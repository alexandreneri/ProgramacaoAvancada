import java.io.IOException;

public class MinhaTread implements Runnable  {
	
	private String link;
	Gerenciador g;
	
	public MinhaTread(String link){
		
		this.link =  link;
		g = new Gerenciador ();
		
	}

	@Override
	public void run() {
		
		try {
			g.baixar(link);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
