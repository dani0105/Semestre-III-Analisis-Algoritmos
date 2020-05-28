package Graph;

/**
 * Representa los vertices de un {@link Graph}.
 */
public class Vertex {

    public Vertex nextVertex;
    public int name;
    boolean mark;
    public Arc firstArc;

    /**
     * Crea un nuevo a vertice.
     *
     * @param name nombre del vertice
     */
    public Vertex(int name) {
        this.name = name;
        this.mark = false;
    }
}
