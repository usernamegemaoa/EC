package njuse.ec.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import njuse.ec.service.AdvertisementService;
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

	@Override
	public final ResultVo addAd(final AdVo adVo) {
		ResultVo result = new ResultVo();
		if (adVo == null) {
			result.setResultCode(1);
		} else {
			result.setResultCode(0);
		}
		return result;
	}

	@Override
	public final ResultVo delAd(final int userId, final int adId) {
		ResultVo result = new ResultVo();
		if (userId < 0) {
			result.setResultCode(1);
		} else {
			result.setResultCode(0);
		}
		return result;
	}

	@Override
	public final List<AdVo> getAds(final int userId) {
		List<AdVo> adVoList = new ArrayList<AdVo>();
		if (userId > 0) {
			adVoList.add(new AdVo());
		}
		return adVoList;
	}

	@Override
	public final List<AdVo> getAds(final KindVo kindVo) {
		List<AdVo> adVoList = new ArrayList<AdVo>();
		if (kindVo != null) {
			adVoList.add(new AdVo());
		}
		return adVoList;
	}

	@Override
	public final ResultVo addIndexAd(final AdVo adVo) {
		ResultVo result = new ResultVo();
		if (adVo == null) {
			result.setResultCode(1);
		} else {
			result.setResultCode(0);
		}
		return result;
	}

	@Override
	public final ResultVo addLatestAd(final AdVo adVo) {
		ResultVo result = new ResultVo();
		if (adVo == null) {
			result.setResultCode(1);
		} else {
			result.setResultCode(0);
		}
		return result;
	}

	@Override
	public final List<AdVo> getIndexAd() {
		List<AdVo> adVoList = new ArrayList<AdVo>();
		adVoList.add(new AdVo());
		return adVoList;
	}

	@Override
	public final List<AdVo> getLatestAd() {
		List<AdVo> adVoList = new ArrayList<AdVo>();
		adVoList.add(new AdVo());
		return adVoList;
	}

}
