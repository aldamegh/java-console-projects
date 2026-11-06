package coursework;

public class DigitalGame  extends VideoGame{
	
	private double size;
	
			
	public DigitalGame(String name, double price, double updateSize, double size) {
		super(name, price, updateSize);
		this.size = size;
	}
	
	public DigitalGame(  DigitalGame game) {
		super(game);
		this.size = game.size;
	}

	public double getSize() {
		return size;
	}
	
	
	public double calcTotalSize() {
		return size+updateSize;
		
	}
	
	
}
