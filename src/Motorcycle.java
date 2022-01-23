import java.util.Scanner;

public class Motorcycle extends Kendaraan{
	
	Scanner scan = new Scanner(System.in);
	Integer helm;
	Integer helmPrice;

	public Motorcycle(String tipe, String brand, String name, String license, Integer topSpeed, Integer gasCap,
			Integer wheel, String jenisTipe, Integer helm) {
		super(tipe, brand, name, license, topSpeed, gasCap, wheel, jenisTipe);
		this.helm = helm;
	}
	
	@Override
	void callKendaraan() {
		System.out.println(this.name + " is standing!");
		System.out.print("Input helm price: ");
		helmPrice = scan.nextInt();
		scan.nextLine();
		System.out.println("Price: " + helmPrice);
	}
	
	@Override
	void printKendaraan() {
		System.out.println("Brand: " + this.brand);
		System.out.println("Name: " + this.name);
		System.out.println("License Plate: " + this.license);
		System.out.println("Type: " + this.jenisTipe);
		System.out.println("Gas Capacity: " + this.gasCap);
		System.out.println("Top Speed: " + this.topSpeed);
		System.out.println("Wheel(s): " + this.wheel);
		System.out.println("Helm: " + this.helm);
		this.callKendaraan();
	}
	

}
