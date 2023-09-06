package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartPanel;

import co.edu.unbosque.mundo.BosTinder;

public class PanelInformes extends JPanel{
	private JButton bt_regresar_pi, bt_exportar;
	private JLabel lb_media, lb_mediana, lb_moda;
	private JTextField tf_media, tf_mediana, tf_moda;
	private BosTinder mundo;
	private Image background;
	
	public PanelInformes() {
		setLayout(null);
		iniciar();
		setVisible(false);
		setBackground(new ImageIcon(getClass().getResource("/Imagen/bg.jpg")).getImage());
		
		try {
			mundo= new BosTinder();
			ChartPanel pan;
			try {
				pan = new ChartPanel(mundo.graficas());
				pan.setBounds(100, 50, 500, 300);
				pan.setVisible(true);
				add(pan);
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
		
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
		setBorder(new TitledBorder("Informes"));
		
		//BOTONES
		bt_regresar_pi = new JButton("Regresar");
		bt_regresar_pi.setActionCommand("REGRESARPPI");
		bt_regresar_pi.setBounds(160, 400, 200, 30);
		bt_regresar_pi.setVisible(true);
		add(bt_regresar_pi);
		
		bt_exportar = new JButton("Exportar PDF");
		bt_exportar.setActionCommand("EXPORTAR");
		bt_exportar.setBounds(380, 400, 200, 30);
		bt_exportar.setVisible(true);
		add(bt_exportar);
		
		lb_media = new JLabel("Media:");
		lb_media.setBounds(600, 80, 100, 30);
		add(lb_media);
		tf_media = new JTextField();
		tf_media.setBounds(600, 110, 100, 30);
		tf_media.setEditable(false);
		add(tf_media);
		
		lb_mediana = new JLabel("Mediana:");
		lb_mediana.setBounds(600, 140, 100, 30);
		add(lb_mediana);
		tf_mediana = new JTextField();
		tf_mediana.setBounds(600, 170, 100, 30);
		tf_mediana.setEditable(false);
		add(tf_mediana);
		
		lb_moda = new JLabel("Moda:");
		lb_moda.setBounds(600, 200, 100, 30);
		add(lb_moda);
		tf_moda = new JTextField();
		tf_moda.setBounds(600, 230, 100, 30);
		tf_moda.setEditable(false);
		add(tf_moda);
		
	}
	
	

	public JButton getBt_exportar() {
		return bt_exportar;
	}


	public void setBt_exportar(JButton bt_exportar) {
		this.bt_exportar = bt_exportar;
	}


	public JButton getBt_regresar_pi() {
		return bt_regresar_pi;
	}

	public void setBt_regresar_pi(JButton bt_regresar_pi) {
		this.bt_regresar_pi = bt_regresar_pi;
	}


	public JLabel getLb_media() {
		return lb_media;
	}


	public void setLb_media(JLabel lb_media) {
		this.lb_media = lb_media;
	}


	public JLabel getLb_mediana() {
		return lb_mediana;
	}


	public void setLb_mediana(JLabel lb_mediana) {
		this.lb_mediana = lb_mediana;
	}


	public JLabel getLb_moda() {
		return lb_moda;
	}


	public void setLb_moda(JLabel lb_moda) {
		this.lb_moda = lb_moda;
	}


	public JTextField getTf_media() {
		return tf_media;
	}


	public void setTf_media(JTextField tf_media) {
		this.tf_media = tf_media;
	}


	public JTextField getTf_mediana() {
		return tf_mediana;
	}


	public void setTf_mediana(JTextField tf_mediana) {
		this.tf_mediana = tf_mediana;
	}


	public JTextField getTf_moda() {
		return tf_moda;
	}


	public void setTf_moda(JTextField tf_moda) {
		this.tf_moda = tf_moda;
	}
	
	

}
