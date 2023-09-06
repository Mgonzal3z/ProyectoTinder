package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelAdministrador extends JPanel {
	private JButton bt_bdd, bt_informes, bt_eliminarPersona, bt_logOut;
	private Image background;
	
	
	public PanelAdministrador() {
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
		setBorder(new TitledBorder("Administrador"));
		
		//BOTONES
		bt_bdd = new JButton("Base de datos");
		bt_bdd.setActionCommand("BDD");
		bt_bdd.setBounds(290, 100, 200, 30);
		bt_bdd.setVisible(true);
		add(bt_bdd);
		
		bt_informes = new JButton("Informes");
		bt_informes.setActionCommand("INFORMES");
		bt_informes.setBounds(290, 150, 200, 30);
		bt_informes.setVisible(true);
		add(bt_informes);
		
		bt_eliminarPersona = new JButton("Eliminar persona");
		bt_eliminarPersona.setActionCommand("ELIMINAR");
		bt_eliminarPersona.setBounds(290, 200, 200, 30);
		bt_eliminarPersona.setVisible(true);
		add(bt_eliminarPersona);
		
		bt_logOut = new JButton("LogOut");
		bt_logOut.setActionCommand("LOGOUT_ADMIN");
		bt_logOut.setBounds(290, 400, 200, 30);
		bt_logOut.setVisible(true);
		add(bt_logOut);
		
		
	}

	public JButton getBt_bdd() {
		return bt_bdd;
	}

	public void setBt_bdd(JButton bt_bdd) {
		this.bt_bdd = bt_bdd;
	}

	public JButton getBt_informes() {
		return bt_informes;
	}

	public void setBt_informes(JButton bt_informes) {
		this.bt_informes = bt_informes;
	}

	public JButton getBt_eliminarPersona() {
		return bt_eliminarPersona;
	}

	public void setBt_eliminarPersona(JButton bt_eliminarPersona) {
		this.bt_eliminarPersona = bt_eliminarPersona;
	}

	public JButton getBt_logOut() {
		return bt_logOut;
	}

	public void setBt_logOut(JButton bt_logOut) {
		this.bt_logOut = bt_logOut;
	}
	
}
