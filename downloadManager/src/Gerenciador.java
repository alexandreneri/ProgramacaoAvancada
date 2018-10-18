import java.io.IOException;

import PegaString.FacedeRecuperarString;
import TipoDeArquivo.TipoDoArquivo;

public class Gerenciador {

	public Gerenciador() {

	}

	public void baixar(String link) throws IOException {

		Cache cache = new Cache();
		Download down = new Download();
		FacedeRecuperarString facada = new FacedeRecuperarString();
		facada.inicializar();
		TipoDoArquivo tipo = new TipoDoArquivo(facada.extesao(link));

		String referencia = tipo.tipoArquivo() + "\\\\" + facada.nome(link);
		
		System.out.println(referencia);

		if (cache.verificarSeArquivoExisteNoCache(referencia) == true) {

			System.out.println("arquivo existe no cahce");

			if (cache.verificarSeArquivoExisteFileSystem(referencia)) {
				System.out.println("arquivo existe na pasta");
			} else {
				down.baixar(link,referencia);
			}

		} else {
			down.baixar(link,referencia);
			cache.salvarNomedoArquivo(referencia);
		}
	}

	
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
	

}
