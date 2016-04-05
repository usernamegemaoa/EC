package njuse.ec.service;

import java.util.List;

import njuse.ec.vo.PlaceVo;

/**
 * 地址服务.
 * @author 丞
 *
 */
public interface PlaceService {

	/**
	 * 获取省会.
	 * @return 省会列表
	 */
	List<PlaceVo> getProvince();
	
	/**
	 * 获取所有市.
	 * @param provinceId 省会id.
	 * @return 某个省下所有市
	 */
	List<PlaceVo> getCity(int provinceId);
	
	/**
	 * 获取所有区.
	 * @param cityId 城市id
	 * @return 获取所有区
	 */
	List<PlaceVo> getDistrict(int cityId);
}
