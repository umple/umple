  new Test.Unit.Runner({
    
    setup: function() {
    },
    
    teardown: function() {
      
    },
    
    test_format: function() 
    { with(this) {
      assertEqual("abc",format("abc"));
      assertEqual("abc {0} def",format("abc {0} def"));
      assertEqual("abc 123 def",format("abc {0} def",123));
      assertEqual("abc 123 def",format("abc {0} def",123,456));
      assertEqual("123 abc {0} 789 def 456",format("{0} abc {0} {2} def {1}",123,456,789));
    }},

    test_round: function() 
    { with(this) {
      assertEqual(0,roundTo(4,1));
      assertEqual(10,roundTo(6,1));
      assertEqual(10,roundTo(11,1));
      assertEqual(20,roundTo(15,1));
      
      assertEqual(0,roundTo(0.04,-1));
      assertEqual(0.1,roundTo(0.06,-1));
      assertEqual(0.1,roundTo(0.11,-1));
      assertEqual(0.2,roundTo(0.16,-1));      
    }},



    
  },{testLog: "helpertestlog"}); 
