
public class testRational {

	public static void main(String[] args) {

		
		Rational r1 = new Rational();
		
		r1.setNom(1);
		
		r1.setDenom(2);
		
		
		
		
		
		Rational r2 = new Rational();

		

		r2.setNom(3);
		
		r2.setDenom(4);
		
		
		
		Rational r3 = r2.mul(r1);
		
		
		System.out.println(r3.getNom()+"/"+r3.getDenom());
		
		
		
		
		Rational r4 = r2.add(r1);
		
		
		System.out.println(r4.getNom()+"/"+r4.getDenom());
		
		
		
		
		
		
		
		
		
		
	}

}
