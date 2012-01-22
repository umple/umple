require 'test/unit'
require './src-gen-umple/student_a_b'
require './src-gen-umple/mentor_a_b'
require './src-gen-umple/program_a_b'

module CruiseAssociations
class MNToOptionalNTest < Test::Unit::TestCase

  def test_CreateStudentWihtoutMentor
  
    s = StudentAB.new(99)
    assert_equal(false,s.is_number_of_mentors_valid)
  end
  
  def test_CreateMentorWithoutStudent
    m = MentorAB.new("blah")
    assert_equal(0,m.number_of_students)
  end
  
  def test_AddStudentsAndMentorsOkay
    m = MentorAB.new("blah")
    m2 = MentorAB.new("blah")
    m3 = MentorAB.new("blah")
    m4 = MentorAB.new("blah")
    m5 = MentorAB.new("blah")
    m6 = MentorAB.new("blah")
    
    s = StudentAB.new(99)
    s2 = StudentAB.new(98)
    s3 = StudentAB.new(97)

    assert_equal(true,m.add_student(s))
    assert_equal(true,m.add_student(s2))
    assert_equal(false,m.add_student(s3))
    
    assert_equal(true,s.add_mentor(m2))
    assert_equal(true,s.add_mentor(m3))
    assert_equal(true,s.add_mentor(m4))
    assert_equal(true,s.add_mentor(m5))
    assert_equal(false,s.add_mentor(m6))
    
    assert_equal(2, m.number_of_students)
    assert_equal(m4,s.get_mentor(3))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(5,s.number_of_mentors)
  end   
  
  def test_RemoveMiddleMentorWhenNotValidMaintainsTheOrder
    s = StudentAB.new(99)
    
    m = MentorAB.new("blah")
    m2 = MentorAB.new("blah")
    m3 = MentorAB.new("blah")

    s.add_mentor(m)
    s.add_mentor(m2)
    s.add_mentor(m3)
    assert_equal(false,s.remove_mentor(m2))
    assert_equal(3, s.number_of_mentors)
    assert_equal(m2,s.get_mentor(1))
  end 
  
  def test_RemoveStudents
    m = MentorAB.new("blah")
    m2 = MentorAB.new("blah2")
    m3 = MentorAB.new("blah3")
    m4 = MentorAB.new("blah4")
    
    s = StudentAB.new(99)
    s2 = StudentAB.new(98)
    s3 = StudentAB.new(97)
    
    m.add_student(s)
    m.add_student(s2)
    m2.add_student(s)
    m2.add_student(s2)
    m3.add_student(s)
    m3.add_student(s2)
    m4.add_student(s)
    m4.add_student(s2)
    
    assert_equal(false,m.remove_student(s3))
    assert_equal(true,m.remove_student(s2))
    
    assert_equal(3,s2.number_of_mentors)
    assert_equal(1, m.number_of_students)
  end 
  
  def test_SetStudentsTooMany
    m = MentorAB.new("blah")
    
    s = StudentAB.new(99)
    s2 = StudentAB.new(98)
    s3 = StudentAB.new(97)
    
    assert_equal(true,m.add_student(s))
    assert_equal(true,m.add_student(s2))
    assert_equal(false,m.add_student(s3))
    
    assert_equal(2, m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(0,s3.number_of_mentors)
  end   
  
  def test_MentorAlreadyHasEnoughStudents
    m = MentorAB.new("blah")
    
    s = StudentAB.new(99)
    s2 = StudentAB.new(98)
    s3 = StudentAB.new(97)
    
    m.add_student(s)
    m.add_student(s2)
    
    assert_equal(false,m.add_student(s3))
    
    assert_equal(2, m.number_of_students)
    assert_equal(0,s3.number_of_mentors)
  end    
  

  def test_getBoundsForStudent
    assert_equal(2,MentorAB::maximum_number_of_students)
  end  
  
  def test_getBoundsForMentor
    assert_equal(3,StudentAB::minimum_number_of_mentors)
    assert_equal(5,StudentAB::maximum_number_of_mentors)
  end    

  def test_deleteMentorAndStudentHasEnough
    m = MentorAB.new("blah")
    m2 = MentorAB.new("blah2")
    m3 = MentorAB.new("blah2")
    m4 = MentorAB.new("blah2")

    s = StudentAB.new(99)
    s2 = StudentAB.new(98)
    
    m.add_student(s)
    m.add_student(s2)
    m2.add_student(s)
    m2.add_student(s2)
    m3.add_student(s)
    m3.add_student(s2)
    m4.add_student(s)
    m4.add_student(s2)
    
    p = ProgramAB.new
    s.set_program(p)
    
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(p,s.get_program)
    assert_equal(3,s.number_of_mentors)
  end  

  def test_deleteMentorAndStudentNowHasTooFewMentors
    m = MentorAB.new("blah")
    m2 = MentorAB.new("blah2")
    m3 = MentorAB.new("blah3")

    s = StudentAB.new(99)
    s2 = StudentAB.new(98)
    
    m.add_student(s)
    m.add_student(s2)
    m2.add_student(s)
    m2.add_student(s2)
    m3.add_student(s)
    m3.add_student(s2)
    
    p = ProgramAB.new
    s.set_program(p)

    assert_equal(2,m.number_of_students)
    assert_equal(2,m2.number_of_students)
    assert_equal(2,m3.number_of_students)
    assert_equal(3,s.number_of_mentors)
    assert_equal(3,s2.number_of_mentors)
    
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(0,m2.number_of_students)
    assert_equal(0,m3.number_of_students)
    assert_equal(0,s.number_of_mentors)
    assert_equal(0,s2.number_of_mentors)
  end  

end
end