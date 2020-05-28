package Graph;

/**
 * Una clase que representa un grafo interconectado por varios {@link Arc}.
 */
public class Graph {

    // Algunas variables utilizadas
    public Vertex firstVertex;
    public long comparisons;
    public long assignments;
    private int lines;

    /**
     * Inserta un {@link Vertex} al grafo.
     *
     * @param name el nombre es el numero que se le asigna a cada {@link Vertex}
     */
    public void addVertex(int name) {
        Vertex newVertex = new Vertex(name);
        if (firstVertex == null) {
            firstVertex = newVertex;
            return;
        }
        newVertex.nextVertex = firstVertex;
        firstVertex = newVertex;
    }

    /**
     * Inserta un {@link Arc} de un {@link Vertex} a otro.
     *
     * @param source {@link Vertex} de origen
     * @param destination {@link Vertex} de destino
     */
    public void addArc(Vertex source, Vertex destination) {
        Arc newArc = new Arc();
        newArc.destination = destination;
        if (source.firstArc == null) {
            source.firstArc = newArc;
        } else {
            newArc.nextArc = source.firstArc;
            source.firstArc = newArc;
        }
    }

    /**
     * Método que crea los {@link Vertex} y hace las conexiones entre ellos para
     * hacer un grafo conexo.
     *
     * @param amount cantidad de vertices a insertar
     * @return true si todo salió bien
     */
    public boolean createGraph(int amount) {
        for (int i = 1; i <= amount; i++) {
            addVertex(i);
        }
        Vertex aux = firstVertex;
        Vertex aux2 = firstVertex;
        while (aux != null) {
            while (aux2 != null) {
                if (aux != aux2) {
                    addArc(aux, aux2);
                }
                aux2 = aux2.nextVertex;
            }
            aux2 = firstVertex;
            aux = aux.nextVertex;
        }
        return true;
    }

    /**
     * Ejecuta el recorrido en profundidad.
     */
    public void depthRun() {
        clearMarks();
        depthRunHelper(firstVertex);
    }

    /**
     * Se encarga de realizar el recorrido en profundidad.
     *
     * @param vertex el {@link Vertex} que se está recorriendo
     */
    private void depthRunHelper(Vertex vertex) {
        comparisons += 2;
        lines++;
        if ((vertex == null) || (vertex.mark)) {
            lines++;
            return;
        }
        assignments++;
        lines++;
        vertex.mark = true;

        assignments++;
        lines++;
        Arc arc = vertex.firstArc;

        lines++;
        comparisons++;
        while (arc != null) {
            comparisons++;

            lines++;
            depthRunHelper(arc.destination);

            lines++;
            assignments++;
            arc = arc.nextArc;
        }
    }

    /**
     * Limpia las marcas de todos los vertices.
     */
    private void clearMarks() {
        Vertex aux = firstVertex;
        while (aux != null) {
            aux.mark = false;
            aux = aux.nextVertex;
        }
    }

    /**
     * Recorre todos los nodos del grafo iterativamente.
     */
    public void widthRun() {
        lines++;
        Vertex tempVertex = firstVertex;
        assignments++;

        comparisons++;
        lines++;
        while (tempVertex != null) {
            lines++;
            comparisons++;

            Arc tempArc = tempVertex.firstArc;
            lines++;
            assignments++;
            while (tempArc != null) {
                lines++;
                comparisons++;
                tempArc = tempArc.nextArc;
                lines++;
                assignments++;
            }

            tempVertex = tempVertex.nextVertex;
            lines++;
            assignments++;
        }
    }

    public void printVars(float time) {
        System.out.print("Timepo transcurrido: ");
        System.out.printf("Tiempo = %.3f S\n", time / 1000);
        System.out.print("Comparaciones: ");
        System.out.println(this.comparisons);
        System.out.print("Asignaciones: ");
        System.out.println(this.assignments);
        System.out.print("Lineas de codigo: ");
        System.out.println(this.lines);
        System.out.println("\n");
        this.assignments = 0;
        this.comparisons = 0;
        this.lines = 0;
    }
}
