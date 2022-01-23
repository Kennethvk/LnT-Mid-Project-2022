
public class Car extends Kendaraan {
	
	Integer entSys;
	
	public Car(String tipe, String brand, String name, String license, Integer topSpeed, Integer gasCap, Integer wheel,
			String jenisTipe, Integer entSys) {
		super(tipe, brand, name, license, topSpeed, gasCap, wheel, jenisTipe);
		this.entSys = entSys;
	}

	@Override
	void callKendaraan() {
		System.out.println("Turning on entertainment system...");
		if (this.jenisTipe.equals("Supercar")) {
			System.out.println("Boosting!");
		}
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
		System.out.println("Entertainment System: " + this.entSys);
		this.callKendaraan();
	}

}
