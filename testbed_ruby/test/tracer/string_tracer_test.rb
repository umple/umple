require 'test/unit'
require './src-gen-umple/door_e'
require './src-gen-umple/door_f'

module CruiseTracerTest
class StringTracerTest < Test::Unit::TestCase

  def setup
    # @tracer = StringTracer::getInstance()
    # @tracer.reset()
  end

  def test_traceStrings
    # puts @tracer
  end

end
end

# package cruise.tracer.test;
# 
# import org.junit.*;
# 
# import cruise.util.StringTracer;
# 
# public class StringTracerTest
# {
#   
#   StringTracer tracer;
# 
#   @Before
#   public void setUp()
#   {
#     tracer = StringTracer.getInstance();
#     tracer.reset();
#   }
#   
#   @Test
#   public void traceStrings()
#   {
#     PersonA person = new PersonA();
#     Assert.assertEquals(0,tracer.numberOfTraces());
#     person.setName("aha");
#     Assert.assertEquals(1,tracer.numberOfTraces());
#     Assert.assertEquals("name=aha",tracer.getTrace(0));
#   }
#   
# }