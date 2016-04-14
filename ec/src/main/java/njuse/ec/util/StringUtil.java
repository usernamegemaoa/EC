package njuse.ec.util;

import java.util.Random;

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

	/**
	 * 获取特定长度随机字符串.
	 * @param length 随机串长度
	 * @return 随机字符串
	 */
	public static String randomString(final int length) {  
	    String str = "abcdefghijklmnopqrstuvwxyz";
	    str += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    str += "0123456789";
	    Random random = new Random();  
	    StringBuffer buf = new StringBuffer();  
	    for (int i = 0; i < length; i++) {  
	        int num = random.nextInt(str.length());  
	        buf.append(str.charAt(num));  
	    }  
	    return buf.toString();
	}
}
