package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelEnviar extends JPanel {
	
	JTextField mensaje, mensajeCifrado;
	JTextArea conversacion;
	JLabel chat, historial, cifrado;
	JButton btnEnviar, btnCifrar, btnDescifrar;
	
	public PanelEnviar() {
		// TODO Auto-generated constructor stub
		
		setLayout(new GridLayout(6, 1));
		
		mensajeCifrado = new JTextField();
		chat = new JLabel("Chat");
		cifrado = new JLabel("Menseje cifrado");
		historial = new JLabel("historial");
		conversacion = new JTextArea();
		mensaje = new JTextField(20);
		
		setBorder( new CompoundBorder( new EmptyBorder( 4, 4, 4, 4 ), new TitledBorder( " Chat " ) ) );
		
		
		add(historial);
		add(conversacion);
		add(cifrado);
		add(mensajeCifrado);
		add(chat);
		add(mensaje);
		
		
		setVisible(true);
	}
	
	public void setConversacion(String conversacion) {
		this.conversacion.append(("\n"+conversacion));
		
	}
	
	public String getMensaje() {
		return mensaje.getText();
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje.setText(mensaje);
	}

	public String getCifrado() {
		return mensajeCifrado.getText();
	}
	
	public void setCifrado(String mensaje) {
		this.mensajeCifrado.setText(mensaje);
	}

	
}
