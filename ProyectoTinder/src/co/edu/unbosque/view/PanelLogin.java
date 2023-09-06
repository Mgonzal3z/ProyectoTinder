package co.edu.unbosque.view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelLogin extends JPanel {
	private JLabel lb_usuario, lb_contrasena;
	private JTextField tf_usuario, tf_contrasena;
	private JButton bt_login, bt_registrarme;
	private Image background;
	
	public PanelLogin() {
		setLayout(null);
		iniciar();
		setVisible(false);
		setBackground(new ImageIcon(getClass().getResource("/Imagen/bosTinder.jpg")).getImage());
	}
	public void paintComponent(Graphics g) {

		int width = 784;
		int height = 560;

		if (this.background != null) {
			g.drawImage(this.background, 0, 0, width, height, null);
		}

		super.paintComponent(g);
	}

	public void setBackground(Image image) {

		this.setOpaque(false);
		this.background = new ImageIcon(image).getImage();
		repaint();
	}

	private void iniciar() {
		setBackground(Color.white);
		setBorder(new TitledBorder("Log-In"));
		
		//CAMPOS DE TEXTO Y LABEL
		lb_usuario = new JLabel("Usuario: ");
		lb_usuario.setBounds(210, 200, 200, 30);
		add(lb_usuario);
		tf_usuario = new JTextField();
		tf_usuario.setBounds(290, 200, 200, 30);
		add(tf_usuario);
		
		lb_contrasena = new JLabel("Contraseña: ");
		lb_contrasena.setBounds(210, 250, 200, 30);
		add(lb_contrasena);
		tf_contrasena = new JTextField();
		tf_contrasena.setBounds(290, 250, 200, 30);
		add(tf_contrasena);
		
		//BOTONES
		bt_login = new JButton("Ingresar");
		bt_login.setActionCommand("LOGIN");
		bt_login.setBounds(290, 400, 200, 30);
		bt_login.setVisible(true);
		add(bt_login);
		
		bt_registrarme = new JButton("Registrarme");
		bt_registrarme.setActionCommand("REGISTRARME");
		bt_registrarme.setBounds(290, 450, 200, 30);
		bt_registrarme.setVisible(true);
		add(bt_registrarme);
		
	}

	public JTextField getTf_usuario() {
		return tf_usuario;
	}

	public void setTf_usuario(JTextField tf_usuario) {
		this.tf_usuario = tf_usuario;
	}

	public JTextField getTf_contrasena() {
		return tf_contrasena;
	}

	public void setTf_contrasena(JTextField tf_contrasena) {
		this.tf_contrasena = tf_contrasena;
	}

	public JButton getBt_login() {
		return bt_login;
	}

	public void setBt_login(JButton bt_login) {
		this.bt_login = bt_login;
	}

	public JButton getBt_registrarme() {
		return bt_registrarme;
	}

	public void setBt_registrarme(JButton bt_registrarme) {
		this.bt_registrarme = bt_registrarme;
	}
	
}
