package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import utils.*;



public class PlayFair {

	public String [][] crearMatriz(String palabra){
		
		// Se crea un arreglo con las letras del alfabeto
		ArrayList<String> alfabeto = new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g","h",
				"ij","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));	

		//se crea la matriz
		String [][] matriz = new String [5][5];
		
		//se convierte la clave en una arreglo de chars
		char[] arregloPalabra = palabra.toCharArray();
		ArrayList<Character> letrasUsadas = new ArrayList<>();

		//se inicializan contadores que se usarn mas adelnate
		int contFila = 0;
		int contColm = 0;

		/*Se agregara la clave a la matriz y los caracteres de la 
		 * clave seran removidos del alfabeto
		 */
		for (int i = 0; i < arregloPalabra.length; i++) {


			if (contColm>4){
				contFila ++;
				contColm = 0;
			}

			if(letrasUsadas.contains(arregloPalabra[i])==false){
				
				if((""+arregloPalabra[i]).equalsIgnoreCase("i") ||(""+arregloPalabra[i]).equalsIgnoreCase("j") ){					
					matriz[contFila][contColm] ="ij";
					letrasUsadas.add('i');
					letrasUsadas.add('j');
					alfabeto.remove("ij");

				}
				else{

					matriz[contFila][contColm] = ""+arregloPalabra[i];
					letrasUsadas.add(arregloPalabra[i]);
					alfabeto.remove(""+arregloPalabra[i]);


				}
				contColm ++;
			}


		}

		//Se completa la matriz con los caracteres restantes del alfabeto
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {

				if (matriz[i][j]==null){

					matriz[i][j] = alfabeto.get(0);
					alfabeto.remove(0);					

				}
			}

		}
		
