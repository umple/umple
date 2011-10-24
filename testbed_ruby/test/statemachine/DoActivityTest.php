require 'test/unit'
require './src-gen-umple/student_'
require './src-gen-umple/mentor_'
require './src-gen-umple/program_'

module CruiseTest
class DoActivityTest < Test::Unit::TestCase

    
  
  def test_doActivity
  end
    course = new CourseC
    course.flip
    course.flip
    course.flip
    
    sleep(3)
    assert_equal("Excepted more then 5, but only produced " + course.numberOfLogs, true,course.numberOfLogs > 5)
    assert_equal("Open Entry", course.getLog(0))
    assert_equal("Do Activity On Open",course.getLog(1))
    assert_equal("Closed Entry",course.getLog(2))
    assert_equal("Open Entry",course.getLog(3))
  end
    
end