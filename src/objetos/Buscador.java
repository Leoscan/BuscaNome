package objetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Buscador {	
	public void lerArquivo(String nomeArquivo, String valor, Semaphore s1) throws InterruptedException {
		s1.acquire();
		File arquivo = new File(nomeArquivo);
		int i = 1;
        
        try {
        	Scanner scanner = new Scanner(arquivo);
			while (scanner.hasNextLine()) {
	            String linha = scanner.nextLine();
	            
	            if(linha.contains(valor))
	            	System.out.println("Valor " + valor + " Encontrado na linha " + i + " no Arquivo " + nomeArquivo);
	            
	            i++;
	        }
	        scanner.close();
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        s1.release();
	}
}