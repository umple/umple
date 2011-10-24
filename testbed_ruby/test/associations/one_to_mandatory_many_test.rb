require 'test/unit'
require './src-gen-umple/student_m'
require './src-gen-umple/mentor_m'
require './src-gen-umple/program_m'

module CruiseTest
class OneToMandatoryManyTest < Test::Unit::TestCase

  def test_cannotCreateNullStudent
    assert_raise RuntimeError do #"Unable to create student due to mentor"
      StudentM.new(99,nil)
    end
  end
  
  def test_CreateMentorWithoutStudent
    m = MentorM.new("blah")
    assert_equal(0,m.number_of_students)
  end
  
  def test_CannotSetMentorNull
    m = MentorM.new("blah")
    s = StudentM.new(99,m)
    
    assert_equal(false,s.set_mentor(nil))
  end  
  
  def test_CanAlwaysSetMentorNeverAtMax
  
    m = MentorM.new("blah")
    m2 = MentorM.new("blah2")
    
    StudentM.new(99,m)
    StudentM.new(98,m)
    StudentM.new(97,m)
    
    StudentM.new(96,m2)
    StudentM.new(95,m2)
    
    for i in 1..10
      s = StudentM.new(i,m2)
      assert_equal(true,s.set_mentor(m))
      assert_equal(2,m2.number_of_students)
      assert_equal(3+i,m.number_of_students)
    end
  end    
  
  def test_CannotSetMentorExistingAtMin
  
    m = MentorM.new("blah")
    m2 = MentorM.new("blah2")
    
    StudentM.new(99,m)
    StudentM.new(98,m)
    
    StudentM.new(97,m2)
    s = StudentM.new(96,m2)
    assert_equal(false,s.set_mentor(m))
    
    assert_equal(2,m.number_of_students)
    assert_equal(2,m2.number_of_students)
    assert_equal(m2,s.get_mentor)
  
  
  end   
  
  def test_CreateStudentFromMentor
  
    m = MentorM.new("blah")
    s = StudentM.new(99,m)
  
    assert_equal(99,s.get_number)
    assert_equal(m,s.get_mentor)
    assert_equal(1,m.number_of_students)
    assert_equal(s,m.get_student(0))
  end  
  
  def test_add_studentConstructorInformation
  
    m = MentorM.new("blah")
    s = StudentM.new(10,m)
  
    assert_equal(10,s.get_number)
    assert_equal(m,s.get_mentor)
    assert_equal(1,m.number_of_students)
    assert_equal(s,m.get_student(0))
  end
  
  
  def test_add_studentConstructorInformation_neverTooMany
  
    m = MentorM.new("blah")
    
    for i in 1..9
    
      s = StudentM.new(i,m)
      assert_equal(true,s != nil)
      assert_equal(i,m.number_of_students)
    end
  end
  
  def test_createStudentMentoNeverHasEnough
  
    m = MentorM.new("blah")
    for i in 1..11
    
      StudentM.new(i,m)
      assert_equal(i,m.number_of_students)
    end
  end  
  
  
  
  def test_cannotReplaceMentorIfNotLeftWithoutEnoughStudents
  
    m = MentorM.new("blah")
    m2 = MentorM.new("blah2")
  
    s = StudentM.new(123,m)
    StudentM.new(125,m)
    
    assert_equal(false,s.set_mentor(m2))
  end
  
  def test_replaceMentor
  
    m = MentorM.new("blah")
    m2 = MentorM.new("blah2")
  
    s = StudentM.new(123,m)
    StudentM.new(125,m)
    StudentM.new(124,m)
    
    s2 = StudentM.new(122,m2)
    
    
    assert_equal(true,s.set_mentor(m2))
    
    assert_equal(m2,s.get_mentor)
    assert_equal(2,m2.number_of_students)
    assert_equal(s2,m2.get_student(0))
    assert_equal(s,m2.get_student(1))
    
    assert_equal(2,m.number_of_students)
    
  end 
  
  def test_addToNewMentor
  
    m = MentorM.new("blah")
    m2 = MentorM.new("blah2")
  
    s = StudentM.new(123,m)
    StudentM.new(124,m)
    StudentM.new(125,m)
    
    assert_equal(true,m2.add_student(s))
    assert_equal(m2,s.get_mentor)
    assert_equal(s,m2.get_student(0))
    assert_equal(2,m.number_of_students)
  end  
  
  def test_removeFromExistingMentor
  
    m = MentorM.new("blah")
    m2 = MentorM.new("blah2")
  
    s1 = StudentM.new(123,m)
    s2 = StudentM.new(124,m)
    s3 = StudentM.new(125,m)
    
    assert_equal(3,m.number_of_students)
    assert_equal(0,m2.number_of_students)
    
    m2.add_student(s1)
  
    assert_equal(2,m.number_of_students)
    assert_equal(s2,m.get_student(0))
    assert_equal(s3,m.get_student(1))
    
    assert_equal(1,m2.number_of_students)
    assert_equal(s1,m2.get_student(0))
    
    assert_equal(m2,s1.get_mentor)
    assert_equal(m,s2.get_mentor)
    assert_equal(m,s3.get_mentor)
  end   
  
  def test_set_mentorReplacesExistingMentor
  
    m = MentorM.new("blah")
    s = StudentM.new(99,m)
    StudentM.new(98,m)
    StudentM.new(97,m)
    
    m2 = MentorM.new("blah2")
    
    assert_equal(true,s.set_mentor(m2))
    assert_equal(m2,s.get_mentor)
    assert_equal(s,m2.get_student(0))
    assert_equal(2,m.number_of_students)    
  end
  
  def test_is_number_of_students_valid
  
    m = MentorM.new("blah")
    assert_equal(false,m.is_number_of_students_valid)
  
    StudentM.new(99,m)
    assert_equal(false,m.is_number_of_students_valid)
  
    StudentM.new(98,m)
    assert_equal(true,m.is_number_of_students_valid)
  
    StudentM.new(97,m)
    assert_equal(true,m.is_number_of_students_valid)
  
  end
  
  def test_getBoundsForStudent
  
    assert_equal(2,MentorM::minimum_number_of_students)
  end  
  
  def test_add_studentMentorNeverHasTooMany
  
    m = MentorM.new("blah")
    m2 = MentorM.new("blah2")
    
    StudentM.new(12,m)
    StudentM.new(13,m)
    StudentM.new(14,m)
    
    StudentM.new(21,m2)
    StudentM.new(22,m2)
    s = StudentM.new(23,m2)
    
    assert_equal(true,m.add_student(s))
  
    assert_equal(4,m.number_of_students)
    assert_equal(2,m2.number_of_students)
  end  
  
  def test_add_studentWhenMentorHasTooFew
  
    m = MentorM.new("blah")
    m2 = MentorM.new("blah2")
    
    StudentM.new(12,m)
    StudentM.new(13,m)
    
    StudentM.new(21,m2)
    s = StudentM.new(23,m2)
    
    assert_equal(false,m.add_student(s))
  
    assert_equal(2,m.number_of_students)
    assert_equal(2,m2.number_of_students)
  end  
end
end