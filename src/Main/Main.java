package Main;

import BinaryTree.BinaryTree;
import Graph.Graph;

public class Main {

    private static final int TREE_TEST_VALUE = 1000;
    private static final int GRAPH_TEST_VALUE = 100;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree tree;
        Graph grafo;

        // Ejecucion de los arboles
        System.out.printf("Arboles valor (%d)\n", TREE_TEST_VALUE);
        tree = new BinaryTree();
        tree.autoFill(TREE_TEST_VALUE); // se llena el arbol

        // Recorrido por nivel (iterativo)
        System.out.println("\nRecorrido por nivel");
        long start = System.currentTimeMillis();
        tree.level();
        long finish = System.currentTimeMillis();
        tree.printVars(finish - start);

        // Recorrido por profundidad (recursivo)
        System.out.println("Recorrido por profundidad");
        start = System.currentTimeMillis();
        tree.profundity(tree.getRoot());
        finish = System.currentTimeMillis();
        tree.printVars(finish - start);

        // Ejecucion de los grafos
        System.out.printf("Grafos valor (%d)\n", GRAPH_TEST_VALUE);
        grafo = new Graph();
        grafo.createGraph(GRAPH_TEST_VALUE); //Se llena el grafo
        //System.out.println(grafo.arcsCount(grafo.firstVertex));// cantidad de arcos que tiene el primer vertice  

        // Recorrido por profundidad (recursivo)
        System.out.println("Recorrido por profundidad");
        start = System.currentTimeMillis();
        grafo.depthRun();
        finish = System.currentTimeMillis();
        grafo.printVars(finish - start);

        // Recorrido por anchura (iterativo)
        System.out.println("Recorrido por anchura");
        start = System.currentTimeMillis();
        grafo.widthRun();
        finish = System.currentTimeMillis();
        grafo.printVars(finish - start);
    }

}
