package com.maggie.s4.member.memberUser;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.maggie.s4.member.MemberDTO;
import com.maggie.s4.member.MemberService;
import com.maggie.s4.member.memberFile.MemberFileDAO;
import com.maggie.s4.member.memberFile.MemberFileDTO;
import com.maggie.s4.util.FileSaver;

@Service
public class MemberUserService implements MemberService{

	@Autowired
	private MemberUserDAO memberUserDAO;
	
	@Autowired
	private MemberFileDAO memberFileDAO;
	
	@Autowired
	private FileSaver fileSaver;
	
	@Override
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.getMemberLogin(memberDTO);
	}

	@Override
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.setMemberUpdate(memberDTO);
	}
		
	@Override
	public int setMemberDelete(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.setMemberDelete(memberDTO);
	}
	
	@Override
	public MemberDTO getMemberOne(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.getMemberOne(memberDTO);
	}	
	
	@Override
	public int setMemberInsert(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception {
		// insert member data first
		int result = memberUserDAO.setMemberInsert(memberDTO);		
		
		if(photo.getSize()>0) {
			FileSaver fileSaver = new FileSaver();
			File dest = fileSaver.getDestinationFile(session, "member");
			System.out.println(dest.getPath());
			String fname = fileSaver.saveTransfer(dest, photo);
			
			MemberFileDTO memberFileDTO = new MemberFileDTO();
			memberFileDTO.setId(memberDTO.getId());
			memberFileDTO.setFileName(fname);
			memberFileDTO.setOrigName(photo.getOriginalFilename());
			memberFileDAO.setInsert(memberFileDTO);			
		}

		return result;
	}

	@Override
	public MemberDTO getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.getMemberIdCheck(memberDTO);
	}
	
	public MemberFileDTO getMemberImageName(MemberDTO memberDTO) throws Exception {
		return memberFileDAO.getMemberImageName(memberDTO);
	}
	
	
}
