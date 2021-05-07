package culinaire.structures;

import java.beans.ConstructorProperties;
import java.io.Serializable;

public class Ustensile implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ustensile;
	
	@ConstructorProperties("ustensile")
	public Ustensile(String ustensile) {
		this.ustensile=ustensile;
	}
	
	

	public String getUstensile() {
		return this.ustensile;
	}

}
