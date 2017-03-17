package cn.wedfrend.dao;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wedfrend.category.Relation;
import cn.wedfrend.util.BaseDao;

//该包下存放所有与数据库相关的操作


public class RelationDAO extends BaseDao{
	
	
	//查询所有数据内容
	
	public List<Relation> getAllRelation(){
		List<Relation> list = new ArrayList<Relation>();
		//这里进行数据库进行查询
		String sql="select * from relation";
		try {
			ResultSet rs = this.executeQuery(sql);
			while (rs.next()) {
				list.add(new Relation(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//释放资源
			this.colse();
		}
		return list;
	}

}
