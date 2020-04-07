/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.ArrayList;

/**
 *
 * @author pache
 */
public class Graph {
    //Algunas variables utilizadas
    public Vertice grafo;
    public Vertice Gfinal;
    boolean bandera;
    
    /**
     * inserta un vertice del grafo
     * @param nombre el nombre es el numero que se le asigna a cada vertice
     * @return Insertado si todo salio bien en caso contrario un strig sin nada
     */
    public String insertarVertices(int nombre){
        Vertice nuevo = new Vertice(nombre, false);
        if (grafo == null) {
            grafo = nuevo;
            Gfinal = nuevo;
            System.out.println("Insertado"+" "+nombre);
            return "Insertado";
        }
        nuevo.sigV = grafo;
        grafo.antV = nuevo;
        grafo = nuevo;
        System.out.println("Insertado"+" "+nombre);
        return "";
    }
    
    /**
     * Busca si existe un arco que conecte dos vertices
     * @param origen vertice de origen
     * @param destino vertice de destino
     * @return retorna el arco encontrado o null si no existe
     */
    public Arco buscar(Vertice origen, Vertice destino){
        if (origen.sigA != null) {
            Arco aux = origen.sigA;
            while (aux!=null) {
                if (aux.destino == destino) {
                    return aux;
                }
                aux= aux.sigA;
            }
        }
        return null;
    }
    
    /**
     * Busca un vertice
     * @param nombre el nombre del vertice a buscar
     * @return retorna el vertice encontrado o null si este no existe
     */
    public Vertice buscar(int nombre){
        Vertice aux = grafo;
        while (aux != null) {            
            if(aux.nombre == nombre)
                return aux;
            aux = aux.sigV;
        }
        return null;
    }
    
    /**
     *  Inserta un Arco de un vertice a otro
     * @param origen vertice de origen
     * @param destino vertice de destino
     * @return retorna insertado si todo salio bien o otro string en caso contratio
     */
    public String insertarArco(Vertice origen, Vertice destino){
        if (buscar(origen,destino)==null) {
            Arco nuevo = new Arco();
            nuevo.destino = destino;
            if (origen.sigA == null) {
                origen.sigA = nuevo;
            }else{
                nuevo.sigA= origen.sigA;
                origen.sigA.antA = nuevo;
                origen.sigA = nuevo;
            }
            return "Insertado";
        }
        return "No se pueden repetir arcos";
    }
    
    /**
     * Verificar cuantos arcos tiene cada vertice
     * @param inicio verrtice al que se le cuentan los arcos
     * @return la cantidad de arcos 
     */
    public int ContarArcos(Vertice inicio){
        int cantidad=0;
        Vertice vertice = buscar(inicio.nombre);
        if (vertice.sigA!=null){
            Arco aux = vertice.sigA;
            while (aux!=null){
                cantidad = cantidad+1;
                aux = aux.sigA;
        }
            return cantidad;
        }
      return 00;  
    }
    
    /**
     * Metodo que crea los vertices y hace las conexiones entre ellos para hacer un grafo conexo
     * @param cantidad cantidad de vertices a insertar
     * @return true si todo salio bien
     */
    public boolean CrearGrafo(int cantidad){  
        for(int i = 1; i<=cantidad; i++){
            insertarVertices(i);
        }
        Vertice aux = grafo;
        while(aux!= null){
            insertarArco(aux, aux.sigV);
            if(Gfinal == aux){
                insertarArco(aux, grafo);
            }
            aux = aux.sigV;
        }
        return true;
    }
    
    /**
     * Busca recursivamente una ruta de un vertice a otro, por o que si se pone el primero y el segundo pasa por todos los vertices creados
     * @param origen primer vertice de el grafo
     * @param destino ultimo vertice del grafo
     */
    public void hayRuta(Vertice origen,Vertice destino){ 
        if(origen == null || origen.marca == true){
            return;
        }
        origen.marca = true;
        System.out.println("Recursivo"+" "+origen.nombre);
        Arco arco = origen.sigA;
        while(arco !=null){
            if(arco.destino == destino){
                bandera = true;
            }
            hayRuta(arco.destino, destino);
            arco =arco.sigA;
        }
    }
    
    /**
     * verificar que el grafo es conexo
     * @return true si lo es o false si no lo es
     */
    public boolean grafoConexo(){
        Vertice aux= grafo;
        while(aux != null){
            Vertice aux2 = grafo;
            while(aux2 != null){
                bandera = false;
                if(aux2!=aux){
                    hayRuta(aux, aux2);
                    limpiar();
                    if(bandera!= true){
                        return false;
                    }
                }
                aux2 = aux2.sigV;
            }
            aux = aux.sigV;
        }
        return true;
    }
    
    /**
     * limpia las marcas de todos los vertices
     */
    public void limpiar(){
        Vertice aux = grafo;
        while(aux!=null){
            aux.marca=false;
            aux = aux.sigV;
        }
    }
    
    /**
     * recorre todos los nodos del grafo recursivamente
     */
    public void anchura(){
        ArrayList<Vertice> queue = new ArrayList<Vertice>();
        Gfinal.marca = true;
        queue.add(Gfinal);
        while(!queue.isEmpty()){
            Vertice aux = queue.remove(0);
            System.err.println("iterador"+" "+aux.nombre);
            if(aux.sigA.destino.marca != true){
                aux.sigA.destino.marca = true;
                queue.add(aux.sigA.destino);
            }
        }
    }

}
