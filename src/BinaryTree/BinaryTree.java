package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que se encarga de insertar, eliminar y mostrar el arbol binario.
 *
 * @author Daniel
 */
public class BinaryTree {

    private Node root;

    private int comparisons;
    private int assignments;
    private int lines;

    /**
     * Limpia las variables de comparaciones y asignaciones.
     */
    private void clearVars() {
        this.comparisons = 0;
        this.assignments = 0;
        this.lines = 0;
    }

    /**
     * Imprime las asignaciones y comparaciones realizadas y despues las limpia
     *
     * @param time Tiempo que se desea imprimir.
     */
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
        this.clearVars();
    }

    /**
     * No se Mide. Agrega los nodos al arbol.
     *
     * @param value Valor que se le va asignar al nodo.
     * @return TRUE si se inserto correctamente o FALSE si no es así.
     */
    public boolean add(int value) {
        Node nodo = new Node(value);
        if (this.root == null) {
            this.root = nodo;
            return true;
        }

        Node aux = this.root;
        while (true) {
            int id = aux.getId();

            if (id > value) {
                if (aux.getLeft() == null) {
                    aux.setLeft(nodo);
                    return true;
                }
                aux = aux.getLeft();
                continue;
            }

            if (id < value) {
                if (aux.getRight() == null) {
                    aux.setRight(nodo);
                    return true;
                }
                aux = aux.getRight();
                continue;
            }
            return false;
        }
    }

    
    
    /**
     * Imprime en anchura el arbol.
     */
    public void level() {
        
        this.lines++;
        this.comparisons++;
        if (this.root == null) {
            this.lines++;
            return;
        }

        this.assignments++;
        this.lines++;
        List<Node> queue = new ArrayList<>();
        
        this.assignments++;
        this.lines++;
        queue.add(this.root);

        while (!queue.isEmpty()) {
            this.lines++;
            this.comparisons++;
            
            this.assignments++;
            this.lines++;
            Node nodo = queue.remove(0);

            this.comparisons++;
            this.lines++;
            if (nodo.getLeft() != null) {
                this.assignments++;
                this.lines++;
                queue.add(nodo.getLeft());
            }
            
            this.lines++;
            this.comparisons++;
            if (nodo.getRight() != null) {
                this.assignments++;
                this.lines++;
                queue.add(nodo.getRight());
            }
        }
    }

    /**
     * Este metodo es recursivo. Esta echo en EnOrden.
     *
     * @param aux El siguiente Nodo que se desea imprimir
     * @return null si llega al fondo o si el parametro que se paso es null.
     */
    public Node profundity(Node aux) {
        
        this.comparisons++;
        this.lines++;
        if (aux == null) {
            this.lines++;
            return null;
        }

        this.assignments++;
        this.lines++;
        this.profundity(aux.getLeft());

        this.assignments++;
        this.lines++;
        this.profundity(aux.getRight());
        
        this.lines++;
        return null;
    }

    
    
    
    /**
     * No se Mide. Recupera el node raiz del arbol
     *
     * @return Node
     */
    public Node getRoot() {
        return this.root;
    }

    /**
     * No se Mide. Llena el arbol binario automaticamente dependiendo de la
     * cantidad de elementos.
     *
     * @param total El numero total de elemento que va tener el arbol.
     */
    public void autoFill(int total) {
        // Metemos en una lista los números del 1 al total.
        List<Integer> numbers = new ArrayList<>(total);
        for (int i = 1; i < total + 1; i++) {
            numbers.add(i);
        }

        Random random = new Random();

        while (numbers.size() > 1) {
            // Elegimos un índice al azar, entre 0 y el número de elementos 
            // que quedan por sacar
            int randomIndex = random.nextInt(numbers.size());

            this.add(numbers.get(randomIndex));

            // Y eliminamos el elemento de la lista
            numbers.remove(randomIndex);
        }
    }

}
