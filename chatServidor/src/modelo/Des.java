package modelo;

import java.awt.List;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

import utils.Utils;

/**
 *  Contiene los métodos necesarios para la implementación del algoritmo DES para encriptación de mensajes
 * @author sergio garcia y jose alvarez
 * @version 1.0
 * 
 *
 */
public class Des {
	Utils utils = new Utils();
	/**
	 * convierte un String a la representación en ASCII de cada caracter
	 * 
	 * @param cadena
	 * @return en un arrayList la representación en ASCII de cada caracter
	 */
	public ArrayList<Integer> stringToAscii(String cadena) {

		char[] arreglo = cadena.toCharArray();
		ArrayList<Integer> arrayAscii = new ArrayList<>();
		for (char c : arreglo) {

			arrayAscii.add((int)c);

		}

		return arrayAscii;

	}

	public ArrayList<String> asciiToBinary(ArrayList<Integer> cadena){

		ArrayList<String> arrayBinario = new ArrayList<String>();;
		String temp;
		char[] tempChar;
		for (Integer num : cadena) {

			arrayBinario.add(Integer.toBinaryString(num));
		}




		return arrayBinario;
	}

	public ArrayList<String> completarCeros(ArrayList<String> cadena) {

		String temp;
		for (int i =0; i<cadena.size(); i++) {
			temp= cadena.get(i);
			while(temp.length()<8) {
				temp =0+temp;
			}

			cadena.set(i, temp);

		}

		return cadena;
	}

	public ArrayList<Character> stringArrayToCharArray(ArrayList<String> cadena) {

		ArrayList<Character> characterArray= new ArrayList<>();;
		char[] temp;

		for (String c : cadena) {

			temp = c.toCharArray();

			for(int i=0; i<c.length(); i++) {

				characterArray.add(temp[i]);

			}
		}

		return characterArray;
	}

	public ArrayList<Character> completarBitsParaClave(String cadena){

		ArrayList<Character> claveLista = new ArrayList<>();

		claveLista= stringArrayToCharArray(completarCeros(asciiToBinary(stringToAscii(cadena))));

		while (claveLista.size()<64) {

			claveLista.add('0');

		}

		return claveLista;
	}


	public ArrayList<Character> pc1(ArrayList<Character> clave){

		ArrayList<Character> clavePermutada = new ArrayList<>();


		clavePermutada.add(clave.get(56)); clavePermutada.add(clave.get(48)); clavePermutada.add(clave.get(40));
		clavePermutada.add(clave.get(32)); clavePermutada.add(clave.get(24)); clavePermutada.add(clave.get(16));
		clavePermutada.add(clave.get(8)); clavePermutada.add(clave.get(0)); clavePermutada.add(clave.get(57));
		clavePermutada.add(clave.get(49)); clavePermutada.add(clave.get(41)); clavePermutada.add(clave.get(33));
		clavePermutada.add(clave.get(25)); clavePermutada.add(clave.get(17)); clavePermutada.add(clave.get(9));
		clavePermutada.add(clave.get(1)); clavePermutada.add(clave.get(58)); clavePermutada.add(clave.get(50));
		clavePermutada.add(clave.get(42)); clavePermutada.add(clave.get(34)); clavePermutada.add(clave.get(26));
		clavePermutada.add(clave.get(18)); clavePermutada.add(clave.get(10)); clavePermutada.add(clave.get(2));
		clavePermutada.add(clave.get(59)); clavePermutada.add(clave.get(51)); clavePermutada.add(clave.get(43));
		clavePermutada.add(clave.get(35)); clavePermutada.add(clave.get(62)); clavePermutada.add(clave.get(54));
		clavePermutada.add(clave.get(46)); clavePermutada.add(clave.get(38)); clavePermutada.add(clave.get(30));
		clavePermutada.add(clave.get(22)); clavePermutada.add(clave.get(14)); clavePermutada.add(clave.get(6));
		clavePermutada.add(clave.get(61)); clavePermutada.add(clave.get(53)); clavePermutada.add(clave.get(45));
		clavePermutada.add(clave.get(37)); clavePermutada.add(clave.get(29)); clavePermutada.add(clave.get(21));
		clavePermutada.add(clave.get(13)); clavePermutada.add(clave.get(5)); clavePermutada.add(clave.get(60));
		clavePermutada.add(clave.get(52)); clavePermutada.add(clave.get(44)); clavePermutada.add(clave.get(36));
		clavePermutada.add(clave.get(28)); clavePermutada.add(clave.get(20)); clavePermutada.add(clave.get(12)); 
		clavePermutada.add(clave.get(4)); clavePermutada.add(clave.get(27)); clavePermutada.add(clave.get(19)); 
		clavePermutada.add(clave.get(11)); clavePermutada.add(clave.get(3));


		return clavePermutada;
	}

