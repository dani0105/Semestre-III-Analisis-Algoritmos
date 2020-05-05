package Graph;

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
