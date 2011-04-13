require 'test/unit'
require 'src/student_x'
require 'src/mentor_x'
require 'src/program_x'

module CruiseTest
class MStarToMStarTest < Test::Unit::TestCase

  def test_CreateStudentWithoutMentor
    s = StudentX.new(99)
    assert_equal(0,s.number_of_mentors)
  end
  
  def test_CreateMentorWithoutStudent
    m = MentorX.new("blah")
    assert_equal(0,m.number_of_students)
  end
  
  def test_SetStudentsJustEnough
    m = MentorX.new("blah")
    
    s = StudentX.new(99)
    s2 = StudentX.new(98)
    s3 = StudentX.new(97)
    s4 = StudentX.new(96)
    
    assert_equal(true,m.set_students([s,s2,s3,s4]))
    
    assert_equal(4,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(m,s4.get_mentor(0))
  end  
  
  def test_SetStudentsNeverAtMax
    m = MentorX.new("blah")
    
    s = StudentX.new(99)
    s2 = StudentX.new(98)
    s3 = StudentX.new(97)
    s4 = StudentX.new(96)
    s5 = StudentX.new(95)
    s6 = StudentX.new(94)
    s7 = StudentX.new(93)
    s8 = StudentX.new(92)
    s9 = StudentX.new(91)
    
    assert_equal(true,m.set_students([s,s2,s3,s4,s5,s6,s7,s8,s9]))
    
    assert_equal(9,m.number_of_students)
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
    m = MentorX.new("blah")
    
    s = StudentX.new(99)
    
    assert_equal(true,m.add_student(s))
    
    for i in 2..9 do
    
      s2 = StudentX.new(i)
      assert_equal(true,m.add_student(s2))
      assert_equal(i,m.number_of_students)
      assert_equal(m,s2.get_mentor(0))
    end
  end   
  
  def test_RemoveMiddleStudentWhenNotValidMaintainsTheOrder
    m = MentorX.new("blah")
    
    s = StudentX.new(99)
    s2 = StudentX.new(98)
    s3 = StudentX.new(97)
    s4 = StudentX.new(96)


    assert_equal(true,m.set_students([s,s2,s3,s4]))
    assert_equal(false,m.remove_student(s2))
    
    assert_equal(4,m.number_of_students)
    assert_equal(s2,m.get_student(1))
  end 
  
  def test_RemoveStudents
    m = MentorX.new("blah")
    m2 = MentorX.new("blah2")
    m3 = MentorX.new("blah3")
    
    s = StudentX.new(99)
    s2 = StudentX.new(98)
    s3 = StudentX.new(97)
    s4 = StudentX.new(96)
    s5 = StudentX.new(95)
    s6 = StudentX.new(94)

    m.set_students([s,s2,s3,s4,s5])
    m2.set_students([s,s2,s3,s4,s5])
    m3.set_students([s,s2,s3,s4,s5])
    
    
    assert_equal(false,m.remove_student(s6))
    assert_equal(true,m.remove_student(s5))
    
    assert_equal(2,s5.number_of_mentors)
    assert_equal(4,m.number_of_students)
  end 
  
  def test_SetStudentsTooFew
    m = MentorX.new("blah")
    
    s = StudentX.new(99)
    s2 = StudentX.new(98)
    s3 = StudentX.new(97)
    s4 = StudentX.new(96)
    s5 = StudentX.new(95)
    s6 = StudentX.new(94)
    
    assert_equal(true,m.set_students([s,s2,s3]))
    
    assert_equal(false,m.set_students([s4,s5]))
    
    assert_equal(3,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
    assert_equal(0,s4.number_of_mentors)
    assert_equal(0,s5.number_of_mentors)
    assert_equal(0,s6.number_of_mentors)
  end   
  
  def test_MentorNeverHasEnoughStudents
    m = MentorX.new("blah")
    
    s = StudentX.new(99)
    s2 = StudentX.new(98)
    s3 = StudentX.new(97)
    s4 = StudentX.new(96)
    s5 = StudentX.new(95)
    
    m.set_students([s,s2,s3,s4,s5])
    
    s6 = StudentX.new(94)
    assert_equal(true,m.add_student(s6))
    
    assert_equal(6,m.number_of_students)
    assert_equal(1,s6.number_of_mentors)
  end    

  def test_replaceMentor
    m = MentorX.new("blah")
    m2 = MentorX.new("blah2")
    m3 = MentorX.new("blah3")

    s = StudentX.new(99)
    s2 = StudentX.new(98)
    s3 = StudentX.new(97)
    s4 = StudentX.new(96)
    s5 = StudentX.new(95)
    
    m.set_students([s,s2,s3,s4,s5])
    assert_equal(true,s.set_mentors([m2,m3]))

    assert_equal(4,m.number_of_students)
    assert_equal(1,m2.number_of_students)
    assert_equal(1,m3.number_of_students)
    assert_equal(2,s.number_of_mentors)
  end 

  def test_is_number_of_students_valid
  
    m = MentorX.new("blah")
    assert_equal(false,m.is_number_of_students_valid)

    m.add_student(StudentX.new(99))
    assert_equal(false,m.is_number_of_students_valid)

    m.add_student(StudentX.new(98))
    assert_equal(false,m.is_number_of_students_valid)

    m.add_student(StudentX.new(97))
    assert_equal(true,m.is_number_of_students_valid)

    m.add_student(StudentX.new(96))
    assert_equal(true,m.is_number_of_students_valid)
  end
  
  def test_getBoundsForStudent
  
    assert_equal(3,MentorX::minimum_number_of_students)
  end  
  
  def test_deleteMentorAndStudentHasEnough
  
    
    m = MentorX.new("blah")
    m2 = MentorX.new("blah2")
    m3 = MentorX.new("blah2")

    s = StudentX.new(99)
    s2 = StudentX.new(98)
    s3 = StudentX.new(97)
    s4 = StudentX.new(96)
    s5 = StudentX.new(95)
    
    m.set_students([s,s2,s3,s4,s5])
    m2.set_students([s,s2,s3,s4,s5])
    m3.set_students([s,s2,s3,s4,s5])
    
    p = ProgramX.new
    s.set_program(p)
    
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(p,s.get_program)
    assert_equal(2,s.number_of_mentors)
  end  

  def test_deleteMentorAndStudentNowHasTooFewMentors
  
    
    m = MentorX.new("blah")
    m2 = MentorX.new("blah2")

    s = StudentX.new(99)
    s2 = StudentX.new(98)
    s3 = StudentX.new(97)
    s4 = StudentX.new(96)
    s5 = StudentX.new(95)
    
    m.set_students([s,s2,s3,s4,s5])
    m2.set_students([s,s2,s3])
    
    p = ProgramX.new
    s.set_program(p)
    
    m.delete
    assert_equal(0,m.number_of_students)
    assert_equal(0,m2.number_of_students)
    assert_equal(0,s.number_of_mentors)
  end  

end
end
