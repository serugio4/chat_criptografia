package modelo;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import controlador.Controlador;

public class Conexion extends Thread implements Runnable {


	private final int PUERTO= 2000;
	private final String HOST = "localhost";
	private Socket socket;	
	private DataOutputStream salida;
	private DataInputStream entrada;
	private Controlador ctrl;
	private String mensajeAEnviar;
	//private Thread hilo;



	public Conexion (Controlador ctrl) {		

		try {	
			
			socket = new Socket(HOST,PUERTO);
			this.ctrl = ctrl;
			System.out.println("serversocket creado");



		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("ha ocurrido el error "+  e.getMessage());
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			
			System.out.println("conexion aceptada");

			entrada = new DataInputStream(socket.getInputStream());
			salida = new DataOutputStream(socket.getOutputStream());


			while(true){
				
				leerMensaje();
				
				//entrada.close();
				//salida.close();

			
			}


		} catch (IOException e) {

			System.out.println("ha ocurrido el error "+  e.getMessage());
		}

	}

	
	
	public void enviarMensaje(String mensaje, int algoritmo){	
		
		 try {
			 
			salida.writeUTF(algoritmo+mensaje);
			
		} catch (IOException e) {
			
			System.out.println("Ha ocurrido el error: " + e.getMessage());
		}
	}
	
	public void leerMensaje() {
		try {
			System.out.println("Estoy leyendo");
			ctrl.algoritmoMensaje(entrada.readUTF(), ""+socket.getInetAddress());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	public void setMensajeAEnviar(String mensajeAEnviar) {
		this.mensajeAEnviar = mensajeAEnviar;
	}
	public String getMensajeAEnviar() {
		return mensajeAEnviar;
	}

}
