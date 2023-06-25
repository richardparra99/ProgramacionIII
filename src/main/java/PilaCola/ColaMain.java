package PilaCola;

public class ColaMain {
    public static void main(String[] args) {
        //System.out.println("investigar una cola y una cola prioridad");

        Cola<String> cola = new Cola<>();
        cola.encolar("hola");
        cola.encolar("como");
        cola.encolar("estas");
        System.out.println(cola.verPrimero());
    }
}
