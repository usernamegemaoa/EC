package njuse.ec.vo;

import java.util.Date;

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
	 * 商品id.
	 */
	private int goodId;
	
	/**
	 * 父咨询.
	 */
	private int fatherId;
	
	/**
	 * 咨询内容.
	 */
	private String consult;
	
	/**
	 * 咨询时间.
	 */
	private Date time;

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
	 * 获取商品id.
	 * @return 商品id
	 */
	public final int getGoodId() {
		return goodId;
	}

	/**
	 * 设置商品id.
	 * @param newGoodId 商品id
	 */
	public final void setGoodId(final int newGoodId) {
		this.goodId = newGoodId;
	}

	/**
	 * 获取父咨询.
	 * @return 父咨询
	 */
	public final int getFatherConsult() {
		return fatherId;
	}

	/**
	 * 设置父咨询.
	 * @param newFatherId 父咨询
	 */
	public final void setFatherConsult(final int newFatherId) {
		this.fatherId = newFatherId;
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

	/**
	 * 获取咨询时间.
	 * @return 咨询时间
	 */
	public final Date getTime() {
		return time;
	}

	/**
	 * 设置咨询时间.
	 * @param newTime 咨询时间
	 */
	public final void setTime(final Date newTime) {
		this.time = newTime;
	}
}