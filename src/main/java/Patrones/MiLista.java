package Patrones;

import java.util.ArrayList;
import java.util.List;

public class MiLista<T> implements Iterable<T>{
    //private List<T> lista;
    public List<T> lista;

    public MiLista(){
        this.lista = new ArrayList<T>();
    }

    public void agregar(T item){
        this.lista.add(item);
    }

    @Override
    public Iterator<T> getIterador() {
        return new MiIterador<>(this.lista);
    }
}
