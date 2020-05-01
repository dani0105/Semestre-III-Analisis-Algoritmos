/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import BinaryTree.BinaryTree;
import Graph.Arco;
import Graph.Graph;

/**
 *
 * @author Daniel
 */
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
        System.out.println("Ejecutando aalgoritmos");
        
        
        
        long start = System.currentTimeMillis();
        tree.level();
        long finish = System.currentTimeMillis();
        
        tree.printVars( finish - start);
        
        
        start = System.currentTimeMillis();
        tree.profundity(tree.getRoot());
        finish = System.currentTimeMillis();
        
        tree.printVars( finish - start );
        
        
        System.out.println("Grafos");
        grafo = new Graph();
        grafo.CrearGrafo(1000);
        grafo.hayRuta(grafo.grafo, grafo.Gfinal); // recursivo
        System.out.println("Asignaciones "+ grafo.asignaciones+ " " + "Comparacines "+ grafo.comparaciones);
        grafo.asignaciones = 0;
        grafo.comparaciones = 0;
        grafo.limpiar(); // limpia las marcas
        grafo.anchura(); // iterativo
        System.out.println("Asignaciones "+ grafo.asignaciones + " " + "Comparacines "+ grafo.comparaciones);
    }
    
}
