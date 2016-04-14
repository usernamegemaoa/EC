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
 * comment表的实体化映射.
 * @author 阳
 *
 */
@Entity
@Table(name = "comment")
public class Comment implements Serializable {

	/**
	 * 序列化.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 评价id.
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
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
	 * 好中差评.
	 */
	@Column(name = "score")
	private int score;

	/**
	 * 评价内容.
	 */
	@Column(name = "content")
	private String content;

	/**
	 * 评论时间.
	 */
	@Column(name = "time")
	private Date time;

	/**
	 * 获取评价id.
	 * @return 评价id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * 设置评价id.
 	 * @param newId 评价id
	 */
	public final void setId(final int newId) {
		this.id = newId;
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
	 * 获取评价等级.
	 * @return 评价等级
	 */
	public final int getScore() {
		return score;
	}

	/**
	 * 设置评价等级.
	 * @param newScore 评价等级
	 */
	public final void setScore(final int newScore) {
		this.score = newScore;
	}

	/**
	 * 获取评价内容.
	 * @return 评价内容
	 */
	public final String getContent() {
		return content;
	}

	/**
	 * 设置评价内容.
	 * @param newContent 评价内容
	 */
	public final void setContent(final String newContent) {
		this.content = newContent;
	}

	/**
	 * 获取评价时间.
	 * @return 评价时间
	 */
	public final Date getTime() {
		return time;
	}

	/**
	 * 设置评价时间.
	 * @param newTime 评价时间
	 */
	public final void setTime(final Date newTime) {
		this.time = newTime;
	}	
}
