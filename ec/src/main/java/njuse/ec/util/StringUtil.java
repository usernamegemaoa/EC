package njuse.ec.util;

/**
 * String工具.
 * @author 丞
 *
 */
public final class StringUtil {

	/**
	 * null constructor. 
	 */
	private StringUtil() {
		
	}
	
	/**
	 * 判断是否为空.
	 * @param s 字符串
	 * @return 判断结果
	 */
	public static boolean isNull(final String s) {
		if (s == null) {
			return true;
		}
		
		if (s.length() == 0) {
			return true;
		}
		
		return false;
	}

}
