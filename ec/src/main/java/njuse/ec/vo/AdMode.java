package njuse.ec.vo;

/**
 * 广告类型.
 * 
 * @author 丞
 *
 */
public enum AdMode {

	/**
	 * 主页广告.
	 */
	INDEX(0),
	/**
	 * 每日上新.
	 */
	LATEST(1),
	/**
	 * 普通广告.
	 */
	NORMAL(2);

	/**
	 * 枚举变量.
	 */
	private int value = 0;

	/**
	 * 设置变量值.
	 * @param newValue 变量值
	 */
	AdMode(final int newValue) {
		this.value = newValue;
	}

	/**
	 * 根据数值获取枚举.
	 * @param value 变量
	 * @return 枚举
	 */
	public static AdMode valueOf(final int value) {
		switch (value) {
		case 0:
			return INDEX;
		case 1:
			return LATEST;
		case 2:
			return NORMAL;
		default:
			return null;
		}
	}

	/**
	 * 返回数值.
	 * @return 数值
	 */
	public int value() {
		return this.value;
	}
}
