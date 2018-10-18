package TipoDeArquivo;

public class Video implements ITipos {

	@Override
	public String tipoArquivo(TipoDoArquivo tipoDoArquivo) {
		switch (tipoDoArquivo.getExtensao()) {

		case "3gp":

			return "video";
		case "flv":

			return "video";

		case "rmvb":

			return "video";

		case "avi":

			return "video";
		case "mov":

			return "video";
		case "mp4":

			return "video";
		case "mkv":

			return "video";

		}
		
		return "-1";
		
	}
}
