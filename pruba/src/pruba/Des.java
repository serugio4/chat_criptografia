package pruba;

import java.util.ArrayList;

public class Des {
	
	Utils u = new Utils();

	public int stringToAscii(char caracter) {		
		int ascii = (int)caracter;
		return ascii;	
	}

	public String asciiToBinary(int ascii){
		String cadena = "";
		cadena+=Integer.toBinaryString(ascii);
		return cadena;
	}

	public String completarCeros(String cadena) {
		String temp;
		while(cadena.length()<8){
			cadena = '0'+cadena;
		}
		return cadena;
	}

	public String completarBitsParaClave(String cadena){
		String fraseBinario = "";		
		for (int i = 0; i < cadena.length(); i++) {
			fraseBinario += completarCeros(asciiToBinary(stringToAscii(cadena.charAt(i))));
		}
		while (fraseBinario.length()<64){
			fraseBinario = '0'+fraseBinario;
		}
		return fraseBinario;		
	}

	public String pc1(String clave){
		String clavePermutada = "";

		clavePermutada+=clave.charAt(56); clavePermutada+=clave.charAt(48); clavePermutada+=clave.charAt(40);
		clavePermutada+=clave.charAt(32); clavePermutada+=clave.charAt(24); clavePermutada+=clave.charAt(16);
		clavePermutada+=clave.charAt(8); clavePermutada+=clave.charAt(0); clavePermutada+=clave.charAt(57);
		clavePermutada+=clave.charAt(49); clavePermutada+=clave.charAt(41); clavePermutada+=clave.charAt(33);
		clavePermutada+=clave.charAt(25); clavePermutada+=clave.charAt(17); clavePermutada+=clave.charAt(9);
		clavePermutada+=clave.charAt(1); clavePermutada+=clave.charAt(58); clavePermutada+=clave.charAt(50);
		clavePermutada+=clave.charAt(42); clavePermutada+=clave.charAt(34); clavePermutada+=clave.charAt(26);
		clavePermutada+=clave.charAt(18); clavePermutada+=clave.charAt(10); clavePermutada+=clave.charAt(2);
		clavePermutada+=clave.charAt(59); clavePermutada+=clave.charAt(51); clavePermutada+=clave.charAt(43);
		clavePermutada+=clave.charAt(35); clavePermutada+=clave.charAt(62); clavePermutada+=clave.charAt(54);
		clavePermutada+=clave.charAt(46); clavePermutada+=clave.charAt(38); clavePermutada+=clave.charAt(30);
		clavePermutada+=clave.charAt(22); clavePermutada+=clave.charAt(14); clavePermutada+=clave.charAt(6);
		clavePermutada+=clave.charAt(61); clavePermutada+=clave.charAt(53); clavePermutada+=clave.charAt(45);
		clavePermutada+=clave.charAt(37); clavePermutada+=clave.charAt(29); clavePermutada+=clave.charAt(21);
		clavePermutada+=clave.charAt(13); clavePermutada+=clave.charAt(5); clavePermutada+=clave.charAt(60);
		clavePermutada+=clave.charAt(52); clavePermutada+=clave.charAt(44); clavePermutada+=clave.charAt(36);
		clavePermutada+=clave.charAt(28); clavePermutada+=clave.charAt(20); clavePermutada+=clave.charAt(12);
		clavePermutada+=clave.charAt(4); clavePermutada+=clave.charAt(27); clavePermutada+=clave.charAt(19);
		clavePermutada+=clave.charAt(11); clavePermutada+=clave.charAt(3); 

		return clavePermutada;
	}

	public ArrayList<String> funcionLs(String llave){

		String izq = llave.substring(0, llave.length()/2);
		String der = llave.substring(llave.length()/2);
		char temp1, temp2;
		ArrayList<String> keys = new ArrayList<>();

		for (int i = 1; i < 17; i++) {

			if(i==1 || i==2 || i==9 || i==16){
				temp1 = der.charAt(0);
				der = der.substring(1)+temp1;
				temp1 = izq.charAt(0);
				izq = izq.substring(1)+temp1;				
			}
			else {
				temp1 = der.charAt(0);
				temp2 = der.charAt(1);
				der = der.substring(2)+temp1+temp2;
				temp1 = izq.charAt(0);
				temp2 = izq.charAt(1);
				izq = izq.substring(2)+temp1+temp2;				
			}

			keys.add(pc2(izq,der));
			//System.out.println(i +" "+der+" "+izq+" "+keys.get(i-1).length());
		}

		return keys;

	}

