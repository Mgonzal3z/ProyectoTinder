package co.edu.unbosque.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.apache.commons.validator.routines.EmailValidator;
import org.jfree.chart.ChartPanel;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import co.edu.unbosque.mundo.BosTinder;
import co.edu.unbosque.mundo.Persona;
import co.edu.unbosque.view.PanelAdministrador;
import co.edu.unbosque.view.PanelBDD;
import co.edu.unbosque.view.PanelEliminarPersona;
import co.edu.unbosque.view.PanelEncontrarPareja;
import co.edu.unbosque.view.PanelInformes;
import co.edu.unbosque.view.PanelLogin;
import co.edu.unbosque.view.PanelPerfil;
import co.edu.unbosque.view.PanelRegistro;
import co.edu.unbosque.view.PanelTop10;
import co.edu.unbosque.view.PanelUsuario;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener {
	private VentanaPrincipal vp;
	private PanelLogin pLog;
	private PanelAdministrador pAdmin;
	private PanelUsuario pUsuario;
	private PanelRegistro pRegistro;
	private PanelEncontrarPareja pEncontrar;
	private PanelPerfil pPerfil;
	private PanelBDD pBDD;
	private PanelEliminarPersona pElim;
	BosTinder mundo;
	public ArrayList <Persona> personas;
	private String usuarioActual=null;
	private int idUsuarioActual;
	private Component frame = null;

	public Controller() {
		vp = new VentanaPrincipal();
		try {
			mundo = new BosTinder();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pLog = new PanelLogin();
		pAdmin = new PanelAdministrador();
		pUsuario = new PanelUsuario();
		pRegistro = new PanelRegistro();
		pPerfil = new PanelPerfil();
		pEncontrar = new PanelEncontrarPareja();
		pPerfil = new PanelPerfil();
		pBDD = new PanelBDD();
		pElim = new PanelEliminarPersona();
		asignarOyentes();
		cargarTabla(mundo.getPersonas());
		personas=mundo.getPersonas();
		
		vp.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		vp.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
		                // Se pide una confirmaci�n antes de finalizar el programa
				int option = JOptionPane.showConfirmDialog(
					null, 
					"�Est�s seguro de que quieres cerrar la aplicaci�n?",
					"Confirmaci�n de cierre", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					mundo.writeToCsvFile();				
					System.exit(0);
				}
			}
		});
	}

	public void cargarTabla(ArrayList<Persona> auxPersonas) {
		for (int i = 0; i < auxPersonas.size(); i++) {
			actualizarTabla(auxPersonas.get(i).getId(), auxPersonas.get(i).getNombre(), auxPersonas.get(i).getApellido1(),
					auxPersonas.get(i).getApellido2(), auxPersonas.get(i).getGenero(),
					auxPersonas.get(i).getAlias(), auxPersonas.get(i).getClave(),  auxPersonas.get(i).getCorreo(),
					auxPersonas.get(i).getFechaNaci(),  auxPersonas.get(i).getEdad(), auxPersonas.get(i).getIngresos(),
					auxPersonas.get(i).getDivorcio(),
					auxPersonas.get(i).getLikesRecibidos(),  auxPersonas.get(i).getLikesDados(),
					auxPersonas.get(i).getMatches(),  auxPersonas.get(i).getEstado(),  auxPersonas.get(i).getEstatura()
					);
		}

	}

	private void asignarOyentes() {
		vp.getpLog().getBt_registrarme().addActionListener(this);
		vp.getpLog().getBt_login().addActionListener(this);
		vp.getpAdmin().getBt_logOut().addActionListener(this);
		vp.getpUsuario().getBt_encontrarPareja().addActionListener(this);
		vp.getpUsuario().getBt_logOut().addActionListener(this);
		vp.getpUsuario().getBt_perfil().addActionListener(this);
		vp.getpRegistro().getBt_regresar_pr().addActionListener(this);
		vp.getpRegistro().getBt_inscribir().addActionListener(this);
		vp.getpRegistro().getCb_sexo().addActionListener(this);
		vp.getpPerfil().getCb_sexo().addActionListener(this);
		vp.getpPerfil().getBt_inscribir().addActionListener(this);
		vp.getpEncontrar().getBt_regresar_pe().addActionListener(this);
		vp.getpEncontrar().getBt_like_pe().addActionListener(this);
		vp.getpEncontrar().getBt_next_pe().addActionListener(this);
		vp.getpPerfil().getBt_regresar_pp().addActionListener(this);
		vp.getpBDD().getBt_regresar_pbdd().addActionListener(this);
		vp.getpBDD().getBt_filtrar().addActionListener(this);
		vp.getpAdmin().getBt_bdd().addActionListener(this);
		vp.getpAdmin().getBt_informes().addActionListener(this);
		vp.getpInf().getBt_regresar_pi().addActionListener(this);
		vp.getpInf().getBt_exportar().addActionListener(this);
		vp.getpAdmin().getBt_eliminarPersona().addActionListener(this);
		vp.getpElim().getBt_regresar_pe().addActionListener(this);
		vp.getpElim().getBt_eliminar_pe().addActionListener(this);

	}



	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static boolean isValidEmail(String email) {

		EmailValidator validator = EmailValidator.getInstance();

		return validator.isValid(email);

	}


	public void reiniciarPR() {
		vp.getpRegistro().getTf_nombre().setText(null);
		vp.getpRegistro().getTf_apellido1().setText(null);
		vp.getpRegistro().getTf_apellido2().setText(null);
		vp.getpRegistro().getCb_sexo().setSelectedIndex(0);
		vp.getpRegistro().getTf_usuario().setText(null);
		vp.getpRegistro().getTf_contrasena().setText(null);
		vp.getpRegistro().getTf_correo().setText(null);
		vp.getpRegistro().getCb_dia().setSelectedIndex(0);
		vp.getpRegistro().getCb_mes().setSelectedIndex(0);
		vp.getpRegistro().getCb_anio().setSelectedIndex(0);
		vp.getpRegistro().getCb_estatura().setSelectedIndex(0);
		vp.getpRegistro().getCb_estadoCivil().setSelectedIndex(0);
		vp.getpRegistro().getTf_ingresos().setText(null);

	}

	public boolean validar() {
		boolean valor = true;


		if ((vp.getpRegistro().getTf_nombre().getText().toString().isEmpty())
				|| (vp.getpRegistro().getTf_apellido1().getText().toString().isEmpty())
				|| (vp.getpRegistro().getTf_apellido2().getText().toString().isEmpty())
				|| (vp.getpRegistro().getCb_sexo().getSelectedItem().toString().equals("Seleccione"))
				|| (vp.getpRegistro().getTf_usuario().getText().toString().isEmpty())
				|| (vp.getpRegistro().getTf_contrasena().getText().toString().isEmpty())
				|| (vp.getpRegistro().getTf_correo().getText().toString().isEmpty())
				|| (vp.getpRegistro().getCb_dia().getSelectedItem().toString().equals("Dia"))
				|| (vp.getpRegistro().getCb_mes().getSelectedItem().toString().equals("Mes"))
				|| (vp.getpRegistro().getCb_anio().getSelectedItem().toString().equals("A�o"))) {

			valor = false;

		} else if (vp.getpRegistro().getCb_sexo().getSelectedItem().toString().equals("H")) {
			if ((vp.getpRegistro().getTf_ingresos().getText().isEmpty())
					|| (vp.getpRegistro().getCb_estatura().getSelectedItem().toString().equals("Seleccione"))) {
				valor = false;
			}
			if (isNumeric(vp.getpRegistro().getTf_ingresos().getText()) == false) {
				JOptionPane.showMessageDialog(null, "El salario debe ser un valor numerico", "Validar Informaci�n",
						JOptionPane.ERROR_MESSAGE);
				valor = false;
			}
			if(vp.getpRegistro().getCb_estatura().getSelectedItem().toString().equals("No mostrar")) {
				JOptionPane.showMessageDialog(null, "Los hombres deben mostrar su estatura", "Validar Informaci�n",
						JOptionPane.ERROR_MESSAGE);
				valor = false;
			}
			if (2021 - Integer.parseInt(vp.getpRegistro().getCb_anio().getSelectedItem().toString()) < 18) {
				JOptionPane.showMessageDialog(null, "Debes ser mayor de 18 para poder registrarte",
						"Validar Informaci�n", JOptionPane.ERROR_MESSAGE);
				valor = false;
			}
			if (isValidEmail(vp.getpRegistro().getTf_correo().getText()) == false) {
				JOptionPane.showMessageDialog(null, "Debes ingresar correo correctamente", "Validar Informaci�n",
						JOptionPane.ERROR_MESSAGE);
				valor = false;
			}
		} else if (vp.getpRegistro().getCb_sexo().getSelectedItem().toString().equals("M")) {
			if (vp.getpRegistro().getCb_estadoCivil().getSelectedItem().equals("Seleccione")) {
				valor = false;
			}

			if (2021 - Integer.parseInt(vp.getpRegistro().getCb_anio().getSelectedItem().toString()) < 18) {
				JOptionPane.showMessageDialog(null, "Debes ser mayor de 18 para poder registrarte",
						"Validar Informaci�n", JOptionPane.ERROR_MESSAGE);
				valor = false;
			}
			if (vp.getpRegistro().getCb_estatura().getSelectedItem().toString().equals("Seleccione")) {
				vp.getpRegistro().getCb_estatura().setSelectedItem("No mostrar");

			}
			if (isValidEmail(vp.getpRegistro().getTf_correo().getText()) == false) {
				JOptionPane.showMessageDialog(null, "Debes ingresar correo correctamente", "Validar Informaci�n",
						JOptionPane.ERROR_MESSAGE);
				valor = false;
			}
		}

		return valor;

	}

	public void actualizarTabla(int Id,String nombre,String apellido1, String Apellido2, String genero,
			String alias, String clave, String correo,String nacimiento, String edad, String ingresos, String divorcio,
			int likesRecibidos, int likesDados, int matches, String estado, String estatura) {
		Object[] objtPersona = {  Id, nombre, apellido1,  Apellido2,  genero,
				alias, clave,  correo, nacimiento,  edad, ingresos, divorcio,
				likesRecibidos,  likesDados,  matches,  estado,  estatura};

		vp.getpBDD().getTableModel().addRow(objtPersona);
	}

	public int verSolteros(ArrayList<Persona> solteros) {
		int idSoltero = (int) Math.floor(Math.random()*(0-solteros.size()+1)+solteros.size());
		String info="Nombre: "+solteros.get(idSoltero).getNombre()
				+System.getProperty("line.separator")+
				System.getProperty("line.separator")+
				"Apellidos: "+solteros.get(idSoltero).getApellido1()+
				" "+solteros.get(idSoltero).getApellido2()
				+System.getProperty("line.separator")
				+System.getProperty("line.separator")+
				"Edad: "+solteros.get(idSoltero).getEdad()
				+System.getProperty("line.separator")
				+System.getProperty("line.separator")+
				"Estatura: "+solteros.get(idSoltero).getEstatura()
				+System.getProperty("line.separator")
				+System.getProperty("line.separator")+
				"Correo: "+solteros.get(idSoltero).getCorreo()
				+System.getProperty("line.separator")
				+System.getProperty("line.separator")+
				"Alias: "+solteros.get(idSoltero).getAlias();
		vp.getpEncontrar().getTa_infopareja().setText(info);
		return idSoltero;
	}

	public void siguienteSoltero() {
		if(mundo.getPersonas().get(idUsuarioActual-1).getGenero().equals("H")) {
			int idSoltero=verSolteros(mundo.getMujeres());
			vp.getpEncontrar().getTa_infopareja().append(
					System.getProperty("line.separator")
					+System.getProperty("line.separator")+
					"Divorcios: "+mundo.getMujeres().get(idSoltero).getDivorcio());
			vp.getpEncontrar().setIdSoltero(idSoltero);
		}else if(mundo.getPersonas().get(idUsuarioActual-1).getGenero().equals("M")) {
			int idSoltero=verSolteros(mundo.getHombres());
			vp.getpEncontrar().getTa_infopareja().append(
					System.getProperty("line.separator")
					+System.getProperty("line.separator")+
					"Ingresos: "+mundo.getHombres().get(idSoltero).getIngresos());
			vp.getpEncontrar().setIdSoltero(idSoltero);
		}
	}


	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("LOGIN")) {
			if (vp.getpLog().getTf_usuario().getText().equals("a")) {
				vp.getpLog().getTf_contrasena().setText(null);
				vp.getpLog().getTf_usuario().setText(null);
				vp.getpLog().setVisible(false);
				vp.getpAdmin().setVisible(true);


			} else if (vp.getpLog().getTf_usuario().getText() != "a") {
				boolean existe=false;

				for(int i =0; i< mundo.getPersonas().size();i++) {

					if((vp.getpLog().getTf_usuario().getText().equalsIgnoreCase(mundo.getPersonas().get(i).getAlias()))&&
							(vp.getpLog().getTf_contrasena().getText().equals(mundo.getPersonas().get(i).getClave()))) {
						existe=true;
						usuarioActual=mundo.getPersonas().get(i).getAlias();
						idUsuarioActual=mundo.getPersonas().get(i).getId();
						vp.getpLog().setVisible(false);
						vp.getpUsuario().setVisible(true);
						vp.getpLog().getTf_contrasena().setText(null);
						vp.getpLog().getTf_usuario().setText(null);

					}
				}
				if(existe==false) {
					JOptionPane.showMessageDialog(null, "Informaci�n no encontrada","Validar Informaci�n", JOptionPane.ERROR_MESSAGE);
				}

			}

		}
		if (e.getActionCommand().equals("REGISTRARME")) {
			vp.getpLog().setVisible(false);
			vp.getpRegistro().setVisible(true);

		}
		if (e.getActionCommand().equals("LOGOUT_ADMIN")) {
			vp.getpAdmin().setVisible(false);
			vp.getpLog().setVisible(true);

		}
		if (e.getActionCommand().equals("LOGOUT_USU")) {
			vp.getpUsuario().setVisible(false);
			vp.getpLog().setVisible(true);
			usuarioActual=null;

		}
		if (e.getActionCommand().equals("REGRESAR_PREGIS")) {
			vp.getpRegistro().setVisible(false);
			vp.getpLog().setVisible(true);

		}
		if (e.getActionCommand().equals("SEXO")) {
			String opcion = vp.getpRegistro().getCb_sexo().getSelectedItem().toString();
			if (opcion.equals("H")) {
				vp.getpRegistro().getCb_estatura().setSelectedIndex(0);
				vp.getpRegistro().getLb_ingresos().setVisible(true);
				vp.getpRegistro().getTf_ingresos().setVisible(true);
				vp.getpRegistro().getLb_hisEstadoCivil().setVisible(false);
				vp.getpRegistro().getCb_estadoCivil().setVisible(false);
				vp.getpRegistro().getLb_estatura().setVisible(true);
				vp.getpRegistro().getCb_estatura().setVisible(true);
				vp.getpRegistro().getTf_ingresos().setText("");

			} else if (opcion.equals("M")) {
				vp.getpRegistro().getCb_estatura().setSelectedIndex(0);
				vp.getpRegistro().getLb_ingresos().setVisible(false);
				vp.getpRegistro().getTf_ingresos().setVisible(false);
				vp.getpRegistro().getLb_hisEstadoCivil().setVisible(true);
				vp.getpRegistro().getCb_estadoCivil().setVisible(true);
				vp.getpRegistro().getLb_estatura().setVisible(true);
				vp.getpRegistro().getCb_estatura().setVisible(true);
				vp.getpRegistro().getTf_ingresos().setText("No aplica");

			} else if (opcion.equals("Seleccione")) {
				vp.getpRegistro().getCb_estadoCivil().setSelectedIndex(0);
				vp.getpRegistro().getCb_estatura().setSelectedIndex(0);
				vp.getpRegistro().getLb_ingresos().setVisible(false);
				vp.getpRegistro().getTf_ingresos().setVisible(false);
				vp.getpRegistro().getLb_hisEstadoCivil().setVisible(false);
				vp.getpRegistro().getLb_estatura().setVisible(false);
				vp.getpRegistro().getCb_estadoCivil().setVisible(false);
				vp.getpRegistro().getCb_estatura().setVisible(false);
				vp.getpRegistro().getTf_ingresos().setText("");
			}
		}
		if (e.getActionCommand().equals("ENCONTRAR")) {
			vp.getpUsuario().setVisible(false);
			vp.getpEncontrar().setVisible(true);
			siguienteSoltero();

		}if (e.getActionCommand().equals("LIKEPE")) {
			mundo.AumentarLike(vp.getpEncontrar().getIdSoltero()-1, idUsuarioActual-1);
			vp.getpBDD().borrarTabla();
			cargarTabla(mundo.getPersonas());
			siguienteSoltero();
		}
		if (e.getActionCommand().equals("NEXTPE")) {
			siguienteSoltero();
		}
		if (e.getActionCommand().equals("REGRESARPENCON")) {
			vp.getpUsuario().setVisible(true);
			vp.getpEncontrar().setVisible(false);
		}
		if (e.getActionCommand().equals("PERFIL")) {
			vp.getpPerfil().setVisible(true);
			vp.getpUsuario().setVisible(false);
			int pos =idUsuarioActual-1;
			vp.getpPerfil().getTf_nombre().setText(mundo.getPersonas().get(pos).getNombre());
			vp.getpPerfil().getTf_apellido1().setText(mundo.getPersonas().get(pos).getApellido1());
			vp.getpPerfil().getTf_apellido2().setText(mundo.getPersonas().get(pos).getApellido2());
			vp.getpPerfil().getTf_usuario().setText(mundo.getPersonas().get(pos).getAlias());
			vp.getpPerfil().getTf_contrasena().setText(mundo.getPersonas().get(pos).getClave());
			vp.getpPerfil().getTf_correo().setText(mundo.getPersonas().get(pos).getCorreo());
			vp.getpPerfil().getCb_sexo().setSelectedItem(mundo.getPersonas().get(pos).getGenero());
			String fecha= mundo.getPersonas().get(pos).getFechaNaci();
			String[] fechap=fecha.split("/");
			vp.getpPerfil().getCb_dia().setSelectedItem(fechap[0]);
			vp.getpPerfil().getCb_mes().setSelectedItem(fechap[1]);
			vp.getpPerfil().getCb_anio().setSelectedItem(fechap[2]);
			vp.getpPerfil().getCb_estatura().setSelectedItem(mundo.getPersonas().get(pos).getEstatura());
			vp.getpPerfil().getTf_likesRecibidos().setText(mundo.getPersonas().get(pos).getLikesRecibidos()+"");
			vp.getpPerfil().getTf_Matches().setText(mundo.getPersonas().get(pos).getMatches()+"");
			if(vp.getpPerfil().getCb_sexo().getSelectedItem().equals("H")) {
				vp.getpPerfil().getTf_ingresos().setText(mundo.getHombres().get(pos).getIngresos());
				vp.getpPerfil().getCb_estadoCivil().setSelectedItem("No aplica");
			}else if(vp.getpPerfil().getCb_sexo().getSelectedItem().equals("H")) {
				vp.getpPerfil().getCb_estadoCivil().setSelectedItem(mundo.getMujeres().get(pos).getDivorcio());
				vp.getpPerfil().getTf_ingresos().setText("No Aplica");
			}
		}
		if (e.getActionCommand().equals("ACTUALIZARPP")) {
			int auxId =idUsuarioActual-1;
			int edad= 2021- Integer.parseInt(vp.getpPerfil().getCb_anio().getSelectedItem().toString());
			String divorcio="";
			String ingresos="";
			if(vp.getpPerfil().getCb_sexo().getSelectedItem().toString().equals("H")) {
				divorcio="No aplica";
				ingresos=vp.getpPerfil().getTf_ingresos().getText();
			}else if(vp.getpPerfil().getCb_sexo().getSelectedItem().toString().equals("M")) {
				divorcio=vp.getpPerfil().getCb_estadoCivil().getSelectedItem().toString();
				ingresos="No aplica";
			}
			personas.set(auxId, new Persona(auxId+1, 
					vp.getpPerfil().getTf_nombre().getText(),  
					vp.getpPerfil().getTf_apellido1().getText(), 
					vp.getpPerfil().getTf_apellido2().getText(),
					vp.getpPerfil().getCb_sexo().getSelectedItem().toString(),
					vp.getpPerfil().getTf_usuario().getText(),
					vp.getpPerfil().getTf_contrasena().getText(),
					vp.getpPerfil().getTf_correo().getText(),
					vp.getpPerfil().getCb_dia().getSelectedItem()+"/"+vp.getpRegistro().getCb_mes().getSelectedItem()+"/"+vp.getpRegistro().getCb_anio().getSelectedItem(),
					edad+"",ingresos,divorcio,
					0,0,0,"Disponible", 
					vp.getpPerfil().getCb_estatura().getSelectedItem().toString()));
			JOptionPane.showMessageDialog(null, "Se ha actualizado la informaci�n correctamente");
			vp.getpBDD().borrarTabla();
			cargarTabla(mundo.getPersonas());
		}
		if (e.getActionCommand().equals("SEXOPP")) {
			String opcion = vp.getpPerfil().getCb_sexo().getSelectedItem().toString();
			if (opcion.equals("H")) {
				vp.getpPerfil().getCb_estatura().setSelectedIndex(0);
				vp.getpPerfil().getLb_ingresos().setVisible(true);
				vp.getpPerfil().getTf_ingresos().setVisible(true);
				vp.getpPerfil().getLb_hisEstadoCivil().setVisible(false);
				vp.getpPerfil().getCb_estadoCivil().setVisible(false);
				vp.getpPerfil().getLb_estatura().setVisible(true);
				vp.getpPerfil().getCb_estatura().setVisible(true);
			}else if (opcion.equals("M")) {
				vp.getpPerfil().getCb_estatura().setSelectedIndex(0);
				vp.getpPerfil().getLb_ingresos().setVisible(false);
				vp.getpPerfil().getTf_ingresos().setVisible(false);
				vp.getpPerfil().getLb_hisEstadoCivil().setVisible(true);
				vp.getpPerfil().getCb_estadoCivil().setVisible(true);
				vp.getpPerfil().getLb_estatura().setVisible(true);
				vp.getpPerfil().getCb_estatura().setVisible(true);

			} else if (opcion.equals("Seleccione")) {
				vp.getpPerfil().getCb_estadoCivil().setSelectedIndex(0);
				vp.getpPerfil().getCb_estatura().setSelectedIndex(0);
				vp.getpPerfil().getLb_ingresos().setVisible(false);
				vp.getpPerfil().getTf_ingresos().setVisible(false);
				vp.getpPerfil().getLb_hisEstadoCivil().setVisible(false);
				vp.getpPerfil().getLb_estatura().setVisible(false);
				vp.getpPerfil().getCb_estadoCivil().setVisible(false);
				vp.getpPerfil().getCb_estatura().setVisible(false);
			}

		}
		if (e.getActionCommand().equals("REGRESARPPERF")) {
			vp.getpPerfil().setVisible(false);
			vp.getpUsuario().setVisible(true);
		}
		if (e.getActionCommand().equals("BDD")) {
			vp.getpAdmin().setVisible(false);
			vp.getpBDD().setVisible(true);
			vp.setSize(1350, 600);
			vp.setLocationRelativeTo(null);
			System.out.println(mundo.getPersonas().get(0).getDivorcio());
		}
		if (e.getActionCommand().equals("REGRESARPBDD")) {
			vp.getpAdmin().setVisible(true);
			vp.getpBDD().setVisible(false);
			vp.setSize(800, 600);
			vp.setLocationRelativeTo(null);
		}
		if (e.getActionCommand().equals("INFORMES")) {
			vp.getpAdmin().setVisible(false);
			vp.getpInf().setVisible(true);
			vp.getpInf().getLb_media().setVisible(true);
			vp.getpInf().getTf_media().setVisible(true);
			vp.getpInf().getLb_mediana().setVisible(true);
			vp.getpInf().getTf_mediana().setVisible(true);
			vp.getpInf().getLb_moda().setVisible(true);
			vp.getpInf().getTf_moda().setVisible(true);
			vp.getpInf().getTf_media().setText(mundo.media()+"");
			vp.getpInf().getTf_mediana().setText(mundo.mediana()+"");
			vp.getpInf().getTf_moda().setText(mundo.moda()+"");
			try {
				mundo.graficas();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
//				e1.printStackTrace();
			}
			try {
				ChartPanel pan = new ChartPanel(mundo.graficas());
				pan.setBounds(100, 50, 500, 300);
				pan.setVisible(true);
				vp.getContentPane().add(pan);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
//				e1.printStackTrace();
			}
		}
		if (e.getActionCommand().equals("EXPORTAR")) {
			mundo.exportarReportes(vp.getpInf());
			JOptionPane.showMessageDialog(null, "Exportado con exito");
		}
		if (e.getActionCommand().equals("REGRESARPPI")) {
			vp.getpAdmin().setVisible(true);
			vp.getpInf().setVisible(false);
		}
		if (e.getActionCommand().equals("ELIMINAR")) {
			vp.getpAdmin().setVisible(false);
			vp.getpElim().setVisible(true);
		}
		if (e.getActionCommand().equals("REGRESARPE")) {
			vp.getpAdmin().setVisible(true);
			vp.getpElim().setVisible(false);
		}
		if (e.getActionCommand().equals("ELIMINARPE")) {
			JOptionPane.showMessageDialog(null, mundo.eliminarPersona(vp.getpElim().getTf_idaeliminar_pe().getText()));
			vp.getpBDD().borrarTabla();
			cargarTabla(mundo.getPersonas());
		}
		if(e.getActionCommand().equals("INSCRIBIR")) {
			if (validar() == true) {
				int auxId= mundo.getPersonas().get(mundo.getPersonas().size()-1).getId()+1;
				int edad= 2021- Integer.parseInt(vp.getpRegistro().getCb_anio().getSelectedItem().toString());
				if(mundo.validarAlias(vp.getpRegistro().getTf_usuario().getText().toString())==false) {
					JOptionPane.showMessageDialog(null, "Nombre de Usuario No Disponible", "Validar Informaci�n",
							JOptionPane.ERROR_MESSAGE);
				}else {
					String divorcio="";
					String ingresos="";
					if(vp.getpRegistro().getCb_sexo().getSelectedItem().toString().equals("H")) {
						divorcio="No aplica";
						ingresos=vp.getpRegistro().getTf_ingresos().getText();
					}else if(vp.getpRegistro().getCb_sexo().getSelectedItem().toString().equals("M")) {
						divorcio=vp.getpRegistro().getCb_estadoCivil().getSelectedItem().toString();
						ingresos="No aplica";
					}
					personas.add(new Persona(auxId, 
							vp.getpRegistro().getTf_nombre().getText(),  
							vp.getpRegistro().getTf_apellido1().getText(), 
							vp.getpRegistro().getTf_apellido2().getText(),
							vp.getpRegistro().getCb_sexo().getSelectedItem().toString(),
							vp.getpRegistro().getTf_usuario().getText(),
							vp.getpRegistro().getTf_contrasena().getText(),
							vp.getpRegistro().getTf_correo().getText(),
							vp.getpRegistro().getCb_dia().getSelectedItem()+"/"+vp.getpRegistro().getCb_mes().getSelectedItem()+"/"+vp.getpRegistro().getCb_anio().getSelectedItem(),
							edad+"",
							ingresos,divorcio,
							0,0,0,"Disponible", 
							vp.getpRegistro().getCb_estatura().getSelectedItem().toString()));
					JOptionPane.showMessageDialog(null, "Se ha ingresado una persona correctamente");
					mundo.setPersonas(personas);
					mundo.añadePorGenero(auxId-1);
					vp.getpBDD().borrarTabla();
					cargarTabla(mundo.getPersonas());
				}
				mundo.enviarCorreo(vp.getpRegistro().getTf_correo().getText().toString(),vp.getpRegistro().getTf_usuario().getText().toString(), vp.getpRegistro().getTf_contrasena().getText().toString());
				reiniciarPR();
				
			} else {
				JOptionPane.showMessageDialog(frame, "Verifique informacion", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getActionCommand().equals("FILTRAR")) {
			if(vp.getpBDD().getCb_tipo_filtro().getSelectedItem().toString().equals("Top 10 Likes")) {
				vp.getpBDD().getCb_genero().setVisible(false);
				vp.getpBDD().borrarTabla();
				cargarTabla(mundo.getTop10Likes());
			}
			else if(vp.getpBDD().getCb_tipo_filtro().getSelectedItem().toString().equals("Ingresos")) {
				vp.getpBDD().getCb_genero().setVisible(false);
				vp.getpBDD().borrarTabla();
				cargarTabla(mundo.getIngresos());
			}
			else if(vp.getpBDD().getCb_tipo_filtro().getSelectedItem().toString().equals("Genero")) {
				vp.getpBDD().getCb_genero().setVisible(true);
				if(vp.getpBDD().getCb_genero().getSelectedItem().toString().equals("Masculino")) {
					vp.getpBDD().borrarTabla();
					cargarTabla(mundo.getHombres());	
				}else if(vp.getpBDD().getCb_genero().getSelectedItem().toString().equals("Femenino")) {
					vp.getpBDD().borrarTabla();
					cargarTabla(mundo.getMujeres());	
				}else {
					vp.getpBDD().borrarTabla();
					cargarTabla(mundo.getIngresos());
				}
			}else {
				vp.getpBDD().getCb_genero().setVisible(false);
				vp.getpBDD().borrarTabla();
				cargarTabla(mundo.getPersonas());
			}
		}
	}
}
