/* EXPERIMENTAL CODE - NON COMPILEABLE VERSION OF C++ */
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

#ifndef STUDENT_H_
#define STUDENT_H_
#include <string>
using namespace std;

class student
{
   //------------------------
  // Attributes for header file
  //------------------------
  private:


  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //student Attributes
  int age;

  //------------------------
  // Constructor
  //------------------------
  public:

   student(const int & aAge);

  
 student(const student & student);
  	
  //------------------------
  // Operator =
  //------------------------

 student operator=(const student & student);

  	  	
  //------------------------
  // INTERFACE
  //------------------------

  bool setAge(const int & aAge);
  int getAge() const;

  //------------------------
  // Destructor
  //------------------------
virtual ~student();

};

#endif