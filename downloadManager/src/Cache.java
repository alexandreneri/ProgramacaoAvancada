import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Cache {
	
	private static String destino = "C:\\Users\\alexa\\Downloads\\teste\\";
	
	public void salvarNomedoArquivo(String nome) throws IOException {

			File arq = new File(destino+"cache.txt");
			FileWriter fw = new FileWriter(arq, true);

			BufferedWriter bw = new BufferedWriter(fw);

			// escreve o conteúdo no arquivo
			bw.write(nome);
			// quebra de linha
			bw.newLine();
			bw.close();
			fw.close();
		
	}

	public boolean verificarSeArquivoExisteFileSystem(String referencia) {

		File file = new File(destino + referencia);
		
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verificarSeArquivoExisteNoCache(String referencia) throws IOException{
		
		boolean resul = null != null;
		File arq = new File(destino+"cache.txt");
		
		if (false == verificarSeArquivoExisteFileSystem("cache.txt")) {
			
			File musica = new File(destino+"musica");
			musica.mkdir();
			
			File video = new File(destino+"video");
			video.mkdir();
			
			File imagem = new File (destino+"imagem");
			imagem.mkdir();
			
			arq.createNewFile();			
			resul = false;
		
		}else{
			
			FileReader fr = new FileReader( arq );
			BufferedReader br = new BufferedReader( fr );
			
			while( br.ready() ){
				//lê a proxima linha
				String linha = br.readLine();				 
				//faz algo com a linha				
				if (linha.equals(referencia)){					
					resul = true;
				}
			}
		}
		
		if (false==resul){			
			return false;
		}else{			
			return true;
		}
	}	
}
