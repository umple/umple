require 'test/unit'
require './src-gen-umple/student_l'
require './src-gen-umple/mentor_l'
require './src-gen-umple/program_l'

module CruiseAssociations
class OneToNTest < Test::Unit::TestCase

  def test_cannotCreateNullStudent
    assert_raise RuntimeError do #"Unable to create student due to mentor"
      StudentL.new(99,nil)
    end
  end
  
  def test_CreateMentorWithoutStudent
    m = MentorL.new("blah")
    assert_equal(0,m.number_of_students)
  end
  
  def test_CannotSetMentorNull
    m = MentorL.new("blah")
    s = StudentL.new(99,m)
    
    assert_equal(false,s.set_mentor(nil))
  end  
  
  def test_CannotSetMentorAlreadyAtMax
    m = MentorL.new("blah")
    m2 = MentorL.new("blah2")
    
    StudentL.new(99,m)
    StudentL.new(98,m)    
    
    StudentL.new(97,m2)
    s = StudentL.new(96,m2)
    assert_equal(false,s.set_mentor(m))
    
    assert_equal(2,m.number_of_students)
    assert_equal(2,m2.number_of_students)
    assert_equal(m2,s.get_mentor)
  end    
  
  def test_CannotSetMentorExistingAtMin
    m = MentorL.new("blah")
    m2 = MentorL.new("blah2")
    
    StudentL.new(99,m)
    StudentL.new(98,m)
    
    StudentL.new(97,m2)
    s = StudentL.new(96,m2)
    assert_equal(false,s.set_mentor(m))
    
    assert_equal(2,m.number_of_students)
    assert_equal(2,m2.number_of_students)
    assert_equal(m2,s.get_mentor)
  end   
  
  def test_CreateStudentFromMentor
    m = MentorL.new("blah")
    s = StudentL.new(99,m)
  
    assert_equal(99,s.get_number)
    assert_equal(m,s.get_mentor)
    assert_equal(1,m.number_of_students)
    assert_equal(s,m.get_student(0))
  end  
  
  def test_add_studentConstructorInformation
    m = MentorL.new("blah")
    s = StudentL.new(10,m)
  
    assert_equal(10,s.get_number)
    assert_equal(m,s.get_mentor)
    assert_equal(1,m.number_of_students)
    assert_equal(s,m.get_student(0))
  end
  
  def test_add_studentConstructorInformation_tooMany
    m = MentorL.new("blah")
    s = StudentL.new(10,m)
    s = StudentL.new(11,m)

    assert_raise RuntimeError do #"Unable to create student due to mentor"
      s = StudentL.new(13,m)
    end
  end
  
  def test_createStudentWhenMentorAlreadyHasEnogh
    assert_raise RuntimeError do #"Unable to create student due to mentor"
      m = MentorL.new("blah")
      StudentL.new(10,m)
      StudentL.new(11,m)
      StudentL.new(12,m)
      StudentL.new(13,m)
    end
  end  
  
  def test_cannotReplaceMentor
    m = MentorL.new("blah")
    m2 = MentorL.new("blah2")
  
    s = StudentL.new(123,m)
    s2 = StudentL.new(125,m2)
    
    assert_equal(false,s.set_mentor(m2))
    assert_equal(m,s.get_mentor)
    assert_equal(1,m2.number_of_students)
    
    assert_equal(1,m.number_of_students)
  end 
  
  def test_cannotReassign
    m = MentorL.new("blah")
    m2 = MentorL.new("blah2")
  
    s = StudentL.new(123,m)
    assert_equal(false,m2.add_student(s))
  end  
  
  def test_cannotRemoveFromExistingMentor
    m = MentorL.new("blah")
    m2 = MentorL.new("blah2")
  
    s1 = StudentL.new(123,m)
    StudentL.new(124,m)
    
    assert_equal(2,m.number_of_students)
    assert_equal(0,m2.number_of_students)
    
    assert_equal(false,m2.add_student(s1))
  end
  
  def test_is_number_of_students_valid
    m = MentorL.new("blah")
    assert_equal(false,m.is_number_of_students_valid)
  
    StudentL.new(99,m)
    assert_equal(false,m.is_number_of_students_valid)
  
    StudentL.new(98,m)
    assert_equal(true,m.is_number_of_students_valid)
  end
  
  def test_getBoundsForStudent
    assert_equal(2,MentorL::minimum_number_of_students)
    assert_equal(2,MentorL::maximum_number_of_students)
  end  
  
  def test_add_studentWhenMentorHasTooMany
    m = MentorL.new("blah")
    m2 = MentorL.new("blah2")
    
    s = StudentL.new(12,m)
    StudentL.new(13,m)
    
    StudentL.new(21,m2)
    StudentL.new(22,m2)
    
    assert_equal(false,m.add_student(s))
  
    assert_equal(2,m.number_of_students)
    assert_equal(2,m2.number_of_students)
  end  
  
  def test_add_studentWhenMentorHasTooFew
    m = MentorL.new("blah")
    m2 = MentorL.new("blah2")
    
    StudentL.new(12,m)
    StudentL.new(13,m)
    
    StudentL.new(21,m2)
    s = StudentL.new(23,m2)
    
    assert_equal(false,m.add_student(s))
  
    assert_equal(2,m.number_of_students)
    assert_equal(2,m2.number_of_students)
   end  
end
end