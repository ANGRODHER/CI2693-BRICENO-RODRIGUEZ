import java.util.List;

public interface Graph<v> {
    public boolean add(v vertex);
    public boolean connect(v from, v to, String comun);
    public boolean disconnect(v from, v to);
    public boolean contains(v vertex);
    public List<CartaMostro> getInwardEdges(v to);
    public List<CartaMostro> getOutwardEdges(v from);
    public List<CartaMostro> getVerticesConnectedTo(v vertex);
    public List<CartaMostro> getAllVertices();
    public boolean remove(v vertex);
    public int size();
}