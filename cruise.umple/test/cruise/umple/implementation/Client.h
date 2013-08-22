/* EXPERIMENTAL CODE - NON COMPILEABLE VERSION OF C++ */
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

#ifndef CLIENT_H_
#define CLIENT_H_
#include <string>
using namespace std;

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
  


  public:


  //------------------------
  // Constructor
  //------------------------   Client(const int & aMinAge);

  
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
  int getMinAge() const;

  //------------------------
  // Destructor
  //------------------------
virtual ~Client();

   int someMethod(Integer arg);
};

#endif