	public ArrayList<Character> divParteIzquierda(ArrayList<Character> key){

		ArrayList<Character> parteIzq = new ArrayList<>();

		for (int i = 0; i < 28; i++) {

			parteIzq.add(key.get(i));

		}


		return parteIzq;
	}

	public ArrayList<Character> divParteDerecha(ArrayList<Character> key){

		ArrayList<Character> parteDer = new ArrayList<>();

		for (int i = 28; i < key.size(); i++) {

			parteDer.add(key.get(i));

		}


		return parteDer;
	}

	public ArrayList<Character> funcionLs(ArrayList<Character> parteKey, int numeroIteracion){

		ArrayList<Character> despuesDeAplicarLs = new ArrayList<>();

		for (int i = 0; i < parteKey.size(); i++) {
			despuesDeAplicarLs.add(parteKey.get(i));

		}

		if(numeroIteracion==1 || numeroIteracion==2 || numeroIteracion==9 || numeroIteracion==16) {

			despuesDeAplicarLs.remove(0);
			despuesDeAplicarLs.add(parteKey.get(0));

		}

		else if (numeroIteracion==3 || numeroIteracion==4 || numeroIteracion==5 || numeroIteracion==6 ||
				numeroIteracion==7 || numeroIteracion==8 || numeroIteracion==10 || numeroIteracion==11 || 
				numeroIteracion==12 || numeroIteracion==13 || numeroIteracion==14 || numeroIteracion==15){

			despuesDeAplicarLs.remove(0);
			despuesDeAplicarLs.remove(0);
			despuesDeAplicarLs.add(parteKey.get(0));
			despuesDeAplicarLs.add(parteKey.get(1));
		}


		return despuesDeAplicarLs;
	}

	public ArrayList<ArrayList> crearPartesLlaves(ArrayList<Character> parte){

		ArrayList<ArrayList> llaves = new ArrayList<>();

		llaves.add(funcionLs(parte, 1));


		for (int i = 2; i <= 16; i++) {

			llaves.add(funcionLs(llaves.get(i-2),i));

		}



		return llaves;
	}

	public ArrayList<Character> pc2(ArrayList<Character> clavesIzq, ArrayList<Character> clavesDer){

		ArrayList<Character> claveFinal = new ArrayList<>();

		ArrayList<Character> unionClaves= new ArrayList<>();

		for (int i = 0; i < clavesIzq.size(); i++) {
			unionClaves.add(clavesIzq.get(i));
		}
		for (int i = 0; i < clavesDer.size(); i++) {
			unionClaves.add(clavesDer.get(i));
		}

		claveFinal.add(unionClaves.get(13));	claveFinal.add(unionClaves.get(16));
		claveFinal.add(unionClaves.get(10));	claveFinal.add(unionClaves.get(23));
		claveFinal.add(unionClaves.get(0));		claveFinal.add(unionClaves.get(4));

		claveFinal.add(unionClaves.get(2));		claveFinal.add(unionClaves.get(27));
		claveFinal.add(unionClaves.get(14));	claveFinal.add(unionClaves.get(5));
		claveFinal.add(unionClaves.get(20));	claveFinal.add(unionClaves.get(9));

		claveFinal.add(unionClaves.get(22));	claveFinal.add(unionClaves.get(18));
		claveFinal.add(unionClaves.get(11));	claveFinal.add(unionClaves.get(3));
		claveFinal.add(unionClaves.get(25));	claveFinal.add(unionClaves.get(7));

		claveFinal.add(unionClaves.get(15));	claveFinal.add(unionClaves.get(6));
		claveFinal.add(unionClaves.get(26));	claveFinal.add(unionClaves.get(19));
		claveFinal.add(unionClaves.get(12));	claveFinal.add(unionClaves.get(1));

		claveFinal.add(unionClaves.get(40));	claveFinal.add(unionClaves.get(51));
		claveFinal.add(unionClaves.get(30));	claveFinal.add(unionClaves.get(36));
		claveFinal.add(unionClaves.get(46));	claveFinal.add(unionClaves.get(54));

		claveFinal.add(unionClaves.get(29));	claveFinal.add(unionClaves.get(39));
		claveFinal.add(unionClaves.get(50));	claveFinal.add(unionClaves.get(44));
		claveFinal.add(unionClaves.get(32));	claveFinal.add(unionClaves.get(47));

		claveFinal.add(unionClaves.get(43));	claveFinal.add(unionClaves.get(48));
		claveFinal.add(unionClaves.get(38));	claveFinal.add(unionClaves.get(55));
		claveFinal.add(unionClaves.get(33));	claveFinal.add(unionClaves.get(52));

		claveFinal.add(unionClaves.get(45));	claveFinal.add(unionClaves.get(41));
		claveFinal.add(unionClaves.get(49));	claveFinal.add(unionClaves.get(35));
		claveFinal.add(unionClaves.get(28));	claveFinal.add(unionClaves.get(31));

		return claveFinal;
	}

