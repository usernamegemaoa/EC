package njuse.ec.dao;

import java.util.List;

import njuse.ec.model.Picture;

/**
 * 图片DAO接口设计.
 * @author 阳
 *
 */
public interface PictureDAO {

	/**
	 * 添加图片.
	 * @param pic 图片
	 */
	void addPic(Picture pic);
	
	/**
	 * 删除图片.
	 * @param pic 图片
	 */
	void deletePic(Picture pic);
	
	/**
	 * 获取图片列表.
	 * @param goodId 商品id
	 * @return 图片列表
	 */
	List<Picture> getPics(int goodId);
	
	/**
	 * 获取主图片.
	 * @param goodId 商品id
	 * @return 图片列表
	 */
	List<Picture> getMainPic(int goodId);
}
