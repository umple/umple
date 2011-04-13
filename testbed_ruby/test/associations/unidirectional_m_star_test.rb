require 'test/unit'
require 'src/student_a_l'
require 'src/mentor_a_l'
require 'src/program_a_l'

module CruiseTest
class UnidirectionalMStarTest < Test::Unit::TestCase

  def test_constructorTooFew
  	assert_raise RuntimeError do #"Unable to create MentorAL, must have at least 3 students"
      s = StudentAL.new(99)
      s2 = StudentAL.new(98)
      MentorAL.new("blah",[s,s2])
    end
  end

  def test_constructorRequiresMinimum
    s = StudentAL.new(99)
    s2 = StudentAL.new(98)
    s3 = StudentAL.new(97)
    
    m = MentorAL.new("blah",[s,s2,s3])
    assert_equal(3,m.number_of_students)
  end
  
  def test_addRemoveWithinLimits
    s = StudentAL.new(99)
    s2 = StudentAL.new(98)
    s3 = StudentAL.new(97)
    s4 = StudentAL.new(96)
    s5 = StudentAL.new(95)
    s6 = StudentAL.new(94)
    
    m = MentorAL.new("blah",[s,s2,s3])
    assert_equal(3,m.number_of_students)
    assert_equal(true,m.add_student(s4))
    assert_equal(true,m.add_student(s5))
    
    assert_equal(5,m.number_of_students)
    
    assert_equal(false,m.remove_student(s6))
    assert_equal(true,m.remove_student(s3))
    assert_equal(true,m.remove_student(s4))
    assert_equal(false,m.remove_student(s))
    assert_equal(3,m.number_of_students)
  end

  def test_deleteDoesNotChangeStudent
    s = StudentAL.new(99)
    s2 = StudentAL.new(98)
    s3 = StudentAL.new(97)

    p = ProgramAL.new
    s.set_program(p)
    
    m = MentorAL.new("blah",[s,s2,s3])
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(p,s.get_program)
  end
end
end