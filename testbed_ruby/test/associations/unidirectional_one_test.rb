require 'test/unit'
require './src-gen-umple/student_a_h'
require './src-gen-umple/mentor_a_h'
require './src-gen-umple/program_a_h'

module CruiseTest
class UnidirectionalOneTest < Test::Unit::TestCase

  def test_ConstructorManySide
    s = StudentAH.new(1)
    m = MentorAH.new("a",s)
    assert_equal("a",m.get_name)
    assert_equal(1,m.get_student.get_number)
  end
  
  def test_ConstructorCannotSetNull
  	assert_raise RuntimeError do #"Unable to create MentorAH due to aStudent"
      MentorAH.new("a",nil)
    end
  end   
  
  def test_deleteLeavesStudentAlone
    m = MentorAH.new("a",StudentAH.new(1))
    s = m.get_student
    p = ProgramAH.new
    s.set_program(p)
    m.delete
    assert_equal(nil,m.get_student)
    assert_equal(nil,m.get_program)
    assert_equal(p,s.get_program)
  end
end
end
