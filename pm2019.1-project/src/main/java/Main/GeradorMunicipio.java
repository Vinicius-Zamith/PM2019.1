package Main;

import java.util.ArrayList;

public class GeradorMunicipio {
	private ArrayList<String> nomeMunicipios;
	private ArrayList<String> codigoMunicipios;
	private ArrayList<String> coordenadasMunicipios;
	
	public GeradorMunicipio(ArrayList<String> nomeMunicipios, ArrayList<String> codigoMunicipios, ArrayList<String> coordenadasMunicipios) {
		this.nomeMunicipios = nomeMunicipios;
		this.codigoMunicipios = codigoMunicipios;
		this.coordenadasMunicipios = coordenadasMunicipios;
	}

	public ArrayList<String> getNomeMunicipios() {
		return nomeMunicipios;
	}

	public void setNomeMunicipios(ArrayList<String> nomeMunicipios) {
		this.nomeMunicipios = nomeMunicipios;
	}

	public ArrayList<String> getCodigoMunicipios() {
		return codigoMunicipios;
	}

	public void setCodigoMunicipios(ArrayList<String> codigoMunicipios) {
		this.codigoMunicipios = codigoMunicipios;
	}

	public ArrayList<String> getCoordenadasMunicipios() {
		return coordenadasMunicipios;
	}

	public void setCoordenadasMunicipios(ArrayList<String> coordenadasMunicipios) {
		this.coordenadasMunicipios = coordenadasMunicipios;
	}
	
	public void gerarMunicipio() {
		GeradorBoundingBox geradorBoundingBox = new GeradorBoundingBox();
		for (int i = 0; i < nomeMunicipios.size() - 1; i++) {
			Municipio municipio = new Municipio(this.nomeMunicipios.get(i), this.codigoMunicipios.get(i), geradorBoundingBox.gerarBoundingBox(this.coordenadasMunicipios.get(i)));
			System.out.println(municipio.toString());
		}
	}
}
