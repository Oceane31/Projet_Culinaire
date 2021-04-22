package culinaire.structures;

import java.io.Serializable;

public class Ustensile implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ustensile;
	
	public Ustensile(String u) {
		this.ustensile=u;
	}
	
	public static void main(String[] args) {
		//Ustensiles casserole=new Ustensiles("casserole");

	}

	public String getUstensile() {
		return this.ustensile;
	}

}
