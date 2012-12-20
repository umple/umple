require 'test/unit'
require './src-gen-umple/student_o'
require './src-gen-umple/mentor_o'
require './src-gen-umple/program_o'

module CruiseAssociations
class ManyToMNTest < Test::Unit::TestCase

  def test_CreateStudentWithoutMentor
    s = StudentO.new(99)
    assert_equal(0,s.number_of_mentors)
  end
  
  def test_ConstructorWithTooFew
    assert_raise RuntimeError do
      s = StudentO.new(99)
      MentorO.new("blah",[s])
    end
  end
  
  def test_ConstructorWithTooMany
    assert_raise RuntimeError do #"Unable to create MentorO, must have 2 to 4 students"
      s = StudentO.new(99)
      s2 = StudentO.new(98)    
      s3 = StudentO.new(97)
      s4 = StudentO.new(96)
      s5 = StudentO.new(95)
      MentorO.new("blah",[s,s2,s3,s4,s5])
    end
  end
  
  def test_constructorJustBigEnough
    s = StudentO.new(99)
    s2 = StudentO.new(98)
  
    m = MentorO.new("blah",[s,s2])
  
    assert_equal(2,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
  end
  
  def test_constructorJustSmallEnough
    s = StudentO.new(99)
    s2 = StudentO.new(98)    
    s3 = StudentO.new(97)
    s4 = StudentO.new(96)
  
    m = MentorO.new("blah",[s,s2,s3,s4])
  
    assert_equal(4,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(m,s4.get_mentor(0))
  end  
  
  def test_constructorWatchOutForDuplicateEntries
    assert_raise RuntimeError do #"Unable to create MentorO, must have 2 to 4 students
      s = StudentO.new(99)
      MentorO.new("blah",[s, s])
    end
  end
  
  def test_constructorExistingMentorsOkay
    s1 = StudentO.new(99)
    s2 = StudentO.new(98)
    s3 = StudentO.new(97)
    
    m = MentorO.new("blah",[s1,s2])
  
    assert_equal(2,m.number_of_students)
    assert_equal(m, s1.get_mentor(0))
    assert_equal(m, s2.get_mentor(0))
    assert_equal(0, s3.number_of_mentors)    
  
    m2 = MentorO.new("blah2",[s1,s2,s3])
    
    assert_equal(2,m.number_of_students)
    assert_equal(m, s1.get_mentor(0))
    assert_equal(m, s2.get_mentor(0))
    
    assert_equal(3,m2.number_of_students)
    assert_equal(m2, s1.get_mentor(1))
    assert_equal(m2, s2.get_mentor(1))
    assert_equal(m2, s3.get_mentor(0))
  
  end   
  
  def test_set_students_outsideNM
    s = StudentO.new(99)
    s2 = StudentO.new(98)    
    s3 = StudentO.new(97)
    s4 = StudentO.new(96)
    s5 = StudentO.new(95)
  
    m = MentorO.new("blah",[s, s2])
    
    assert_equal(false,m.set_students([s2, s3, s4, s5, s]))
    assert_equal(2,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(0,s3.number_of_mentors)
    assert_equal(0,s4.number_of_mentors)
    assert_equal(0,s5.number_of_mentors)
  
    assert_equal(false,m.set_students([s5]))
    assert_equal(2,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(0,s3.number_of_mentors)
    assert_equal(0,s4.number_of_mentors)
    assert_equal(0,s5.number_of_mentors)
  end
  
  def test_set_students_doNotAllowDuplicatesNM
    s = StudentO.new(99)
    s2 = StudentO.new(98)    
    s3 = StudentO.new(97)
  
    m = MentorO.new("blah",[s, s2])
    assert_equal(false,m.set_students([s2, s2, s3]))
  end
  
  def test_set_students_withinNM
    s = StudentO.new(99)
    s2 = StudentO.new(98)    
    s3 = StudentO.new(97)
    s4 = StudentO.new(96)
  
    m = MentorO.new("blah",[s, s2])
    
    assert_equal(true,m.set_students([s2, s3, s4]))
    assert_equal(3,m.number_of_students)
  
    assert_equal(0,s.number_of_mentors)
  
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(m,s4.get_mentor(0))    
  end
  
  def test_add_mentorTooMany
    s = StudentO.new(99)
    s2 = StudentO.new(98)    
    s3 = StudentO.new(97)
    s4 = StudentO.new(96)
    s5 = StudentO.new(95)
  
    m = MentorO.new("blah",[s,s2,s3,s4])
    
    assert_equal(false,s5.add_mentor(m))
    assert_equal(4,m.number_of_students)
    assert_equal(0,s5.number_of_mentors)
    
  end
  
  def test_add_mentorOkay
    s = StudentO.new(99)
    s2 = StudentO.new(98)    
    s3 = StudentO.new(97)
    s5 = StudentO.new(96)
  
    m = MentorO.new("blah",[s,s2,s3])
    
    assert_equal(true,s5.add_mentor(m))
    assert_equal(4,m.number_of_students)
    assert_equal(1,s5.number_of_mentors)
    
  end

  def test_add_student
    s = StudentO.new(99)
    s2 = StudentO.new(98)    
    s3 = StudentO.new(97)
    s4 = StudentO.new(96)
    s5 = StudentO.new(95)
  
    m = MentorO.new("blah",[s,s2,s3])
    
    assert_equal(true,m.add_student(s4))
    
    assert_equal(4,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(m,s4.get_mentor(0))    
   
    assert_equal(false,m.add_student([s5]))
    assert_equal(4,m.number_of_students)
  
  end  
  
  def test_add_studentHasExistingMentor
    s = StudentO.new(99)
    s2 = StudentO.new(98)    
    s3 = StudentO.new(97)
    s4 = StudentO.new(96)
    s5 = StudentO.new(95)
    s6 = StudentO.new(94)
  
    m = MentorO.new("blah",[s,s2,s3])
    m2 = MentorO.new("blah2",[s4,s5,s6])
  
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
  
    assert_equal(false,m.add_student(s5))
  end  
  
  def test_remove_student
    s = StudentO.new(99)
    s2 = StudentO.new(98)    
    s3 = StudentO.new(97)
    s4 = StudentO.new(96)
  
    m = MentorO.new("blah",[s,s2,s3])
    
    assert_equal(false,m.remove_student(s4))
    assert_equal(true,m.remove_student(s3))
    
    assert_equal(2,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(0,s3.number_of_mentors)
    assert_equal(0,s4.number_of_mentors)    
  
    assert_equal(false,m.remove_student(s2))
    assert_equal(2,m.number_of_students)
  end  
  
  def test_set_students_empty
    s = StudentO.new(99)
    s2 = StudentO.new(98)
    s3 = StudentO.new(97)
    m = MentorO.new("blah",[s,s2,s3])
  
    assert_equal(false,m.set_students([]))
    assert_equal(3,m.number_of_students)
  end
  
  def test_deletStudentDeletesTheMentorIfNotEnoughLeft
    s1 = StudentO.new(99)
    s2 = StudentO.new(98)
  
    m = MentorO.new("blah",[s1,s2])
    studentP = ProgramO.new
    mentorP = ProgramO.new
    
    s2.set_program(studentP)
    m.set_program(mentorP)
  
    s1.delete
    
    assert_equal(0,m.number_of_students)
    assert_equal(nil,m.get_program)
    assert_equal(nil,mentorP.get_mentor)
    assert_equal(studentP,s2.get_program)
    assert_equal(0,s1.number_of_mentors)
  end  
  
  def test_deleteStudentLeavesMentorAloneIfHasEnough
    s1 = StudentO.new(99)
    s2 = StudentO.new(98)
    s3 = StudentO.new(97)
  
    m = MentorO.new("blah",[s1,s2,s3])
    studentP = ProgramO.new
    mentorP = ProgramO.new
    
    s2.set_program(studentP)
    m.set_program(mentorP)
  
    s1.delete
    
    assert_equal(2,m.number_of_students)
    assert_equal(mentorP,m.get_program)
    assert_equal(m,mentorP.get_mentor)
    assert_equal(studentP,s2.get_program)
    assert_equal(0,s1.number_of_mentors)
  end 
  
end
end