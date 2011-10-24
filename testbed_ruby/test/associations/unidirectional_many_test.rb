require 'test/unit'
require './src-gen-umple/student_p'
require './src-gen-umple/mentor_p'
require './src-gen-umple/program_p'

module CruiseTest
class UnidirectionalManyTest < Test::Unit::TestCase

  def test_add_student
    m = MentorP.new("blah")
    s = StudentP.new(1)
    m.add_student(s)
    assert_equal(s,m.get_student(0))
  end
  
  def test_addSameStudent
    m = MentorP.new("blah")
    s = StudentP.new(1)
    
    assert_equal(true,m.add_student(s))

    assert_equal(1,m.number_of_students)
    assert_equal(s,m.get_student(0))
  end  
  
  def test_remove_student
    m = MentorP.new("blah")
    s = StudentP.new(1)
    
    assert_equal(true,m.add_student(s))
    assert_equal(true,m.remove_student(s))
    assert_equal(false,m.remove_student(s))

    assert_equal(0,m.number_of_students)
  end   


  def test_addMultipleMentors
    m = MentorP.new("blah")
    m2 = MentorP.new("blah")

    s = StudentP.new(99)
    assert_equal(0,m.number_of_students)
    assert_equal(0,m2.number_of_students)

    m.add_student(s)
    
    assert_equal(1,m.number_of_students)
    assert_equal(0,m2.number_of_students)

    m2.add_student(s)

    assert_equal(1,m.number_of_students)
    assert_equal(1,m2.number_of_students)

    assert_equal(s,m.get_student(0))
    assert_equal(s,m2.get_student(0))
  end
  
  def test_deleteDoesNotRemoveStudentsFromMentors
    m = MentorP.new("blah")
    m2 = MentorP.new("blah")
    m3 = MentorP.new("blah")
    
    s = StudentP.new(99)
    s2 = StudentP.new(98)
    s3 = StudentP.new(97)
    
    m.add_student(s)
    m.add_student(s2)
    
    m2.add_student(s)
    m3.add_student(s3)
    
    s.delete
    
    assert_equal(2,m.number_of_students)
    assert_equal(1,m2.number_of_students)
    assert_equal(1,m3.number_of_students)
  end
  
end
end
