#PLEASE DO NOT EDIT THIS CODE
#This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!


class Order:
    def __init__(self, aNumber):
        self._number = aNumber

    def setNumber(self, aNumber):
        self._number = aNumber
        return True

    def getNumber(self):
        return self._number

    def delete(self):
        pass

    def __str__(self):
        return (super().__str__() + "["
                + "number:" + str(self.getNumber())
                + "]")
