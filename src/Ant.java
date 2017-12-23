
public class Ant {
	
     private int id;
     private float speed = 5;
     private float position;
     private int direction;
     
	
     public int getDirection() {
		return direction;
	}

	public void changeDirection() {
		this.direction = -this.direction;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
		
	}
	
	public void creep(float incTIme) {
	    this.position += incTIme * this.speed * this.direction;
		
	}
	
	public boolean isOut(Stick s) {
		if(this.position >= s.getMax() || this.position <= s.getMin())
			return true;
		else 
			return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPosition() {
		return position;
	}

	public void setPosition(float position) {
		this.position = position;
	}
	
	
	
	
}
