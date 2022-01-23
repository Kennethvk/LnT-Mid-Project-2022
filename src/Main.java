import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	Integer longestName = 0;
	
	public Boolean validateLicense(String license) {
		Integer check = 0;
		
		String [] arr = license.split(" ");
		
		if (arr.length == 3) {
			check++;
		}else return false;
		
		if (arr[0].matches("[A-Z]{1}")) {
			check++;
		}
		
		if (arr[1].matches("[0-9]{1,4}")) {
			check++;
		}
		
		if (arr[2].matches("[A-Z]{1,3}")) {
			check++;
		}
				
		if (check == 4) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void getInput(ArrayList<Kendaraan> arrayKend) {
		scan.nextLine();
		String tipe;
		do {
			System.out.print("Input type [Car | Motorcycle]: ");
			tipe = scan.nextLine();
		} while (!tipe.equals("Car") && !tipe.equals("Motorcycle"));

		String brand;
		do {
			System.out.print("Input brand [>=5]: ");
			brand = scan.nextLine();	
		} while (brand.length() < 5);
		
		String name;
		do {
			System.out.print("Input name [>=5]: ");
			name = scan.nextLine();	
		} while (name.length() < 5);
		if (name.length() > longestName) longestName = name.length(); 
		
		String license;
		do {
			System.out.print("Input license: ");
			license = scan.nextLine();
		} while (validateLicense(license) == false);
		
		Integer topSpeed;
		do {
			System.out.print("Input top speed [100 <= topSpeed <= 250]: ");
			topSpeed = scan.nextInt();
		} while (topSpeed < 100 || topSpeed > 250);
		
		Integer gasCap;
		do {
			System.out.print("Input gas capacity [30 <= gasCap <= 60]: ");
			gasCap = scan.nextInt();
		} while (gasCap < 30 || gasCap > 60);
		
		if (tipe.matches("Car")) {
			
			Integer wheel;
			do {
				System.out.print("Input wheel [4 <= wheel <= 6]: ");
				wheel = scan.nextInt();
			} while (wheel < 4 || wheel > 6);
			scan.nextLine();
			
			String jenisMobil;
			do {
				System.out.print("Input type [SUV | Supercar | Minivan]: ");
				jenisMobil = scan.nextLine();
			} while (!jenisMobil.matches("SUV") && !jenisMobil.matches("Supercar") && !jenisMobil.matches("Minivan"));
			
			Integer entSys;
			do {
				System.out.print("Input entertainment system amount [>=1]: ");
				entSys = scan.nextInt();
			} while (entSys < 1);
			
			Car obj = new Car(tipe,brand,name,license,topSpeed,gasCap,wheel,jenisMobil,entSys);
			arrayKend.add(obj);
			
		}else if (tipe.matches("Motorcycle")) {
			Integer wheel;
			do {
				System.out.print("Input wheel [2 <= wheel <= 3]: ");
				wheel = scan.nextInt();
			} while (wheel < 2 || wheel > 3);
			scan.nextLine();
			
			String jenisMotor;
			do {
				System.out.print("Input type [Automatic | Manual]: ");
				jenisMotor = scan.nextLine();
			} while (!jenisMotor.matches("Automatic") && !jenisMotor.matches("Manual"));
			
			Integer helm;
			do {
				System.out.print("Input helm amount [>=1]: ");
				helm = scan.nextInt();
			} while (helm < 1);
			
			Motorcycle obj = new Motorcycle(tipe,brand,name,license,topSpeed,gasCap,wheel,jenisMotor,helm);	
			arrayKend.add(obj);
		}
		
	}
	
	public void printTabel(Integer temp, ArrayList<Kendaraan> arrayKend) {
		System.out.print("|");
		for (int i = 0; i < temp.toString().length() + 3;i++) {
			System.out.print("-");
		}
		System.out.print("|-----------|");
		for (int i = 0; i < longestName + 5; i++) System.out.print("-");
		System.out.println("|");
	}
	
	public void getView(ArrayList<Kendaraan> arrayKend) {
		Integer arraySize = arrayKend.size();
		Integer countView = 0;
		
		printTabel(arraySize, arrayKend);
		System.out.print("|No");
		for (int i = 0; i < arraySize.toString().length() + 1; i++) System.out.print(" ");
		System.out.print("|Type       |Name");
		for (int i = 0; i < longestName + 1; i++) System.out.print(" ");
		System.out.println("|");
		printTabel(arraySize, arrayKend);
		
		if (arrayKend.size() == 0) {
			System.out.print("|");
			for (int i = 0; i < arraySize.toString().length() + 3; i++) System.out.print(" ");
			System.out.print("|           |");
			for (int i = 0; i < longestName + 5; i++) System.out.print(" ");
			System.out.println("|");
		}else {
			do {
				System.out.print("|");
				System.out.print(countView+1);
				for (int i = 0; i < arraySize.toString().length() + 3 - countView.toString().length(); i++) System.out.print(" ");
				System.out.print("|");
				System.out.print(arrayKend.get(countView).tipe);
				for (int i = 0; i < 11 - arrayKend.get(countView).tipe.length(); i++) System.out.print(" ");
				System.out.print("|");
				System.out.print(arrayKend.get(countView).name);
				for (int i = 0; i < longestName + 5 - arrayKend.get(countView).name.length(); i++) System.out.print(" ");
				System.out.println("|");
				countView++;
			} while (countView < arraySize);
		}
		
		printTabel(arraySize, arrayKend);
		printTabel(arraySize, arrayKend);
		
		Integer chooseView;
		System.out.print("Pick a vehicle number to test drive[Enter '0' to exit]: ");
		chooseView = scan.nextInt();
		scan.nextLine();
		if (chooseView == 0 || arraySize == 0) {
			
		} else {
			chooseView--;
			arrayKend.get(chooseView).printKendaraan();
		}
		
	}

	public Main() {
		// TODO Auto-generated constructor stub
		Integer choose = 0;
		ArrayList<Kendaraan> arrayKend= new ArrayList<Kendaraan>();
		do {
			System.out.println("=======================");
			System.out.println("Menu Aplikasi");
			System.out.println("1. Input");
			System.out.println("2. View");
			System.out.println("3. Exit");
			System.out.println("=======================");
			System.out.print("Pilih menu : ");
			choose = scan.nextInt();
			if (choose == 1) {
				getInput(arrayKend);
			}
			if (choose == 2) {
				getView(arrayKend);
			}
		} while (choose != 3);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
