package cn.wedfrend.dao;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wedfrend.category.Relation;
import cn.wedfrend.util.BaseDao;

//�ð��´�����������ݿ���صĲ���


public class RelationDAO extends BaseDao{
	
	
	//��ѯ������������
	
	public List<Relation> getAllRelation(){
		List<Relation> list = new ArrayList<Relation>();
		//����������ݿ���в�ѯ
		String sql="select * from relation";
		try {
			ResultSet rs = this.executeQuery(sql);
			while (rs.next()) {
				list.add(new Relation(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//�ͷ���Դ
			this.colse();
		}
		return list;
	}

}
