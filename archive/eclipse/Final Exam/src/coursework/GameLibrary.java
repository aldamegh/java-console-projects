package coursework;

public class GameLibrary {
	
	private String name;
	
	private VideoGame arrGames[] ;
	
	private int nbVideoGame ;

	public GameLibrary(String name, int size) {
	
		this.name = name;
		arrGames = new VideoGame[size];
		nbVideoGame = 0;
	}
	
	
	
	public Boolean addGame(VideoGame g)throws  NullPointerException {
		
		if(nbVideoGame>=arrGames.length) return false;
		
		if(g==null) throw new NullPointerException("the new game is null");
		
		if(g instanceof PhysicalGame)
		arrGames[nbVideoGame++] = new PhysicalGame((PhysicalGame)g);
		
		else if(g instanceof DigitalGame)
			arrGames[nbVideoGame++] = new DigitalGame((DigitalGame)g);
		
		return true;
		
	}
	
	public  VideoGame[] getDigital( double size) {
		VideoGame Digital[]  = new  VideoGame[nbVideoGame];
		
		int count=0;
		
		for(int i=0;i<nbVideoGame;i++) {
			if(arrGames[i] instanceof DigitalGame 
					&& ((DigitalGame)arrGames[i]).getSize()>= size) {
				Digital[count++] = new DigitalGame((DigitalGame)arrGames[i]);
			}	
		}	
		
		return Digital;
	}

	
	public VideoGame maxDigital() {
		
		int count=0;
		VideoGame maxD =(DigitalGame)arrGames[count];
		
		for(int i=0;i<nbVideoGame;i++) {
			
			if(arrGames[i] instanceof DigitalGame 
					&& ((DigitalGame)arrGames[i]).getSize()>= 0) {
				maxD[count++]=(DigitalGame) arrGames[i];
			}	
		}
		return ((DigitalGame)arrGames[count]);	
	}
	
	
	
	
	
	
	
	
}
