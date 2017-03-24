package cn.wedfrend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wedfrend.category.Category;
import cn.wedfrend.util.BaseDao;

public class CategoryDAO extends BaseDao{
	
	/**
	 * ��ȡȫ����category�б�
	 * @return
	 */
	public List<Category> getAllCategory(){
		String sql = "select * from category";
		List<Category> list = new ArrayList<Category>();
		try {
			ResultSet rs = this.executeQuery(sql);
			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.colse();
		}
		return null;
		
	}
	
	
	/**
	 * ��ѯ�������
	 * @param id
	 * @return
	 */
	public Category getCategoryById(int id){
		
		String sql = "select * from category where id=?";
		
		try {
			ResultSet rs = this.executeQuery(sql, id);
			while (rs.next()) {
				return new Category(rs.getInt(1), rs.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.colse();
		}
		return null;
		
	}
	

}
