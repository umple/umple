require 'test/unit'
require './src-gen-umple/student_w'
require './src-gen-umple/mentor_w'
require './src-gen-umple/program_w'

module CruiseTest
class NToMStarTest < Test::Unit::TestCase

  def test_CreateStudentWithoutMentor
    s = StudentW.new(99)
    assert_equal(0,s.number_of_mentors)
  end
  
  def test_CreateMentorWithoutStudent
    m = MentorW.new("blah")
    assert_equal(0,m.number_of_students)
  end
  
  def test_SetStudentsJustEnough
    m = MentorW.new("blah")
    
    s = StudentW.new(99)
    s2 = StudentW.new(98)
    s3 = StudentW.new(97)
    s4 = StudentW.new(96)
    
    assert_equal(true,m.set_students([s,s2,s3,s4]))
    
    assert_equal(4, m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(m,s4.get_mentor(0))
  end  
  
  def test_SetStudentsNeverAtMax
    m = MentorW.new("blah")
    
    s = StudentW.new(99)
    s2 = StudentW.new(98)
    s3 = StudentW.new(97)
    s4 = StudentW.new(96)
    s5 = StudentW.new(95)
    s6 = StudentW.new(94)
    s7 = StudentW.new(93)
    s8 = StudentW.new(92)
    s9 = StudentW.new(91)
    
    assert_equal(true,m.set_students([s,s2,s3,s4,s5,s6,s7,s8,s9]))
    
    assert_equal(9, m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(m,s4.get_mentor(0))
    assert_equal(m,s5.get_mentor(0))
    assert_equal(m,s6.get_mentor(0))
    assert_equal(m,s7.get_mentor(0))
    assert_equal(m,s8.get_mentor(0))
    assert_equal(m,s9.get_mentor(0))
  end   
  
  def test_AddStudents
    m = MentorW.new("blah")
    
    s = StudentW.new(99)
    
    assert_equal(true,m.add_student(s))
    
    for i in 2..9 do
    
      s2 = StudentW.new(i)
      assert_equal(true,m.add_student(s2))
      assert_equal(i,m.number_of_students)
      assert_equal(m,s2.get_mentor(0))
    end
  end   
  
  def test_RemoveMiddleStudentWhenNotValidMaintainsTheOrder
    m = MentorW.new("blah")
    
    s = StudentW.new(99)
    s2 = StudentW.new(98)
    s3 = StudentW.new(97)
    s4 = StudentW.new(96)


    assert_equal(true,m.set_students([s,s2,s3,s4]))
    assert_equal(false,m.remove_student(s2))
    
    assert_equal(4, m.number_of_students)
    assert_equal(s2,m.get_student(1))
  end 
  
  def test_CannotRemoveStudentsBecauseNeedsFixedNumberOfMentors
    m = MentorW.new("blah")
    m2 = MentorW.new("blah2")
    
    s = StudentW.new(99)
    s2 = StudentW.new(98)
    s3 = StudentW.new(97)
    s4 = StudentW.new(96)
    s5 = StudentW.new(95)
    s6 = StudentW.new(94)

    m.set_students([s,s2,s3,s4,s5])
    m2.set_students([s,s2,s3,s4,s5])
    
    assert_equal(false,m.remove_student(s6))
    assert_equal(false,m.remove_student(s5))
    
    assert_equal(2,s5.number_of_mentors)
    assert_equal(5, m.number_of_students)
  end 
  
  def test_SetStudentsTooFew
    m = MentorW.new("blah")
    
    s = StudentW.new(99)
    s2 = StudentW.new(98)
    s3 = StudentW.new(97)
    s4 = StudentW.new(96)
    s5 = StudentW.new(95)
    s6 = StudentW.new(94)
    
    assert_equal(true,m.set_students([s,s2,s3]))
    
    assert_equal(false,m.set_students([s4,s5]))
    
    assert_equal(3, m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(0,s4.number_of_mentors)
    assert_equal(0,s5.number_of_mentors)
    assert_equal(0,s6.number_of_mentors)
  end   
  
  def test_MentorNeverHasEnoughStudents
    m = MentorW.new("blah")
    
    s = StudentW.new(99)
    s2 = StudentW.new(98)
    s3 = StudentW.new(97)
    s4 = StudentW.new(96)
    s5 = StudentW.new(95)
    
    m.set_students([s,s2,s3,s4,s5])
    
    s6 = StudentW.new(94)
    assert_equal(true,m.add_student(s6))
    
    assert_equal(6, m.number_of_students)
    assert_equal(1,s6.number_of_mentors)
  end    

  def test_replaceMentor
    m = MentorW.new("blah")
    m2 = MentorW.new("blah2")
    m3 = MentorW.new("blah3")

    s = StudentW.new(99)
    s2 = StudentW.new(98)
    s3 = StudentW.new(97)
    s4 = StudentW.new(96)
    s5 = StudentW.new(95)
    
    m.set_students([s,s2,s3,s4,s5])
    assert_equal(true,s.set_mentors([m2,m3]))

    assert_equal(4,m.number_of_students)
    assert_equal(1,m2.number_of_students)
    assert_equal(1,m3.number_of_students)
    assert_equal(2,s.number_of_mentors)
  end 

  def test_is_number_of_students_valid
    m = MentorW.new("blah")
    assert_equal(false,m.is_number_of_students_valid)

    m.add_student(StudentW.new(99))
    assert_equal(false,m.is_number_of_students_valid)

    m.add_student(StudentW.new(98))
    assert_equal(false,m.is_number_of_students_valid)

    m.add_student(StudentW.new(97))
    assert_equal(true,m.is_number_of_students_valid)

  end
  
  def test_getBoundsForStudent
    assert_equal(3,MentorW::minimum_number_of_students)
  end  
  
  def test_deleteMentorDeletesStudents
    m = MentorW.new("blah")
    m2 = MentorW.new("blah2")

    s = StudentW.new(99)
    s2 = StudentW.new(98)
    s3 = StudentW.new(97)
    s4 = StudentW.new(96)
    s5 = StudentW.new(95)
    
    m.set_students([s,s2,s3,s4,s5])
    m2.set_students([s,s2,s3,s4,s5])
    
    p = ProgramW.new
    s.set_program(p)
    
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(nil,s.get_program)
    assert_equal(0,s.number_of_mentors)
  end  

  def test_deleteMentorDeletesStudentThatThenDeletesMentor
    m = MentorW.new("blah")
    m2 = MentorW.new("blah2")

    s = StudentW.new(99)
    s2 = StudentW.new(98)
    s3 = StudentW.new(97)
    s4 = StudentW.new(96)
    
    m.set_students([s,s2,s3,s4])
    m2.set_students([s,s2,s3])
    
    p = ProgramW.new
    s.set_program(p)
    
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(0,m2.number_of_students)
    assert_equal(nil,s.get_program)
    assert_equal(0,s.number_of_mentors)
  end  

  def test_deleteMentorAndStudentNowHasTooFewMentors
    m = MentorW.new("blah")
    m2 = MentorW.new("blah2")

    s = StudentW.new(99)
    s2 = StudentW.new(98)
    s3 = StudentW.new(97)
    s4 = StudentW.new(96)
    s5 = StudentW.new(95)
    
    m.set_students([s,s2,s3,s4,s5])
    m2.set_students([s,s2,s3])
    
    p = ProgramW.new
    s.set_program(p)
    
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(0,m2.number_of_students)
    assert_equal(0,s.number_of_mentors)
  end  

end
end