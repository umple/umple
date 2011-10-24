require 'test/unit'
require './src-gen-umple/student_'
require './src-gen-umple/mentor_'
require './src-gen-umple/program_'

module CruiseTest
class EmptyStateTest < Test::Unit::TestCase

    
  function test_getStateMachine
    course = new CourseA
    assert_equal(nil,course.getStatus)
  end
end