		//Imprimir matriz
		for (int i = 0; i < matriz.length; i++) {
			System.out.println();
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j]+", ");
			}
		}

		return matriz;

	}

	//Este metodo se usa para remover espacios de la cadena ingresada
	public String quitarEspacios (String frase){
		System.out.println("Estoy en quitar espacios");
		String [] frasePartida = frase.split(" ");
		String fraseJunta = "";		
		for (int i = 0; i < frasePartida.length; i++) {			
			fraseJunta += frasePartida[i];
		}		

		return fraseJunta;

	}

	/*Se necesita partir el texto en parejas de caracteres.
	 * Posteriormente se compara si los dos caracteres de la pareja
	 * son el mismo, en caso afirmativo se introduce una x en la mitad de estos,
	 * de lo contrario la pareja se deja igual
	 */
	public String xEnLaMitad(String cadena){
		System.out.println("Estoy en quitar x");
		String temp1,temp2, cadenaFinal = "";		
		for (int i = 0; i < cadena.length(); i+=2) {			
			temp1=""+cadena.charAt(i);
			if(i != cadena.length()-1){
				temp2=""+cadena.charAt(i+1);
			}
			else{
				temp2="";
			}	

			if(temp1.equalsIgnoreCase(temp2)){				
				cadenaFinal += temp1+"x"+temp2;				
			}
			else{
				cadenaFinal+=temp1+temp2;
			}			
		}		
		return cadenaFinal;
	}

	//llama los metodos quitarEspacios y xEnLaMitad para dejar listo el mensaje para cifrar
	public String prepararMensaje(String cadena){

		cadena = xEnLaMitad(quitarEspacios(cadena));

		if(cadena.length()%2!=0){			
			cadena = cadena.concat("x");		
		}

		return cadena;		


	}

	public ArrayList<String> cifrar(String [][] matriz ,String cadena){
		
		cadena = prepararMensaje(cadena);
		String temp1,temp2;
		ArrayList<String> textoCifrado = new ArrayList<>();
		int posTemp1Fila = 0,posTemp1Col = 0,posTemp2Fila = 0,posTemp2Col = 0;

		//for para recorerar la cadena
		for (int i = 0; i < cadena.length(); i+=2) {
			temp1 = ""+cadena.charAt(i);
			temp2 = ""+cadena.charAt(i+1);

			//for para buscar las posicion de los caracteres
			for (int j = 0; j < matriz.length; j++) {
				for (int k = 0; k < matriz.length; k++) {

					//guardar posicion del caracter 1
					if(matriz[j][k].equalsIgnoreCase(temp1) || 
							(matriz[j][k].equalsIgnoreCase("ij") && 
									(temp1.equalsIgnoreCase("i")|| temp1.equalsIgnoreCase("j")))){
						
						posTemp1Fila = j;
						posTemp1Col = k;
					}
					//guardar posicion del caracter 2
					else if(matriz[j][k].equalsIgnoreCase(temp2) || 
							(matriz[j][k].equalsIgnoreCase("ij") && 
									(temp2.equalsIgnoreCase("i")|| temp2.equalsIgnoreCase("j")))){
						posTemp2Fila = j;
						posTemp2Col = k;
					}

				}
			}

			//correr a la derecha si estan en la misma fila
			if(posTemp1Fila==posTemp2Fila){

				/*si el primer caracter esta en la ultima columna de la fila
				 * se intercambia por la primera
				 */
				if(posTemp1Col == matriz.length-1 ){

					textoCifrado.add(matriz[posTemp1Fila][0]);

				}
				else{

					textoCifrado.add(matriz[posTemp1Fila][posTemp1Col+1]);

				}

				if(posTemp2Col == matriz.length-1 ){

					textoCifrado.add(matriz[posTemp2Fila][0]);

				}
				else{

					textoCifrado.add(matriz[posTemp2Fila][posTemp2Col+1]);

				}

			}

			//corrar hacia abajo si estan en la misma columna
			else if(posTemp2Col == posTemp1Col){

				if(posTemp1Fila == matriz.length-1){

					textoCifrado.add(matriz[0][posTemp1Col]);

				}
				else{

					textoCifrado.add(matriz[posTemp1Fila+1][posTemp1Col]);

				}

				if(posTemp2Fila == matriz.length-1){

					textoCifrado.add(matriz[0][posTemp2Col]);

				}
				else{

					textoCifrado.add(matriz[posTemp2Fila+1][posTemp2Col]);

				}

			}
			else{
				//se agrega primero el temp1
				textoCifrado.add(matriz[posTemp1Fila][posTemp2Col]);
				//se agrega el temp2
				textoCifrado.add(matriz[posTemp2Fila][posTemp1Col]);
				
			}



		}
		
		System.out.println("Termine de cifrar");
		return textoCifrado;

	}
	
	public ArrayList<String> descifrar(String [][] matriz , ArrayList<String> cadena){
		
		String temp1,temp2;
		int posTemp1Fila = 0,posTemp1Col = 0,posTemp2Fila = 0,posTemp2Col = 0;
		ArrayList<String> textoDescifrado = new ArrayList<>();

		//for para recorerar la cadena
		for (int i = 0; i < cadena.size(); i+=2) {
			temp1 = ""+cadena.get(i);
			temp2 = ""+cadena.get(i+1);

			//for para buscar las posicion de los caracteres
			for (int j = 0; j < matriz.length; j++) {
				for (int k = 0; k < matriz.length; k++) {

					//guardar posicion del caracter 1
					if(matriz[j][k].equalsIgnoreCase(temp1) || 
							(matriz[j][k].equalsIgnoreCase("ij") && 
									(temp1.equalsIgnoreCase("i")|| temp1.equalsIgnoreCase("j")))){
						
						posTemp1Fila = j;
						posTemp1Col = k;
					}
					//guardar posicion del caracter 2
					else if(matriz[j][k].equalsIgnoreCase(temp2) || 
							(matriz[j][k].equalsIgnoreCase("ij") && 
									(temp2.equalsIgnoreCase("i")|| temp2.equalsIgnoreCase("j")))){
						posTemp2Fila = j;
						posTemp2Col = k;
					}

				}
			}
			
			if(posTemp1Fila==posTemp2Fila){

				/*si el primer caracter esta en la primera columna de la fila
				 * se intercambia por la ultima
				 */
				if(posTemp1Col == 0 ){

					textoDescifrado.add(matriz[posTemp1Fila][4]);

				}
				else{

					textoDescifrado.add(matriz[posTemp1Fila][posTemp1Col-1]);

				}

				if(posTemp2Col == 0 ){

					textoDescifrado.add(matriz[posTemp2Fila][4]);

				}
				else{

					textoDescifrado.add(matriz[posTemp2Fila][posTemp2Col-1]);

				}

			}
			//corrar hacia arriba si estan en la misma columna
			else if(posTemp2Col == posTemp1Col){

				if(posTemp1Fila == 0){

					textoDescifrado.add(matriz[4][posTemp1Col]);

				}
				else{

					textoDescifrado.add(matriz[posTemp1Fila-1][posTemp1Col]);

				}

				if(posTemp2Fila == 0){

					textoDescifrado.add(matriz[4][posTemp2Col]);

				}
				else{

					textoDescifrado.add(matriz[posTemp2Fila-1][posTemp2Col]);

				}

			}else{
				//se agrega primero el temp1
				textoDescifrado.add(matriz[posTemp1Fila][posTemp2Col]);
				//se agrega el temp2
				textoDescifrado.add(matriz[posTemp2Fila][posTemp1Col]);
				
			}
		
		}
		
		return textoDescifrado;
	}

//	public static void main(String[] args) {
//		PlayFair crear = new PlayFair();
//		Utils util = new Utils();
//	    String matriz1 [][]= crear.crearMatriz("yoanpinzon");	   
//	    ArrayList<String> cifrado = crear.cifrar(matriz1, "this secret message is encrypted");
//	    System.out.println(util.arrayListToString(crear.descifrar(matriz1, cifrado)));
//	    
//	}

}
