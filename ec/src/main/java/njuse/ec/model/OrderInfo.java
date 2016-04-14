package njuse.ec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_info")
public class OrderInfo implements Serializable{

	    private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name="id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name="order_id")
		private int order_id;
		@Column(name="good_id")
		private int good_id;
		@Column(name="size")
		private String size;
		@Column(name="color")
		private String color;
		@Column(name="quantity")
		private int quantity;
		@Column(name="price")
		private int price	;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getOrder_id() {
			return order_id;
		}
		public void setOrder_id(int order_id) {
			this.order_id = order_id;
		}
		public int getGood_id() {
			return good_id;
		}
		public void setGood_id(int good_id) {
			this.good_id = good_id;
		}
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		
}
