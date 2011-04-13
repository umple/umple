require 'test/unit'
require 'src/door_e'
require 'src/door_f'

module CruiseAttributesTest
class DateTimeStringTest < Test::Unit::TestCase

  def test_Date
    door = DoorE.new
    
    assert_equal("1978-12-01",door.get_d1.to_s)
    assert_equal("1978-12-02",door.get_d2.to_s)
    assert_equal("1978-12-03",door.get_d3.to_s)
    assert_equal("1978-12-04",door.get_d4.to_s)

    door.reset_d3
    assert_equal("1978-12-03",door.get_d3.to_s)
  end

  def test_Time
    door = DoorF.new
    
    assert_equal(Time.parse("12:51:51"),door.get_d1)
    assert_equal(Time.parse("12:52:52"),door.get_d2)
    assert_equal(Time.parse("12:53:53"),door.get_d3)
    assert_equal(Time.parse("12:53:54"),door.get_d4)
  
    door.reset_d3
    assert_equal(Time.parse("12:53:53"),door.get_d3)
  end
  
end
end