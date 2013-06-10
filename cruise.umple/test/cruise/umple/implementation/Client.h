/* EXPERIMENTAL CODE - NON COMPILEABLE VERSION OF C++ */
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

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

  //------------------------
  // Constructor
  //------------------------
  public:

   Client(const int & aMinAge);

  
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