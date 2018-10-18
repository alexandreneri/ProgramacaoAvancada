import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Download {

	
	
	private static final String destino = "C:\\Users\\alexa\\Downloads\\teste\\";
	
	

	public Download() {

		
		
	}

	public void baixar(String link, String referencia) throws IOException {  //Baixar arquivo imagem, video, musica e salva

		URL url = new URL(link);
		

		InputStream is = url.openStream();

		FileOutputStream fos = new FileOutputStream(destino+referencia);

		int bytes = 0;

		while ((bytes = is.read()) != -1) {
			fos.write(bytes);
		}

		is.close();
		fos.close();
	}
}
