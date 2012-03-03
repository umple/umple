<?php

class StringTracerTest extends UnitTestCase
{
  
  public function setUp()
  {
    StringTracer::getInstance()->reset();
  }
  
  public function test_traceStrings()
  {
    $tracer = StringTracer::getInstance();
    $person = new PersonA("aName");
    $this->assertEqual(0,$tracer->numberOfTraces());
    $person->setName("aha");
    $this->assertEqual(1,$tracer->numberOfTraces());
    $this->assertEqual("name=aha",$tracer->getTrace(0));
  }
  
}
