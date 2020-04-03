
public class ElectricalProduct extends Product{

	/* 4.
	 * Isi dari class ini kurang lebih sama seperti class FoodProduct, intinya, kita extend class product
	 * Bedanya, atribut yang ditambahkan di class ini, yaitu voltage
	 * 
	 * Kalau sudah dari class ini, kita bisa ke class Main lagi
	 */
	
	private int voltage;	

	public int getVoltage() {
		return voltage;
	}

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	public ElectricalProduct() {
		// TODO Auto-generated constructor stub
	}

	public ElectricalProduct(String name, int price, int voltage) {
		super(name, price);
		this.voltage = voltage;
	}
}
