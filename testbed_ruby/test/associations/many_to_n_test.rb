require 'test/unit'
require './src-gen-umple/student_q'
require './src-gen-umple/mentor_q'
require './src-gen-umple/program_q'

module CruiseTest
class ManyToNTest < Test::Unit::TestCase

  def test_CreateStudentWithoutMentor
    s = StudentQ.new(99)
    assert_equal(0,s.number_of_mentors)
  end
  
  def test_ConstructorWithTooFew
    assert_raise RuntimeError do #"Unable to create MentorQ, must have 2 students"
      s = StudentQ.new(99)
      MentorQ.new("blah",[s])
    end
  end
  
  def test_ConstructorWithTooMany
    assert_raise RuntimeError do #"Unable to create MentorQ, must have 2 students"
      s = StudentQ.new(99)
      s2 = StudentQ.new(98)    
      s3 = StudentQ.new(97)
      MentorQ.new("blah",[s,s2,s3])
    end
  end
  
  def test_constructorJustRight
    s = StudentQ.new(99)
    s2 = StudentQ.new(98)
  
    m = MentorQ.new("blah",[s,s2])
  
    assert_equal(2,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
  end
  
  def test_constructorWatchOutForDuplicateEntries
    assert_raise RuntimeError do #"Unable to create MentorQ, must have 2 students"
      s = StudentQ.new(99)
      MentorQ.new("blah",[s, s])
    end
  end
  
  def test_constructorExistingMentorsOkay
    s1 = StudentQ.new(99)
    s2 = StudentQ.new(98)
    s3 = StudentQ.new(97)
    
    m = MentorQ.new("blah",[s1,s2])
  
    assert_equal(2,m.number_of_students)
    assert_equal(m,s1.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(0,s3.number_of_mentors)    
  
    m2 = MentorQ.new("blah2",[s2,s3])
    
    assert_equal(2,m.number_of_students)
    assert_equal(m,s1.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    
    assert_equal(2,m2.number_of_students)
    assert_equal(m2,s2.get_mentor(1))
    assert_equal(m2,s3.get_mentor(0))
  end
  
  def test_set_students_outsideN
    s = StudentQ.new(99)
    s2 = StudentQ.new(98)    
    s3 = StudentQ.new(97)
    s4 = StudentQ.new(96)
    s5 = StudentQ.new(95)
  
    m = MentorQ.new("blah",[s,s2])
    
    assert_equal(false,m.set_students([s2,s3,s4]))
    assert_equal(2,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(0,s3.number_of_mentors)
    assert_equal(0,s4.number_of_mentors)
    assert_equal(0,s5.number_of_mentors)
  
    assert_equal(false,m.set_students([]))
    assert_equal(2,m.number_of_students)
    assert_equal(m,s.get_mentor(0))
    assert_equal(m,s2.get_mentor(0))
    assert_equal(0,s3.number_of_mentors)
    assert_equal(0,s4.number_of_mentors)
    assert_equal(0,s5.number_of_mentors)
  end
  
  def test_set_students_doNotAllowDuplicatesNM
    s = StudentQ.new(99)
    s2 = StudentQ.new(98)    
    s3 = StudentQ.new(97)
  
    m = MentorQ.new("blah",[s,s2])
    assert_equal(false,m.set_students([s2,s2,s3]))
  end
  
  def test_set_students_withinN
    s = StudentQ.new(99)
    s2 = StudentQ.new(98)    
    s3 = StudentQ.new(97)
  
    m = MentorQ.new("blah",[s,s2])
    
    assert_equal(true,m.set_students([s3,s2]))
    assert_equal(2,m.number_of_students)
  
    assert_equal(0,s.number_of_mentors)
  
    assert_equal(m,s2.get_mentor(0))
    assert_equal(m,s3.get_mentor(0))
  end
  
  def test_set_students_empty
    s = StudentQ.new(99)
    s2 = StudentQ.new(98)
    m = MentorQ.new("blah",[s,s2])
  
    assert_equal(false,m.set_students([]))
    assert_equal(2,m.number_of_students)
  end
  
  def test_deletStudentDeletesTheMentorIfNotEnoughLeft
    s1 = StudentQ.new(99)
    s2 = StudentQ.new(98)
  
    m = MentorQ.new("blah",[s1,s2])
    studentP = ProgramQ.new
    mentorP = ProgramQ.new
    
    s2.set_program(studentP)
    m.set_program(mentorP)
  
    s1.delete
    
    
    assert_equal(0,m.number_of_students)
    assert_equal(nil,m.get_program)
    assert_equal(nil,mentorP.get_mentor)
    assert_equal(studentP,s2.get_program)
    assert_equal(0,s1.number_of_mentors)
  end    
  
  def test_add_mentorTooMany
    s = StudentQ.new(99)
    s2 = StudentQ.new(98)    
    s3 = StudentQ.new(97)
  
    m = MentorQ.new("blah",[s,s2])
    
    assert_equal(false,s3.add_mentor(m))
    assert_equal(2,m.number_of_students)
    assert_equal(0,s3.number_of_mentors)
  end
end
end
