package cruise.umple.compiler;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;

public class UmpleSystemExamplesTest
{

  @Test
  public void Airline()
  {
    String path = SampleFileWriter.rationalize("test/data/Airline");
    run(path, "AirlineExample.ump");
  }

  @Test
  public void Election()
  {
    String path = SampleFileWriter.rationalize("test/data/Election");
    run(path, "ElectionSystem.ump");
  }

  @Test
  public void BankingSystemA()
  {
    String path = SampleFileWriter.rationalize("test/data/Banking/a");
    run(path, "BankingSystemA.ump");
  }

  @Test
  public void BankingSystemB()
  {
    String path = SampleFileWriter.rationalize("test/data/Banking/b");
    run(path, "BankingSystemB.ump");
  }

  @Test
  public void Warehouse()
  {
    String path = SampleFileWriter.rationalize("test/data/Warehouse");
    run(path, "WarehouseSystem.ump");
  }

  @Test
  // Test has been reviewed and fixed. Errors in implementation
  public void ElevatorA()
  {
    String path = SampleFileWriter.rationalize("test/data/Elevator/a");
    run(path, "ElevatorSystemA.ump");
  }

  @Test
  // Test has been reviewed and fixed. Errors in test
  public void ElevatorB()
  {
    String path = SampleFileWriter.rationalize("test/data/Elevator/b");
    run(path, "ElevatorSystemB.ump");
  }

  @Test
  public void Test2DShapes()
  {
    String path = SampleFileWriter.rationalize("test/data/2DShapes");
    run(path, "2DShapes.ump");
  }

  @Test
  public void GenealogyA()
  {
    String path = SampleFileWriter.rationalize("test/data/Genealogy/a");
    run(path, "GenealogyA.ump");
  }

  @Test
  public void GenealogyB()
  {
    String path = SampleFileWriter.rationalize("test/data/Genealogy/b");
    run(path, "GenealogyB.ump");
  }

  @Test
  public void GenealogyC()
  {
    String path = SampleFileWriter.rationalize("test/data/Genealogy/c");
    run(path, "GenealogyC.ump");
  }

  @Test
  public void InventoryAndOrders_ClientOrders()
  {
    String path = SampleFileWriter.rationalize("test/data/InventoryAndOrders/ClientOrder");
    run(path, "MailOrderSystemClientOrder.ump");
  }

  @Test
  public void InventoryAndOrders_InventoryManagement()
  {
    String path = SampleFileWriter.rationalize("test/data/InventoryAndOrders/InventoryManagement");
    run(path, "InventoryManagement.ump");
  }

  @Test
  public void InventoryAndOrders_System()
  {
    String path = SampleFileWriter.rationalize("test/data/InventoryAndOrders/System");
    run(path, "MailOrderSystem.ump");
  }

  @Test
  public void Policy()
  {
    String path = SampleFileWriter.rationalize("test/data/Police");
    run(path, "PoliceSystem.ump");
  }

  @Test
  public void University()
  {
    String path = SampleFileWriter.rationalize("test/data/University");
    run(path, "UniversitySystem.ump");
  }

  @Test
  public void PoliciticalEntities()
  {
    String path = SampleFileWriter.rationalize("test/data/PoliticalEntities");
    run(path, "PoliticalEntities.ump");
  }

  @Test
  public void GeogrphicalInfo()
  {
    String path = SampleFileWriter.rationalize("test/data/GeographicalInfo");
    run(path, "GeographicalInformationSystem.ump");
  }

  @Test
  public void ManufacturingPlant()
  {
    String path = SampleFileWriter.rationalize("test/data/ManufacturingPlant");
    run(path, "ManufactoringPlantController.ump");
  }

  @Test
  public void Library()
  {
    String path = SampleFileWriter.rationalize("test/data/Library");
    run(path, "Library.ump");
  }

  @Test
  public void Hotel()
  {
    String path = SampleFileWriter.rationalize("test/data/Hotel");
    run(path, "Hotel.ump");
  }

  @Test
  public void Insurance()
  {
    String path = SampleFileWriter.rationalize("test/data/Insurance");
    run(path, "Insurance.ump");
  }

  @Test
  public void TelephoneSystem()
  {
    String path = SampleFileWriter.rationalize("test/data/TelephoneSystem");
    run(path, "TelephoneSystem.ump");
  }

  @Test
  public void AccessControl()
  {
    String path = SampleFileWriter.rationalize("test/data/AccessControl");
    run(path, "AccessControl.ump");

  }

  @Test
  public void Accidents()
  {
    String path = SampleFileWriter.rationalize("test/data/Accidents");
    run(path, "Accidents.ump");

  }

  @Test
  public void Accommodations()
  {
    String path = SampleFileWriter.rationalize("test/data/Accommodations");
    run(path, "Accommodations.ump");

  }

  @Test
  public void AfghanRainDesign()
  {
    String path = SampleFileWriter.rationalize("test/data/AfghanRainDesign");
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
