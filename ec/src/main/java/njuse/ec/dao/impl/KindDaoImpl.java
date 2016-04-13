package njuse.ec.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.dao.BaseDao;
import njuse.ec.dao.KindDAO;
import njuse.ec.model.Kind;

/**
 * 商品种类DAO的接口实现.
 * @author 阳
 *
 */
@Repository
public class KindDaoImpl implements KindDAO {

	/**
	 * baseDao.
	 */
	@Autowired
	private BaseDao<Kind> baseDao;
	
	@Override
	public void addKind(Kind kind) {
		baseDao.save(kind);
	}

	@Override
	public void deleteKind(Kind kind) {
		baseDao.delete(kind);
		
	}

	@Override
	public List<Kind> getFatherKinds() {
		return baseDao.findlist(Kind.class, "kindId", "0");
	}

	@Override
	public List<Kind> getSonKinds(int fatherId) {
		return baseDao.findlist(Kind.class, "kindId", String.valueOf(fatherId));
	}

}
