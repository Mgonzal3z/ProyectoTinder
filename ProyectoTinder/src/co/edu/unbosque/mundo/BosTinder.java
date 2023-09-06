package co.edu.unbosque.mundo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;


public class BosTinder {

	private ArrayList <Persona> personas;
	private ArrayList <Persona> hombres;
	private ArrayList <Persona> mujeres;
	private ArrayList <Persona> top10Likes;
	private FileReader archCSV = null;
	private CSVReader csvReader = null;
	String[] cabecera = new String [17];

	public BosTinder() throws FileNotFoundException {

		personas = new ArrayList<Persona>();
		mujeres = new ArrayList<Persona>();
		hombres = new ArrayList<Persona>();
		top10Likes = new ArrayList<Persona>();

		//PARA LEER EL ARCHIVO CSV
		archCSV = new FileReader("data/datos.csv");
		CSVParser conPuntoYComa = new CSVParserBuilder().withSeparator(';').build();
		csvReader = new CSVReaderBuilder(archCSV).withCSVParser(conPuntoYComa).build();
		leerArchivo();
		

	



	}


	public void leerArchivo() {
		try {

			String[] fila = null;
			fila = csvReader.readNext();
			cabecera[0] = fila[0]; cabecera[1] = fila[1]; cabecera[2] = fila[2]; cabecera[3] = fila[3];
			cabecera[4] = fila[4]; cabecera[5] = fila[5]; cabecera[6] = fila[6]; cabecera[7] = fila[7];
			cabecera[8] = fila[8]; cabecera[9] = fila[9]; cabecera[10] = fila[10]; cabecera[11] = fila[11];
			cabecera[12] = fila[12]; cabecera[13] = fila[13]; cabecera[14] = fila[14]; cabecera[15] = fila[15];
			cabecera[16] = fila[16];		 


			while((fila = csvReader.readNext()) != null) {        	  

				if(fila[4].equalsIgnoreCase("H")) {
					fila[11]= "No aplica";
				}else {
					fila[10]="No aplica";
				}

				Persona p = new Persona(Integer.parseInt(fila[0]), fila[1], fila[2], fila[3], fila[4], fila[5], fila[6],
						fila[7], fila[8], fila[9], fila[10], fila[11], Integer.parseInt(fila[12]), Integer.parseInt(fila[13]),
						Integer.parseInt(fila[14]), fila[15], fila[16]);

				personas.add(p);
			}


		}
		catch(IOException e) {
//			System.out.println(e);
		}
		catch(Exception e) {
//			System.out.println(e);
		}
		finally {
			try { 
				archCSV.close();
				csvReader.close();
			}
			catch(IOException e) {
//				System.out.println(e);
			}
		}
	}


