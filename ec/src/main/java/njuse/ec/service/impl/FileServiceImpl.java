package njuse.ec.service.impl;

import java.io.File;

import org.springframework.stereotype.Service;

import njuse.ec.service.FileService;
import njuse.ec.vo.ResultVo;

/**
 * 文件服务实现.
 * @author 丞
 *
 */
@Service
public class FileServiceImpl implements FileService {

	@Override
	public final ResultVo upload(final File file) {
		ResultVo uploadResult = new ResultVo();
		if (file == null) {
			uploadResult.setResultCode(1);
			uploadResult.setResultMessage("上传失败");
		} else {
			uploadResult.setResultCode(0);
			uploadResult.setResultMessage("上传成功");
		}
		return uploadResult;
	}

}
