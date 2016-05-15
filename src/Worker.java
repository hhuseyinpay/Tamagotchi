

public class Worker {
	
	private String workerName;
	
	private boolean isLeave;
	private boolean isWithChildren;
	private boolean isOnMarket;
	private int     actionNumber;	
	private Child   child;
	
	private int food;
	private int toy;
	private int hygiene;
	

	Worker(int workerID){
		workerName = "Wr" + ((workerID < 10) ? "0" + workerID : workerID);
		isLeave = false;
		isWithChildren = false;
		isOnMarket = false;
		actionNumber = 0;
		child = null;
		food = 0;
		toy = 0;
		hygiene = 0;
	}
	
	
	
	
	public boolean isLeave() {
		return isLeave;
	}




	public void setLeave(boolean isLeave) {
		this.isLeave = isLeave;
	}




	public boolean isWithChildren() {
		return isWithChildren;
	}

	public void setWithChildren(boolean isWithChildren) {
		this.isWithChildren = isWithChildren;
	}

	public boolean isOnMarket() {
		return isOnMarket;
	}

	public void setOnMarket(boolean isOnMarket) {
		this.isOnMarket = isOnMarket;
	}



	

	public int getActionNumber() {
		return actionNumber;
	}

	public void setActionNumber(int actionNumber) {
		this.actionNumber = actionNumber;
	}

	public Child getChild() {
		return child;
	}




	public void setChild(Child child) {
		this.child = child;
	}




	public int getFood() {
		return food;
	}




	public void setFood(int food) {
		this.food = food;
	}




	public int getToy() {
		return toy;
	}




	public void setToy(int toy) {
		this.toy = toy;
	}




	public int getHygiene() {
		return hygiene;
	}




	public void setHygiene(int hygiene) {
		this.hygiene = hygiene;
	}




	public String getWorkerName() {
		return workerName;
	}
	
	public void returnFromJob(){
		
		isWithChildren = false;
		child.setChildAccessible(true);
		isOnMarket = false;
		actionNumber = 0;
		child = null;
			
	}
	
	public float terminate(float credit){
		
		actionNumber = 0;
		isLeave = true;
		return credit-30;
		
	}
	
	public void find(){
		child.setMissing(child.getMissing() - 1);
	}
	public void check(){
		child.setChildAccessible(true);
		child = null;
		actionNumber = 0;
		isWithChildren = false;
	}
	
	


	
}
