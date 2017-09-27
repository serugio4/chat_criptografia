package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import controlador.Controlador;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelBotones extends JPanel implements ActionListener{
	
	JButton btnEnv;
	Controlador ctrl;
	PanelEnviar panelEnviar;
	JComboBox<String> cbx;
	
	
	public PanelBotones(Controlador ctrl, PanelEnviar panelEnviar) {
		// TODO Auto-generated constructor stub
		setBorder( new CompoundBorder( new EmptyBorder( 4, 4, 4, 4 ), new TitledBorder( " Botones " ) ) );
		setLayout(new GridLayout(2, 2));
		this.ctrl = ctrl;
		this.panelEnviar = panelEnviar;
		
		cbx = new JComboBox<>();
		
		btnEnv = new JButton("Enviar");
		btnEnv.setActionCommand("enviar");
		btnEnv.addActionListener(this);
		
		
		cbx.addItem("Seleccione algoritmo");
		
		cbx.addItem("Playfair");
		cbx.addItem("DES");
		cbx.addItem("RSA");
		cbx.addItem("AES");
		cbx.addItem("Reset");
		cbx.setSelectedIndex(0);
		
		cbx.addActionListener(this);
		
		
		
		add(btnEnv);
		add(cbx);
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String evento = e.getActionCommand();
		
		switch (evento) {
		case "enviar":
			ctrl.enviar();
			panelEnviar.setMensaje("");
			
		break;

		default:
			break;
		}
		
		if(cbx == e.getSource()){
			String evento1 = (String) cbx.getSelectedItem();
			if(evento1.equalsIgnoreCase("Playfair")){
				ctrl.generarMatriz();
				//ctrl.cifrar(panelEnviar.getMensaje());
			}
			else if(evento1.equalsIgnoreCase("DES")){
				ctrl.generarLlavesDes();
			}
			
		}
		
		
		
		
	}


	public String getCbx() {
		return (String) cbx.getSelectedItem();
	}

}
