require 'test/unit'
require 'src/student_'
require 'src/mentor_'
require 'src/program_'

module CruiseTest
class SimpleStateMachineTest < Test::Unit::TestCase

    
  function test_OneStateNoEvents
  end
    course = new CourseB
    assert_equal("StatusOpen",course.getStatus)
  end
end
