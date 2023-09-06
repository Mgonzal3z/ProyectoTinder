package co.edu.unbosque.mundo;

public class Persona {

	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String genero;
	private String alias;
	private String clave;
	private String correo;
	private String fechaNaci;
	private String edad;
	private String ingresos;
	private String divorcio;
	private int likesRecibidos;
	private int likesDados;
	private int matches;
	private String estado;
	private String estatura;
	
	public Persona(int id,String nombre, String apellido1, String apellido2, String genero,String alias, String clave,
	 String correo, String fechaNaci, String edad, String ingresos, String divorcio, int likesRecibidos,  int likesDados, 
	 int matches, String estado, String estatura) {
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.genero = genero;
		this.alias = alias;
		this.clave = clave;
		this.correo = correo;
	    this.fechaNaci = fechaNaci;
		this.edad = edad;
		this.ingresos = ingresos;
		this.divorcio = divorcio;
		this.likesDados = likesDados;
		this.likesRecibidos = likesRecibidos;
		this.matches = matches;
		this.estado = estado;
		this.estatura = estatura;
	}
	
	public String[] getPersona() {
		String [] auxPersona = {getId()+"",getNombre(), getApellido1(),getApellido2(), getGenero(),getAlias(),
				getClave(),getCorreo(),getFechaNaci(),getEdad(),getIngresos()+"",getDivorcio(),
				getLikesRecibidos()+"", getLikesDados()+"",getMatches()+"",getEstado(),getEstatura()};
		return auxPersona;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFechaNaci() {
		return fechaNaci;
	}

	public void setFechaNaci(String fechaNaci) {
		this.fechaNaci = fechaNaci;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getIngresos() {
		return ingresos;
	}

	public void setIngresos(String ingresos) {
		this.ingresos = ingresos;
	}

	public String getDivorcio() {
		return divorcio;
	}

	public void setDivorcio(String divorcio) {
		this.divorcio = divorcio;
	}

	public int getLikesRecibidos() {
		return likesRecibidos;
	}

	public void setLikesRecibidos(int likesRecibidos) {
		this.likesRecibidos = likesRecibidos;
	}

	public int getLikesDados() {
		return likesDados;
	}

	public void setLikesDados(int likesDados) {
		this.likesDados = likesDados;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstatura() {
		return estatura;
	}

	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}

	
}
