require 'test/unit'
require './src-gen-umple/student_z'
require './src-gen-umple/mentor_z'
require './src-gen-umple/program_z'

module CruiseAssociations
class OneToOptionalNTest < Test::Unit::TestCase

  def test_cannotCreateNullStudent
  	assert_raise RuntimeError do #"Unable to create student due to mentor"
      StudentZ.new(99,nil)
    end
  end
  
  def test_CreateMentorWithoutStudent
    m = MentorZ.new("blah")
    assert_equal(0,m.number_of_students)
  end

  def test_CannotSetMentorNull
    m = MentorZ.new("blah")
    s = StudentZ.new(99,m)
    
    assert_equal(false,s.set_mentor(nil))
    assert_equal(m,s.get_mentor)
    assert_equal(s,m.get_student(0))
  end 
  
  def test_CreateStudentFromMentor
    m = MentorZ.new("blah")
    s = StudentZ.new(99,m)

    assert_equal(99,s.get_number)
    assert_equal(m,s.get_mentor)
    assert_equal(1,m.number_of_students)
    assert_equal(s,m.get_student(0))
  end  
  
  def test_CreateStudentFromMentorTooMany
  	assert_raise RuntimeError do #"Unable to create student due to mentor"
      m = MentorZ.new("blah")
      StudentZ.new(99,m)
      StudentZ.new(98,m)
      StudentZ.new(97,m)
      StudentZ.new(96,m)
    end
  end  
  
  def test_CannotSetMentorAlreadyAtMax
    m = MentorZ.new("blah")
    m2 = MentorZ.new("blah2")
    
    StudentZ.new(99,m)
    StudentZ.new(98,m)
    StudentZ.new(97,m)
    
    StudentZ.new(96,m2)
    StudentZ.new(95,m2)
    s = StudentZ.new(94,m2)
    assert_equal(false,s.set_mentor(m))
    
    assert_equal(3,m.number_of_students)
    assert_equal(3,m2.number_of_students)
    assert_equal(m2,s.get_mentor)
  end    

  def test_CreateStudentFromMentorJustEnough
    m = MentorZ.new("blah")
    s = StudentZ.new(99,m)
    s2 = StudentZ.new(98,m)
    s3 = StudentZ.new(97,m)
    
    assert_equal(3,m.number_of_students)
    assert_equal(m,s.get_mentor)
    assert_equal(m,s2.get_mentor)
    assert_equal(m,s3.get_mentor)
  end   
  
  def test_MaximumNumberOfStudents
    assert_equal(3,MentorZ::maximum_number_of_students)
  end
  
  def test_add_studentConstructorInformation
    m = MentorZ.new("blah")
    s = StudentZ.new(10,m)

    assert_equal(10,s.get_number)
    assert_equal(m,s.get_mentor)
    assert_equal(1,m.number_of_students)
    assert_equal(s,m.get_student(0))
  end
  
  def test_add_studentConstructorInformationTooMany
    m = MentorZ.new("blah")
    s = StudentZ.new(10,m)
    s2 = StudentZ.new(11,m)
    s3 = StudentZ.new(12,m)

    assert_equal(10,s.get_number)
    assert_equal(m,s.get_mentor)
    assert_equal(3,m.number_of_students)
    assert_equal(s,m.get_student(0))
    assert_equal(s2,m.get_student(1))
    assert_equal(s3,m.get_student(2))

    assert_raise RuntimeError do
      s4 = StudentZ.new(13,m)
    end
  end  
  
  def test_replaceMentor
    m = MentorZ.new("blah")
    m2 = MentorZ.new("blah2")

    s = StudentZ.new(123,m)
    s2 = StudentZ.new(125,m2)
    
    assert_equal(true,s.set_mentor(m2))
    
    assert_equal(m2,s.get_mentor)
    assert_equal(2,m2.number_of_students)
    assert_equal(s2,m2.get_student(0))
    assert_equal(s,m2.get_student(1))
    
    assert_equal(0,m.number_of_students)
  end 
  
  def test_addToNewMentor
    m = MentorZ.new("blah")
    m2 = MentorZ.new("blah2")

    s = StudentZ.new(123,m)
    m2.add_student(s)
    
    assert_equal(m2,s.get_mentor)
    assert_equal(s,m2.get_student(0))
    assert_equal(0,m.number_of_students)
  end  
  
  def test_removeFromExistingMentor
    m = MentorZ.new("blah")
    m2 = MentorZ.new("blah2")

    s1 = StudentZ.new(123,m)
    s2 = StudentZ.new(124,m)
    s3 = StudentZ.new(125,m)
    
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
    m = MentorZ.new("blah")
    s = StudentZ.new(99,m)
    
    m2 = MentorZ.new("blah2")
    
    s.set_mentor(m2)
    assert_equal(m2,s.get_mentor)
    assert_equal(s,m2.get_student(0))
    assert_equal(0,m.number_of_students)    
  end  
  
  def test_add_studentWhenMentorHasTooMany
    m = MentorZ.new("blah")
    m2 = MentorZ.new("blah2")
    
    StudentZ.new(12,m)
    StudentZ.new(13,m)
    StudentZ.new(14,m)
    
    StudentZ.new(21,m2)
    StudentZ.new(22,m2)
    s = StudentZ.new(23,m2)
    
    assert_equal(false,m.add_student(s))

    assert_equal(3,m.number_of_students)
    assert_equal(3,m2.number_of_students)
  end
end
end
