package data;

public class TirArc extends Sport
{
	private int target_distance;
	private String affected_area;
	
	
	public Archery(int target_distance,String affected_area) {
		this.target_distance=target_distance;
		this.affected_area=affected_area;
		
		
	}
	public int gettarget_distance() {
		
		
		return target_distance;
	}
	
	public String getaffected_area() {
		
		return affected_area;
		
		
	}
	
	public void settarget_distance(int target_distance) {
		
		this.target_distance=target_distance;
	}

	public void setaffected_area(String affected_area) {
		
		
	this.affected_area=affected_area;	
		
		
	}

}
