require 'test/unit'
require './src-gen-umple/student_n'
require './src-gen-umple/mentor_n'

module CruiseTest
class ManyToManyTest < Test::Unit::TestCase
    
  def test_CreateNew
    s = StudentN.new(99)
    assert_equal(0,s.number_of_mentors)
    
    m = MentorN.new("blah")
    assert_equal(0,m.number_of_students)
  end

  def test_add_student
    m = MentorN.new("blah")
    s = StudentN.new(99)

    assert_equal true, m.add_student(s)
    
    assert_equal(m, s.get_mentor(0))
    assert_equal(s, m.get_student(0))
  end
  
  def test_add_studentToMultipleMentors
    m = MentorN.new("blah")
    m2 = MentorN.new("blah2")
    
    
    s = StudentN.new(99)
    s2 = StudentN.new(992)
    m.add_student(s)
    m2.add_student(s2)
    m2.add_student(s)
    s2.add_mentor(m)
    
    assert_equal(m, s.get_mentor(0))
    assert_equal(m2, s.get_mentor(1))
    assert_equal(m2, s2.get_mentor(0))
    assert_equal(m, s2.get_mentor(1))
  
    
    assert_equal(s, m.get_student(0))
    assert_equal(s2, m.get_student(1))
    assert_equal(s2, m2.get_student(0))
    assert_equal(s, m2.get_student(1))
  end
  
  # def test_addToNewMentor
  #   m = MentorN.new("blah")
  #   m2 = MentorN.new("blah2")
  #   s = StudentN.new(99)
  #   
  #   m.add_student(s)
  #   m2.add_student(s)
  #   
  #   assert_equal(2, s.number_of_mentors)
  #   assert_equal(m, s.mentor(0))
  #   assert_equal(m2, s.mentor(1))
  # 
  #   assert_equal(1, m.number_of_students)
  #   assert_equal(1, m2.number_of_students)
  # 
  #   assert_equal(s, m.student(0))
  #   assert_equal(s, m2.student(0))
  # end  
  # 
  # 
  # def test_doNotRemoveFromExistingMentor
  #   m = MentorN.new("blah")
  #   m2 = MentorN.new("blah2")
  # 
  #   s1 = StudentN.new(99)
  #   s2 = StudentN.new(98)
  #   s3 = StudentN.new(97)
  #   
  #   m.add_student(s1)
  #   m.add_student(s2)
  #   m.add_student(s3)
  # 
  #   assert_equal(3, m.number_of_students)
  #   assert_equal(0, m2.number_of_students)
  #   
  #   m2.add_student(s1)
  # 
  #   assert_equal(3, m.number_of_students)
  #   assert_equal(s1, m.student(0))
  #   assert_equal(s2, m.student(1))
  #   assert_equal(s3, m.student(2))
  #   
  #   assert_equal(1, m2.number_of_students)
  #   assert_equal(s1, m2.student(0))
  #   
  #   assert_equal(m, s1.mentor(0))
  #   assert_equal(m2, s1.mentor(1))
  #   
  #   assert_equal(m, s2.mentor(0))
  #   assert_equal(m, s3.mentor(0))
  # end   
  # 
  # 
  # def test_remove_student
  #   m = MentorN.new("blah")
  #   s = StudentN.new(99)
  #   
  #   m.add_student(s)
  #   m.remove_student(s)
  #   
  #   assert_equal(0,s.number_of_mentors)
  #   assert_equal(0,m.number_of_students)
  # end  
  # 
  # 
  # def test_deleteAll
  #   m = MentorN.new("blah")
  #   m2 = MentorN.new("blah2")
  #   
  #   s = StudentN.new(99)
  #   s2 = StudentN.new(98)
  #   s3 = StudentN.new(97)
  #   
  #   m.add_student(s)
  #   m.add_student(s2)
  #   m.add_student(s3)
  # 
  #   m2.add_student(s2)
  #   
  #   m.delete
  # 
  #   assert_equal(0,m.number_of_students)
  #   assert_equal(1,m2.number_of_students)
  #   
  #   assert_equal(0,s.number_of_mentors)
  #   assert_equal(1,s2.number_of_mentors)
  #   assert_equal(0,s3.number_of_mentors)
  # end  
  
end
end