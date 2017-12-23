import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CreepingGame {
	
     int ANT_COUNT = 5;
     float STICK_LENGTH = 300;
     float INIT_POSITIONS[] = {30,80,110,160,250};
     float curr_time ;      //确定当前所运行时间
     float cost_time = 0 ;  //到下一次碰撞所花费的时间
     float final_time = 0;  //当下一次不会碰撞时，所有蚂蚁脱离杆子的时间
     boolean isOver = false ;  //判断下一次是否会有碰撞发生
    Stick stick;
    List<Ant> ants = new ArrayList<Ant>();
    List<Float> stick_distance = new ArrayList<Float>();
    

    public void detectCollision() {
    	        List<CollisionId> collisionId = new ArrayList<CollisionId>();
    	        //检测碰撞，并将下一次可能的碰撞加入碰撞检测集合
    	        for(int i = 0;i<4;i++) {
    	        	if(ants.get(i).getDirection() ==1 && ants.get(i+1).getDirection() ==-1) {
    	        		CollisionId cId = new CollisionId();
    	        		cId.setFirstId(ants.get(i).getId());
    	        		cId.setSecondId(ants.get(i+1).getId());
    	        		cId.setDistance(ants.get(i+1).getPosition() - ants.get(i).getPosition());
    	        		collisionId.add(cId);
    	        		Collections.sort(collisionId);
    	        	}
    	        	
    	
    }
              //集合不为空，意味着会有碰撞发生，筛选出最近的一次碰撞
    	        if(collisionId.size() != 0) {
    	        	     Collections.sort(collisionId);
    	        	     CollisionId collisionId2 = new CollisionId();
    	        	     collisionId2 = collisionId.get(0);
    	        	     cost_time = collisionId2.getDistance() / 10;
    	        	     for(int i = 0;i<ANT_COUNT;i++) {
    	      	    	   ants.get(i).creep(cost_time);
    	      	       }
  	        	     ants.get(collisionId2.getFirstId()).changeDirection();
       	        	 ants.get(collisionId2.getSecondId()).changeDirection();
    	        	     
    	        	     
    	        }
    	        // 下一次不会碰撞，则求出蚂蚁脱离杆子的最大时间
    	        else {
    	        	float distance;
    	        	for( int i = 0;i <5;i++) {
    	        		if(ants.get(i).getDirection() == -1) {
    	        			distance = ants.get(i).getPosition() - 0;
    	        			stick_distance.add(distance);
    	        			
    	        		}
    	        		else {
    	        			distance = 300 - ants.get(i).getPosition();
    	        			stick_distance.add(distance);
    	        		}
    	        		
    	        	}
    	        	Collections.sort(stick_distance,Collections.reverseOrder());
    	        	final_time = stick_distance.get(0) / 5;
    	        	isOver = true;
    	        	
    	        }
    	        
    	        	
    	        
    }
    
      public float playGame() {
      //统计每一次运行的总时间  
    	  while(!isOver) {
        		curr_time += cost_time;  
        		detectCollision();
        	}
        	    curr_time += final_time;
        	return curr_time;
	
            }

    
	public  CreepingGame(List<Integer> direction) {
		this.curr_time = 0;
		stick = new Stick();
		stick.setMin(0);
		stick.setMax(STICK_LENGTH);
		//初始化蚂蚁信息
		for(int i = 0;i< ANT_COUNT;i++) {
			Ant ant = new Ant();
			ant.setDirection(direction.get(i));
			ant.setId(i);
			ant.setPosition(INIT_POSITIONS[i]);
			ants.add(i, ant);
		}

		
	}
    
}

