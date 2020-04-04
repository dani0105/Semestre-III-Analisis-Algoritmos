/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import BinaryTree.BinaryTree;

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
        
        tree = new BinaryTree();
        tree.autoFill(1000);
        tree.profundity();
    }
    
}
