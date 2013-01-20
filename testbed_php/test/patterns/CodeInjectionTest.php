<?php

class CodeInjectionTest extends UnitTestCase
{
  public function test_MultiLanguagedCodeBlocks()
  {
  	$cb = new LanguageSpecificCodeBlock("Hello");
  	$cb->setName("World");
    $this->assertEqual("php",$cb->getName());
  }  
}

?>
