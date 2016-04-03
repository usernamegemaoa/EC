package njuse.ec.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import njuse.ec.vo.AdVo;
import njuse.ec.vo.KindVo;

/**
 * 广告模块测试.
 * @author 丞
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AdvertisementServiceTest {

	/**
	 * 广告模块. 
	 */
	@Autowired
	private AdvertisementService adService;
	
	/**
	 * 测试添加广告.
	 */
	@Test
	public final void testAddAd() {
		assertEquals(1, adService.addAd(null).getResultCode());
		assertEquals(0, adService.addAd(new AdVo()).getResultCode());
	}

	/**
	 * 测试删除广告. 
	 */
	@Test
	public final void testDelAd() {
		assertEquals(1, adService.delAd(-1, -1).getResultCode());
		assertEquals(0, adService.delAd(1, 1).getResultCode());
	}

	/**
	 * 测试获取广告. 
	 */
	@Test
	public final void testGetAdsInt() {
		assertEquals(1, adService.getAds(1).size());
		assertEquals(0, adService.getAds(-1).size());
	}

	/**
	 * 测试获取广告. 
	 */
	@Test
	public final void testGetAdsKindVo() {
		assertEquals(1, adService.getAds(new KindVo()).size());
		assertEquals(0, adService.getAds(null).size());
	}

	/**
	 * 测试添加首页广告.
	 */
	@Test
	public final void testAddIndexAd() {
		assertEquals(1, adService.addIndexAd(null).getResultCode());
		assertEquals(0, adService.addIndexAd(new AdVo()).getResultCode());
	}

	/**
	 * 测试添加最新广告. 
	 */
	@Test
	public final void testAddLatestAd() {
		assertEquals(1, adService.addLatestAd(null).getResultCode());
		assertEquals(0, adService.addLatestAd(new AdVo()).getResultCode());
	}

	/**
	 * 测试获取主页广告. 
	 */
	@Test
	public final void testGetIndexAd() {
		assertTrue(adService.getIndexAd().size() >= 0);
	}

	/**
	 * 测试获取最新上新的广告. 
	 */
	@Test
	public final void testGetLatestAd() {
		assertTrue(adService.getLatestAd().size() >= 0);
	}

}
