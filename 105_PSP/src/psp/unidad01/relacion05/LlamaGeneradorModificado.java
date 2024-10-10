package psp.unidad01.relacion05;

import java.io.IOException;

public class LlamaGeneradorModificado {

	public static void main(String[] args) {

			
		ProcessBuilder p1 = new ProcessBuilder();
		
		p1.command("java","-jar","GeneradorModificado.jar", "ejercicio1" );	
		try {
			p1.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p1.command("java","-jar","GeneradorModificado.jar", "ejercicio2" );	
		try {
			p1.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		p1.command("java","-jar","GeneradorModificado.jar");	
		try {
			p1.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
