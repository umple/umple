/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package usecase.registerCandidate;
import view.registerCandidate.RegisterCandidateView;
import javax.swing.JOptionPane;
import service.CandidateService;
import shared.domain.Candidate;
import usecase.startup.Controller;

public class RegisterCandidateController
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static RegisterCandidateController theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RegisterCandidateController Attributes
  private RegisterCandidateView registerCandidateView;
  private String candidateName;
  private String candidateAddress;
  private String candidateTelephone;
  private boolean candidateFound;

  //RegisterCandidateController State Machines
  enum CandidateRegistrationSteps { Initial, RegisterCandidateViewShown, CheckingCandidateData, CheckingExistingCandidate, AddingCandidate, CandidateAdded, CandidateNotAdded, CandidateExists, CandidateNameEmpty, CandidateAddressEmpty, CandidateTelephoneEmpty, ClosingView }
  private CandidateRegistrationSteps CandidateRegistrationSteps;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private RegisterCandidateController()
  {
    candidateName = null;
    candidateAddress = null;
    candidateTelephone = null;
    candidateFound = false;
    setCandidateRegistrationSteps(CandidateRegistrationSteps.Initial);
  }

  public static RegisterCandidateController getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new RegisterCandidateController();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getCandidateRegistrationStepsFullName()
  {
    String answer = CandidateRegistrationSteps.toString();
    return answer;
  }

  public CandidateRegistrationSteps getCandidateRegistrationSteps()
  {
    return CandidateRegistrationSteps;
  }

  public boolean registerCandidate()
  {
    boolean wasEventProcessed = false;
    
    CandidateRegistrationSteps aCandidateRegistrationSteps = CandidateRegistrationSteps;
    switch (aCandidateRegistrationSteps)
    {
      case Initial:
        setCandidateRegistrationSteps(CandidateRegistrationSteps.RegisterCandidateViewShown);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean addButtonClicked()
  {
    boolean wasEventProcessed = false;
    
    CandidateRegistrationSteps aCandidateRegistrationSteps = CandidateRegistrationSteps;
    switch (aCandidateRegistrationSteps)
    {
      case RegisterCandidateViewShown:
        setCandidateRegistrationSteps(CandidateRegistrationSteps.CheckingCandidateData);
        wasEventProcessed = true;
        break;
      case CandidateNameEmpty:
        setCandidateRegistrationSteps(CandidateRegistrationSteps.CheckingCandidateData);
        wasEventProcessed = true;
        break;
      case CandidateAddressEmpty:
        setCandidateRegistrationSteps(CandidateRegistrationSteps.CheckingCandidateData);
        wasEventProcessed = true;
        break;
      case CandidateTelephoneEmpty:
        setCandidateRegistrationSteps(CandidateRegistrationSteps.CheckingCandidateData);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean closeView()
  {
    boolean wasEventProcessed = false;
    
    CandidateRegistrationSteps aCandidateRegistrationSteps = CandidateRegistrationSteps;
    switch (aCandidateRegistrationSteps)
    {
      case RegisterCandidateViewShown:
        setCandidateRegistrationSteps(CandidateRegistrationSteps.ClosingView);
        wasEventProcessed = true;
        break;
      case CandidateNameEmpty:
        setCandidateRegistrationSteps(CandidateRegistrationSteps.ClosingView);
        wasEventProcessed = true;
        break;
      case CandidateAddressEmpty:
        setCandidateRegistrationSteps(CandidateRegistrationSteps.ClosingView);
        wasEventProcessed = true;
        break;
      case CandidateTelephoneEmpty:
        setCandidateRegistrationSteps(CandidateRegistrationSteps.ClosingView);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition588__()
  {
    boolean wasEventProcessed = false;
    
    CandidateRegistrationSteps aCandidateRegistrationSteps = CandidateRegistrationSteps;
    switch (aCandidateRegistrationSteps)
    {
      case CheckingCandidateData:
        if (candidateName.trim().isEmpty())
        {
          setCandidateRegistrationSteps(CandidateRegistrationSteps.CandidateNameEmpty);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition589__()
  {
    boolean wasEventProcessed = false;
    
    CandidateRegistrationSteps aCandidateRegistrationSteps = CandidateRegistrationSteps;
    switch (aCandidateRegistrationSteps)
    {
      case CheckingCandidateData:
        if (candidateAddress.trim().isEmpty())
        {
          setCandidateRegistrationSteps(CandidateRegistrationSteps.CandidateAddressEmpty);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition590__()
  {
    boolean wasEventProcessed = false;
    
    CandidateRegistrationSteps aCandidateRegistrationSteps = CandidateRegistrationSteps;
    switch (aCandidateRegistrationSteps)
    {
      case CheckingCandidateData:
        if (candidateTelephone.trim().isEmpty())
        {
          setCandidateRegistrationSteps(CandidateRegistrationSteps.CandidateTelephoneEmpty);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition591__()
  {
    boolean wasEventProcessed = false;
    
    CandidateRegistrationSteps aCandidateRegistrationSteps = CandidateRegistrationSteps;
    switch (aCandidateRegistrationSteps)
    {
      case CheckingCandidateData:
        setCandidateRegistrationSteps(CandidateRegistrationSteps.CheckingExistingCandidate);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition592__()
  {
    boolean wasEventProcessed = false;
    
    CandidateRegistrationSteps aCandidateRegistrationSteps = CandidateRegistrationSteps;
    switch (aCandidateRegistrationSteps)
    {
      case CheckingExistingCandidate:
        if (!candidateFound)
        {
          setCandidateRegistrationSteps(CandidateRegistrationSteps.AddingCandidate);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition593__()
  {
    boolean wasEventProcessed = false;
    
    CandidateRegistrationSteps aCandidateRegistrationSteps = CandidateRegistrationSteps;
    switch (aCandidateRegistrationSteps)
    {
      case CheckingExistingCandidate:
        if (candidateFound)
        {
          setCandidateRegistrationSteps(CandidateRegistrationSteps.CandidateExists);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition594__()
  {
    boolean wasEventProcessed = false;
    
    CandidateRegistrationSteps aCandidateRegistrationSteps = CandidateRegistrationSteps;
    switch (aCandidateRegistrationSteps)
    {
      case AddingCandidate:
        if (CandidateService.getInstance().getCandidateAdded())
        {
          setCandidateRegistrationSteps(CandidateRegistrationSteps.CandidateAdded);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition595__()
  {
    boolean wasEventProcessed = false;
    
    CandidateRegistrationSteps aCandidateRegistrationSteps = CandidateRegistrationSteps;
    switch (aCandidateRegistrationSteps)
    {
      case AddingCandidate:
        if (CandidateService.getInstance().getCandidateAdded())
        {
          setCandidateRegistrationSteps(CandidateRegistrationSteps.CandidateNotAdded);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition596__()
  {
    boolean wasEventProcessed = false;
    
    CandidateRegistrationSteps aCandidateRegistrationSteps = CandidateRegistrationSteps;
    switch (aCandidateRegistrationSteps)
    {
      case CandidateAdded:
        setCandidateRegistrationSteps(CandidateRegistrationSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition597__()
  {
    boolean wasEventProcessed = false;
    
    CandidateRegistrationSteps aCandidateRegistrationSteps = CandidateRegistrationSteps;
    switch (aCandidateRegistrationSteps)
    {
      case CandidateNotAdded:
        setCandidateRegistrationSteps(CandidateRegistrationSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition598__()
  {
    boolean wasEventProcessed = false;
    
    CandidateRegistrationSteps aCandidateRegistrationSteps = CandidateRegistrationSteps;
    switch (aCandidateRegistrationSteps)
    {
      case CandidateExists:
        setCandidateRegistrationSteps(CandidateRegistrationSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition599__()
  {
    boolean wasEventProcessed = false;
    
    CandidateRegistrationSteps aCandidateRegistrationSteps = CandidateRegistrationSteps;
    switch (aCandidateRegistrationSteps)
    {
      case ClosingView:
        setCandidateRegistrationSteps(CandidateRegistrationSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setCandidateRegistrationSteps(CandidateRegistrationSteps aCandidateRegistrationSteps)
  {
    CandidateRegistrationSteps = aCandidateRegistrationSteps;

    // entry actions and do activities
    switch(CandidateRegistrationSteps)
    {
      case RegisterCandidateViewShown:
        showRegisterCandidateView();
        break;
      case CheckingCandidateData:
        checkCandidateData();
        __autotransition588__();
        __autotransition589__();
        __autotransition590__();
        __autotransition591__();
        break;
      case CheckingExistingCandidate:
        CandidateService.getInstance().setCandidateNameToSearch(candidateName);
          candidateFound=CandidateService.getInstance().getCandidateFound();
        __autotransition592__();
        __autotransition593__();
        break;
      case AddingCandidate:
        tryToAddCandidate();
        __autotransition594__();
        __autotransition595__();
        break;
      case CandidateAdded:
        JOptionPane.showMessageDialog(null, "Candidate Added Successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
          Controller.getInstance().start();
        __autotransition596__();
        break;
      case CandidateNotAdded:
        JOptionPane.showMessageDialog(null, "Adding Candidate Failed!", "Error!", JOptionPane.ERROR_MESSAGE); Controller.getInstance().start();
        __autotransition597__();
        break;
      case CandidateExists:
        JOptionPane.showMessageDialog(null, "Candidate Exists!", "Error!", JOptionPane.ERROR_MESSAGE);
          Controller.getInstance().start();
          registerCandidateView.dispose();
        __autotransition598__();
        break;
      case CandidateNameEmpty:
        JOptionPane.showMessageDialog(null, "Candidate name cannot be empty!", "Error!", JOptionPane.ERROR_MESSAGE);
        break;
      case CandidateAddressEmpty:
        JOptionPane.showMessageDialog(null, "Candidate address cannot be empty!", "Error!", JOptionPane.ERROR_MESSAGE);
        break;
      case CandidateTelephoneEmpty:
        JOptionPane.showMessageDialog(null, "Candidate telephone cannot be empty!", "Error!", JOptionPane.ERROR_MESSAGE);
        break;
      case ClosingView:
        registerCandidateView.dispose();
        __autotransition599__();
        break;
    }
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private void showRegisterCandidateView() {
    registerCandidateView=new RegisterCandidateView();
    registerCandidateView.setVisible(true);
  }
  
  private void checkCandidateData() {
    candidateName=registerCandidateView.getCandidateName();
    candidateAddress=registerCandidateView.getCandidateAddress();
    candidateTelephone=registerCandidateView.getCandidateTelephone();
  }
  
  private void tryToAddCandidate() {
    Candidate candidate=new Candidate(-1, candidateName, candidateAddress, candidateTelephone);
    CandidateService.getInstance().setNewCandidate(candidate);
    registerCandidateView.dispose();
  }
}