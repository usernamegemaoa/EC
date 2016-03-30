package njuse.ec.vo;

public class CastVo {
       
	private int castID;
	
	private int goodID;
	
	private String size;
	
	private int quantity;
	
	public final int getCastID(){
		return castID;
	}
	
	public final int getGoodID(){
		return goodID;
	}
	
	public final String getSize(){
		return size;
	}
	
	public final int getNumber(){
		return quantity;
	}
	
	public final void setGoodID(final int newGoodID) {
		this.goodID = newGoodID;
	}
	
	public final void setSize(final String newSize) {
		this.size = newSize;
	}
	
	public final void setQuantity(final int newQuantity) {
		this.quantity = newQuantity;
	}
}
