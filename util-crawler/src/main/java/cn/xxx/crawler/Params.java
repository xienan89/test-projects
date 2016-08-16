package cn.xxx.crawler;
public class Params{
		String brand;
		String number;
		String price;
		String item_name;
		public Params(String brand, String number, String price, String name){
			this.brand = brand;
			this.number = number;
			this.price = price;
			this.item_name = name;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getItem_name() {
			return item_name;
		}
		public void setItem_name(String item_name) {
			this.item_name = item_name;
		}			
	}
