package Patrones;

import java.util.ArrayList;
import java.util.List;

public class Pro3Informa implements Observable{
    public List<Observer> observadores;

    private String notificacion;

    public Pro3Informa(){
        this.observadores = new ArrayList<>();
    }

    public void notificar(String mensaje){
        this.notificacion = mensaje;
        this.notificarObservadores();
    }

    @Override
    public void suscribir(Observer observer) {
        // agregamos al observador a la lista de los observadores
        this.observadores.add(observer);
    }

    @Override
    public void desuscribir(Observer observer) {
        // removemos al observador de la lista
        this.observadores.remove(observer);
    }

    @Override
    public void notificarObservadores() {
        for (Observer observer : this.observadores){
            observer.actualizar(this.notificacion);
        }
    }
}
