import re
import unittest

from ImportModules import importModules

importModules(["OoTag", "OoFrozenTag", "OoBag", "OoBox", "OoShelf", "OoPile", "OoRack", "OoPin", "OoBadge",
               "OoBadgeSet", "OoHolder", "OoDesk", "OoChair", "OoLock", "OoCard", "OoTwin", "OoBase", "OoCar",
               "OoEngine", "OoSeat", "OoBelt", "OoVehicle", "OoPlate", "OoTruck", "OoBus", "OoDriver", "OoRanked",
               "OoLadder", "OoPodium", "OoWatched", "OoWatcher", "OoCounted", "OoHelm", "OoWheel", "OoRudder",
               "OoDock", "OoBoat", "aOoGauge", "OoDial", "OoGaugeChild", "OoTeam", "OoPlayer"], ["oneone"])
from ImportModules import *


def publicMutators(obj):
    return [name for name in dir(type(obj)) if re.fullmatch("(set|add|remove)[A-Z].*", name)]


class DirectedEndsTest(unittest.TestCase):
    """Directed ends link objects by identity: an object with an equal key is another object."""

    def setUp(self):
        self.a = OoTag.OoTag("a")
        self.equalToA = OoTag.OoTag("a")
        self.b = OoTag.OoTag("b")
        self.c = OoTag.OoTag("c")
        self.assertEqual(self.a, self.equalToA)

    def _assertLinked(self, expected, actual):
        self.assertEqual(len(expected), len(actual))
        for e, a in zip(expected, actual):
            self.assertIs(e, a)

    def test_addAndRemoveFindObjectsByIdentity(self):
        bag = OoBag.OoBag()
        self.assertIs(True, bag.addTag(self.a))
        self.assertIs(True, bag.addTag(self.equalToA))
        self.assertIs(False, bag.addTag(self.a))
        self.assertIs(True, bag.removeTag(self.equalToA))
        self.assertIs(False, bag.removeTag(self.equalToA))
        self._assertLinked((self.a,), bag.getTags())

    def test_batchSetterRefusesTheSameObjectTwiceAndKeepsTheOrder(self):
        box = OoBox.OoBox()
        self.assertIs(True, box.setTags(self.b, self.a))
        self._assertLinked((self.b, self.a), box.getTags())
        self.assertIs(False, box.setTags(self.c, self.c))
        self._assertLinked((self.b, self.a), box.getTags())
        self.assertIs(True, box.setTags(self.equalToA, self.a))
        self._assertLinked((self.equalToA, self.a), box.getTags())
        self.assertIs(True, box.setTags())
        self.assertEqual(0, box.numberOfTags())

    def test_optionalNStopsAtItsMaximum(self):
        box = OoBox.OoBox()
        self.assertIs(True, box.addTag(self.a))
        self.assertIs(True, box.addTag(self.equalToA))
        self.assertIs(False, box.addTag(self.b))
        self.assertIs(False, box.setTags(self.a, self.b, self.c))
        self._assertLinked((self.a, self.equalToA), box.getTags())
        self.assertIs(True, box.removeTag(self.a))
        self.assertIs(True, box.setTags(self.c, self.b))
        self._assertLinked((self.c, self.b), box.getTags())

    def test_mnKeepsBothBounds(self):
        with self.assertRaises(RuntimeError):
            OoShelf.OoShelf()
        with self.assertRaises(RuntimeError):
            OoShelf.OoShelf(self.a, self.a)
        with self.assertRaises(RuntimeError):
            OoShelf.OoShelf(self.a, self.b, self.c)
        shelf = OoShelf.OoShelf(self.a)
        self.assertIs(False, shelf.removeTag(self.a))
        self.assertIs(True, shelf.addTag(self.equalToA))
        self.assertIs(False, shelf.addTag(self.b))
        self.assertIs(False, shelf.setTags())
        self._assertLinked((self.a, self.equalToA), shelf.getTags())
        self.assertIs(True, shelf.removeTag(self.a))
        self._assertLinked((self.equalToA,), shelf.getTags())

    def test_mStarKeepsItsMinimum(self):
        pile = OoPile.OoPile(self.a)
        self.assertIs(False, pile.removeTag(self.a))
        self.assertIs(False, pile.setTags())
        self.assertIs(True, pile.addTag(self.b))
        self.assertIs(True, pile.removeTag(self.a))
        self._assertLinked((self.b,), pile.getTags())

    def test_nNeedsExactlyNDifferentObjects(self):
        with self.assertRaises(RuntimeError):
            OoRack.OoRack(self.a)
        with self.assertRaises(RuntimeError):
            OoRack.OoRack(self.a, self.a)
        rack = OoRack.OoRack(self.a, self.equalToA)
        self.assertFalse(hasattr(rack, "addTag"))
        self.assertIs(False, rack.setTags(self.c))
        self.assertIs(True, rack.setTags(self.c, self.b))
        self._assertLinked((self.c, self.b), rack.getTags())

    def test_oneRefusesNoneAndOptionalOneAcceptsIt(self):
        with self.assertRaises(RuntimeError):
            OoPin.OoPin(None)
        pin = OoPin.OoPin(self.a)
        self.assertIs(False, pin.setTag(None))
        self.assertIs(self.a, pin.getTag())
        self.assertIs(True, pin.setSpare(self.b))
        self.assertIs(True, pin.setSpare(None))
        self.assertIsNone(pin.getSpare())
        pin.delete()
        self.assertIsNone(pin.getTag())

    def test_keyEndCannotChangeOnceHashed(self):
        badge = OoBadge.OoBadge(self.a)
        self.assertIs(True, badge.setTag(self.b))
        {badge}
        self.assertIs(False, badge.setTag(self.a))
        self.assertIs(self.b, badge.getTag())

    def test_keyManyEndCannotChangeOnceHashed(self):
        badges = OoBadgeSet.OoBadgeSet()
        self.assertIs(True, badges.addTag(self.a))
        {badges}
        self.assertIs(False, badges.addTag(self.b))
        self.assertIs(False, badges.removeTag(self.a))
        self.assertIs(False, badges.setTags(self.b))
        self._assertLinked((self.a,), badges.getTags())


    def test_sortedEndsKeepThePriorityOrder(self):
        three, one, two = OoRanked.OoRanked(3), OoRanked.OoRanked(1), OoRanked.OoRanked(2)
        ladder = OoLadder.OoLadder()
        for rung in (three, one, two):
            self.assertIs(True, ladder.addRung(rung))
        self.assertIs(False, ladder.addRung(one))
        self._assertLinked((one, two, three), ladder.getRungs())
        podium = OoPodium.OoPodium()
        self.assertIs(True, podium.setPlaces(three, two))
        self._assertLinked((two, three), podium.getPlaces())
        self.assertIs(True, podium.addPlace(one))
        self.assertIs(False, podium.addPlace(OoRanked.OoRanked(0)))
        self._assertLinked((one, two, three), podium.getPlaces())


