package Main;

public class BoundingBox {

	private double maxLong;
	private double minLong;
	private double maxLat;
	private double minLat;
	
	public BoundingBox(double maxLong, double minLong, double maxLat, double minLat) {
		this.maxLat = maxLat;
		this.minLat = minLat;
		this.maxLong = maxLong;
		this.minLong = minLong;
	}

	public double getMaxLat() {
		return maxLat;
	}
	
	public void setMaxLat(double maxLat) {
		this.maxLat = maxLat;
	}
	
	public double getMinLat() {
		return minLat;
	}
	
	public void setMinLat(double minLat) {
		this.minLat = minLat;
	}
	
	public double getMaxLong() {
		return maxLong;
	}
	
	public void setMaxLong(double maxLong) {
		this.maxLong = maxLong;
	}
	
	public double getMinLong() {
		return minLong;
	}
	
	public void setMinLong(double minLong) {
		this.minLong = minLong;
	}

	public String toString(){
		String boundingBoxString = String.format("minLat: %f \n minLong: %f \n maxLat: %f \n maxLong: %f \n", this.minLat, this.minLong, this.maxLat, this.maxLong);
		return boundingBoxString;
	}
}
