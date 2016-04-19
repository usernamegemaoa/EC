package njuse.ec.service;

import java.io.File;

import njuse.ec.vo.ResultVo;

/**
 * 文件模块.
 * @author 丞
 *
 */
public interface FileService {
	
	/**
	 * 上传图片到服务器.
	 * @param file 图片文件
	 * @param fileName 文件名
	 * @return 上传结果
	 */
	ResultVo upload(File file, String fileName);

}
