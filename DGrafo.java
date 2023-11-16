import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.nio.charset.StandardCharsets;

public class DGrafo implements Graph<CartaMostro> {
    // Declaramos las variables, arreglos y tablas que vayamos a utilizar
    private HashMap<String, CartaMostro> vertices;
    private ArrayList<edges> connect;
    public static final int inf = Integer.MAX_VALUE;

    public DGrafo() {
        // Constructor de la clase.
        vertices = new HashMap<>();
        connect = new ArrayList<>();
    }

    // Método para agregar un vértice al grafo
    public boolean add(CartaMostro vertex) {
        if (!vertices.containsKey(vertex.getNombre())) {
            // Agregar el vértice al hashtable
            vertices.put(vertex.getNombre(), vertex);
            // Vértice agregado exitosamente
            return true;
        }
        // El vértice ya existe en el grafo
        return false;
    }

    // Método para verificar si un vértice existe en el grafo dado su identificador
    public boolean contains(CartaMostro vertex) {
        if (vertices.containsKey(vertex.getNombre())) {
            // El vértice existe en el grafo
            return true;
        }
        // El vértice no existe en el grafo
        return false;
    }

    // Método para verificar si existe un lado entre dos vértices
    public boolean containsconnect(CartaMostro from, CartaMostro to) {
        // Iterar sobre todos los lados
        for (edges a : connect) {
            // Verificar si los vértices extremos coinciden en cualquier dirección
            if (a.getExtremoInicial().equals(from) && a.getExtremoFinal().equals(to)) {
                // Existe un lado entre los vértices
                return true;
            }
        }
        // No existe un lado entre los vértices
        return false;
    }

    // Método para verificar si existe un lado entre dos vértices
    public String containsconnectComun(CartaMostro from, CartaMostro to) {
        // Iterar sobre todos los lados
        for (edges a : connect) {
            // Verificar si los vértices extremos coinciden en cualquier dirección
            if (a.getExtremoInicial().equals(from) && a.getExtremoFinal().equals(to)) {
                // Existe un lado entre los vértices
                return a.getComun();
            }
        }
        // No existe un lado entre los vértices
        return null;
    }

    public boolean connect(CartaMostro from, CartaMostro to, String comun) {
        // Esta función establece la relación entre dos vértices si existe una conexión
        // entre ellos.
        if (!containsconnect(from, to)) {
            edges arista = new edges("" + from.getNombre() + to.getNombre() + "", comun, from, to);
            connect.add(arista);
            return true;
        }
        return false;
    }

    public boolean disconnect(CartaMostro from, CartaMostro to) {
        // Esta función elimina la relación entre dos vértices si existe una conexión
        // entre ellos.
        if (contains(from) && contains(to) && containsconnect(from, to)) {
            for (edges a : connect) {
                if (a.getExtremoInicial().equals(from) && a.getExtremoFinal().equals(to)) {
                    connect.remove(a);
                    return true;
                }
            }
        }
        return false;
    }

    public List<CartaMostro> getInwardEdges(CartaMostro to) {
        // Esta función devuelve una lista de vértices predecesores que tienen una
        // conexión con el vértice dado.
        List<CartaMostro> inwardEdges = new ArrayList<>();
        for (edges a : connect) {
            if (a.getExtremoFinal().getNombre().equals(to.getNombre())) {
                inwardEdges.add(a.getExtremoInicial());
            }
        }
        return inwardEdges;
    }

    public List<CartaMostro> getOutwardEdges(CartaMostro from) {
        // Esta función devuelve una lista de vértices sucesores que tienen una conexión
        // con el vértice dado.
        List<CartaMostro> outwardEdges = new ArrayList<>();
        for (edges a : connect) {
            if (a.getExtremoInicial().getNombre().equals(from.getNombre())) {
                outwardEdges.add(a.getExtremoFinal());
            }
        }
        return outwardEdges;
    }

    public List<CartaMostro> getVerticesConnectedTo(CartaMostro vertex) {
        // Esta función devuelve una lista de vértices que tienen una conexión con el
        // vértice dado.
        List<CartaMostro> verticesConnectedTo = new ArrayList<>();
        for (edges a : connect) {
            if (a.getExtremoInicial().getNombre().equals(vertex.getNombre())) {
                verticesConnectedTo.add(a.getExtremoFinal());
            } else if (a.getExtremoFinal().equals(vertex)) {
                verticesConnectedTo.add(a.getExtremoInicial());
            }
        }
        return verticesConnectedTo;
    }

