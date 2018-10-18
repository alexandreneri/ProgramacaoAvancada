package TipoDeArquivo;

public class TipoDoArquivo {

	
	private String extensao;
	private ITipos tipos;
	//private String resulTipoArquivo = "";
	
	private int tipo=1;

	
	public TipoDoArquivo(String extensao){
		
		this.extensao= extensao;		
	
	
		
	do{	
		
		switch (tipo){
	
		case 1:
			tipos = new Musica();
			break;
			
		case 2:			
			tipos =  new Video();
			break;
		
		case 3:
			tipos = new Imagem();
			break;
		
		default:			
			System.out.println("arquivo não suportado");
			
	}
		
		
tipo+=1;

	}
while(tipoArquivo().equals("-1"));

	

		
		
	
	}
  public String getExtensao(){
		
		return extensao;
  }
  
  public String tipoArquivo(){
	  
	  return tipos.tipoArquivo(this);
  }
}
