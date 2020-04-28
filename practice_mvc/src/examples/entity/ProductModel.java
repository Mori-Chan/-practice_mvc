package examples.entity;

public class ProductModel {

	private String id = null;	// 商品 ID
	private String name = null;	// 商品名
	private int price = 0;		// 商品価格

	public ProductModel() { super(); }

	public String getId(){ return this.id; }
	public void setId(String id){ this.id = id; }

	public String getName(){ return this.name; }
	public void setName(String name){ this.name = name; }

	public int getPrice(){ return this.price; }
	public void setPrice(int price){ this.price = price; }
}
