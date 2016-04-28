package njuse.ec.vo;

import java.util.List;

/**
 * 商品节点.
 * @author 丞
 *
 */
public class GoodElement {

	/**
	 * 图片.
	 */
	private String img;
	
	/**
	 * 商品名.
	 */
	private String name;
	
	/**
	 * 颜色节点.
	 */
	private List<ColorElement> colorList;

	/**
	 * @return the img
	 */
	public final String getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public final void setImg(String img) {
		this.img = img;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the colorList
	 */
	public final List<ColorElement> getColorList() {
		return colorList;
	}

	/**
	 * @param colorList the colorList to set
	 */
	public final void setColorList(List<ColorElement> colorList) {
		this.colorList = colorList;
	}
	
}
