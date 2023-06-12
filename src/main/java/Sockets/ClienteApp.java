package Sockets;
public class ClienteApp {
    public static void main(String[] args) {
        ClienteObject cliente = new ClienteObject("192.168.100.16",8080);
        cliente.enviarMensaje("Jugada 1: A,5");
        cliente.enviarMensaje("Jugada 2: C,1");
//
//cliente.desconectarServidor();
    }
}