package njuse.ec.service;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 文件测试.
 * @author 丞
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class FileServiceTest {
	
	/**
	 * 文件service.
	 */
	@Autowired
	private FileService fileService;

	/**
	 * 测试上传函数.
	 */
	@Test
	public final void testUpload() {
//		assertEquals(1, fileService.upload(null).getResultCode());
//		assertEquals(0, fileService.upload(new File("aaa")).getResultCode());
	}

}
