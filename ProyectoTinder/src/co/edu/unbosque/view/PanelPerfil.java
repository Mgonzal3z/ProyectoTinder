package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelPerfil extends JPanel{
	private JLabel lb_nombre, lb_apellido1, lb_apellido2, 
	lb_sexo, lb_usuario, lb_contrasena, lb_correo, lb_nacimiento, 
	lb_ingresos, lb_hisEstadoCivil, lb_estatura,lb_likesRecibidos,lb_Matches ;
	private JTextField tf_nombre, tf_apellido1, tf_apellido2, 
	 tf_usuario, tf_contrasena, tf_correo, tf_nacimiento, 
	tf_ingresos, tf_hisEstadoCivil, tf_likesRecibidos,tf_Matches;
	private JComboBox<String> cb_sexo, cb_dia, cb_mes, cb_anio, 
	cb_estatura, cb_estadoCivil;
	private JButton bt_inscribir, bt_regresar_pp;
	private Image background;
	
	public PanelPerfil() {
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
		setBorder(new TitledBorder("Perfil"));
		
		//CAMPOS DE TEXTO Y LABEL
		
				//CAMPO NOMBRE
				lb_nombre = new JLabel("Nombre: ");
				lb_nombre.setBounds(5, 15, 200, 30);
				add(lb_nombre);
				tf_nombre = new JTextField();
				tf_nombre.setBounds(5, 40, 200, 30);
				add(tf_nombre);
				
				//CAMPO APELLIDOS
				lb_apellido1 = new JLabel("Primer Apellido: ");
				lb_apellido1.setBounds(5, 65, 200, 30);
				add(lb_apellido1);
				tf_apellido1 = new JTextField();
				tf_apellido1.setBounds(5, 90, 200, 30);
				add(tf_apellido1);
				
				lb_apellido2 = new JLabel("Segundo Apellido: ");
				lb_apellido2.setBounds(5, 115, 200, 30);
				add(lb_apellido2);
				tf_apellido2 = new JTextField();
				tf_apellido2.setBounds(5, 140, 200, 30);
				add(tf_apellido2);
				
				//CAMPO GENERO
				lb_sexo = new JLabel("Sexo:");
				lb_sexo.setBounds(5, 165, 200, 30);
				add(lb_sexo);	
				cb_sexo = new JComboBox<>();
				cb_sexo.setBounds(5, 190, 100, 30);
				cb_sexo.addItem("Seleccione");
				cb_sexo.addItem("H");
				cb_sexo.addItem("M");
				cb_sexo.setActionCommand("SEXOPP");
				add(cb_sexo);
				
				//CAMPO FECHA DE NACIMIENTO
				lb_nacimiento = new JLabel("Fecha de nacimiento: ");
				lb_nacimiento.setBounds(5, 215, 200, 30);
				add(lb_nacimiento);
				cb_dia = new JComboBox<String>();
				cb_dia.setBounds(5, 240, 60, 30);
				cb_dia.addItem("Dia");
				add(cb_dia);
				cb_dia.setEditable(false);
				for (int i = 1; i <= 31; i++) {
					String aux = "" + i;
					cb_dia.addItem(aux);
				}
				cb_mes = new JComboBox<String>(new String[] {"Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
						"Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" });
				cb_mes.setBounds(70, 240, 100, 30);
				cb_mes.setActionCommand("MES");
				add(cb_mes);
				
				cb_anio = new JComboBox<String>();
				cb_anio.setBounds(175, 240, 60, 30);
				cb_anio.setActionCommand("AÑO");
				add(cb_anio);
				cb_anio.addItem("Año");
				for (int i = 1900; i <= 2020; i++) {
					String aux = "" + i;
					cb_anio.addItem(aux);
				}
				
				//CAMPO ESTATURA
				lb_estatura = new JLabel("Estatura en cm: ");
				lb_estatura.setBounds(5, 265, 200, 30);
				add(lb_estatura);
				lb_estatura.setVisible(false);
				cb_estatura = new JComboBox<String>();
				cb_estatura.setBounds(5, 290, 100, 30);
				cb_estatura.addItem("Seleccione");
				add(cb_estatura);
				cb_estatura.setVisible(false);
				for (int i = 100; i <= 220; i++) {
					String aux = "" + i;
					cb_estatura.addItem(aux);
				}
				
				//CAMPO ESTADO CIVIL
				lb_hisEstadoCivil = new JLabel("Divorcios: ");
				lb_hisEstadoCivil.setBounds(5, 315, 200, 30);
				add(lb_hisEstadoCivil);
				lb_hisEstadoCivil.setVisible(false);
				cb_estadoCivil = new JComboBox<String>();
				cb_estadoCivil.setBounds(5, 340, 100, 30);
				cb_estadoCivil.addItem("Seleccione");
				cb_estadoCivil.addItem("NO");
				cb_estadoCivil.addItem("SI");
				add(cb_estadoCivil);
				cb_estadoCivil.setVisible(false);
				
				//CAMPO INGRESOS
				lb_ingresos= new JLabel("Ingresos: ");
				lb_ingresos.setBounds(5, 315, 200, 30);
				add(lb_ingresos);
				lb_ingresos.setVisible(false);
				tf_ingresos = new JTextField();
				tf_ingresos.setBounds(5, 340, 150, 30);
				add(tf_ingresos);
				tf_ingresos.setVisible(false);
				
				//CAMPO NOMBRE DE USUARIO
				lb_usuario = new JLabel("Usuario:");
				lb_usuario.setBounds(290, 15, 200, 30);
				add(lb_usuario);
				tf_usuario = new JTextField();
				tf_usuario.setBounds(290, 40, 200, 30);
				add(tf_usuario);
				
				//CAMPO CONTRASEÑA
				lb_contrasena = new JLabel("Contraseña:");
				lb_contrasena.setBounds(290, 65, 200, 30);
				add(lb_contrasena);
				tf_contrasena = new JTextField();
				tf_contrasena.setBounds(290, 90, 200, 30);
				add(tf_contrasena);
				
				//CAMPO CORREO
				lb_correo = new JLabel("Correo:");
				lb_correo.setBounds(290, 115, 200, 30);
				add(lb_correo);
				tf_correo = new JTextField();
				tf_correo.setBounds(290, 140, 200, 30);
				add(tf_correo);
				
				//CAMPO LIKES RECIBIDOS
				lb_likesRecibidos = new JLabel("Likes Recibidos: ");
				lb_likesRecibidos.setBounds(290, 165, 200, 30);
				add(lb_likesRecibidos);
				tf_likesRecibidos = new JTextField();
				tf_likesRecibidos.setBounds(290, 195, 200, 30);
				tf_likesRecibidos.setEditable(false);
				add(tf_likesRecibidos);
				
				//CAMPO MATCHES
				lb_Matches = new JLabel("Matches: ");
				lb_Matches.setBounds(290, 225, 200, 30);
				add(lb_Matches);
				tf_Matches = new JTextField();
				tf_Matches.setEditable(false);
				tf_Matches.setBounds(290, 255, 200, 30);
				add(tf_Matches);
		
		//BOTONES
		bt_regresar_pp = new JButton("Regresar");
		bt_regresar_pp.setActionCommand("REGRESARPPERF");
		bt_regresar_pp.setBounds(150, 400, 200, 30);
		bt_regresar_pp.setVisible(true);
		add(bt_regresar_pp);
		
		bt_inscribir = new JButton("Actualizar");
		bt_inscribir.setActionCommand("ACTUALIZARPP");
		bt_inscribir.setBounds(400, 400, 200, 30);
		bt_inscribir.setVisible(true);
		add(bt_inscribir);
		
	}

	public JButton getBt_regresar_pp() {
		return bt_regresar_pp;
	}

	public void setBt_regresar_pp(JButton bt_regresar_pp) {
		this.bt_regresar_pp = bt_regresar_pp;
	}

	public JLabel getLb_nombre() {
		return lb_nombre;
	}

	public void setLb_nombre(JLabel lb_nombre) {
		this.lb_nombre = lb_nombre;
	}

	public JLabel getLb_apellido1() {
		return lb_apellido1;
	}

	public void setLb_apellido1(JLabel lb_apellido1) {
		this.lb_apellido1 = lb_apellido1;
	}

	public JLabel getLb_apellido2() {
		return lb_apellido2;
	}

	public void setLb_apellido2(JLabel lb_apellido2) {
		this.lb_apellido2 = lb_apellido2;
	}

	public JLabel getLb_sexo() {
		return lb_sexo;
	}

	public void setLb_sexo(JLabel lb_sexo) {
		this.lb_sexo = lb_sexo;
	}

	public JLabel getLb_usuario() {
		return lb_usuario;
	}

	public void setLb_usuario(JLabel lb_usuario) {
		this.lb_usuario = lb_usuario;
	}

	public JLabel getLb_contrasena() {
		return lb_contrasena;
	}

	public void setLb_contrasena(JLabel lb_contrasena) {
		this.lb_contrasena = lb_contrasena;
	}

	public JLabel getLb_correo() {
		return lb_correo;
	}

	public void setLb_correo(JLabel lb_correo) {
		this.lb_correo = lb_correo;
	}

	public JLabel getLb_nacimiento() {
		return lb_nacimiento;
	}

	public void setLb_nacimiento(JLabel lb_nacimiento) {
		this.lb_nacimiento = lb_nacimiento;
	}

	public JLabel getLb_ingresos() {
		return lb_ingresos;
	}

	public void setLb_ingresos(JLabel lb_ingresos) {
		this.lb_ingresos = lb_ingresos;
	}

	public JLabel getLb_hisEstadoCivil() {
		return lb_hisEstadoCivil;
	}

	public void setLb_hisEstadoCivil(JLabel lb_hisEstadoCivil) {
		this.lb_hisEstadoCivil = lb_hisEstadoCivil;
	}

	public JLabel getLb_estatura() {
		return lb_estatura;
	}

	public void setLb_estatura(JLabel lb_estatura) {
		this.lb_estatura = lb_estatura;
	}

	public JTextField getTf_nombre() {
		return tf_nombre;
	}

	public void setTf_nombre(JTextField tf_nombre) {
		this.tf_nombre = tf_nombre;
	}

	public JTextField getTf_apellido1() {
		return tf_apellido1;
	}

	public void setTf_apellido1(JTextField tf_apellido1) {
		this.tf_apellido1 = tf_apellido1;
	}

	public JTextField getTf_apellido2() {
		return tf_apellido2;
	}

	public void setTf_apellido2(JTextField tf_apellido2) {
		this.tf_apellido2 = tf_apellido2;
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

	public JTextField getTf_correo() {
		return tf_correo;
	}

	public void setTf_correo(JTextField tf_correo) {
		this.tf_correo = tf_correo;
	}

	public JTextField getTf_nacimiento() {
		return tf_nacimiento;
	}

	public void setTf_nacimiento(JTextField tf_nacimiento) {
		this.tf_nacimiento = tf_nacimiento;
	}

	public JTextField getTf_ingresos() {
		return tf_ingresos;
	}

	public void setTf_ingresos(JTextField tf_ingresos) {
		this.tf_ingresos = tf_ingresos;
	}

	public JTextField getTf_hisEstadoCivil() {
		return tf_hisEstadoCivil;
	}

	public void setTf_hisEstadoCivil(JTextField tf_hisEstadoCivil) {
		this.tf_hisEstadoCivil = tf_hisEstadoCivil;
	}

	public JComboBox<String> getCb_sexo() {
		return cb_sexo;
	}

	public void setCb_sexo(JComboBox<String> cb_sexo) {
		this.cb_sexo = cb_sexo;
	}

	public JComboBox<String> getCb_dia() {
		return cb_dia;
	}

	public void setCb_dia(JComboBox<String> cb_dia) {
		this.cb_dia = cb_dia;
	}

	public JComboBox<String> getCb_mes() {
		return cb_mes;
	}

	public void setCb_mes(JComboBox<String> cb_mes) {
		this.cb_mes = cb_mes;
	}

	public JComboBox<String> getCb_anio() {
		return cb_anio;
	}

	public void setCb_anio(JComboBox<String> cb_anio) {
		this.cb_anio = cb_anio;
	}

	public JComboBox<String> getCb_estatura() {
		return cb_estatura;
	}

	public void setCb_estatura(JComboBox<String> cb_estatura) {
		this.cb_estatura = cb_estatura;
	}

	public JComboBox<String> getCb_estadoCivil() {
		return cb_estadoCivil;
	}

	public void setCb_estadoCivil(JComboBox<String> cb_estadoCivil) {
		this.cb_estadoCivil = cb_estadoCivil;
	}

	public JButton getBt_inscribir() {
		return bt_inscribir;
	}

	public void setBt_inscribir(JButton bt_inscribir) {
		this.bt_inscribir = bt_inscribir;
	}

	public JLabel getLb_likesRecibidos() {
		return lb_likesRecibidos;
	}

	public void setLb_likesRecibidos(JLabel lb_likesRecibidos) {
		this.lb_likesRecibidos = lb_likesRecibidos;
	}

	public JLabel getLb_Matches() {
		return lb_Matches;
	}

	public void setLb_Matches(JLabel lb_Matches) {
		this.lb_Matches = lb_Matches;
	}

	public JTextField getTf_likesRecibidos() {
		return tf_likesRecibidos;
	}

	public void setTf_likesRecibidos(JTextField tf_likesRecibidos) {
		this.tf_likesRecibidos = tf_likesRecibidos;
	}

	public JTextField getTf_Matches() {
		return tf_Matches;
	}

	public void setTf_Matches(JTextField tf_Matches) {
		this.tf_Matches = tf_Matches;
	}
	
	
	
}
