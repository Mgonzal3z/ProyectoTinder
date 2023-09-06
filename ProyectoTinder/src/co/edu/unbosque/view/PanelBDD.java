package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class PanelBDD extends JPanel {

	private JTable tabla;
	private String[] columnas = {"Id","Nombre","P. Apellido","S. Apellido","Genero","Alias","Clave",
			"Correo","F. Nacimiento","Edad","Ingresos","Divorcio","Likes R", "Likes D", 
			"Matches", "Estado", "Estatura"};
	private DefaultTableModel tableModel;
	private TableRowSorter<DefaultTableModel> sorter;
	private JButton bt_regresar_pbdd;
	private JButton bt_filtrar;
	private String [] filtros = {"Seleccione", "Top 10 Likes", "Ingresos", "Genero"};
	private JComboBox<String> cb_tipo_filtro ;
	private JComboBox<String> cb_genero ;
	private Image background;

	public PanelBDD() {

		setVisible(false);
		setLayout(null);
		iniciar();
		setBackground(new ImageIcon(getClass().getResource("/Imagen/bg.jpg")).getImage());
		setBackground(Color.white);
		setBorder(new TitledBorder("Usuarios Inscritos"));
		tableModel = new DefaultTableModel(columnas, 0) {
			Class[] types = { Integer.class, String.class, String.class, String.class, String.class , String.class , String.class 
					, String.class , String.class , Integer.class , String.class , String.class , Integer.class , Integer.class 
					, Integer.class , String.class , Integer.class };
			public Class getColumnClass(int c) {
				return getValueAt(0, c).getClass();
			}
		};

		sorter= new TableRowSorter<DefaultTableModel>(tableModel);

		JTable tabla = new JTable(tableModel){
			public boolean isCellEditable(int datos, int columnas) {
				return false;
			}

			public Component prepareRenderer(TableCellRenderer r, int datos, int columnas) {
				Component c = super.prepareRenderer(r, datos, columnas);
				if (datos % 2 == 0)
					c.setBackground(Color.white);
				else
					c.setBackground(Color.LIGHT_GRAY);

				if (isCellSelected(datos, columnas))
					c.setBackground(new Color(159,213,209));
				return c;
			}
		};

		add(tabla.getTableHeader(), BorderLayout.PAGE_START);
		add(tabla, BorderLayout.CENTER);

		tabla.setPreferredScrollableViewportSize(new Dimension(1120, 340));
		tabla.setFillsViewportHeight(true);
		tabla.setAutoCreateRowSorter(true);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(60);
		tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(6).setPreferredWidth(60);
		tabla.getColumnModel().getColumn(7).setPreferredWidth(120);
		tabla.getColumnModel().getColumn(8).setPreferredWidth(60);
		tabla.getColumnModel().getColumn(9).setPreferredWidth(30);//edad
		tabla.getColumnModel().getColumn(10).setPreferredWidth(50);
		tabla.getColumnModel().getColumn(11).setPreferredWidth(60);//divorcio
		tabla.getColumnModel().getColumn(12).setPreferredWidth(50);//Likes recibidos
		tabla.getColumnModel().getColumn(13).setPreferredWidth(50);//dados
		tabla.getColumnModel().getColumn(14).setPreferredWidth(40);
		tabla.getColumnModel().getColumn(15).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(16).setPreferredWidth(60);

		//PARA LOS FILTROS GENERALES
		cb_tipo_filtro = new JComboBox<>(filtros);
		cb_tipo_filtro.setBounds(320, 15, 100, 30);
		add(cb_tipo_filtro);
		
		String[] generos= {"Seleccione","Masculino","Femenino"};
		cb_genero = new JComboBox<>(generos);
		cb_genero.setBounds(430, 15, 100, 30);
		cb_genero.setVisible(false);
		add(cb_genero);

		bt_filtrar = new JButton("FILTRAR");
		bt_filtrar.setBounds(210, 15, 100, 30);
		add(bt_filtrar);


		tabla.setBounds(5, 50, 1284, 340);
		add(tabla);
		JScrollPane jsp = new JScrollPane(tabla);
		jsp.setBounds(5, 50, 1284, 340);
		add(jsp);
	}

	public void borrarTabla() {
		DefaultTableModel model = (DefaultTableModel)this.getTableModel(); 
		int rows = model.getRowCount(); 
		for(int i = rows - 1; i >=0; i--)
		{
			model.removeRow(i); 
		}
	}
	
	public void paintComponent(Graphics g) {

		int width = 1345;
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
		setBorder(new TitledBorder("Base de datos"));

		//BOTONES
		bt_regresar_pbdd = new JButton("Regresar");
		bt_regresar_pbdd.setActionCommand("REGRESARPBDD");
		bt_regresar_pbdd.setBounds(15, 500, 200, 30);
		bt_regresar_pbdd.setVisible(true);
		add(bt_regresar_pbdd);

	}

	public JButton getBt_regresar_pbdd() {
		return bt_regresar_pbdd;
	}

	public void setBt_regresar_pbdd(JButton bt_regresar_pbdd) {
		this.bt_regresar_pbdd = bt_regresar_pbdd;
	}
	

	public JComboBox<String> getCb_tipo_filtro() {
		return cb_tipo_filtro;
	}

	public void setCb_tipo_filtro(JComboBox<String> cb_tipo_filtro) {
		this.cb_tipo_filtro = cb_tipo_filtro;
	}

	public JComboBox<String> getCb_genero() {
		return cb_genero;
	}

	public void setCb_genero(JComboBox<String> cb_genero) {
		this.cb_genero = cb_genero;
	}

	public JButton getBt_filtrar() {
		return bt_filtrar;
	}

	public void setBt_filtrar(JButton bt_filtrar) {
		this.bt_filtrar = bt_filtrar;
	}


	public TableRowSorter<DefaultTableModel> getSorter() {
		return sorter;
	}


	public void setSorter(TableRowSorter<DefaultTableModel> sorter) {
		this.sorter = sorter;
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public String[] getColumnas() {
		return columnas;
	}

	public void setColumnas(String[] columnas) {
		this.columnas = columnas;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}


}