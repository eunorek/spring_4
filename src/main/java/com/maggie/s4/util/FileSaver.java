package com.maggie.s4.util;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	public String saveCopy(File dest, MultipartFile multipartFile) throws Exception {
		// get dir to save photo
		if(!dest.exists()) {
			dest.mkdirs();
		}
		// make name
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		String fname = multipartFile.getOriginalFilename();
		fname = time + "_" + fname;
		
		System.out.println(dest.getPath());
		System.out.println("image size: " + multipartFile.getSize());
		
		// save photo	
		// new File(parent, childFileName)
		dest = new File(dest, fname);
		FileCopyUtils.copy(multipartFile.getBytes(), dest);
		return fname;
	}
	
	public String saveTransfer(File dest, MultipartFile multipartFile) throws Exception {
		// get dir to save photo
		if(!dest.exists()) {
			dest.mkdirs();
		}
		// make name
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		String fname = multipartFile.getOriginalFilename();
		fname = time + "_" + fname;
		
		System.out.println(fname);
		System.out.println("image size: " + multipartFile.getSize());
		
		// save photo	
		// new File(parent, childFileName)
		dest = new File(dest, fname);
		multipartFile.transferTo(dest);
		return fname;
	}
	
	public File getDestinationFile(HttpSession session, String dir) {
		String path = session.getServletContext().getRealPath("/resources/upload/" + dir + "/");
		File dest = new File(path);
		return dest;
	}
	
}
