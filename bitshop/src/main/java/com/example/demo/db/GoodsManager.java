package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.GoodsVo;

public class GoodsManager {
	
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader =  Resources.getResourceAsReader("com/example/demo/db/sqlmapconfig.xml");
		    factory = new SqlSessionFactoryBuilder().build(reader);
		    reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public static List<GoodsVo> listAll(){
		SqlSession session = factory.openSession();
		List<GoodsVo> list = session.selectList("goods.selectAll");
		session.close();
		return list;
	}
	
	public static int insert(GoodsVo g){
		SqlSession session = factory.openSession();
		int re = session.insert("goods.insert", g);
		System.out.println("매니저동작");
		session.commit();
		session.close();
		return re;
	}
	
	public static int update(GoodsVo g){
		SqlSession session = factory.openSession();
		int re = session.update("goods.update", g);
		session.commit();
		session.close();
		return re;
	}
	
	public static int delete(GoodsVo g){
		SqlSession session = factory.openSession();
		int re = session.update("goods.delete", g);
		session.commit();
		session.close();
		return re;
	}
}
