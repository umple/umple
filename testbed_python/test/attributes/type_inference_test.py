import unittest
import datetime

from ImportModules import importModules

importModules(
    ["MoreTypeInference", "TypeInference", "TypeInferenceInterfaceObject"], ["attributes", "test"]
)
from ImportModules import *


class TypeInferenceTest(unittest.TestCase):
    # testbed/test/cruise/attributes/test/TypeInferenceTest.java: inferenceCheck
    def test_inferenceCheck(self):
        x = TypeInference.TypeInference(None, 0, None, False, 0)
        self.assertEqual(2, x.getA())
        self.assertEqual(3.0, x.getB())
        self.assertIs(False, x.getC())
        self.assertEqual("hello world!", x.getD())
        self.assertIsNone(x.getE())
        self.assertEqual(0, x.getF())
        self.assertEqual(42, x.getG())
        self.assertEqual("hello", x.getH())
        self.assertIsNone(x.getI())
        self.assertEqual(-1, x.getJ())
        self.assertEqual(-3.33333, x.getK())
        self.assertEqual("-6", x.getL())
        self.assertEqual("-3.1415926", x.getM())
        self.assertEqual("99", x.getN())
        self.assertIs(False, x.getO())
        self.assertIs(False, x.getP())
        self.assertEqual(0, x.getQ())
        self.assertEqual(3, x.getR())

    # testbed/test/cruise/attributes/test/TypeInferenceTest.java: moreInferenceCheck
    # Attribute l (= new Object()) is left out of the Python model, see testbed_python/src/TestHarnessAttributes.ump
    def test_moreInferenceCheck(self):
        y = MoreTypeInference.MoreTypeInference(None, None)
        self.assertIsInstance(y.getA(), datetime.time)
        self.assertIsNone(y.getB())
        self.assertIsInstance(y.getC(), str)
        self.assertIsInstance(y.getD(), datetime.time)
        self.assertIsInstance(y.getE(), str)
        self.assertIsInstance(y.getF(), str)
        self.assertIsInstance(y.getG(), datetime.date)
        self.assertIsNone(y.getH())
        self.assertIsInstance(y.getI(), str)
        self.assertIsInstance(y.getJ(), str)
        self.assertIsInstance(y.getK(), datetime.date)

    # testbed/test/cruise/attributes/test/TypeInferenceTest.java: inferenceCheckInterface
    # Constant AL (= new Object()) is left out of the Python model, see testbed_python/src/TestHarnessAttributes.ump
    def test_inferenceCheckInterface(self):
        z = TypeInferenceInterfaceObject.TypeInferenceInterfaceObject()
        self.assertEqual(2, z.A)
        self.assertEqual(3.0, z.B)
        self.assertIs(False, z.C)
        self.assertEqual("hello world!", z.D)
        self.assertEqual("", z.E)
        self.assertEqual(0, z.F)
        self.assertEqual(42, z.G)
        self.assertEqual("hello", z.H)
        self.assertEqual("", z.I)
        self.assertEqual(-1, z.J)
        self.assertEqual(-3.33333, z.K)
        self.assertEqual("-6", z.L)
        self.assertEqual("-3.1415926", z.M)
        self.assertEqual("99", z.N)
        self.assertIs(False, z.O)
        self.assertIs(False, z.P)
        self.assertEqual(0, z.Q)
        self.assertEqual(3, z.R)
        self.assertIsInstance(z.AA, datetime.time)
        self.assertIsInstance(z.AC, str)
        self.assertIsInstance(z.AD, datetime.time)
        self.assertIsInstance(z.AE, str)
        self.assertIsInstance(z.AF, str)
        self.assertIsInstance(z.AG, datetime.date)
        self.assertIsInstance(z.AI, str)
        self.assertIsInstance(z.AJ, str)
        self.assertIsInstance(z.AK, datetime.date)
