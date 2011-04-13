require 'test/unit'
require 'src/student_a_k'
require 'src/mentor_a_k'
require 'src/program_a_k'

module CruiseTest
class UnidirectionalNTest < Test::Unit::TestCase

  def test_constructorEmpty
    m = MentorAK.new("blah")
    assert_equal(0,m.number_of_students)
  end
  
  def test_setTooMany
    s = StudentAK.new(99)
    s2 = StudentAK.new(98)
    s3 = StudentAK.new(97)
    s4 = StudentAK.new(96)
    
    m = MentorAK.new("blah")
    assert_equal(false,m.set_students([s,s2,s3,s4]))
    assert_equal(0, m.number_of_students)
  end

  def test_set_students
    s = StudentAK.new(99)
    s2 = StudentAK.new(98)
    s3 = StudentAK.new(97)
    s4 = StudentAK.new(97)
    
    m = MentorAK.new("blah")
    
    assert_equal(false,m.set_students([s,s2,s3,s4]))
    assert_equal(false,m.set_students([s,s2,s2]))
    assert_equal(true,m.set_students([s,s2]))
    
    assert_equal(2,m.number_of_students)
  end
  
  def test_deleteDoesNotChangeStudent
    s = StudentAK.new(99)
    s2 = StudentAK.new(98)
    s3 = StudentAK.new(97)

    p = ProgramAK.new
    s.set_program(p)
    
    m = MentorAK.new("blah")
    m.set_students([s,s2,s3])
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(p,s.get_program)
  end
end
end