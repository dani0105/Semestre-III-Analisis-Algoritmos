package Graph;

import java.util.ArrayList;

/**
 * Una clase que representa un grafo interconectado por varios {@link Arc}.
 */
public class Graph {

    // Algunas variables utilizadas
    public Vertex firstVertex;
    public Vertex finalG;
    boolean flag;
    public int comparisons;
    public int assignments;
    private int lines;

    /**
     * Inserta un {@link Vertex} al grafo.
     *
     * @param name el nombre es el numero que se le asigna a cada {@link Vertex}
     * @return insertado si todo salio bien en caso contrario un string sin nada
     */
    public String addVertex(int name) {
        Vertex newVertex = new Vertex(name);
        if (firstVertex == null) {
            firstVertex = newVertex;
            finalG = newVertex;

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
     * @return retorna insertado si todo salió bien o otro string en caso
     * contrario
     */
    public String addArc(Vertex source, Vertex destination) {
        if (searchArc(source, destination) == null) {
            Arc newArc = new Arc();
            newArc.destination = destination;
            if (source.firstArc == null) {
                source.firstArc = newArc;
            } else {
                newArc.nextArc = source.firstArc;
                source.firstArc.prevArc = newArc;
                source.firstArc = newArc;
            }
            return "Insertado";
        }
        return "No se pueden repetir arcos";
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
            return cantidad;
        }
        return 00;
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
        while (aux != null) {
            addArc(aux, aux.nextVertex);
            if (finalG == aux) {
                addArc(aux, firstVertex);
            }
            aux = aux.nextVertex;
        }
        return true;
    }

    /**
     * Busca recursivamente una ruta de un {@link Vertex} a otro, por o que si
     * se pone el primero y el segundo pasa por todos los {@link Vertex}
     * creados.
     *
     * @param source primer {@link Vertex} de el grafo
     * @param destination último {@link Vertex} del grafo
     */
    public void searchRoute(Vertex source, Vertex destination) {
        comparisons++;
        lines++;
        if (source == null || source.mark == true) {
            lines++;
            return;
        }
        source.mark = true;
        lines++;
        assignments++;
        Arc arc = source.firstArc;
        lines++;
        assignments++;
        while (arc != null) {
            lines++;
            comparisons++;
            comparisons++;
            if (arc.destination == destination) {
                lines++;
                flag = true;
                lines++;
                assignments++;
            }
            searchRoute(arc.destination, destination);
            lines++;
            arc = arc.nextArc;
            lines++;
            assignments++;
        }
    }

    /**
     * Verificar que el grafo es conexo.
     *
     * @return true si lo es o false si no lo es
     */
    public boolean grafoConexo() {
        Vertex aux = firstVertex;
        while (aux != null) {
            Vertex aux2 = firstVertex;
            while (aux2 != null) {
                flag = false;
                if (aux2 != aux) {
                    searchRoute(aux, aux2);
                    clearMarks();
                    if (flag != true) {
                        return false;
                    }
                }
                aux2 = aux2.nextVertex;
            }
            aux = aux.nextVertex;
        }
        return true;
    }

    /**
     * Limpia las marcas de todos los vertices.
     */
    public void clearMarks() {
        Vertex aux = firstVertex;
        while (aux != null) {
            aux.mark = false;
            aux = aux.nextVertex;
        }
    }

    /**
     * Recorre todos los nodos del grafo iterativamente.
     */
    public void widthPath() {
        lines++;
        Vertex tempVertex = firstVertex;
        assignments++;

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
        System.out.printf("Tiempo = %.3f S\n",time/1000);
        System.out.print("Comparaciones: ");
        System.out.println(this.comparisons);
        System.out.print("Asignaciones: ");
        System.out.println(this.assignments);
        System.out.print("Lineas de codigo: ");
        System.out.println(this.lines);
        System.out.println("\n");
    }
}
