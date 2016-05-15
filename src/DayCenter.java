import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.Random;

import enigma.core.Enigma;

public class DayCenter {

	// ----- Application ----- //

	public static boolean maxCarer = false;
	public static boolean maxWorker = false;
	public static boolean maxChild = false;

	Application application = new Application();

	// ---------------------------------- //

	public static enigma.console.Console cn = Enigma
			.getConsole("Tamagotchi Virtual Day Care Center",120,35,true);

	// ---------------------------------- //

	public float credit;
	public float averageHap;
	public float score;
	public int day = 0;
	public int turn;

	public static Child[] children = new Child[1000];
	public static Carer[] carers = new Carer[1000];
	public static Worker[] workers = new Worker[1000];
	public static int chCount = 0;
	public static int caCount = 0;
	public static int woCount = 0;

	// ----------------------------------

	// Supplies of Day Care Center
	Random rnd = new Random();
	float totalFood = rnd.nextInt(51) + 25;
	float totalGame = rnd.nextInt(51) + 25;
	float totalHygiene = rnd.nextInt(51) + 25;

	// ----------------------------------

	// key listener----------------
	public int commandCursorX = 10;
	public int keypr; // key pressed?
	public int rkey; // key (for press/release)
	public KeyListener klis;
	public String command = "";
	public int isEntered = 0;

	// -----------------------------

	public void clear() {
		cn.getTextWindow().setCursorPosition(0, 0);
		for (int y = 0; y < 25; y++) {
			if (y == 2 || y == 3 || y == 4) continue;
			for (int x = 0; x < 120; x++) {	
				cn.getTextWindow().setCursorPosition(x, y);
				System.out.println(" ");
			}
		}
		cn.getTextWindow().setCursorPosition(0, 0);
	}

	public void mainMenu() {
		cn.getTextWindow().setCursorPosition(5, 5);
		System.out
				.println("|--------------------------------------------------------|");
		cn.getTextWindow().setCursorPosition(5, 6);
		System.out
				.println("|              Tamagotchi Virtual Day Care Center        |");
		cn.getTextWindow().setCursorPosition(5, 7);
		System.out
				.println("|--------------------------------------------------------|");

		cn.getTextWindow().setCursorPosition(5, 9);
		System.out
				.println("|-------------------------------------------------|");
		cn.getTextWindow().setCursorPosition(5, 10);
		System.out
				.println("|           Enter 1: Start Game                   |");
		cn.getTextWindow().setCursorPosition(5, 11);
		System.out
				.println("|-------------------------------------------------|");

		cn.getTextWindow().setCursorPosition(5, 12);
		System.out
				.println("|-------------------------------------------------|");
		cn.getTextWindow().setCursorPosition(5, 13);
		System.out
				.println("|           Enter 2: About Game                   |");
		cn.getTextWindow().setCursorPosition(5, 14);
		System.out
				.println("|-------------------------------------------------|");

		cn.getTextWindow().setCursorPosition(5, 15);
		System.out
				.println("|-------------------------------------------------|");
		cn.getTextWindow().setCursorPosition(5, 16);
		System.out
				.println("|           Enter 3: Exit                         |");
		cn.getTextWindow().setCursorPosition(5, 17);
		System.out
				.println("|-------------------------------------------------|");

		cn.getTextWindow().setCursorPosition(5, 21);
		System.out.print("Enter Your Choice: ");
		switch (cn.readLine()) {
		case "1":
			clear();
			System.out.println("Hi Bro!");
			break;
		case "2":
			clear();
			System.out.println("Bla bla");
			break;
		case "3":
			clear();
			System.exit(0);
		default:
			System.out.println("Wrong Entry Bro!");
			break;
		}
	}

