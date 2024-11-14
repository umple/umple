// This is a more fully-featured state machine for
// a garage door corresponding to the diagram
// above
class Garage {
  Boolean entranceClear=true;
  GarageDoor { 
    Closed {
      entry/{stopMotor();}  
      entry/{triggerEnergySaveMode();}
      exit/ {triggerNormalEnergyMode();}
      pressButton -> /{turnLightOn();} Opening; 
    }
    Opening {
      entry/{runMotorForward();}
      openingCompleted -> Open;
    }
    Open {
      entry/{stopMotor();}
      // do {wait(60000); turnLightOff();}
      pressButton [getEntranceClear()] -> Closing;
    }
    Closing {
      entry/{runMotorInReverse();}
      closingCompleted -> Closed;
      pressButton -> /{flashLightOn();} Opening; 
    }
  }
  
  boolean runMotorInReverse() Java {
     System.out.println(
       "Running motor in reverse");
    return true;
  }

  boolean runMotorInReverse() Python {
    print("Running motor in reverse")
    return True
  }
  
  boolean flashLightOn() Java {
     System.out.println("Flashing light on");
    return true;
  }

  boolean flashLightOn() Python {
    print("Flashing light on")
    return True;
  }

  boolean turnLightOn() Java {
     System.out.println("Turning light on");
    return true;
  }

  boolean turnLightOn() Python {
    print("Turning light on")
    return True
  }  
  
   boolean turnLightOff() Java {
     System.out.println(
       "Turning light off");
    return true;
  }

   boolean turnLightOff() Python {
    print("Turning light off")
    return True
  }  
  
  boolean runMotorForward() Java {
     System.out.println(
       "Running motor forwards");
    return true;
  }

  boolean runMotorForward() Python {
    print("Running motor forwards")
    return True
  }  

  boolean triggerEnergySaveMode() Java {
     System.out.println(
       "Triggering Energy Saving Mode");
    return true;
  }

  boolean triggerEnergySaveMode() Python {
    print("Triggering Energy Saving Mode")
    return True
  }

  boolean stopMotor() Java {
     System.out.println("Stopping motor");
    return true;
  }

  boolean stopMotor() Python {
    print("Stopping motor")
    return True
  }  

  boolean triggerNormalEnergyMode() Java {
     System.out.println(
       "Triggering Normal Energy Mode");
         return true;
  }

  boolean triggerNormalEnergyMode() Python {
    print("Triggering Normal Energy Mode")
    return True
  }  
  
  boolean waitawhile() Java {
    System.out.println("Waiting");
    return true;
  }

  boolean waitawhile() Python {
    print("Waiting")
    return True
  }  
  
  boolean test() Java {
          System.out.println("Testing");
         return true;
  }

  boolean test() Python {
    print("Testing")
    return True
  }  
}
// @@@skipcppcompile
