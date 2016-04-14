package njuse.ec.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.BaseDao;
import njuse.ec.dao.PictureDAO;
import njuse.ec.model.Picture;

/**
 * 图片DAO接口实现.
 * @author 阳
 *
 */
@Repository
public class PictureDAOImpl implements PictureDAO {
	
	/**
	 * baseDao.
	 */
	@Autowired
	private BaseDao<Picture> baseDao;
	
	@Override
	public final void addPic(final Picture pic) {
		baseDao.save(pic);
	}

	@Override
	public final void deletePic(final Picture pic) {
		baseDao.delete(pic);
	}

	@Override
	public final List<Picture> getPics(final int goodId) {
		return baseDao.findlist(Picture.class, "goodId", String.valueOf(goodId));
	}

	@Override
	public final Picture getMainPic(final int goodId) { 
		List<Picture> pics = getPics(goodId);
		for(int i = 0; i < pics.size(); i++) {
			Picture pic = pics.get(i);
			while(pic.getIsMain().equals("true")) {
				return pic;
			}
		}
		return null;
	}
}