	public ArrayList<ArrayList> crearLlavesFinales(ArrayList<ArrayList> llavesIzq, ArrayList<ArrayList> llavesDer){

		ArrayList<ArrayList> llavesFinales= new ArrayList<>();

		for(int i =0; i<16; i++) {

			llavesFinales.add(pc2(llavesIzq.get(i), llavesDer.get(i)));
		}


		return llavesFinales;
	}

	public ArrayList<ArrayList> crearLlavesCompleto(String clave){

		ArrayList<ArrayList> llavesIzq = crearPartesLlaves(divParteIzquierda(pc1(completarBitsParaClave(clave))));
		ArrayList<ArrayList> llavesDer = crearPartesLlaves(divParteDerecha(pc1(completarBitsParaClave(clave))));


		return crearLlavesFinales(llavesIzq, llavesDer);
	}


	public ArrayList<Character> ip(ArrayList<Character> mensajeInicial){

		ArrayList<Character> despuesIp = new ArrayList<>();


		despuesIp.add(mensajeInicial.get(57));	despuesIp.add(mensajeInicial.get(49));
		despuesIp.add(mensajeInicial.get(41));	despuesIp.add(mensajeInicial.get(33));
		despuesIp.add(mensajeInicial.get(25));	despuesIp.add(mensajeInicial.get(17));
		despuesIp.add(mensajeInicial.get(9));	despuesIp.add(mensajeInicial.get(1));
		despuesIp.add(mensajeInicial.get(59));	despuesIp.add(mensajeInicial.get(51));
		despuesIp.add(mensajeInicial.get(43));	despuesIp.add(mensajeInicial.get(35));
		despuesIp.add(mensajeInicial.get(27));	despuesIp.add(mensajeInicial.get(19));
		despuesIp.add(mensajeInicial.get(11));	despuesIp.add(mensajeInicial.get(3));
		despuesIp.add(mensajeInicial.get(61));	despuesIp.add(mensajeInicial.get(53));
		despuesIp.add(mensajeInicial.get(45));	despuesIp.add(mensajeInicial.get(37));
		despuesIp.add(mensajeInicial.get(29));	despuesIp.add(mensajeInicial.get(21));
		despuesIp.add(mensajeInicial.get(13));	despuesIp.add(mensajeInicial.get(5));
		despuesIp.add(mensajeInicial.get(63));	despuesIp.add(mensajeInicial.get(55));
		despuesIp.add(mensajeInicial.get(47));	despuesIp.add(mensajeInicial.get(39));
		despuesIp.add(mensajeInicial.get(31));	despuesIp.add(mensajeInicial.get(23));
		despuesIp.add(mensajeInicial.get(15));	despuesIp.add(mensajeInicial.get(7));
		despuesIp.add(mensajeInicial.get(56));	despuesIp.add(mensajeInicial.get(48));
		despuesIp.add(mensajeInicial.get(40));	despuesIp.add(mensajeInicial.get(32));
		despuesIp.add(mensajeInicial.get(24));	despuesIp.add(mensajeInicial.get(16));
		despuesIp.add(mensajeInicial.get(8));	despuesIp.add(mensajeInicial.get(0));
		despuesIp.add(mensajeInicial.get(58));	despuesIp.add(mensajeInicial.get(50));
		despuesIp.add(mensajeInicial.get(42));	despuesIp.add(mensajeInicial.get(34));
		despuesIp.add(mensajeInicial.get(26));	despuesIp.add(mensajeInicial.get(18));
		despuesIp.add(mensajeInicial.get(10));	despuesIp.add(mensajeInicial.get(2));
		despuesIp.add(mensajeInicial.get(60));	despuesIp.add(mensajeInicial.get(52));
		despuesIp.add(mensajeInicial.get(44));	despuesIp.add(mensajeInicial.get(36));
		despuesIp.add(mensajeInicial.get(28));	despuesIp.add(mensajeInicial.get(20));
		despuesIp.add(mensajeInicial.get(12));	despuesIp.add(mensajeInicial.get(4));
		despuesIp.add(mensajeInicial.get(62));	despuesIp.add(mensajeInicial.get(54));
		despuesIp.add(mensajeInicial.get(46));	despuesIp.add(mensajeInicial.get(38));
		despuesIp.add(mensajeInicial.get(30));	despuesIp.add(mensajeInicial.get(22));
		despuesIp.add(mensajeInicial.get(14));	despuesIp.add(mensajeInicial.get(6));


		return despuesIp;
	}
	
	

