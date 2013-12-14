require 'test/unit'
require './src-gen-umple/const_default'
require 'date'
require 'time'

module CruiseAttributesTest
class ConstTest < Test::Unit::TestCase

  def test_Const
    door = ConstDefault.new
    
    assert_equal("0",ConstDefault::I1.to_s)
    assert_equal("0",ConstDefault::I2.to_s)
    assert_equal("0.0",ConstDefault::D1.to_s)
    assert_equal("0.0",ConstDefault::D2.to_s)
    assert_equal("0.0",ConstDefault::F1.to_s)
    assert_equal("0.0",ConstDefault::F2.to_s)
    assert_equal("false",ConstDefault::B1.to_s)
    assert_equal("false",ConstDefault::B2.to_s)
    assert_equal("",ConstDefault::STR)
    today = Time.now
    todayStr = today.strftime("%Y-%m-%d")
    assert_equal("00:00:00", ConstDefault::TIME.strftime("%H:%M:%S"))
    assert_equal(todayStr, ConstDefault::DATE.strftime("%Y-%m-%d"))
  end
   
end


end
