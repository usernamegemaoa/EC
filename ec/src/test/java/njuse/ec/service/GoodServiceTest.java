package njuse.ec.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import njuse.ec.vo.CommentVo;
import njuse.ec.vo.ConsultVo;
import njuse.ec.vo.GoodVo;
import njuse.ec.vo.KindVo;
import njuse.ec.vo.StockVo;

/**
 * 商品测试.
 * @author 阳
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class GoodServiceTest {
	
	/**
	 * 商品service.
	 */
	@Autowired
	private GoodService goodService;

	/**
	 * 获取第一层分类测试.
	 */
	@Test
	public final void testGetFatherKind() {
//		assertEquals("上装", goodService.getFatherKind().get(0).getName());
	}

	/**
	 * 获取子分类测试.
	 */
	@Test
	public final void testGetSonKind() {
//		assertEquals(0, goodService.getSonKind(new KindVo()).size());
//		assertEquals(null, goodService.getSonKind(null));
	}

	/**
	 * 查看最新单品页数测试.
	 */
	@Test
	public final void testGetLatestGoodPages() {
//		assertTrue(goodService.getLatestGoodPages() >= 0);
	}

	/**
	 * 根据页数显示新品列表测试.
	 */
	@Test
	public final void testGetLatestGood() {
//		assertEquals(0, goodService.getLatestGood(0).size());
//		assertEquals(null, goodService.getLatestGood(-1));
	}

	/**
	 * 获取指定种类的商品列表页数测试.
	 */
	@Test
	public final void testGetKindGoodPages() {
//		assertTrue(goodService.getKindGoodPages(new KindVo()) >= 0);
//		assertTrue(goodService.getKindGoodPages(null) < 0);
	}

	/**
	 * 获取指定页数指定种类的商品列表测试.
	 */
	@Test
	public final void testGetKindGood() {
//		assertEquals(0, goodService.getKindGood(new KindVo(), 0).size());
//		assertEquals(null, goodService.getKindGood(null, 0));
//		assertEquals(null, goodService.getKindGood(new KindVo(), -1));
//		assertEquals(null, goodService.getKindGood(null, -1));
	}

	/**
	 * 关键字搜索商品列表页数测试.
	 */
	@Test
	public final void testGetSearchGoodPages() {
//		assertTrue(goodService.getSearchGoodPages("1") >= 0);
	}

	/**
	 * 获取指定页数关键字搜索商品列表测试.
	 */
	@Test
	public final void testGetSearchGood() {
//		assertEquals(0, goodService.getSearchGood("1", 0).size());
//		assertEquals(null, goodService.getSearchGood("1", -1));
	}

	/**
	 * 获取商品具体信息测试.
	 */
	@Test
	public final void testGetDetailGood() {
//		assertEquals(0, goodService.getDetailGood(0).getGoodId());
	}

	/**
	 * 获取同类热销商品列表测试.
	 */
	@Test
	public final void testGetHotGood() {
//		assertEquals(0, goodService.getHotGood(0).size());
	}

	/**
	 * 发布商品测试.
	 */
	@Test
	public final void testAddGood() {
//		assertEquals(0, goodService.addGood(new GoodVo(), 
//				new ArrayList<StockVo>()).getResultCode());
//		assertEquals(1, goodService.addGood(new GoodVo(), 
//				null).getResultCode());
//		assertEquals(1, goodService.addGood(null, 
//				new ArrayList<StockVo>()).getResultCode());
//		assertEquals(1, goodService.addGood(null, 
//				null).getResultCode());
	}

	/**
	 * 为商品添加咨询测试.
	 */
	@Test
	public final void testAddGoodConsult() {
//		assertEquals(0, goodService.addGoodConsult(0, 
//				new ConsultVo()).getResultCode());
//		assertEquals(1, goodService.addGoodConsult(0, null).getResultCode());
	}

	/**
	 * 为商品添加评价测试.
	 */
	@Test
	public final void testAddGoodComment() {
//		assertEquals(0, goodService.addGoodComment(0, 
//				new CommentVo()).getResultCode());
//		assertEquals(1, goodService.addGoodComment(0, null).getResultCode());
	}

	/**
	 * 获取咨询页数测试.
	 */
	@Test
	public final void testGetConsultPages() {
//		assertTrue(goodService.getConsultPages(0) >= 0);
	}

	/**
	 * 获取评价页数测试.
	 */
	@Test
	public final void testGetCommentPages() {
//		assertTrue(goodService.getCommentPages(0) >= 0);
	}

	/**
	 * 获取咨询测试.
	 */
	@Test
	public final void testGetConsults() {
//		assertEquals(0, goodService.getConsults(0, 0).size());
//		assertEquals(null, goodService.getConsults(0, -1));
	}

	/**
	 * 获取评价测试.
	 */
	@Test
	public final void testGetComments() {
//		assertEquals(0, goodService.getComments(0, 0).size());
//		assertEquals(null, goodService.getComments(0, -1));
	}

}
