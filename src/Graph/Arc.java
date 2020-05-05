package Graph;

/**
 * Representa los arcos que conectan los múltiples {@link Vertex} que tiene
 * {@link Graph}.
 */
public class Arc {

    Arc nextArc;
    Arc prevArc;
    public Vertex destination;

    /**
     * Constructor por defecto.
     */
    public Arc() {
    }

}