    public List<CartaMostro> getAllVertices() {
        // Esta función devuelve una lista de todos los vértices del grafo.
        List<CartaMostro> allVertices = new ArrayList<>();
        for (String key : vertices.keySet()) {
            allVertices.add(vertices.get(key));
        }
        return allVertices;
    }

    public boolean remove(CartaMostro vertex) {
        // Esta función elimina un vértice del grafo.
        if (contains(vertex)) {
            vertices.remove(vertex.getNombre());
            return true;
        }
        return false;
    }

    public int size() {
        // Esta función devuelve el número de vértices en el grafo.
        return vertices.size();
    }

    @Override
    public String toString() {
        // Este método devuelve una representación en forma de cadena del grafo.
        StringBuilder sb = new StringBuilder();
        // Iterar sobre todos los vertices en el grafo
        for (CartaMostro a : vertices.values()) {
            sb.append("Nombre: ").append(a.getNombre()).append(" Nivel: ").append(a.getNivel()).append(" Atributo: ")
                    .append(a.getAtributo()).append(" Poder: ").append(a.getPoder()).append("\n");
        }
        // Iterar sobre todas las aristas en el grafo
        for (edges l : connect) {
            sb.append(l).append("\n");
        }
        // Devolver la representación en forma de cadena del grafo
        return sb.toString();
    }

    public boolean cargarGrafo(String archivoCSV) {
        // Esta función cargará los datos de un .txt
        try (BufferedReader lista = new BufferedReader(new FileReader(archivoCSV, StandardCharsets.UTF_8))) {
            String linea;
            boolean primeraLinea = true;
            // Dividir la línea en datos separados por '|'
            while ((linea = lista.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue; // Omitir la primera línea
                }
                String[] datos = linea.split(",");
                String Nombre = datos[0];
                Integer Nivel = Integer.parseInt(datos[1]);
                String Atributo = datos[2];
                Integer Poder = Integer.parseInt(datos[3]);
                CartaMostro a = new CartaMostro(Nombre);
                a.setNivel(Nivel);
                a.setAtributo(Atributo);
                a.setPeso(Poder);
                add(a);
            }
            for (CartaMostro c1 : vertices.values()) {
                for (CartaMostro c2 : vertices.values()) {
                    if (c1 != c2) {

                        if (c1.getNivel() == c2.getNivel() && !(c1.getAtributo().equals(c2.getAtributo()))
                                && c1.getPoder() != c2.getPoder()) {
                            connect(c1, c2, "" + c1.getNivel() + "");
                        } else if (c1.getNivel() != c2.getNivel() && (c1.getAtributo().equals(c2.getAtributo()))
                                && c1.getPoder() != c2.getPoder()) {
                            connect(c1, c2, c1.getAtributo());
                        } else if (c1.getNivel() != c2.getNivel() && !(c1.getAtributo().equals(c2.getAtributo()))
                                && c1.getPoder() == c2.getPoder()) {
                            connect(c1, c2, "" + c1.getPoder() + "");
                        }
                    }
                }
            }
            return true;
        } catch (IOException | NumberFormatException e) {
            return false;
        }
    }

    public ArrayList<String> mundochiquito() {
        // Esta función devuelve un ArrayList con los vértices del grafo.
        ArrayList<String> mundochiquito = new ArrayList<>();
        for (CartaMostro a : vertices.values()) {
            for (CartaMostro b : getOutwardEdges(a)) {
                for (CartaMostro c : getOutwardEdges(b)) {
                    if (a != b && b != c) {

                        if (containsconnectComun(a, b) != containsconnectComun(b, c))

                            mundochiquito.add(a.getNombre() + " " + b.getNombre() + " " + c.getNombre());
                    }
                }
            }
        }
        // Verificamos si existe una terna relacionada
        if (mundochiquito.size() == 0) {
            System.out.println("No existe una terna relacionada");
            return mundochiquito;
        }
        for (String i : mundochiquito) {
            System.out.println(i);
        }
        return mundochiquito;
    }

    // end
}