class ImmutableEndsTest(unittest.TestCase):
    def setUp(self):
        self.one = OoFrozenTag.OoFrozenTag("one")
        self.two = OoFrozenTag.OoFrozenTag("two")
        self.three = OoFrozenTag.OoFrozenTag("three")

    def test_immutableEndsAreSetOnlyByTheConstructor(self):
        holder = OoHolder.OoHolder(self.one, self.two, self.three)
        self.assertEqual([], publicMutators(holder))
        self.assertIs(False, holder._setTags(self.one))
        self.assertIs(False, holder._setSingle(None))
        self.assertIs(self.one, holder.getSingle())
        self.assertEqual(2, holder.numberOfTags())
        holder.delete()
        self.assertIs(self.one, holder.getSingle())
        self.assertEqual(2, holder.numberOfTags())

    def test_constructorChecksImmutableEnds(self):
        self.assertIsNone(OoHolder.OoHolder(None).getSingle())
        with self.assertRaises(RuntimeError):
            OoHolder.OoHolder(None, self.one, self.one)
        with self.assertRaises(RuntimeError):
            OoHolder.OoHolder(None, self.one, self.two, self.three)


class AtMostOneBothWaysTest(unittest.TestCase):
    """Bidirectional ends that are at most one: the partner is found by identity."""

    def test_optionalToOptionalMovesToAnEqualObject(self):
        desk = OoDesk.OoDesk("d")
        equalDesk = OoDesk.OoDesk("d")
        chair = OoChair.OoChair("c")
        self.assertIs(True, desk.setChair(chair))
        self.assertIs(True, equalDesk.setChair(chair))
        self.assertIs(equalDesk, chair.getDesk())
        self.assertIs(chair, equalDesk.getChair())
        self.assertIsNone(desk.getChair())

    def test_oneEndRefusesAPartnerOwnedByAnEqualObject(self):
        card = OoCard.OoCard("c1")
        otherCard = OoCard.OoCard("c2")
        lock = OoLock.OoLock("l", card)
        equalLock = OoLock.OoLock("l", otherCard)
        self.assertIs(False, lock.setCard(otherCard))
        self.assertIs(False, card.setLock(equalLock))
        self.assertIs(card, lock.getCard())
        self.assertIs(lock, card.getLock())
        self.assertIs(otherCard, equalLock.getCard())
        self.assertIs(equalLock, otherCard.getLock())

    def test_symmetricReflexiveEndUsesIdentity(self):
        twin = OoTwin.OoTwin("a")
        equalTwin = OoTwin.OoTwin("a")
        other = OoTwin.OoTwin("b")
        self.assertIs(True, twin.setTwin(other))
        self.assertIs(True, equalTwin.setTwin(other))
        self.assertIs(other, equalTwin.getTwin())
        self.assertIs(equalTwin, other.getTwin())
        self.assertIsNone(twin.getTwin())
        equalTwin.delete()
        self.assertIsNone(other.getTwin())
        self.assertIsNone(equalTwin.getTwin())


