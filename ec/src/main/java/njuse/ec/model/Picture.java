package njuse.ec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * picture表的实体化映射.
 * @author 阳
 *
 */
@Entity
@Table(name = "picture")
public class Picture implements Serializable {

	/**
	 * 序列化.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 图片id.
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
	 * 图片路径.
	 */
	@Column(name = "file")
	private String file;
	
	/**
	 * 是否为主图片.
	 */
	@Column(name = "main")
	private String isMain;

	/**
	 * 获取图片id.
	 * @return 图片id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * 设置图片id.
	 * @param newId 图片id
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
	 * 获取图片路径. 
	 * @return 图片路径
	 */
	public final String getFile() {
		return file;
	}

	/**
	 * 设置图片路径.
	 * @param newFile 图片路径
	 */
	public final void setFile(final String newFile) {
		this.file = newFile;
	}

	/**
	 * 获取图片是否为主图片.
	 * @return 是否为主图片
	 */
	public final String getIsMain() {
		return isMain;
	}

	/**
	 * 设置图片是否为主图片.
	 * @param newIsMain 是否为主图片
	 */
	public final void setIsMain(final String newIsMain) {
		this.isMain = newIsMain;
	}

}
