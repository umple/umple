module ExampleLoaderHelper
  
  CLASS_EXAMPLES = {
  "2DShapes.ump" => ["Shape2D", "EllipticalShape", "EllipticalShape_generalization"],
  "AccessControl.ump" => ["FunctionalArea", "User", "umpleAssociation_5"],
  "AccessControl2.ump" => ["User", "umpleAssociation_11", "Door"],
  "Accidents.ump" => ["Accident", "umpleAssociation_2", "SeriousnessLevel"],
  "Accommodations.ump" => ["UnitBooking", "umpleAssociation_7", "ViewUnitStatus"],
  "AfghanRainDesign.ump" => ["SurveyObservation", "umpleAssociation_9", "Farm"],
  "AirlineExample.ump" => ["PersonRole", "PassengerRole_generalization", "umpleAssociation_7"],
  "BankingSystemA.ump" => ["Employee", "Client_generalization", "umpleAssociation_8"],
  "BankingSystemB.ump" => ["Bank", "BankAccount_generalization", "umpleAssociation_5"],
  "CanalSystem.ump" => ["SegEnd", "Bend_generalization", "umpleAssociation_8"],
  "Decisions.ump" => ["Person", "Comment_generalization", "umpleAssociation_21"],
  "OhHellWhist.ump" => ["Card", "Trick_generalization", "umpleAssociation_8"],
  "Claim.ump" => ["Claim", "Clamor", "umpleAssociation_0"],
  "CommunityAssociation.ump" => ["CommunityResidence", "Rink_generalization", "umpleAssociation_5"],
  "Compositions.ump" => ["Composition", "", ""],
  "CoOpSystem.ump" => ["Job", "Resume", "umpleAssociation_11"],
  "DMMOverview.ump" => ["SourceObject", "SourceRelationship_generalization", "umpleAssociation_6"],
  "DMMSourceObjectHierarchy.ump" => ["Contains", "SourceUnit_generalization", "umpleAssociation_7"],
  "DMMRelationshipHierarchy.ump" => ["SourceRelationship", "Uses_generalization", "TakesAddressOf"],
  "DMMExtensionCTF.ump" => ["Trace", "RoutineCallTrace_generalization", "umpleAssociation_10"],
  "ElectionSystem.ump" => ["Voter", "Candidate", "umpleAssociation_13"],
  "ElevatorSystemA.ump" => ["Bank", "Floor", "umpleAssociation_5"],
  "ElevatorSystemB.ump" => ["Button", "ConsoleCallButton_generalization", "umpleAssociation_8"],
  "GenealogyA.ump" => ["Person", "Union", "umpleAssociation_1"],
  "GenealogyB.ump" => ["Person", "Union", "umpleAssociation_2"],
  "GenealogyC.ump" => ["Person", "Adoption", "umpleAssociation_3"],
  "GeographicalInformationSystem.ump" => ["FeatureType", "RegionFeatureType_generalization", "umpleAssociation_5"],
  "Hospital.ump" => ["Shift", "Janitor_generalization", "umpleAssociation_5"],
  "Hotel.ump" => ["HotelCompany", "MeetingRoom_generalization", "umpleAssociation_6"],
  "Insurance.ump" => ["Transaction", "Renewal_generalization", "umpleAssociation_4"],
  "InventoryManagement.ump" => ["ProductSource", "ReceivedDelivery", "umpleAssociation_7"],
  "Library.ump" => ["Author", "IssueOfPeriodical_generalization", "umpleAssociation_5"],
  "MailOrderSystemClientOrder.ump" => ["Product", "Client", "umpleAssociation_7"],
  "ManufacturingPlantController.ump" => ["ProductRun", "Robot", "umpleAssociation_15"],
  "Pizza.ump" => ["Driver", "DrinkOrder_generalization", "umpleAssociation_5"],
  "PoliceSystem.ump" => ["CrimeOccurrence", "Victim_generalization", "umpleAssociation_10"],
  "PoliticalEntities.ump" => ["Territory", "Country_generalization", "umpleAssociation_2"],
  "realestate.ump" => ["Address", "Agent", "umpleAssociation_7"],
  "RoutesAndLocations.ump" => ["RoadSegment", "Intersection_generalization", "umpleAssociation_11"],
  "School.ump" => ["Person", "School", "umpleAssociation_0"],
  "TelephoneSystem.ump" => ["VoiceMailBox", "Telephone", "umpleAssociation_7"],
  "UniversitySystem.ump" => ["Topic", "MutualExclusionReason", "umpleAssociation_5"],
  "VendingMachineClassDiagram.ump" => ["ProductTransaction", "CoinType", "umpleAssociation_7"],
  "WarehouseSystem.ump" => ["MovementLocation", "SlotSet_generalization", "umpleAssociation_12"]
}

