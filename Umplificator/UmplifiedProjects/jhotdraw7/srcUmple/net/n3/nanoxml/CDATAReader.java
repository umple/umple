/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package net.n3.nanoxml;
import java.io.Reader;
import java.io.IOException;

public class CDATAReader
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CDATAReader()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private IXMLReader reader;
/**
    * Saved char.
    */
   private char savedChar;
/**
    * True if the end of the stream has been reached.
    */
   private boolean atEndOfData;
/**
    * Cleans up the object when it's destroyed.
    */
   protected void finalize()
      throws Throwable
   {
      this.reader = null;
      super.finalize();
   }
/**
    * Reads a block of data.
    *
    * @param buffer where to put the read data
    * @param offset first position in buffer to put the data
    * @param size maximum number of chars to read
    *
    * @return the number of chars read, or -1 if at EOF
    *
    * @throws java.io.IOException
    *		if an error occurred reading the data
    */
   public int read(char[] buffer,
                   int    offset,
                   int    size)
      throws IOException
   {
      int charsRead = 0;

      if (this.atEndOfData) {
         return -1;
      }

      if ((offset + size) > buffer.length) {
         size = buffer.length - offset;
      }

      while (charsRead < size) {
         char ch = this.savedChar;

         if (ch == 0) {
            ch = this.reader.read();
         } else {
            this.savedChar = 0;
         }

         if (ch == ']') {
            char ch2 = this.reader.read();
            
            if (ch2 == ']') {
               char ch3 = this.reader.read();

               if (ch3 == '>') {
                  this.atEndOfData = true;
                  break;
               }

               this.savedChar = ch2;
               this.reader.unread(ch3);
            } else {
               this.reader.unread(ch2);
            }
         }
         buffer[charsRead] = ch;
         charsRead++;
      }

      if (charsRead == 0) {
         charsRead = -1;
      }

      return charsRead;
   }
/**
    * Skips remaining data and closes the stream.
    *
    * @throws java.io.IOException
    *		if an error occurred reading the data
    */
   public void close()
      throws IOException
   {
      while (! this.atEndOfData) {
         char ch = this.savedChar;

         if (ch == 0) {
            ch = this.reader.read();
         } else {
            this.savedChar = 0;
         }

         if (ch == ']') {
            char ch2 = this.reader.read();

            if (ch2 == ']') {
               char ch3 = this.reader.read();

               if (ch3 == '>') {
                  break;
               }

               this.savedChar = ch2;
               this.reader.unread(ch3);
            } else {
               this.reader.unread(ch2);
            }
         }
      }

      this.atEndOfData = true;
   }
}