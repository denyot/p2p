package com.hxf.p2p.base.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


/**
 * 上传工具
 * 
 * @author Administrator
 * 
 */
public class UploadUtil {
	/**
	 *
	 * @param file 上传的文件
	 * @param basePath 文件存储路径
	 * @return
	 */
	public static String upload(MultipartFile file, String basePath) {
		String orgFileName = file.getOriginalFilename();
		String fileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(orgFileName);
		try {
			File targetFile = new File(basePath, fileName);
			FileUtils.writeByteArrayToFile(targetFile, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
}
