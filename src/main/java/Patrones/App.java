package Patrones;

public class App {
    public static void main(String[] args) {
        // creamos un publisher
        Pro3Informa informador = new Pro3Informa();

        // creamos unos suscriptores
        Suscriptor juanito = new Suscriptor("Juan Perez");
        Suscriptor pepe = new Suscriptor("Pepe Peña");
        Suscriptor maria = new Suscriptor("Maria Fuentes");

        // agregamos a los suscriptores
        informador.suscribir(juanito);
        informador.suscribir(pepe);
        informador.suscribir(maria);

        // mandamos un mensaje
        informador.notificar("bienvenido al grupo");
    }
}
