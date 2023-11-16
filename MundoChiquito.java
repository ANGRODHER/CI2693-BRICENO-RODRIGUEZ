public class MundoChiquito {
    public static void main(String[] args) {
        DGrafo grafo = new DGrafo();
        String archivoCSV = "deck.csv";
        grafo.cargarGrafo(archivoCSV);

        grafo.mundochiquito();

    }
}
