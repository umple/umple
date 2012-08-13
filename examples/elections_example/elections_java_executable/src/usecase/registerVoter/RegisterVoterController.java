/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package usecase.registerVoter;
import view.registerVoter.RegisterVoterView;
import service.VoterService;
import shared.domain.Voter;
import usecase.startup.Controller;
import shared.Result;

public class RegisterVoterController
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static RegisterVoterController theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RegisterVoterController Attributes
  private RegisterVoterView registerVoterView;
  private String voterName;
  private String voterAddress;
  private String voterTelephone;
  private boolean voterFound;

  //RegisterVoterController State Machines
  enum VoterRegistrationSteps { Initial, RegisterVoterViewShown, CheckingVoterData, CheckingExistingVoter, AddingVoter, VoterAdded, VoterNotAdded, VoterExists, VoterNameEmpty, VoterAddressEmpty, VoterTelephoneEmpty, ClosingView }
  private VoterRegistrationSteps VoterRegistrationSteps;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private RegisterVoterController()
  {
    voterName = null;
    voterAddress = null;
    voterTelephone = null;
    voterFound = false;
    setVoterRegistrationSteps(VoterRegistrationSteps.Initial);
  }

  public static RegisterVoterController getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new RegisterVoterController();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getVoterRegistrationStepsFullName()
  {
    String answer = VoterRegistrationSteps.toString();
    return answer;
  }

  public VoterRegistrationSteps getVoterRegistrationSteps()
  {
    return VoterRegistrationSteps;
  }

  public boolean registerVoter()
  {
    boolean wasEventProcessed = false;
    
    VoterRegistrationSteps aVoterRegistrationSteps = VoterRegistrationSteps;
    switch (aVoterRegistrationSteps)
    {
      case Initial:
        setVoterRegistrationSteps(VoterRegistrationSteps.RegisterVoterViewShown);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean addButtonClicked()
  {
    boolean wasEventProcessed = false;
    
    VoterRegistrationSteps aVoterRegistrationSteps = VoterRegistrationSteps;
    switch (aVoterRegistrationSteps)
    {
      case RegisterVoterViewShown:
        setVoterRegistrationSteps(VoterRegistrationSteps.CheckingVoterData);
        wasEventProcessed = true;
        break;
      case VoterNameEmpty:
        setVoterRegistrationSteps(VoterRegistrationSteps.CheckingVoterData);
        wasEventProcessed = true;
        break;
      case VoterAddressEmpty:
        setVoterRegistrationSteps(VoterRegistrationSteps.CheckingVoterData);
        wasEventProcessed = true;
        break;
      case VoterTelephoneEmpty:
        setVoterRegistrationSteps(VoterRegistrationSteps.CheckingVoterData);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean closeView()
  {
    boolean wasEventProcessed = false;
    
    VoterRegistrationSteps aVoterRegistrationSteps = VoterRegistrationSteps;
    switch (aVoterRegistrationSteps)
    {
      case RegisterVoterViewShown:
        setVoterRegistrationSteps(VoterRegistrationSteps.ClosingView);
        wasEventProcessed = true;
        break;
      case VoterNameEmpty:
        setVoterRegistrationSteps(VoterRegistrationSteps.ClosingView);
        wasEventProcessed = true;
        break;
      case VoterAddressEmpty:
        setVoterRegistrationSteps(VoterRegistrationSteps.ClosingView);
        wasEventProcessed = true;
        break;
      case VoterTelephoneEmpty:
        setVoterRegistrationSteps(VoterRegistrationSteps.ClosingView);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition86__()
  {
    boolean wasEventProcessed = false;
    
    VoterRegistrationSteps aVoterRegistrationSteps = VoterRegistrationSteps;
    switch (aVoterRegistrationSteps)
    {
      case CheckingVoterData:
        if (voterName.trim().isEmpty())
        {
          setVoterRegistrationSteps(VoterRegistrationSteps.VoterNameEmpty);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition87__()
  {
    boolean wasEventProcessed = false;
    
    VoterRegistrationSteps aVoterRegistrationSteps = VoterRegistrationSteps;
    switch (aVoterRegistrationSteps)
    {
      case CheckingVoterData:
        if (voterAddress.trim().isEmpty())
        {
          setVoterRegistrationSteps(VoterRegistrationSteps.VoterAddressEmpty);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition88__()
  {
    boolean wasEventProcessed = false;
    
    VoterRegistrationSteps aVoterRegistrationSteps = VoterRegistrationSteps;
    switch (aVoterRegistrationSteps)
    {
      case CheckingVoterData:
        if (voterTelephone.trim().isEmpty())
        {
          setVoterRegistrationSteps(VoterRegistrationSteps.VoterTelephoneEmpty);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition89__()
  {
    boolean wasEventProcessed = false;
    
    VoterRegistrationSteps aVoterRegistrationSteps = VoterRegistrationSteps;
    switch (aVoterRegistrationSteps)
    {
      case CheckingVoterData:
        setVoterRegistrationSteps(VoterRegistrationSteps.CheckingExistingVoter);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition90__()
  {
    boolean wasEventProcessed = false;
    
    VoterRegistrationSteps aVoterRegistrationSteps = VoterRegistrationSteps;
    switch (aVoterRegistrationSteps)
    {
      case CheckingExistingVoter:
        if (!voterFound)
        {
          setVoterRegistrationSteps(VoterRegistrationSteps.AddingVoter);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition91__()
  {
    boolean wasEventProcessed = false;
    
    VoterRegistrationSteps aVoterRegistrationSteps = VoterRegistrationSteps;
    switch (aVoterRegistrationSteps)
    {
      case CheckingExistingVoter:
        if (voterFound)
        {
          setVoterRegistrationSteps(VoterRegistrationSteps.VoterExists);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition92__()
  {
    boolean wasEventProcessed = false;
    
    VoterRegistrationSteps aVoterRegistrationSteps = VoterRegistrationSteps;
    switch (aVoterRegistrationSteps)
    {
      case AddingVoter:
        if (VoterService.getInstance().getVoterAdded())
        {
          setVoterRegistrationSteps(VoterRegistrationSteps.VoterAdded);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition93__()
  {
    boolean wasEventProcessed = false;
    
    VoterRegistrationSteps aVoterRegistrationSteps = VoterRegistrationSteps;
    switch (aVoterRegistrationSteps)
    {
      case AddingVoter:
        if (VoterService.getInstance().getVoterAdded())
        {
          setVoterRegistrationSteps(VoterRegistrationSteps.VoterNotAdded);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition94__()
  {
    boolean wasEventProcessed = false;
    
    VoterRegistrationSteps aVoterRegistrationSteps = VoterRegistrationSteps;
    switch (aVoterRegistrationSteps)
    {
      case VoterAdded:
        setVoterRegistrationSteps(VoterRegistrationSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition95__()
  {
    boolean wasEventProcessed = false;
    
    VoterRegistrationSteps aVoterRegistrationSteps = VoterRegistrationSteps;
    switch (aVoterRegistrationSteps)
    {
      case VoterNotAdded:
        setVoterRegistrationSteps(VoterRegistrationSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition96__()
  {
    boolean wasEventProcessed = false;
    
    VoterRegistrationSteps aVoterRegistrationSteps = VoterRegistrationSteps;
    switch (aVoterRegistrationSteps)
    {
      case VoterExists:
        setVoterRegistrationSteps(VoterRegistrationSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition97__()
  {
    boolean wasEventProcessed = false;
    
    VoterRegistrationSteps aVoterRegistrationSteps = VoterRegistrationSteps;
    switch (aVoterRegistrationSteps)
    {
      case ClosingView:
        setVoterRegistrationSteps(VoterRegistrationSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setVoterRegistrationSteps(VoterRegistrationSteps aVoterRegistrationSteps)
  {
    VoterRegistrationSteps = aVoterRegistrationSteps;

    // entry actions and do activities
    switch(VoterRegistrationSteps)
    {
      case RegisterVoterViewShown:
        showRegisterVoterView();
        break;
      case CheckingVoterData:
        checkVoterData();
        __autotransition86__();
        __autotransition87__();
        __autotransition88__();
        __autotransition89__();
        break;
      case CheckingExistingVoter:
        VoterService.getInstance().setVoterNameToSearch(voterName);
          voterFound=VoterService.getInstance().getVoterFound();
        __autotransition90__();
        __autotransition91__();
        break;
      case AddingVoter:
        tryToAddVoter();
        __autotransition92__();
        __autotransition93__();
        break;
      case VoterAdded:
        Result.getInstance().setMessage("Voter Added Successfully!");/*JOptionPane.showMessageDialog(null, "Voter Added Successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE)*/;
               Controller.getInstance().start();
        __autotransition94__();
        break;
      case VoterNotAdded:
        Result.getInstance().setMessage("Adding Voter Failed!");/*JOptionPane.showMessageDialog(null, "Adding Voter Failed!", "Error!", JOptionPane.ERROR_MESSAGE);*/
               Controller.getInstance().start();
        __autotransition95__();
        break;
      case VoterExists:
        Result.getInstance().setMessage("Voter Exists!");/*JOptionPane.showMessageDialog(null, "Voter Exists!", "Error!", JOptionPane.ERROR_MESSAGE);*/
          Controller.getInstance().start();
          registerVoterView.dispose();
        __autotransition96__();
        break;
      case VoterNameEmpty:
        Result.getInstance().setMessage("Voter name cannot be empty!");/*JOptionPane.showMessageDialog(null, "Voter name cannot be empty!", "Error!", JOptionPane.ERROR_MESSAGE);*/
        break;
      case VoterAddressEmpty:
        Result.getInstance().setMessage("Voter address cannot be empty!");/*JOptionPane.showMessageDialog(null, "Voter address cannot be empty!", "Error!", JOptionPane.ERROR_MESSAGE);*/
        break;
      case VoterTelephoneEmpty:
        Result.getInstance().setMessage("Voter tel cannot be empty!");/*JOptionPane.showMessageDialog(null, "Voter telephone cannot be empty!", "Error!", JOptionPane.ERROR_MESSAGE);*/
        break;
      case ClosingView:
        registerVoterView.dispose();
        __autotransition97__();
        break;
    }
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private void showRegisterVoterView() {
    registerVoterView=new RegisterVoterView();
    registerVoterView.setVisible(true);
  }
  
  private void checkVoterData() {
    voterName=registerVoterView.getVoterName();
    voterAddress=registerVoterView.getVoterAddress();
    voterTelephone=registerVoterView.getVoterTelephone();
  }
  
  private void tryToAddVoter() {
    Voter voter=new Voter(-1, voterName, voterAddress, voterTelephone);
    VoterService.getInstance().setNewVoter(voter);
    registerVoterView.dispose();
  }
}