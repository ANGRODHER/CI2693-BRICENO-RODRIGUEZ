
public abstract class connect {
  // Clase abstracta

  // Propiedades de la clase
  private String id;
  private String comun;

  public connect(String id, String peso) {
    // Constructor de la clase abstracta
    this.id = id;
    this.comun = peso;
  }

  public String getId() {
    // obtener el id
    return id;
  }

  public String getComun() {
    // Obtener el comun
    return comun;
  }

  public String setComun(String x) {
    // Cambiar el comun
    this.comun = x;
    return comun;
  }

  public abstract String toString();
}