	public ArrayList<Character> despuesIpPartirenDos(ArrayList<Character> despuesIp, int desde, int hasta){

		ArrayList<Character> pedazo = new ArrayList<>(despuesIp.subList(desde, hasta));

		return pedazo;
	}

	public ArrayList<Character> funcionExpansionE(ArrayList<Character> parteDer){

		ArrayList<Character> parteDerExpandida = new ArrayList<>();

		parteDerExpandida.add(parteDer.get(31)); 		parteDerExpandida.add(parteDer.get(0));
		parteDerExpandida.add(parteDer.get(1)); 		parteDerExpandida.add(parteDer.get(2));
		parteDerExpandida.add(parteDer.get(3)); 		parteDerExpandida.add(parteDer.get(4));
		parteDerExpandida.add(parteDer.get(3)); 		parteDerExpandida.add(parteDer.get(4));
		parteDerExpandida.add(parteDer.get(5)); 		parteDerExpandida.add(parteDer.get(6));
		parteDerExpandida.add(parteDer.get(7)); 		parteDerExpandida.add(parteDer.get(8));
		parteDerExpandida.add(parteDer.get(7)); 		parteDerExpandida.add(parteDer.get(8));
		parteDerExpandida.add(parteDer.get(9)); 		parteDerExpandida.add(parteDer.get(10));
		parteDerExpandida.add(parteDer.get(11)); 		parteDerExpandida.add(parteDer.get(12));
		parteDerExpandida.add(parteDer.get(11)); 		parteDerExpandida.add(parteDer.get(12));
		parteDerExpandida.add(parteDer.get(13)); 		parteDerExpandida.add(parteDer.get(14));
		parteDerExpandida.add(parteDer.get(15)); 		parteDerExpandida.add(parteDer.get(16));
		parteDerExpandida.add(parteDer.get(15)); 		parteDerExpandida.add(parteDer.get(16));
		parteDerExpandida.add(parteDer.get(17)); 		parteDerExpandida.add(parteDer.get(18));
		parteDerExpandida.add(parteDer.get(19)); 		parteDerExpandida.add(parteDer.get(20));
		parteDerExpandida.add(parteDer.get(19)); 		parteDerExpandida.add(parteDer.get(20));
		parteDerExpandida.add(parteDer.get(21)); 		parteDerExpandida.add(parteDer.get(22));
		parteDerExpandida.add(parteDer.get(23)); 		parteDerExpandida.add(parteDer.get(24));
		parteDerExpandida.add(parteDer.get(23)); 		parteDerExpandida.add(parteDer.get(24));
		parteDerExpandida.add(parteDer.get(25)); 		parteDerExpandida.add(parteDer.get(26));
		parteDerExpandida.add(parteDer.get(27)); 		parteDerExpandida.add(parteDer.get(28));
		parteDerExpandida.add(parteDer.get(27)); 		parteDerExpandida.add(parteDer.get(28));
		parteDerExpandida.add(parteDer.get(29)); 		parteDerExpandida.add(parteDer.get(30));
		parteDerExpandida.add(parteDer.get(31)); 		parteDerExpandida.add(parteDer.get(0));


		return parteDerExpandida;
	}

