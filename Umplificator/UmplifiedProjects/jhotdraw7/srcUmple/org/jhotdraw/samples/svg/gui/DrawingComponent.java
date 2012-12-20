/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package org.jhotdraw.samples.svg.gui;
import java.awt.event.*;
import javax.swing.*;
import org.jhotdraw.draw.*;

public class DrawingComponent
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DrawingComponent()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public JComponent getComponent();
/**
     * Returns the drawing of the DrawingComponent.
     */
    public Drawing getDrawing();
/**
     * Sets the drawing of the DrawingComponent.
     */
    public void setDrawing(Drawing newValue);
/**
     * Adds an ActionListener.
     * <p>
     * The ActionListener receives an ActionEvent with action command "save"
     * when the user clicks at the save button on the drawing component.
     * <p>
     * The ActionListener receives an ActionEvent with action command "cancel"
     * when the user clicks at the cancel button on the drawing component.
     */
    public void addActionListener(ActionListener listener);
/**
     * Removes an ActionListener.
     */
    public void removeActionListener(ActionListener listener);
/**
     * Returns a summary about the changes made on the drawing.
     */
    public String getSummary();
}