import contextlib
import io
import unittest

from ImportModules import importModules

importModules(["CoreItem", "CoreBook", "CoreCode", "CoreRegistry", "CoreSettings", "CoreLazy", "CorePriced",
               "CoreTagged", "CoreBothI", "CoreEnumNames", "CoreOuter", "CoreNestedUser", "FpOwner", "FpItem", "FpDetail",
               "KfFlagChild", "KfCacheChild", "KmOwner", "KmTag", "aTitle", "bound", "OvUser",
               "aName", "args", "bound_", "OvPair", "MgBox", "MgItem", "MgNamed", "MgSwitch", "MgView",
               "OvShape", "OvCircle", "OvSpecific", "InjTeam", "InjPlayer", "SortBoard", "SortCard",
               "FacGarage", "FacCar", "MgProduct", "MgDoc", "OvCanvas", "TxBox", "TxLabel",
               "MgTeam", "MgPlayer", "MgGauge", "OvMessage", "OvUrgent", "OvInbox", "NestMarker", "MgAccount", "MgRoster", "InvClamp", "OvChar",
               "AbsShape", "AbsSquare", "SmLabel", "EvVehicle", "EvPassenger", "RdOrder", "RdLine", "InjBadge",
               "SetEvThermostat", "InjRoom", "InjBuilding", "AbsGroupShape", "AbsGroupSquare",
               "InjBox", "InjBoxItem", "InjGuardA", "InjGuardB", "InjGuardC", "InjGuardD", "InjGuardK",
               "InjGuardSub", "InjGuardU", "InjGuardV", "InjGuardW", "InjGuardX", "InjGuardY", "InjGuardZ",
               "InjGuardT", "InjGuardM", "InjGuardN", "InjQuery", "EvChild", "EvTraitUser", "EvStrParam", "math",
               "OvKeyed", "OvImmList"],
              ["core", "test"])
from ImportModules import *


