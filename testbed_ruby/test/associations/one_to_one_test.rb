require 'test/unit'
require './src-gen-umple/student_g'
require './src-gen-umple/mentor_g'
require './src-gen-umple/program_g'

module CruiseAssociations
class OneToOneTest < Test::Unit::TestCase

  def test_Constructor
    m = MentorG.new("a",nil)
    s = StudentG.new(1,m)
    
    assert_equal("a",m.get_name)
    assert_equal(1,s.get_number)
    assert_equal(s,m.get_student)
    assert_equal(m,s.get_mentor)
  end
  
  def test_MustCreateRelationship
  	assert_raise RuntimeError do #"Unable to create StudentG due to aMentor"
      m = MentorG.new("a",nil)
      m.get_student
    end
  end  
  
  def test_delete
    m = MentorG.new("a",nil)
    s = StudentG.new(1,m)

    s.set_program(ProgramG.new)
    m.delete
    assert_equal(nil,m.get_student)
    assert_equal(nil,m.get_program)
    assert_equal(nil,s.get_mentor)
    assert_equal(nil,s.get_program)
  end
  
end
end
