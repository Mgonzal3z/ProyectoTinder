package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelEliminarPersona extends JPanel{
	private JButton bt_regresar_pe, bt_eliminar_pe;
	private JTextField tf_idaeliminar_pe;
	private JLabel lb_id;
	private Image background;
	
	public PanelEliminarPersona() {
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
		setBorder(new TitledBorder("Eliminar persona"));
		
		//AREA DE TEXTO Y LABEL
		lb_id = new JLabel("Ingrese ID de la persona a eliminar: ");
		lb_id.setBounds(290, 125, 300, 30);
		add(lb_id);
		tf_idaeliminar_pe = new JTextField();
		tf_idaeliminar_pe.setBounds(290, 150, 200, 30);
		add(tf_idaeliminar_pe);
		
		
		//BOTONES
		bt_eliminar_pe = new JButton("Eliminar");
		bt_eliminar_pe.setActionCommand("ELIMINARPE");
		bt_eliminar_pe.setBounds(290, 350, 200, 30);
		bt_eliminar_pe.setVisible(true);
		add(bt_eliminar_pe);
		
		bt_regresar_pe = new JButton("Regresar");
		bt_regresar_pe.setActionCommand("REGRESARPE");
		bt_regresar_pe.setBounds(290, 400, 200, 30);
		bt_regresar_pe.setVisible(true);
		add(bt_regresar_pe);
		
	}

	public JButton getBt_regresar_pe() {
		return bt_regresar_pe;
	}

	public void setBt_regresar_pe(JButton bt_regresar_pe) {
		this.bt_regresar_pe = bt_regresar_pe;
	}

	public JButton getBt_eliminar_pe() {
		return bt_eliminar_pe;
	}

	public void setBt_eliminar_pe(JButton bt_eliminar_pe) {
		this.bt_eliminar_pe = bt_eliminar_pe;
	}

	public JTextField getTf_idaeliminar_pe() {
		return tf_idaeliminar_pe;
	}

	public void setTf_idaeliminar_pe(JTextField tf_idaeliminar_pe) {
		this.tf_idaeliminar_pe = tf_idaeliminar_pe;
	}

	

}
