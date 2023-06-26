package Sockets.BatallaNaval;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Servidor extends JFrame {
    private JLabel chat = new JLabel();
    private JLabel participantes = new JLabel();
    private JTextArea jPanelChat = new JTextArea();
    private JTextArea jPanelParticipa = new JTextArea();

    int port = 0;
    ServerSocket servidor;
    HashMap clienteColl = new HashMap();

    public Servidor() {
        setTitle("Servidor");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(700, 250);
        setLayout(null);
        setSize(545, 520);
        init();
        try {
            servidor = new ServerSocket(2089);
            new ClientAccept().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() {
        jPanelParticipa.setBackground(new java.awt.Color(0, 0, 0));
        jPanelParticipa.setBounds(370, 50, 150, 400);
        jPanelParticipa.setEditable(false);
        jPanelParticipa.setForeground(Color.white);

        participantes.setFont(new java.awt.Font("Dialog", 0, 24));
        participantes.setText("Participante");
        participantes.setBounds(400, -20, 100, 100);

        jPanelChat.setBackground(new java.awt.Color(0, 0, 0));
        jPanelChat.setBounds(10, 50, 350, 400);
        jPanelChat.setEditable(false);
        jPanelChat.setForeground(Color.white);

        chat.setFont(new java.awt.Font("Dialog", 0, 24));
        chat.setText("Movimientos");
        chat.setBounds(170, -20, 100, 100);

        add(jPanelChat, null);
        add(jPanelParticipa, null);
        add(participantes, null);
        add(chat, null);

    }

    public class ClientAccept extends Thread {

        public void run() {
            while (true) {
                try {
                    Socket socket = servidor.accept();
                    String i = new DataInputStream(socket.getInputStream()).readUTF();
                    if (clienteColl.containsKey(i)) {
                        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                        dout.writeUTF("Ya estas registrado");

                    } else {
                        clienteColl.put(i, socket);
                        jPanelParticipa.append(i + " Se unio\n");
                        DataOutputStream dout = new DataOutputStream((socket.getOutputStream()));
                        dout.writeUTF("");
                        new MsgRead(socket, i).start();
                        new listaClientes().start();
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    class MsgRead extends Thread {
        Socket s;
        String ID;

        MsgRead(Socket s, String ID) {
            this.s = s;
            this.ID = ID;
        }

        public void run() {
            while (!clienteColl.isEmpty()) {
                try {
                    String i = new DataInputStream(s.getInputStream()).readUTF();
                    Set k = clienteColl.keySet();
                    Iterator itr = k.iterator();
                    while (itr.hasNext()) {
                        String key = (String) itr.next();
                        if (!key.equalsIgnoreCase(ID)) {
                            try {
                                new DataOutputStream(((Socket) clienteColl.get(key)).getOutputStream()).writeUTF("Jugador: "+ ID + ","+ i);
                            } catch (Exception e) {
                                // Manejo de errores al enviar mensajes a los clientes
                            }
                        }
                    }
                    jPanelChat.append("Jugador: "+ ID + ","+ i + "\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // Clase interna para preparar la lista de clientes conectados
    class listaClientes extends Thread {
        public void run() {
            try {
                String ids = "";
                Set k = clienteColl.keySet();
                Iterator itr = k.iterator();
                while (itr.hasNext()) {
                    String key = (String) itr.next();
                    ids += key + ",";
                }
                if (ids.length() != 0) {
                    ids = ids.substring(0, ids.length() - 1);
                }

                itr = k.iterator();

                while (itr.hasNext()) {
                    String key = (String) itr.next();
                    try {
                        new DataOutputStream(((Socket) clienteColl.get(key)).getOutputStream()).writeUTF(":;.,/=" + ids);
                    } catch (Exception e) {
                        clienteColl.remove(key);
                        jPanelParticipa.append(key + ":Salio" + "\n");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Servidor serv = new Servidor();
        serv.setVisible(true);
    }
}
