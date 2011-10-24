require 'test/unit'
require './src-gen-umple/student_a_a'
require './src-gen-umple/mentor_a_a'
require './src-gen-umple/program_a_a'

module CruiseTest
class ManyToOptionalNTest < Test::Unit::TestCase

  def test_CreateStudentWithoutMentor
    s = StudentAA.new(99)
    assert_equal(0,s.number_of_mentors)
  end

  def test_CreateMentorWithoutStudent
  
    m = MentorAA.new("blah")
    assert_equal(0,m.number_of_students)
  end

  def test_setTooMany
  
    s = StudentAA.new(99)
    s2 = StudentAA.new(98)    
    s3 = StudentAA.new(97)
    m = MentorAA.new("blah")
    assert_equal(false,m.set_students([s,s2,s3])) 
    assert_equal(0,m.number_of_students)
    assert_equal(0,s.number_of_mentors)
    assert_equal(0,s2.number_of_mentors)
    assert_equal(0,s3.number_of_mentors)
  end


  def test_set_studentsAtMax
  
    s = StudentAA.new(99)
    s2 = StudentAA.new(98)

    m = MentorAA.new("blah")
    m.set_students([s,s2])

    assert_equal(2,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
  end

  def test_set_studentsWatchOutForDuplicates
  
    s = StudentAA.new(99)
    m = MentorAA.new("blah")
    assert_equal(false,m.set_students([s,s]))
  end

  def test_set_studentsDoNotEraseExisting
  
    s = StudentAA.new(99)
    s2 = StudentAA.new(98)
    s3 = StudentAA.new(97)

    m = MentorAA.new("blah")
    m.set_students([s,s2])

    assert_equal(2, m.number_of_students)
    assert_equal(m, s.get_mentor(0))
    assert_equal(m, s2.get_mentor(0))
    assert_equal(0, s3.number_of_mentors)    

    m2 = MentorAA.new("blah2")
    m2.set_students([s,s3])

    assert_equal(2, m.number_of_students)
    assert_equal(m, s.get_mentor(0))
    assert_equal(m, s2.get_mentor(0))

    assert_equal(2, m2.number_of_students)
    assert_equal(m2, s.get_mentor(1))
    assert_equal(m2, s3.get_mentor(0))

  end   

  def test_set_students_aboveNKeepsExistingIntact
  
    s = StudentAA.new(99)
    s2 = StudentAA.new(98)    
    s3 = StudentAA.new(97)
    s4 = StudentAA.new(96)
    s5 = StudentAA.new(95)

    m = MentorAA.new("blah")

    assert_equal(true,m.set_students([s,s2]))
    assert_equal(false, m.set_students([s2, s3, s4, s5, s]))
    assert_equal(2,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(0,s3.number_of_mentors)
    assert_equal(0,s4.number_of_mentors)
    assert_equal(0,s5.number_of_mentors)

  end

  def test_set_students_doNotAllowDuplicatesNM
  
    s = StudentAA.new(99)
    s2 = StudentAA.new(98)    

    m = MentorAA.new("blah")
    assert_equal(false, m.set_students([s, s2, s]))
  end

  def test_set_students_atNOverwritesExisting
  
    s = StudentAA.new(99)
    s2 = StudentAA.new(98)    
    s3 = StudentAA.new(97)

    m = MentorAA.new("blah")

    assert_equal(true, m.set_students([s, s2]))
    assert_equal(true, m.set_students([s2, s3]))
    assert_equal(2,m.number_of_students)

    assert_equal(0,s.number_of_mentors)
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))

  end

  def test_add_mentorTooMany
  
    s = StudentAA.new(99)
    s2 = StudentAA.new(98)    
    s3 = StudentAA.new(97)

    m = MentorAA.new("blah")
    m.set_students([s,s2])

    assert_equal(false,s3.add_mentor(m))
    assert_equal(2,m.number_of_students)
    assert_equal(0,s3.number_of_mentors)

  end

  def test_add_mentorTOkay
  
    s = StudentAA.new(99)
    s2 = StudentAA.new(98)    

    m = MentorAA.new("blah")
    m.set_students([s])

    assert_equal(true,s2.add_mentor(m))
    assert_equal(2,m.number_of_students)
    assert_equal(1,s2.number_of_mentors)

  end


  def test_add_student
  
    s = StudentAA.new(99)
    s2 = StudentAA.new(98)
    s3 = StudentAA.new(97) 

    m = MentorAA.new("blah")
    assert_equal(true,m.set_students([s]))

    assert_equal(1,m.number_of_students)

    assert_equal(true,m.add_student(s2))

    assert_equal(2,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))

    assert_equal(false,m.add_student(s3))
    assert_equal(2,m.number_of_students)

  end  

  def test_add_studentHasExistingMentor
  
    s = StudentAA.new(99)
    s2 = StudentAA.new(98)    
    s3 = StudentAA.new(97)

    m = MentorAA.new("blah")
    m2 = MentorAA.new("blah2")

    m.set_students([s,s2])
    m2.set_students([s3])

    assert_equal(2,m.number_of_students)
    assert_equal(1,m2.number_of_students)

    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))

    assert_equal(m2,s3.get_mentor(0))

    assert_equal(true,m2.add_student(s2))

    assert_equal(2,m.number_of_students)
    assert_equal(2,m2.number_of_students)

    assert_equal(2,s2.number_of_mentors)    
    assert_equal(m,s2.get_mentor(0))    
    assert_equal(m2,s2.get_mentor(1))

    assert_equal(false,m.add_student(s3))
  end  

  def test_remove_student
  
    s = StudentAA.new(99)
    s2 = StudentAA.new(98)    
    s3 = StudentAA.new(97)

    m = MentorAA.new("blah")
    m.set_students([s,s2])

    assert_equal(false,m.remove_student(s3))
    assert_equal(true,m.remove_student(s2))

    assert_equal(1,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(0,s2.number_of_mentors)
    assert_equal(0,s3.number_of_mentors)

    assert_equal(true,m.remove_student(s))
    assert_equal(0,m.number_of_students)
  end  




  def test_set_students_empty
  
    s = StudentAA.new(99)
    s2 = StudentAA.new(98)
    m = MentorAA.new("blah")
    m.set_students([s,s2])
    assert_equal(true, m.set_students([]))
    assert_equal(0,m.number_of_students)
    assert_equal(0,s.number_of_mentors)
    assert_equal(0,s2.number_of_mentors)
  end


  def test_deleteStudentLeavesMentorAlone
  
    s1 = StudentAA.new(99)
    s2 = StudentAA.new(98)

    m = MentorAA.new("blah")
    m.set_students([s1,s2])
    studentP = ProgramAA.new
    mentorP = ProgramAA.new

    s2.set_program(studentP)
    m.set_program(mentorP)

    s1.delete

    assert_equal(1,m.number_of_students)
    assert_equal(mentorP,m.get_program)
    assert_equal(m,mentorP.get_mentor)
    assert_equal(studentP,s2.get_program)
    assert_equal(0,s1.number_of_mentors)
  end 

  def test_studentBounds
  
    assert_equal(2,MentorAA.maximum_number_of_students)
  end
end
end