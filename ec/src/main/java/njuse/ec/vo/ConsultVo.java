package njuse.ec.vo;

/**
 * 咨询vo.
 * @author 阳
 *
 */
public class ConsultVo {

	/**
	 * 咨询id.
	 */
	private int consultId;
	
	/**
	 * 咨询者id.
	 */
	private int userId;
	
	/**
	 * 父咨询.
	 */
	private ConsultVo fatherConsult;
	
	/**
	 * 咨询内容.
	 */
	private String consult;

	/**
	 * 获取咨询id.
	 * @return 咨询id
	 */
	public final int getConsultId() {
		return consultId;
	}

	/**
	 * 设置咨询id.
	 * @param newConsultId 咨询id
	 */
	public final void setConsultId(final int newConsultId) {
		this.consultId = newConsultId;
	}

	/**
	 * 获取咨询者id.
	 * @return 咨询者id
	 */
	public final int getUserId() {
		return userId;
	}

	/**
	 * 设置咨询者id.
	 * @param newUserId 咨询者id
	 */
	public final void setUserId(final int newUserId) {
		this.userId = newUserId;
	}

	/**
	 * 获取父咨询.
	 * @return 父咨询
	 */
	public final ConsultVo getFatherConsult() {
		return fatherConsult;
	}

	/**
	 * 设置父咨询.
	 * @param newFatherConsult 父咨询
	 */
	public final void setFatherConsult(final ConsultVo newFatherConsult) {
		this.fatherConsult = newFatherConsult;
	}

	/**
	 * 获取咨询内容.
	 * @return 咨询内容
	 */
	public final String getConsult() {
		return consult;
	}

	/**
	 * 设置咨询内容.
	 * @param newConsult 咨询内容
	 */
	public final void setConsult(final String newConsult) {
		this.consult = newConsult;
	}
}