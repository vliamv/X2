/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Bugatti
 */
public class Registro extends Ventana{
    
    private PanelRegistro reg;
    private Control cont;
    
    public Registro(){
        
        setSize(600, 400);
        reg = new PanelRegistro(600, 400);
        add(reg);
        
    }
    public class PanelRegistro extends JPanel implements ActionListener{
        
        private Font font;
        private ImageIcon imagelap;
        private JLabel nombre, grupo, contra, confir;
        private JButton registrarse;
        private JTextField grupoTx, nombreTx;
        private JPasswordField contra2PW, contra1PW;
        private Usuario user;
        Archivo archivos;
        protected Control cont;
        protected ListaUsuario lista;
        
        public PanelRegistro(int ancho, int alto){
            
            //ListaUsuario lista  =new ListaUsuario();
            
            font = new Font("Verdana", Font.BOLD, 16);
            
            setVisible(true);
            setLayout(null);
            setLocation(0,0);
            setSize(ancho, alto);
            setResizable(false);
            
            grupoTx = new JTextField();
            grupoTx.setBounds(370, 107, 150, 20);
            grupoTx.setVisible(true);
            add(grupoTx);
            
            //lista.setClave(grupoTx.getText());
            
            nombreTx = new JTextField();
            nombreTx.setBounds(370, 57, 150, 20);
            nombreTx.setVisible(true);
            nombreTx.addActionListener(this);
            add(nombreTx);
            
            //lista.setNombre(nombreTx.getText());
            
            contra2PW = new JPasswordField();
            contra2PW.setBounds(370, 207, 150, 20);
            contra2PW.setEnabled(true);
            contra2PW.addActionListener(this);
            add(contra2PW);
            
            contra1PW = new JPasswordField();
            contra1PW.setBounds(370, 157, 150, 20);
            contra1PW.setEnabled(true);
            contra1PW.addActionListener(this);
            add(contra1PW);
            
            registrarse = new JButton("Registrarse!");
            registrarse.setBounds(240, 250, 120, 30);
            registrarse.addActionListener(this);
            registrarse.setVisible(true);
            add(registrarse);
            
            nombre = new JLabel();
            nombre.setText("Nombre:");
            nombre.setLocation(100, 50);
            nombre.setSize(100,20);
            nombre.setForeground(Color.black);
            nombre.setFont(font);
            add(nombre);
            
            grupo = new JLabel();
            grupo.setText("Grupo:");
            grupo.setLocation(100, 100);
            grupo.setSize(100, 20);
            grupo.setForeground(Color.black);
            grupo.setFont(font);
            add(grupo);
            
            contra = new JLabel();
            contra.setText("Contraseña:");
            contra.setLocation(100, 150);
            contra.setSize(176, 20);
            contra.setForeground(Color.black);
            contra.setFont(font);
            add(contra);
            
            confir = new JLabel();
            confir.setText("Confirmacion de \nContraseña:");
            confir.setLocation(100, 200);
            confir.setSize(432, 32);
            confir.setForeground(Color.black);
            confir.setFont(font);
            add(confir);
            
        }
        /*public void Validar(){
            
            if(contra2PW.getText().equals(contra1PW.getText())){
                
                lista.setGrupo(grupoTx.getText());
                lista.setNombre(nombreTx.getText());
                lista.setClave(contra2PW.getText());
                dispose();
                
            }else
                JOptionPane.showMessageDialog(null, "Las contraseñas deben coincidir");
        }*/
        public void paint(Graphics g){
           
            Dimension tam = getSize();
            imagelap = new ImageIcon(getClass().getResource("escuela.jpg"));           
            
            g.drawImage(imagelap.getImage(), 0, 0, tam.width, tam.height, null);
            setOpaque(false);
       
            super.paint(g);
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Registrarse!")) {
                if(contra1PW.getText().equals(contra2PW.getText())) {
                    user = new Usuario(nombreTx.getText(), contra1PW.getText(), grupo.getText());
                    Control.Usuarios.add(user);
                    archivos = new Archivo();
                    archivos.Serializar(Control.Usuarios);
                    dispose();
                
            }
                else
                    JOptionPane.showMessageDialog(null, "Contraseñas diferentes");
        }
    }
    }
    
}