	public String pc2(String izq, String der){
		String completo = izq + der;
		String key = "";

		key += completo.charAt(13); key += completo.charAt(16); key += completo.charAt(10);
		key += completo.charAt(23); key += completo.charAt(0); key += completo.charAt(4);
		key += completo.charAt(2); key += completo.charAt(27); key += completo.charAt(14);
		key += completo.charAt(5); key += completo.charAt(20); key += completo.charAt(9);
		key += completo.charAt(22); key += completo.charAt(18); key += completo.charAt(11);
		key += completo.charAt(3); key += completo.charAt(25); key += completo.charAt(7);
		key += completo.charAt(15); key += completo.charAt(6); key += completo.charAt(26);
		key += completo.charAt(19); key += completo.charAt(12); key += completo.charAt(1);
		key += completo.charAt(40); key += completo.charAt(51); key += completo.charAt(30);
		key += completo.charAt(36); key += completo.charAt(46); key += completo.charAt(54);
		key += completo.charAt(29); key += completo.charAt(39); key += completo.charAt(50);
		key += completo.charAt(44); key += completo.charAt(32); key += completo.charAt(47);
		key += completo.charAt(43); key += completo.charAt(48); key += completo.charAt(38);
		key += completo.charAt(55); key += completo.charAt(33); key += completo.charAt(52);
		key += completo.charAt(45); key += completo.charAt(41); key += completo.charAt(49);
		key += completo.charAt(35); key += completo.charAt(28); key += completo.charAt(31);

		return key;
	}

	public ArrayList<String> generarLlaves(String clave){

		return funcionLs(pc1(completarBitsParaClave(clave)));

	}

	public String ip(String mensaje){
		String despuesIp = "";

		despuesIp+=mensaje.charAt(57); despuesIp+=mensaje.charAt(49); despuesIp+=mensaje.charAt(41);
		despuesIp+=mensaje.charAt(33); despuesIp+=mensaje.charAt(25); despuesIp+=mensaje.charAt(17);
		despuesIp+=mensaje.charAt(9); despuesIp+=mensaje.charAt(1); despuesIp+=mensaje.charAt(59);
		despuesIp+=mensaje.charAt(51); despuesIp+=mensaje.charAt(43); despuesIp+=mensaje.charAt(35);
		despuesIp+=mensaje.charAt(27); despuesIp+=mensaje.charAt(19); despuesIp+=mensaje.charAt(11);
		despuesIp+=mensaje.charAt(3); despuesIp+=mensaje.charAt(61); despuesIp+=mensaje.charAt(53);
		despuesIp+=mensaje.charAt(45); despuesIp+=mensaje.charAt(37); despuesIp+=mensaje.charAt(29);
		despuesIp+=mensaje.charAt(21); despuesIp+=mensaje.charAt(13); despuesIp+=mensaje.charAt(5);
		despuesIp+=mensaje.charAt(63); despuesIp+=mensaje.charAt(55); despuesIp+=mensaje.charAt(47);
		despuesIp+=mensaje.charAt(39); despuesIp+=mensaje.charAt(31); despuesIp+=mensaje.charAt(23);
		despuesIp+=mensaje.charAt(15); despuesIp+=mensaje.charAt(7); despuesIp+=mensaje.charAt(56);
		despuesIp+=mensaje.charAt(48); despuesIp+=mensaje.charAt(40); despuesIp+=mensaje.charAt(32);
		despuesIp+=mensaje.charAt(24); despuesIp+=mensaje.charAt(16); despuesIp+=mensaje.charAt(8);
		despuesIp+=mensaje.charAt(0); despuesIp+=mensaje.charAt(58); despuesIp+=mensaje.charAt(50);
		despuesIp+=mensaje.charAt(42); despuesIp+=mensaje.charAt(34); despuesIp+=mensaje.charAt(26);
		despuesIp+=mensaje.charAt(18); despuesIp+=mensaje.charAt(10); despuesIp+=mensaje.charAt(2);
		despuesIp+=mensaje.charAt(60); despuesIp+=mensaje.charAt(52); despuesIp+=mensaje.charAt(44);
		despuesIp+=mensaje.charAt(36); despuesIp+=mensaje.charAt(28); despuesIp+=mensaje.charAt(20);
		despuesIp+=mensaje.charAt(12); despuesIp+=mensaje.charAt(4); despuesIp+=mensaje.charAt(62);
		despuesIp+=mensaje.charAt(54); despuesIp+=mensaje.charAt(46); despuesIp+=mensaje.charAt(38);
		despuesIp+=mensaje.charAt(30); despuesIp+=mensaje.charAt(22); despuesIp+=mensaje.charAt(14);
		despuesIp+=mensaje.charAt(6); 

		return despuesIp;
	}

