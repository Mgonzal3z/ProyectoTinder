package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PanelTop10 extends JPanel{
	
	private JTable tabla;
	private String[] columnas = {"Id","Nombre","P. Apellido","S. Apellido","Genero","Alias","Clave",
			"Correo","F. Nacimiento","Edad","Divorcio","No. Likes Recibidos", "no. Likes Dados", 
			"Matches", "Estado", "Estatura"};
	private DefaultTableModel tableModel;
	private TableRowSorter<DefaultTableModel> sorter;
	private Image background;

private JButton bt_regresar_ptop;
	
	public PanelTop10() {
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
		setBorder(new TitledBorder("Top 10"));
		
		//BOTONES
		bt_regresar_ptop = new JButton("Regresar");
		bt_regresar_ptop.setActionCommand("REGRESARPTOP");
		bt_regresar_ptop.setBounds(15, 500, 200, 30);
		bt_regresar_ptop.setVisible(true);
		add(bt_regresar_ptop);
		
	}

	public JButton getBt_regresar_ptop() {
		return bt_regresar_ptop;
	}

	public void setBt_regresar_ptop(JButton bt_regresar_ptop) {
		this.bt_regresar_ptop = bt_regresar_ptop;
	}
	
}
