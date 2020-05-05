package BinaryTree;

/**
 * Se insertan en el arbol binario y almacena los siguientes nodos.
 *
 * @author Daniel
 */
public class Node {

    private Node right;
    private Node left;
    private int id;

    /**
     * Constructo de la clase
     *
     * @param id id del nodo.
     */
    public Node(int id) {
        this.id = id;
    }

    /**
     * Establece el nodo a la derecha
     *
     * @param node nodo que se va a insertar
     */
    public void setRight(Node node) {
        this.right = node;
    }

    /**
     * Establece el nodo a la izquierda
     *
     * @param node nodo que se va a insertar
     */
    public void setLeft(Node node) {
        this.left = node;

    }

    /**
     * Recupera el nodo derecho al que apunta
     *
     * @return Retorna el nodo que apunta.
     */
    public Node getRight() {
        return this.right;
    }

    /**
     * Recupera el nodo izquierdo al que apunta
     *
     * @return Retorna el nodo que apunta.
     */
    public Node getLeft() {
        return this.left;
    }

    /**
     * Recupera el valor del nodo
     *
     * @return el int del identificacion del nodo
     */
    public int getId() {
        return this.id;
    }
}
