package vista;

import java.awt.BorderLayout;
import controlador.*;

import javax.swing.JFrame;

public class VentanaChat extends JFrame {
	
	PanelEnviar panelEnviar;
	PanelBotones panelBtn;
	Controlador ctrl;
	
	
	
	public VentanaChat(Controlador ctrl) {
		
		this.ctrl = ctrl;
		
		panelEnviar = new PanelEnviar();
		panelBtn = new PanelBotones(ctrl, panelEnviar);
		
		setSize(1000, 500);
		setTitle("Chat Cliente");
		setLayout(new BorderLayout());
		setResizable(true);
		setLocationRelativeTo(null);
				
		add(panelEnviar, BorderLayout.CENTER);
		add(panelBtn,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.ctrl.conectar(panelEnviar, panelBtn);
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		VentanaChat ventanaChat = new VentanaChat(new Controlador());
		ventanaChat.setVisible(true);
	
		
	}
	

}