	public ArrayList<Character> funcionXor(ArrayList<Character> a, ArrayList<Character> b){

		ArrayList<Character> despuesDeXor = new ArrayList<>();
		char temp;
		for (int i = 0; i < a.size(); i++) {
			int cosa =(a.get(i)^b.get(i));
			temp = Character.forDigit(cosa, 10);
			despuesDeXor.add(temp);
		}

		return despuesDeXor;
	}

	public ArrayList<ArrayList> dividirEnSeis(ArrayList<Character> despuesXor){

		ArrayList<ArrayList> listaPedazosDe6 = new ArrayList<>();
		ArrayList<Character> listaTemp;


		listaTemp = new ArrayList<>(despuesXor.subList(0, 6));

		listaPedazosDe6.add(listaTemp);
		listaTemp = new ArrayList<>(despuesXor.subList(6, 12));
		listaPedazosDe6.add(listaTemp);
		listaTemp = new ArrayList<>(despuesXor.subList(12, 18));
		listaPedazosDe6.add(listaTemp);
		listaTemp = new ArrayList<>(despuesXor.subList(18, 24));
		listaPedazosDe6.add(listaTemp);
		listaTemp = new ArrayList<>(despuesXor.subList(24, 30));
		listaPedazosDe6.add(listaTemp);
		listaTemp = new ArrayList<>(despuesXor.subList(30, 36));
		listaPedazosDe6.add(listaTemp);
		listaTemp = new ArrayList<>(despuesXor.subList(36, 42));
		listaPedazosDe6.add(listaTemp);
		listaTemp = new ArrayList<>(despuesXor.subList(42, 48));
		listaPedazosDe6.add(listaTemp);


		return listaPedazosDe6;
	}

	public int s1 (ArrayList<Integer> b1){

		int fila = b1.get(0);
		int col = b1.get(1);

		int[][] matrizS1= {{14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7},
				{0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8},
				{4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},
				{15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13}};


		return matrizS1[fila][col];


	}

	public int s2 (ArrayList<Integer> b2){

		int fila = b2.get(0);
		int col = b2.get(1);

		int[][] matrizS1= {{15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},
				{3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},
				{0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15},
				{13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9}};

		return matrizS1[fila][col];


	}

	public int s3 (ArrayList<Integer> b2){

		int fila = b2.get(0);
		int col = b2.get(1);

		int[][] matrizS1= {{10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8},
				{13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1},
				{13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7},
				{1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12}};

		return matrizS1[fila][col];


	}

	public int s4 (ArrayList<Integer> b2){

		int fila = b2.get(0);
		int col = b2.get(1);

		int[][] matrizS1= {{7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15},
				{13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9},
				{10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4},
				{3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14}};

		return matrizS1[fila][col];


	}
	public int s5 (ArrayList<Integer> b2){

		int fila = b2.get(0);
		int col = b2.get(1);

		int[][] matrizS1= {{2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9},
				{14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6},
				{4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14},
				{11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3}};

		return matrizS1[fila][col];


	}
	public int s6 (ArrayList<Integer> b2){

		int fila = b2.get(0);
		int col = b2.get(1);

		int[][] matrizS1= {{12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11},
				{10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8},
				{9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6},
				{4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13}};

		return matrizS1[fila][col];


	}

	public int s7 (ArrayList<Integer> b2){

		int fila = b2.get(0);
		int col = b2.get(1);

		int[][] matrizS1= {{4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1},
				{13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6},
				{1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2},
				{6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12}};

		return matrizS1[fila][col];


	}
	public int s8 (ArrayList<Integer> b2){

		int fila = b2.get(0);
		int col = b2.get(1);

		int[][] matrizS1= {{13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7},
				{1,15,13,8,10,3,7,4,12,5,6,11,0,14,9,2},
				{7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8},
				{2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11}};



		return matrizS1[fila][col];


	}

