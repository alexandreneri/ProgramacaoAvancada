package PegaString;

public class PegarNomedoArquivo {

	
public String nomeDoArquivo(String link){
	
	int tamanhoString =  link.length();
	int posicao = link.lastIndexOf("/");
		
	String nomedoArquivo = link.substring(posicao+1, tamanhoString);
	
	return nomedoArquivo;
 }
}