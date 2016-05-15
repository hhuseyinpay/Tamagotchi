
import java.util.*;

public class Child {
	
	private boolean isChildAccessible; 
	private boolean isChildLeave; 
	private boolean isMissing;
	
	private String name;
	
	private float FOOD_RATE;
	private float TOY_RATE;
	private float SLEEP_RATE;
	private float HYGIENE_RATE;
	
	private float FOOD_HAPP_RATE = (float) 0.24; 
	private float GAME_HAPP_RATE = (float) 0.12;
	private float SLEEP_HAPP_RATE = (float) 0.08;
	private float HYGIENE_HAPP_RATE = (float) 0.06;
	
	private float food;
	private float toy;
	private float sleep;
	private float hygiene;
	
	private float happiness;
	private int missing;			
	Random rnd = new Random();
	
	Child(int childID){
		
		name = "Ch" +  (( childID < 10) ? "0" + childID : childID );	
		food = rnd.nextInt(21) + 40;
		toy = rnd.nextInt(21) + 40;
		sleep = rnd.nextInt(21) + 40;
		hygiene = rnd.nextInt(21) + 40;
		FOOD_RATE = (float) ( rnd.nextInt(101) + 50 ) / 100;
		TOY_RATE = (float) ( rnd.nextInt(101) + 50 ) / 100;
		SLEEP_RATE = (float) ( rnd.nextInt(51) + 25 ) / 100;
		HYGIENE_RATE = (float) ( rnd.nextInt(31) + 20 ) / 100;
		happiness = rnd.nextInt(21) + 40;
		missing = 0; 
		isChildAccessible = true;
		isChildLeave = false;
		isMissing = false;
		
	} 

	public float getFOOD_HAPP_RATE() {
		return FOOD_HAPP_RATE;
	}

	public void setFOOD_HAPP_RATE(float fOOD_HAPP_RATE) {
		FOOD_HAPP_RATE = fOOD_HAPP_RATE;
	}

	public float getGAME_HAPP_RATE() {
		return GAME_HAPP_RATE;
	}

	public void setGAME_HAPP_RATE(float gAME_HAPP_RATE) {
		GAME_HAPP_RATE = gAME_HAPP_RATE;
	}

	public float getSLEEP_HAPP_RATE() {
		return SLEEP_HAPP_RATE;
	}

	public void setSLEEP_HAPP_RATE(float sLEEP_HAPP_RATE) {
		SLEEP_HAPP_RATE = sLEEP_HAPP_RATE;
	}

	public float getHYGIENE_HAPP_RATE() {
		return HYGIENE_HAPP_RATE;
	}

	public void setHYGIENE_HAPP_RATE(float hYGIENE_HAPP_RATE) {
		HYGIENE_HAPP_RATE = hYGIENE_HAPP_RATE;
	}

	public boolean getIsChildAccessible() {
		return isChildAccessible;
	}

	public void setChildAccessible(boolean isChildAccessible) {
		this.isChildAccessible = isChildAccessible;
	}

	public boolean getIsChildLeave() {
		return isChildLeave;
	}

	public void setChildLeave(boolean isChildLeave) {
		this.isChildLeave = isChildLeave;
	}
	


	public boolean isMissing() {
		return isMissing;
	}

	public void setMissing(boolean isMissing) {
		this.isMissing = isMissing;
	}

	public String getName() { return name; }
	public float getFOOD_RATE() { return FOOD_RATE; }
	public float getGAME_RATE() { return TOY_RATE; }
	public float getSLEEP_RATE() { return SLEEP_RATE; }
	public float getHYGIENE_RATE() { return HYGIENE_RATE; }
	
	public float getFood(){ return food;}
	public float getToy(){ return toy;}
	public float getSleep(){ return sleep;}
	public float getHygiene(){ return hygiene;}

	public void setFood(float food) { this.food = food; }
	public void setToy(float toy) { this.toy = toy; }
	public void setSleep(float sleep) {this.sleep = sleep; }
	public void setHygiene(float hygiene) { this.hygiene = hygiene; }
	
	public float getHappiness() { return happiness; }
	public int getMissing() { return missing; }
	public void setHappiness(float happiness) { this.happiness = happiness; }
	public void setMissing(int missing) { this.missing = missing; }
	
	
	
}
