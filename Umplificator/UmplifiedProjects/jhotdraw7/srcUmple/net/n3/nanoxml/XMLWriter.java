/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package net.n3.nanoxml;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Vector;

public class XMLWriter
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public XMLWriter()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private PrintWriter writer;
/**
    * Cleans up the object when it's destroyed.
    */
   protected void finalize()
      throws Throwable
   {
      this.writer = null;
      super.finalize();
   }
/**
    * Writes an XML element.
    *
    * @param xml the non-null XML element to write.
    */
   public void write(IXMLElement xml)
      throws IOException
   {
      this.write(xml, false, 0, true);
   }
/**
    * Writes an XML element.
    *
    * @param xml the non-null XML element to write.
    * @param prettyPrint if spaces need to be inserted to make the output more
    *                    readable
    */
   public void write(IXMLElement xml,
                     boolean     prettyPrint)
      throws IOException
   {
      this.write(xml, prettyPrint, 0, true);
   }
/**
    * Writes an XML element.
    *
    * @param xml the non-null XML element to write.
    * @param prettyPrint if spaces need to be inserted to make the output more
    *                    readable
    * @param indent how many spaces to indent the element.
    */
   public void write(IXMLElement xml,
                     boolean     prettyPrint,
                     int         indent)
       throws IOException
   {
       this.write(xml, prettyPrint, indent, true);
   }
/**
    * Writes an XML element.
    *
    * @param xml the non-null XML element to write.
    * @param prettyPrint if spaces need to be inserted to make the output more
    *                    readable
    * @param indent how many spaces to indent the element.
    */
   public void write(IXMLElement xml,
                     boolean     prettyPrint,
                     int         indent,
                     boolean     collapseEmptyElements)
      throws IOException
   {
      if (prettyPrint) {
         for (int i = 0; i < indent; i++) {
            this.writer.print(' ');
         }
      }

      if (xml.getName() == null) {
         if (xml.getContent() != null) {
            if (prettyPrint) {
               this.writeEncoded(xml.getContent().trim());
               writer.println();
            } else {
               this.writeEncoded(xml.getContent());
            }
         }
      } else {
         this.writer.print('<');
         this.writer.print(xml.getFullName());
         Vector nsprefixes = new Vector();

         if (xml.getNamespace() != null) {
            if (xml.getName().equals(xml.getFullName())) {
               this.writer.print(" xmlns=\"" + xml.getNamespace() + '"');
            } else {
               String prefix = xml.getFullName();
               prefix = prefix.substring(0, prefix.indexOf(':'));
               nsprefixes.addElement(prefix);
               this.writer.print(" xmlns:" + prefix);
               this.writer.print("=\"" + xml.getNamespace() + "\"");
            }
         }

         Iterator enm = xml.iterateAttributeNames();

         while (enm.hasNext()) {
            String key = (String) enm.next();
            int index = key.indexOf(':');

            if (index >= 0) {
               String namespace = xml.getAttributeNamespace(key);

               if (namespace != null) {
                  String prefix = key.substring(0, index);

                  if (! nsprefixes.contains(prefix)) {
                     this.writer.print(" xmlns:" + prefix);
                     this.writer.print("=\"" + namespace + '"');
                     nsprefixes.addElement(prefix);
                  }
               }
            }
         }

         enm = xml.iterateAttributeNames();

         while (enm.hasNext()) {
            String key = (String) enm.next();
            String value = xml.getAttribute(key, null);
            this.writer.print(" " + key + "=\"");
            this.writeEncoded(value);
            this.writer.print('"');
         }

         if ((xml.getContent() != null)
             && (xml.getContent().length() > 0)) {
            writer.print('>');
            this.writeEncoded(xml.getContent());
            writer.print("</" + xml.getFullName() + '>');

            if (prettyPrint) {
               writer.println();
            }
         } else if (xml.hasChildren() || (! collapseEmptyElements)) {
            writer.print('>');

            if (prettyPrint) {
               writer.println();
            }

            enm = xml.iterateChildren();

            while (enm.hasNext()) {
               IXMLElement child = (IXMLElement) enm.next();
               this.write(child, prettyPrint, indent + 4,
                          collapseEmptyElements);
            }

            if (prettyPrint) {
               for (int i = 0; i < indent; i++) {
                  this.writer.print(' ');
               }
            }

            this.writer.print("</" + xml.getFullName() + ">");

            if (prettyPrint) {
               writer.println();
            }
         } else {
            this.writer.print("/>");

            if (prettyPrint) {
               writer.println();
            }
         }
      }

      this.writer.flush();
   }
/**
    * Writes a string encoding reserved characters.
    *
    * @param str the string to write.
    */
   private void writeEncoded(String str)
   {
      for (int i = 0; i < str.length(); i++) {
         char c = str.charAt(i);

         switch (c) {
            case 0x0A:
               this.writer.print(c);
               break;

            case '<':
               this.writer.print("&lt;");
               break;

            case '>':
               this.writer.print("&gt;");
               break;

            case '&':
               this.writer.print("&amp;");
               break;

            case '\'':
               this.writer.print("&apos;");
               break;

            case '"':
               this.writer.print("&quot;");
               break;

            default:
               if ((c < ' ') || (c > 0x7E)) {
                  this.writer.print("&#x");
                  this.writer.print(Integer.toString(c, 16));
                  this.writer.print(';');
               } else {
                  this.writer.print(c);
               }
         }
      }
   }
}