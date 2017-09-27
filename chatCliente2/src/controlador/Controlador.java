package controlador;
import vista.PanelBotones;
import vista.PanelEnviar;

import java.util.ArrayList;

import modelo.*;
import utils.Utils;

public class Controlador {

	PanelEnviar panelEnviar;
	Conexion conexion;
	PlayFair playFair;
	Utils util;
	String matriz [][];
	PanelBotones panelBotones;
	Des des;
	ArrayList<ArrayList> llavesDes;

	public Controlador() {
		// TODO Auto-generated constructor stub

		conexion = new Conexion(this);
		conexion.start();
		playFair = new PlayFair();
		util = new Utils();
		des = new Des();
		llavesDes = new ArrayList<>();

	}


	public void conectar(PanelEnviar panelEnviar,PanelBotones panelBotones) {
		this.panelEnviar = panelEnviar;
		this.panelBotones = panelBotones;

	}

	public void enviar(){

		
		System.out.println(panelBotones.getCbx());
		if(panelBotones.getCbx().equalsIgnoreCase("Playfair")){
			ArrayList<String> a = playFair.cifrar(matriz, panelEnviar.getMensaje());
			panelEnviar.setCifrado(util.arrayListToString(a));
			panelEnviar.setConversacion("Yo: "+ panelEnviar.getCifrado());
			conexion.enviarMensaje(panelEnviar.getCifrado(), 1);
		}
		else if (panelBotones.getCbx().equalsIgnoreCase("DES")) {
			panelEnviar.setCifrado(cifrarDes(panelEnviar.getMensaje()));
			panelEnviar.setConversacion("Yo: "+ panelEnviar.getCifrado());
			conexion.enviarMensaje(panelEnviar.getCifrado(), 2);			

		}
		else if (panelBotones.getCbx().equalsIgnoreCase("AES")) {
			panelEnviar.setCifrado(cifrarAes());
			panelEnviar.setConversacion("Yo: "+ panelEnviar.getCifrado());
			conexion.enviarMensaje(panelEnviar.getCifrado(), 3);			

		}

	}

	public void mensajeRecibido (String mensaje){		
		panelEnviar.setCifrado(mensaje);		
	}


	public void generarMatriz(){
		matriz = playFair.crearMatriz("sergio");
	}

	public void descifrar(String palabra, String ip){

		generarMatriz();
		panelEnviar.setConversacion(ip+": "+util.arrayListToString(
				playFair.descifrar(matriz, util.stringToArray((palabra)))));		

	}

	public void algoritmoMensaje(String mensaje, String ip){
		char primero = mensaje.charAt(0);
		if(primero == '1'){			
			descifrar(mensaje.substring(1), ip);			
			mensajeRecibido(ip+": "+mensaje.substring(1));
		}
		else if(primero == '2') {
			panelEnviar.setConversacion(ip +": "+descifrarDes(mensaje.substring(1)));
			panelEnviar.setCifrado(mensaje.substring(1));
			
		}
		else if(primero =='3') {
			panelEnviar.setConversacion((ip + ": "+descifrarAes(mensaje.substring(1))));
			panelEnviar.setCifrado(ip + ": "+ mensaje.substring(1));
		}
	}
	
	public void generarLlavesDes() {
		
		this.llavesDes =des.crearLlavesCompleto("aBcDeFgH");
		
	}
	
	public String cifrarDes(String mensaje) {
		
		return des.cifrarDes(mensaje, llavesDes);
		
	}
	
	public String cifrarAes() {
		
		
		 String key = "92AE31A79FEEB2A3"; //llave
		 String iv = "0123456789ABCDEF"; // vector de inicialización
		 String cleartext = panelEnviar.getMensaje();
		 String cifrado = "";
		 try {
			cifrado = modelo.StringEncrypt.encrypt(key, iv,cleartext);
			System.out.println("Texto encriptado: "+modelo.StringEncrypt.encrypt(key, iv,cleartext));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return cifrado;
		 
	}
	
	public String descifrarAes(String cifrado) {
		
		String key = "92AE31A79FEEB2A3"; //llave
		String iv = "0123456789ABCDEF"; // vector de inicialización
		String descifrado = "";
		try {
			descifrado = modelo.StringEncrypt.decrypt(key, iv,cifrado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return descifrado;
	}
	
	public String descifrarDes(String mensaje){
		
		System.out.println("Entre a descifrar DES");
		ArrayList<Character> array = des.descifrar(mensaje, llavesDes);		
		String mensaje2 = util.decimalToBinaryToAscii(array);
		
		return mensaje2;
		
	}
	
	


}
