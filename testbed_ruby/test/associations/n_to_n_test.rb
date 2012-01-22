require 'test/unit'
require './src-gen-umple/student_v'
require './src-gen-umple/mentor_v'
require './src-gen-umple/program_v'

module CruiseAssociations
class NToNTest < Test::Unit::TestCase

  def test_CreateStudentWithoutMentor
    s = StudentV.new(99)
    assert_equal(0,s.number_of_mentors)
  end
  
  def test_CreateMentorWithoutStudent
    m = MentorV.new("blah")
    assert_equal(0,m.number_of_students)
  end
  
  def test_SetStudentsJustRightEnough
    m = MentorV.new("blah")
    
    s = StudentV.new(99)
    s2 = StudentV.new(98)
    s3 = StudentV.new(97)
    
    assert_equal(true,m.set_students([s,s2,s3]))
    
    assert_equal(3,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
  end  
  
  def test_SetStudentsTooMany
    m = MentorV.new("blah")
    
    s = StudentV.new(99)
    s2 = StudentV.new(98)
    s3 = StudentV.new(97)
    s4 = StudentV.new(96)
    
    assert_equal(false,m.set_students([s,s2,s3,s4]))
  end   
  
  def test_AddStudents
    m = MentorV.new("blah")
    
    s = StudentV.new(99)
    s2 = StudentV.new(98)
    s3 = StudentV.new(97)
    s4 = StudentV.new(96)
    s5 = StudentV.new(95)
    s6 = StudentV.new(94)

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
    m = MentorV.new("blah")
    
    s = StudentV.new(99)
    s2 = StudentV.new(98)
    s3 = StudentV.new(97)

    m.set_students([s,s2,s3])
    assert_equal(false,m.remove_student(s3))
  end 
  
  def test_SetStudentsTooManyAndTooFew
    m = MentorV.new("blah")
    
    s = StudentV.new(99)
    s2 = StudentV.new(98)
    s3 = StudentV.new(97)
    s4 = StudentV.new(96)
    s5 = StudentV.new(95)
    
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
    m = MentorV.new("blah")
    
    s = StudentV.new(99)
    s2 = StudentV.new(98)
    s3 = StudentV.new(97)
    
    m.set_students([s,s2,s3])
    
    s6 = StudentV.new(94)
    assert_equal(false,m.add_student(s6))
    
    assert_equal(3,m.number_of_students)
    assert_equal(0,s6.number_of_mentors)
  end    

  def test_set_mentors
    m = MentorV.new("blah")
    m2 = MentorV.new("blah2")
    m3 = MentorV.new("blah3")
    m4 = MentorV.new("blah4")

    s = StudentV.new(99)
    s2 = StudentV.new(98)
    
    assert_equal(true,s.set_mentors([m2,m3,m,m4]))
    assert_equal(true,m2.add_student(s2))

    
    assert_equal(2,m2.number_of_students)
    assert_equal(1,m3.number_of_students)
    assert_equal(4,s.number_of_mentors)
  end 

  def test_is_number_of_students_valid
    m = MentorV.new("blah")
    assert_equal(false,m.is_number_of_students_valid)

    m.add_student(StudentV.new(99))
    assert_equal(false,m.is_number_of_students_valid)

    m.add_student(StudentV.new(98))
    assert_equal(false,m.is_number_of_students_valid)

    m.add_student(StudentV.new(97))
    assert_equal(true,m.is_number_of_students_valid)
  end
  
  def test_getBoundsForStudent
    assert_equal(3,MentorV::minimum_number_of_students)
    assert_equal(3,MentorV::maximum_number_of_students)
  end  

  def test_deleteMentorAndStudentNowHasTooFewMentors
    m = MentorV.new("blah")
    m2 = MentorV.new("blah2")

    s = StudentV.new(99)
    s2 = StudentV.new(98)
    s3 = StudentV.new(97)
    
    m.set_students([s,s2,s3])
    m2.set_students([s,s2,s3])
    
    p = ProgramV.new
    s.set_program(p)
    
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(0,m2.number_of_students)
    assert_equal(0,s.number_of_mentors)
  end  

end
end