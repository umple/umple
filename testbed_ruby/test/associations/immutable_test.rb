require 'test/unit'
require './src-gen-umple/mentor_c'
require './src-gen-umple/class_many_association'
require './src-gen-umple/class_m_to_n_association'
require './src-gen-umple/class_m_star_association'
require './src-gen-umple/class_n_association'
require './src-gen-umple/class_one_association'
require './src-gen-umple/class_optional_n_association'
require './src-gen-umple/class_optional_one_association'
require './src-gen-umple/otherclass'

module CruiseAssociations
class ImmutableAssociationTest < Test::Unit::TestCase

  def test_mutableClassHasSettersRemoversAndAddMethods
    mentor = MentorC.new("name")
    assert_equal(true,object_class_has_adders_or_removers(mentor))
  end
  

  def test_unidirectionalManyAssociation
    other1 = Otherclass.new("otherClass")
    other2 = Otherclass.new("otherClass")

    many = ClassManyAssociation.new([])
    assert_equal(false,many.has_otherclasses)
    many.delete
    assert_equal(false,many.has_otherclasses)

    many = ClassManyAssociation.new([other1])
    assert_equal(true,many.has_otherclasses)

    many = ClassManyAssociation.new([other1, other2])
    assert_equal(true,many.has_otherclasses)
    assert_equal(true,many.index_of_otherclass(other1) >= 0)
    assert_equal(true,many.index_of_otherclass(other2) >= 0)
    assert_equal(false,object_class_has_adders_or_removers(many))

    assert_equal(false,many.set_otherclasses([other1,other2]))
  end  


  def test_unidirectionalMToNAssociation
    other1 = Otherclass.new("other")
    other2 = Otherclass.new("other")
    other3 = Otherclass.new("other")
    other4 = Otherclass.new("other")

    assert_raise RuntimeError do 
      mToN = ClassMToNAssociation.new([])
    end
    
    assert_raise RuntimeError do
      mToN = ClassMToNAssociation.new([other1])
    end    

    mToN = ClassMToNAssociation.new([other1,other2])
    assert_equal(true,mToN.has_otherclasses)
    assert_equal(true,mToN.index_of_otherclass(other1) >= 0)
    assert_equal(true,mToN.index_of_otherclass(other2) >= 0)
    mToN.delete
    assert_equal(true,mToN.has_otherclasses)

    assert_equal(false,mToN.set_otherclasses([other1,other2]))

    mToN = ClassMToNAssociation.new([other1,other2,other3])
    assert_equal(true,mToN.has_otherclasses)

    assert_raise RuntimeError do
      mToN = ClassMToNAssociation.new([other1,other2,other3,other4])
    end    

    assert_equal(false,object_class_has_adders_or_removers(mToN))
  end  


  def test_unidirectionalMStarAssociation
    other1 = Otherclass.new("other")
    other2 = Otherclass.new("other")
    other3 = Otherclass.new("other")

    assert_raise RuntimeError do 
      mStar = ClassMStarAssociation.new([])
    end

    assert_raise RuntimeError do 
      mStar = ClassMStarAssociation.new([other1])
    end

    mStar = ClassMStarAssociation.new([other1,other2])
    assert_equal(true,mStar.has_otherclasses)
    assert_equal(true,mStar.index_of_otherclass(other1) >= 0)
    assert_equal(true,mStar.index_of_otherclass(other2) >= 0)
    mStar.delete
    assert_equal(true,mStar.has_otherclasses)

    assert_equal(false,mStar.set_otherclasses([other1,other2]))

    mStar = ClassMStarAssociation.new([other1,other2,other3])
    assert_equal(true,mStar.has_otherclasses)
    
    assert_equal(false,object_class_has_adders_or_removers(mStar))
  end  


  def test_unidirectionalNAssociation
    other1 = Otherclass.new("other")
    other2 = Otherclass.new("other")
    other3 = Otherclass.new("other")

    assert_raise RuntimeError do 
      n = ClassNAssociation.new([])
    end

    assert_raise RuntimeError do 
      n = ClassNAssociation.new([other1])
    end

    n = ClassNAssociation.new([other1,other2])
    assert_equal(true,n.has_otherclasses)
    assert_equal(true,n.index_of_otherclass(other1) >= 0)
    assert_equal(true,n.index_of_otherclass(other2) >= 0)
    n.delete
    assert_equal(true,n.has_otherclasses)

    assert_equal(false,n.set_otherclasses([other1,other2]))

    assert_raise RuntimeError do 
      n = ClassNAssociation.new([other1,other2,other3])
    end
    
    assert_equal(false,object_class_has_adders_or_removers(n))
  end


  def test_unidirectionalOneAssociation
    other = Otherclass.new("otherClass")

    one = ClassOneAssociation.new(other)
    assert_equal(true,one.get_otherclass == other)
    one.delete
    assert_equal(true,one.get_otherclass == other)

    assert_raise RuntimeError do 
      one = ClassOneAssociation.new(nil)
    end
    
    assert_equal(false,object_class_has_adders_or_removers(one))
  end  


  def test_unidirectionalOptionalNAssociation
    other1 = Otherclass.new("other")
    other2 = Otherclass.new("other")
    other3 = Otherclass.new("other")

    optN = ClassOptionalNAssociation.new([])
    assert_equal(false,optN.has_otherclasses)
    
    optN = ClassOptionalNAssociation.new([other1])
    assert_equal(true,optN.has_otherclasses)
    assert_equal(true,optN.index_of_otherclass(other1) >= 0)

    optN = ClassOptionalNAssociation.new([other1,other2])
    assert_equal(true,optN.has_otherclasses)
    assert_equal(true,optN.index_of_otherclass(other1) >= 0)
    assert_equal(true,optN.index_of_otherclass(other2) >= 0)
    optN.delete
    assert_equal(true,optN.has_otherclasses)

    assert_equal(false,optN.set_otherclasses([other1,other2]))

    assert_raise RuntimeError do 
      optN = ClassOptionalNAssociation.new([other1,other2,other3])
    end

    assert_equal(false,object_class_has_adders_or_removers(optN))
  end


  def test_unidirectionalOptionalOneAssociation
    other = Otherclass.new("otherClass")

    optOne = ClassOptionalOneAssociation.new(other)
    assert_equal(true,optOne.get_otherclass == other)
    optOne.delete
    assert_equal(true,optOne.get_otherclass == other)

    optOne = ClassOptionalOneAssociation.new(nil)
    assert_equal(true,optOne.get_otherclass == nil)
    
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
