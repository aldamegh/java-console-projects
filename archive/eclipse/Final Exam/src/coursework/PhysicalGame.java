package coursework;

public class PhysicalGame extends VideoGame{

	private String condition;

	public PhysicalGame(String name, double price, double updateSize, String condition) {
		super(name, price, updateSize);
		this.condition = condition;
	}
	
	public PhysicalGame(PhysicalGame game) {
		super(game);
		
		this.condition = game.condition;
	}

	
	public String getCondition() {
		return condition;
	}
	
	public double calcTotalSize() {
		return updateSize;
		
	}
}
