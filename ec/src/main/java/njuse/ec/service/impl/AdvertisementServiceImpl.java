package njuse.ec.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import njuse.ec.dao.BaseDao;
import njuse.ec.model.Ad;
import njuse.ec.model.Good;
import njuse.ec.model.User;
import njuse.ec.service.AdvertisementService;
import njuse.ec.vo.AdMode;
import njuse.ec.vo.AdVo;
import njuse.ec.vo.KindVo;
import njuse.ec.vo.ResultVo;

/**
 * 广告模块.
 * @author 丞
 *
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

	/**
	 * user dao.
	 */
	@Autowired
	private BaseDao<User> userDao;
	
	/**
	 * good dao.
	 */
	@Autowired
	private BaseDao<Good> goodDao;
	
	/**
	 * ad dao.
	 */
	@Autowired
	private BaseDao<Ad> adDao;

	@Override
	public final ResultVo addAd(final AdVo adVo) {
		ResultVo result = new ResultVo();

		int userId = adVo.getUserId();
		int goodId = adVo.getGoodId();
		User user = userDao.load(User.class, userId);
		Good good = goodDao.load(Good.class, goodId);
		
		if (user == null || good == null) {
			result.setResultCode(1);
			result.setResultMessage("添加失败");
			return result;
		}
		
		Ad ad = new Ad();
		adVo.setMode(AdMode.NORMAL);
		ad.setMode(adVo.getMode().value());
		ad.setPicPath(adVo.getPicturePath());
		ad.setGood(good);
		ad.setUser(user);
		adDao.save(ad);
		result.setResultCode(0);
		result.setResultMessage("添加成功");

		return result;
	}

	@Override
	public final ResultVo delAd(final int userId, final int adId) {
		ResultVo result = new ResultVo();

		Ad ad = adDao.load(Ad.class, adId);
		if (ad == null || ad.getUser().getId() != userId) {
			result.setResultCode(1);
			result.setResultMessage("删除失败");
		} else {
			adDao.delete(ad);
			result.setResultCode(0);
			result.setResultMessage("删除成功");
		}
		
		return result;
	}

	@Override
	public final List<AdVo> getAds(final int userId) {
		List<AdVo> adVoList = new ArrayList<AdVo>();
		
		User user = userDao.load(User.class, userId);
		Set<Ad> ads = user.getAds();
		Iterator<Ad> i = ads.iterator();
		while (i.hasNext()) {
			AdVo vo = new AdVo();
			Ad ad = i.next();
			vo.setGoodId(ad.getGood().getId());
			vo.setId(ad.getId());
			vo.setMode(AdMode.valueOf(ad.getMode()));
			vo.setPicturePath(ad.getPicPath());
			vo.setUserId(ad.getUser().getId());
			adVoList.add(vo);
		}

		return adVoList;
	}

	@Override
	public final List<AdVo> getAds(final KindVo kindVo) {
		List<AdVo> adVoList = new ArrayList<AdVo>();

		List<Good> goods = goodDao.findlist(
				Good.class,
				"kindId",
				String.valueOf(kindVo.getKindId()));
		
		Iterator<Good> i = goods.iterator();
		while (i.hasNext()) {
			Good good = i.next();
			Set<Ad> goodAds = good.getAds();
			Iterator<Ad> adI = goodAds.iterator();
			while (adI.hasNext()) {
				Ad ad = adI.next();
				AdVo vo = new AdVo();
				vo.setGoodId(ad.getGood().getId());
				vo.setId(ad.getId());
				vo.setMode(AdMode.valueOf(ad.getMode()));
				vo.setPicturePath(ad.getPicPath());
				vo.setUserId(ad.getUser().getId());
				adVoList.add(vo);
			}
		}
		
		return adVoList;
	}

	@Override
	public final ResultVo addIndexAd(final AdVo adVo) {
		ResultVo result = new ResultVo();

		int userId = adVo.getUserId();
		int goodId = adVo.getGoodId();
		User user = userDao.load(User.class, userId);
		Good good = goodDao.load(Good.class, goodId);
		
		if (user == null || good == null) {
			result.setResultCode(1);
			result.setResultMessage("添加失败");
			return result;
		}
		
		Ad ad = new Ad();
		adVo.setMode(AdMode.INDEX);
		ad.setMode(adVo.getMode().value());
		ad.setPicPath(adVo.getPicturePath());
		ad.setGood(good);
		ad.setUser(user);
		adDao.save(ad);
		result.setResultCode(0);
		result.setResultMessage("添加成功");

		return result;
	}

	@Override
	public final ResultVo addLatestAd(final AdVo adVo) {
		ResultVo result = new ResultVo();

		int userId = adVo.getUserId();
		int goodId = adVo.getGoodId();
		User user = userDao.load(User.class, userId);
		Good good = goodDao.load(Good.class, goodId);
		
		if (user == null || good == null) {
			result.setResultCode(1);
			result.setResultMessage("添加失败");
			return result;
		}
		
		Ad ad = new Ad();
		adVo.setMode(AdMode.LATEST);
		ad.setMode(adVo.getMode().value());
		ad.setPicPath(adVo.getPicturePath());
		ad.setGood(good);
		ad.setUser(user);
		adDao.save(ad);
		result.setResultCode(0);
		result.setResultMessage("添加成功");

		return result;
	}

	@Override
	public final List<AdVo> getIndexAd() {
		List<AdVo> adVoList = new ArrayList<AdVo>();
		List<Ad> ads = adDao.findlist(
				Ad.class,
				"mode",
				String.valueOf(AdMode.INDEX.value()));
		Iterator<Ad> i = ads.iterator();
		while (i.hasNext()) {
			Ad ad = i.next();
			AdVo vo = new AdVo();
			vo.setGoodId(ad.getGood().getId());
			vo.setId(ad.getId());
			vo.setMode(AdMode.valueOf(ad.getMode()));
			vo.setPicturePath(ad.getPicPath());
			vo.setUserId(ad.getUser().getId());
			adVoList.add(vo);
		}
		return adVoList;
	}

	@Override
	public final List<AdVo> getLatestAd() {
		List<AdVo> adVoList = new ArrayList<AdVo>();
		List<Ad> ads = adDao.findlist(
				Ad.class,
				"mode",
				String.valueOf(AdMode.LATEST.value()));
		Iterator<Ad> i = ads.iterator();
		while (i.hasNext()) {
			Ad ad = i.next();
			AdVo vo = new AdVo();
			vo.setGoodId(ad.getGood().getId());
			vo.setId(ad.getId());
			vo.setMode(AdMode.valueOf(ad.getMode()));
			vo.setPicturePath(ad.getPicPath());
			vo.setUserId(ad.getUser().getId());
			adVoList.add(vo);
		}
		return adVoList;
	}

}
