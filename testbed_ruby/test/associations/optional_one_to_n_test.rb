require 'test/unit'
require './src-gen-umple/student_d'
require './src-gen-umple/mentor_d'
require './src-gen-umple/program_d'

module CruiseAssociations
class OptionalOneToNTest < Test::Unit::TestCase

  def test_CreateStudentWithoutMentor
    s = StudentD.new
    assert_equal(nil,s.get_mentor)
  end
  
  def test_ConstructorWithoutNStudents
    assert_raise RuntimeError do #"Unable to create MentorD, must have 3 students"
      s = StudentD.new
      s2 = StudentD.new    
      MentorD.new([s,s2])
    end
  end
  
  def test_set_students_makeSureAlwaysN
    s = StudentD.new
    s2 = StudentD.new
    s3 = StudentD.new
  
    m = MentorD.new([s,s2,s3])
    s4 = StudentD.new
    s5 = StudentD.new
    s6 = StudentD.new
    
    assert_equal(true,m.set_students([s, s2, s3]))
    assert_equal(3,m.number_of_students)
    assert_equal(m,s.get_mentor)
    assert_equal(m,s2.get_mentor)
    assert_equal(m,s3.get_mentor)
  
    assert_equal(true,m.set_students([s4, s5, s6]))
    assert_equal(3,m.number_of_students)
    assert_equal(nil,s.get_mentor)
    assert_equal(nil,s2.get_mentor)
    assert_equal(nil,s3.get_mentor)
    assert_equal(m,s4.get_mentor)
    assert_equal(m,s5.get_mentor)
    assert_equal(m,s6.get_mentor)
  end
  
  def test_set_students_watchOutForDuplicateEntries
    assert_raise RuntimeError do #"Unable to create MentorD, must have 3 students"
      s = StudentD.new
      s2 = StudentD.new
      MentorD.new([s, s2, s])
    end
  end
  
  def test_set_students_replaceExisitingmakeSureAlwaysN
    s = StudentD.new
    s2 = StudentD.new
    s3 = StudentD.new
  
    m = MentorD.new([s, s2, s3])
    s4 = StudentD.new
    
    assert_equal(false,m.set_students([s,s2]))
    assert_equal(3,m.number_of_students)
    assert_equal(m,s.get_mentor)
    assert_equal(m,s2.get_mentor)
    assert_equal(m,s3.get_mentor)
    assert_equal(nil,s4.get_mentor)    
    
    assert_equal(false,m.set_students([s, s2, s3, s4]))
    assert_equal(3,m.number_of_students)
    assert_equal(nil,s4.get_mentor)
  end
  
  def test_set_students_empty
    s = StudentD.new
    s2 = StudentD.new
    s3 = StudentD.new
    m = MentorD.new([s,s2,s3])
  
    
    assert_equal(true,m.set_students([s, s2, s3]))
    assert_equal(3,m.number_of_students)
  
    assert_equal(false,m.set_students([]))
    assert_equal(3,m.number_of_students)
  end
  
  def test_checkForExistingMentor
    s1 = StudentD.new
    s2 = StudentD.new
    s3 = StudentD.new

    m = MentorD.new([s1,s2,s3])

    s4 = StudentD.new
  
    assert_equal(3,m.number_of_students)
    assert_equal(m, s1.get_mentor)
    assert_equal(m, s2.get_mentor)
    assert_equal(m, s3.get_mentor)    
    assert_equal(nil, s4.get_mentor)    

    assert_raise RuntimeError do #"Unable to create MentorD, must have 3 students"
      MentorD.new([s1,s2,s4])
    end
  end   
  
  def test_deletStudentDeletesTheMentor
    s1 = StudentD.new
    s2 = StudentD.new
    s3 = StudentD.new
  
    m = MentorD.new([s1,s2,s3])
    studentP = ProgramD.new
    mentorP = ProgramD.new
    
    s2.set_program(studentP)
    m.set_program(mentorP)
  
    s1.delete
    
    assert_equal(0,m.number_of_students)
    assert_equal(nil,m.get_program)
    assert_equal(nil,mentorP.get_mentor)
    assert_equal(studentP,s2.get_program)
    assert_equal(nil,s1.get_mentor)
  end  

end
end