package PegaString;

public class FacedeRecuperarString {
	
	protected PegarExtensaodoArquivo extensao;
	protected PegarNomedoArquivo nome;
	
	public void inicializar(){
		
		extensao= new PegarExtensaodoArquivo ();
		
		nome = new  PegarNomedoArquivo();
		
			
	}
	
	public String nome(String link){
		return nome.nomeDoArquivo(link);
	}
	
	public String extesao (String link){
		
		return extensao.extensaoDoArquivo(link);
	}
	
	
}
