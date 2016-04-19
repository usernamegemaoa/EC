package njuse.ec.dao;

import java.util.List;

import njuse.ec.model.Place;

/**
 * 地点dao.
 * @author 丞
 *
 */
public interface PlaceDao {

	/**
	 * 获取省会.
	 * @return 省会列表
	 */
	List<Place> getProvince();
	
	/**
	 * 获取所有市.
	 * @param provinceId 省会id.
	 * @return 某个省下所有市
	 */
	List<Place> getCity(int provinceId);
	
	/**
	 * 获取所有区.
	 * @param cityId 城市id
	 * @return 获取所有区
	 */
	List<Place> getDistrict(int cityId);
}
