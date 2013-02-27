<?php

class CodeInjectionTest extends UnitTestCase
{
  public function test_MultiLanguagedCodeBlocks()
  {
  	$cb = new LanguageSpecificCodeBlock("Hello");
  	$cb->setName("World");
    $this->assertEqual("I am php",$cb->getName());
    $this->assertTrue(!$cb->isJava());
    
    $cb->applySpecificAction();
    $this->assertEquals("action=php",$cb->getName());
    
    $this->assertEquals("Php",$cb->getLanguageImplementedIn());
  }  
}

?>
