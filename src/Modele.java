import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Modele {

	public ArrayList<Recette> listeRecettes;
	
	public Modele() {
		this.listeRecettes=new ArrayList<Recette>();
	}
	
	public void chargerXML() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(new File("recettes.xml"));
		BufferedInputStream bis = new BufferedInputStream(fis);
		XMLDecoder decoder = new XMLDecoder(bis);
		this.listeRecettes = (ArrayList<Recette>)decoder.readObject();
		decoder.close();
		bis.close();
		fis.close();
	}
	
	public String toString() {
		return this.listeRecettes.toString();
	}
	
	public void enregistrerXML() {
		try {
			FileOutputStream fos = new FileOutputStream(new File("recettes.xml"));
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			XMLEncoder encoder = new XMLEncoder(bos);
			encoder.writeObject(this.listeRecettes);
			encoder.flush();
			encoder.close();
			bos.close();
			fos.close();

		} catch (IOException e) {
			throw new RuntimeException("Impossible d'écrire les données");
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Modele m =new Modele();
//		m.listeRecettes.add(new Recette("risotto",2,5,4,new ArrayList()));
//		m.enregistrerXML();
		m.chargerXML();
		System.out.println(m);
	}

	
}
