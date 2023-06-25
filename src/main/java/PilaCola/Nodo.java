package PilaCola;

public class Nodo<T> {
    private T valor;
    private Nodo<T> siguiente;

    public Nodo(T dato){
        this.valor = dato;
    }

    public T getValor() {
        return valor;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}

