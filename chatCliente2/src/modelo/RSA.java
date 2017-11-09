package modelo;

import java.util.ArrayList;

public class RSA {
	
	private static final int P = 347;
	private static final int Q = 463;
	private static final int N = P*Q;
	private static final int TOTEMN = (P-1)*(Q-1);
	private static final int E = 277;
	private ArrayList<Integer> listaq =  new ArrayList<>(); 
	private int y = 0;
	
	public int algoritmoEuclides(int totem, int e){
		int x = e;
		int y  = totem;
		int yp = 0;
		int xp = 0;
		
		if(totem != 1 && e!=0){

			int aux = e;
			listaq.add(totem/e);
			e = totem % e;
			totem =  aux;
			algoritmoEuclides(totem, e);
			
		}else{	
		
			for (int i = listaq.size()-2 ; i >= 0 ; i--) {
				yp = y;
				xp = x;
				x = yp;
				y = xp-listaq.get(i)*yp;			
			}
			
			this.y = y;
			
		}

		return this.y;
	}
	
	public double powerMod(int key, double m, int n){
		
		String listabinarios = Integer.toBinaryString(key);
		double z = m;
		
		for (int i = 1; i < listabinarios.length(); i++) {
			if(listabinarios.charAt(i) =='1'){
				
				z = (Math.pow(z, 2)*m)%n;
			}else{
				z = Math.pow(z, 2)%n;
			}
			
		}
		
		return z; 
		
	}
	
	public String cifrarRsa(String mensaje){
		String cifrado ="";
		int ascii = 0;
		for (int i = 0; i < mensaje.length(); i++) {
			ascii = (int) mensaje.charAt(i);
			cifrado += powerMod(E, ascii, N)+",";
		}
		cifrado = cifrado.substring(0, cifrado.length()-1);
		return cifrado;
	}
	
	public String descifrarRsa(String mensaje){
		
		int p = algoritmoEuclides(TOTEMN, E);
		String []cifrado = mensaje.split(","); 
		
		String descifrado = "";
		for (int i = 0; i < cifrado.length; i++) {
			
			descifrado += (char) powerMod(p, Double.parseDouble(cifrado[i]), N);
		}
	
		return descifrado;
		
		
	}
	
	public void resetQ(){
		this.listaq = new ArrayList<>();
	}
	
	/*public static void main(String[] args) {
		RSA r = new RSA();
		//System.out.println(TOTEMN);
		//System.out.println(r.powerMod(E, 24501, N));
		//System.out.println(r.algoritmoEuclides(TOTEMN, E));
		
		
		//System.out.println(r.cifrarRsa("Hola"));
		System.out.println(r.descifrarRsa(r.cifrarRsa("Hola")));
		
	}*/
	
	

}
