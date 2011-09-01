class Test {
   Student student1 = new Student(null,100);
   Student student2 = new Student(null,200);
   Supervisor supervisor1 = new Supervisor(null);
   Supervisor supervisor2 = new Supervisor(null);

   public static void main(String [ ] args) {

     // Test 1 set up initial students
     Test t=new Test();
     t.student1.setName("Foo");
     t.student2.setName("Bar");
     t.supervisor1.setName("Alice");
     t.supervisor2.setName("Charlie");
     t.printTest("Test 1: Initial setting", true);

     t.printTest("Test 2: Add a supervisor should fail since not enrolled",
        !t.student1.setSupervisor(t.supervisor1));

     t.student1.enrol();
     t.printTest("Test 3: After enrolling should be able to add supervisor",
        t.student1.setSupervisor(t.supervisor1));

     t.printTest("Test 4: Can't change supervisor; must delete first",
        !t.student1.setSupervisor(t.supervisor2));

     t.student2.enrol();
     t.printTest("Test 5: Second student can have same supervisor",
        t.student2.setSupervisor(t.supervisor1));

     t.student1.setSupervisor(null);
     t.printTest("Test 6: Change supervisor",
        t.student1.setSupervisor(t.supervisor2));

     t.student1.graduate();
     t.student2.quit();
     t.printTest("Test 7: Final after graduation",true);
   }

   void printTest(String s, boolean testResult) {
      System.out.println((testResult ? "Passed " : "Failed ")+s);
      System.out.println("Student 1 "+student1);
      System.out.println("Student 2 "+student2);
      System.out.println("Supervisor 1 "+supervisor1);
      System.out.println("Supervisor 2 "+supervisor2);
      System.out.println("");
   }
}
