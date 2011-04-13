require 'test/unit'
require 'src/student_'
require 'src/mentor_'
require 'src/program_'

module CruiseTest
class EmptyStateTest < Test::Unit::TestCase

    
  function test_getStateMachine
    course = new CourseA
    assert_equal(nil,course.getStatus)
  end
end