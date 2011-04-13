require 'test/unit'
require 'src/student_f'
require 'src/mentor_f'
require 'src/program_f'

module CruiseTest
class OptionalOneToMStarTest < Test::Unit::TestCase

  def test_CreateStudentWithoutMentor
    s = StudentF.new
    assert_equal(nil,s.get_mentor)
  end
  
  def test_ConstructorWithTooFew
  	assert_raise RuntimeError do #"Unable to create MentorF, must have at least 2 students"
      s = StudentF.new
      MentorF.new([s])
    end
  end

  def test_constructorJustBigEnough
    s = StudentF.new
    s2 = StudentF.new

    m = MentorF.new([s,s2])

    assert_equal(2,m.number_of_students)
    assert_equal(m,s.get_mentor)
    assert_equal(m,s2.get_mentor)
  end
  
  def test_constructorWatchOutForDuplicateEntries
  	assert_raise RuntimeError do #"Unable to create MentorF, must have at least 2 students"
      s = StudentF.new
      MentorF.new([s,s])
    end
  end
  
  def test_constructorCheckForExistingMentorNotEnoughToSurvive
  	assert_raise RuntimeError do #"Unable to create MentorF, must have at least 2 students"
      s1 = StudentF.new
      s2 = StudentF.new
      s3 = StudentF.new
      s4 = StudentF.new
    
      m = MentorF.new([s1,s2,s3])

      assert_equal(3, m.number_of_students)
      assert_equal(m, s1.get_mentor)
      assert_equal(m, s2.get_mentor)
      assert_equal(m, s3.get_mentor)    
      assert_equal(nil, s4.get_mentor)    

      MentorF.new([s1,s2,s4])
    end
  end   
  
  def test_constructorCheckForExistingMentorFnoughToShare
    s1 = StudentF.new
    s2 = StudentF.new
    s3 = StudentF.new
    s4 = StudentF.new
    s5 = StudentF.new
    
    m = MentorF.new([s1,s2,s3])

    assert_equal(3, m.number_of_students)
    assert_equal(m, s1.get_mentor)
    assert_equal(m, s2.get_mentor)
    assert_equal(m, s3.get_mentor)    
    assert_equal(nil, s4.get_mentor)    
    assert_equal(nil, s5.get_mentor)

    m2 = MentorF.new([s2,s4,s5])

    assert_equal(2, m.number_of_students)
    assert_equal(3, m2.number_of_students)
    assert_equal(m, s1.get_mentor)
    assert_equal(m2, s2.get_mentor)
    assert_equal(m, s3.get_mentor)    
    assert_equal(m2, s4.get_mentor)    
    assert_equal(m2, s5.get_mentor)
  end   

  def test_set_students_lessThanM
    s = StudentF.new
    s2 = StudentF.new    
    s3 = StudentF.new
    s4 = StudentF.new
    s5 = StudentF.new
    s6 = StudentF.new

    m = MentorF.new([s,s2])
    
    assert_equal(false, m.set_students([s]))
    assert_equal(2,m.number_of_students)
    assert_equal(m,s.get_mentor)
    assert_equal(m,s2.get_mentor)
    assert_equal(nil,s3.get_mentor)
    assert_equal(nil,s4.get_mentor)    
    assert_equal(nil,s5.get_mentor)    
    assert_equal(nil,s6.get_mentor)    
  end

  def test_set_students_aLot
    allStudents = []
    
    for i in 1..100
      allStudents << StudentF.new
    end
    
    m = MentorF.new(allStudents)
    assert_equal(100,m.number_of_students)
  end
  
  

  def test_set_students_atLeastM
  
    s = StudentF.new
    s2 = StudentF.new    
    s3 = StudentF.new
    s4 = StudentF.new

    m = MentorF.new([s,s2])
    
    assert_equal(true, m.set_students([s2, s3, s4]))
    assert_equal(3,m.number_of_students)
    assert_equal(nil,s.get_mentor)
    assert_equal(m,s2.get_mentor)
    assert_equal(m,s3.get_mentor)
    assert_equal(m,s4.get_mentor)    
  end
  
  def test_add_student
  
    s = StudentF.new
    s2 = StudentF.new    
    s3 = StudentF.new
    s4 = StudentF.new
    s5 = StudentF.new
    s6 = StudentF.new

    m = MentorF.new([s,s2,s3,s4])

    assert_equal(true,m.add_student(s5))
    
    assert_equal(5,m.number_of_students)
    assert_equal(m,s.get_mentor)
    assert_equal(m,s2.get_mentor)
    assert_equal(m,s3.get_mentor)
    assert_equal(m,s4.get_mentor)    
    assert_equal(m,s5.get_mentor)    

    assert_equal(true,m.add_student(s6))
    assert_equal(6,m.number_of_students)
  
  end  

  def test_add_studentHasExistingMentor
  
    s = StudentF.new
    s2 = StudentF.new    
    s3 = StudentF.new
    s4 = StudentF.new
    s5 = StudentF.new
    s6 = StudentF.new

    m = MentorF.new([s,s2,s3])
    m2 = MentorF.new([s4,s5,s6])
    
    assert_equal(true,m.add_student(s4))
    
    assert_equal(4,m.number_of_students)
    assert_equal(2,m2.number_of_students)
    
    assert_equal(m,s.get_mentor)
    assert_equal(m,s2.get_mentor)
    assert_equal(m,s3.get_mentor)
    assert_equal(m,s4.get_mentor)    
    assert_equal(m2,s5.get_mentor)    
    assert_equal(m2,s6.get_mentor)

    assert_equal(false,m.add_student(s5))
  end  

  def test_remove_student
  
    s = StudentF.new
    s2 = StudentF.new    
    s3 = StudentF.new
    s4 = StudentF.new

    m = MentorF.new([s,s2,s3])
    
    assert_equal(false,m.remove_student(s4))
    assert_equal(true,m.remove_student(s3))
    assert_equal(2,m.number_of_students)
    
    assert_equal(m,s.get_mentor)
    assert_equal(m,s2.get_mentor)
    assert_equal(nil,s3.get_mentor)
    assert_equal(nil,s4.get_mentor)    

    assert_equal(false,m.remove_student(s2))
    assert_equal(2,m.number_of_students)
  end  

  def test_set_students_empty
    s = StudentF.new
    s2 = StudentF.new
    s3 = StudentF.new
    m = MentorF.new([s,s2,s3])

    assert_equal(false, m.set_students([]))
    assert_equal(3,m.number_of_students)
  end
  
  def test_deletStudentDeletesTheMentorIfNotEnoughLeft
    s1 = StudentF.new
    s2 = StudentF.new

    m = MentorF.new([s1,s2])
    studentP = ProgramF.new
    mentorP = ProgramF.new
    
    s2.set_program(studentP)
    m.set_program(mentorP)

    s1.delete
    
    assert_equal(0,m.number_of_students)
    assert_equal(nil,m.get_program)
    assert_equal(nil,mentorP.get_mentor)
    assert_equal(studentP,s2.get_program)
    assert_equal(nil,s1.get_mentor)
  end  
  
  def test_deleteStudentLeavesMentorAloneIfHasEnough
    s1 = StudentF.new
    s2 = StudentF.new
    s3 = StudentF.new

    m = MentorF.new([s1,s2,s3])
    studentP = ProgramF.new
    mentorP = ProgramF.new
    
    s2.set_program(studentP)
    m.set_program(mentorP)

    s1.delete
    
    assert_equal(2,m.number_of_students)
    assert_equal(mentorP,m.get_program)
    assert_equal(m,mentorP.get_mentor)
    assert_equal(studentP,s2.get_program)
    assert_equal(nil,s1.get_mentor)
  end 
  
end
end