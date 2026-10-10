import unittest
from unittest import mock

from ImportModules import importModules

importModules(["MmMentor", "MmStudent", "MmCourse", "MmPupil", "MmClub", "MmMember", "MmPanel", "MmJudge",
               "MmLock", "MmKey", "MmAuthor", "MmBook", "MmPeer", "MmRing"], ["manymany"])
from ImportModules import *


def refuse(*args):
    raise AssertionError("association code must not compare or hash linked objects")


class ManyToManyPythonTest(unittest.TestCase):
    """Behaviour of associations whose two ends are many that the ported Java tests do not cover."""

    def test_equalButDifferentObjectsAreLinkedSeparately(self):
        m = MmMentor.MmMentor("m")
        s = MmStudent.MmStudent(1)
        twin = MmStudent.MmStudent(1)
        self.assertEqual(s, twin)
        self.assertIs(True, m.addStudent(s))
        self.assertEqual(-1, m.indexOfStudent(twin))
        self.assertIs(True, m.addStudent(twin))
        self.assertEqual((s, twin), m.getStudents())
        self.assertIs(m, twin.getMentor(0))
        self.assertIs(False, m.addStudent(twin))

    def test_equalButDifferentObjectIsNotUnlinked(self):
        m = MmMentor.MmMentor("m")
        twinMentor = MmMentor.MmMentor("m")
        s = MmStudent.MmStudent(1)
        twin = MmStudent.MmStudent(1)
        m.addStudent(s)
        self.assertIs(False, m.removeStudent(twin))
        self.assertIs(False, twin.removeMentor(m))
        self.assertIs(False, s.removeMentor(twinMentor))
        self.assertEqual((s,), m.getStudents())
        self.assertEqual((m,), s.getMentors())
        self.assertIs(True, s.removeMentor(m))
        self.assertEqual((), m.getStudents())

    def test_batchSetterTellsObjectsApartByIdentity(self):
        m = MmMentor.MmMentor("m")
        s = MmStudent.MmStudent(1)
        twin = MmStudent.MmStudent(1)
        self.assertIs(True, m.setStudents(s, twin))
        self.assertEqual((s, twin), m.getStudents())
        self.assertIs(False, m.setStudents(s, twin, s))
        self.assertEqual((s, twin), m.getStudents())

    def test_linkingNeverComparesOrHashesLinkedObjects(self):
        m = MmMentor.MmMentor("m")
        m2 = MmMentor.MmMentor("m2")
        s1 = MmStudent.MmStudent(1)
        s2 = MmStudent.MmStudent(2)
        s3 = MmStudent.MmStudent(3)
        with mock.patch.object(MmStudent.MmStudent, "__eq__", refuse), \
                mock.patch.object(MmStudent.MmStudent, "__hash__", refuse), \
                mock.patch.object(MmMentor.MmMentor, "__eq__", refuse), \
                mock.patch.object(MmMentor.MmMentor, "__hash__", refuse):
            self.assertIs(True, m.setStudents(s1, s2))
            self.assertIs(True, m.setStudents(s2, s3))
            self.assertIs(False, m.setStudents(s1, s1))
            self.assertIs(True, s1.addMentor(m2))
            self.assertIs(True, m.removeStudent(s2))
            m2.delete()
            s3.delete()
        self.assertEqual((), m.getStudents())
        self.assertEqual((), s1.getMentors())
        # the keys are still settable, so no hash was taken
        self.assertIs(True, s1.setId(9))
        self.assertIs(True, m.setName("n"))

    def test_batchSetterKeepsGivenOrderAndLinksOnlyChanges(self):
        m = MmMentor.MmMentor("m")
        s1 = MmStudent.MmStudent(1)
        s2 = MmStudent.MmStudent(2)
        s3 = MmStudent.MmStudent(3)
        m.setStudents(s1, s2)
        self.assertIs(True, m.setStudents(s3, s2))
        self.assertEqual((s3, s2), m.getStudents())
        self.assertEqual((), s1.getMentors())
        self.assertEqual((m,), s2.getMentors())
        self.assertEqual((m,), s3.getMentors())
        self.assertIs(True, m.setStudents())
        self.assertEqual((), m.getStudents())
        self.assertEqual((), s2.getMentors())

    def test_batchSettersRejectDuplicatesAndBoundsWithoutChange(self):
        p = MmPanel.MmPanel("p")
        judges = [MmJudge.MmJudge(str(i)) for i in range(4)]
        self.assertIs(True, p.setJudges(judges[0], judges[1]))
        self.assertIs(False, p.setJudges(judges[2], judges[2]))
        self.assertIs(False, p.setJudges())
        self.assertEqual((judges[0], judges[1]), p.getJudges())
        self.assertEqual((), judges[2].getPanels())
        j = judges[3]
        panels = [MmPanel.MmPanel(str(i)) for i in range(4)]
        self.assertIs(True, j.setPanels(panels[0], panels[1], panels[2]))
        self.assertIs(False, j.setPanels(panels[0], panels[1], panels[0]))
        self.assertIs(False, j.setPanels(panels[0]))
        self.assertIs(False, j.setPanels(*panels))
        self.assertEqual((panels[0], panels[1], panels[2]), j.getPanels())
        self.assertEqual((), panels[3].getJudges())
        m = MmMentor.MmMentor("m")
        students = [MmStudent.MmStudent(i) for i in range(4)]
        self.assertIs(False, m.setStudents(*students))
        self.assertEqual((), students[0].getMentors())

    def test_addIsUndoneWhenTheOtherEndIsFull(self):
        c1 = MmCourse.MmCourse("c1")
        c2 = MmCourse.MmCourse("c2")
        c3 = MmCourse.MmCourse("c3")
        p = MmPupil.MmPupil("p")
        other = MmPupil.MmPupil("other")
        c3.addPupil(other)
        p.addCourse(c1)
        p.addCourse(c2)
        self.assertIs(False, c3.addPupil(p))
        self.assertEqual((other,), c3.getPupils())
        self.assertEqual((c1, c2), p.getCourses())
        self.assertIs(False, p.addCourse(c3))

    def test_removeIsUndoneAtTheOldPositionWhenTheOtherEndIsAtItsMinimum(self):
        club = MmClub.MmClub("club")
        other = MmClub.MmClub("other")
        a = MmMember.MmMember("a")
        m = MmMember.MmMember("m")
        b = MmMember.MmMember("b")
        for member in (a, m, b):
            club.addMember(member)
        other.addMember(m)
        self.assertIs(False, club.removeMember(m))
        self.assertEqual((a, m, b), club.getMembers())
        self.assertEqual((club, other), m.getClubs())
        self.assertIs(False, m.removeClub(club))
        third = MmClub.MmClub("third")
        m.addClub(third)
        self.assertIs(True, club.removeMember(m))
        self.assertEqual((a, b), club.getMembers())
        self.assertEqual((other, third), m.getClubs())

    def test_deleteRemovesMembersThatKeepEnoughClubsAndDeletesTheOthers(self):
        club = MmClub.MmClub("club")
        other = MmClub.MmClub("other")
        third = MmClub.MmClub("third")
        m = MmMember.MmMember("m")
        atMinimum = MmMember.MmMember("atMinimum")
        m.setClubs(club, other, third)
        atMinimum.setClubs(club, other)
        club.delete()
        self.assertEqual((), club.getMembers())
        self.assertEqual((other, third), m.getClubs())
        self.assertEqual((), atMinimum.getClubs())
        self.assertEqual((m,), other.getMembers())

    def test_keyMemberEndRefusesChangesOnceHashed(self):
        lock = MmLock.MmLock("l")
        k1 = MmKey.MmKey("k1")
        k2 = MmKey.MmKey("k2")
        lock.addKey(k1)
        hash(lock)
        self.assertIs(False, lock.addKey(k2))
        self.assertIs(False, k2.addLock(lock))
        self.assertEqual((), k2.getLocks())
        self.assertIs(False, lock.removeKey(k1))
        self.assertIs(False, k1.removeLock(lock))
        self.assertEqual((lock,), k1.getLocks())
        self.assertIs(False, lock.setKeys(k2))
        self.assertEqual((k1,), lock.getKeys())

    def test_sortedEndsStaySortedWhicheverSideAdds(self):
        a = MmAuthor.MmAuthor("Bea")
        a2 = MmAuthor.MmAuthor("Al")
        b = MmBook.MmBook("Zed")
        b2 = MmBook.MmBook("Alpha")
        a.addBook(b)
        b2.addAuthor(a)
        b.addAuthor(a2)
        self.assertEqual((b2, b), a.getBooks())
        self.assertEqual((a2, a), b.getAuthors())

    def test_reflexiveEndLinksBothWays(self):
        p = MmPeer.MmPeer("p")
        q = MmPeer.MmPeer("q")
        self.assertIs(True, p.addPeer(q))
        self.assertEqual((q,), p.getPeers())
        self.assertEqual((p,), q.getPeers())
        self.assertIs(True, q.removePeer(p))
        self.assertEqual((), p.getPeers())
        p.addPeer(q)
        p.delete()
        self.assertEqual((), q.getPeers())

    def test_reflexiveDeleteCascadesBelowTheMinimum(self):
        r1, r2, r3, r4, r5 = [MmRing.MmRing("r" + str(i)) for i in range(1, 6)]
        self.assertIs(True, r1.setNeighbours(r2, r3))
        self.assertIs(True, r4.setNeighbours(r2, r3))
        self.assertIs(True, r5.setNeighbours(r2, r3))
        r1.delete()
        self.assertEqual((), r1.getNeighbours())
        self.assertEqual((r4, r5), r2.getNeighbours())
        self.assertEqual((r4, r5), r3.getNeighbours())
        r2.delete()
        for r in (r2, r3, r4, r5):
            self.assertEqual((), r.getNeighbours())

    def test_snapshotAllowsRemovingWhileIterating(self):
        m = MmMentor.MmMentor("m")
        students = [MmStudent.MmStudent(i) for i in range(3)]
        m.setStudents(*students)
        before = m.getStudents()
        for s in m.getStudents():
            self.assertIs(True, m.removeStudent(s))
        self.assertEqual((), m.getStudents())
        self.assertEqual(tuple(students), before)


if __name__ == "__main__":
    unittest.main()
