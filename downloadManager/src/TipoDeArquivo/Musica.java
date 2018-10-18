package TipoDeArquivo;

public class Musica implements ITipos {

	@Override
	public String tipoArquivo(TipoDoArquivo tipoDoArquivo) {
		// TODO Auto-generated method stub
		if (tipoDoArquivo.getExtensao().equals("mp3")){
			
		
			return "musica";
		}
		return "-1";
	}
	
	
	

}
