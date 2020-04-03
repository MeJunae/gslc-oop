import java.util.Date;

public class FoodProduct extends Product{

	/* 3.
	 * Kita bisa menggunakan keyword 'extends' agar Class ini memiliki semua atribut public, protected class yang di-extend
	 * Karena class ini extend class Product, maka FoodProduct memiliki:
	 * atribut protected di class Product (String name, int price)
	 * dan method public setter getternya.
	 * 
	 * Untuk ExpiredDate di class ini bisa kita bikin private saja karena kita tidak ada kebutuhan untuk diturunkan ke class lainnya
	 * 
	 * sudah ke class ini maka kita ke class ElectricalProduct
	 */
	
//	Setelah ini, lanjut bikin setter n getternya
	private String expiredDate;
//	Bikin String agar nanti ga ribet untuk inisialisasi tipe data Date karena kita ingin fokus ke inheritance dulu
	
	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}
	
//	Selanjutnya, kita bisa bikin constructor yang langsung menerima parameter semua atribut
//	Ada banyak cara agar constructor bisa menerima semua atribut, bikin manual dari awal, atau generate lalu tambahkan
	public FoodProduct() {
		// TODO Auto-generated constructor stub
	}
	
	public FoodProduct(String name, int price, String expiredDate) {
//		Karena kita sudah buat constructor yang menerima Name dan Price di SuperClass class ini (Class Product)
//		Maka kita bisa panggil constructornya dengan keyword 'super' kemudian berikan parameter sesuai dengan apa yang sudah dibuat di superclassnya
		super(name, price);
//		Apabila kita hanya memanggil super() maka kita memanggil constructor yang tidak menerima parameter sama sekali
		this.expiredDate = expiredDate;
	}

}
