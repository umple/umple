import java.util.*;

class Supervisor extends Person
{
   List<Student> mentees = new ArrayList<Student>();
   
   Supervisor() {}

   public String toString() {
      return(
         (name==null ? " " : name) + " " +
         mentees.size()+ " mentees"
      );
   }
}

