/* EXPERIMENTAL CODE - NON COMPILEABLE VERSION OF C++ */
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

#include "Client.h"

	
  //------------------------
  // CONSTRUCTOR
  //------------------------
  
 Client::Client(const int & aMinAge)
  {
    minAge = aMinAge;
  }
  
  //------------------------
  // COPY CONSTRUCTOR
  //------------------------

 Client::Client(const Client & client)
  {
    this->minAge = client.minAge;
  }
  	
  //------------------------
  // Operator =
  //------------------------

 Client Client::operator=(const Client & client)
  {
    this->minAge = client.minAge;
  }

  //------------------------
  // INTERFACE
  //------------------------

  bool Client::setMinAge(const int & aMinAge)
  {
    bool wasSet = false;
    minAge = aMinAge;
    wasSet = true;
    return wasSet;
  }

  int Client::getMinAge() const
  {
    return minAge;
  }

  
  //------------------------
  // DESTRUCTOR
  //------------------------
  
Client::~Client()
  {}

   int Client::someMethod(Integer arg){

      if( !(arg>5))
        {
        throw "Please provide a valid arg";
        }
      if( !(minAge<8))
        {
        throw "Please provide a valid minAge";
        }
      // rest of stuff that we don't interpret
 return 0;
  }

