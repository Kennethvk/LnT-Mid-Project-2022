
public abstract class Kendaraan {
	
	String tipe;
	String brand;
	String name;
	String license;
	Integer topSpeed;
	Integer gasCap;
	Integer wheel;
	String jenisTipe;
	
	
	public Kendaraan(String tipe, String brand, String name, String license, Integer topSpeed, Integer gasCap,
			Integer wheel, String jenisTipe) {
		this.tipe = tipe;
		this.brand = brand;
		this.name = name;
		this.license = license;
		this.topSpeed = topSpeed;
		this.gasCap = gasCap;
		this.wheel = wheel;
		this.jenisTipe = jenisTipe;
	}



	abstract void callKendaraan();
	abstract void printKendaraan();
	
}
