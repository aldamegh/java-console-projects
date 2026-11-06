
public class Rational {

	private int nom;
	
	private int denom= 1;

	
	
	public void setNom (int nom) {
		
		this.nom=nom;
	}
	
	public void setDenom(int denom) {
		
		this.denom=denom;
	}
	
	public int getNom() {
		return nom;
	}
	
	public int getDenom() {
		return denom;
	}
	
	public double ratio(int nom ,int denom) {
		
		this.nom=nom; this.denom=denom;
		
		double ratio = nom/denom;
		
		
		return ratio;
	}
	
	public double ratio1(int nom ,int denom) {
		
		this.nom=nom; this.denom=denom;
		
		double ratio1 = nom/denom;
		
		
		return ratio1;
	}
		
		public Rational  mul(Rational r) {
			
			Rational resultR = new Rational();
			
			resultR.nom = nom * r.nom;
			
			resultR.denom = denom * r.denom;
			return resultR;
		}
	
		public Rational  add(Rational r) {
			
			Rational resultR = new Rational();
			
			resultR.nom = nom*r.denom + r.nom*denom;
			
			resultR.denom = denom*r.denom;
			return resultR;
		}
	}
	