import java.io.IOException;

import PegaString.FacedeRecuperarString;
import TipoDeArquivo.TipoDoArquivo;
import java.util.concurrent.*;


public class ATest {
	

	public static void main (String [] arg) throws IOException{
		
		String link = "http://www.whatsappimagens.com/imagens/imagens-imagens-para-baixar-de-amizade-4.gif";
		int tamanhodaLista = 2;
        int threadPoolSize = 1;
        
        ExecutorService tpes = Executors.newFixedThreadPool(threadPoolSize);
		
        MinhaTread[] g = new MinhaTread[tamanhodaLista];
        
        for (int i = 0; i < tamanhodaLista; i++) {
            g[i] = new MinhaTread(link);
            tpes.execute((Runnable) g[i]);
        }
        tpes.shutdown();
    }
        
        
	}


