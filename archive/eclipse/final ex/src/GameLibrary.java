

public class GameLibrary {
	private String name;
	private VideoGame[] arrGames;
	private int nbV;
	
	public GameLibrary(String name,int size) {
		this.name =name;
		arrGames =new VideoGame[size];
		nbV=0;	
	}
	
	public boolean addGame(VideoGame g)throws NullPointerException{
		if(g==null)throw new NullPointerException();
		if(nbV>=arrGames.length)return false;
		
		if(g instanceof PhysicalGame) {
			arrGames[nbV]= new PhysicalGame((PhysicalGame)g);
			nbV++; 
			return true;
			}
		else { 
			arrGames[nbV] = new DigitalGame((DigitalGame)g);
			nbV++;
			return true;}
		
	}
	
	public int getDigital(double size) {
		int count=0;
		for(int i=0;i<nbV;i++) {
			if(arrGames[i] instanceof DigitalGame 
					&& ((DigitalGame)arrGames[i]).getSize()>= size) {
				count++;
			}	
		}	
		return count;
	}
	
	public double getPhysical(double pr,String con) {
		int count=0;
		for(int i=0;i<nbV;i++) {
			if(arrGames[i] instanceof PhysicalGame && arrGames[i].getPrice()<pr
				&& ((PhysicalGame)arrGames[i]).getCondition().equalsIgnoreCase(con)	) {
				
				count++;
			}
			
		}
		
		return count;
	}
	
	
	
	
}
