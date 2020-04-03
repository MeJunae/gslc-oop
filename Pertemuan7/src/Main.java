import java.util.Scanner;
import java.util.Vector;

public class Main {

	/*
	 * 1.
	 * Pada pertemuan 7 kita akan membahas mengenai salah satu mekanisme atau konsep OOP, yaitu Inheritance
	 * Sesuai dengan namanya, dengan inheritance, kita bisa menurunkan atribut dari satu class, ke class lain-lainnya
	 * Contoh, dalam sebuah toko pasti punya product, namun punya banyak tipenya.
	 * Ada Product yang punya atribut expired date seperti produk yg di konsumsi dan juga ada yang tidak.
	 * Ada yang punya atribut rincian voltase (produk kelistrikan) dan lain sebagainya.
	 * Tapi yang pasti dimiliki oleh setiap product dalam suatu toko adalah Nama dan Harga.
	 * Jadi kita bisa membuat Class Product yang memiliki atribut Nama dan Harga.
	 * Untuk menspesifikasikan atau mengelompokkan product tersebut sesuai dengan tipe produknya agar memiliki atribut yang sesuai
	 * Kita bisa membuat class lain dengan hanya memberikan atribut tambahan:
	 * Class FoodProduct, yang memiliki atribut tambahan ExpiredDate
	 * Class ElectricalProduct, yang memiliki atribut tambahan Voltage
	 * Dengan hanya memberikan atribut tambahan, kita tinggal meng-extend-kan kedua class tersebut ke Class Product
	 * Sehingga Class Product menjadi Base Class dan Class FoodProduct dan ElectricalProduct menjadi Derived Class dari Class Product
	 * Maka kedua class tersebut mempunyai atribut yang dimiliki class Product juga yaitu nama dan harga.
	 * 
	 * Pertama kita bikin class product dahulu, silahkan buka Class Product yang sudah terbuat
	 */
	
	Scanner scan = new Scanner(System.in);
	private void cls() {
		for(int i=0; i<30; i++) {
			System.out.println("");
		}
	}
	
//	Hanya method untuk scan integer yang agak safe
	private int scanInt() {
		int res = -1;
		try {
			res = scan.nextInt(); scan.nextLine();
		} catch (Exception e) {
			res = -1;
		}
		return res;
	}
	
//	Kita bikin Vector untuk menampung Product
	Vector<Product> productVec = new Vector<Product>();
//	Dengan kita bikin vector product, maka bisa menampung semua subclass Product yang udah kita bikin
//	Jadi Vector itu bisa menampung class product dan semua keturunannya (disini FoodProduct dan ElectricalProduct)
	
	public Main() {
//		Agar enak, baca class lain dulu baru mengerti ke codingan di constructor ini, mulai dari class Product
//		Kita akan coba bikin Create dan Read untuk Class FoodProduct dan ElectricalProduct
//		Kita jalankan Method Menu, yang akan menjalankan method lain
		menu();
	}
	
	private void menu() {
//		Method ini untuk menu
		int chooseMenu = -1;
		do {
			cls();
			System.out.println("1. New FoodProduct");
			System.out.println("2. New ElectricalProduct");
			System.out.println("3. Read All Product");
			System.out.println("0. Exit");
			chooseMenu = scanInt();
			switch(chooseMenu) {
			case 1:
				insertNewFoodProduct();
				break;
			case 2:
				insertNewElectricalProduct();
				break;
			case 3:
				readAll();
				break;
			}
		}while(chooseMenu != 0);
	}
	
	private void insertNewFoodProduct() {
		cls();
//		Disini ga bikin validasi yah, untuk validasi silahkan tambahkan sendiri, agar lebih fokus ke inheritance
		System.out.print("Input Name : ");
		String name = scan.nextLine();
		System.out.print("Input Price : ");
		int price = scanInt();
		System.out.print("Input Expired Date : ");
		String expiredDate = scan.nextLine();
		
//		Apabila sudah maka kita langsung tambahkan ke Vector Product kita
		productVec.add(new FoodProduct(name, price, expiredDate));
	}
	
	private void insertNewElectricalProduct() {
		cls();
//		Isinya kurang lebih sama dengan insertNewFoodProduct
		System.out.print("Input Name : ");
		String name = scan.nextLine();
		System.out.print("Input Price : ");
		int price = scanInt();
		System.out.print("Input Voltage : ");
		int voltage = scanInt();
		
//		Apabila sudah maka kita langsung tambahkan ke Vector Product kita
		productVec.add(new ElectricalProduct(name, price, voltage));
	}
	
	private void readAll() {
//		Pertama kita bikin looping untuk semua isi vector product
		cls();
		for(int i=0; i<productVec.size(); i++) {			
//			biar enak kita tampung object class Product dari productVec.elementAt(i) ke dalam 1 variabel
			Product product = productVec.elementAt(i);
			System.out.println("Product " + (i+1));
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
			
//			kita cek apakah element index i itu merupakan object dari class FoodProduct atau ElectricalProduct
//			bisa pake keyword 'instanceof'
			if(product instanceof FoodProduct) {
//				Kita print sesuai dengan atribut yg dimiliki FoodProduct
//				Disini saya pakai cara yang cukup mudah
//				Karena kita udah tampung object productVec.elementAt(i) ke 1 variabel namanya product
//				Kita tinggal typecast ke class FoodProduct jadi (FoodProduct)product
//				Kita kurungkan lagi jadi ((FoodProduct)product) agar menjadi satu kesatuan
//				dengan setelah kurung itu, kita bisa akses method dari FoodProduct
				System.out.println("Expired Date: " + ((FoodProduct)product).getExpiredDate());
//				Apabila kita ga tampung ke dalam 1 variabel tersebut, maka akan ketik cukup panjang
//				Kita ambil dulu objectnya dengan cara productVec.elementAt(i), object yang diambil masih class Product
//				Setelah itu kita type cast ke FoodProduct jadi seperti (FoodProduct)productVec.elementAt(i)
//				Kalau udah, maka object tersebut sudah type class FoodProduct, kita kurungkan object itu jadi ((FoodProduct)productVec.elementAt(i))
//				Kalau sudah, kita bisa pake method yang ada di FoodProduct, jadinya ((FoodProduct)productVec.elementAt(i)).methodnya()
//				Kalau ga kita tampung maka ((FoodProduct)productVec.elementAt(i)).getExpiredDate();
			}else if(product instanceof ElectricalProduct) {
				//Caranya sama
				System.out.println("Voltage: " + ((ElectricalProduct)product).getVoltage());
			}
			System.out.println("");
//			Perlu kita validasi ngecek apakah object di element tersebut merupakan Class FoodProduct atau ElectricalProduct
//			Karena dari kedua class tersebut, yg mau kita print, memiliki atribut berbeda
//			Maka kita cek dulu object tersebut instansi dari class apa, kemudian baru kita jalankan methodnya
		}
		scan.nextLine();
	}

	public static void main(String[] args) {
//		Memanggil constructor dari kelas Main
		new Main();
	}

}