	public ArrayList<Character> pasarPorCajas(ArrayList<ArrayList> divididoEnOcho){

		ArrayList<ArrayList> despuesDeCajas = new ArrayList<>();
		ArrayList<Character> despuesDeCajasFinal = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		int retorno;
		String mensaje="";

		temp = utils.arrayCharacterToInt(divididoEnOcho.get(0));
		retorno= s1(temp);
		despuesDeCajas.add(utils.decimalTobinary(retorno));

		temp = utils.arrayCharacterToInt(divididoEnOcho.get(1));
		retorno= s2(temp);
		despuesDeCajas.add(utils.decimalTobinary(retorno));

		temp = utils.arrayCharacterToInt(divididoEnOcho.get(2));
		retorno= s3(temp);
		despuesDeCajas.add(utils.decimalTobinary(retorno));

		temp = utils.arrayCharacterToInt(divididoEnOcho.get(3));
		retorno= s4(temp);
		despuesDeCajas.add(utils.decimalTobinary(retorno));

		temp = utils.arrayCharacterToInt(divididoEnOcho.get(4));
		retorno= s5(temp);
		despuesDeCajas.add(utils.decimalTobinary(retorno));

		temp = utils.arrayCharacterToInt(divididoEnOcho.get(5));
		retorno= s6(temp);
		despuesDeCajas.add(utils.decimalTobinary(retorno));

		temp = utils.arrayCharacterToInt(divididoEnOcho.get(6));
		retorno= s7(temp);
		despuesDeCajas.add(utils.decimalTobinary(retorno));

		temp = utils.arrayCharacterToInt(divididoEnOcho.get(7));
		retorno= s8(temp);
		despuesDeCajas.add(utils.decimalTobinary(retorno));




		for(int i=0; i< despuesDeCajas.size();i++) {
			for (int j = 0; j < despuesDeCajas.get(i).size(); j++) {

				despuesDeCajasFinal.add((char)(despuesDeCajas.get(i).get(j)));

			}
		}



		return despuesDeCajasFinal;
	}

	public ArrayList<Character> p(ArrayList<Character> despuesDeCajas){

		ArrayList<Character> despuesDeP= new ArrayList<>();

		despuesDeP.add(despuesDeCajas.get(15));	despuesDeP.add(despuesDeCajas.get(6));
		despuesDeP.add(despuesDeCajas.get(19));	despuesDeP.add(despuesDeCajas.get(20));
		despuesDeP.add(despuesDeCajas.get(28));	despuesDeP.add(despuesDeCajas.get(11));
		despuesDeP.add(despuesDeCajas.get(27));	despuesDeP.add(despuesDeCajas.get(16));
		despuesDeP.add(despuesDeCajas.get(0));	despuesDeP.add(despuesDeCajas.get(14));
		despuesDeP.add(despuesDeCajas.get(22));	despuesDeP.add(despuesDeCajas.get(25));
		despuesDeP.add(despuesDeCajas.get(4));	despuesDeP.add(despuesDeCajas.get(17));
		despuesDeP.add(despuesDeCajas.get(30));	despuesDeP.add(despuesDeCajas.get(9));
		despuesDeP.add(despuesDeCajas.get(1));	despuesDeP.add(despuesDeCajas.get(7));
		despuesDeP.add(despuesDeCajas.get(23));	despuesDeP.add(despuesDeCajas.get(13));
		despuesDeP.add(despuesDeCajas.get(31));	despuesDeP.add(despuesDeCajas.get(26));
		despuesDeP.add(despuesDeCajas.get(2));	despuesDeP.add(despuesDeCajas.get(8));
		despuesDeP.add(despuesDeCajas.get(18));	despuesDeP.add(despuesDeCajas.get(12));
		despuesDeP.add(despuesDeCajas.get(29));	despuesDeP.add(despuesDeCajas.get(5));
		despuesDeP.add(despuesDeCajas.get(21));	despuesDeP.add(despuesDeCajas.get(10));
		despuesDeP.add(despuesDeCajas.get(3));	despuesDeP.add(despuesDeCajas.get(24));


		return despuesDeP;
	}

