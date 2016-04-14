package njuse.ec.service.impl;

import java.io.File;

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

	@Override
	public final ResultVo upload(final File file) {
		String root = ServletActionContext.getServletContext().getRealPath("");
		String savePath = root + File.separator + "upload" + File.separator;
		savePath += randomString(FILE_NAME_LENGTH);
		savePath += System.currentTimeMillis();
		
		ResultVo uploadResult = new ResultVo();
		if (file == null) {
			uploadResult.setResultCode(1);
			uploadResult.setResultMessage("上传失败");
		} else {
			uploadResult.setResultCode(0);
			uploadResult.setResultMessage("上传成功");
			savePath += "===" + file.getName();
		}

		System.out.println(root);
		uploadResult.setResultMessage(savePath);
		return uploadResult;
	}

}
