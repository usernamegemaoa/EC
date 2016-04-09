package njuse.ec.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import njuse.ec.service.PlaceService;
import njuse.ec.vo.PlaceVo;

/**
 * 地理位置模块.
 * @author 丞
 *
 */
@Service
public class PlaceServiceImpl implements PlaceService {

	@Override
	public final List<PlaceVo> getProvince() {
		List<PlaceVo> provinces = new ArrayList<PlaceVo>();
		PlaceVo province = new PlaceVo();
		province.setPlaceCode(0);
		province.setPlaceName("北京");
		return provinces;
	}

	@Override
	public final List<PlaceVo> getCity(final int provinceId) {
		List<PlaceVo> provinces = new ArrayList<PlaceVo>();
		PlaceVo province = new PlaceVo();
		province.setPlaceCode(0);
		province.setPlaceName("北京");
		return provinces;
	}

	@Override
	public final List<PlaceVo> getDistrict(final int cityId) {
		List<PlaceVo> provinces = new ArrayList<PlaceVo>();
		PlaceVo province = new PlaceVo();
		province.setPlaceCode(0);
		province.setPlaceName("北京");
		return provinces;
	}

}
