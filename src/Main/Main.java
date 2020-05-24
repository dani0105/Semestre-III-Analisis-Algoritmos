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

        // Ejecucion de los arboles
        tree = new BinaryTree();
        tree.autoFill(100000); // se llena el arbol

        long start = System.currentTimeMillis();
        tree.level();
        long finish = System.currentTimeMillis();
        tree.printVars(finish - start);

        
        start = System.currentTimeMillis();
        tree.profundity(tree.getRoot());
        finish = System.currentTimeMillis();
        tree.printVars(finish - start);
        
        // Ejecucion de los grafos
        System.out.println("Grafos");
        grafo = new Graph();
        grafo.createGraph(1000); //Se llena el grafo
        System.out.println(grafo.arcsCount(grafo.firstVertex));// cantidad de arcos que tiene el primer vertice  
        
        // Recursivo
        start = System.currentTimeMillis();
        grafo.searchRoute(grafo.firstVertex, grafo.finalG); 
        finish = System.currentTimeMillis();
        grafo.printVars(finish - start);
        
        grafo.assignments = 0;
        grafo.comparisons = 0;
        
        grafo.clearMarks(); // limpia las marcas
        
        // Iterativo
        start = System.currentTimeMillis();
        grafo.widthPath();
        finish = System.currentTimeMillis();
        grafo.printVars(finish - start);
    }

}