	public void writeToCsvFile(){
		List<String[]> usuarios = new ArrayList<String[]>();
		usuarios.add(cabecera);
		for(int i=0;i<personas.size();i++) {
			usuarios.add(personas.get(i).getPersona());	
		}
		String separator=";";
		String fileName= "data/datos.csv";
		try (FileWriter writer = new FileWriter(fileName)){
			for (String[] strings : usuarios) {
				for (int i = 0; i < strings.length; i++) {
					writer.append(strings[i]);
					if(i < (strings.length-1))
						writer.append(separator);
				}
				writer.append(System.lineSeparator());
			}
			writer.flush();
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}


	public ArrayList<Persona> getPersonas() {
		return personas;
	}


	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

	public void enviarCorreo(String correoDestino, String usuario, String clave) {
		final String username = "proyectobostinder@gmail.com";
		final String password = "abc1234$";
		Properties props = new Properties();

		props.put("mail.smtp.user","username"); 
		props.put("mail.smtp.host", "smtp.gmail.com"); 
		props.put("mail.smtp.port", "25"); 
		props.put("mail.debug", "true"); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.starttls.enable","true"); 
		props.put("mail.smtp.EnableSSL.enable","true");

		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
		props.setProperty("mail.smtp.socketFactory.fallback", "false");   
		props.setProperty("mail.smtp.port", "465");   
		props.setProperty("mail.smtp.socketFactory.port", "465"); 
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("proyectobostinder@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(correoDestino));
			message.setSubject("Registro Exitoso BosTinder");
			message.setText("Estimado cliente, tu registro a BosTinder fue exitoso. "
					+ "\nTe damos la bienvenida a esta increible comunidad."
					+ "\n\n Usuario: "+usuario
					+ "\n Clave: "+clave);
			Transport.send(message);
			System.out.println("Se envio exitosamente el correo");
		} catch (MessagingException e) {
			System.out.println("No se pudo enviar el correo");
			throw new RuntimeException(e);
		}
	}


	public int media() {
		int media=0;
		for(int i=0;i<personas.size();i++) {
			media= media+personas.get(i).getLikesRecibidos();
		}
		return media/personas.size();	
	}

	public int mediana(){
		ArrayList<Integer> numeros = ordenarMedianaBurbuja();
		int mediana=0;
		if(numeros.size()%2==0) {
			mediana=(numeros.get(numeros.size()/2)+numeros.get((numeros.size()/2)+1))/2;
		}else {
			mediana=numeros.get((numeros.size()/2)+1);
		}
		return mediana;
	}

	private ArrayList ordenarMedianaBurbuja() {

		ArrayList<Integer> numeros =new ArrayList<Integer>();

		for(int i=0;i<personas.size();i++) {
			numeros.add(personas.get(i).getLikesRecibidos());
		}

		int n = numeros.size();
		int aux = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (numeros.get(j - 1) > numeros.get(j)) {
					aux = numeros.get(j-1);
					numeros.set(j-1, numeros.get(j));
					numeros.set(j,aux) ;

				}
			}
		}


