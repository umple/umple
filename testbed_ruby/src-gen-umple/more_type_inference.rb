# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE ${last.version} modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAttributesTest
require 'time'
require 'date'

class MoreTypeInference


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MoreTypeInference Attributes - for documentation purposes
  #attr_reader :a, :b, :c, :d, :e, :f, :g, :h, :i, :j, :k, :l

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_b, a_h)
    @initialized = false
    @deleted = false
    @a = Time.parse("12:12:12")
    @b = a_b
    @c = "12:12"
    @d = Time.parse("12:12:12")
    @e = "99:99:99"
    @f = "2000:01:01"
    @g = Date.parse("2000-01-01")
    @h = a_h
    @i = "2000-01"
    @j = "2000:01:01"
    @k = Date.parse("2000-01-01")
    @l = new Object()
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_a(a_a)
    was_set = false
    @a = a_a
    was_set = true
    was_set
  end

  def set_b(a_b)
    was_set = false
    @b = a_b
    was_set = true
    was_set
  end

  def set_c(a_c)
    was_set = false
    @c = a_c
    was_set = true
    was_set
  end

  def set_d(a_d)
    was_set = false
    @d = a_d
    was_set = true
    was_set
  end

  def set_e(a_e)
    was_set = false
    @e = a_e
    was_set = true
    was_set
  end

  def set_f(a_f)
    was_set = false
    @f = a_f
    was_set = true
    was_set
  end

  def set_g(a_g)
    was_set = false
    @g = a_g
    was_set = true
    was_set
  end

  def set_h(a_h)
    was_set = false
    @h = a_h
    was_set = true
    was_set
  end

  def set_i(a_i)
    was_set = false
    @i = a_i
    was_set = true
    was_set
  end

  def set_j(a_j)
    was_set = false
    @j = a_j
    was_set = true
    was_set
  end

  def set_k(a_k)
    was_set = false
    @k = a_k
    was_set = true
    was_set
  end

  def set_l(a_l)
    was_set = false
    @l = a_l
    was_set = true
    was_set
  end

  def get_a
    @a
  end

  def get_b
    @b
  end

  def get_c
    @c
  end

  def get_d
    @d
  end

  def get_e
    @e
  end

  def get_f
    @f
  end

  def get_g
    @g
  end

  def get_h
    @h
  end

  def get_i
    @i
  end

  def get_j
    @j
  end

  def get_k
    @k
  end

  def get_l
    @l
  end

  def delete
    @deleted = true
  end

end
end