import java.util.ArrayList;
import java.util.List;

public class PlayRoom {
	
	//float incTime;
	float curr_Time;
	int allDirections[];
	float minTime;
	float maxTime;
	CreepingGame creepingGame;
	public void budildAllDirections() {
		allDirections = new int[32 * 5];
		//用二进制表示所有的-1和1的组合
		for(int i=0;i < 32; i++) {
			int curr_i = i;
			int directions[] = {0,0,0,0,0};
			for(int j = 0;j < 5;j++) {
				int sign = curr_i % 2;
				curr_i = curr_i/2;
				if(sign == 1)
					directions[j] = 1;
				else
					directions[j] = -1;
				allDirections[i * 5 + j] = directions[j];
				
				
			}
			
		}
		
	}
	
	public void playGame() {
		for(int i =0;i<32;i++) {
			List<Integer> curr_direction = new ArrayList<Integer>();
			for(int j =0;j<5;j++) {
				curr_direction.add(j, allDirections[i*5+j]);
			
			}
			creepingGame = new CreepingGame(curr_direction);
			float duration = creepingGame.playGame();
			updateMinAndMax(duration);
			System.out.println("第"+(i+1) +"次用时"+duration+"秒");
		}
		
		System.out.println("最小用时为" + minTime +"秒");
		System.out.println("最大用时为" + maxTime +"秒");
	}
	
	public void updateMinAndMax(float time) {
		
		if(time < minTime)
			minTime = time;
		if(time > maxTime)
			maxTime = time;
		
		
	}
	public PlayRoom() {
		curr_Time = 0;
		budildAllDirections();
		minTime = 9999;
		maxTime = 0;
	}

}