	public String funcionE(String parteDer){
		String despuesExp ="";

		despuesExp+=parteDer.charAt(31); despuesExp+=parteDer.charAt(0); despuesExp+=parteDer.charAt(1);
		despuesExp+=parteDer.charAt(2); despuesExp+=parteDer.charAt(3); despuesExp+=parteDer.charAt(4);
		despuesExp+=parteDer.charAt(3); despuesExp+=parteDer.charAt(4); despuesExp+=parteDer.charAt(5);
		despuesExp+=parteDer.charAt(6); despuesExp+=parteDer.charAt(7); despuesExp+=parteDer.charAt(8);
		despuesExp+=parteDer.charAt(7); despuesExp+=parteDer.charAt(8); despuesExp+=parteDer.charAt(9);
		despuesExp+=parteDer.charAt(10); despuesExp+=parteDer.charAt(11); despuesExp+=parteDer.charAt(12);
		despuesExp+=parteDer.charAt(11); despuesExp+=parteDer.charAt(12); despuesExp+=parteDer.charAt(13);
		despuesExp+=parteDer.charAt(14); despuesExp+=parteDer.charAt(15); despuesExp+=parteDer.charAt(16);
		despuesExp+=parteDer.charAt(15); despuesExp+=parteDer.charAt(16); despuesExp+=parteDer.charAt(17);
		despuesExp+=parteDer.charAt(18); despuesExp+=parteDer.charAt(19); despuesExp+=parteDer.charAt(20);
		despuesExp+=parteDer.charAt(19); despuesExp+=parteDer.charAt(20); despuesExp+=parteDer.charAt(21);
		despuesExp+=parteDer.charAt(22); despuesExp+=parteDer.charAt(23); despuesExp+=parteDer.charAt(24);
		despuesExp+=parteDer.charAt(23); despuesExp+=parteDer.charAt(24); despuesExp+=parteDer.charAt(25);
		despuesExp+=parteDer.charAt(26); despuesExp+=parteDer.charAt(27); despuesExp+=parteDer.charAt(28);
		despuesExp+=parteDer.charAt(27); despuesExp+=parteDer.charAt(28); despuesExp+=parteDer.charAt(29);
		despuesExp+=parteDer.charAt(30); despuesExp+=parteDer.charAt(31); despuesExp+=parteDer.charAt(0);

		return despuesExp;
	}

	public String funcionXor(String despuesExp, String key){
		String despuesXor ="";
		for (int i = 0; i < despuesExp.length(); i++) {
			despuesXor += despuesExp.charAt(i) ^ key.charAt(i);
		}
		return despuesXor;
	}

