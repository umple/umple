require 'test/unit'
require './src-gen-umple/student_e'
require './src-gen-umple/mentor_e'
require './src-gen-umple/program_e'

module CruiseTest
class OptionalOneToMNTest < Test::Unit::TestCase

  def test_CreateStudentWithoutMentor
    s = StudentE.new
    assert_equal(nil,s.get_mentor)
  end
  
  def test_ConstructorWithTooFew
    assert_raise RuntimeError do #"Unable to create MentorE, must have 2 to 5 students"
      s = StudentE.new
      MentorE.new([s])
    end
  end
  
  def test_ConstructorWithTooMany
    assert_raise RuntimeError do #"Unable to create MentorE, must have 2 to 5 students"
      s = StudentE.new
      s2 = StudentE.new    
      s3 = StudentE.new
      s4 = StudentE.new
      s5 = StudentE.new
      s6 = StudentE.new
      MentorE.new([s,s2,s3,s4,s5,s6])
    end
  end
  
  def test_constructorJustBigEnough
    s = StudentE.new
    s2 = StudentE.new
  
    m = MentorE.new([s,s2])
    
    assert_equal(2,m.number_of_students)
    assert_equal(m,s.get_mentor)
    assert_equal(m,s2.get_mentor)
  end
  
  def test_constructorJustSmallEnough
    s = StudentE.new
    s2 = StudentE.new    
    s3 = StudentE.new
    s4 = StudentE.new
    s5 = StudentE.new
  
    m = MentorE.new([s,s2,s3,s4,s5])
  
    assert_equal(5,m.number_of_students)
    assert_equal(m,s.get_mentor)
    assert_equal(m,s2.get_mentor)
    assert_equal(m,s3.get_mentor)
    assert_equal(m,s4.get_mentor)
    assert_equal(m,s5.get_mentor)
  end  
  
  def test_constructorWatchOutForDuplicateEntries
    assert_raise RuntimeError do #"Unable to create MentorE, must have 2 to 5 students"
      s = StudentE.new
      MentorE.new([s,s])
    end
  end
  
  def test_constructorCheckForExistingMentorNotEnoughToSurvive
    assert_raise RuntimeError do #"Unable to create MentorE, must have 2 to 5 students"
      s1 = StudentE.new
      s2 = StudentE.new
      s3 = StudentE.new
      s4 = StudentE.new
    
      m = MentorE.new([s1,s2,s3])
  
      assert_equal(3, m.number_of_students)
      assert_equal(m, s1.get_mentor)
      assert_equal(m, s2.get_mentor)
      assert_equal(m, s3.get_mentor)    
      assert_equal(nil, s4.get_mentor)    
  
      MentorE.new([s1,s2,s4])
    end
  end   
  
  def test_constructorCheckForExistingMentorEnoughToShare
    s1 = StudentE.new
    s2 = StudentE.new
    s3 = StudentE.new
    s4 = StudentE.new
    s5 = StudentE.new
    
    m = MentorE.new([s1,s2,s3])
  
    assert_equal(3, m.number_of_students)
    assert_equal(m, s1.get_mentor)
    assert_equal(m, s2.get_mentor)
    assert_equal(m, s3.get_mentor)    
    assert_equal(nil, s4.get_mentor)    
    assert_equal(nil, s5.get_mentor)
  
    m2 = MentorE.new([s2,s4,s5])
  
    assert_equal(2, m.number_of_students)
    assert_equal(3, m2.number_of_students)
    assert_equal(m, s1.get_mentor)
    assert_equal(m2, s2.get_mentor)
    assert_equal(m, s3.get_mentor)    
    assert_equal(m2, s4.get_mentor)    
    assert_equal(m2, s5.get_mentor)
  end   
  
  
  
  def test_set_students_outsideNM
    s = StudentE.new
    s2 = StudentE.new    
    s3 = StudentE.new
    s4 = StudentE.new
    s5 = StudentE.new
    s6 = StudentE.new
  
    m = MentorE.new([s,s2])
    
    assert_equal(false, m.set_students([s, s2, s3, s4, s5, s6]))
    assert_equal(2,m.number_of_students)
    assert_equal(m,s.get_mentor)
    assert_equal(m,s2.get_mentor)
    assert_equal(nil,s3.get_mentor)
    assert_equal(nil,s4.get_mentor)    
    assert_equal(nil,s5.get_mentor)    
    assert_equal(nil,s6.get_mentor)    
  
    assert_equal(false, m.set_students([s]))
    assert_equal(2,m.number_of_students)
    assert_equal(m,s.get_mentor)
    assert_equal(m,s2.get_mentor)
    assert_equal(nil,s3.get_mentor)
    assert_equal(nil,s4.get_mentor)    
    assert_equal(nil,s5.get_mentor)    
    assert_equal(nil,s6.get_mentor)    
  end
  
  def test_set_students_withinNM
    s = StudentE.new
    s2 = StudentE.new    
    s3 = StudentE.new
    s4 = StudentE.new
  
    m = MentorE.new([s,s2])
    
    assert_equal(true, m.set_students([s2, s3, s4]))
    assert_equal(3,m.number_of_students)
    assert_equal(s2,m.get_student(0))
    assert_equal(s3,m.get_student(1))
    assert_equal(s4,m.get_student(2))
  
    assert_equal(nil,s.get_mentor)
    assert_equal(m,s2.get_mentor)
    assert_equal(m,s3.get_mentor)
    assert_equal(m,s4.get_mentor)    
  end
  
  def test_add_student
    s = StudentE.new
    s2 = StudentE.new    
    s3 = StudentE.new
    s4 = StudentE.new
    s5 = StudentE.new
    s6 = StudentE.new
  
    m = MentorE.new([s,s2,s3,s4])
  
    assert_equal(true,m.add_student(s5))
    
    assert_equal(5,m.number_of_students)
    assert_equal(m,s.get_mentor)
    assert_equal(m,s2.get_mentor)
    assert_equal(m,s3.get_mentor)
    assert_equal(m,s4.get_mentor)    
    assert_equal(m,s5.get_mentor)    
  
    assert_equal(false,m.add_student(s6))
    assert_equal(5,m.number_of_students)
  end  
  
  def test_add_studentHasExistingMentor
    s = StudentE.new
    s2 = StudentE.new    
    s3 = StudentE.new
    s4 = StudentE.new
    s5 = StudentE.new
    s6 = StudentE.new
  
    m = MentorE.new([s,s2,s3])
    m2 = MentorE.new([s4,s5,s6])
    
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
    s = StudentE.new
    s2 = StudentE.new    
    s3 = StudentE.new
    s4 = StudentE.new
  
    m = MentorE.new([s,s2,s3])
    
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
    s = StudentE.new
    s2 = StudentE.new
    s3 = StudentE.new
    m = MentorE.new([s,s2,s3])
  
    assert_equal(false, m.set_students([]))
    assert_equal(3,m.number_of_students)
  end
  
  def test_deletStudentDeletesTheMentorIfNotEnoughLeft
    s1 = StudentE.new
    s2 = StudentE.new
  
    m = MentorE.new([s1,s2])
    studentP = ProgramE.new
    mentorP = ProgramE.new
    
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
    s1 = StudentE.new
    s2 = StudentE.new
    s3 = StudentE.new
  
    m = MentorE.new([s1,s2,s3])
    studentP = ProgramE.new
    mentorP = ProgramE.new
    
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