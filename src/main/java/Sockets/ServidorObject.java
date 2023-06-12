package Sockets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorObject {
    private ServerSocket servidor;
    private static final Logger logger = LogManager.getLogger(ServidorObject.class);
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;
    private boolean escucharMensajes = true;
    public ServidorObject(){

        this.encenderServidor();
    }
    private void encenderServidor(){
        try {
            servidor = new ServerSocket(8012);
            logger.info("servidor encendido");
            while(this.escucharMensajes){
                socket = servidor.accept();
                logger.info("Cliente conectado");
                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                salida = new PrintWriter(socket.getOutputStream(),true);
                this.gestionarMensajes();
            }
        }catch (IOException error){
            error.printStackTrace();
        }
    }

    private void gestionarMensajes() throws IOException {
//hacer un ajuste en este metodo
//tablero.disparar
        String mensaje = this.entrada.readLine(); //RECIBE MENSAJE
        logger.info("Mensaje recibido: " + mensaje);
        this.salida.println("Respuesta Servidor: Mensaje recibido");//CONFIRMA MENSAJE
        int cliente=0;
//switch que reciba un entero
        switch (cliente){
            case 1:
                salida.println("1:");
                break;
            case 2:
                salida.print("2: "+ mensaje);
        }
    }

    public void apagarServidor(){
//este tiene que enviar mensaje
        try {
            this.entrada.close();
            this.salida.close();
            this.socket.close();
            this.servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}