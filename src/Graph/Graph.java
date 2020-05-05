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
        if (source.nextArc != null) {
            Arc aux = source.nextArc;
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
            if (source.nextArc == null) {
                source.nextArc = newArc;
            } else {
                newArc.nextArc = source.nextArc;
                source.nextArc.prevArc = newArc;
                source.nextArc = newArc;
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
        if (vertice.nextArc != null) {
            Arc aux = vertice.nextArc;
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
        if (source == null || source.mark == true) {
            return;
        }
        source.mark = true;
        assignments++;
        System.out.println("Recursivo" + " " + source.name);
        Arc arc = source.nextArc;
        assignments++;
        while (arc != null) {
            comparisons++;
            comparisons++;
            if (arc.destination == destination) {
                flag = true;
                assignments++;
            }
            searchRoute(arc.destination, destination);
            arc = arc.nextArc;
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
    public void anchura() {
        ArrayList<Vertex> queue = new ArrayList<>();
        assignments++;
        finalG.mark = true;
        assignments++;
        queue.add(finalG);
        assignments++;
        while (!queue.isEmpty()) {
            comparisons++;
            Vertex aux = queue.remove(0);
            assignments++;
            System.err.println("iterador" + " " + aux.name);
            Arc aux2 = aux.nextArc;
            assignments++;
            while (aux2 != null) {
                comparisons++;
                comparisons++;
                if (aux.nextArc.destination.mark != true) {
                    aux.nextArc.destination.mark = true;
                    assignments++;
                    queue.add(aux.nextArc.destination);
                    assignments++;
                }
                aux2 = aux2.nextArc;
                assignments++;
            }
        }
    }

}
