package njuse.ec.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import njuse.ec.vo.CastVo;

/**
 * 进货单测试.
 * @author 阳
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CastServiceTest {
	
	/**
	 * 进货单service.
	 */
	@Autowired
	private CastService castService;

	/**
	 * 获取进货单测试.
	 */
	@Test
	public final void testGetMyCast() {
//		assertEquals(3, castService.getMyCast(276).size());
	}

	/**
	 * 添加进货单测试.
	 */
	@Test
	public final void testAddCast() {
//		CastVo cast = new CastVo();
//		cast.setStockId(4);
//		cast.setColor("黑色");
//		cast.setGoodId(2);
//		cast.setSize("S");
//		cast.setNum(2);
//		assertEquals(0, castService.addCast(276, cast).getResultCode());
	}

	/**
	 * 删除进货单测试.
	 */
	@Test
	public final void testDeleteCast() {
//		CastVo cast = new CastVo();
//		cast.setCastId(280);
//		cast.setStockId(4);
//		cast.setColor("黑色");
//		cast.setGoodId(2);
//		cast.setSize("S");
//		cast.setNum(2);
//		assertEquals(0, castService.deleteCast(276, cast).getResultCode());
	}

	/**
	 * 修改进货单测试.
	 */
	@Test
	public final void testModifyCast() {
//		CastVo cast = new CastVo();
//		cast.setCastId(279);
//		cast.setStockId(4);
//		cast.setColor("黑色");
//		cast.setGoodId(2);
//		cast.setSize("S");
//		cast.setNum(1);
//		assertEquals(0, castService.modifyCast(276, cast).getResultCode());		
	}
}
