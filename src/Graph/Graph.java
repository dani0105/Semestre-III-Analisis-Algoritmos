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
     * @return insertado si todo salió bien en caso contrario un string sin nada
     */
    public String addVertex(int name) {
        Vertex newVertex = new Vertex(name);
        if (firstVertex == null) {
            firstVertex = newVertex;

            return "Insertado";
        }
        newVertex.nextVertex = firstVertex;
        firstVertex.prevVertex = newVertex;
        firstVertex = newVertex;

        return "";
    }

    /**
     * Busca si existe un {@link Arc} que conecte dos vertices.
     *
     * @param source {@link Vertex} de origen
     * @param destination {@link Vertex} de destino
     * @return retorna el {@link Arc} encontrado o null si no existe
     */
    public Arc searchArc(Vertex source, Vertex destination) {
        if (source.firstArc != null) {
            Arc aux = source.firstArc;
            while (aux != null) {
                if (aux.destination == destination) {
                    return aux;
                }
                aux = aux.nextArc;
            }
        }
        return null;
    }

    /**
     * Busca un {@link Vertex} en el Grafo.
     *
     * @param name el nombre del {@link Vertex} a buscar
     * @return retorna el {@link Vertex} encontrado o null si este no existe
     */
    public Vertex searchVertex(int name) {
        Vertex aux = firstVertex;
        while (aux != null) {
            if (aux.name == name) {
                return aux;
            }
            aux = aux.nextVertex;
        }
        return null;
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
            source.firstArc.prevArc = newArc;
            source.firstArc = newArc;
        }
    }

    /**
     * Cuenta los {@link Arc} que tiene cada {@link Vertex}.
     *
     * @param inicio {@link Vertex} al que se le cuentan los arcos
     * @return la cantidad de {@link Arcos}
     */
    public int arcsCount(Vertex inicio) {
        int cantidad = 0;
        Vertex vertice = searchVertex(inicio.name);
        if (vertice.firstArc != null) {
            Arc aux = vertice.firstArc;
            while (aux != null) {
                cantidad = cantidad + 1;
                aux = aux.nextArc;
            }
        }
        return cantidad;
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
    }
}
