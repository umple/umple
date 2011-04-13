require 'test/unit'
require 'src/student_b'
require 'src/mentor_b'
require 'src/program_b'

module CruiseTest
class OptionalOneToOneTest < Test::Unit::TestCase

  def test_Constructor
    student = StudentB.new
    mentor = MentorB.new(student)
    
    assert_equal(student,mentor.get_student)
    assert_equal(mentor,student.get_mentor)
  end 
  
  def test_CannotSetStudentBToNull
    student = StudentB.new
    mentor = MentorB.new(student)
    assert_equal(false,mentor.set_student(nil))
  end

  def test_SetStudent
    student = StudentB.new
    mentor = MentorB.new(student)
    
    student2 = StudentB.new
    assert_equal(true,mentor.set_student(student2))
    
    
    assert_equal(mentor,student2.get_mentor)
    assert_equal(student2,mentor.get_student)
    assert_equal(nil,student.get_mentor)
  end 
  
  def test_SetMentorCannotReset
    s = StudentB.new
    m = MentorB.new(s)
    
    s2 = StudentB.new
    m2 = MentorB.new(s2)
    
    assert_equal(false,m.set_student(s2))
    assert_equal(m,s.get_mentor)
    assert_equal(s,m.get_student)
    assert_equal(m2,s2.get_mentor)
    assert_equal(s2,m2.get_student)
  end 

  def test_SetMentor
    student = StudentB.new
    mentor = MentorB.new(student)
    
    student2 = StudentB.new
    student2.set_mentor(mentor)
    
    assert_equal(mentor,student2.get_mentor)
    assert_equal(student2,mentor.get_student)
    assert_equal(nil,student.get_mentor)
  end   

  def test_UnableToConstructNewSubordinateFromExistingDriverThatAlreadyHasDriver
  	assert_raise RuntimeError do #"Unable to create mentor due to student"
      student = StudentB.new
      MentorB.new(student)
      MentorB.new(student) 
    end
  end 


  def test_DeleteDriverStudentHasNoMentor
    student = StudentB.new
    student.delete
    assert_equal(nil,student.get_mentor)
  end
  
  def test_DeleteDriverRemovesSubordinate
    student = StudentB.new
    mentor = MentorB.new(student)
    program = ProgramB.new
    mentor.set_program(program)
    
    student.delete
    assert_equal(nil,student.get_mentor)
    assert_equal(nil,mentor.get_student)
    assert_equal(nil,mentor.get_program)
  end  
  
  def test_DeleteSubordinateKeepDriver
    student = StudentB.new
    mentor = MentorB.new(student)
    program = ProgramB.new
    student.set_program(program)
    
    mentor.delete
    assert_equal(nil,student.get_mentor)
    assert_equal(nil,mentor.get_student)
    assert_equal(program,student.get_program)
  end  
  
end
end