package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelUsuario extends JPanel {
	private JButton bt_perfil, bt_encontrarPareja, bt_logOut;
	private Image background;

	public PanelUsuario() {
		setLayout(null);
		iniciar();
		setVisible(false);
		setBackground(new ImageIcon(getClass().getResource("/Imagen/bg.jpg")).getImage());
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
		setBorder(new TitledBorder("Usuario"));
		
		//BOTONES
		bt_perfil = new JButton("Perfil");
		bt_perfil.setActionCommand("PERFIL");
		bt_perfil.setBounds(290, 100, 200, 30);
		bt_perfil.setVisible(true);
		add(bt_perfil);
		
		bt_encontrarPareja = new JButton("Encontrar Pareja");
		bt_encontrarPareja.setActionCommand("ENCONTRAR");
		bt_encontrarPareja.setBounds(290, 150, 200, 30);
		bt_encontrarPareja.setVisible(true);
		add(bt_encontrarPareja);
		
		bt_logOut = new JButton("LogOut");
		bt_logOut.setActionCommand("LOGOUT_USU");
		bt_logOut.setBounds(290, 400, 200, 30);
		bt_logOut.setVisible(true);
		add(bt_logOut);
	}

	public JButton getBt_perfil() {
		return bt_perfil;
	}

	public void setBt_perfil(JButton bt_perfil) {
		this.bt_perfil = bt_perfil;
	}

	public JButton getBt_encontrarPareja() {
		return bt_encontrarPareja;
	}

	public void setBt_encontrarPareja(JButton bt_encontrarPareja) {
		this.bt_encontrarPareja = bt_encontrarPareja;
	}

	public JButton getBt_logOut() {
		return bt_logOut;
	}

	public void setBt_logOut(JButton bt_logOut) {
		this.bt_logOut = bt_logOut;
	}
	
}
