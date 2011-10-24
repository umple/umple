require 'test/unit'
require './src-gen-umple/student_y'
require './src-gen-umple/mentor_y'
require './src-gen-umple/program_y'

module CruiseTest
class OptionalOneToOptionalNTest < Test::Unit::TestCase

  def test_CreateStudentWithoutMentor
    s = StudentY.new(99)
    assert_equal(nil,s.get_mentor)
  end
  
  def test_add_student
    m = MentorY.new("blah")
    s = StudentY.new(99)
    m.add_student(s)
    
    assert_equal(m,s.get_mentor)
    assert_equal(s,m.get_student(0))
  end
  
  def test_add_studentCannotAddForever
    m = MentorY.new("blah")
    assert_equal(true,m.add_student(StudentY.new(99)))
    assert_equal(true,m.add_student(StudentY.new(98)))
    assert_equal(true,m.add_student(StudentY.new(97)))
    assert_equal(true,m.add_student(StudentY.new(96)))
    assert_equal(false,m.add_student(StudentY.new(95)))
  end
  
  def test_replaceMentor
    m = MentorY.new("blah")
    m2 = MentorY.new("blah2")
  
    s = StudentY.new(99)
    m.add_student(s)
    s.set_mentor(m2)
    
    assert_equal(m2,s.get_mentor)
    assert_equal(s,m2.get_student(0))
    assert_equal(0,m.number_of_students)
  end 
  
  def test_cannotReplaceIfFull
    m = MentorY.new("blah")
    m2 = MentorY.new("blah2")
  
    m2.add_student(StudentY.new(99))
    m2.add_student(StudentY.new(98))
    m2.add_student(StudentY.new(97))
    m2.add_student(StudentY.new(96))
    
    s = StudentY.new(95)
    
    assert_equal(true,m.add_student(s))
    assert_equal(false,s.set_mentor(m2))
    
    assert_equal(m,s.get_mentor)
    assert_equal(4,m2.number_of_students)
    assert_equal(1,m.number_of_students)
  end 
  
  def test_addToNewMentor
    m = MentorY.new("blah")
    m2 = MentorY.new("blah2")
    s = StudentY.new(99)
    
    assert_equal(true, m.add_student(s))
    assert_equal(m,s.get_mentor)

    assert_equal(true, m2.add_student(s))
    assert_equal(m2,s.get_mentor)
    assert_equal(s,m2.get_student(0))
    assert_equal(0,m.number_of_students)
  end  
  
  def test_cannotAddToFullMentor
    m = MentorY.new("blah")
    m2 = MentorY.new("blah2")
    s = StudentY.new(99)
    
    m.add_student(StudentY.new(98))
    m.add_student(StudentY.new(97))
    m.add_student(StudentY.new(96))
    m.add_student(StudentY.new(95))
    
    m2.add_student(s)
    assert_equal(false,m.add_student(s))
    assert_equal(m2,s.get_mentor)
    assert_equal(4,m.number_of_students)
    assert_equal(1,m2.number_of_students)
  end
  
  def test_removeFromExistingMentor
    m = MentorY.new("blah")
    m2 = MentorY.new("blah2")
  
    s1 = StudentY.new(99)
    s2 = StudentY.new(98)
    s3 = StudentY.new(97)
    
    m.add_student(s1)
    m.add_student(s2)
    m.add_student(s3)
  
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
  
  def test_remove_student
    m = MentorY.new("blah")
    s = StudentY.new(99)
    
    m.add_student(s)
    m.remove_student(s)
    
    assert_equal(nil,s.get_mentor)
    assert_equal(0,m.number_of_students)
    
  end  
  
  def test_maximum_number_of_students
    assert_equal(4,MentorY::maximum_number_of_students)
  end
  
end
end