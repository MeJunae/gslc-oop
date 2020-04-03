
public class Product {
	
	/* 2.
	 * Di Class ini kita tidak extend kemana-mana karena Product akan menjadi Base Class
	 * Base Class, bisa dibilang class yang akan di extend oleh class lain
	 * sehingga class lain akan memiliki semua atribut di class ini dengan access modifier public dan protected
	 * Apabila atribut nya no-access-modifier, bisa diturunkan apabila kedua class tersebut di Package yang sama
	 * Selain base class, kita juga bisa menyebut Class Product sebagai Superclass
	 * 
	 * Setelah mengerti class ini, kita ke class FoodProduct dulu
	 */
	
//	Ini kita bikin protected agar bisa diakses di subclass/derived class atau class yang extend ke class ini.
//	Kita akan tetep encapsulation, bikin method setter and getter nya
//	Dengan mudah cukup tekan Alt + Shift + S -> R -> Alt + A -> Alt + O -> Enter (Apabila ingin semua atribut di-generate setter n getternya)
	protected String name;
	protected int price;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
//		Review ulang, keyword 'this' disini untuk membedakan antara name (atribut class) dan name (parameter)
//		Karena dua2nya sama, jadi kalo hanya name = name; bakal pake name yang ada di parameter (bisa dilihat di warna text tersebut)
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
//	Kita juga bisa bikin constructor yang langsung menerima parameter semua atribut yang dimiliki class tersebut
//	Untuk memudahkan dalam inisialisasi object
//	Alt + Shift + S -> O -> Enter (Generate Constructor Using Fields)
//	Jadi Auto generate constructor dengan field atau atribut yang dimiliki class ini
	public Product() {
		// TODO Auto-generated constructor stub
	}

//	Ini hasil generatenya
	public Product(String name, int price) {
//		Keyword super ini tidak berfungsi untuk apa-apa karena tidak ada superclass (class ini tidak extend apa-apa) jadi boleh dihapus
		super();
		this.name = name;
		this.price = price;
	}

}
