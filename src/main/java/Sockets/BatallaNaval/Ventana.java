package Sockets.BatallaNaval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {
    private JLabel lbNombre = new JLabel("Nombre: ");
    private JTextField txtNombre = new JTextField();
    private JButton btnInicio = new JButton("Iniciar");
    private JButton[][] btnTabla = new JButton[10][10];

    public Ventana(){
        this.setSize(500, 500);
        this.setTitle("BATALLA NAVAL");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void iniciarComponentes(){
        //setLayout(new GridLayout(10, 10)); // Establecer GridLayout
        setLayout(null);
        lbNombre.setBounds(137,280,100,20);
        txtNombre.setBounds(135,310,200,20);
        btnInicio.setBounds(185, 350, 100, 30);

        this.add(lbNombre);
        this.add(txtNombre);
        this.add(btnInicio);
        btnInicio.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInicio){
            for (int indice = 0; indice < 9; indice++) {
                for (int aux = 0; aux < 9; aux++) {
                    JButton btn1 = new JButton();
                    this.add(btn1);
                    btn1.addActionListener(this);
                    btnTabla[indice][aux] = btn1;
                }
            }
            revalidate();
        }
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
}
