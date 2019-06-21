package Main;

import java.util.ArrayList;
import java.util.Collections;

public class GeradorBoundingBox {
	private ArrayList<String> coordenadasMunicipio;

	public ArrayList<String> getCoordenadasMunicipio() {
		return coordenadasMunicipio;
	}

	public void setCoordenadasMunicipio(ArrayList<String> coordenadasMunicipio) {
		this.coordenadasMunicipio = coordenadasMunicipio;
	}

	public Object gerarBoundingBox(String coordenadas) {
		String LatLong[] = coordenadas.split(",0");
		
		int tamanhoLong = pegarLongitudes(LatLong).size();
		double maxLong = pegarLongitudes(LatLong).get(0);
		double minLong = pegarLongitudes(LatLong).get(tamanhoLong - 1);
		
		int tamanhoLat = pegarLatitudes(LatLong).size();
		double maxLat = pegarLatitudes(LatLong).get(0);
		double minLat = pegarLatitudes(LatLong).get(tamanhoLat - 1);
		

		BoundingBox boundingBox = new BoundingBox(maxLong, minLong, maxLat, minLat);
		return boundingBox;
		
	}
	
	public ArrayList<Double> pegarLongitudes(String[] LatLong) {
		ArrayList<Double> longitude = new ArrayList<Double>();
		
		for(int i = 0; i < LatLong.length - 1; i++) {
			String[] LatLongSeparados = LatLong[i].split(",");
			longitude.add(Double.parseDouble(LatLongSeparados[0]));
		}
		
		Collections.sort(longitude);
		return longitude;
	}
	
	public ArrayList<Double> pegarLatitudes(String[] LatLong) {
		ArrayList<Double> latitude = new ArrayList<Double>();
		
		for(int i = 0; i < LatLong.length - 1; i++) {
			String[] LatLongSeparados = LatLong[i].split(",");
			latitude.add(Double.parseDouble(LatLongSeparados[1]));
		}
		
		Collections.sort(latitude);
		return latitude;
	}
}