class MandatoryOneToOneTest(unittest.TestCase):
    def test_constructorCreatesThePartner(self):
        car = OoCar.OoCar(aX=7, aPowerForEngine=120)
        self.assertEqual(7, car.getX())
        self.assertEqual(120, car.getEngine().getPower())
        self.assertIs(car, car.getEngine().getCar())

    def test_partnerBuiltByAlternateConstructorHasItsParentPart(self):
        engine = OoEngine.OoEngine(90, 3)
        car = engine.getCar()
        self.assertIsInstance(car, OoBase.OoBase)
        self.assertEqual(3, car.getX())
        self.assertIs(engine, car.getEngine())

    def test_alternateConstructorNeedsAFreePartner(self):
        car = OoCar.OoCar(1, 2)
        with self.assertRaises(RuntimeError):
            OoEngine.OoEngine.alternateConstructor(5, car)
        with self.assertRaises(RuntimeError):
            OoCar.OoCar.alternateConstructor(1, None)

    def test_partnerCollectionIsAListBeforeTheOwnCollection(self):
        a = OoTag.OoTag("a")
        b = OoTag.OoTag("b")
        seat = OoSeat.OoSeat([a], b)
        self.assertEqual((b,), seat.getTags())
        self.assertEqual((a,), seat.getBelt().getTags())
        belt = OoBelt.OoBelt([b, a], a)
        self.assertEqual((a,), belt.getTags())
        self.assertEqual((b, a), belt.getSeat().getTags())

    def test_deleteDeletesThePartner(self):
        car = OoCar.OoCar(1, 2)
        engine = car.getEngine()
        engine.delete()
        self.assertIsNone(engine.getCar())
        self.assertIsNone(car.getEngine())


class OneToOneSubclassTest(unittest.TestCase):
    """A subclass of a class in a mandatory one-to-one pair takes an existing partner for its parent part."""

    def _freePlate(self):
        vehicle = OoVehicle.OoVehicle(4, "p")
        plate = vehicle.getPlate()
        vehicle.delete()
        self.assertIsNone(plate.getVehicle())
        return plate

    def test_subclassAttachesTheGivenPartner(self):
        plate = self._freePlate()
        truck = OoTruck.OoTruck(6, plate)
        self.assertEqual(6, truck.getWheels())
        self.assertIs(plate, truck.getPlate())
        with self.assertRaises(RuntimeError):
            OoTruck.OoTruck(6, None)

    def test_subclassInItsOwnPairIsBuiltByItsPartner(self):
        plate = self._freePlate()
        driver = OoDriver.OoDriver("d", 8, plate)
        bus = driver.getBus()
        self.assertIsInstance(bus, OoBus.OoBus)
        self.assertEqual(8, bus.getWheels())
        self.assertIs(plate, bus.getPlate())
        self.assertIs(driver, bus.getDriver())
        other = OoBus.OoBus(10, self._freePlate(), "e")
        self.assertEqual("e", other.getDriver().getName())
        self.assertIs(other, other.getDriver().getBus())


