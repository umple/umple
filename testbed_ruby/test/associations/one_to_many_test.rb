require 'test/unit'
require './src-gen-umple/student_j'
require './src-gen-umple/mentor_j'
require './src-gen-umple/program_j'

module CruiseTest
class OneToManyTest < Test::Unit::TestCase

  def test_cannotCreateNullStudent
    assert_raise RuntimeError do #"Unable to create student due to mentor"
      StudentJ.new(99,nil)
    end
  end
  
  def test_CreateMentorWithoutStudent
    m = MentorJ.new("blah")
    assert_equal(0,m.number_of_students)
  end
  
  def test_CreateStudentFromMentor
    m = MentorJ.new("blah")
    s = StudentJ.new(99,m)
  
    assert_equal(99,s.get_number)
    assert_equal(m,s.get_mentor)
    assert_equal(1,m.number_of_students)
    assert_equal(s,m.get_student(0))
  end  
  
  def test_add_studentConstructorInformation
    m = MentorJ.new("blah")
    s = StudentJ.new(10,m)
  
    assert_equal(10,s.get_number)
    assert_equal(m,s.get_mentor)
    assert_equal(1,m.number_of_students)
    assert_equal(s,m.get_student(0))
  end
  
  def test_replaceMentor
    m = MentorJ.new("blah")
    m2 = MentorJ.new("blah2")
  
    s = StudentJ.new(123,m)
    s2 = StudentJ.new(125,m2)
    
    s.set_mentor(m2)
    
    assert_equal(m2,s.get_mentor)
    assert_equal(2,m2.number_of_students)
    assert_equal(s2,m2.get_student(0))
    assert_equal(s,m2.get_student(1))
    
    assert_equal(0,m.number_of_students)
  end 
  
  def test_addToNewMentor
    m = MentorJ.new("blah")
    m2 = MentorJ.new("blah2")
  
    s = StudentJ.new(123,m)
    m2.add_student(s)
    
    assert_equal(m2,s.get_mentor)
    assert_equal(s,m2.get_student(0))
    assert_equal(0,m.number_of_students)
  end  
  
  def test_removeFromExistingMentor
    m = MentorJ.new("blah")
    m2 = MentorJ.new("blah2")
  
    s1 = StudentJ.new(123,m)
    s2 = StudentJ.new(124,m)
    s3 = StudentJ.new(125,m)
    
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
  
  
  def test_cannotSetMentorNull
    m = MentorJ.new("blah")
    s = StudentJ.new(99,m)
    assert_equal(false,s.set_mentor(nil))
    assert_equal(m,s.get_mentor)
    assert_equal(s,m.get_student(0))
  end
  
  def test_set_mentorReplacesExistingMentor
    m = MentorJ.new("blah")
    s = StudentJ.new(99,m)
    
    m2 = MentorJ.new("blah2")
    
    s.set_mentor(m2)
    assert_equal(m2,s.get_mentor)
    assert_equal(s,m2.get_student(0))
    assert_equal(0,m.number_of_students)    
  end  
  
end
end
