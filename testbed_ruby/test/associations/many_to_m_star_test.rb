require 'test/unit'
require './src-gen-umple/student_r'
require './src-gen-umple/mentor_r'
require './src-gen-umple/program_r'

module CruiseAssociations
class ManyToMStarTest < Test::Unit::TestCase

  def test_CreateStudentWithoutMentor
    s = StudentR.new(99)
    assert_equal(0,s.number_of_mentors)
  end
  
  def test_ConstructorWithTooFew
    assert_raise RuntimeError do #"Unable to create MentorR, must have at least 3 students"
      s = StudentR.new(99)
      MentorR.new("blah",[s])
    end
  end
  
  
  def test_ConstructorCannotHaveTooMany
    s = StudentR.new(99)
    s2 = StudentR.new(98)    
    s3 = StudentR.new(97)
    s4 = StudentR.new(96)
    s5 = StudentR.new(95)
    s6 = StudentR.new(94)
    s7 = StudentR.new(93)
    s8 = StudentR.new(92)
    MentorR.new("blah",[s,s2,s3,s4,s5,s6,s7,s8])
  end
  
  def test_constructorJustBigEnough
    s = StudentR.new(99)
    s2 = StudentR.new(98)    
    s3 = StudentR.new(97)
  
    m = MentorR.new("blah",[s,s2,s3])
  
    assert_equal(3,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
  end
  
  
  def test_constructorMoreThanBigEnough
    s = StudentR.new(99)
    s2 = StudentR.new(98)    
    s3 = StudentR.new(97)
    s4 = StudentR.new(96)
  
    m = MentorR.new("blah",[s,s2,s3,s4])
  
    assert_equal(4,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(m,s4.get_mentor(0))
  end  
  
  def test_constructorWatchOutForDuplicateEntries
    assert_raise RuntimeError do #"Unable to create MentorR, must have at least 3 students"
      s = StudentR.new(99)
      MentorR.new("blah",[s,s])
    end
  end
  
  
  def test_constructorExistingMentorsOkay
    s = StudentR.new(99)
    s2 = StudentR.new(98)    
    s3 = StudentR.new(97)
    s4 = StudentR.new(96)
    
    m = MentorR.new("blah",[s,s2,s3])
  
    assert_equal(3, m.number_of_students)
    assert_equal(m, s.get_mentor(0))
    assert_equal(m, s2.get_mentor(0))
    assert_equal(m, s3.get_mentor(0))
    assert_equal(0, s4.number_of_mentors)    
  
    m2 = MentorR.new("blah",[s,s2,s4])
    
    assert_equal(3, m.number_of_students)
    assert_equal(m, s.get_mentor(0))
    assert_equal(m, s2.get_mentor(0))
    assert_equal(m, s3.get_mentor(0))
    
    assert_equal(3, m2.number_of_students)
    assert_equal(m2, s.get_mentor(1))
    assert_equal(m2, s2.get_mentor(1))
    assert_equal(m2, s4.get_mentor(0))
  
  end   
  
  
  def test_set_students_tooFew
    s = StudentR.new(99)
    s2 = StudentR.new(98)    
    s3 = StudentR.new(97)
    s4 = StudentR.new(96)
    s5 = StudentR.new(95)
  
    m = MentorR.new("blah",[s,s2,s3])
    
    assert_equal(false, m.set_students([s5,s4]))
    assert_equal(3,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(0,s4.number_of_mentors)
    assert_equal(0,s5.number_of_mentors)
  end
  
  
  def test_set_students_doNotAllowDuplicates
    s = StudentR.new(99)
    s2 = StudentR.new(98)    
    s3 = StudentR.new(97)
    
    m = MentorR.new("blah",[s,s2,s3])
    assert_equal(false, m.set_students([s2,s2,s3]))
  end
  
  
  def test_set_students_aboveMinimum
    s = StudentR.new(99)
    s2 = StudentR.new(98)    
    s3 = StudentR.new(97)
    s4 = StudentR.new(96)
  
    m = MentorR.new("blah",[s,s2,s3])
    
    assert_equal(true, m.set_students([s2,s3,s4]))
    assert_equal(3,m.number_of_students)
    assert_equal(0,s.number_of_mentors)
  
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(m,s4.get_mentor(0))    
  end
  
  
  def test_add_mentorNeverTooMany
    s = StudentR.new(99)
    s2 = StudentR.new(98)    
    s3 = StudentR.new(97)
    s4 = StudentR.new(96)
    s5 = StudentR.new(95)
  
    m = MentorR.new("blah",[s,s2,s3,s4])
    
    assert_equal(true,s5.add_mentor(m))
    assert_equal(5,m.number_of_students)
    assert_equal(1,s5.number_of_mentors)
    
  end
  
  
  def test_add_student
    s = StudentR.new(99)
    s2 = StudentR.new(98)    
    s3 = StudentR.new(97)
    s4 = StudentR.new(96)
    s5 = StudentR.new(95)
  
    m = MentorR.new("blah",[s,s2,s3])
  
    assert_equal(true,m.add_student(s4))
    
    assert_equal(4,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(m,s4.get_mentor(0))    
   
    assert_equal(true,m.add_student(s5))
    assert_equal(5,m.number_of_students)
  
  end  
  
  def test_add_studentHasExistingMentor
    s = StudentR.new(99)
    s2 = StudentR.new(98)    
    s3 = StudentR.new(97)
    s4 = StudentR.new(96)
    s5 = StudentR.new(95)
    s6 = StudentR.new(94)
  
    m = MentorR.new("blah",[s,s2,s3])
    m2 = MentorR.new("blah2",[s4,s5,s6])
  
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    
    assert_equal(m2,s4.get_mentor(0))
    assert_equal(m2,s5.get_mentor(0))
    assert_equal(m2,s6.get_mentor(0))
    
    assert_equal(true,m.add_student(s4))
    
    assert_equal(4,m.number_of_students)
    assert_equal(3,m2.number_of_students)
    
    assert_equal(2,s4.number_of_mentors)    
    assert_equal(m2,s4.get_mentor(0))    
    assert_equal(m,s4.get_mentor(1))
  
    assert_equal(true,m.add_student(s5))
  end  
  
  def test_remove_student
    s = StudentR.new(99)
    s2 = StudentR.new(98)    
    s3 = StudentR.new(97)
    s4 = StudentR.new(96)
    s5 = StudentR.new(95)
  
    m = MentorR.new("blah",[s,s2,s3,s5])
    
    assert_equal(false,m.remove_student(s4))
    assert_equal(true,m.remove_student(s3))
    
    assert_equal(3,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(0,s3.number_of_mentors)
    assert_equal(0,s4.number_of_mentors)   
    assert_equal(m,s5.get_mentor(0))
  
    assert_equal(false,m.remove_student(s2))
    assert_equal(3,m.number_of_students)
  end  
  
  
  def test_set_students_empty
    s = StudentR.new(99)
    s2 = StudentR.new(98)    
    s3 = StudentR.new(97)
  
    m = MentorR.new("blah",[s,s2,s3])
  
    assert_equal(false, m.set_students([]))
    assert_equal(3,m.number_of_students)
  end
  
  
  def test_deletStudentDeletesTheMentorIfNotEnoughLeft
    s = StudentR.new(99)
    s2 = StudentR.new(98)    
    s3 = StudentR.new(97)
  
    m = MentorR.new("blah",[s,s2,s3])
    studentP = ProgramR.new
    mentorP = ProgramR.new
    
    s2.set_program(studentP)
    m.set_program(mentorP)
  
    s.delete
    
    assert_equal(0,m.number_of_students)
    assert_equal(nil,m.get_program)
    assert_equal(nil,mentorP.get_mentor)
    assert_equal(studentP,s2.get_program)
    assert_equal(0,s.number_of_mentors)
  end  

  def test_deleteStudentLeavesMentorAloneIfHasEnough
    s = StudentR.new(99)
    s2 = StudentR.new(98)    
    s3 = StudentR.new(97)
    s4 = StudentR.new(96)

    m = MentorR.new("blah",[s,s2,s3,s4])
    studentP = ProgramR.new
    mentorP = ProgramR.new
    
    assert_equal true, s2.set_program(studentP)
    assert_equal true, m.set_program(mentorP)

    s.delete
    
    assert_equal(3,m.number_of_students)
    assert_equal(mentorP,m.get_program)
    assert_equal(m,mentorP.get_mentor)
    assert_equal(studentP,s2.get_program)
    assert_equal(0,s.number_of_mentors)
  end 
  
end
end