/*******************************************************************************
* Copyright (c) 2016 Ahmed M.Orabi, Mahmoud M.Orabi.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     Ahmed M.Orabi
*     Mahmoud M.Orabi
*
* Please refer to the code authors before making any changes. 
* For any code reuse or copy, contact the authors and it is a MUST 
* to refer author names.
*
* @author -Ahmed M.Orabi {@link ahmedvc@hotmail.com}
* @author Mahmoud M.Orabi {@link mahmoud_3rabi@hotmail.com}
*******************************************************************************/
package cruise.umple.test.harness.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TemplateGeneratedOutput {

  private String language;
  private List<String> files;

  public TemplateGeneratedOutput(String aLanguage, String[] afiles) {
    language = aLanguage;
    files = new ArrayList<String>();
    files.addAll(Arrays.asList(afiles));
  }
  
  public void setLanguage(String aLanguage) {
    language = aLanguage;
  }

  public boolean addFile(String aFile) {
    return files.add(aFile);
  }

  public boolean removeFile(String aFile) {
    return files.remove(aFile);
  }

  public String getLanguage() {
    return language;
  }

  public String getFile(int index) {
    String aFile = files.get(index);
    return aFile;
  }

  public String[] getFiles() {
    String[] newFiles = files.toArray(new String[files.size()]);
    return newFiles;
  }

  public int numberOfFiles()
  {
    int number = files.size();
    return number;
  }

  public boolean hasFiles()
  {
    boolean has = files.size() > 0;
    return has;
  }

  public int indexOfFile(String aFile)
  {
    int index = files.indexOf(aFile);
    return index;
  }

}