package uk.co.utilisoft.bpmn.fiddle.framework;

import org.apache.tomcat.util.http.fileupload.InvalidFileNameException;

import javax.annotation.processing.FilerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class FDLTools
{
  public static Path assertValidInput(Path aPath) throws IOException
  {
    if (!Files.exists(aPath))
      throw new FileNotFoundException(aPath.toString());
    
    if (!Files.isRegularFile(aPath))
      throw new FileNotFoundException(aPath + " is a directory!");

    if (!aPath.toString().toLowerCase().endsWith(".bpmn"))
      throw new InvalidFileNameException(aPath.toString(),"Not a valid .bpmn file");
    
    if (!Files.isReadable(aPath))
      throw new IOException(aPath + " cannot be read");
    
    return aPath;
  }
  
  public static Path assertValidOutput(Path aPath) throws IOException
  {
    if (Files.exists(aPath))
      throw new FileAlreadyExistsException(aPath.toString());
  
    if (!aPath.toString().toLowerCase().endsWith(".bpmn"))
      throw new InvalidFileNameException(aPath.toString(),"Not a valid .bpmn filename");
    
    return aPath;
  }
  
 
}
