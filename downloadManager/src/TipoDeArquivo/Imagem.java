package TipoDeArquivo;

public class Imagem implements ITipos {

	@Override
	public String tipoArquivo(TipoDoArquivo tipoDoArquivo) {

		switch (tipoDoArquivo.getExtensao()) {

		case "jpeg":

			return "imagem";
		case "jpg":

			return "imagem";

		case "gif":

			return "imagem";

		case "bitmap":

			return "imagem";
		case "tiff":

			return "imagem";
		case "raw":

			return "imagem";
		case "svg":

			return "imagem";

		}
		
		return "-1";
		
	}

}
