package PilaCola;

public class Cola<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;

    public void encolar(T dato) {
        Nodo<T> entrante = new Nodo<>(dato);
        if (primero == null) {
            primero = entrante;
            ultimo = entrante;
        } else {
            ultimo.setSiguiente(entrante);
            ultimo = entrante;
        }
    }

    public T tomarElemento() {
        T valor = null;
        if (primero == null) {
            System.out.println("la cola esta vacia");
        } else {
            valor = primero.getValor();
            primero = primero.getSiguiente();
        }
        return valor;
    }

    public T verPrimero() {
        T valor = null;
        if (primero == null) {
            System.out.println("la cola esta vacia");
        } else {
            valor = primero.getValor();
        }
        return valor;
    }

    public T colaVacio() {
        //return valor == null;
    }
}
