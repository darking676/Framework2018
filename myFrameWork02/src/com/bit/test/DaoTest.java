package com.bit.test;

import java.sql.SQLException;
import java.util.List;

import com.bit.model.GuestDao;
import com.bit.model.entity.GuestVo;

public class DaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pk=8888;
		GuestVo testBean = new GuestVo(pk,"test",null,9000);
		GuestVo editBean = new GuestVo(testBean.getSabun(),"test2",null,9009);
		GuestVo resultBean=null;
		try {
			GuestDao dao = new GuestDao();
			dao.insertOne(testBean);
			System.out.println("입력성공");
			dao=new GuestDao();
			System.out.println("상세:"+(testBean.equals(dao.selectOne(testBean.getSabun()))));
			dao=new GuestDao();
			System.out.println("수정:"+(dao.updateOne(editBean)>0));
			dao=new GuestDao();
			System.out.println("삭제 :"+(dao.deleteOne(editBean.getSabun())>0));
//			List<GuestVo> list = dao.selectAll();
//			if(list!=null && list.size()>0){
//				System.out.println("seccess");
//			}else{
//				System.out.println("err");
//			}
//			for(GuestVo bean : list){
//				System.out.println(bean);
//			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
