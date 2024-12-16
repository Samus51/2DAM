package hlc.ud03.examen.datos;

public class BloqueDatosException extends RuntimeException {

  public BloqueDatosException(String string) {
    super(string);
  }

  public BloqueDatosException(Exception e) {
    super(e);
  }

}
