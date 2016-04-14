package njuse.ec.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * sub_consult表的实体化映射.
 * @author 阳
 *
 */
@Entity
@Table(name = "sub_consult")
public class SubConsult implements Serializable {

	/**
	 * 序列化.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 咨询id.
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	/**
	 * 父咨询id.
	 */
	@Column(name = "consult_id")
	private int consultId;
	
	/**
	 * 商品id.
	 */
	@Column(name = "good_id")
	private int goodId;
	
	/**
	 * 顾客id.
	 */
	@Column(name = "user_id")
	private int userId;
	
	/**
	 * 咨询内容.
	 */
	@Column(name = "content")
	private String content;

	/**
	 * 咨询时间.
	 */
	@Column(name = "time")
	private Date time;

	/**
	 * 获取咨询id.
	 * @return 咨询id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * 设置咨询id.
 	 * @param newId 咨询id
	 */
	public final void setId(final int newId) {
		this.id = newId;
	}

	/**
	 * 获取父咨询id.
	 * @return 父咨询id
	 */
	public final int getConsultId() {
		return consultId;
	}

	/**
	 * 设置父咨询id.
	 * @param newConsultId 父咨询id
	 */
	public final void setConsultId(final int newConsultId) {
		this.consultId = newConsultId;
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
	 * 获取用户id.
	 * @return 用户id
	 */
	public final int getUserId() {
		return userId;
	}

	/**
	 * 设置用户id.
	 * @param newUserId 用户id
	 */
	public final void setUserId(final int newUserId) {
		this.userId = newUserId;
	}

	/**
	 * 获取咨询内容.
	 * @return 咨询内容
	 */
	public final String getContent() {
		return content;
	}

	/**
	 * 设置咨询内容.
	 * @param newContent 咨询内容
	 */
	public final void setContent(final String newContent) {
		this.content = newContent;
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
