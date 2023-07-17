import java.util.Scanner;

public class vending_machine {

	public static void main(String[] args){
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Client person1 = new Client();
		
		String [] items = {"Chocolate", "Mango Juice", "Water", "Chips", "Cookie", "Peanuts"};
		String [] code = {"A1", "B2", "C3", "D4", "E5", "F6"};
		int [] itemCount = {5, 5, 5, 5, 5, 5};
		
		boolean refill = false;
		
		while (true) {
			person1.money = 0;
			System.out.println("Welcome! please choose what you would like to have: ");
			
			for (int i=0; i<items.length; i++) {
				System.out.println("-" + code[i] + " " + items[i]);
			}
			System.out.println("Press 'H' for assistance\n");
			person1.inputCode = scan.next();
			
			
			//if customer called for assistant
			if (person1.inputCode.equalsIgnoreCase("h")) {
				System.out.println("Calling for assistance...\n");
				
				
				System.out.println("Press 'Y' if machine did not return money or did not release an item.");
				System.out.println("Press 'R' for refill. Press 'F' to call assistant to fix machine.");
				person1.RorF = scan.next();
				
				if(person1.RorF.equalsIgnoreCase("r")) {
					itemCount = new int[] {5, 5, 5, 5, 5, 5}; 
					refill = false;
					System.out.println("Assistant has refilled the vending machine\n\n");
				}
				else if (person1.RorF.equalsIgnoreCase("f")) {
					System.out.println("Assistant has been called to fix the machine...\n\n");
				}
				else if (person1.RorF.equalsIgnoreCase("y")) {
					
					System.out.print("Have you kicked the machine for not working? ");
					while(!person1.kickConfirm.equalsIgnoreCase("y") && !person1.kickConfirm.equalsIgnoreCase("n")) {
						System.out.println("(Y/N)");
						person1.kickConfirm = scan.next();
					}
						
					
					if (person1.kickConfirm.equalsIgnoreCase("y")) {
						person1.angry = true;
						System.out.println("Message has been sent to vendor: 'Machine is being abused'");
						System.out.println("You are not allowed to use this machine\n\n");
						person1.kickConfirm = "";
					}
					else {
						person1.angry = false;
						System.out.println("Kindly call for assistant...\n\n");
					}
					
					
				}
				else {
					System.out.println("Invalid input\n\n");
				}
			}
			//if customer is not angry and entered correct code for item
			else if (person1.angry != true) {
				while(person1.money != 5) {
					System.out.println("Pay the exact amount to recieve your good (5$ per item)");
					person1.money = scan.nextInt();
					if(person1.money != 5) {
						System.out.println("Returning " + person1.money + "$");
					}
				}
				
				System.out.println("Amount entered " + person1.money + "$ for item " + person1.inputCode + ". Press 'Y' to continue. Press any other key to cancel.");
				person1.YorN = scan.next();
				
				for(int i=0; i<items.length; i++) {
					if (itemCount[i] == 0) {
						System.out.println("Call for assistance to refill item " + items[i]);
						refill = true;
						System.out.println("Returning " + person1.money + "$...\n\n");
						break;
					}
				}
				
				if(refill) {
					continue;
				}
				else if (person1.YorN.equalsIgnoreCase("y")) {
					switch (person1.inputCode){
					case "A1", "a1": System.out.println("Releasing A1, Chocolate...");
							   itemCount[0]--;
							   System.out.println(itemCount[0] + " " + items[0] + " left\n\n");
							   break;
					case "B2", "b2": System.out.println("Releasing B2, Mango Juice...");
							   itemCount[1]--;
							   System.out.println(itemCount[1] + " " + items[1] + " left\n\n");
							   break;
					case "C3", "c3": System.out.println("Releasing C3, Water...");
							   itemCount[2]--;
							   System.out.println(itemCount[2] + " " + items[2] + " left\n\n");
							   break;
					case "D4", "d4": System.out.println("Releasing D4, Chips...");
							   itemCount[3]--;
							   System.out.println(itemCount[3] + " " + items[3] + " left\n\n");
							   break;
					case "E5", "e5": System.out.println("Releasing E5, Biscuits...");
							   itemCount[4]--;
							   System.out.println(itemCount[4] + " " + items[4] + " left\n\n");
							   break;
					case "F6", "f6": System.out.println("Releasing F6, Peanuts...");
							   itemCount[5]--;
							   System.out.println(itemCount[5] + " " + items[5] + " left\n\n");
							   break;
					default: System.out.println("The code entered does not exist!");
							 System.out.println("Returning " + person1.money + "$...");
							 break;
					}
				}
				else {
					System.out.println("Process cancelled...returning " + person1.money + "$\n\n");
					
				}
				
				
				
			}
			// If customer is angry
			else {
				System.out.println("You are not allowed to use the vending machine! Call for assistant...\n\n");
			}
		
		}
		
	}

}


