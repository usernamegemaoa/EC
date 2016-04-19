package njuse.ec.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
//		assertEquals("下装", goodService.getFatherKind().get(1).getName());
	}

	/**
	 * 获取子分类测试.
	 */
	@Test
	public final void testGetSonKind() {
//		KindVo kind = new KindVo();
//		kind.setKindId(1);
//		kind.setFatherKind(0);
//		kind.setName("上装");
//		assertEquals(1, goodService.getSonKind(kind).size());
	}

	/**
	 * 查看最新单品页数测试.
	 */
	@Test
	public final void testGetLatestGoodPages() {
//		assertEquals(1, goodService.getLatestGoodPages());
	}

	/**
	 * 根据页数显示新品列表测试.
	 */
	@Test
	public final void testGetLatestGood() {
//		assertEquals("短裤", goodService.getLatestGood(0).get(0).getName());
	}

	/**
	 * 获取指定种类的商品列表页数测试.
	 */
	@Test
	public final void testGetKindGoodPages() {
//		KindVo kind = new KindVo();
//		kind.setKindId(4);
//		assertEquals(1, goodService.getKindGoodPages(kind));
	}

	/**
	 * 获取指定页数指定种类的商品列表测试.
	 */
	@Test
	public final void testGetKindGood() {
//		KindVo kind = new KindVo();
//		kind.setKindId(4);
//		assertEquals(2, goodService.getKindGood(kind,0).size());	
	}

	/**
	 * 关键字搜索商品列表页数测试.
	 */
	@Test
	public final void testGetSearchGoodPages() {
//		assertEquals(1,goodService.getSearchGoodPages("裤"));
	}

	/**
	 * 获取指定页数关键字搜索商品列表测试.
	 */
	@Test
	public final void testGetSearchGood() {
//		assertEquals(2, goodService.getSearchGood("裤", 0).size());
	}

	/**
	 * 获取商品具体信息测试.
	 */
	@Test
	public final void testGetDetailGood() {
		GoodVo vo = goodService.getDetailGood(2);
		assertEquals(vo.getStocks().size(), 2);
	}

	/**
	 * 获取同类热销商品列表测试.
	 */
	@Test
	public final void testGetHotGood() {
//		assertEquals(1, goodService.getHotGood(1).size());
	}

	/**
	 * 发布商品测试.
	 */
	@Test
	public final void testAddGood() {
//		GoodVo good = new GoodVo();
//		StockVo stock1 = new StockVo();
//		StockVo stock2 = new StockVo();
//		List<StockVo> stocks = new ArrayList<StockVo>();
//		good.setKindId(4);
//		good.setSellerId(276);
//		good.setName("短裤");
//		good.setGoodNum("货号");
//		good.setDescription("商品描述");
//		good.setPrice(11.99);
//		good.setDeliverInfo("送货信息");
//		good.setReturnInfo("退货信息");
//		good.setTime(new Date());
//		stock1.setColor("黄色");
//		stock1.setSize("S");
//		stock1.setQuantity(30);
//		stock2.setColor("黄色");
//		stock2.setSize("M");
//		stock2.setQuantity(40);
//		stocks.add(stock1);
//		stocks.add(stock2);
//		assertEquals(0, goodService.addGood(good, stocks).getResultCode());
	}

	/**
	 * 为商品添加咨询测试.
	 */
	@Test
	public final void testAddGoodConsult() {
//		ConsultVo consult = new ConsultVo();
//		consult.setFatherConsult(1);
//		consult.setTime(new Date());
//		consult.setUserId(123);
//		consult.setConsult("哦哦");
//		assertEquals(0, goodService.addGoodConsult(0, consult).getResultCode());
	}

	/**
	 * 为商品添加评价测试.
	 */
	@Test
	public final void testAddGoodComment() {
//		CommentVo comment = new CommentVo();
//		comment.setFatherComment(0);
//		comment.setGoodId(129);
//		comment.setScore(1);
//		comment.setUserId(123);
//		comment.setTime(new Date());
//		comment.setComment("差评");
//		assertEquals(0, goodService.addGoodComment(129, comment).getResultCode());
	}

	/**
	 * 获取咨询页数测试.
	 */
	@Test
	public final void testGetConsultPages() {
//		assertEquals(1, goodService.getConsultPages(1));
	}

	/**
	 * 获取评价页数测试.
	 */
	@Test
	public final void testGetCommentPages() {
//		assertEquals(1, goodService.getCommentPages(1));
	}

	/**
	 * 获取咨询测试.
	 */
	@Test
	public final void testGetConsults() {
//		assertEquals(1, goodService.getConsults(1, 0).size());
	}

	/**
	 * 获取评价测试.
	 */
	@Test
	public final void testGetComments() {
//		assertEquals(1, goodService.getComments(2, 0).size());
	}
	
	/**
	 * 获取子评论测试.
	 */
	@Test
	public final void testGetSonComments() {
//		assertEquals(1 , goodService.getSonComments(1).size());
	}
	
	/**
	 * 获取子咨询测试.
	 */
	@Test
	public final void testGetSonConsults() {
//		assertEquals(3 , goodService.getSonConsults(1).size());
	}
	
	/**
	 * 测试获取商家所有商品.
	 */
	@Test
	public final void testGetShopGood() {
		List<GoodVo> goods = goodService.getShopGood(276);
		assertEquals(2, goods.size());
		assertEquals(2, goods.get(0).getStocks().size());
	}
	
	/**
	 * 测试修改商品属性.
	 */
	@Test
	public final void testModifyGood() {
		GoodVo vo = goodService.getDetailGood(123);
		assertEquals("ASDF", vo.getGoodNum());
		vo.setGoodNum("testmodify");
		goodService.modifyGood(vo);
		vo = goodService.getDetailGood(123);
		assertEquals("testmodify", vo.getGoodNum());
	}
}