		return numeros;
	}

	public String moda() {
		ArrayList<Integer> numeros = ordenarMedianaBurbuja();
		int tam =numeros.size();
		numeros.add(numeros.get(tam-1));
		ArrayList<Integer[]> parejas= new ArrayList();
		String moda = null;
		int cont=0;

		for(int i=0;i<tam;i++) {
			if(numeros.get(i)==numeros.get(i+1)) {
				cont++;
			}else {
				Integer[] aux= {numeros.get(i),cont+1};
				parejas.add(aux);
				cont=0;
			}

		}

		Integer[] aux= {numeros.get(tam),cont};
		parejas.add(aux);

		int mayor=parejas.get(0)[1];
		for(int i=0;i<parejas.size();i++){
			if(parejas.get(i)[1]>mayor){
				mayor=parejas.get(i)[1];
				moda=parejas.get(i)[0]+"";
			}else if(parejas.get(i)[1]==mayor) {
				moda=moda+" "+parejas.get(i)[0];
			}
		}

		return moda;
	}

	public ArrayList<Persona> getTop10Likes() {
		ArrayList <Persona> personasAux=ordenarLikesRInsercion();
		for(int i=0;i<10;i++) {
			top10Likes.add(personasAux.get(i));
		}
		return top10Likes;
	}

	public void setTop10Likes(ArrayList<Persona> top10Likes) {
		this.top10Likes = top10Likes;
	}

	private ArrayList ordenarLikesRInsercion() {
		ArrayList <Persona> personasAux=personas;
		Persona aux;	
		for (int i = 0; i < personasAux.size(); i++) {
			for (int j = i + 1; j < personasAux.size(); j++) {
				int v1=personasAux.get(i).getLikesRecibidos();
				int v2=personasAux.get(j).getLikesRecibidos();
				if (v1<v2) {
					aux = personasAux.get(i);
					personasAux.set(i, personasAux.get(j));
					personasAux.set(j, aux);
				}
			}
		}
		return personasAux;
	}

	public ArrayList <Persona> getMujeres(){
		for(int i=0;i<personas.size();i++) {
			if(personas.get(i).getGenero().equals("M")) {
				mujeres.add(personas.get(i));
			}
		}
		return mujeres;

	}

	public ArrayList <Persona> getHombres(){
		for(int i=0;i<personas.size();i++) {
			if(personas.get(i).getGenero().equals("H")) {
				hombres.add(personas.get(i));
			}
		}
		return hombres;

	}

	public ArrayList <Persona> getIngresos(){
		ArrayList <Persona> personasAux=getHombres();
		ArrayList <Persona> rta=new ArrayList();
		for(int i=0;i<personasAux.size();i++) {
			String s = personasAux.get(i).getIngresos().toString(); 
			s = s.replace(',', '.'); 
			double conv = Double.parseDouble(s);
			if(conv>=244.85) {
				rta.add(personasAux.get(i));
			}
		}
		return rta;
	}

	public String eliminarPersona(String alias) {
		String rta="No se encontr� este usuario";
		for(int i=0; i<personas.size();i++) {
			if(personas.get(i).getAlias().equalsIgnoreCase(alias)) {
				personas.remove(i);
				rta="Eliminado con �xito";
			}
		}

		return rta;
	}

	public void AumentarLike(int idSoltero, int idUsuarioActual) {
		personas.get(idSoltero).setLikesRecibidos(personas.get(idSoltero).getLikesRecibidos()+1);
		personas.get(idUsuarioActual).setLikesDados(personas.get(idUsuarioActual).getLikesDados()+1);
	}
	
	public boolean validarAlias(String pAlias) {
		boolean rta=true;
		for(int i=0;i<personas.size();i++) {
			if(personas.get(i).getAlias().equals(pAlias)) {
				rta=false;
			}
		}
		return rta;
	}
	
	public ArrayList datosNormalizados() {
		ArrayList rta=new ArrayList();
		int suma=0;
		int media=media();
		int sumaCuadrados=0;
		for(int i=0;i<personas.size();i++) {
			sumaCuadrados=((personas.get(i).getLikesRecibidos()-media)*(personas.get(i).getLikesRecibidos()-media));
			suma=suma+sumaCuadrados;
		}
		double destandar=Math.sqrt(suma/personas.size()-1);
		
		for(int i=0;i<personas.size();i++) {
			int parriba=Math.abs(personas.get(i).getLikesRecibidos()-media);
			rta.add(parriba/destandar);
		}
		return rta;
		
	}

	public JFreeChart graficas() throws IOException {
		DefaultCategoryDataset Datos = new DefaultCategoryDataset();
		JFreeChart Grafica;
		ArrayList<Double> aux =datosNormalizados();
		for(int i=0;i<aux.size();i++) {
		Datos.addValue(aux.get(i), "Cantidad de Likes", personas.get(i).getAlias());
		}

		Grafica = ChartFactory.createBarChart("Likes Recibidos", "Usuarios", "Likes", Datos,
				PlotOrientation.VERTICAL, true, true, false);
		return Grafica;
	}


	public void añadePorGenero(int auxId) {
		if(personas.get(auxId).getGenero().equals("H")) {
			hombres.add(personas.get(auxId));
		}else if(personas.get(auxId).getGenero().equals("M")) {
			mujeres.add(personas.get(auxId));
		}
		
	}
	
	public void exportarReportes(JPanel panel) {
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm");
		//print the panel to pdf
		Document document = new Document(PageSize.A4.rotate());
		
		try {
			String nombreFile="data/Informe_"+dtf2.format(LocalDateTime.now())+".pdf";
		    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(nombreFile));
		    document.open();
		    PdfContentByte contentByte = writer.getDirectContent();
		    PdfTemplate template = contentByte.createTemplate(784,400);
		    Graphics2D g2 = template.createGraphics(784,400);
		    panel.print(g2);
		    g2.dispose();
		    contentByte.addTemplate(template, 30, 180);
		    
		} catch (Exception e) {
//		    e.printStackTrace();
		}
		finally{
		    if(document.isOpen()){
		    	
		        document.close();
		    }
		}
	}


}
