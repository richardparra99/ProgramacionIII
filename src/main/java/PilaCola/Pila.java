package PilaCola;

public class Pila<T> {
    private Nodo<T> cima;

    public void apilar(T valor){
        Nodo<T> ultimo = new Nodo<>(valor);
        ultimo.setSiguiente(cima);
        cima = ultimo;
    }

    public T tomarElemto(){
        T ultimo = null;
        if (cima == null){
            System.out.println("la pila esta vacia");
        } else {
            ultimo = cima.getValor();
            cima = cima.getSiguiente();
        }
        return ultimo;
    }

    public T verCima(){
        T ultimo = null;
        if (cima == null){
            System.out.println("la pila esta vacia");
        } else {
            ultimo = cima.getValor();
        }
        return ultimo;
    }
}
