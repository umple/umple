package cruise.umple.ignore;

public class Ignore
{
  protected static String nl;
  public static synchronized Ignore create(String lineSeparator)
  {
    nl = lineSeparator;
    Ignore result = new Ignore();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  public function ";
  protected final String TEXT_2 = "($";
  protected final String TEXT_3 = ")" + NL + "  {";
  protected final String TEXT_4 = NL + "    ";
  protected final String TEXT_5 = NL + "    else" + NL + "    {" + NL + "      return false;" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_6 = NL + "  private function ";
  protected final String TEXT_7 = "()" + NL + "  {";
  protected final String TEXT_8 = NL + "    ";
  protected final String TEXT_9 = NL + "  }" + NL;
  protected final String TEXT_10 = NL + "  private function ";
  protected final String TEXT_11 = "($";
  protected final String TEXT_12 = ")" + NL + "  {" + NL + "    $this->";
  protected final String TEXT_13 = " = $";
  protected final String TEXT_14 = ";";
  protected final String TEXT_15 = NL + NL + "    // entry actions and do activities";
  protected final String TEXT_16 = NL + "    ";
  protected final String TEXT_17 = NL + "  }" + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -Dmyenv=FILL_ME_IN.xml codegenMoveTemplates to move into the appropriate projects
  for (StateMachine sm : uClass.getAllStateMachines())  
  {
    if (sm.getType() == "Simple" && sm.numberOfStates() > 0)
    {
      
    
  
  StringBuffer allCases = new StringBuffer();

  for (State state : sm.getStates())
  {
    if (state.getIsStartState())
    {
      allCases.append(StringFormatter.format("if"));
    }
    else
    {
      allCases.append(StringFormatter.format("    elseif"));
    }
    allCases.append(StringFormatter.format(" (${0} == \"{1}\")\n",gen.translate("parameterOne",sm),gen.translate("stateOne",state)));
    allCases.append(StringFormatter.format("    {\n"));
    allCases.append(StringFormatter.format("      $this->{0} = self::${1};\n",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
    allCases.append(StringFormatter.format("      return true;\n"));
    allCases.append(StringFormatter.format("    }\n"));
  }
  String outputCases = allCases.toString().trim();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_2);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_5);
    
    }
    else if (sm.numberOfStates() > 0)
    {
      
    
  boolean hasEntry = false;
  boolean hasExit = false;
  boolean isFirstEntry = true;
  boolean isFirstExit = true;

  StringBuilder entryActions = new StringBuilder();
  StringBuilder exitActions = new StringBuilder();
  for(State state : sm.getStates())
  {
    boolean hasThisEntry = false;
    boolean hasThisExit = false;
    
    for(Action action : state.getActions())
    {
      if ("entry".equals(action.getActionType()))
      {
        if (!hasThisEntry)
        {
          if (isFirstEntry)
          {
            entryActions.append(StringFormatter.format("if ($this->{0} == self::${1})\n    {",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
          }
          else
          {
            entryActions.append("\n    ");
            entryActions.append(StringFormatter.format("elseif ($this->{0} == self::${1})\n    {",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
          }
        }
        hasEntry = true;
        hasThisEntry = true;
        isFirstEntry = false;
        entryActions.append("\n      " + action.getActionCode());
      }
      else if ("exit".equals(action.getActionType()))
      {
        if (!hasThisExit)
        {
          if (isFirstExit)
          {
            exitActions.append(StringFormatter.format("if ($this->{0} == self::${1})\n    {",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
          }
          else
          {
            exitActions.append("\n    ");
            exitActions.append(StringFormatter.format("elseif ($this->{0} == self::${1})\n    {",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
          }
          isFirstExit = false;
        }
        hasExit = true;
        hasThisExit = true;
        isFirstExit = false;
        exitActions.append("\n      " + action.getActionCode());
      }
    }
  
    if (state.getActivity() != null)
    {
      if (!hasThisEntry)
      {
        if (isFirstEntry)
        {
          entryActions.append(StringFormatter.format("if ($this->{0} == self::${1})\n    {",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
        }
        else
        {
          entryActions.append("\n    ");
          entryActions.append(StringFormatter.format("elseif ($this->{0} == self::${1})\n    {",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
        }
      }
      hasEntry = true;
      hasThisEntry = true;
      isFirstEntry = false;
      entryActions.append(StringFormatter.format("\n      {0}",state.getActivity().getActivityCode()));
    }
    
    if (hasThisEntry)
    {
      entryActions.append("\n    }");
    }
    
    if (hasThisExit)
    {
      exitActions.append("\n    }");
    }
  }

     if (hasExit) { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_9);
     } 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_11);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_14);
     if (hasEntry) { 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    stringBuffer.append( entryActions );
     } 
    stringBuffer.append(TEXT_17);
    
    }
  }
}

    return stringBuffer.toString();
  }
}
