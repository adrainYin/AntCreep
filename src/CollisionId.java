

public class CollisionId implements Comparable<CollisionId>{
	
	private int firstId;
	private int secondId;
	private float distance;
	
	public CollisionId(int firstId,int secondId,float distance) {
		
		this.firstId = firstId;
		this.secondId = secondId;
		this.distance = distance ;
		
	}
	
	public  CollisionId() {
		// TODO Auto-generated constructor stub
	}
		
	
	public int getFirstId() {
		return firstId;
	}
	public void setFirstId(int firstId) {
		this.firstId = firstId;
	}
	public int getSecondId() {
		return secondId;
	}
	public void setSecondId(int secondId) {
		this.secondId = secondId;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	@Override
	public int compareTo(CollisionId o) {
		// TODO Auto-generated method stub
		
		return (int) (this.distance-o.distance);
	}

}
