package njuse.ec.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import njuse.ec.service.FileService;
import njuse.ec.vo.ResultVo;
import static njuse.ec.util.StringUtil.randomString;

/**
 * 文件服务实现.
 * @author 丞
 *
 */
@Service
public class FileServiceImpl implements FileService {
	
	/**
	 * 文件名长度.
	 */
	private static final int FILE_NAME_LENGTH = 5;
	
	/**
	 * 写文件buffer大小.
	 */
	private static final int BUFFER_SIZE = 2048;

	@Override
	public final ResultVo upload(final File file, final String realName) {
		ResultVo uploadResult = new ResultVo();
		if (file == null) {
			uploadResult.setResultCode(1);
			uploadResult.setResultMessage("上传失败");
		} else {
			ServletContext context = ServletActionContext.getServletContext();
			String root = context.getRealPath("");
			String savePath = root + File.separator + "upload" + File.separator;
			String fileName = randomString(FILE_NAME_LENGTH);
			fileName += System.currentTimeMillis();
			fileName += ".";
			fileName += realName.substring(realName.indexOf(".") + 1);
			try {
				FileInputStream fis = new FileInputStream(file);
				File saveFile = new File(savePath, fileName);
				FileOutputStream fos = new FileOutputStream(saveFile);
				byte[] buffer = new byte[BUFFER_SIZE];
				int len = 0;
				while ((len = fis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fis.close();
				fos.close();

				uploadResult.setResultCode(0);
				uploadResult.setResultMessage("upload/" + fileName);
			} catch (FileNotFoundException e) {
				uploadResult.setResultCode(1);
				uploadResult.setResultMessage("上传失败-未找到文件");
				e.printStackTrace();
			} catch (IOException e) {
				uploadResult.setResultCode(1);
				uploadResult.setResultMessage("上传失败-IO异常");
				e.printStackTrace();
			}
		}

		return uploadResult;
	}

}
