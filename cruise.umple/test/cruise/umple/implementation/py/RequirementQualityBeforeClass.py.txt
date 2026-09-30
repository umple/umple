#PLEASE DO NOT EDIT THIS CODE
#This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!


class Item:
    def __init__(self, aName):
        self._name = aName

    def setName(self, aName):
        self._name = aName
        return True

    def getName(self):
        return self._name

    def delete(self):
        pass

    def __str__(self):
        return (super().__str__() + "["
                + "name:" + str(self.getName())
                + "]")
