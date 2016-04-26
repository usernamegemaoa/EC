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
		assertEquals(0, castService.getMyCast(1).size());
	}

	/**
	 * 添加进货单测试.
	 */
	@Test
	public final void testAddCast() {
		assertEquals(0, castService.addCast(1, new CastVo()).getResultCode());
		assertEquals(1, castService.addCast(1, null).getResultCode());
	}

	/**
	 * 删除进货单测试.
	 */
	@Test
	public final void testDeleteCast() {
		assertEquals(0, 
				castService.deleteCast(1, new CastVo()).getResultCode());
		assertEquals(1, castService.deleteCast(1, null).getResultCode());
	}

	/**
	 * 修改进货单测试.
	 */
	@Test
	public final void testModifyCast() {
		assertEquals(0, 
				castService.modifyCast(1, new CastVo()).getResultCode());
		assertEquals(1, castService.modifyCast(1, null).getResultCode());
	}

}
