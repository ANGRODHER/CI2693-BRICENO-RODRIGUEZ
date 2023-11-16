public class edges extends connect {
  // Variables de Arista.
  private CartaMostro extremoInicial;
  private CartaMostro extremoFinal;

  // Crear Arista.
  public edges(String id, String peso, CartaMostro extremoInicial, CartaMostro extremoFinal) {
    super(id, peso);
    this.extremoInicial = extremoInicial;
    this.extremoFinal = extremoFinal;
  }

  // Obtener Extremo1.
  public CartaMostro getExtremoInicial() {
    return this.extremoInicial;
  }

  // Obtener Extremo2.
  public CartaMostro getExtremoFinal() {
    return this.extremoFinal;
  }

  // Mostrar la arista.
  @Override
  public String toString() {
    return "Aristas: (" + extremoInicial.getNombre() + " -> " + extremoFinal.getNombre() + ") Caracteristica: "
        + getComun();
  }
}
