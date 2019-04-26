package org.donna.model;

public class Product {

    private int productID;
    private String productTitle;
    private String manufacturer;
    private double price;
    private String category;
    private String image;
    private int qty;

    public Product() {
    }

    public Product(int productID, String productTitle, String manufacturer, double price, String category, String image, int qty) {
        this.productID = productID;
        this.productTitle = productTitle;
        this.manufacturer = manufacturer;
        this.price = price;
        this.category = category;
        this.image = image;
        this.qty = qty;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}



    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productTitle=" + productTitle + ", price=" + price +  ", category=" + category +  ", image=" + image +", qty=" + qty + '}';
    }
}
	
