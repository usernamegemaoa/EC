package njuse.ec.service;

import java.util.List;

import njuse.ec.vo.AdVo;
import njuse.ec.vo.KindVo;
import njuse.ec.vo.ResultVo;

/**
 * 广告模块.
 * @author 丞
 *
 */
public interface AdvertisementService {
	
	/**
	 * 添加广告.
	 * @param adVo 广告信息
	 * @return	0 - 添加成功
	 * 			1 - 添加失败
	 */
	ResultVo addAd(AdVo adVo);
	
	/**
	 * 删除广告.
	 * @param userId 用户Id.
	 * @param adId 广告id.
	 * @return	0 - 删除成功
	 * 			1 - 删除失败（广告不存在，非本人所发广告等）
	 */
	ResultVo delAd(int userId, int adId);

	/**
	 * 获取商家所发广告列表.
	 * @param userId 商家id
	 * @return 广告列表
	 */
	List<AdVo> getAds(int userId);
	
	/**
	 * 获取该分类下所有广告.
	 * @param kindVo 分类Vo
	 * @return 广告列表
	 */
	List<AdVo> getAds(KindVo kindVo);

	/**
	 * 添加首页广告.
	 * @param adVo 广告Vo
	 * @return	0 - 添加成功
	 * 			1 - 添加失败
	 */
	ResultVo addIndexAd(AdVo adVo);

	/**
	 * 添加每日上新广告.
	 * @param adVo 广告Vo
	 * @return	0 - 添加成功
	 * 			1 - 添加失败
	 */
	ResultVo addLatestAd(AdVo adVo);

	/**
	 * 获取首页广告.
	 * @return 广告列表
	 */
	List<AdVo> getIndexAd();

	/**
	 * 获取每日上新广告.
	 * @return 广告列表
	 */
	List<AdVo> getLatestAd();
}
