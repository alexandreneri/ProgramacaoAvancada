package PegaString;

public class PegarExtensaodoArquivo {

	public String extensaoDoArquivo(String link){
		
		int tamanhoString =  link.length();
		int posicao = link.lastIndexOf(".");
				
		String nomedoArquivo = link.substring(posicao+1, tamanhoString);
		
		return nomedoArquivo;
	 }
}
