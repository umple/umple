require 'test/unit'
require './src-gen-umple/student_a_i'
require './src-gen-umple/mentor_a_i'
require './src-gen-umple/program_a_i'

module CruiseTest
class UnidirectionalOptionalOneTest < Test::Unit::TestCase

  def test_set_student
    s = StudentAI.new(1)
    m = MentorAI.new("a")
    assert_equal("a",m.get_name)
    assert_equal(nil,m.get_student)

    m.set_student(s)
    assert_equal(s,m.get_student)
    assert_equal(1,m.get_student.get_number)
  end
  
  def test_deleteLeavesStudentAlone
    m = MentorAI.new("a")
    s = StudentAI.new(1)
    m.set_student(s)
    p = ProgramAI.new
    s.set_program(p)
    m.delete
    assert_equal(nil,m.get_student)
    assert_equal(nil,m.get_program)
    assert_equal(p,s.get_program)
    
  end
end
end