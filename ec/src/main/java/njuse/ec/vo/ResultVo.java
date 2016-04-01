package njuse.ec.vo;

/**
 * 通用结果vo.
 * 
 * @author 丞
 *
 */
public class ResultVo {

	/**
	 * 结果代码.
	 */
	private int resultCode;
	
	/**
	 * 结果消息.
	 */
	private String resultMessage;

	/**
	 * 获取结果代码.
	 * @return 代码
	 */
	public final int getResultCode() {
		return resultCode;
	}

	/**
	 * 设置结果代码.
	 * @param newResultCode 结果代码 
	 */
	public final void setResultCode(final int newResultCode) {
		this.resultCode = newResultCode;
	}

	/**
	 * 获取结果消息.
	 * @return 结果消息
	 */
	public final String getResultMessage() {
		return resultMessage;
	}

	/**
	 * 设置结果消息.
	 * @param newResultMessage 结果消息
	 */
	public final void setResultMessage(final String newResultMessage) {
		this.resultMessage = newResultMessage;
	}
	
}
