require 'test/unit'
require 'src/student_a_d'
require 'src/mentor_a_d'
require 'src/program_a_d'

module CruiseTest
class MStarToOptionalNTest < Test::Unit::TestCase

  def test_CreateStudentWihtoutMentor
    s = StudentAD.new(99)
    assert_equal(false,s.is_number_of_mentors_valid)
  end
  
  def test_CreateMentorWithoutStudent
    m = MentorAD.new("blah")
    assert_equal(0,m.number_of_students)
  end
  
  def test_AddStudentsAndMentorsOkay
    m = MentorAD.new("blah")
    m2 = MentorAD.new("blah2")
    m3 = MentorAD.new("blah3")
    m4 = MentorAD.new("blah4")
    m5 = MentorAD.new("blah5")
    m6 = MentorAD.new("blah6")
    
    s = StudentAD.new(99)
    s2 = StudentAD.new(98)
    s3 = StudentAD.new(97)

    assert_equal(true,m.add_student(s))
    assert_equal(true,m.add_student(s2))
    assert_equal(false,m.add_student(s3))
    
    assert_equal(true,s.add_mentor(m2))
    assert_equal(true,s.add_mentor(m3))
    assert_equal(true,s.add_mentor(m4))
    assert_equal(true,s.add_mentor(m5))
    assert_equal(true,s.add_mentor(m6))
    
    assert_equal(2,m.number_of_students)
    assert_equal(m4,s.get_mentor(3))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(6,s.number_of_mentors)
  end
  
  def test_isNumberOfValid  
    s = StudentAD.new(99)
    assert_equal(false,s.is_number_of_mentors_valid)

    s.add_mentor(MentorAD.new("blah"))
    assert_equal(false,s.is_number_of_mentors_valid)

    s.add_mentor(MentorAD.new("blah2"))
    assert_equal(false,s.is_number_of_mentors_valid)

    s.add_mentor(MentorAD.new("blah3"))
    assert_equal(true,s.is_number_of_mentors_valid)

    s.add_mentor(MentorAD.new("blah4"))
    assert_equal(true,s.is_number_of_mentors_valid)
  end
  
  def test_RemoveMiddleMentorWhenNotValidMaintainsTheOrder
    s = StudentAD.new(99)
    
    m = MentorAD.new("blah")
    m2 = MentorAD.new("blah2")
    m3 = MentorAD.new("blah3")

    s.add_mentor(m)
    s.add_mentor(m2)
    s.add_mentor(m3)
    assert_equal(false,s.remove_mentor(m2))
    assert_equal(3,s.number_of_mentors)
    assert_equal(m2,s.get_mentor(1))
  end 
  
  def test_RemoveStudents
    m = MentorAD.new("blah")
    m2 = MentorAD.new("blah2")
    m3 = MentorAD.new("blah3")
    m4 = MentorAD.new("blah4")
    
    s = StudentAD.new(99)
    s2 = StudentAD.new(98)
    s3 = StudentAD.new(97)
    
    m.add_student(s)
    m.add_student(s2)
    m2.add_student(s)
    m2.add_student(s2)
    m3.add_student(s)
    m3.add_student(s2)
    m4.add_student(s)
    m4.add_student(s2)
    
    assert_equal(false,m.remove_student(s3))
    assert_equal(true,m.remove_student(s2))
    
    assert_equal(3,s2.number_of_mentors)
    assert_equal(1,m.number_of_students)
  end 
  
  def test_SetStudentsTooMany
    m = MentorAD.new("blah")
    
    s = StudentAD.new(99)
    s2 = StudentAD.new(98)
    s3 = StudentAD.new(97)
    
    assert_equal(true,m.add_student(s))
    assert_equal(true,m.add_student(s2))
    assert_equal(false,m.add_student(s3))
    
    assert_equal(2,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(0,s3.number_of_mentors)
  end   
  
  def test_MentorAlreadyHasEnoughStudents
    m = MentorAD.new("blah")
    
    s = StudentAD.new(99)
    s2 = StudentAD.new(98)
    s3 = StudentAD.new(97)
    
    m.add_student(s)
    m.add_student(s2)
    
    assert_equal(false,m.add_student(s3))
    
    assert_equal(2,m.number_of_students)
    assert_equal(0,s3.number_of_mentors)
  end    
  

  def test_getBoundsForStudent
    assert_equal(2,MentorAD::maximum_number_of_students)
  end  
  
  def test_getBoundsForMentor
    assert_equal(3,StudentAD::minimum_number_of_mentors)
  end    
  

  def test_deleteMentorAndStudentHasEnough
    m = MentorAD.new("blah")
    m2 = MentorAD.new("blah2")
    m3 = MentorAD.new("blah3")
    m4 = MentorAD.new("blah4")

    s = StudentAD.new(99)
    s2 = StudentAD.new(98)
    
    m.add_student(s)
    m.add_student(s2)
    m2.add_student(s)
    m2.add_student(s2)
    m3.add_student(s)
    m3.add_student(s2)
    m4.add_student(s)
    m4.add_student(s2)
    
    p = ProgramAD.new
    s.set_program(p)
    
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(p,s.get_program)
    assert_equal(3,s.number_of_mentors)
  end  

  def test_deleteMentorAndStudentNowHasTooFewMentors
    m = MentorAD.new("blah")
    m2 = MentorAD.new("blah2")
    m3 = MentorAD.new("blah3")

    s = StudentAD.new(99)
    s2 = StudentAD.new(98)
    
    m.add_student(s)
    m.add_student(s2)
    m2.add_student(s)
    m2.add_student(s2)
    m3.add_student(s)
    m3.add_student(s2)
    
    p = ProgramAD.new
    s.set_program(p)

    assert_equal(2,m.number_of_students)
    assert_equal(2,m2.number_of_students)
    assert_equal(3,s.number_of_mentors)

    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(0,m2.number_of_students)
    assert_equal(0,s.number_of_mentors)
  end  

end
end