class InjectionsTest(unittest.TestCase):
    """Before injections run where Java puts them: an add's first, so an add that is then refused
    runs it too; after injections run after a change."""

    def test_addAndRemove(self):
        watched = OoWatched.OoWatched()
        a, b, c = OoTag.OoTag("a"), OoTag.OoTag("b"), OoTag.OoTag("c")
        self.assertIs(True, watched.addTag(a))
        self.assertIs(False, watched.addTag(a))
        self.assertIs(True, watched.addTag(b))
        self.assertIs(False, watched.addTag(c))
        self.assertIs(True, watched.removeTag(a))
        self.assertIs(False, watched.removeTag(a))
        self.assertEqual(["before add a", "after add", "before add a", "before add b", "after add", "before add c",
                          "before remove", "after remove", "before remove"], watched.getCalls())

    def test_setters(self):
        watched = OoWatched.OoWatched()
        a = OoTag.OoTag("a")
        self.assertIs(False, watched.setTags(a, a))
        self.assertIs(True, watched.setTags(a))
        self.assertIs(True, watched.setTag(a))
        self.assertIs(True, watched.setWatcher(OoWatcher.OoWatcher()))
        self.assertIs(True, watched.setWatcher(None))
        self.assertEqual(["before set 2", "before set 1", "after set", "before tag", "after tag",
                          "before watcher", "after watcher", "before watcher", "after watcher"], watched.getCalls())


    def test_untaggedInjectionGoesThroughTheBatch(self):
        counted = OoCounted.OoCounted()
        self.assertIs(True, counted.setTags(OoTag.OoTag("a"), OoTag.OoTag("b")))
        self.assertEqual(2, counted.getCount())


class HelperNameTest(unittest.TestCase):
    """A user method named like the helper does not replace it."""

    def test_userMethodDoesNotReplaceTheHelper(self):
        wheel = OoWheel.OoWheel(3)
        helm = wheel.getHelm()
        self.assertIs(wheel, helm.getWheel())
        self.assertFalse(hasattr(helm, "hijacked"))

    def test_subclassMethodDoesNotReplaceTheParentHelper(self):
        wheel = OoWheel.OoWheel(3)
        wheel.getHelm().delete()
        self.assertIsNone(wheel.getHelm())
        rudder = OoRudder.OoRudder(wheel)
        self.assertIs(wheel, rudder.getWheel())
        self.assertFalse(hasattr(rudder, "hijacked"))


class PartnerReferenceTest(unittest.TestCase):
    """The constructors name the partner's class through its module, and through the class itself."""

    def test_nestedPartnerFromBothEnds(self):
        boat = OoBoat.OoBoat("b", 3)
        berth = boat.getBerth()
        self.assertIsInstance(berth, OoDock.OoDock.OoBerth)
        self.assertEqual(3, berth.getSize())
        self.assertIs(boat, berth.getBoat())
        berth = OoDock.OoDock.OoBerth(4, "c")
        self.assertEqual("c", berth.getBoat().getName())
        self.assertIs(berth, berth.getBoat().getBerth())

    def test_parameterNamedLikeTheClass(self):
        dial = OoDial.OoDial(5, 7)
        self.assertEqual(7, dial.getGauge().getOoGauge())
        dial.delete()
        self.assertIsNone(dial.getGauge())
        child = OoGaugeChild.OoGaugeChild(8, dial)
        self.assertEqual(8, child.getOoGauge())
        self.assertIs(dial, child.getDial())


class MandatoryManyToOptionalOneTest(unittest.TestCase):
    def test_deleteReleasesThePlayers(self):
        first = OoPlayer.OoPlayer()
        second = OoPlayer.OoPlayer()
        team = OoTeam.OoTeam(first, second)
        team.delete()
        self.assertEqual(0, team.numberOfPlayers())
        self.assertIsNone(first.getTeam())
        self.assertIsNone(second.getTeam())