	public ArrayList<Character> funcionF(ArrayList<Character> r, ArrayList<Character> key ){

		ArrayList<Character> despuesExpansion = funcionExpansionE(r);

		ArrayList<Character> despuesXor = funcionXor(despuesExpansion, key);


		ArrayList<ArrayList> despuesDividirEnSeis = dividirEnSeis(despuesXor);

		ArrayList<Character> despuesPasarPorCajas = pasarPorCajas(despuesDividirEnSeis);
		ArrayList<Character> despuesDeP = p(despuesPasarPorCajas);

		return despuesDeP;
	}

	public ArrayList<ArrayList> generarLiRi(ArrayList<Character>l0, ArrayList<Character>r0, ArrayList<Character>key){

		ArrayList<Character>nuevoLi = r0;
		ArrayList<Character>nuevoRi = funcionXor(l0, funcionF(r0, key));

		ArrayList<ArrayList>despuesGenerarLiRi = new ArrayList<>();

		despuesGenerarLiRi.add(nuevoLi);
		despuesGenerarLiRi.add(nuevoRi);


		return despuesGenerarLiRi;
	}

	public ArrayList<ArrayList> generarLiRi1A16(ArrayList<Character>l0, ArrayList<Character>r0, ArrayList<ArrayList>key){

		ArrayList<Character>li= new ArrayList<>();;
		ArrayList<Character>ri = new ArrayList<>();
		ArrayList<ArrayList>liRiTemp;

		liRiTemp= generarLiRi(l0, r0, key.get(0));

		li= liRiTemp.get(0);
		ri= liRiTemp.get(1);

		for (int i = 2; i <= 16; i++) {


			liRiTemp= generarLiRi(li, ri, key.get(i-1));

			li= liRiTemp.get(0);
			ri= liRiTemp.get(1);	

		}

		return liRiTemp;
	}

	public ArrayList<Character> ipInv(ArrayList<ArrayList> l16R16){

		ArrayList<Character> temp = new ArrayList<>();
		ArrayList<Character> despuesIpInv = new ArrayList<>();

		temp.addAll(l16R16.get(1));
		temp.addAll(l16R16.get(0));


		despuesIpInv.add(temp.get(39));	despuesIpInv.add(temp.get(7));	despuesIpInv.add(temp.get(47));
		despuesIpInv.add(temp.get(15));	despuesIpInv.add(temp.get(55));	despuesIpInv.add(temp.get(23));
		despuesIpInv.add(temp.get(63));	despuesIpInv.add(temp.get(31));	despuesIpInv.add(temp.get(38));
		despuesIpInv.add(temp.get(6));	despuesIpInv.add(temp.get(46));	despuesIpInv.add(temp.get(14));
		despuesIpInv.add(temp.get(54));	despuesIpInv.add(temp.get(22));	despuesIpInv.add(temp.get(62));
		despuesIpInv.add(temp.get(30));	despuesIpInv.add(temp.get(37));	despuesIpInv.add(temp.get(5));
		despuesIpInv.add(temp.get(45));	despuesIpInv.add(temp.get(13));	despuesIpInv.add(temp.get(53));
		despuesIpInv.add(temp.get(21));	despuesIpInv.add(temp.get(61));	despuesIpInv.add(temp.get(29));
		despuesIpInv.add(temp.get(36));	despuesIpInv.add(temp.get(4));	despuesIpInv.add(temp.get(44));
		despuesIpInv.add(temp.get(12));	despuesIpInv.add(temp.get(52));	despuesIpInv.add(temp.get(20));
		despuesIpInv.add(temp.get(60));	despuesIpInv.add(temp.get(28));	despuesIpInv.add(temp.get(35));
		despuesIpInv.add(temp.get(3));	despuesIpInv.add(temp.get(43));	despuesIpInv.add(temp.get(11));
		despuesIpInv.add(temp.get(51));	despuesIpInv.add(temp.get(19));	despuesIpInv.add(temp.get(59));
		despuesIpInv.add(temp.get(27));	despuesIpInv.add(temp.get(34));	despuesIpInv.add(temp.get(2));
		despuesIpInv.add(temp.get(42));	despuesIpInv.add(temp.get(10));	despuesIpInv.add(temp.get(50));
		despuesIpInv.add(temp.get(18));	despuesIpInv.add(temp.get(58));	despuesIpInv.add(temp.get(26));
		despuesIpInv.add(temp.get(33));	despuesIpInv.add(temp.get(1));	despuesIpInv.add(temp.get(41));
		despuesIpInv.add(temp.get(9));	despuesIpInv.add(temp.get(49));	despuesIpInv.add(temp.get(17));
		despuesIpInv.add(temp.get(57));	despuesIpInv.add(temp.get(25));	despuesIpInv.add(temp.get(32));
		despuesIpInv.add(temp.get(0));	despuesIpInv.add(temp.get(40));	despuesIpInv.add(temp.get(8));
		despuesIpInv.add(temp.get(48));	despuesIpInv.add(temp.get(16));	despuesIpInv.add(temp.get(56));
		despuesIpInv.add(temp.get(24));


		return despuesIpInv;
	}

