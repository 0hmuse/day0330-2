package com.example.demo.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.UploadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.GoodsDao;
import com.example.demo.vo.GoodsVo;
import com.google.gson.Gson;

@RestController
public class GoodsController {

	@Autowired
	private GoodsDao dao;
	
	@RequestMapping(value="/listGoods", produces = "application/json;charset=utf8")
	public String listGoods() {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.listGoods());
		return str;
	}
	
	@RequestMapping(value="/detailGoods", produces = "application/json;charset=utf-8")
	public String detailGoods(GoodsVo v) {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.detailGoods(v));
		return str;
	
	}
	
	@RequestMapping(value = "/insertGoods")
	public String insertGoods(GoodsVo v) {
		String str = "상품 등록에 실패하였습니다.";
		String path = "C:\\stsAopTest\\day0327bitShop\\src\\main\\resources\\static\\day0327\\img";
		MultipartFile uploadFile = v.getUploadFile();
		System.out.println(uploadFile);
		String fname = "";
		if(uploadFile!=null && !uploadFile.equals("")) {
			fname = uploadFile.getOriginalFilename();
		}
		
		v.setNo(dao.nextNo());
		v.setFname(fname);
		
		int re = dao.insertGoods(v);
		if(re>0) {
			str = "상품 등록에 성공하였습니다.";
			try {
				byte[] data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return str;
	}
	
	@RequestMapping("/updateGoods")
	public String updateGoods(GoodsVo v) {
		String str = "상품 수정에 실패하였습니다.";
		int re = dao.updateGoods(v);
		if(re>0) {
			str = "상품 수정에 성공하였습니다.";
		}
		return str;
		
	}
	
	@RequestMapping("/deleteGoods")
	public String deleteGoods(GoodsVo v) {
		String str = "상품 삭제 실패하였습니다.";
		int re = dao.deleteGoods(v);
		if(re>0) {
			str = "상품 삭제 성공하였습니다.";
		}
		return str;
		
	}
	
}