	public void print() {
		cn.getTextWindow().setCursorPosition(0, 0);
		System.out.print("Day: " + day + "      Turn: " + turn
				+ "      Current Avg.Happiness: " + averageHap + "      Credit: "
				+ credit + "      Score: " + score + "\n" + "--- Applications ---");
		cn.getTextWindow().setCursorPosition(100, 2);
		System.out.print("-- Supplies --");
		cn.getTextWindow().setCursorPosition(100, 3);
		System.out.print("Food: " + totalFood);
		cn.getTextWindow().setCursorPosition(100, 4);
		System.out.print("Toy: " + totalGame);
		cn.getTextWindow().setCursorPosition(100, 5);
		System.out.print("Hygiene: " + totalHygiene);
		cn.getTextWindow().setCursorPosition(0, 5);
		System.out.print("--- Children ---" + "\n");
		int countLine = 3;
		int space = 0;
		
		int verticalLine = 7;
		int verticalSpace = 100;
		

		for (int i = 0; i < chCount; i++) {
			
			if (i % 4 == 0) {
				countLine += 3;
				space = 0;
			}
			
			cn.getTextWindow().setCursorPosition(space , countLine);
			System.out.print(children[i].getName() + " ");
			
			
			if (!children[i].getIsChildAccessible() && !children[i].getIsChildLeave()){
				
				for (int j = 0; j < caCount; j++) { // hangi metot tetiklendiyse onun attributuyle yazdýrma iþlemi
					if (carers[j].getChild() == children[i]){
						
						cn.getTextWindow().setCursorPosition(space, countLine + 1);
						
						System.out.print(carers[j].getCarerName());
						
						boolean writeFlag = false;
						
						if (carers[j].getActionNumber() == 1){
							cn.getTextWindow().setCursorPosition(space+5, countLine);
							System.out.print("F: " + (int) children[i].getFood());
							cn.getTextWindow().setCursorPosition(space+5, countLine + 1);
							System.out.print("F: " + (int) carers[j].getAmount());
							
						}
						else if (carers[j].getActionNumber() == 2){
							cn.getTextWindow().setCursorPosition(space+5, countLine);
							System.out.print("G: " + (int) children[i].getToy());
							cn.getTextWindow().setCursorPosition(space+5, countLine + 1);
							System.out.print("G: " + (int) carers[j].getAmount());
						}
						else if (carers[j].getActionNumber() == 3){
							cn.getTextWindow().setCursorPosition(space+5, countLine);
							System.out.print("S: " + (int) children[i].getSleep());
							cn.getTextWindow().setCursorPosition(space+5, countLine+1);
							System.out.print("S: " + (int) carers[j].getAmount());
						}						
						else if (carers[j].getActionNumber() == 4){
							cn.getTextWindow().setCursorPosition(space+5, countLine);
							System.out.print("H: " + (int) children[i].getHygiene());
							cn.getTextWindow().setCursorPosition(space+5, countLine+1);
							System.out.print("H: " + (int) carers[j].getAmount());
						}
						else if (carers[j].getActionNumber() == 5){		
							cn.getTextWindow().setCursorPosition(space+5, countLine);
							System.out.print("M: ");
							if (children[i].getMissing() != 0){
								
								System.out.print(children[i].getMissing());	
								writeFlag = true;
							}
							
							
						}
						
						
						
						
						if (writeFlag){
							cn.getTextWindow().setCursorPosition(verticalSpace, verticalLine);
							System.out.print(children[i].getName());
							verticalLine++;
							cn.getTextWindow().setCursorPosition(verticalSpace, verticalLine);
							System.out.print("Missing: " + children[i].getMissing());
						}
						else {
							cn.getTextWindow().setCursorPosition(verticalSpace, verticalLine);
							System.out.print(children[i].getName());
							verticalLine++;
							cn.getTextWindow().setCursorPosition(verticalSpace, verticalLine);
							System.out.print("Happy: " + (int) children[i].getHappiness());
							verticalLine++;
							cn.getTextWindow().setCursorPosition(verticalSpace, verticalLine);
							System.out.print("F: " + (int) children[i].getFood() + " G: " + (int) children[i].getToy());
							verticalLine++;
							cn.getTextWindow().setCursorPosition(verticalSpace, verticalLine);
							System.out.print("S: " + (int) children[i].getSleep() + " H: " + (int) children[i].getHygiene());
						}
						
						
						
						
						
					}
				}
				for (int j = 0; j < woCount; j++) {
					
					if (workers[j].getChild() == children[i]){
						
						if (workers[j].getActionNumber() == 3){
							cn.getTextWindow().setCursorPosition(verticalSpace, verticalLine);
							System.out.print(children[i].getName());
							verticalLine++;
							cn.getTextWindow().setCursorPosition(verticalSpace, verticalLine);
							System.out.print("Happy: " + (int) children[i].getHappiness());
							verticalLine++;
							cn.getTextWindow().setCursorPosition(verticalSpace, verticalLine);
							System.out.print("F: " + (int) children[i].getFood() + " G: " + (int) children[i].getToy());
							verticalLine++;
							cn.getTextWindow().setCursorPosition(verticalSpace, verticalLine);
							System.out.print("S: " + (int) children[i].getSleep() + " H: " + (int) children[i].getHygiene());
						}
						
						
						else if (workers[j].getActionNumber() == 4){
							System.out.print("M: ");
							if (children[i].getMissing() != 0)
								System.out.print(children[i].getMissing());
							
							cn.getTextWindow().setCursorPosition(space-5, countLine + 1);
							System.out.print(workers[j].getWorkerName()); 
																			
						}
						
						
					}
					
				}
			
			}
			
			space += 12;

		}
		
		cn.getTextWindow().setCursorPosition(0, 15);
		System.out.print("--- Carers ----");
		System.out.println();
		
		for (int i = 0; i < caCount; i++) {
			if (!carers[i].isLeave()){
				System.out.print(carers[i].getCarerName());
				
				if (carers[i].getIsWithChildren()){
					System.out.print(" ( " + carers[i].getChild().getName() + " ");
					if (carers[i].getActionNumber() == 1){
						System.out.print("Food: " + carers[i].getAmount() + " )");
					}
					else if (carers[i].getActionNumber() == 2){
						System.out.print("Game: " + carers[i].getAmount()+ " )");
					}
					else if (carers[i].getActionNumber() == 3){
						System.out.print("Sleep: " + carers[i].getAmount()+ " )");
					}
					else if (carers[i].getActionNumber() == 4){
						System.out.print("Hygiene: " + carers[i].getAmount()+ " )");
					}
					else if (carers[i].getActionNumber() == 5){ //!! problemli eleman
						System.out.print("Check " + " )");
					}
					
				}
				
				System.out.print(" F: " + carers[i].getFOOD_RATE() + " G: "
										+ carers[i].getGAME_RATE() + " S: "
										+ carers[i].getSLEEP_RATE() + " H: "
										+ carers[i].getHYGIENE_RATE() + "\n");				
			}
		}

		cn.getTextWindow().setCursorPosition(0, 20);
		System.out.print("--- Workers ---" + "\n");
		for (int i = 0; i < woCount; i++) {
			
			if (!workers[i].isLeave()) {
				System.out.print(workers[i].getWorkerName());
				
				
				if (workers[i].getActionNumber() == 3){
					System.out.print(" ( Check ) ");
				}
				else if (workers[i].getActionNumber() == 4) {
					System.out.print(" ( Market: " + "Food: " + workers[i].getFood() + 
										" Game: " + workers[i].getToy() + " Hygiene: " 
										+ workers[i].getHygiene() + " )");
				}
				System.out.println();
			}
					
		}
		cn.getTextWindow().setCursorPosition(0, 25);
		System.out.println("Command > ");

	}