	public String cifrarDes(String mensaje, ArrayList<ArrayList> keys){

		ArrayList<String> mensajePorPartes =  new ArrayList<>();	
		String otroMensaje =  mensaje;
		ArrayList<Character> completoCifrado = new ArrayList<>();
		String mensajecifrado = "";

		while(otroMensaje.length()>0){
			if(otroMensaje.length()<8){
				mensajePorPartes.add(mensaje.substring(0));
				otroMensaje = "";
			}
			else{
				mensajePorPartes.add(mensaje.substring(0, 8));
				otroMensaje = otroMensaje.substring(8);
			}

		}

		for (int i = 0; i < mensajePorPartes.size(); i++) {
			ArrayList<Character> mensajeCompleto = completarBitsParaClave(mensaje);		
			ArrayList<Character> despuesIp =ip(mensajeCompleto);
			ArrayList<Character> l0 = despuesIpPartirenDos(despuesIp, 0, despuesIp.size()/2);
			ArrayList<Character> r0 = despuesIpPartirenDos(despuesIp, despuesIp.size()/2, despuesIp.size());
			completoCifrado.addAll(ipInv(generarLiRi1A16(l0, r0, keys)));
		}
		
		for (int i = 0; i < completoCifrado.size(); i++) {
			mensajecifrado+=completoCifrado.get(i);
		}

		return mensajecifrado;

	}

	public ArrayList<ArrayList> generarDescifrarLiRi1A16(ArrayList<Character>r16, ArrayList<Character>l16, ArrayList<ArrayList>key){

		ArrayList<Character>li= new ArrayList<>();;
		ArrayList<Character>ri = new ArrayList<>();
		ArrayList<ArrayList>liRiTemp;

		liRiTemp= generarLiRi(r16, l16, key.get(15));

		ri= liRiTemp.get(0);
		li= liRiTemp.get(1);

		for (int i = 14; i == 0 ; i--) {


			liRiTemp= generarLiRi(ri, li, key.get(i));

			ri= liRiTemp.get(0);
			li= liRiTemp.get(1);	

		}

		return liRiTemp;
	}

	public ArrayList<Character> descifrar(String mensaje, ArrayList<ArrayList> keys){

		//char[] cifrado = mensaje.toCharArray();
		String cifrado = mensaje;
		ArrayList<ArrayList> completo = new ArrayList<>();
		ArrayList<Character> porPartes = new ArrayList<>();
		ArrayList<Character> mensajeDescifrado = new ArrayList<>();
		int cont = 0;

		for (int i = 0; i < cifrado.length(); i+=64) {

			for (int j = 0;j < 64; j++) {
				porPartes.add(cifrado.charAt(j));
				cont ++;
			}
			completo.add(porPartes);
		}

		for (int i = 0; i < completo.size(); i++) {

			ArrayList<Character>despuesIp = ip(completo.get(i));
			ArrayList<Character>r16 = despuesIpPartirenDos(despuesIp, 0, despuesIp.size()/2);
			ArrayList<Character>l16 = despuesIpPartirenDos(despuesIp, despuesIp.size()/2, despuesIp.size());
			
			mensajeDescifrado.addAll(ipInv(generarLiRi1A16(r16, l16, keys)));			

		}
		

		
		return mensajeDescifrado;
	}


	//	public static void main(String[] args) {
	//		
	//		Des d = new Des();
	//		
	//		String cifrado = d.cifrarDes("Hola Que Hace", d.crearLlavesCompleto("abcdefgh"));
	//		d.descifrar(cifrado, d.crearLlavesCompleto("abcdefgh"));
	//		
	//	}


}
