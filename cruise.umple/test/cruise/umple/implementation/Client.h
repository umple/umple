/* EXPERIMENTAL CODE - NON COMPILEABLE VERSION OF C++ */
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

#ifndef CLIENT_H_
#define CLIENT_H_
#include <string>
using namespace std;

// attributes on both sides of the constraint's boolean expression
class Client
{
   //------------------------
  // Attributes for header file
  //------------------------
  private:


  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Client Attributes
  int minAge;
  int age;
  


  public:


  //------------------------
  // Constructor
  //------------------------   Client(const int & aMinAge, const int & aAge);

  
  //------------------------
  // Copy Constructor
  //------------------------

 Client(const Client & client);
  	
  //------------------------
  // Operator =
  //------------------------

 Client operator=(const Client & client);

  	  	
  //------------------------
  // INTERFACE
  //------------------------

  bool setMinAge(const int & aMinAge);
  bool setAge(const int & aAge);
  int getMinAge() const;

  int getAge() const;

  //------------------------
  // Destructor
  //------------------------
virtual ~Client();

};

#endif