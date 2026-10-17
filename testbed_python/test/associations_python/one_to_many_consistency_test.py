import random
import unittest

from ImportModules import importModules

importModules(["OmFzOwner", "OmFzA", "OmFzB", "OmFzC", "OmFzD", "OmFzE", "OmFzF"], ["onemany"])
from ImportModules import *

# (class, many end, one end, upper bound of the many end)
ENDS = [(OmFzA.OmFzA, "As", "OwnerA", None), (OmFzB.OmFzB, "Bs", "OwnerB", 3), (OmFzC.OmFzC, "Cs", "OwnerC", None),
        (OmFzD.OmFzD, "Ds", "OwnerD", None), (OmFzE.OmFzE, "Es", "OwnerE", 2), (OmFzF.OmFzF, "Fs", "OwnerF", 3)]
OPTIONAL = (OmFzA.OmFzA, OmFzB.OmFzB, OmFzC.OmFzC)


# Random adds, removes, sets, batch sets, factories and deletes on every one-to-many kind, with keys
# drawn from {0, 1} so that many linked objects are equal. After each step both sides of every link
# must agree by identity, no object may be listed twice, and upper bounds must hold. Deletes that
# reach other association families (owners, and the parts of the 2..* and 1..3 ends) are left out.
class ConsistencyTest(unittest.TestCase):
    def _check(self, owners, pools):
        for owner in owners:
            for cls, many, one, upper in ENDS:
                items = getattr(owner, "get" + many)()
                if upper is not None:
                    self.assertLessEqual(len(items), upper)
                for x in items:
                    self.assertIs(owner, getattr(x, "get" + one)())
                    self.assertEqual(1, sum(1 for y in items if y is x))
            self.assertNotEqual(1, owner.numberOfCs())
        for cls, many, one, upper in ENDS:
            for x in pools[cls]:
                owner = getattr(x, "get" + one)()
                if owner is not None:
                    self.assertTrue(any(y is x for y in getattr(owner, "get" + many)()))

    def _run_seed(self, seed, steps):
        rnd = random.Random(seed)
        key = lambda: rnd.randrange(2)
        owners = []
        pools = {cls: [] for cls, *_ in ENDS}

        def newOwner():
            free = [c for c in pools[OmFzC.OmFzC] if c.getOwnerC() is None]
            parts = rnd.sample(free, 2) if len(free) >= 2 and rnd.random() < 0.5 else [OmFzC.OmFzC(key()), OmFzC.OmFzC(key())]
            owners.append(OmFzOwner.OmFzOwner(key(), *parts))
            pools[OmFzC.OmFzC].extend(p for p in parts if not any(p is c for c in pools[OmFzC.OmFzC]))

        newOwner()
        newOwner()
        for _ in range(steps):
            owner = rnd.choice(owners)
            cls, many, one, upper = rnd.choice(ENDS)
            pool = pools[cls]
            x = rnd.choice(pool) if pool else None
            single = many[:-1]
            op = rnd.randrange(8)
            if op == 0:
                try:
                    pool.append(cls(key()) if cls in OPTIONAL else cls(key(), owner))
                except RuntimeError:
                    pass
            elif op == 1 and x is not None:
                self.assertIn(getattr(owner, "add" + single)(x), (True, False))
            elif op == 2 and x is not None:
                self.assertIn(getattr(owner, "remove" + single)(x), (True, False))
            elif op == 3 and x is not None:
                target = None if cls in OPTIONAL and rnd.random() < 0.3 else rnd.choice(owners)
                self.assertIn(getattr(x, "set" + one)(target), (True, False))
            elif op == 4 and cls not in OPTIONAL:
                created = getattr(owner, "add" + single)(key())
                if created is not None:
                    pool.append(created)
            elif op == 5 and x is not None and cls not in (OmFzC.OmFzC, OmFzF.OmFzF):
                x.delete()
                pool[:] = [y for y in pool if y is not x]
            elif op == 6 and cls is OmFzC.OmFzC and len(pool) >= 2:
                self.assertIn(owner.setCs(*[rnd.choice(pool) for _ in range(rnd.randint(1, 4))]), (True, False))
            elif op == 7 and rnd.random() < 0.1:
                newOwner()
            self._check(owners, pools)

    def test_randomOperationsKeepLinksConsistent(self):
        for seed in range(40):
            self._run_seed(seed, 250)


if __name__ == "__main__":
    unittest.main()
