require 'test/unit'
require './src-gen-umple/student_s'
require './src-gen-umple/mentor_s'
require './src-gen-umple/program_s'

module CruiseAssociations
class MNToMNTest < Test::Unit::TestCase

  def test_CreateStudentWithoutMentor
    s = StudentS.new(99)
    assert_equal(0,s.number_of_mentors)
  end

  def test_CreateMentorWithoutStudent
    m = MentorS.new("blah")
    assert_equal(0,m.number_of_students)
  end

  def test_SetStudentsJustEnough
    m = MentorS.new("blah")
    
    s = StudentS.new(99)
    s2 = StudentS.new(98)
    s3 = StudentS.new(97)
    
    assert_equal(true,m.set_students([s,s2,s3]))
    
    assert_equal(3,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
  end  
  
  def test_SetStudentsAtMax
    m = MentorS.new("blah")
    
    s = StudentS.new(99)
    s2 = StudentS.new(98)
    s3 = StudentS.new(97)
    s4 = StudentS.new(96)
    s5 = StudentS.new(95)
    
    assert_equal(true,m.set_students([s,s2,s3,s4,s5]))
    
    assert_equal(5,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(m,s4.get_mentor(0))
    assert_equal(m,s5.get_mentor(0))
  end   
  
  def test_AddStudents
    m = MentorS.new("blah")
    
    s = StudentS.new(99)
    s2 = StudentS.new(98)
    s3 = StudentS.new(97)
    s4 = StudentS.new(96)
    s5 = StudentS.new(95)
    s6 = StudentS.new(94)

    assert_equal(true,m.add_student(s))
    assert_equal(true,m.add_student(s2))
    assert_equal(true,m.add_student(s3))
    assert_equal(true,m.add_student(s4))
    assert_equal(true,m.add_student(s5))
    assert_equal(false,m.add_student(s6))
    
    assert_equal(5,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(m,s4.get_mentor(0))
    assert_equal(m,s5.get_mentor(0))
    assert_equal(0,s6.number_of_mentors)
  end   

  def test_RemoveMiddleStudentWhenNotValidMaintainsTheOrder
    m = MentorS.new("blah")
    
    s = StudentS.new(99)
    s2 = StudentS.new(98)
    s3 = StudentS.new(97)


    assert_equal(true,m.set_students([s,s2,s3]))
    assert_equal(false,m.remove_student(s2))
    
    assert_equal(3,m.number_of_students)
    assert_equal(s2,m.get_student(1))
  end 

  def test_RemoveStudents
    m = MentorS.new("blah")
    m2 = MentorS.new("blah2")
    m3 = MentorS.new("blah3")
    
    s = StudentS.new(99)
    s2 = StudentS.new(98)
    s3 = StudentS.new(97)
    s4 = StudentS.new(96)
    s5 = StudentS.new(95)
    s6 = StudentS.new(94)

    m.set_students([s,s2,s3,s4,s5])
    m2.set_students([s,s2,s3,s4,s5])
    m3.set_students([s,s2,s3,s4,s5])
    
    
    assert_equal(false,m.remove_student(s6))
    assert_equal(true,m.remove_student(s5))
    
    assert_equal(2,s5.number_of_mentors)
    assert_equal(4,m.number_of_students)
  end 

  def test_SetStudentsTooManyAndTooFew
    m = MentorS.new("blah")
    
    s = StudentS.new(99)
    s2 = StudentS.new(98)
    s3 = StudentS.new(97)
    s4 = StudentS.new(96)
    s5 = StudentS.new(95)
    s6 = StudentS.new(94)
    
    assert_equal(true,m.set_students([s,s2,s3]))
    
    assert_equal(false,m.set_students([s4,s5]))
    assert_equal(false,m.set_students([s4,s5,s,s2,s3,s6]))
    
    assert_equal(3,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(0,s4.number_of_mentors)
    assert_equal(0,s5.number_of_mentors)
    assert_equal(0,s6.number_of_mentors)
  end   

  def test_MentorAlreadyHasEnoughStudents
    m = MentorS.new("blah")
    
    s = StudentS.new(99)
    s2 = StudentS.new(98)
    s3 = StudentS.new(97)
    s4 = StudentS.new(96)
    s5 = StudentS.new(95)
    
    m.set_students([s,s2,s3,s4,s5])
    
    s6 = StudentS.new(94)
    assert_equal(false,m.add_student(s6))
    
    assert_equal(5,m.number_of_students)
    assert_equal(0,s6.number_of_mentors)
  end    

  def test_replaceMentor
    m = MentorS.new("blah")
    m2 = MentorS.new("blah2")
    m3 = MentorS.new("blah3")

    s = StudentS.new(99)
    s2 = StudentS.new(98)
    s3 = StudentS.new(97)
    s4 = StudentS.new(96)
    s5 = StudentS.new(95)
    
    m.set_students([s,s2,s3,s4,s5])
    assert_equal(true,s.set_mentors([m2,m3]))

    assert_equal(4,m.number_of_students)
    assert_equal(1,m2.number_of_students)
    assert_equal(1,m3.number_of_students)
    assert_equal(2,s.number_of_mentors)
  end 

  def test_is_number_of_students_valid
    m = MentorS.new("blah")
    assert_equal(false,m.is_number_of_students_valid)

    m.add_student(StudentS.new(99))
    assert_equal(false,m.is_number_of_students_valid)

    m.add_student(StudentS.new(98))
    assert_equal(false,m.is_number_of_students_valid)

    m.add_student(StudentS.new(97))
    assert_equal(true,m.is_number_of_students_valid)

  end

  def test_getBoundsForStudent
    assert_equal(3,MentorS::minimum_number_of_students)
    assert_equal(5,MentorS::maximum_number_of_students)
  end  

  def test_deleteMentorAndStudentHasEnough
    m = MentorS.new("blah")
    m2 = MentorS.new("blah2")
    m3 = MentorS.new("blah3")

    s = StudentS.new(99)
    s2 = StudentS.new(98)
    s3 = StudentS.new(97)
    s4 = StudentS.new(96)
    s5 = StudentS.new(95)
    
    m.set_students([s,s2,s3,s4,s5])
    m2.set_students([s,s2,s3,s4,s5])
    m3.set_students([s,s2,s3,s4,s5])
    
    p = ProgramS.new
    s.set_program(p)
    
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(p,s.get_program)
    assert_equal(2,s.number_of_mentors)
  end  

  def test_deleteMentorAndStudentNowHasTooFewMentors
    m = MentorS.new("blah")
    m2 = MentorS.new("blah2")

    s = StudentS.new(99)
    s2 = StudentS.new(98)
    s3 = StudentS.new(97)
    s4 = StudentS.new(96)
    s5 = StudentS.new(95)
    
    m.set_students([s,s2,s3,s4,s5])
    m2.set_students([s,s2,s3])
    
    p = ProgramS.new
    s.set_program(p)
    
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(0,m2.number_of_students)
    assert_equal(0,s.number_of_mentors)
  end  

end
end