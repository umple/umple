require 'test/unit'
require 'src/student_t'
require 'src/mentor_t'
require 'src/program_t'

module CruiseTest
class MNToNTest < Test::Unit::TestCase

  def test_CreateStudentWithoutMentor
    s = StudentT.new(99)
    assert_equal(0,s.number_of_mentors)
  end
  
  def test_CreateMentorWithoutStudent
    m = MentorT.new("blah")
    assert_equal(0,m.number_of_students)
  end
  
  def test_SetStudentsJustRightEnough
    m = MentorT.new("blah")
    
    s = StudentT.new(99)
    s2 = StudentT.new(98)
    s3 = StudentT.new(97)
    
    assert_equal(true,m.set_students([s,s2,s3]))
    
    assert_equal(3,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
  end  
  
  def test_SetStudentsTooMany
    m = MentorT.new("blah")
    
    s = StudentT.new(99)
    s2 = StudentT.new(98)
    s3 = StudentT.new(97)
    s4 = StudentT.new(96)
    
    assert_equal(false,m.set_students([s,s2,s3,s4]))
  end   
  
  def test_AddStudents
    m = MentorT.new("blah")
    
    s = StudentT.new(99)
    s2 = StudentT.new(98)
    s3 = StudentT.new(97)
    s4 = StudentT.new(96)
    s5 = StudentT.new(95)
    s6 = StudentT.new(94)

    assert_equal(true,m.add_student(s))
    assert_equal(true,m.add_student(s2))
    assert_equal(true,m.add_student(s3))
    assert_equal(false,m.add_student(s4))
    assert_equal(false,m.add_student(s5))
    assert_equal(false,m.add_student(s6))
    
    assert_equal(3,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(0,s4.number_of_mentors)
    assert_equal(0,s5.number_of_mentors)
    assert_equal(0,s6.number_of_mentors)
  end   
  
  def test_CannotRemoveStudents
    m = MentorT.new("blah")
    
    s = StudentT.new(99)
    s2 = StudentT.new(98)
    s3 = StudentT.new(97)

    m.set_students([s,s2,s3])
    assert_equal(false,m.remove_student(s3))
  end 
  
  def test_SetStudentsTooManyAndTooFew
    m = MentorT.new("blah")
    
    s = StudentT.new(99)
    s2 = StudentT.new(98)
    s3 = StudentT.new(97)
    s4 = StudentT.new(96)
    s5 = StudentT.new(95)
    
    assert_equal(true,m.set_students([s,s2,s3]))
    
    assert_equal(false,m.set_students([s4,s5]))
    assert_equal(false,m.set_students([s4,s5,s,s2]))
    
    assert_equal(3,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(0,s4.number_of_mentors)
    assert_equal(0,s5.number_of_mentors)
    assert_equal(0,s5.number_of_mentors)
  end   
  
  def test_MentorAlreadyHasEnoughStudents
    m = MentorT.new("blah")
    
    s = StudentT.new(99)
    s2 = StudentT.new(98)
    s3 = StudentT.new(97)
    
    m.set_students([s,s2,s3])
    
    s6 = StudentT.new(94)
    assert_equal(false,m.add_student(s6))
    
    assert_equal(3,m.number_of_students)
    assert_equal(0,s6.number_of_mentors)
  end    

  def test_set_mentors
    m2 = MentorT.new("blah2")
    m3 = MentorT.new("blah3")

    s = StudentT.new(99)
    s2 = StudentT.new(98)
    
    assert_equal(true,s.set_mentors([m2,m3]))
    assert_equal(true,m2.add_student(s2))

    
    assert_equal(2,m2.number_of_students)
    assert_equal(1,m3.number_of_students)
    assert_equal(2,s.number_of_mentors)
  end
 
  def test_is_number_of_students_valid
    m = MentorT.new("blah")
    assert_equal(false,m.is_number_of_students_valid)

    m.add_student(StudentT.new(99))
    assert_equal(false,m.is_number_of_students_valid)

    m.add_student(StudentT.new(98))
    assert_equal(false,m.is_number_of_students_valid)

    m.add_student(StudentT.new(97))
    assert_equal(true,m.is_number_of_students_valid)
  end
  
  def test_getBoundsForStudent
    assert_equal(3,MentorT::minimum_number_of_students)
    assert_equal(3,MentorT::maximum_number_of_students)
  end  
  
  def test_deleteMentorAndStudentHasEnough
    m = MentorT.new("blah")
    m2 = MentorT.new("blah2")
    m3 = MentorT.new("blah3")

    s = StudentT.new(99)
    s2 = StudentT.new(98)
    s3 = StudentT.new(97)
    
    m.set_students([s,s2,s3])
    m2.set_students([s,s2,s3])
    m3.set_students([s,s2,s3])
    
    p = ProgramT.new
    s.set_program(p)
    
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(p,s.get_program)
    assert_equal(2,s.number_of_mentors)
  end  

  def test_deleteMentorAndStudentNowHasTooFewMentors
    m = MentorT.new("blah")
    m2 = MentorT.new("blah2")

    s = StudentT.new(99)
    s2 = StudentT.new(98)
    s3 = StudentT.new(97)
    
    m.set_students([s,s2,s3])
    m2.set_students([s,s2,s3])
    
    p = ProgramT.new
    s.set_program(p)
    
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(0,m2.number_of_students)
    assert_equal(0,s.number_of_mentors)
  end  

end
end
