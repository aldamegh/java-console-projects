

public class DigitalGame extends VideoGame {
	private double size;
	
	public DigitalGame(String name,double price,double update,double size) {
		super(name,price,update);
		this.size=size;
	}
	
	public DigitalGame(DigitalGame game) {
		super(game);
		this.size=game.size;
	}

	
	public double calcTotalSize() {
		return size + updateSize;
	}
	
	public double getSize() {
		return size;
	}

	
	
	
	
}
