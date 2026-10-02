import unittest

from ImportModules import importModules

importModules(["OmMentor", "OmStudent", "OmOptMentor", "OmOptStudent", "OmBatchMentor", "OmBatchStudent", "OmNMentor",
               "OmNStudent", "OmFMentor", "OmFStudent", "OmCanvas", "OmCircle", "OmShow", "OmViewer", "OmTicket", "OmBus",
               "OmSeat", "OmTeam", "OmPlayer", "OmKmOwner", "OmKmChild", "OmKbOwner", "OmKbChild", "OmKcOwner",
               "OmKcChild", "OmGMentor", "OmGStudent", "OmWhole", "OmPart", "OmHub", "OmSpoke", "OmAcademy", "OmPupil",
               "OmBatch", "OmItem", "OmMmMentor", "OmMmStudent", "OmLogMentor", "OmLogStudent", "OmLogOwner",
               "OmLogItem"],
              ["onemany"])
from ImportModules import *


# Keyed objects can be equal, so links are compared one by one by identity.
def assertLinks(test, expected, actual):
    test.assertIsInstance(actual, tuple)
    test.assertEqual(len(expected), len(actual))
    for e, a in zip(expected, actual):
        test.assertIs(e, a)


# Python-specific behaviour of associations whose one end is at most one and whose other end is many
# (models in testbed_pythonnext/src/TestHarnessPythonOneMany.ump).
class OneToManyTest(unittest.TestCase):
    def test_equalKeyedObjectsAreDifferentLinks(self):
        m = OmMentor.OmMentor(1)
        s1 = OmStudent.OmStudent(7, m)
        s2 = OmStudent.OmStudent(7, m)
        self.assertEqual(s1, s2)
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(s2, m.getStudent(1))
        self.assertEqual(1, m.indexOfStudent(s2))
        self.assertEqual(-1, m.indexOfStudent(OmStudent.OmStudent(7, OmMentor.OmMentor(2))))

    def test_removingAnEqualObjectOfAnotherOwnerKeepsTheOwnLink(self):
        m1 = OmMentor.OmMentor(1)
        m2 = OmMentor.OmMentor(2)
        mine = OmStudent.OmStudent(7, m1)
        other = OmStudent.OmStudent(7, m2)
        self.assertTrue(m1.removeStudent(other))  # Java's result: the object is not one m1 must keep
        assertLinks(self, (mine,), m1.getStudents())
        self.assertIs(m1, mine.getMentor())
        assertLinks(self, (other,), m2.getStudents())

    def test_movingToAnEqualButDifferentOwner(self):
        m1 = OmOptMentor.OmOptMentor(1)
        m2 = OmOptMentor.OmOptMentor(1)
        s = OmOptStudent.OmOptStudent(5)
        self.assertTrue(s.setMentor(m1))
        self.assertTrue(s.setMentor(m2))
        self.assertIs(m2, s.getMentor())
        assertLinks(self, (), m1.getStudents())
        assertLinks(self, (s,), m2.getStudents())
        self.assertFalse(m1.removeStudent(s))
        self.assertIs(m2, s.getMentor())

    def test_gettersReturnSnapshots(self):
        m = OmOptMentor.OmOptMentor(1)
        s1 = OmOptStudent.OmOptStudent(1)
        m.addStudent(s1)
        before = m.getStudents()
        m.addStudent(OmOptStudent.OmOptStudent(2))
        assertLinks(self, (s1,), before)
        self.assertEqual(2, m.numberOfStudents())

    def test_addingTheSameObjectTwiceIsRefused(self):
        m = OmOptMentor.OmOptMentor(1)
        s = OmOptStudent.OmOptStudent(1)
        self.assertTrue(m.addStudent(s))
        self.assertFalse(m.addStudent(s))
        assertLinks(self, (s,), m.getStudents())

    def test_batchSetterRejectsTheSameObjectTwiceButAcceptsEqualObjects(self):
        a = OmBatchStudent.OmBatchStudent(1)
        b = OmBatchStudent.OmBatchStudent(2)
        m = OmBatchMentor.OmBatchMentor(a, b)
        twin = OmBatchStudent.OmBatchStudent(1)
        self.assertFalse(m.setStudents(a, a))
        assertLinks(self, (a, b), m.getStudents())
        self.assertTrue(m.setStudents(twin, a))
        assertLinks(self, (twin, a), m.getStudents())
        self.assertIs(m, twin.getMentor())
        self.assertIsNone(b.getMentor())
        with self.assertRaises(RuntimeError):
            OmBatchMentor.OmBatchMentor(a, a)

    def test_batchSetterChecksEveryOldOwnerBeforeChangingAnything(self):
        s = [OmBatchStudent.OmBatchStudent(i) for i in range(6)]
        m1 = OmBatchMentor.OmBatchMentor(s[0], s[1], s[2])
        m2 = OmBatchMentor.OmBatchMentor(s[3], s[4])
        # m1 would keep one student, below its lower bound of two
        self.assertFalse(m2.setStudents(s[3], s[0], s[1]))
        assertLinks(self, (s[0], s[1], s[2]), m1.getStudents())
        assertLinks(self, (s[3], s[4]), m2.getStudents())
        self.assertIs(m1, s[0].getMentor())
        self.assertIs(m2, s[4].getMentor())
        # one student may leave m1, and s[4] is left out of m2
        self.assertTrue(m2.setStudents(s[3], s[0], s[5]))
        assertLinks(self, (s[1], s[2]), m1.getStudents())
        assertLinks(self, (s[3], s[0], s[5]), m2.getStudents())
        self.assertIs(m2, s[0].getMentor())
        self.assertIsNone(s[4].getMentor())

    def test_movingBetweenBoundedOwnersKeepsTheOldOwnerAboveItsLowerBound(self):
        s = [OmBatchStudent.OmBatchStudent(i) for i in range(5)]
        m1 = OmBatchMentor.OmBatchMentor(s[0], s[1])
        m2 = OmBatchMentor.OmBatchMentor(s[2], s[3], s[4])
        self.assertFalse(m2.addStudent(s[0]))
        self.assertIs(m1, s[0].getMentor())
        self.assertTrue(m1.addStudent(s[2]))
        assertLinks(self, (s[3], s[4]), m2.getStudents())
        assertLinks(self, (s[0], s[1], s[2]), m1.getStudents())
        self.assertIs(m1, s[2].getMentor())
        self.assertFalse(m2.removeStudent(s[3]))
        self.assertTrue(m1.removeStudent(s[2]))
        self.assertIsNone(s[2].getMentor())

    def test_exactBatchSetter(self):
        a, b, c, d = (OmNStudent.OmNStudent() for _ in range(4))
        m = OmNMentor.OmNMentor(a, b)
        other = OmNMentor.OmNMentor(c, d)
        self.assertFalse(m.setStudents(a))
        self.assertFalse(m.setStudents(a, a))
        self.assertFalse(m.setStudents(a, c))
        assertLinks(self, (a, b), m.getStudents())
        e = OmNStudent.OmNStudent()
        self.assertTrue(m.setStudents(e, a))
        assertLinks(self, (e, a), m.getStudents())
        self.assertIs(m, e.getMentor())
        self.assertIsNone(b.getMentor())
        assertLinks(self, (c, d), other.getStudents())

    def test_factoryReturnsNoneWhenTheEndIsFull(self):
        m = OmFMentor.OmFMentor()
        a = m.addStudent("a")
        self.assertEqual("a", a.getName())
        self.assertIs(m, a.getMentor())
        m.addStudent("b")
        self.assertIsNone(m.addStudent("c"))
        self.assertEqual(2, m.numberOfStudents())
        self.assertFalse(m.addStudent(OmFStudent.OmFStudent("d", OmFMentor.OmFMentor())))

    def test_abstractClassHasNoFactory(self):
        board = OmCanvas.OmCanvas()
        circle = OmCircle.OmCircle(board)
        self.assertFalse(hasattr(OmCanvas.OmCanvas, "addShape1"))
        assertLinks(self, (circle,), board.getShapes())
        other = OmCanvas.OmCanvas()
        self.assertTrue(other.addShape(circle))
        self.assertIs(other, circle.getBoard())
        assertLinks(self, (), board.getShapes())

    def test_associationClassRefusesASecondInstanceForTheSamePair(self):
        show1 = OmShow.OmShow(1)
        show2 = OmShow.OmShow(2)
        tom = OmViewer.OmViewer("Tom")
        jan = OmViewer.OmViewer("Jan")
        t1 = OmTicket.OmTicket(show1, tom)
        t2 = show1.addOmTicket(jan)
        t3 = OmTicket.OmTicket(show2, tom)
        assertLinks(self, (t1, t2), show1.getOmTickets())
        assertLinks(self, (t1, t3), tom.getOmTickets())
        with self.assertRaisesRegex(RuntimeError, "Unable to create omTicket due to omViewer"):
            OmTicket.OmTicket(show1, jan)
        t4 = OmTicket.OmTicket(show2, jan)
        # moving t3 to show1 would link Tom to show1 twice: refused, and t3 keeps its place in show2
        self.assertFalse(t3.setOmShow(show1))
        self.assertIs(show2, t3.getOmShow())
        assertLinks(self, (t3, t4), show2.getOmTickets())

    def test_keyMembersCannotChangeOnceHashed(self):
        bus1 = OmBus.OmBus()
        bus2 = OmBus.OmBus()
        seat = OmSeat.OmSeat(1, bus1)
        self.assertTrue(seat.setBus(bus2))
        hash(seat)
        self.assertFalse(seat.setBus(bus1))
        self.assertFalse(bus1.addSeat(seat))  # Java reports success
        self.assertIs(bus2, seat.getBus())
        assertLinks(self, (), bus1.getSeats())
        assertLinks(self, (seat,), bus2.getSeats())
        team = OmTeam.OmTeam(1)
        p1 = OmPlayer.OmPlayer()
        self.assertTrue(team.addPlayer(p1))
        hash(team)
        self.assertFalse(team.addPlayer(OmPlayer.OmPlayer()))
        self.assertFalse(team.removePlayer(p1))
        assertLinks(self, (p1,), team.getPlayers())
        # the frozen team cannot let p1 go, so another team cannot take it (Java recurses forever)
        self.assertFalse(OmTeam.OmTeam(2).addPlayer(p1))
        self.assertIs(team, p1.getTeam())

    def test_aFrozenOwnerEndRefusesMovesBothWays(self):
        old = OmKmOwner.OmKmOwner(1)
        new = OmKmOwner.OmKmOwner(2)
        c = OmKmChild.OmKmChild(old)
        hash(new)
        self.assertFalse(c.setOwner(new))
        self.assertFalse(new.addChild(c))
        hash(old)
        self.assertFalse(c.setOwner(OmKmOwner.OmKmOwner(3)))
        self.assertFalse(OmKmOwner.OmKmOwner(4).addChild(c))
        self.assertIs(old, c.getOwner())
        assertLinks(self, (c,), old.getChildren())
        assertLinks(self, (), new.getChildren())

    def test_endsWrittenDirectlyRespectFrozenKeys(self):
        a, b, c, d = (OmKbChild.OmKbChild(i) for i in range(4))
        owner = OmKbOwner.OmKbOwner(a, b, c)
        hash(d)
        self.assertFalse(owner.addChild(d))  # d's owner is part of its hashed key
        self.assertFalse(owner.setChildren(a, b, d))
        self.assertIsNone(d.getOwner())
        hash(c)
        self.assertFalse(owner.removeChild(c))
        self.assertFalse(owner.setChildren(a, b))  # c would lose its owner
        assertLinks(self, (a, b, c), owner.getChildren())
        self.assertIs(owner, c.getOwner())
        e, f, g, h, k = (OmKcChild.OmKcChild() for _ in range(5))
        frozen = OmKcOwner.OmKcOwner(1, e, f, g)
        taker = OmKcOwner.OmKcOwner(2, h, k)
        hash(frozen)
        self.assertFalse(taker.addChild(g))  # the frozen old owner cannot lose g
        self.assertFalse(taker.setChildren(h, k, g))
        assertLinks(self, (e, f, g), frozen.getChildren())
        self.assertIs(frozen, g.getOwner())

    def test_aFrozenKeyEndStaysLinked(self):
        m = OmGMentor.OmGMentor()
        s = OmGStudent.OmGStudent(1)
        s.setMentor(m)
        hash(s)
        self.assertFalse(m.removeStudent(s))
        self.assertFalse(OmGMentor.OmGMentor().addStudent(s))  # Java recurses forever
        m.delete()  # Java loops forever
        self.assertIs(m, s.getMentor())
        assertLinks(self, (s,), m.getStudents())

    def test_compositionDeleteToleratesPartsThatRemovedThemselves(self):
        whole = OmWhole.OmWhole()
        parts = [OmPart.OmPart(whole) for _ in range(3)]
        whole.delete()
        assertLinks(self, (), whole.getParts())
        for part in parts:
            self.assertIsNone(part.getOwner())
        rim = OmSpoke.OmSpoke()
        hubs = [OmHub.OmHub() for _ in range(2)]
        for hub in hubs:
            hub.setRim(rim)
        rim.delete()
        assertLinks(self, (), rim.getHubs())
        for hub in hubs:
            self.assertIsNone(hub.getRim())

    def test_sortedEndStaysInPriorityOrderAfterEveryAdd(self):
        academy = OmAcademy.OmAcademy()
        s5 = academy.addStudent(5, "e")
        s1 = OmPupil.OmPupil(1, "a", academy)
        s3 = academy.addStudent(3, "c")
        s3b = academy.addStudent(3, "c2")
        assertLinks(self, (s1, s3, s3b, s5), academy.getStudents())
        other = OmAcademy.OmAcademy()
        s2 = other.addStudent(2, "b")
        self.assertTrue(academy.addStudent(s2))
        assertLinks(self, (s1, s2, s3, s3b, s5), academy.getStudents())

    def test_batchSetKeepsASortedEndSorted(self):
        a, b, c = OmItem.OmItem(9), OmItem.OmItem(1), OmItem.OmItem(5)
        batch = OmBatch.OmBatch(a, b)
        assertLinks(self, (b, a), batch.getItems())
        self.assertTrue(batch.setItems(a, c, b))
        assertLinks(self, (b, c, a), batch.getItems())

    def test_leavingAnOwnerAtItsLowerBoundIsRefused(self):
        s = [OmMmStudent.OmMmStudent() for _ in range(5)]
        m1 = OmMmMentor.OmMmMentor(s[0], s[1])
        m2 = OmMmMentor.OmMmMentor(s[2], s[3], s[4])
        self.assertFalse(s[0].setMentor(m2))
        self.assertFalse(s[0].setMentor(None))
        self.assertIs(m1, s[0].getMentor())
        self.assertTrue(s[2].setMentor(m1))
        assertLinks(self, (s[0], s[1], s[2]), m1.getStudents())
        assertLinks(self, (s[3], s[4]), m2.getStudents())
        self.assertTrue(s[2].setMentor(None))
        self.assertIsNone(s[2].getMentor())
        self.assertTrue(s[2].setMentor(m2))
        assertLinks(self, (s[3], s[4], s[2]), m2.getStudents())

    def test_injectionsRunAroundChangesThatHappen(self):
        m = OmLogMentor.OmLogMentor()
        s = OmLogStudent.OmLogStudent()
        self.assertTrue(m.addStudent(s))
        self.assertEqual("before add", m.getEvents()[0])
        self.assertEqual("after add", m.getEvents()[-1])
        self.assertEqual(["before set", "after set"], s.getEvents())
        count = m.numberOfEvents()
        self.assertFalse(m.addStudent(s))  # as in Java, the before injection runs, then the duplicate check refuses
        self.assertEqual(count + 1, m.numberOfEvents())
        self.assertEqual("before add", m.getEvents()[-1])
        a, b = OmLogItem.OmLogItem(), OmLogItem.OmLogItem()
        owner = OmLogOwner.OmLogOwner(a, b)
        self.assertEqual(["before set items", "after set items"], owner.getEvents())
        self.assertFalse(owner.setItems(a, a))  # the body refuses after the before injection, as in Java
        self.assertEqual(["before set items", "after set items", "before set items"], owner.getEvents())
        self.assertTrue(owner.setItems(b, a))
        self.assertEqual("after set items", owner.getEvents()[-1])

    def test_constructorReportsTheRefusedEnd(self):
        with self.assertRaisesRegex(RuntimeError, "^Unable to create student due to mentor\\. See https://manual\\.umple\\.org"):
            OmStudent.OmStudent(1, None)


if __name__ == "__main__":
    unittest.main()
