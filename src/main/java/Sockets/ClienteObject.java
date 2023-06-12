package Sockets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClienteObject {


    //private static final Logger logger = LogManager.getLogger(ClienteObject.class);
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;

    public ClienteObject(String servidor, int puerto) {
        this.conectarServidor(servidor,puerto);
    }

    public ClienteObject() {

    }

    public void conectarServidor(String servidor, int puerto){
        try {
            socket = new Socket(servidor,puerto);
//loggear informacion
//
            //logger.info("Conexion realizada");
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            salida = new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void recibirRespuestas() throws IOException {
        String respuesta = this.entrada.readLine();
//gestionarDisparo
        System.out.println(respuesta);

    }

    public void enviarMensaje(String mensaje){
        this.salida.println(mensaje);
    }
    public void desconectarServidor(){
        try {
            this.salida.close();
            this.salida.close();
            this.socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}