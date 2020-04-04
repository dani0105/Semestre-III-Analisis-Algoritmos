
package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  Clase que se encarga de insertar, eliminar y mostrar el arbol binario. 
 * @author Daniel
 */
public class BinaryTree {

    private Node root;
    
    /**
     * Agrega los nodos al arbol.
     * @param value Valor que se le va asignar al nodo.
     * @return TRUE si se inserto correctamente o FALSE si no es así.
     */
    public boolean add(int value){
        Node nodo = new Node(value);
        if(this.root == null){
            this.root = nodo;
            return true;
        }
       
        Node aux = this.root;
        while(true){
            int id = aux.getId();
            
            if(id > value){
                if(aux.getLeft() == null){
                    aux.setLeft(nodo);
                    return true;
                }
                aux = aux.getLeft();
                continue;
            }
            
            if(id < value){
                if(aux.getRight()== null){
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
     * imprime en profundidad el arbol
     */
    public void level (){
        if(this.root == null)
            return;
        
        List<Node> queue = new ArrayList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {   
            Node nodo = queue.remove(0);
            System.out.println("Nodo de ID:"+nodo.getId());
            
            if(nodo.getLeft() != null)
                queue.add(nodo.getLeft());
            if(nodo.getRight()!= null)
                queue.add(nodo.getRight());
        }
    }
    
    /**
     * Este metodo es recursivo. Esta echo en EnOrden.
     * @param aux El siguiente Nodo que se desea imprimir
     * @return null si llega al fondo o si el parametro que se paso es null.
     */
    public Node profundity(Node aux){
        if(aux == null)
            return null;
        System.out.println("Id:"+aux.getId());
        this.profundity(aux.getLeft());
        this.profundity(aux.getRight());
        return null;
    }
    
    /**
     * Este metodo incia la recursividad
     * @return Null si llega al final o la raiz es null
     */
    public Node profundity(){
        if(this.root == null)
            return null;
        
        System.out.println("Id:"+this.root.getId()+" Right->"+this.root.getRight().getId());
        this.profundity(this.root.getLeft());
        this.profundity(this.root.getRight());
        return null;
    }
    
    /**
     * Llena el arbol binario automaticamente dependiendo de la cantidad de elementos.
     * @param total El numero total de elemento que va tener el arbol.
    */
    public void autoFill(int total){
        // Metemos en una lista los números del 1 al total.
        List<Integer> numbers = new ArrayList<>(total);
        for (int i=1;i<total+1;i++){
           numbers.add(i);
        }
        
        Random random = new Random();

        while (numbers.size()>1){
            // Elegimos un índice al azar, entre 0 y el número de cartas que quedan por sacar
            int randomIndex = random.nextInt(numbers.size());

            this.add(numbers.get(randomIndex));

            // Y eliminamos la carta del mazo (la borramos de la lista)
            numbers.remove(randomIndex);
         }
    }
    
    
        
    
    
    
    
}
