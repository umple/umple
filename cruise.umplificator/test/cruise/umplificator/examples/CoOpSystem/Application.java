/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 12 "CoOpSystem.ump"
// line 81 "CoOpSystem.ump"
public class Application
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Application Associations
  private Student student;
  private Job job;
  private Interview interview;
  private Offer offer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Application(Student aStudent, Job aJob)
  {
    boolean didAddStudent = setStudent(aStudent);
    if (!didAddStudent)
    {
      throw new RuntimeException("Unable to create application due to student");
    }
    boolean didAddJob = setJob(aJob);
    if (!didAddJob)
    {
      throw new RuntimeException("Unable to create application due to job");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Student getStudent()
  {
    return student;
  }

  public Job getJob()
  {
    return job;
  }

  public Interview getInterview()
  {
    return interview;
  }

  public boolean hasInterview()
  {
    boolean has = interview != null;
    return has;
  }

  public Offer getOffer()
  {
    return offer;
  }

  public boolean hasOffer()
  {
    boolean has = offer != null;
    return has;
  }

  public boolean setStudent(Student aStudent)
  {
    boolean wasSet = false;
    if (aStudent == null)
    {
      return wasSet;
    }

    Student existingStudent = student;
    student = aStudent;
    if (existingStudent != null && !existingStudent.equals(aStudent))
    {
      existingStudent.removeApplication(this);
    }
    student.addApplication(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setJob(Job aJob)
  {
    boolean wasSet = false;
    if (aJob == null)
    {
      return wasSet;
    }

    Job existingJob = job;
    job = aJob;
    if (existingJob != null && !existingJob.equals(aJob))
    {
      existingJob.removeApplication(this);
    }
    job.addApplication(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setInterview(Interview aInterview)
  {
    //
    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet
    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because 
    // it's not required (No upper bound)
    //   
    boolean wasSet = false;
    Interview existingInterview = interview;

    if (existingInterview == null)
    {
      if (aInterview != null)
      {
        if (aInterview.addApplication(this))
        {
          existingInterview = aInterview;
          wasSet = true;
        }
      }
    } 
    else if (existingInterview != null)
    {
      if (aInterview == null)
      {
        if (existingInterview.minimumNumberOfApplications() < existingInterview.numberOfApplications())
        {
          existingInterview.removeApplication(this);
          existingInterview = aInterview;  // aInterview == null
          wasSet = true;
        }
      } 
      else
      {
        if (existingInterview.minimumNumberOfApplications() < existingInterview.numberOfApplications())
        {
          existingInterview.removeApplication(this);
          aInterview.addApplication(this);
          existingInterview = aInterview;
          wasSet = true;
        }
      }
    }
    if (wasSet)
    {
      interview = existingInterview;
    }
    return wasSet;
  }
  
  public boolean setOffer(Offer aNewOffer)
  {
    boolean wasSet = false;
    if (offer != null && !offer.equals(aNewOffer) && equals(offer.getApplication()))
    {
      //Unable to setOffer, as existing offer would become an orphan
      return wasSet;
    }

    offer = aNewOffer;
    Application anOldApplication = aNewOffer != null ? aNewOffer.getApplication() : null;

    if (!this.equals(anOldApplication))
    {
      if (anOldApplication != null)
      {
        anOldApplication.offer = null;
      }
      if (offer != null)
      {
        offer.setApplication(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Student placeholderStudent = student;
    this.student = null;
    placeholderStudent.removeApplication(this);
    Job placeholderJob = job;
    this.job = null;
    placeholderJob.removeApplication(this);
    if (interview != null)
    {
      if (interview.numberOfApplications() <= 1)
      {
        interview.delete();
      }
      else
      {
        Interview placeholderInterview = interview;
        this.interview = null;
        placeholderInterview.removeApplication(this);
      }
    }
    Offer existingOffer = offer;
    offer = null;
    if (existingOffer != null)
    {
      existingOffer.delete();
    }
  }

}