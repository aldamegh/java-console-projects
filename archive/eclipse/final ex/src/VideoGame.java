

public abstract class VideoGame {
	private String name;
	private double price;
	protected double updateSize;
	
	
	public VideoGame(String name, double price,double update) {
		this.name=name;
		this.price =price;
		this.updateSize=update;
	}
	
	public VideoGame(VideoGame game) {
		this.name = game.name;
		this.price=game.price;
		this.updateSize = game.updateSize;	
	}
	
	public double getPrice()throws IllegalArgumentException{
		if(price<0)throw new IllegalArgumentException();
		return price;
		}
	
	public abstract double calcTotalSize();
	

}
