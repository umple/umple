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
    $this->assertEqual("actionphp",$cb->getName());
    
    $this->assertEqual("Php",$cb->getLanguageImplementedIn());
  }  
}

?>
