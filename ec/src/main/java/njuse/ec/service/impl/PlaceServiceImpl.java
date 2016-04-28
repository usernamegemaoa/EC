package njuse.ec.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import njuse.ec.dao.PlaceDao;
import njuse.ec.model.Place;
import njuse.ec.service.PlaceService;
import njuse.ec.vo.PlaceVo;

/**
 * 地理位置模块.
 * @author 丞
 *
 */
@Service
public class PlaceServiceImpl implements PlaceService {
	
	/**
	 * placeDao.
	 */
	@Autowired
	private PlaceDao placeDao;

	@Override
	public final List<PlaceVo> getProvince() {
		List<Place> places = placeDao.getProvince();
		List<PlaceVo> provinces = new ArrayList<PlaceVo>();
		Iterator<Place> i = places.iterator();
		while (i.hasNext()) {
			Place place = i.next();
			PlaceVo vo = new PlaceVo();
			vo.setId(place.getId());
			vo.setPlaceCode(place.getPlaceCode());
			vo.setPlaceName(place.getPlaceName());
			provinces.add(vo);
		}
		return provinces;
	}

	@Override
	public final List<PlaceVo> getCity(final int provinceId) {
		List<Place> places = placeDao.getCity(provinceId);
		List<PlaceVo> citys = new ArrayList<PlaceVo>();
		Iterator<Place> i = places.iterator();
		while (i.hasNext()) {
			Place place = i.next();
			PlaceVo vo = new PlaceVo();
			vo.setId(place.getId());
			vo.setPlaceCode(place.getPlaceCode());
			vo.setPlaceName(place.getPlaceName());
			citys.add(vo);
		}
		return citys;
	}

	@Override
	public final List<PlaceVo> getDistrict(final int cityId) {
		List<Place> places = placeDao.getDistrict(cityId);
		List<PlaceVo> districts = new ArrayList<PlaceVo>();
		Iterator<Place> i = places.iterator();
		while (i.hasNext()) {
			Place place = i.next();
			PlaceVo vo = new PlaceVo();
			vo.setId(place.getId());
			vo.setPlaceCode(place.getPlaceCode());
			vo.setPlaceName(place.getPlaceName());
			districts.add(vo);
		}
		return districts;
	}

}
