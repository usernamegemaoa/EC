package njuse.ec.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="user_id")
	private int user_id;
	@Column(name="shop_id")
	private int shop_id;
	@Column(name="state")//1:未支付，2:代发货,3:待确认,4:待评价,5:申请退款中,6：已退款
	private int state;
	@Column(name="is_read")
	private boolean is_read;
	@Column(name="time")
	private Date time;
	@Column(name="place_code")
	private int place_code;
	@Column(name="place_name")
	private String place_name;
	@Column(name="people")
	private String people;
	@Column(name="phone")
	private String phone;
	@Column(name="express_number")
	private String express_number;
	
	
	public int getId() {
		return id;
	}
	public void setId(int newId){
		this.id=newId;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public boolean isIs_read() {
		return is_read;
	}
	public void setIs_read(boolean is_read) {
		this.is_read = is_read;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getPlace_code() {
		return place_code;
	}
	public void setPlace_code(int place_code) {
		this.place_code = place_code;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getExpress_number(){
		return express_number;
	}
	public void setExpress_number(String express_number){
		this.express_number=express_number;
	}
}
