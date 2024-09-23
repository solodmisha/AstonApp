package validation;

import java.io.File;
import java.io.IOException;

public interface ValidStrategy  {

  Boolean  isValidImport ( File file) throws IOException;
}