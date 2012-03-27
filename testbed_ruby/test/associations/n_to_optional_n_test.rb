require 'test/unit'
require './src-gen-umple/student_ac'
require './src-gen-umple/mentor_ac'
require './src-gen-umple/program_ac'

module CruiseAssociations
class NToOptionalNTest < Test::Unit::TestCase

  def test_CreateStudentWithoutMentors
    m = MentorAC.new("blah")
    StudentAC.new(99)
  end
  
  def test_CreateStudentJustEnoughMentors
    m = MentorAC.new("blah")
    m2 = MentorAC.new("blah2")
    m3 = MentorAC.new("blah2")
    s = StudentAC.new(99)
    
    assert_equal(true,s.add_mentor(m))
    assert_equal(true,s.add_mentor(m2))
    assert_equal(false,s.add_mentor(m3))
    assert_equal(2,s.number_of_mentors)
  end

  def test_CreateMentorWithoutStudent
    m = MentorAC.new("blah")
    assert_equal(0,m.number_of_students)
  end
  
  def test_SetMentorsOutsideRange
    s = StudentAC.new(99)

    m = MentorAC.new("blah")
    m2 = MentorAC.new("blah")
    m3 = MentorAC.new("blah")

    assert_equal(true,s.add_mentor(m))
    assert_equal(true,s.add_mentor(m2))
    assert_equal(false,s.add_mentor(m3))
    
    assert_equal(2, s.number_of_mentors)
    assert_equal(s,m.get_student(0))
    assert_equal(s,m2.get_student(0))
    assert_equal(0,m3.number_of_students)
  end
  
  def test_AddStudents
    m = MentorAC.new("blah")
    
    s = StudentAC.new(99)
    s2 = StudentAC.new(98)
    s3 = StudentAC.new(97)
    s4 = StudentAC.new(96)

    assert_equal(true,m.add_student(s))
    assert_equal(true,m.add_student(s2))
    assert_equal(true,m.add_student(s3))
    assert_equal(false,m.add_student(s4))
    
    assert_equal(3,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(1,s3.number_of_mentors)
  end   
  
  def test_RemoveMiddleMentorWhenNotValidMaintainsTheOrder
    s = StudentAC.new(99)
    
    m = MentorAC.new("blah")
    m2 = MentorAC.new("blah")

    s.add_mentor(m)
    s.add_mentor(m2)
    assert_equal(false,s.remove_mentor(m2))
    
    assert_equal(2, s.number_of_mentors)
    assert_equal(m2,s.get_mentor(1))
  end 
  
  def test_CannotRemoveStudents
    m = MentorAC.new("blah")
    m2 = MentorAC.new("blah2")
    m3 = MentorAC.new("blah3")
    
    s = StudentAC.new(99)
    s2 = StudentAC.new(98)
    s3 = StudentAC.new(97)
    
    m.add_student(s)
    m.add_student(s2)
    m2.add_student(s)
    m2.add_student(s2)
    assert_equal(false,m3.add_student(s))
    assert_equal(false,m3.add_student(s2))
    
    assert_equal(false,m.remove_student(s3))
    assert_equal(false,m.remove_student(s2))
    
    assert_equal(2,s2.number_of_mentors)
    assert_equal(2,m.number_of_students)
  end 
  
  def test_SetStudentsTooMany
    m = MentorAC.new("blah")
    
    s = StudentAC.new(99)
    s2 = StudentAC.new(98)
    s3 = StudentAC.new(97)
    s4 = StudentAC.new(96)
    
    m.add_student(s)
    m.add_student(s2)
    assert_equal(true,m.add_student(s3))
    assert_equal(false,m.add_student(s4))
  end   
  
  def test_MentorAlreadyHasEnoughStudents
    m = MentorAC.new("blah")
    
    s = StudentAC.new(99)
    s2 = StudentAC.new(98)
    s3 = StudentAC.new(97)
    s4 = StudentAC.new(96)
    
    m.add_student(s)
    m.add_student(s2)
    m.add_student(s3)
    
    assert_equal(false,m.add_student(s4))
    
    assert_equal(3,m.number_of_students)
    assert_equal(1,s3.number_of_mentors)
  end    

  def test_add_mentor
    m = MentorAC.new("blah")
    m2 = MentorAC.new("blah2")
    m3 = MentorAC.new("blah2")

    s = StudentAC.new(99)
    s2 = StudentAC.new(98)
    
    assert_equal(true,m.add_student(s))
    assert_equal(true,m.add_student(s2))
    assert_equal(true,s.add_mentor(m2))
    assert_equal(false,s.add_mentor(m3))

    assert_equal(2,m.number_of_students)
    assert_equal(1,m2.number_of_students)
    assert_equal(0,m3.number_of_students)
    assert_equal(2,s.number_of_mentors)
  end 
  
  def test_getBoundsForStudent
    assert_equal(3,MentorAC::maximum_number_of_students)
  end  
  
  def test_getBoundsForMentor
    assert_equal(2,StudentAC::minimum_number_of_mentors)
    assert_equal(2,StudentAC::maximum_number_of_mentors)
  end    
  

  def test_deleteMentorAndStudentNowHasTooFewMentors
    m = MentorAC.new("blah")
    m2 = MentorAC.new("blah2")
    m3 = MentorAC.new("blah2")

    s = StudentAC.new(99)
    s2 = StudentAC.new(98)
    
    s.add_mentor(m)
    s.add_mentor(m2)
    s.add_mentor(m3)
    s2.add_mentor(m)
    s2.add_mentor(m2)
    s2.add_mentor(m3)
    
    m3.add_student(s)
    m3.add_student(s2)
    
    p = ProgramAC.new
    s.set_program(p)
    
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(0,m2.number_of_students)
    assert_equal(0,s.number_of_mentors)
  end  

end
end