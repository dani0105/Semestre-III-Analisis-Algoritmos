/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author pache
 */
public class Vertice {
    public Vertice sigV;
    Vertice antV;
    public int nombre;
    boolean marca;
    public Arco sigA;

    public Vertice(int nombre, boolean marca) {
        this.nombre = nombre;
        this.marca = false;
    }
}
