require 'test/unit'
require './src-gen-umple/widget_immutable_a'
require './src-gen-umple/widget_immutable_b'
require './src-gen-umple/widget_subclass'
require './src-gen-umple/widget_mutable_b'
require './src-gen-umple/class_many'
require './src-gen-umple/class_m_to_n'
require './src-gen-umple/class_m_star'
require './src-gen-umple/class_n'
require './src-gen-umple/class_one'
require './src-gen-umple/class_optional_n'
require './src-gen-umple/class_optional_one'
require './src-gen-umple/class_otherclass'

module CruisePatternsTest
class ClassLevelImmutabilityTest < Test::Unit::TestCase

  def test_noDeleteForAssociationsAndAttributesOfImmutableClass
    associated = WidgetImmutableB.new("name")

    widget = WidgetImmutableA.new("Big Widget",associated)
    assert_equal(widget.get_name, "Big Widget")
    assert_equal(widget.get_widgetImmutableB, associated)

    widget.delete
    assert_equal(widget.get_name, "Big Widget")
    assert_equal(widget.get_widgetImmutableB, associated)
  end
  

  def test_noDeleteForAssociationsAndAttributesOfSubclassOfImmutableClass
    associated = WidgetImmutableB.new("name")

    widget = WidgetSubclass.new("Little Widget","myType",[associated])
    assert_equal(widget.get_name, "Little Widget")
    assert_equal(widget.get_type, "myType")
    assert_equal(widget.get_widgetImmutableB(0), associated)

    widget.delete
    assert_equal(widget.get_name, "Little Widget")
    assert_equal(widget.get_type, "myType")
    assert_equal(widget.get_widgetImmutableB(0), associated)
  end


  def test_mutableClassHasSettersRemoversAndAddMethods
    widget = WidgetMutableB.new
    assert_equal(true,object_class_has_adders_or_removers(widget))
  end
  

  def test_unidirectionalManyAssociation
    other1 = ClassOtherclass.new("otherClass")
    other2 = ClassOtherclass.new("otherClass")

    many = ClassMany.new([])
    assert_equal(false,many.has_classOtherclasses)
    many = ClassMany.new([other1])
    assert_equal(true,many.has_classOtherclasses)
    many = ClassMany.new([other1, other2])
    assert_equal(true,many.has_classOtherclasses)
    assert_equal(true,many.index_of_classOtherclass(other1) >= 0)
    assert_equal(true,many.index_of_classOtherclass(other2) >= 0)
    assert_equal(false,object_class_has_adders_or_removers(many))

    assert_equal(false,many.set_classOtherclasses([other1,other2]))
  end  


  def test_unidirectionalMToNAssociation
    other1 = ClassOtherclass.new("other")
    other2 = ClassOtherclass.new("other")
    other3 = ClassOtherclass.new("other")
    other4 = ClassOtherclass.new("other")

    assert_raise RuntimeError do 
      mToN = ClassMToN.new([])
    end
    
    assert_raise RuntimeError do
      mToN = ClassMToN.new([other1])
    end    

    mToN = ClassMToN.new([other1,other2])
    assert_equal(true,mToN.has_classOtherclasses)
    assert_equal(true,mToN.index_of_classOtherclass(other1) >= 0)
    assert_equal(true,mToN.index_of_classOtherclass(other2) >= 0)

    assert_equal(false,mToN.set_classOtherclasses([other1,other2]))

    mToN = ClassMToN.new([other1,other2,other3])
    assert_equal(true,mToN.has_classOtherclasses)

    assert_raise RuntimeError do
      mToN = ClassMToN.new([other1,other2,other3,other4])
    end    

    assert_equal(false,object_class_has_adders_or_removers(mToN))
  end  


  def test_unidirectionalMStarAssociation
    other1 = ClassOtherclass.new("other")
    other2 = ClassOtherclass.new("other")
    other3 = ClassOtherclass.new("other")

    assert_raise RuntimeError do 
      mStar = ClassMStar.new([])
    end

    assert_raise RuntimeError do 
      mStar = ClassMStar.new([other1])
    end

    mStar = ClassMStar.new([other1,other2])
    assert_equal(true,mStar.has_classOtherclasses)
    assert_equal(true,mStar.index_of_classOtherclass(other1) >= 0)
    assert_equal(true,mStar.index_of_classOtherclass(other2) >= 0)

    assert_equal(false,mStar.set_classOtherclasses([other1,other2]))

    mStar = ClassMStar.new([other1,other2,other3])
    assert_equal(true,mStar.has_classOtherclasses)
    
    assert_equal(false,object_class_has_adders_or_removers(mStar))
  end  


  def test_unidirectionalNAssociation
    other1 = ClassOtherclass.new("other")
    other2 = ClassOtherclass.new("other")
    other3 = ClassOtherclass.new("other")

    assert_raise RuntimeError do 
      n = ClassN.new([])
    end

    assert_raise RuntimeError do 
      n = ClassN.new([other1])
    end

    n = ClassN.new([other1,other2])
    assert_equal(true,n.has_classOtherclasses)
    assert_equal(true,n.index_of_classOtherclass(other1) >= 0)
    assert_equal(true,n.index_of_classOtherclass(other2) >= 0)

    assert_equal(false,n.set_classOtherclasses([other1,other2]))

    assert_raise RuntimeError do 
      n = ClassN.new([other1,other2,other3])
    end
    
    assert_equal(false,object_class_has_adders_or_removers(n))
  end


  def test_unidirectionalOneAssociation
    other = ClassOtherclass.new("otherClass")

    one = ClassOne.new(other)
    assert_equal(true,one.get_classOtherclass == other)

    assert_raise RuntimeError do 
      one = ClassOne.new(nil)
    end
    
    assert_equal(false,object_class_has_adders_or_removers(one))
  end  


  def test_unidirectionalOptionalNAssociation
    other1 = ClassOtherclass.new("other")
    other2 = ClassOtherclass.new("other")
    other3 = ClassOtherclass.new("other")

    optN = ClassOptionalN.new([])
    assert_equal(false,optN.has_classOtherclasses)
    
    optN = ClassOptionalN.new([other1])
    assert_equal(true,optN.has_classOtherclasses)
    assert_equal(true,optN.index_of_classOtherclass(other1) >= 0)

    optN = ClassOptionalN.new([other1,other2])
    assert_equal(true,optN.has_classOtherclasses)
    assert_equal(true,optN.index_of_classOtherclass(other1) >= 0)
    assert_equal(true,optN.index_of_classOtherclass(other2) >= 0)

    assert_equal(false,optN.set_classOtherclasses([other1,other2]))

    assert_raise RuntimeError do 
      optN = ClassOptionalN.new([other1,other2,other3])
    end

    assert_equal(false,object_class_has_adders_or_removers(optN))
  end


  def test_unidirectionalOptionalOneAssociation
    other = ClassOtherclass.new("otherClass")

    optOne = ClassOptionalOne.new(other)
    assert_equal(true,optOne.get_classOtherclass == other)

    optOne = ClassOptionalOne.new(nil)
    assert_equal(true,optOne.get_classOtherclass == nil)
    
    assert_equal(false,object_class_has_adders_or_removers(optOne))
  end


  def object_class_has_adders_or_removers(obj)
    hasMethods = false
    methods = obj.class.public_instance_methods
    setterNameRegex = /\A(add|remove)_[a-z]+[a-zA-Z]*\Z/

    methods.each do |m|
      if ((m =~ setterNameRegex) == 0)
        hasMethods = true
        break
      end
    end
    hasMethods
  end

end
end
