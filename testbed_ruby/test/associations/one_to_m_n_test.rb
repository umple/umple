require 'test/unit'
require './src-gen-umple/student_k'
require './src-gen-umple/mentor_k'
require './src-gen-umple/program_k'

module CruiseTest
class OneToMNTest < Test::Unit::TestCase

  def test_cannotCreateNullStudent
    assert_raise RuntimeError do #"Unable to create student due to mentor"
      StudentK.new(99,nil)
    end
  end
  
  def test_CreateMentorWithoutStudent
    m = MentorK.new("blah")
    assert_equal(0,m.number_of_students)
  end
  
  def test_CannotSetMentorNull
    m = MentorK.new("blah")
    s = StudentK.new(99,m)
    
    assert_equal(false,s.set_mentor(nil))
    assert_equal(m,s.get_mentor)
    assert_equal(s,m.get_student(0))
    
  end  
  
  def test_CannotSetMentorAlreadyAtMax
    m = MentorK.new("blah")
    m2 = MentorK.new("blah2")
    
    StudentK.new(99,m)
    StudentK.new(98,m)
    StudentK.new(97,m)
    
    StudentK.new(96,m2)
    StudentK.new(95,m2)
    s = StudentK.new(94,m2)
    assert_equal(false,s.set_mentor(m))
    
    assert_equal(3,m.number_of_students)
    assert_equal(3,m2.number_of_students)
    assert_equal(m2,s.get_mentor)
  end    
  
  def test_CannotSetMentorExistingAtMin
    m = MentorK.new("blah")
    m2 = MentorK.new("blah2")
    
    StudentK.new(99,m)
    StudentK.new(98,m)
    
    StudentK.new(97,m2)
    s = StudentK.new(96,m2)
    assert_equal(false,s.set_mentor(m))
    
    assert_equal(2,m.number_of_students)
    assert_equal(2,m2.number_of_students)
    assert_equal(m2,s.get_mentor)
  end   
  
  def test_CreateStudentFromMentor
    m = MentorK.new("blah")
    s = StudentK.new(99,m)
  
    assert_equal(99,s.get_number)
    assert_equal(m,s.get_mentor)
    assert_equal(1,m.number_of_students)
    assert_equal(s,m.get_student(0))
  end  
  
  def test_createStudentWhenMentorAlreadyHasEnogh
    assert_raise RuntimeError do #"Unable to create student due to mentor"
      m = MentorK.new("blah")
      StudentK.new(10,m)
      StudentK.new(11,m)
      StudentK.new(12,m)
      StudentK.new(13,m)
    end
  end  
  
  
  
  def test_replaceMentor
    m = MentorK.new("blah")
    m2 = MentorK.new("blah2")
  
    s = StudentK.new(123,m)
    StudentK.new(125,m)
    StudentK.new(126,m)
    s2 = StudentK.new(124,m2)
    
    assert_equal(3,m.number_of_students)
    assert_equal(1,m2.number_of_students)
    
    assert_equal(true,s.set_mentor(m2))
    assert_equal(m2,s.get_mentor)
    assert_equal(2,m2.number_of_students)
    assert_equal(s2,m2.get_student(0))
    assert_equal(s,m2.get_student(1))
    
    assert_equal(2,m.number_of_students)
  end 
  
  def test_addToNewMentor
    m = MentorK.new("blah")
    m2 = MentorK.new("blah2")
  
    s = StudentK.new(123,m)
    StudentK.new(124,m)
    StudentK.new(125,m)
    
    assert_equal(true,m2.add_student(s))
    assert_equal(m2,s.get_mentor)
    assert_equal(s,m2.get_student(0))
    assert_equal(2,m.number_of_students)
  end  
  
  def test_removeFromExistingMentor
    m = MentorK.new("blah")
    m2 = MentorK.new("blah2")
  
    s1 = StudentK.new(123,m)
    s2 = StudentK.new(124,m)
    s3 = StudentK.new(125,m)
    
    assert_equal(3,m.number_of_students)
    assert_equal(0,m2.number_of_students)
    
    m2.add_student(s1)
  
    assert_equal(2,m.number_of_students)
    assert_equal(s2,m.get_student(0))
    assert_equal(s3,m.get_student(1))
    
    assert_equal(1,m2.number_of_students)
    assert_equal(s1,m2.get_student(0))
    
    assert_equal(m2,s1.get_mentor)
    assert_equal(m,s2.get_mentor)
    assert_equal(m,s3.get_mentor)
  end   
  
  def test_set_mentorReplacesExistingMentor
    m = MentorK.new("blah")
    s = StudentK.new(99,m)
    StudentK.new(98,m)
    StudentK.new(97,m)
    
    m2 = MentorK.new("blah2")
    
    assert_equal(true,s.set_mentor(m2))
    assert_equal(m2,s.get_mentor)
    assert_equal(s,m2.get_student(0))
    assert_equal(2,m.number_of_students)    
  end
  
  def test_is_number_of_students_valid
    m = MentorK.new("blah")
    assert_equal(false,m.is_number_of_students_valid)
  
    StudentK.new(99,m)
    assert_equal(false,m.is_number_of_students_valid)
  
    StudentK.new(98,m)
    assert_equal(true,m.is_number_of_students_valid)
  
    StudentK.new(97,m)
    assert_equal(true,m.is_number_of_students_valid)
  
  end
  
  def test_getBoundsForStudent
    assert_equal(2,MentorK::minimum_number_of_students)
    assert_equal(3,MentorK::maximum_number_of_students)
  end  
  
  def test_add_studentWhenMentorHasTooMany
    m = MentorK.new("blah")
    m2 = MentorK.new("blah2")
    
    StudentK.new(12,m)
    StudentK.new(13,m)
    StudentK.new(14,m)
    
    StudentK.new(21,m2)
    StudentK.new(22,m2)
    s = StudentK.new(23,m2)
    
    assert_equal(false,m.add_student(s))
  
    assert_equal(3,m.number_of_students)
    assert_equal(3,m2.number_of_students)
  end  
  
  def test_add_studentWhenMentorHasTooFew
    m = MentorK.new("blah")
    m2 = MentorK.new("blah2")
    
    StudentK.new(12,m)
    StudentK.new(13,m)
    
    StudentK.new(21,m2)
    s = StudentK.new(23,m2)
    
    assert_equal(false,m.add_student(s))
  
    assert_equal(2,m.number_of_students)
    assert_equal(2,m2.number_of_students)
  end  
end
end
