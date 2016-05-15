
import java.util.Random;

public class Application {

	Random rnd = new Random();

	public void create(float averageHap){	
		if (rnd.nextInt(50) < 10 && !DayCenter.maxCarer) {
			DayCenter.cn.getTextWindow().setCursorPosition(0,4);
			System.out.print("3." + "Carer -  " + " F: " + createCarer().getFOOD_RATE() + "  " +
												  " G: " + createCarer().getGAME_RATE() + "  " +
												  " S: " + createCarer().getSLEEP_RATE() + "  " +
												  " H: " + createCarer().getHYGIENE_RATE());
			
			
		}
		if (rnd.nextInt(50) < 10 && !DayCenter.maxWorker){
			DayCenter.cn.getTextWindow().setCursorPosition(0,3);
			createWorker();
			System.out.print("2.Worker"); 
			
		}
		if (rnd.nextInt(50) < 20 && !DayCenter.maxChild){
			if (averageHap >= 65) {
				DayCenter.cn.getTextWindow().setCursorPosition(0,2);
				System.out.print("1." + "Child -  " + " F: " + createChild().getFOOD_RATE() + "  " +
													  " G: " + createChild().getGAME_RATE() + "  " + 
													  " S: " + createChild().getSLEEP_RATE() + "  " +
													  " H: " + createChild().getHYGIENE_RATE());
			}
		}
		DayCenter.maxCarer = true; 
		DayCenter.maxWorker = true;
		DayCenter.maxChild = true;

	}	
	public Child createChild(){
		Child child = new Child(DayCenter.chCount + 1);  
		return child;
	}
	public Carer createCarer() {
		Carer carer = new Carer(DayCenter.caCount + 1);
		return carer;
	}	
	public Worker createWorker() {
		Worker worker = new Worker(DayCenter.woCount + 1);
		return worker;
	}	
	
}