class CoreTest(unittest.TestCase):
    def test_abstractClassCannotBeInstantiated(self):
        with self.assertRaises(TypeError):
            CoreItem.CoreItem("x", None)

    def test_listAttributeKeepsItemsWithCommasAndReturnsCopies(self):
        book = CoreBook.CoreBook("n", None, "i")
        self.assertEqual(["a", "b,c"], book.getTags())
        self.assertEqual("b,c", book.getTag(-1))
        self.assertEqual(-1, book.indexOfTag("zz"))
        self.assertFalse(book.removeTag("zz"))
        self.assertTrue(book.addTag("q"))
        copy = book.getTags()
        copy.append("changed")
        self.assertEqual(3, book.numberOfTags())

    def test_defaultsAndWidening(self):
        book = CoreBook.CoreBook("n", None, "i")
        self.assertEqual(5, book.getStock())
        self.assertTrue(book.setStock(7))
        self.assertTrue(book.resetStock())
        self.assertEqual(5, book.getStock())
        self.assertIsInstance(book.getWeight(), float)

    def test_autouniqueCountsPerClass(self):
        first = CoreBook.CoreBook("n", None, "a")
        second = CoreBook.CoreBook("n", None, "b")
        self.assertEqual(first.getSerial() + 1, second.getSerial())

    def test_keyedObjectsCompareAndHashByKey(self):
        book = CoreBook.CoreBook("n", None, "i")
        same = CoreBook.CoreBook("n", CoreItem.CoreItem.Color.Red, "i")
        other = CoreBook.CoreBook("m", None, "i")
        self.assertEqual(book, same)
        self.assertTrue(book.equals(same))
        self.assertNotEqual(book, other)
        self.assertFalse(book == 5)
        self.assertEqual(1, len({book, same}))

    def test_keyCannotChangeOnceHashed(self):
        book = CoreBook.CoreBook("n", None, "i")
        self.assertTrue(book.setName("m"))
        hash(book)
        self.assertFalse(book.setIsbn("j"))
        self.assertFalse(book.setName("inherited key member"))
        self.assertEqual("m", book.getName())

    def test_uniqueRegistryAcceptsZeroAndRejectsDuplicates(self):
        zero = CoreCode.CoreCode(0)
        self.assertIs(zero, CoreCode.CoreCode.getWithNumber(0))
        with self.assertRaises(RuntimeError):
            CoreCode.CoreCode(0)
        other = CoreCode.CoreCode(1001)
        self.assertFalse(other.setNumber(0))
        self.assertTrue(other.setNumber(1002))
        self.assertFalse(CoreCode.CoreCode.hasWithNumber(1001))
        zero.delete()
        self.assertFalse(CoreCode.CoreCode.hasWithNumber(0))
        replacement = CoreCode.CoreCode(0)
        zero.delete()
        self.assertIs(replacement, CoreCode.CoreCode.getWithNumber(0))
        replacement.delete()
        other.delete()

    def test_singletonOnlyThroughGetInstance(self):
        registry = CoreRegistry.CoreRegistry.getInstance()
        self.assertIs(registry, CoreRegistry.CoreRegistry.getInstance())
        self.assertEqual(0, registry.getCount())
        with self.assertRaises(RuntimeError):
            CoreRegistry.CoreRegistry()

    def test_immutableClassHasNoSetters(self):
        settings = CoreSettings.CoreSettings("h", 80)
        self.assertEqual(80, settings.getPort())
        self.assertFalse(hasattr(settings, "setHost"))

    def test_lazyImmutableSetsOnce(self):
        lazy = CoreLazy.CoreLazy()
        self.assertIsNone(lazy.getLabel())
        self.assertTrue(lazy.setLabel("a"))
        self.assertFalse(lazy.setLabel("b"))
        self.assertEqual("a", lazy.getLabel())

    def test_enumerationValuesAndStrings(self):
        color = CoreItem.CoreItem.Color
        self.assertEqual("Red", str(color.Red))
        self.assertEqual("Dark_green", color.Dark_green.name)
        self.assertIs(color.Red, color("Red"))

    def test_interfaceIsAbstractWithConstants(self):
        self.assertEqual(1, CorePriced.CorePriced.CURRENCY)
        with self.assertRaises(TypeError):
            CorePriced.CorePriced()

    def test_stringFormKeepsTheUmpleLayout(self):
        book = CoreBook.CoreBook("n", CoreItem.CoreItem.Color.Red, "i")
        text = str(book)
        self.assertIn("[serial:", text)
        self.assertIn(",name:n,weight:2.0,stock:5]\n  color=Red[isbn:i,used:False]", text)

    def test_inheritedListAndDefaultedKeysFreezeOnHash(self):
        tagged = CoreTagged.CoreTagged()
        self.assertTrue(tagged.addTag("a"))
        self.assertTrue(tagged.setLevel(2))
        hash(tagged)
        self.assertFalse(tagged.addTag("b"))
        self.assertFalse(tagged.removeTag("a"))
        self.assertFalse(tagged.resetLevel())
        self.assertEqual((["a"], 2), (tagged.getTags(), tagged.getLevel()))

    def test_interfaceParentsAlreadyInheritedAreNotRepeated(self):
        names = [c.__name__ for c in CoreBothI.CoreBothI.__mro__]
        self.assertEqual(["CoreBothI", "CoreChildI", "CoreRootI", "ABC", "object"], names)

    def test_enumerationNamedEnumDoesNotHideTheBaseClass(self):
        self.assertEqual("Blue", str(CoreEnumNames.CoreEnumNames.Other.Blue))
        self.assertEqual("Red", str(CoreEnumNames.CoreEnumNames.Enum.Red))


    def test_nestedSubclassDeclaredBeforeItsBase(self):
        child = CoreOuter.CoreOuter.NestChild(1, 2)
        self.assertIsInstance(child, CoreOuter.CoreOuter.NestBase)
        self.assertEqual((1, 2), (child.getB(), child.getC()))

    def test_nestedAssociationsCreateLinkAndDeleteThroughTheOuterClass(self):
        outer = CoreOuter.CoreOuter
        owner = outer.NestOwner("o")
        part = owner.addNestPart()
        self.assertIsInstance(part, outer.NestPart)
        self.assertIs(owner, part.getNestOwner())
        holder = outer.NestHolder("label")
        self.assertIs(holder, holder.getNestTag().getNestHolder())
        user = CoreNestedUser.CoreNestedUser()
        t1, t2, t3 = outer.NestTeam(), outer.NestTeam(), outer.NestTeam()
        atMinimum = outer.NestMember(user, t1, t2)
        aboveMinimum = outer.NestMember(user, t1, t2, t3)
        t1.delete()
        self.assertEqual([aboveMinimum], list(user.getNestMembers()))
        self.assertEqual(2, aboveMinimum.numberOfNestTeams())
        self.assertEqual(0, atMinimum.numberOfNestTeams())

    def test_overloadsDispatchOnNestedClasses(self):
        outer = CoreOuter.CoreOuter
        part = outer.NestOwner("o").addNestPart()
        member = outer.NestMember(CoreNestedUser.CoreNestedUser(), outer.NestTeam(), outer.NestTeam())
        self.assertEqual(("part", "member"), (outer.NestHub().take(part), outer.NestHub().take(member)))
        user = CoreNestedUser.CoreNestedUser()
        self.assertEqual(("part", "member"), (user.take(part), user.take(member)))


    def test_factoryAttachesTheGivenOneToOnePartner(self):
        detail = FpDetail.FpDetail("original", FpOwner.FpOwner())
        with self.assertRaises(RuntimeError):
            FpOwner.FpOwner().addItem(aDetail=detail)
        free = FpDetail.FpDetail("free", FpOwner.FpOwner())
        free.delete()
        item = FpOwner.FpOwner().addItem(aDetail=free)
        self.assertIs(free, item.getDetail())
        self.assertEqual("free", item.getDetail().getName())

    def test_subclassAttributesDoNotAliasTheKeyFlagOrHashCache(self):
        flagged = KfFlagChild.KfFlagChild("x", False)
        self.assertFalse(flagged.getCanSetName())
        hash(flagged)
        self.assertTrue(flagged.setCanSetName(True))
        self.assertFalse(flagged.setName("z"))
        self.assertEqual("x", flagged.getName())
        cached = KfCacheChild.KfCacheChild("x", "payload")
        first = hash(cached)
        self.assertEqual("payload", cached.getCachedHashCode())
        self.assertTrue(cached.setCachedHashCode("changed"))
        self.assertEqual(first, hash(cached))

    def test_movingAKeyMemberIsRefusedAfterHashing(self):
        x, y = KmTag.KmTag("x"), KmTag.KmTag("y")
        owner = KmOwner.KmOwner()
        owner.addTag(x)
        owner.addTag(y)
        hash(owner)
        self.assertFalse(owner.addOrMoveTagAt(y, 0))
        self.assertEqual([x, y], list(owner.getTags()))

    def test_parameterNamedLikeTheClassDoesNotHideIt(self):
        first = aTitle.aTitle("hello", 1)
        second = aTitle.aTitle("world", 2)
        self.assertEqual((1, 2), (first.getId(), second.getId()))
        self.assertIs(second, aTitle.aTitle.getWithCode(2))
        self.assertFalse(first.setCode(2))
        # an autounique key has the unique lookups too (issue 2165)
        self.assertIs(first, aTitle.aTitle.getWithId(first.getId()))
        first.delete()
        self.assertEqual((False, True), (aTitle.aTitle.hasWithId(first.getId()), aTitle.aTitle.hasWithId(second.getId())))

    def test_overloadsOnClassesNamedLikeDispatcherLocalsAndOnTheClassItself(self):
        user = OvUser.OvUser()
        self.assertEqual(("bound", "int"), (user.f(bound.bound()), user.f(1)))
        self.assertEqual(("self type", "int"), (user.g(user), user.g(1)))


    def test_outerClassHiddenByALocalIsStillReached(self):
        owner = aName.aName.NameOwner()
        item = owner.addItem("hello")
        self.assertIsInstance(item, aName.aName.NameItem)
        self.assertEqual("hello", item.getName())
        self.assertIs(owner, item.getOwner())
        user = args.args.ArgsUser()
        self.assertEqual(("target", "int"), (user.f(args.args.ArgsTarget()), user.f(1)))

    def test_eachImportedTypeKeepsItsOwnNameInADispatcher(self):
        pair = OvPair.OvPair()
        self.assertEqual(("bound", "bound_"), (pair.h(bound.bound()), pair.h(bound_.bound_())))
        self.assertEqual("bound_", pair.h(x=bound_.bound_()))


    def test_generatedMethodsSharingANameAreDispatchedByArguments(self):
        box, item, other = MgBox.MgBox(), MgItem.MgItem(), MgItem.MgItem()
        self.assertTrue(box.addOne(item))
        self.assertIs(box, item.getMgBox())
        self.assertTrue(box.addMany(other))
        self.assertIs(box, other.getMgBox(0))
        named = MgNamed.MgNamed("x")
        self.assertEqual(("x", ">x"), (named.getName(), named.getName(">")))
        self.assertIn("name:x", str(named))
        switch = MgSwitch.MgSwitch()
        self.assertTrue(switch.go(3))
        self.assertEqual("On", switch.getSmFullName())

    def test_mostSpecificOverloadIsCalled(self):
        value = OvSpecific.OvSpecific()
        self.assertEqual(("shape", "circle"), (value.area(OvShape.OvShape("s")), value.area(OvCircle.OvCircle("c"))))
        self.assertEqual(("integer", "double"), (value.size(3), value.size(3.5)))
        self.assertEqual(("one", "many"), (value.count(1), value.count(1, 2)))

    def test_addInjectionsAndSortingRunInJavasOrder(self):
        team, player = InjTeam.InjTeam(), InjPlayer.InjPlayer()
        self.assertTrue(team.addInjPlayer(player))
        self.assertFalse(team.addInjPlayer(player))
        # Java's first add runs its before code twice, as linking the player adds it again
        self.assertEqual("adding;adding;adding;", team.getLog())
        board = SortBoard.SortBoard()
        board.addCard(SortCard.SortCard(2))
        board.addCard(SortCard.SortCard(1))
        self.assertEqual("2;2;", board.getLog())
        self.assertEqual([1, 2], [card.getRank() for card in board.getCards()])

    def test_noneGivenToAnAddWithAFactoryCreatesNothing(self):
        garage = FacGarage.FacGarage()
        car = garage.addFacCar("x")
        self.assertEqual("x", car.getPlate())
        with self.assertRaisesRegex(AttributeError, "NoneType"):
            garage.addFacCarAt(None, 0)
        # adding at a position takes an object, as in Java; other values fail and change nothing
        with self.assertRaisesRegex(AttributeError, "str"):
            garage.addFacCarAt("y", 0)
        self.assertEqual((car,), garage.getFacCars())

    def test_aGeneratedGetterJoinsUserOverloadsAndStringsStayText(self):
        product = MgProduct.MgProduct("book")
        self.assertEqual(("book", "a:book", "[book]"), (product.getName(), product.getName("a:"), product.getName("[", "]")))
        self.assertIn("name:book", str(product))
        doc = MgDoc.MgDoc("d")
        self.assertIn("    def getName(self, locale):\n", doc.sample())
        self.assertEqual("d", doc.getName())
        self.assertFalse(hasattr(MgDoc.MgDoc, "getName1"))

    def test_sameCountOverloadsOfGeneratedMethodsAreDispatchedByType(self):
        team, player = MgTeam.MgTeam(), MgPlayer.MgPlayer()
        self.assertTrue(team.addMgPlayer("ann"))
        self.assertTrue(team.addMgPlayer(player))
        self.assertIs(team, player.getMgTeam())
        other = MgTeam.MgTeam()
        self.assertTrue(player.setMgTeam(other))
        self.assertEqual((0, 1), (team.numberOfMgPlayers(), other.numberOfMgPlayers()))
        self.assertTrue(team.register("bob"))
        self.assertTrue(team.register(player))
        self.assertEqual("ann;player;", team.getLog())

    def test_overloadsAreToldApartByTypeWhateverTheirNames(self):
        gauge = MgGauge.MgGauge()
        self.assertEqual((True, 12), (gauge.setLevel(12), gauge.getLevel()))
        self.assertEqual((True, 12), (gauge.setLevel("ok"), gauge.getLevel()))
        self.assertEqual((True, 5), (gauge.setPrice(5), gauge.getPrice()))
        self.assertTrue(gauge.setPrice("a", "b"))
        self.assertTrue(gauge.open("text"))
        self.assertEqual("Shut", gauge.getSmFullName())
        self.assertTrue(gauge.open(3))
        self.assertEqual("Open", gauge.getSmFullName())
        inbox = OvInbox.OvInbox()
        self.assertEqual(("urgent", "urgent", "ordinary"), (inbox.deliver(OvUrgent.OvUrgent()),
                         inbox.deliver(OvUrgent.OvUrgent(), OvMessage.OvMessage()), inbox.deliver(OvMessage.OvMessage())))

    def test_staticOverloadsOfGeneratedStaticMethodsShareADispatcher(self):
        account = MgAccount.MgAccount("kim@example.com")
        self.assertIs(account, MgAccount.MgAccount.getWithEmail("kim@example.com"))
        self.assertEqual("user", MgAccount.MgAccount.getWithEmail("kim@example.com", True))
        account.delete()
        self.assertEqual((2, 3, 2), (MgRoster.MgRoster.minimumNumberOfMembers(),
                                     MgRoster.MgRoster.minimumNumberOfMembers(True), MgRoster.MgRoster.minimumNumberOfMembers(False)))

    def test_beforeInjectionsRunAheadOfTheInvariant(self):
        clamp = InvClamp.InvClamp()
        self.assertEqual((True, 0), (clamp.setBalance(-5), clamp.getBalance()))
        self.assertEqual((True, 7), (clamp.setBalance(7), clamp.getBalance()))

    def test_charAndFloatingOverloadsFollowJava(self):
        chooser = OvChar.OvChar()
        self.assertEqual(("string", "double"), (chooser.f("ab"), chooser.g(1.5)))
        # A one-character string has the char overload's type (FINAL-LEDGER section 4)
        self.assertEqual("char", chooser.f("a"))

    def test_abstractMethodBesideAGeneratedOneKeepsSubclassesCreatable(self):
        self.assertEqual("square x", AbsSquare.AbsSquare().setSize("x"))
        with self.assertRaises(TypeError):
            AbsShape.AbsShape()

    def test_generatedMethodsOfUserNamesAreDispatchedByType(self):
        label = SmLabel.SmLabel()
        self.assertEqual("Quiet", label.getStatusFullName())
        self.assertTrue(label.setStatus("custom"))
        label.setStatus(SmLabel.SmLabel.Status.Active)
        self.assertEqual("Active", label.getStatusFullName())
        vehicle = EvVehicle.EvVehicle()
        passenger = EvPassenger.EvPassenger()
        self.assertTrue(vehicle.addPassenger(passenger))
        self.assertEqual((True, "12A;"), (vehicle.removePassenger("12A"), vehicle.getLog()))
        self.assertTrue(vehicle.removePassenger(passenger))
        self.assertEqual(0, vehicle.numberOfPassengers())

    def test_aRedefinitionReplacesOnlyTheOverloadOfItsTypes(self):
        order = RdOrder.RdOrder()
        RdLine.RdLine("a", 1, order)
        self.assertEqual((False, 1), (order.addLine("b", 2), order.numberOfLines()))

    def test_beforeInjectionsRunAheadOfTheOnceSetGuard(self):
        badge = InjBadge.InjBadge()
        self.assertTrue(badge.setBadge("gold"))
        self.assertFalse(badge.setBadge("silver"))
        self.assertEqual("attempt gold;attempt silver;", badge.getLog())

    def test_beforeInjectionsRunAheadOfAKeyGuardOnADirectedEnd(self):
        room = InjRoom.InjRoom(1)
        self.assertTrue(room.setBuilding(InjBuilding.InjBuilding()))
        hash(room)
        self.assertFalse(room.setBuilding(InjBuilding.InjBuilding()))
        self.assertFalse(room.setNumber(5))
        self.assertEqual("b;b;n;", room.getLog())

    def test_beforeInjectionsRunAheadOfEveryGuard(self):
        d0, d1 = InjGuardD.InjGuardD(), InjGuardD.InjGuardD()
        a = InjGuardA.InjGuardA(d0, d1)
        a.setLog("")
        d = InjGuardD.InjGuardD()
        self.assertEqual((False, False, True), (a.removeBee(InjGuardB.InjGuardB()), a.setDees(d, d), a.setCee(InjGuardC.InjGuardC())))
        hash(a)
        self.assertFalse(a.setCee(InjGuardC.InjGuardC()))
        self.assertEqual("removeBee;setDees;setCee;setCee;", a.getLog())

        k = InjGuardK.InjGuardK(1)
        hash(k)
        self.assertEqual([False] * 4, [k.addName("x"), k.removeName("x"), k.setN(2), k.setLevel(5)])
        self.assertEqual("addName x;removeName x;setN 2;setLevel 5;", k.getLog())

        # The inherited key is frozen too (unlike Java), after the before-injection
        sub = InjGuardSub.InjGuardSub(1)
        hash(sub)
        self.assertEqual((False, 1, "setN 2;"), (sub.setN(2), sub.getN(), sub.getLog()))

        w, ys, ts = InjGuardW.InjGuardW(), [InjGuardY.InjGuardY() for _ in range(3)], [InjGuardT.InjGuardT(), InjGuardT.InjGuardT()]
        u = InjGuardU.InjGuardU(InjGuardX.InjGuardX(), [w], ys, ts)
        u.setLog("")
        hash(u)
        v = InjGuardV.InjGuardV()
        self.assertEqual([False] * 7, [u.setWs(w), u.setX(InjGuardX.InjGuardX()), u.setYs(*ys), u.setZs(InjGuardZ.InjGuardZ()),
                                       u.setTs(*ts), u.addV(v), u.removeV(v)])
        self.assertEqual("setWs;setX;setYs;setZs;setTs;addV;removeV;", u.getLog())

        m, n = InjGuardM.InjGuardM(), InjGuardN.InjGuardN()
        self.assertTrue(m.addN(n))
        hash(m)
        self.assertEqual((False, "removeN;"), (m.removeN(n), m.getLog()))

    def test_generatedQueriesRunTheirInjections(self):
        # The constructor takes the default through getDefaultLevel, as Java's does
        query = InjQuery.InjQuery("a@b")
        self.assertEqual("default;default after;", query.getLog())
        query.setLog("")
        self.assertEqual((True, 3), (query.isOn(), query.getDefaultLevel()))
        self.assertEqual("isOn;isOn after;default;default after;", query.getLog())
        out = io.StringIO()
        with contextlib.redirect_stdout(out):
            answers = (InjQuery.InjQuery.hasWithEmail("zz"), InjQuery.InjQuery.minimumNumberOfItems(),
                       InjQuery.InjQuery.maximumNumberOfItems())
        # As in Java, the has-query asks the get-query, whose injections run too
        self.assertEqual(((False, 0, 4), "hasWithEmail\ngetWithEmail after\nminimum\nmaximum\n"), (answers, out.getvalue()))

    def test_anEventNamedLikeASetterOfAGrandparentOrATrait(self):
        for machine in (EvChild.EvChild(), EvTraitUser.EvTraitUser()):
            self.assertEqual((True, 5), (machine.setX(5), machine.getX()))
            self.assertEqual((True, "T"), (machine.setX("v"), machine.getSmFullName()))

    def test_anEventParameterNamedStr(self):
        machine = EvStrParam.EvStrParam()
        self.assertEqual((True, True, "Error"), (machine.press("a"), machine.press("b"), machine.getSmFullName()))

    def test_aClassNamedMathKeepsTheStandardModule(self):
        machine = math.math()
        self.assertEqual((True, 1.5), (machine.go(), machine.getY()))

    def test_typedOverloadsKeepTheGeneratedEqualsAndIndexOf(self):
        a, b = OvKeyed.OvKeyed("same"), OvKeyed.OvKeyed("same")
        self.assertEqual((True, False), (a.equals(b), a.equals(False)))
        values = OvImmList.OvImmList()
        self.assertEqual((1, -1, 771), (values.indexOfValue("y"), values.indexOfValue("missing"), values.indexOfValue(False)))

    def test_aValidityQueryRunsItsInjections(self):
        box = InjBox.InjBox()
        self.assertEqual((False, 11), (box.isNumberOfItemsValid(), box.getHits()))

    def test_anAbstractGroupKeepsTheGeneratedMethodOfItsName(self):
        square = AbsGroupSquare.AbsGroupSquare()
        self.assertEqual((True, 5), (square.grow(5), square.getSize()))
        self.assertEqual("square x", square.setSize("x"))
        with self.assertRaises(TypeError):
            AbsGroupShape.AbsGroupShape()

    def test_setterEventAndUserMethodShareOneDispatcher(self):
        thermostat = SetEvThermostat.SetEvThermostat(20)
        self.assertEqual((True, 22), (thermostat.setTarget(22), thermostat.getTarget()))
        self.assertEqual((True, 21), (thermostat.setTarget(18, 24), thermostat.getTarget()))
        self.assertTrue(thermostat.setTarget("eco"))
        self.assertEqual("Scheduled", thermostat.getModeFullName())

    def test_nestedClassTextStaysAsWritten(self):
        self.assertEqual("#<<IMPORTS>>", NestMarker.NestMarker.NestMarkerInner().text())

    def test_narrowerVariableArgumentsAreMoreSpecific(self):
        canvas = OvCanvas.OvCanvas()
        self.assertEqual(("circles", "shapes", "circles"),
                         (canvas.describe(OvCircle.OvCircle("c")), canvas.describe(OvShape.OvShape("s")), canvas.describe()))
        self.assertEqual(("integers", "doubles"), (canvas.count(1, 2), canvas.count(1.5)))

    def test_missingModelObjectInTextIsNull(self):
        label = TxLabel.TxLabel()
        label.go()
        self.assertEqual("box=null", label.getText())

    def test_underscoreNamesInValuesAreNotNumbers(self):
        self.assertEqual(30, MgView.MgView().getMode())


if __name__ == "__main__":
    unittest.main()
