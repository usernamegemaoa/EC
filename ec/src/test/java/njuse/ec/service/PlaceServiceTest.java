package njuse.ec.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 地理模块测试.
 * @author 丞
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PlaceServiceTest {
	
	/**
	 * 地理模块.
	 */
	@Autowired
	private PlaceService placeService;

	/**
	 * 获取省测试. 
	 */
	@Test
	public final void testGetProvince() {
		assertNotNull(placeService.getProvince().size());
	}

	/**
	 * 测试获取市.
	 */
	@Test
	public final void testGetCity() {
		assertNotNull(placeService.getCity(0).size());
	}

	/**
	 * 测试获取区.
	 */
	@Test
	public final void testGetDistrict() {
		assertNotNull(placeService.getDistrict(0).size());
	}

}
