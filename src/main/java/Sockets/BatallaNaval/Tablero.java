package Sockets.BatallaNaval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class Tablero extends JFrame{

    private int intentos = 0;
    private int contador = 0;

    String iD;
    DataInputStream din; //l
    DataOutputStream dout; //e

    boolean bandera = false;
    private JButton[][] btnTabla = new JButton[10][10];

    private int[][] ubicacionBarco = new int[10][10];

    private ArrayList<Point> localizacion = new ArrayList<>();

    int cantidadBarco;
    public Tablero(String idJugador, Socket socket) {
        iD = idJugador;
        cantidadBarco = 0;
        setTitle("Batalla Naval Jugador " + iD);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());
            new Read().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //setLocationRelativeTo(null);
        setLayout(null);
        // initComponents();
        cargarListeners();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void cargarListeners() {

        for (int filas = 0; filas < 10; filas++) {
            for (int columnas = 0; columnas < 10; columnas++) {
                JButton btn1 = crearBotonMatriz(filas, columnas);
                btnTabla[filas][columnas] = btn1;
                ubicacionBarco[filas][columnas] = 0;

            }
        }
        while (cantidadBarco<3) {
            int x = random();
            int y = random();
            if(ubicacionBarco[x][y] == 0) {
                ubicacionBarco[x][y] = 1;
                btnTabla[x][y].setText("O");
                cantidadBarco++;
                localizacion.add(new Point(x,y));
            }
        }
        repaint(); // Actualiza la interfaz gráfica
    }
    public int random() {
        return (int) (Math.random()*9);
    }
    private JButton crearBotonMatriz(int indice, int aux) {
        JButton btn = new JButton();
        // Configura el tamaño y posición del botón en función de los índices
        btn.setBounds(25 + aux * 45, 25 + indice * 45, 45, 45);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!bandera) {
                    JOptionPane.showMessageDialog(Tablero.this, "esperando  jugador");
                    return;
                }
                JButton btn1 = (JButton) e.getSource();
                if(localizacion.size() == 0) JOptionPane.showMessageDialog(Tablero.this, "¡Has perdido el juego!");
                // Verificar el texto actual del botón
                if (btn1.getText().isEmpty()||btn1.getText().equals("O")) {
                    // Asignar "X" o "O" de forma aleatoria
                    if(!btn1.getText().equals("O")) {
                        btn1.setText("X");
                    }
                    contador++;
                    intentos++;
                    try {
                        dout.writeUTF("movimiento: x=" + indice + "-y="+aux);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        this.add(btn);
        return btn;
    }


    public class Read extends Thread {
        public void run() {
            while (true) {
                try {
                    String m = din.readUTF();
                    if (m.contains(":;.,/=")) {
                        m = m.substring(6);
                        // dlm.clear();
                        StringTokenizer st = new StringTokenizer(m, ",");
                        String[] jugadores = m.split(",");
                        if(jugadores.length > 1) {
                            bandera = true;
                        }
                        while (st.hasMoreTokens()) {
                            String u = st.nextToken();
                            if (!iD.equals(u)) {

                                System.out.println(u);
                                // dlm.addElement(u);
                            }
                        }
                    } else {
                        if(m.contains("ganador")) {
                            JOptionPane.showMessageDialog(Tablero.this, "¡Has Ganado el juego!");
                            return;
                        }

                        // txt_mensajes.append("" + m + "\n");
                        String[] info = m.split(",");
                        String nombreJugador = info[0].split(" ")[1];

                        String movimientos = info[1].split(" ")[1];
                        String[] movimiento = movimientos.split("-");
                        int x = Integer.parseInt(movimiento[0].substring(2));
                        int y = Integer.parseInt(movimiento[1].substring(2));

                        if(ubicacionBarco[x][y] != 0) {
                            for (int i = 0; i < localizacion.size(); i++) {
                                Point punto = localizacion.get(i);
                                if(x == punto.x && y == punto.y ) {
                                    localizacion.remove(i);
                                    break;
                                }
                            }

                            ubicacionBarco[x][y] = 0;
                            btnTabla[x][y].setText(btnTabla[x][y].getText()+"X");
                        }
                        if(localizacion.size() == 0) {
                            JOptionPane.showMessageDialog(Tablero.this, "¡Has perdido el juego!");
                            dout.writeUTF("ganador");
                        }

                    }
                } catch (Exception e) {
                    break;
                }
            }

        }
    }
}

