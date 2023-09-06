package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame{
	
	private PanelLogin pLog;
	private PanelAdministrador pAdmin;
	private PanelUsuario pUsuario;
	private PanelRegistro pRegistro;
	private PanelEncontrarPareja pEncontrar;
	private PanelPerfil pPerfil;
	private PanelBDD pBDD;
	private PanelTop10 pTop;
	private PanelInformes pInf;
	private PanelEliminarPersona pElim;
	
	public VentanaPrincipal() {
		setIconImage(new ImageIcon(getClass().getResource("/Imagen/logo.png")).getImage());
		setTitle("BosTinder");
		setSize(800, 600);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		iniciar();
	}

	private void iniciar() {
		
		// PANELES
		pLog = new PanelLogin();
		pLog.setBounds(0, 0, 784, 560);
		getContentPane().add(pLog);
		pLog.setVisible(true);
		
		pAdmin = new PanelAdministrador();
		pAdmin.setBounds(0, 0, 784, 560);
		getContentPane().add(pAdmin);
		pAdmin.setVisible(false);
		
		pUsuario = new PanelUsuario();
		pUsuario.setBounds(0, 0, 784, 560);
		getContentPane().add(pUsuario);
		pUsuario.setVisible(false);
		
		pRegistro = new PanelRegistro();
		pRegistro.setBounds(0, 0, 784, 560);
		getContentPane().add(pRegistro);
		pRegistro.setVisible(false);
		
		pEncontrar = new PanelEncontrarPareja();
		pEncontrar.setBounds(0, 0, 784, 560);
		getContentPane().add(pEncontrar);
		pEncontrar.setVisible(false);
		
		pPerfil = new PanelPerfil();
		pPerfil.setBounds(0, 0, 784, 560);
		getContentPane().add(pPerfil);
		pPerfil.setVisible(false);
		
		pBDD = new PanelBDD();
		pBDD.setBounds(0, 0, 1345, 560);
		getContentPane().add(pBDD);
		pBDD.setVisible(false);
		
		pTop = new PanelTop10();
		pTop.setBounds(0, 0, 1484, 560);
		getContentPane().add(pTop);
		pTop.setVisible(false);
		
		pInf = new PanelInformes();
		pInf.setBounds(0, 0, 784, 560);
		getContentPane().add(pInf);
		pInf.setVisible(false);
		
		pElim = new PanelEliminarPersona();
		pElim.setBounds(0, 0, 784, 560);
		getContentPane().add(pElim);
		pElim.setVisible(false);
	}

	public PanelLogin getpLog() {
		return pLog;
	}

	public void setpLog(PanelLogin pLog) {
		this.pLog = pLog;
	}

	public PanelAdministrador getpAdmin() {
		return pAdmin;
	}

	public void setpAdmin(PanelAdministrador pAdmin) {
		this.pAdmin = pAdmin;
	}

	public PanelUsuario getpUsuario() {
		return pUsuario;
	}

	public void setpUsuario(PanelUsuario pUsuario) {
		this.pUsuario = pUsuario;
	}

	public PanelRegistro getpRegistro() {
		return pRegistro;
	}

	public void setpRegistro(PanelRegistro pRegistro) {
		this.pRegistro = pRegistro;
	}

	public PanelEncontrarPareja getpEncontrar() {
		return pEncontrar;
	}

	public void setpEncontrar(PanelEncontrarPareja pEncontrar) {
		this.pEncontrar = pEncontrar;
	}

	public PanelPerfil getpPerfil() {
		return pPerfil;
	}

	public void setpPerfil(PanelPerfil pPerfil) {
		this.pPerfil = pPerfil;
	}

	public PanelBDD getpBDD() {
		return pBDD;
	}

	public void setpBDD(PanelBDD pBDD) {
		this.pBDD = pBDD;
	}

	public PanelTop10 getpTop() {
		return pTop;
	}

	public void setpTop(PanelTop10 pTop) {
		this.pTop = pTop;
	}

	public PanelInformes getpInf() {
		return pInf;
	}

	public void setpInf(PanelInformes pInf) {
		this.pInf = pInf;
	}

	public PanelEliminarPersona getpElim() {
		return pElim;
	}

	public void setpElim(PanelEliminarPersona pElim) {
		this.pElim = pElim;
	}
	
}

