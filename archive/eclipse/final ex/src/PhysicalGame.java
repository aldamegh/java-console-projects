

public class PhysicalGame extends VideoGame {
	private String condition;
	
	public PhysicalGame(String name,double price,double update,String condition) {
		super(name,price,update);
		this.condition=condition;
	}
	
	public PhysicalGame(PhysicalGame game) {
		super(game);
		this.condition=game.condition;
		
	}

	public double calcTotalSize() {return updateSize;}
	
	public String getCondition() {
		return condition;
	}
	
	
	
}
