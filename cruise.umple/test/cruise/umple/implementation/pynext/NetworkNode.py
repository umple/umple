#PLEASE DO NOT EDIT THIS CODE
#This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!

from abc import ABC
from abc import abstractmethod


class NetworkNode(ABC):
    @abstractmethod
    def connect(self):
        pass

    @abstractmethod
    def disconnect(self):
        pass

    @abstractmethod
    def errorDetected(self):
        pass
