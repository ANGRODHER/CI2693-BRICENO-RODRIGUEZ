public class CartaMostro {
      // variables de la clase.
      private String Nombre;
      private int Poder;
      private int Nivel;
      private String Atributo;
      

      // Constructor de la clase.
      public CartaMostro(String id) {
            this.Nombre = id;
            this.Poder = -1;
            this.Nivel = -1;
            this.Atributo = null;
      }

      // Establece el estado de visitado del vértice.
      public int setNivel(int n) {
            this.Nivel = n;
            return this.Nivel;
      }

      // Obtiene el estado de visitado del vértice.
      public int getNivel() {
            return this.Nivel;
      }

      public String setAtributo(String a){
            this.Atributo = a;
            return this.Atributo;
      }

      public String getAtributo(){
            return this.Atributo;
      }

      // obtener Poder del vertice.
      public int getPoder() {
            return this.Poder;
      }

      // obtener id del vertice.
      public String getNombre() {
            return this.Nombre;
      }

      public int setPeso(int p){
            this.Poder = p;
            return this.Poder;
      } 

      // Devuelve una representación en forma de cadena del vértice.
      public String toString() {
            return " " + getNombre();
      }
}