	public void accept(int number) {
		if (number == 1) {
			for (int i = 0; i < 60; i++) {
				DayCenter.cn.getTextWindow().setCursorPosition(i, 2);
				System.out.print(" ");
			}
			children[chCount] = application.createChild();
			chCount++;
		} else if (number == 2) {
			for (int i = 0; i < 60; i++) {
				DayCenter.cn.getTextWindow().setCursorPosition(i, 3);
				System.out.print(" ");
			}
			workers[woCount] = application.createWorker();
			woCount++;
		} else {
			for (int i = 0; i < 60; i++) {
				DayCenter.cn.getTextWindow().setCursorPosition(i, 4);
				System.out.print(" ");
			}
			carers[caCount] = application.createCarer();
			caCount++;
		}
	}

	// ------------------------------

	DayCenter() throws Exception {

		children[chCount] = new Child(1);
		chCount++;

		averageHap = 0;

		carers[caCount] = new Carer(1);
		caCount++;

		workers[woCount] = new Worker(1);
		woCount++;
		
		credit = 200;
		score = 0;
		day++;

		keyListener(cn);

		Calendar rightNow = Calendar.getInstance();
		long offset = rightNow.get(Calendar.ZONE_OFFSET)
				+ rightNow.get(Calendar.DST_OFFSET);
		long sinceMidnight1 = (rightNow.getTimeInMillis() + offset);

		String[] input;


		int amount = 0;
		int indexNoCh = 0;
		int indexNoCa = 0;
		int indexNoWo = 0;
		int appTimeCounter = 0;
		int marketCounter = 0;
		
		
		
		while (true) {

			print();
			// -----------------------------------------------------------------------------\\
			rightNow = Calendar.getInstance();
			offset = rightNow.get(Calendar.ZONE_OFFSET)
					+ rightNow.get(Calendar.DST_OFFSET);
			long sinceMidnight2 = (rightNow.getTimeInMillis() + offset);
			// -----------------------------------------------------------------------------\\

			
			if (credit < 0) 
				break;
			
			
			// --------------------------Application----------------------------

			application.create(averageHap);

			if (appTimeCounter == 10) {

				maxChild = false;
				maxWorker = false;
				maxCarer = false;

				for (int y = 2; y < 5; y++) {
					for (int x = 0; x < 50; x++) {
						cn.getTextWindow().setCursorPosition(x, y);
						System.out.print(" ");
					}
				}
				appTimeCounter = 0;
			}

			// ---------------------------------------------------------------------

			DayCenter.cn.getTextWindow().setCursorPosition(commandCursorX, 25);

			if (keypr == 1) { // if keyboard button pressed

				cn.getTextWindow().output((char) rkey);
				commandCursorX++;
				keypr = 0; // last action
			}
			if (isEntered == 1) {
				isEntered = 0;

				for (int i = 10; i < 50; i++) {
					cn.getTextWindow().setCursorPosition(i, 25);
					System.out.print(" ");
				}

				commandCursorX = 10;				
				input = command.toLowerCase().split(" ");
				command = "";
				
				
				boolean allOfState = true;

				if (input[0].substring(0, 2).equalsIgnoreCase("cr")) {

					indexNoCa = Integer.parseInt(input[0].substring(2)) - 1;

					if (!input[1].equals("r") && !input[1].equals("t") && !input[1].equals("c")) {

						indexNoCh = Integer.parseInt(input[2].substring(2)) - 1;						
						amount = Integer.parseInt(input[3]);

						allOfState = !carers[indexNoCa].isLeave()
								&& 	!carers[indexNoCa].getIsWithChildren()
								&& !children[indexNoCh].getIsChildLeave()
								&& children[indexNoCh].getIsChildAccessible();

					}

					switch (input[1]) {
					case "f":
						if (allOfState && amount > 0 && amount < totalFood
								&& amount < 26) {

							carers[indexNoCa].setChild(children[indexNoCh]);
							carers[indexNoCa].setAmount(amount);
							carers[indexNoCa].setActionNumber(1);
							carers[indexNoCa].setWithChildren(true);
							children[indexNoCh].setChildAccessible(false);

						}
						break;
					case "g":
						if (allOfState && amount > 0 && amount < 26 && amount < totalGame) {

							carers[indexNoCa].setChild(children[indexNoCh]);
							carers[indexNoCa].setAmount(amount);
							carers[indexNoCa].setActionNumber(2);
							carers[indexNoCa].setWithChildren(true);
							children[indexNoCh].setChildAccessible(false);

						}
						break;
					case "s":
						if (allOfState && amount > 0 && amount < 26 ) {

							carers[indexNoCa].setChild(children[indexNoCh]);
							carers[indexNoCa].setAmount(amount);
							carers[indexNoCa].setActionNumber(3);
							carers[indexNoCa].setWithChildren(true);
							children[indexNoCh].setChildAccessible(false);

						}

						break;
					case "h":
						if (allOfState && amount > 0 && amount < 26 && amount < totalHygiene) {

							carers[indexNoCa].setChild(children[indexNoCh]);
							carers[indexNoCa].setAmount(amount);
							carers[indexNoCa].setActionNumber(4);
							carers[indexNoCa].setWithChildren(true);
							children[indexNoCh].setChildAccessible(false);

						}
						break;
					case "c": // check
						if (allOfState) {

							carers[indexNoCa].setChild(children[indexNoCh]);
							carers[indexNoCa].setActionNumber(5);
							carers[indexNoCa].setWithChildren(true);
							children[indexNoCh].setChildAccessible(false);

						}
						break;
					case "r": // return
						if (carers[indexNoCa].getIsWithChildren()) {

							carers[indexNoCa].setActionNumber(6);

						}
						break;
					case "t": // terminate
						if (!carers[indexNoCa].isLeave()) {

							carers[indexNoCa].setActionNumber(7);

						}
						break;
					default:
						System.out.println("Bunun metodunu yazmadýn.");
						break;
					}
				}

				else if (input[0].substring(0, 2).equalsIgnoreCase("wr")) {

					indexNoWo = Integer.parseInt(input[0].substring(2)) - 1;

					allOfState = !workers[indexNoWo].isLeave()
								&& !workers[indexNoWo].isWithChildren()
								&& !workers[indexNoWo].isOnMarket();

					if (input[1].equals("r")) {

						workers[indexNoWo].setActionNumber(1);

					}

					else if (input[1].equals("t")) {

						workers[indexNoWo].setActionNumber(2);

					}

					else if (input[1].equals("c")) {

						indexNoCh = Integer.parseInt(input[2].substring(2)) - 1;

						if (!children[indexNoCh].getIsChildLeave()
								&& children[indexNoCh].getIsChildAccessible()) {

							workers[indexNoWo].setActionNumber(3);
							workers[indexNoWo].setChild(children[indexNoCh]);
							children[indexNoCh].setChildAccessible(false);

						}

					}

					else if (input[1].equals("m")) {

						for (int i = 2; i < input.length; i++) { // ne kadar
																	 // malzeme,
																	// ne kadar
																	// miktar
																	// girdi
																	// bunu
																	// dinamik
																	// yapmak
																	// için

							if (input[i].substring(0, 1).equals("f"))
								workers[indexNoWo].setFood(Integer
										.parseInt(input[i].substring(2)));
							else if (input[i].substring(0, 1).equals("g"))
								workers[indexNoWo].setToy(Integer
										.parseInt(input[i].substring(2)));
							else
								workers[indexNoWo].setHygiene(Integer
										.parseInt(input[i].substring(2)));

						}

						if (allOfState && (workers[indexNoWo].getFood()
								+ workers[indexNoWo].getToy() + workers[indexNoWo]
										.getHygiene()) < 101
							&& (float) (workers[indexNoWo].getFood() * 0.2
									+ workers[indexNoWo].getToy() * 0.2 + workers[indexNoWo]
									.getHygiene() * 0.1) < credit)
								 {

							marketCounter = 0; 
							workers[indexNoWo].setActionNumber(4);
							workers[indexNoWo].setOnMarket(true);

						}

					}

				}

				else if (input[0].substring(0, 2).equalsIgnoreCase("ap")) {
					accept(Integer.parseInt(input[0].substring(3)));
				}

			}

			if (sinceMidnight2 - sinceMidnight1 >= 2000) {
				sinceMidnight1 = sinceMidnight2;
				appTimeCounter++;
				marketCounter++;
				turn++;
				clear();
				for (int i = 0; i < caCount; i++) {

					if (carers[i].getActionNumber() == 1)
						totalFood -= carers[i].toFeed();

					else if (carers[i].getActionNumber() == 2)
						totalGame -= carers[i].toToy();

					else if (carers[i].getActionNumber() == 3)
						carers[i].toSleep();

					else if (carers[i].getActionNumber() == 4)
						totalHygiene -= carers[i].toHygine();

					else if (carers[i].getActionNumber() == 5){
						carers[i].check();
					}

					else if (carers[i].getActionNumber() == 6)
						carers[i].returnFromJob();

					else if (carers[i].getActionNumber() == 7)
						credit = carers[i].terminate(credit);

				}

				for (int i = 0; i < woCount; i++) {
					if (workers[i].getActionNumber() == 1)
						workers[i].returnFromJob();
					else if (workers[i].getActionNumber() == 2)
						credit = workers[i].terminate(credit);
					else if (workers[i].getActionNumber() == 3){
						if (workers[i].getChild().isMissing()){
							workers[i].find();
						}
						else {
							workers[i].check();
						}
					}
					else if (workers[i].getActionNumber() == 4){						
						if (marketCounter > 9) { // worker markete gidiyor.

							credit -= (float)(workers[i].getFood() * 0.2 + workers[i].getToy() * 0.2 + workers[i].getHygiene() * 0.1);
							workers[i].setOnMarket(false);
							
							totalFood += workers[i].getFood();
							totalGame += workers[i].getToy();
							totalHygiene += workers[i].getHygiene();
							
							workers[i].setFood(0);
							workers[i].setToy(0);
							workers[i].setHygiene(0);
							workers[i].setActionNumber(0);
							
							marketCounter = 0;
							
							// workers in içinde olmasý gereken goMarket eyleminin içine bir þey yazamadýðýmýzdan dolayý
							// bu þekilde burda iþlemleri yaptýk. Feriþtah Hocaya sorduk bunu da yapablirsiniz dedi.

						}
					}
				}

				int counter = 0;
				averageHap = 0;
				for (int i = 0; i < chCount; i++) {

					if (!children[i].getIsChildLeave() && !children[i].isMissing()) {

						children[i].setFood(children[i].getFood()
								- children[i].getFOOD_RATE());
						children[i].setToy(children[i].getToy()
								- children[i].getGAME_RATE());
						children[i].setSleep(children[i].getSleep()
								- children[i].getSLEEP_RATE());
						children[i].setHygiene(children[i].getHygiene()
								- children[i].getHYGIENE_RATE());

						
						//----------- Kaðýttaki 6.madde
						
						if (children[i].getFood() < 25)
							children[i].setHappiness((children[i].getHappiness() - children[i].getFOOD_HAPP_RATE() * 4));
						else if (children[i].getFood() > 75)
							children[i].setHappiness((children[i].getHappiness() - children[i].getFOOD_HAPP_RATE() * 2));
						else 
							children[i].setHappiness((children[i].getHappiness() + children[i].getFOOD_HAPP_RATE()));
						
						if (children[i].getToy() < 25)
							children[i].setHappiness((children[i].getHappiness() - children[i].getGAME_HAPP_RATE() * 4));
						else if (children[i].getToy() > 75)
							children[i].setHappiness((children[i].getHappiness() - children[i].getGAME_HAPP_RATE() * 2));
						else 
							children[i].setHappiness((children[i].getHappiness() + children[i].getGAME_HAPP_RATE()));
						
						if (children[i].getSleep() < 25)
							children[i].setHappiness((children[i].getHappiness() - children[i].getSLEEP_HAPP_RATE() * 4));
						else if (children[i].getSleep() > 75)
							children[i].setHappiness((children[i].getHappiness() - children[i].getSLEEP_HAPP_RATE() * 2));
						else 
							children[i].setHappiness((children[i].getHappiness() + children[i].getSLEEP_HAPP_RATE()));
						
						if (children[i].getHygiene() < 25)
							children[i].setHappiness((children[i].getHappiness() - children[i].getHYGIENE_HAPP_RATE() * 4));
						else if (children[i].getHygiene() > 75)
							children[i].setHappiness((children[i].getHappiness() - children[i].getHYGIENE_HAPP_RATE() * 2));
						else 
							children[i].setHappiness((children[i].getHappiness() + children[i].getHYGIENE_HAPP_RATE()));
						
						//-------------------------------------------------------------------
						
						
						if (children[i].isMissing()) 
							children[i].setMissing(children[i].getMissing() + 1);

						int sayi = rnd.nextInt(100) + 1;

						if (sayi == 1 && children[i].getHappiness() < 25) 
							children[i].setMissing(true);

						if (children[i].getHappiness() < 10) {
							children[i].setChildLeave(true);
							credit -= 50;
							
						}
						if (!children[i].getIsChildLeave()){ 
							counter++;
							averageHap += children[i].getHappiness();
						}
						
					}
				}


				averageHap = averageHap / counter;//ekrana yazmak için
				
				
				
				
				if (turn == 50){
					turn = 0;
					day++;
					for (int i = 0; i < chCount; i++) {
						if (!children[i].getIsChildLeave()) {
							credit += (float)children[i].getHappiness()*(1+((children[i].getHappiness()-50)/50));//kredi hesabý
							score += (float)(counter * (averageHap - 50));//skor hesabý
						}
						
					}
					
					//maaþlar
					for (int i = 0; i < caCount; i++) {
						if (!carers[i].isLeave()) {
							if (credit > 50) 
								credit -= 50;
							else 
								carers[i].setLeave(true);
							
						}
					}
					
					for (int i = 0; i < woCount; i++) {
						if (!workers[i].isLeave()) {
							if (credit > 30) 
								credit -= 30;
							else 
								workers[i].setLeave(true);
							
						}
					}
					//*******
				}
			}
			
			
		}
	}

	public void keyListener(enigma.console.Console cn) throws Exception {
		// ------ Standard code for mouse and keyboard ------ Do not change
		klis = new KeyListener() {
			public void keyTyped(KeyEvent e) {
			} // bir tusa bastigimizda ve bastigimiz tus Unicode karakteriyse

			public void keyPressed(KeyEvent e) {
				if (keypr == 0) {
					keypr = 1;
					rkey = e.getKeyCode();
					if (rkey == KeyEvent.VK_ENTER) {
						isEntered = 1;
						commandCursorX = 10;
					} 
					else if ((char)rkey == '.'){
						command += ':';
					} 
					
					else {
						command += (char) rkey;

					}
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		};
		cn.getTextWindow().addKeyListener(klis);

		// ----------------------------------------------------

	}

}
