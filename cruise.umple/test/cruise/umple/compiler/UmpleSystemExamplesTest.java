/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;



import org.junit.*;



import cruise.umple.util.SampleFileWriter;



public class UmpleSystemExamplesTest

{



  @Test

  public void Airline()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "AirlineExample.ump");

  }



  @Test

  public void Election()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "ElectionSystem.ump");

  }



  @Test

  public void BankingSystemA()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "BankingSystemA.ump");

  }



  @Test

  public void BankingSystemB()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "BankingSystemB.ump");

  }



  @Test

  public void Warehouse()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "WarehouseSystem.ump");

  }



  @Test

  // Test has been reviewed and fixed. Errors in implementation

  public void ElevatorA()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "ElevatorSystemA.ump");

  }



  @Test

  // Test has been reviewed and fixed. Errors in test

  public void ElevatorB()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "ElevatorSystemB.ump");

  }



  @Test

  public void Test2DShapes()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "2DShapes.ump");

  }



  @Test

  public void GenealogyA()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "GenealogyA.ump");

  }



  @Test

  public void GenealogyB()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "GenealogyB.ump");

  }



  @Test

  public void GenealogyC()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "GenealogyC.ump");

  }



  @Test

  public void InventoryAndOrders_ClientOrders()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "MailOrderSystemClientOrder.ump");

  }



  @Test

  public void InventoryAndOrders_InventoryManagement()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "InventoryManagement.ump");

  }



  @Test

  public void InventoryAndOrders_System()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "MailOrderSystem.ump");

  }



  @Test

  public void Policy()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "PoliceSystem.ump");

  }



  @Test

  public void University()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "UniversitySystem.ump");

  }



  @Test

  public void PoliciticalEntities()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "PoliticalEntities.ump");

  }



  @Test

  public void GeogrphicalInfo()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "GeographicalInformationSystem.ump");

  }



  @Test

  public void ManufacturingPlant()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "ManufactoringPlantController.ump");

  }



  @Test

  public void Library()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "Library.ump");

  }



  @Test

  public void Hotel()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "Hotel.ump");

  }



  @Test

  public void Insurance()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "Insurance.ump");

  }



  @Test

  public void TelephoneSystem()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "TelephoneSystem.ump");

  }



  @Test

  public void AccessControl()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "AccessControl.ump");



  }



  @Test

  public void Accidents()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "Accidents.ump");



  }



  @Test

  public void Accommodations()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "Accommodations.ump");



  }



  @Test

  public void AfghanRainDesign()

  {

    String path = SampleFileWriter.rationalize("../umpleonline/ump");

    run(path, "AfghanRainDesign.ump");

  }

  

  

  private UmpleModel run(String path, String filename)

  {

    UmpleModel us = new UmpleModel(new UmpleFile(path, filename));

    us.setShouldGenerate(false);

    us.run();

    return us;

  }



}

