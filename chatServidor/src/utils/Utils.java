package utils;

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
	
	
		
	public ArrayList<Integer> arrayCharacterToInt(ArrayList<Character> a) {
		
		ArrayList<Integer> toIntegers = new ArrayList<>();
		
		
		
		String temp="";
		temp+=a.get(0);
		temp+=a.get(a.size()-1);
		
		int num = Integer.parseInt(temp,2);
		
		toIntegers.add(num);
		
		temp="";
		temp+=a.get(1);
		temp+=a.get(2);
		temp+=a.get(3);
		temp+=a.get(4);
		
		num = Integer.parseInt(temp,2);
		
		toIntegers.add(num);
		
		return toIntegers;
	}
	
	public ArrayList<Character> decimalTobinary(int decimal){
		
		ArrayList<Character> listabinarios = new ArrayList<>();
		
		String temp =Integer.toBinaryString(decimal);
		
		
		for (int i = 0; i < temp.length(); i++) {
			
			listabinarios.add(temp.charAt(i));
		}
		
		while (listabinarios.size()<4) {
			listabinarios.add(0, '0');
			
		}
		return listabinarios;
	}

	public String decimalToBinaryToAscii(ArrayList<Character> mensaje){
		
		String mensajeString = "";
		String mensajeParte = "";
		String completo ="";
		
		for (int i = 0; i < mensaje.size(); i++) {
			mensajeString +=  mensaje.get(i);
		}
		mensajeParte = mensajeString;
		
		while(mensajeParte.length() > 0){			
			char caracter = (char) Integer.parseInt(mensajeParte.substring(0, 8), 2);
			mensajeParte = mensajeParte.substring(8);
			completo += caracter;
			
		}
		System.out.println(completo);
		
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
