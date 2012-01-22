require 'test/unit'
require './src-gen-umple/student_'
require './src-gen-umple/mentor_'
require './src-gen-umple/program_'

module CruiseAssociations
class SimpleStateMachineTest < Test::Unit::TestCase

    
  function test_OneStateNoEvents
  end
    course = new CourseB
    assert_equal("StatusOpen",course.getStatus)
  end
end
