package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class PanelEncontrarPareja extends JPanel{
	private JButton bt_regresar_pe, bt_like_pe, bt_next_pe;
	private JTextArea ta_infopareja;
	private int idSoltero;
	private Image background;
	
	public PanelEncontrarPareja() {
		setLayout(null);
		iniciar();
		setVisible(false);
		idSoltero=0;
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
		setBorder(new TitledBorder("Encontrar Pareja"));
		
		//AREA DE TEXTO
		
		ta_infopareja=new JTextArea();
		ta_infopareja.setBorder(new TitledBorder("Info"));
		ta_infopareja.setBounds(10,50,400,300);
        add(ta_infopareja);
		
		//BOTONES
		bt_regresar_pe = new JButton("Regresar");
		bt_regresar_pe.setActionCommand("REGRESARPENCON");
		bt_regresar_pe.setBounds(290, 450, 200, 30);
		bt_regresar_pe.setVisible(true);
		add(bt_regresar_pe);
		
		bt_like_pe = new JButton("Like! ;)");
		bt_like_pe.setActionCommand("LIKEPE");
		bt_like_pe.setBounds(191, 400, 200, 30);
		bt_like_pe.setVisible(true);
		add(bt_like_pe);
		
		bt_next_pe = new JButton("Next :(");
		bt_next_pe.setActionCommand("NEXTPE");
		bt_next_pe.setBounds(392, 400, 200, 30);
		bt_next_pe.setVisible(true);
		add(bt_next_pe);
		
		
	}

	public int getIdSoltero() {
		return idSoltero;
	}

	public void setIdSoltero(int idSoltero) {
		this.idSoltero = idSoltero;
	}

	public JButton getBt_regresar_pe() {
		return bt_regresar_pe;
	}

	public void setBt_regresar_pe(JButton bt_regresar_pe) {
		this.bt_regresar_pe = bt_regresar_pe;
	}

	public JTextArea getTa_infopareja() {
		return ta_infopareja;
	}

	public void setTa_infopareja(JTextArea ta_infopareja) {
		this.ta_infopareja = ta_infopareja;
	}

	public JButton getBt_like_pe() {
		return bt_like_pe;
	}

	public void setBt_like_pe(JButton bt_like_pe) {
		this.bt_like_pe = bt_like_pe;
	}

	public JButton getBt_next_pe() {
		return bt_next_pe;
	}

	public void setBt_next_pe(JButton bt_next_pe) {
		this.bt_next_pe = bt_next_pe;
	}
	
	
}
