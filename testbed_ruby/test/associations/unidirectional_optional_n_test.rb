require 'test/unit'
require './src-gen-umple/student_i'
require './src-gen-umple/mentor_i'
require './src-gen-umple/program_i'

module CruiseAssociations
class UnidirectionalOptionalNTest < Test::Unit::TestCase

  def test_constructorTooFew
  	assert_raise RuntimeError do #"Unable to create MentorI, must have 2 to 4 students"
      s = StudentI.new(99)
      MentorI.new("blah",[s])
    end
  end
  
  def test_constructorTooMany
  	assert_raise RuntimeError do #"Unable to create MentorI, must have 2 to 4 students"
      s = StudentI.new(99)
      s2 = StudentI.new(98)
      s3 = StudentI.new(97)
      s4 = StudentI.new(96)
      s5 = StudentI.new(96)
    
      MentorI.new("blah",[s,s2,s3,s4,s5])
    end
  end

  def test_constructorRequiresMinimumToMaximum
    s = StudentI.new(99)
    s2 = StudentI.new(98)
    s3 = StudentI.new(97)
    s4 = StudentI.new(96)
    
    m = MentorI.new("blah",[s,s2])
    assert_equal(2,m.number_of_students)

    m2 = MentorI.new("blah2",[s,s2,s3,s4])
    assert_equal(4,m2.number_of_students)
  end
  
  def test_addRemoveWithinLimits
    s = StudentI.new(99)
    s2 = StudentI.new(98)
    s3 = StudentI.new(97)
    s4 = StudentI.new(96)
    s5 = StudentI.new(95)
    
    m = MentorI.new("blah",[s,s2])
    assert_equal(2,m.number_of_students)
    assert_equal(true,m.add_student(s3))
    assert_equal(true,m.add_student(s4))
    assert_equal(false,m.add_student(s4))
    
    assert_equal(4,m.number_of_students)
    
    assert_equal(false,m.remove_student(s5))
    assert_equal(true,m.remove_student(s3))
    assert_equal(true,m.remove_student(s4))
    assert_equal(false,m.remove_student(s))
    assert_equal(2,m.number_of_students)
  end

  def test_deleteDoesNotChangeStudent
    s = StudentI.new(99)
    s2 = StudentI.new(98)

    p = ProgramI.new
    s.set_program(p)
    
    m = MentorI.new("blah",[s,s2])
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(p,s.get_program)
  end
end
end