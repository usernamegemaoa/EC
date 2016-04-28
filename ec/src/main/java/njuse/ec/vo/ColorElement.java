package njuse.ec.vo;

import java.util.List;

/**
 * 颜色节点.
 * @author 丞
 *
 */
public class ColorElement {
	
	/**
	 * 颜色.
	 */
	private String color;
	
	/**
	 * 订单详情节点.
	 */
	private List<DetailElement> detailList;

	/**
	 * @return the color
	 */
	public final String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public final void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the detailList
	 */
	public final List<DetailElement> getDetailList() {
		return detailList;
	}

	/**
	 * @param detailList the detailList to set
	 */
	public final void setDetailList(List<DetailElement> detailList) {
		this.detailList = detailList;
	}

}
