
require 'test/unit'
require 'src/door_b'
require 'src/door_d'
require 'src/door_f'

module CruiseAttributesTest
class DefaultedTest < Test::Unit::TestCase

  def test_defaulted
    door = DoorD.new
    
    assert_equal("1",door.get_id)
    door.set_id "2"
    assert_equal("2",door.get_id)
    assert_equal(true, door.reset_id)
    assert_equal("1",door.get_id)
    
    assert_equal(2,door.get_intId)
    door.set_intId 3
    assert_equal(3,door.get_intId)
    assert_equal(true, door.reset_intId)
    assert_equal(2,door.get_intId)

    assert_equal(3.4,door.get_doubleId,0.01)
    door.set_doubleId 33.44
    assert_equal(33.44,door.get_doubleId,0.01)
    assert_equal(true, door.reset_doubleId)
    assert_equal(3.4,door.get_doubleId,0.01)

    assert_equal(Date.parse("1978-12-05"),door.get_dateId)
    door.set_dateId(Date.parse("1978-01-02"))
    assert_equal(Date.parse("1978-01-02"),door.get_dateId)
    assert_equal(true, door.reset_dateId)
    assert_equal(Date.parse("1978-12-05"),door.get_dateId)

    assert_equal(Time.parse("10:11:15"),door.get_timeId)
    door.set_timeId(Time.parse("13:14:15"))
    assert_equal(Time.parse("13:14:15"),door.get_timeId)
    assert_equal(true, door.reset_timeId)
    assert_equal(Time.parse("10:11:15"),door.get_timeId)

    assert_equal(false,door.get_booleanId)
    door.set_booleanId(true)
    assert_equal(true,door.get_booleanId)
    assert_equal(true, door.reset_booleanId)
    assert_equal(false,door.get_booleanId)

    assert_equal(5,door.get_doorId.get_id)
    door.set_doorId(DoorB.new(6))
    assert_equal(6,door.get_doorId.get_id)
    assert_equal(true, door.reset_doorId)
    assert_equal(5,door.get_doorId.get_id)
  end
end
end
