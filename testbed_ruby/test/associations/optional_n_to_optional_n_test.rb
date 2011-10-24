require 'test/unit'
require './src-gen-umple/student_a_e'
require './src-gen-umple/mentor_a_e'
require './src-gen-umple/program_a_e'

module CruiseTest
class OptionalNToOptionalNTest < Test::Unit::TestCase

  def test_CreateNew
    s = StudentAE.new(99)
    assert_equal(0,s.number_of_mentors)
    
    m = MentorAE.new("blah")
    assert_equal(0,m.number_of_students)
  end
  
  def test_add_student
    m = MentorAE.new("blah")
    s = StudentAE.new(99)
    m.add_student(s)
    
    assert_equal(m,s.get_mentor(0))
    assert_equal(s, m.get_student(0))
  end

  def test_add_studentToMultipleMentors
    m = MentorAE.new("blah")
    m2 = MentorAE.new("blah2")
    
    
    s = StudentAE.new(99)
    s2 = StudentAE.new(992)
    m.add_student(s)
    m2.add_student(s2)
    m2.add_student(s)
    s2.add_mentor(m)
    
    assert_equal(m,s.get_mentor(0))
    assert_equal(m2,s.get_mentor(1))
    assert_equal(m2,s2.get_mentor(0))
    assert_equal(m,s2.get_mentor(1))

    
    assert_equal(s, m.get_student(0))
    assert_equal(s2, m.get_student(1))
    assert_equal(s2, m2.get_student(0))
    assert_equal(s, m2.get_student(1))
  end
  
  def test_addToNewMentor
    m = MentorAE.new("blah")
    m2 = MentorAE.new("blah2")
    s = StudentAE.new(99)
    
    m.add_student(s)
    m2.add_student(s)
    
    assert_equal(2,s.number_of_mentors)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m2,s.get_mentor(1))

    assert_equal(1, m.number_of_students)
    assert_equal(1, m2.number_of_students)

    assert_equal(s, m.get_student(0))
    assert_equal(s, m2.get_student(0))
  end  
  
  def test_doNotRemoveFromExistingMentor
    m = MentorAE.new("blah")
    m2 = MentorAE.new("blah2")

    s1 = StudentAE.new(99)
    s2 = StudentAE.new(98)
    
    m.add_student(s1)
    m.add_student(s2)

    assert_equal(2, m.number_of_students)
    assert_equal(0, m2.number_of_students)
    
    m2.add_student(s1)

    assert_equal(2, m.number_of_students)
    assert_equal(s1, m.get_student(0))
    assert_equal(s2, m.get_student(1))
    
    assert_equal(1, m2.number_of_students)
    assert_equal(s1, m2.get_student(0))
    
    assert_equal(m,s1.get_mentor(0))
    assert_equal(m2,s1.get_mentor(1))
    
    assert_equal(m,s2.get_mentor(0))
  end   
  
  def test_remove_student
    m = MentorAE.new("blah")
    s = StudentAE.new(99)
    
    m.add_student(s)
    m.remove_student(s)
    
    assert_equal(0,s.number_of_mentors)
    assert_equal(0,m.number_of_students)
  end  

  def test_deleteAll
    m = MentorAE.new("blah")
    m2 = MentorAE.new("blah")
    
    s = StudentAE.new(99)
    s2 = StudentAE.new(98)
    s3 = StudentAE.new(97)
    
    m.add_student(s)
    m.add_student(s2)
    m.add_student(s3)

    m2.add_student(s2)
    
    m.delete

    assert_equal(0,m.number_of_students)
    assert_equal(1,m2.number_of_students)
    
    assert_equal(0,s.number_of_mentors)
    assert_equal(1,s2.number_of_mentors)
    assert_equal(0,s3.number_of_mentors)
  end  
  
  def test_isMaxNumber
    assert_equal(3,StudentAE::maximum_number_of_mentors)
    assert_equal(2,MentorAE::maximum_number_of_students)
  end
  
  def test_add_studentsMax
    m = MentorAE.new("blah")
    assert_equal(true,m.add_student(StudentAE.new(99)))
    assert_equal(true,m.add_student(StudentAE.new(98)))
    assert_equal(false,m.add_student(StudentAE.new(97)))
  end


  def test_add_mentorsMax
    s = StudentAE.new(98)
    assert_equal(true,s.add_mentor(MentorAE.new("blah")))
    assert_equal(true,s.add_mentor(MentorAE.new("blah")))
    assert_equal(true,s.add_mentor(MentorAE.new("blah")))
    assert_equal(false,s.add_mentor(MentorAE.new("blah")))
  end
end
end
