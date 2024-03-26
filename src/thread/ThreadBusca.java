package thread;

import java.util.concurrent.Semaphore;

import objetos.Buscador;

public class ThreadBusca implements Runnable{
	private String nomeArquivo, valor;
	private Semaphore s1;
	
	
	public ThreadBusca(String nomeArquivo, String valor, Semaphore s1) {
		this.nomeArquivo = nomeArquivo;
		this.valor = valor;
		this.s1 = s1;
	}

	@Override
	public void run() {
		Buscador buscador = new Buscador();
		try {
			buscador.lerArquivo(nomeArquivo, valor, s1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
