import java.util.Scanner;

public class CashRegister{
	
	static String menu[][] = {{"Burger       ", "Fries        ", "Donut        "},{"Soft Drinks","Fruit Drinks"},{"Mango Float", "Fruit Salad", "Ice Cream"}};
	static int menu_prices[][] = {{30, 30, 35},{15,25},{60, 80, 70}};
	static int order[][] = {{0, 0, 0},{0,0},{0, 0, 0}};
	static Scanner sc = new Scanner(System.in);
		
	public static void main(String[] args){
		System.out.println("Welcome to D'Girls Fast Food Chain!!");
		System.out.println("Press 1 to order Press 2 to view menu");
		int choice = sc.nextInt();
		if(choice == 1){
			order();
		}
		else if (choice==2){
			viewMenu();
		}
		else {
			System.out.println("Error. Please between the two choices only");
			System.exit(0);
		}
	}
		public static void viewMenu() {
		System.out.println("Order\t\t|Quantity|Amount\t\t|Total");
		
		for(int i=0; i<menu.length; i++){
			for(int j =0; j<menu[i].length;j++){
				System.out.println(menu[i][j]+"\t| "+order[i][j]+"\t | "+menu_prices[i][j]+"\t\t| ");
			}
		}
		order();
		
		}
	public static void order(){
		System.out.println("\nPress 1 to order foods\nPress 2 to order drinks\nPress 3 to order dessert\nPress 4 to pay");
		int choice = sc.nextInt();
		System.out.println();
		if(choice == 4){
			receipt();
		}
		else{
			for(int i = 0; i<menu[choice-1].length ;i++){
				System.out.println("Press "+ (i+1) + " to order " + menu[choice-1][i]);
			}
			int order_choice = sc.nextInt();
			
			order[choice-1][order_choice-1]++;
			
			System.out.println("\nDo you want to order more?(Y/N)");
			sc.nextLine();
			String more = sc.nextLine();
			
			if(more.equalsIgnoreCase("y")){
				order();
			}
			else if(more.equalsIgnoreCase("n")) {
				receipt();
			}
			else {
				System.out.println("Error.");
				System.exit(0);
			}
		}
	}
	
	public static void receipt(){
		
		int total[][] = {{0, 0, 0},{0,0},{0, 0, 0}};
		
		for(int i=0; i<menu.length; i++){
			for(int j =0; j<menu[i].length;j++){
				total[i][j] = menu_prices[i][j] * order[i][j];
			}
		}
		
		System.out.println("Order\t\t|Quantity|Amount\t\t|Total");
		
		for(int i=0; i<menu.length; i++){
			for(int j =0; j<menu[i].length;j++){
				System.out.println(menu[i][j]+"\t| "+order[i][j]+"\t | "+menu_prices[i][j]+"\t\t| "+total[i][j]);
			}
		}
		int total_to_pay = 0;
		for(int i=0; i<menu.length; i++){
			for(int j =0; j<menu[i].length;j++){
				total_to_pay += total[i][j];
			}
		}
		
		int payment = 0;
		System.out.println("\nTotal: "+total_to_pay);
		if(total_to_pay == 0){
			System.out.println("You have not ordered anything");
		}
		else{
			while(payment<total_to_pay){
				System.out.print("Enter Payment: ");
				payment = sc.nextInt();
				if(payment<total_to_pay){
					System.out.println("Insufficient money, pay a higher amount");
				}
			}
		}
		int change;
		change = payment - total_to_pay;
		
		System.out.println("\t		RECEIPT:					");
		System.out.println("TOTAL PAYMENT:					" + total_to_pay);
		System.out.println("YOUR PAYMENT:					" + payment);
		System.out.println("YOUR CHANGE: 					" + change);
	}
}