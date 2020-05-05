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

    private int comparison;
    private int assignments;

    /**
     * Limpia las variables de comparaciones y asignaciones.
     */
    private void clearVars() {
        this.comparison = 0;
        this.assignments = 0;
    }

    /**
     * Imprime las asignaciones y comparaciones realizadas y despues las limpia
     *
     * @param time Tiempo que se desea imprimir.
     */
    public void printVars(long time) {
        System.out.print("Timepo transcurrido: ");
        System.out.println(time);
        System.out.print("Comparaciones: ");
        System.out.println(this.comparison);
        System.out.print("Asignaciones: ");
        System.out.println(this.assignments);
        System.out.println("\n");
        this.clearVars();
    }

    /**
     * No se Mide Agrega los nodos al arbol.
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
     * imprime en Anchura el arbol
     */
    public void level() {
        this.comparison++;
        if (this.root == null) {
            return;
        }

        this.assignments++;
        List<Node> queue = new ArrayList<>();
        this.assignments++;
        queue.add(this.root);

        while (!queue.isEmpty()) {
            this.comparison++;
            this.assignments++;
            Node nodo = queue.remove(0);

            this.comparison++;
            if (nodo.getLeft() != null) {
                this.assignments++;
                queue.add(nodo.getLeft());
            }
            this.comparison++;
            if (nodo.getRight() != null) {
                this.assignments++;
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
        this.comparison++;

        if (aux == null) {
            return null;
        }

        this.assignments++;

        this.profundity(aux.getLeft());

        this.assignments++;

        this.profundity(aux.getRight());

        return null;
    }

    /**
     * No se Mide Recupera el node raiz del arbol
     *
     * @return Node
     */
    public Node getRoot() {
        return this.root;
    }

    /**
     * No se Mide Llena el arbol binario automaticamente dependiendo de la
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
            // Elegimos un índice al azar, entre 0 y el número de cartas que quedan por sacar
            int randomIndex = random.nextInt(numbers.size());

            this.add(numbers.get(randomIndex));

            // Y eliminamos la carta del mazo (la borramos de la lista)
            numbers.remove(randomIndex);
        }
    }

}
