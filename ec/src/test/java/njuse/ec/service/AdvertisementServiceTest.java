package njuse.ec.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import njuse.ec.vo.AdMode;
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
	 * 数据库中用于测试的ID.
	 */
	private static final int MAGIC_ID = 123;
	
	/**
	 * 测试添加广告.
	 */
	@Test
	public final void testAddAd() {
		AdVo vo = new AdVo();
		vo.setMode(AdMode.NORMAL);
		vo.setGoodId(MAGIC_ID);
		vo.setUserId(MAGIC_ID);
		vo.setPicturePath("asdf");
		assertEquals(0, adService.addAd(vo).getResultCode());
	}

	/**
	 * 测试删除广告. 
	 */
	@Test
	public final void testDelAd() {
		AdVo vo = new AdVo();
		vo.setMode(AdMode.NORMAL);
		vo.setGoodId(MAGIC_ID);
		vo.setUserId(MAGIC_ID);
		vo.setPicturePath("asdf");
		assertEquals(0, adService.addAd(vo).getResultCode());
		List<AdVo> ads = adService.getAds(MAGIC_ID);
		assertTrue(ads.size() > 0);
		adService.delAd(MAGIC_ID, ads.get(0).getId());
	}

	/**
	 * 测试获取广告. 
	 */
	@Test
	public final void testGetAdsInt() {
		AdVo vo = new AdVo();
		vo.setMode(AdMode.NORMAL);
		vo.setGoodId(MAGIC_ID);
		vo.setUserId(MAGIC_ID);
		vo.setPicturePath("asdf");
		assertEquals(0, adService.addAd(vo).getResultCode());
		List<AdVo> ads = adService.getAds(MAGIC_ID);
		assertTrue(ads.size() > 0);
	}

	/**
	 * 测试获取广告. 
	 */
	@Test
	public final void testGetAdsKindVo() {
		AdVo vo = new AdVo();
		vo.setMode(AdMode.NORMAL);
		vo.setGoodId(MAGIC_ID);
		vo.setUserId(MAGIC_ID);
		vo.setPicturePath("asdf");
		assertEquals(0, adService.addAd(vo).getResultCode());
		KindVo kindVo = new KindVo();
		kindVo.setKindId(MAGIC_ID);
		assertTrue(adService.getAds(kindVo).size() > 0);
	}

	/**
	 * 测试添加首页广告.
	 */
	@Test
	public final void testAddIndexAd() {
		AdVo vo = new AdVo();
		vo.setMode(AdMode.INDEX);
		vo.setGoodId(MAGIC_ID);
		vo.setUserId(MAGIC_ID);
		vo.setPicturePath("asdf");
		assertEquals(0, adService.addIndexAd(vo).getResultCode());
	}

	/**
	 * 测试添加最新广告. 
	 */
	@Test
	public final void testAddLatestAd() {
		AdVo vo = new AdVo();
		vo.setMode(AdMode.LATEST);
		vo.setGoodId(MAGIC_ID);
		vo.setUserId(MAGIC_ID);
		vo.setPicturePath("asdf");
		assertEquals(0, adService.addLatestAd(vo).getResultCode());
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
