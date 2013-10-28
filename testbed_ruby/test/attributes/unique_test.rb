
require 'test/unit'
require './src-gen-umple/item_with_unique_id'

module CruiseAttributesTest
class ImmutableTest < Test::Unit::TestCase

  def setup
    @one = ItemWithUniqueId.new("1")
    @two = ItemWithUniqueId.new("2")
  end

  def teardown
    @one.delete
    @two.delete
  end

  def testCreateWithDuplicates
    assert_raise ArgumentError do
      duplicate = ItemWithUniqueId.new("1")
    end 
  end
  
  def testHasWithGetWith
    assert(ItemWithUniqueId.has_with_id?("1"))
    assert(!ItemWithUniqueId.has_with_id?("3"))
    assert_equal(ItemWithUniqueId.get_with_id("1"), @one)
    assert_equal(ItemWithUniqueId.get_with_id("2"), @two)
  end
  
  def testSetId
    ## Attempt to change id to "1", which is already used.
    ## This should fail and so id should still be "2".
    assert(!@two.set_id("1"))
    assert_equal(@two.get_id, "2")
    ## Attempt to change id to "3", which is free.
    ## This should succeed and "2" should become available.
    assert(@two.set_id("3"))
    assert_equal(@two.get_id, "3")
    assert(!ItemWithUniqueId.has_with_id?("2"))
    ## Now that "2" is available, we can create a new ItemWithUniqueId with id "2" with no error.
    newTwo = ItemWithUniqueId.new("2")
    newTwo.delete
  end

end
end