	public ArrayList<String> partirEn8(String despuesXor){

		ArrayList<String> ochoCajas = new ArrayList<>();
		ochoCajas.add(despuesXor.substring(0,6)); ochoCajas.add(despuesXor.substring(6,12));
		ochoCajas.add(despuesXor.substring(12,18)); ochoCajas.add(despuesXor.substring(18,24));
		ochoCajas.add(despuesXor.substring(24,30)); ochoCajas.add(despuesXor.substring(30,36));
		ochoCajas.add(despuesXor.substring(36,42)); ochoCajas.add(despuesXor.substring(42));

		return ochoCajas;
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
	
	public String pasarPorCajas (ArrayList<String> divididoEnOcho){
		String despuesDeCajas = "";
		ArrayList<Integer> numeros =  new ArrayList<>();
		
		numeros = u.binaryToInt(divididoEnOcho.get(0));
		despuesDeCajas+=u.decimalTobinary(s1(numeros));		
		numeros = u.binaryToInt(divididoEnOcho.get(1));
		despuesDeCajas+=u.decimalTobinary(s2(numeros));		
		numeros = u.binaryToInt(divididoEnOcho.get(2));
		despuesDeCajas+=u.decimalTobinary(s3(numeros));		
		numeros = u.binaryToInt(divididoEnOcho.get(3));
		despuesDeCajas+=u.decimalTobinary(s4(numeros));		
		numeros = u.binaryToInt(divididoEnOcho.get(4));
		despuesDeCajas+=u.decimalTobinary(s5(numeros));		
		numeros = u.binaryToInt(divididoEnOcho.get(5));
		despuesDeCajas+=u.decimalTobinary(s6(numeros));		
		numeros = u.binaryToInt(divididoEnOcho.get(6));
		despuesDeCajas+=u.decimalTobinary(s7(numeros));		
		numeros = u.binaryToInt(divididoEnOcho.get(7));
		despuesDeCajas+=u.decimalTobinary(s8(numeros));

		return despuesDeCajas;
	}
	
	public String p(String despuesCajas){
		String despuesP = "";
		
		despuesP+=despuesCajas.charAt(15); despuesP+=despuesCajas.charAt(6); despuesP+=despuesCajas.charAt(19);
		despuesP+=despuesCajas.charAt(20); despuesP+=despuesCajas.charAt(28); despuesP+=despuesCajas.charAt(11);
		despuesP+=despuesCajas.charAt(27); despuesP+=despuesCajas.charAt(16); despuesP+=despuesCajas.charAt(0);
		despuesP+=despuesCajas.charAt(14); despuesP+=despuesCajas.charAt(22); despuesP+=despuesCajas.charAt(25);
		despuesP+=despuesCajas.charAt(4); despuesP+=despuesCajas.charAt(17); despuesP+=despuesCajas.charAt(30);
		despuesP+=despuesCajas.charAt(9); despuesP+=despuesCajas.charAt(1); despuesP+=despuesCajas.charAt(7);
		despuesP+=despuesCajas.charAt(23); despuesP+=despuesCajas.charAt(13); despuesP+=despuesCajas.charAt(31);
		despuesP+=despuesCajas.charAt(26); despuesP+=despuesCajas.charAt(2); despuesP+=despuesCajas.charAt(8);
		despuesP+=despuesCajas.charAt(18); despuesP+=despuesCajas.charAt(12); despuesP+=despuesCajas.charAt(29);
		despuesP+=despuesCajas.charAt(5); despuesP+=despuesCajas.charAt(21); despuesP+=despuesCajas.charAt(10);
		despuesP+=despuesCajas.charAt(3); despuesP+=despuesCajas.charAt(24);
		
		return despuesP;
	}
	
	public String funcioF(String r, String key){
		
		String despuesExpancion = funcionE(r);
		String despuesXor = funcionXor(despuesExpancion, key);
		ArrayList<String> dividirEnOcho = partirEn8(despuesXor);
		String despuesCajas = pasarPorCajas(dividirEnOcho);
		String despuesP = p(despuesCajas); 
		return despuesP;
		
	}
	
	public String generarLiRi(String l0, String r0, String key){
		
		String li =  r0;
		String ri = funcioF(r0, key);
		ri = funcionXor(ri, l0);
		String despuesGenerarLiRi="";
		despuesGenerarLiRi = li+ri;
		return despuesGenerarLiRi;

	}
	public String generarLiRi1a16(String l0, String r0, ArrayList<String> keys){
		String li;   
		String ri;
		String tempLiRi = generarLiRi(l0, r0, keys.get(0));
		li = (tempLiRi.substring(0, tempLiRi.length()/2));
		ri = (tempLiRi.substring(tempLiRi.length()/2));
		
		for (int i = 2; i <= 16; i++) {
			tempLiRi =  generarLiRi(li, ri, keys.get(i-1));
			li = (tempLiRi.substring(0, tempLiRi.length()/2));
			ri = (tempLiRi.substring(tempLiRi.length()/2));			
		}
		
		return tempLiRi;
		
	}
	
	public String ipInv(String l16r16){
		String temp = l16r16.substring(l16r16.length()/2) + l16r16.substring(0,l16r16.length()/2);
		String despuesIpInv = "";
		
		despuesIpInv += temp.charAt(39); despuesIpInv += temp.charAt(7); despuesIpInv += temp.charAt(47);
		despuesIpInv += temp.charAt(15); despuesIpInv += temp.charAt(55); despuesIpInv += temp.charAt(23);
		despuesIpInv += temp.charAt(63); despuesIpInv += temp.charAt(31); despuesIpInv += temp.charAt(38);
		despuesIpInv += temp.charAt(6); despuesIpInv += temp.charAt(46); despuesIpInv += temp.charAt(14);
		despuesIpInv += temp.charAt(54); despuesIpInv += temp.charAt(22); despuesIpInv += temp.charAt(62);
		despuesIpInv += temp.charAt(30); despuesIpInv += temp.charAt(37); despuesIpInv += temp.charAt(5);
		despuesIpInv += temp.charAt(45); despuesIpInv += temp.charAt(13); despuesIpInv += temp.charAt(53);
		despuesIpInv += temp.charAt(21); despuesIpInv += temp.charAt(61); despuesIpInv += temp.charAt(29);
		despuesIpInv += temp.charAt(36); despuesIpInv += temp.charAt(4); despuesIpInv += temp.charAt(44);
		despuesIpInv += temp.charAt(12); despuesIpInv += temp.charAt(52); despuesIpInv += temp.charAt(20);
		despuesIpInv += temp.charAt(60); despuesIpInv += temp.charAt(28); despuesIpInv += temp.charAt(35);
		despuesIpInv += temp.charAt(3); despuesIpInv += temp.charAt(43); despuesIpInv += temp.charAt(11);
		despuesIpInv += temp.charAt(51); despuesIpInv += temp.charAt(19); despuesIpInv += temp.charAt(59);
		despuesIpInv += temp.charAt(27); despuesIpInv += temp.charAt(34); despuesIpInv += temp.charAt(2);
		despuesIpInv += temp.charAt(42); despuesIpInv += temp.charAt(10); despuesIpInv += temp.charAt(50);
		despuesIpInv += temp.charAt(18); despuesIpInv += temp.charAt(58); despuesIpInv += temp.charAt(26);
		despuesIpInv += temp.charAt(33); despuesIpInv += temp.charAt(1); despuesIpInv += temp.charAt(41);
		despuesIpInv += temp.charAt(9); despuesIpInv += temp.charAt(49); despuesIpInv += temp.charAt(17);
		despuesIpInv += temp.charAt(57); despuesIpInv += temp.charAt(25); despuesIpInv += temp.charAt(32);
		despuesIpInv += temp.charAt(0); despuesIpInv += temp.charAt(40); despuesIpInv += temp.charAt(8);
		despuesIpInv += temp.charAt(48); despuesIpInv += temp.charAt(16); despuesIpInv += temp.charAt(56);
		despuesIpInv += temp.charAt(24);
		
		return despuesIpInv;
		
	}
	
	public String cifrarDes(String mensaje, ArrayList<String> keys){
		
		String despuesIp = ip(mensaje);
		String l0 = despuesIp.substring(0, despuesIp.length()/2);
		String r0 = despuesIp.substring(despuesIp.length()/2);	
		String despues16 = generarLiRi1a16(l0, r0, keys);		
		return ipInv(despues16);
		
	}
	
	public 
	
	
	
	
	


	public static void main(String[] args) {
		Des d = new Des();
		//		String palabra = d.completarBitsParaClave("hola");
		//		System.out.println(palabra+" "+palabra.length());
				String pc1 = d.pc1("0001001100110100010101110111100110011011101111001101111111110001");
		ArrayList<String> keys =d.funcionLs(pc1);
		//		d.generarLlaves("Hola");
		//		System.out.println(d.ip("0000000100100011010001010110011110001001101010111100110111101111"));
// 		String parteDer =d.funcionE("11110000101010101111000010101010");
// 		String despuesXor = d.funcionXor(parteDer, "000110110000001011101111111111000111000001110010");
//		ArrayList<String> dividirEnOcho = d.partirEn8(despuesXor);
//		String despuesCajas = d.pasarPorCajas(dividirEnOcho);
//		System.out.println(d.cifrarDes("0000000100100011010001010110011110001001101010111100110111101111", keys));		
		//String despuesP=d.p(despuesCajas);
		



	}

}