STATE_EXAMPLES = {
  "AgentsCommunication.ump" => ["clust2", "node12", "edge10"],
  "ApplicationProcessing.ump" => ["edge24", "node11"],
  "Booking.ump" => ["node6", "edge7"],
  "CanalLockStateMachine.ump" => ["node10", "edge17"],
  "CarTransmission.ump" => ["clust1", "edge16", "node9"],
  "ComplexStateMachine.ump" => ["clust3", "edge17", "node10"],
  "CourseSectionFlat.ump" => ["edge12", "node6"],
  "CourseSectionNested.ump" => ["clust1", "edge14", "node9"],
  "DigitalWatchNested.ump" => ["clust7", "edge47", "node25"],
  "DigitalWatchFlat.ump" => ["node20", "edge53"],
  "Elevator_State_Machine.ump" => ["clust4", "node14", "edge23"],
  "GarageDoor.ump" => ["node6", "edge8"],
  "LibraryLoanStateMachine.ump" => ["node7", "edge11"],
  "Lights.ump" => ["clust6", "edge29", "node21"],
  "MicrowaveOven2.ump" => ["edge13", "node7"],
  "Ovens.ump" => ["clust6", "edge19", "node20"],
  "ParliamentBill.ump" => ["clust2", "edge17", "node14"],
  "Phone.ump" => ["edge18", "node7"],
  "Runway.ump" => ["clust5", "edge18", "node12"],
  "SecurityLight.ump" => ["clust1", "edge8", "node6"],
  "SpecificFlight.ump" => ["clust1", "node11", "edge14"],
  "SpecificFlightFlat.ump" => ["edge18", "node10"],
  "TcpIpSimulation.ump" => ["node12", "edge18"],
  "TelephoneSystem2.ump" => ["clust3", "edge22", "node10"],
  "TicTacToe.ump" => ["edge7", "node5"],
  "TollBooth.ump" => ["clust2", "edge19", "node11"],
  "TrafficLightsA.ump" => ["edge10", "node6"],
  "TrafficLightsB.ump" => ["clust6", "node30", "edge24"],
  "HomeHeater.ump" => ["edge23", "node37"]
}

COMPOSITE_STRUCTURES_EXAMPLES = {
  "OBDCarSystem.ump" => ["svgCanvas"],
  "PingPong.ump" => ["svgCanvas"]
}

  def switch_to_class_examples
    select("Class Diagrams", :from => "inputExampleType")
  end

  def switch_to_state_examples
    select("State Machines", :from => "inputExampleType")
  end

  def switch_to_compound_structure_examples
    select("Composite Structure", :from => "inputExampleType")
  end

  def check_class_example(example_name)
    select_option_by_value("#inputExampleType", "cdModels")
    select_option_by_value("#inputExample", example_name)

    wait_for_loading

    #include is used here because the website adds the model delimiter to the
    #end of the code, which is not present in the source file for the diagram
    expect(evaluate_script("Page.getUmpleCode()"))
      .to include(get_example_contents(example_name))

    CLASS_EXAMPLES[example_name].each do |element|
      expect(find(:css, "#umpleCanvas")).to have_selector("##{element}")
    end
  end

  def check_state_example(example_name)
    select_option_by_value("#inputExampleType", "smModels")
    select_option_by_value("#inputExample2", example_name)
    
    wait_for_loading 
    
    #include is used here because the website adds the model delimiter to the
    #end of the code, which is not present in the source file for the diagram
    expect(evaluate_script("Page.getUmpleCode()"))
      .to include(get_example_contents(example_name))

    STATE_EXAMPLES[example_name].each do |element|
      expect(find(:css, "#umpleCanvas")).to have_selector("##{element}")
    end
  end

  def check_comp_structure_example(example_name)
    select_option_by_value("#inputExampleType", "structureModels")
    select_option_by_value("#inputExample3", example_name)

    wait_for_loading
    expect(evaluate_script("Page.getUmpleCode()"))
      .to include(get_example_contents(example_name))
  
    COMPOSITE_STRUCTURES_EXAMPLES[example_name].each do |element|
      expect(find(:css, "#umpleCanvas")).to have_selector("##{element}")
    end
  end

  def get_example_contents(filename)
    return get_file_contents(filename, TestUtils::EXAMPLE_DIRECTORY)
  end
end
