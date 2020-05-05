package Main;

import BinaryTree.BinaryTree;
import Graph.Graph;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree tree;
        Graph grafo;

        tree = new BinaryTree();
        System.out.println("Llenando arbol");
        tree.autoFill(100000);
        System.out.println("Ejecutando algoritmos");

        long start = System.currentTimeMillis();
        tree.level();
        long finish = System.currentTimeMillis();

        tree.printVars(finish - start);

        start = System.currentTimeMillis();
        tree.profundity(tree.getRoot());
        finish = System.currentTimeMillis();

        tree.printVars(finish - start);

        System.out.println("Grafos");
        grafo = new Graph();
        grafo.createGraph(1000);
        grafo.searchRoute(grafo.firstVertex, grafo.finalG); // recursivo
        System.out.println("Asignaciones " + grafo.assignments + " " + "Comparacines " + grafo.comparisons);
        grafo.assignments = 0;
        grafo.comparisons = 0;
        grafo.clearMarks(); // limpia las marcas
        grafo.anchura(); // iterativo
        System.out.println("Asignaciones " + grafo.assignments + " " + "Comparacines " + grafo.comparisons);
    }

}
