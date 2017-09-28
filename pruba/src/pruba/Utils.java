package pruba;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Utils {
	
	public String arrayListToString(ArrayList<String> array){		
		String palabra ="";		
		for (int i = 0; i < array.size(); i++) {			
			palabra += array.get(i);			
		}
		System.out.println("Termine de cambiar");
		return palabra;

	}
	
	public ArrayList<String> stringToArray(String palabra){
		
		ArrayList<String> lista =  new ArrayList<>();
		
		for (int i = 0; i < palabra.length(); i++) {
			
			if((""+palabra.charAt(i)).equals("i")){				
				lista.add("ij");
				i++;				
			}
			else{
				lista.add(""+palabra.charAt(i));
			}


		}

		return lista;

	}
	
	
	public ArrayList<Integer> arrayCharToArrayInteger(ArrayList<Character> a){
		
		ArrayList<Integer> b = new ArrayList<>();
		String temp;
		for (int i = 0; i < a.size(); i++) {
			
			temp = a.get(i).toString();
			
			
			b.add(Integer.parseInt((temp)));
			
		}
		
		return b;
	}

	public ArrayList<Character> arrayIntegerToArrayChar(ArrayList<Integer> a){

		ArrayList<Character> b = new ArrayList<>();

		for (int i = 0; i < a.size(); i++) {

			b.add((Integer.toString(a.get(i))).charAt(0));

		}

		return b;
	}
	
	
		
	public ArrayList<Integer> binaryToInt(String a) {
		
		ArrayList<Integer> toIntegers = new ArrayList<>();		
		
		String temp="";
		temp+=a.charAt(0);
		temp+=a.charAt(a.length()-1);		
		int num = Integer.parseInt(temp,2);		
		toIntegers.add(num);		
		temp="";
		for (int i = 1; i < 5; i++) {
			temp+=a.charAt(i);
		}		
		num = Integer.parseInt(temp,2);
		
		toIntegers.add(num);
		
		return toIntegers;
	}
	
	public String decimalTobinary(int decimal){
		
		String listabinarios = "";
		
		listabinarios =Integer.toBinaryString(decimal);		
		
		while (listabinarios.length()<4) {
			listabinarios = '0'+listabinarios;			
		}
		
		return listabinarios;
	}

	public String decimalToBinaryToAscii(String mensaje){
		
		String mensajeParte = mensaje;
		String completo ="";		
		
		while(mensajeParte.length() > 0){			
			char caracter = (char) Integer.parseInt(mensajeParte.substring(0, 8), 2);
			mensajeParte = mensajeParte.substring(8);
			completo += caracter;
			
		}

		
		return completo;
	}
	
	
	
//	public static void main(String[] args) {
//		Utils u = new Utils();
//		
//		ArrayList<Character> c =  new ArrayList<>();
//		c.add('0');
//		c.add('1');
//		c.add('1');
//		c.add('0');
//		c.add('0');
//		c.add('0');
//		c.add('0');		
//		c.add('1');
//		c.add('0');
//		c.add('1');
//		c.add('1');
//		c.add('0');
//		c.add('0');
//		c.add('0');
//		c.add('0');		
//		c.add('1');
//		
//		u.decimalToBinaryToAscii(c);
//		
//	}
//	

}
