
import java.util.Random;
public class Carer {
	
	private String carerName;
	private float FOOD_RATE;
	private float TOY_RATE;
	private float SLEEP_RATE;
	private float HYGIENE_RATE; 
	
	private boolean isLeave;
	private boolean isWithChildren;
	private int amount;
	private int actionNumber;
	private boolean isTheWay;
	private Child child;
	
	Random rnd = new Random();

	Carer(int carerID){
		carerName = "Cr" + ((carerID < 10) ? "0" + carerID : carerID);
		FOOD_RATE = rnd.nextInt(13) + 6;
		TOY_RATE = rnd.nextInt(7) + 3;
		SLEEP_RATE = rnd.nextInt(11) + 5;
		HYGIENE_RATE = rnd.nextInt(17) + 8;
		isLeave = false;
		isWithChildren = false;
		isTheWay = false;
		actionNumber = 0;
		child = null;
		amount = 0;
	}
	
	public boolean isLeave() {
		return isLeave;
	}
	public void setLeave(boolean isLeave) {
		this.isLeave = isLeave;
	}
	public boolean getIsWithChildren() {
		return isWithChildren;
	}
	public void setWithChildren(boolean isWithChildren) {
		this.isWithChildren = isWithChildren;
	}
	public boolean getIsTheWay() {
		return isTheWay;
	}
	public void setIsTheWay(boolean isTheWay) {
		this.isTheWay = isTheWay;
	}
	public int getActionNumber() {
		return actionNumber;
	}
	public void setActionNumber(int actionNumber) {
		this.actionNumber = actionNumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Child getChild() {
		return child;
	}
	public void setChild(Child child) {
		this.child = child;
	}
	public String getCarerName() {
		return carerName;
	}
	public float getFOOD_RATE() {
		return FOOD_RATE;
	}
	public float getGAME_RATE() {
		return TOY_RATE;
	}
	public float getSLEEP_RATE() {
		return SLEEP_RATE;
	}
	public float getHYGIENE_RATE() {
		return HYGIENE_RATE;
	}
	
	public float toFeed() {
		
		if (amount > 0 && amount > FOOD_RATE) {
			child.setFood(child.getFood() + FOOD_RATE);
			amount -= FOOD_RATE;
			return FOOD_RATE;
		}
		else if (amount > 0 && amount < FOOD_RATE ){
			child.setFood(child.getFood() + amount);
			child = null;
			actionNumber = 0;
			isWithChildren = false;
			isTheWay = true;
			amount = 0;
			return amount;
		}		
		else {
			amount = 0;
			child.setChildAccessible(true);
			child = null;
			actionNumber = 0;
			isWithChildren = false;
			isTheWay = true;
			return 0;
		}
	
		
		
	}
	public float toToy() {
		
		if (amount > 0) {
			child.setToy(child.getToy() + TOY_RATE);
			amount -= TOY_RATE;
			return TOY_RATE;
		}
		else if (amount > 0 && amount < TOY_RATE ){
			child.setFood(child.getToy() + amount);
			child = null;
			actionNumber = 0;
			isWithChildren = false;
			isTheWay = true;
			amount = 0;
			return amount;
		}	
		else {
			amount = 0;
			child.setChildAccessible(true);
			child = null;
			actionNumber = 0;
			isWithChildren = false;
			isTheWay = true;
			return 0;
		}
		
	}
	public float toSleep() {
		
		if (amount > 0) {
			child.setSleep(child.getSleep() + SLEEP_RATE);
			amount -= SLEEP_RATE;
			return SLEEP_RATE;
		}
		
		else if (amount > 0 && amount < SLEEP_RATE ){
			child.setFood(child.getSleep() + amount);
			child = null;
			actionNumber = 0;
			isWithChildren = false;
			isTheWay = true;
			amount = 0;
			return amount;
		}	
		
		else {
			amount = 0;
			child.setChildAccessible(true);
			child = null;
			actionNumber = 0;
			isWithChildren = false;
			isTheWay = true;
			return 0;
		}
		
	}	
	public float toHygine(){
		
		if (amount > 0) {
			child.setSleep(child.getHygiene() + HYGIENE_RATE);
			amount -= HYGIENE_RATE;
			return HYGIENE_RATE;
		}
		else if (amount > 0 && amount < HYGIENE_RATE ){
			child.setFood(child.getToy() + amount);
			child = null;
			actionNumber = 0;
			isWithChildren = false;
			isTheWay = true;
			amount = 0;
			return amount;
		}	
		else {
			amount = 0;
			child.setChildAccessible(true);
			child = null;
			actionNumber = 0;
			isWithChildren = false;
			isTheWay = true;
			return 0;
		}
		
	}
	public float[] check() {
		
		float che[] = {0,0,0,0};
		che[0] = child.getFood();
		che[1] = child.getToy();
		che[2] = child.getSleep();
		che[3] =  child.getHygiene();
		
		child.setChildAccessible(true);
		child = null;
		actionNumber = 0;
		isTheWay = true;
		isWithChildren = false;
		
		
		return che;
		
	}	
	public void returnFromJob(){
		
		child.setChildAccessible(true);
		child = null;
		actionNumber = 0;
		isWithChildren = false;		
		isTheWay = true;
		
	}
	public float terminate(float credit){
		
		actionNumber = 0;
		isLeave = true;
		return credit-50;
		
		
	}
	
	


	
}
