package cn.wedfrend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
	/**
	 * ������ݱ�
	 * @param relation
	 * @return
	 */
	public int add(Relation relation){
		String sql = "insert into relation(name,hobby,level,date)values(?,?,?,?)";
		return this.executUpdate(sql, relation.getName(),relation.getHobby(),relation.getLevel(),new SimpleDateFormat("yyyy-MM-dd").format(relation.getDate()));
	}
	
	
	/**
	 * ��ѯ�����б�
	 * @param id
	 * @return
	 */
	public Relation getRelationById(int id){
		String sql="select * from relation where id=?";
		try {
			ResultSet rs = this.executeQuery(sql,id);
			while (rs.next()) {
				return new Relation(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//�ͷ���Դ
			this.colse();
		}
		return null;
	
	}
	
	/**
	 * ���������б�
	 * @param relation
	 * @return
	 */
	public int update(Relation relation){
		String sql = "update relation set name=?,hobby=?,level=?,date=? where id=?";
		return this.executUpdate(sql, relation.getName(),relation.getHobby(),relation.getLevel(),new SimpleDateFormat("yyyy-MM-dd").format(relation.getDate()),relation.getId());
	}
	
	/**
	 * ɾ�������б�
	 * @param id
	 * @return
	 */
	public int del(int id){
		String sql = "delete from relation where id=?";
		return this.executUpdate(sql, id);
	}

}
