require 'test/unit'
require 'src/student_c'
require 'src/mentor_c'
require 'src/program_c'

module CruiseTest
class OptionalOneToManyTest < Test::Unit::TestCase

  def test_CreateStudentWithoutMentor
    s = StudentC.new(99)
    assert_equal(nil,s.get_mentor)
  end
  
  def test_add_student
    m = MentorC.new("m1")
    s = StudentC.new(99)
    m.add_student(s)
    
    assert_equal(m,s.get_mentor)
    assert_equal(s,m.get_student(0))
  end
  
  def test_replaceMentor
    m = MentorC.new("m1")
    m2 = MentorC.new("m2")

    s = StudentC.new(99)
    m.add_student(s)
    assert_equal(1,m.number_of_students)
 
    s.set_mentor(m2)
    
    assert_equal(m2,s.get_mentor)
    assert_equal(s,m2.get_student(0))
    assert_equal(0,m.number_of_students)
  end 
  
  def test_addToNewMentor
    m = MentorC.new("m1")
    m2 = MentorC.new("m2")
    s = StudentC.new(99)
    
    m.add_student(s)
    m2.add_student(s)
    
    assert_equal(m2,s.get_mentor)
    assert_equal(s,m2.get_student(0))
    assert_equal(0,m.number_of_students)
  end  
  
  def test_removeFromExistingMentor
    m = MentorC.new("m1")
    m2 = MentorC.new("m2")

    s1 = StudentC.new(99)
    s2 = StudentC.new(98)
    s3 = StudentC.new(97)
    
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
    m = MentorC.new("m1")
    s = StudentC.new(99)
    
    m.add_student(s)
    m.remove_student(s)
    
    assert_equal(nil,s.get_mentor)
    assert_equal(0,m.number_of_students)
  end  
  
end
end
