<?php

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE modeling language!*/

class MultiplicityEnd
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MultiplicityEnd Attributes
  private $classEntity;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aClassEntity)
  {
    $this->classEntity = $aClassEntity;
  }
  
  //------------------------
  // INTERFACE
  //------------------------

  public function setClassEntity($aClassEntity)
  {
    $this->classEntity = $aClassEntity;
    return true;
  }

  public function getClassEntity()
  {
    return $this->classEntity;
  }

  public function delete()
  {}

}





/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE modeling language!*/

class Association
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Association Attributes
  private $one;
  private $two;
  private $connectors;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aOne, $aTwo)
  {
    $this->one = $aOne;
    $this->two = $aTwo;
    $this->connectors = array();
  }
  
  //------------------------
  // INTERFACE
  //------------------------

  public function setOne($aOne)
  {
    $this->one = $aOne;
    return true;
  }

  public function setTwo($aTwo)
  {
    $this->two = $aTwo;
    return true;
  }

  public function addConnector($aConnector)
  {
    if ($aConnector != null)
    {
      return $this->connectors[] = $aConnector;
    }
    else
    {
      return false;
    }
  }

  public function removeConnector($aConnector)
  {
    unset($this->connectors[$this->indexOfConnector($aConnector)]);
    $this->connectors = array_values($this->connectors);
  }

  public function getOne()
  {
    return $this->one;
  }

  public function getTwo()
  {
    return $this->two;
  }

  public function getConnector($index)
  {
    return $this->connectors[$index];
  }

  public function getConnectors()
  {
    return $this->connectors;
  }

  public function numberOfConnectors()
  {
    return count($this->connectors);
  }

  public function indexOfConnector($aConnector)
  {
    $rawAnswer = array_search($aConnector,$this->connectors);
    return $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer; 
  }

  public function delete()
  {}

  function draw($diagram)
  {
    $red=ImageColorAllocate($diagram,255,0,0);
    $black = ImageColorAllocate($diagram, 0, 0, 0);
    
    $firstPoint = null;
    foreach($this->connectors as $point)
    {
      if ($firstPoint == null)
      {
        $firstPoint = $point;
        continue;
      }
      ImageLine($diagram,$firstPoint->getX(),$firstPoint->getY(),$point->getX(),$point->getY(),$black);
    }
  }
}





/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE modeling language!*/

class Position
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Position Attributes
  private $x;
  private $y;
  private $width;
  private $height;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aX, $aY, $aWidth, $aHeight)
  {
    $this->x = $aX;
    $this->y = $aY;
    $this->width = $aWidth;
    $this->height = $aHeight;
  }
  
  //------------------------
  // INTERFACE
  //------------------------

  public function setX($aX)
  {
    $this->x = $aX;
    return true;
  }

  public function setY($aY)
  {
    $this->y = $aY;
    return true;
  }

  public function setWidth($aWidth)
  {
    $this->width = $aWidth;
    return true;
  }

  public function setHeight($aHeight)
  {
    $this->height = $aHeight;
    return true;
  }

  public function getX()
  {
    return $this->x;
  }

  public function getY()
  {
    return $this->y;
  }

  public function getWidth()
  {
    return $this->width;
  }

  public function getHeight()
  {
    return $this->height;
  }

  public function delete()
  {}

}





/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE modeling language!*/

class ClassEntity
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassEntity Attributes
  private $name;
  private $position;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName, $aPosition)
  {
    $this->name = $aName;
    $this->position = $aPosition;
  }
  
  //------------------------
  // INTERFACE
  //------------------------

  public function setName($aName)
  {
    $this->name = $aName;
    return true;
  }

  public function setPosition($aPosition)
  {
    $this->position = $aPosition;
    return true;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getPosition()
  {
    return $this->position;
  }

  public function delete()
  {}

  public function draw($diagram)
  {
    $name = $this->getName();
    $x = $this->getPosition()->getX();
    $y = $this->getPosition()->getY();
    $width = $this->getPosition()->getWidth();
    $height = $this->getPosition()->getHeight();

    $fontSize = 5;
    $calculatedWidth = strlen($name) * ImageFontWidth($fontSize);
    $calculatedHeight = ImageFontHeight($fontSize);
    $labelOffset = 3;
    $imageSize = 16;
    
    $this->getPosition()->setWidth($width);
    $this->getPosition()->setHeight($height);

    $black = ImageColorAllocate($diagram, 0, 0, 0);
    $red=ImageColorAllocate($diagram,255,0,0);
    $im = ImageCreateFromJpeg("class.jpg");
    
    
    ImageCopy($diagram,$im, $x+$labelOffset, $y+$labelOffset, 0, 0, 15, $imageSize);
    ImageString($diagram,$fontSize,$x+$imageSize+2*$labelOffset,$y+$labelOffset,$name,$black);
    ImageRectangle($diagram,$x,$y,$x+$width,$y+$height,$black);
    ImageRectangle($diagram,$x,$y,$x+$width,$y+$calculatedHeight+2*$labelOffset,$black);  
  }
}





/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE modeling language!*/

class Canvas
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Canvas Attributes
  private $width;
  private $height;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aWidth, $aHeight)
  {
    $this->width = $aWidth;
    $this->height = $aHeight;
  }
  
  //------------------------
  // INTERFACE
  //------------------------

  public function setWidth($aWidth)
  {
    $this->width = $aWidth;
    return true;
  }

  public function setHeight($aHeight)
  {
    $this->height = $aHeight;
    return true;
  }

  public function getWidth()
  {
    return $this->width;
  }

  public function getHeight()
  {
    return $this->height;
  }

  public function delete()
  {}

  public function createDiagram()
  {
    $diagram = ImageCreate($this->getWidth(), $this->getHeight());
    $white = ImageColorAllocate($diagram, 255, 255, 255);
    $black = ImageColorAllocate($diagram, 0, 0, 0);
    //ImageRectangle($diagram,0,0,$this->getWidth() - 1, $this->getHeight() - 1,$black);
    return $diagram;
  }
}





/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE modeling language!*/

class Point
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Point Attributes
  private $x;
  private $y;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aX, $aY)
  {
    $this->x = $aX;
    $this->y = $aY;
  }
  
  //------------------------
  // INTERFACE
  //------------------------

  public function setX($aX)
  {
    $this->x = $aX;
    return true;
  }

  public function setY($aY)
  {
    $this->y = $aY;
    return true;
  }

  public function getX()
  {
    return $this->x;
  }

  public function getY()
  {
    return $this->y;
  }

  public function delete()
  {}

}


?>