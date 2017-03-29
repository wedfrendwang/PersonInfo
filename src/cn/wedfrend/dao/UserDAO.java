package cn.wedfrend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wedfrend.category.user;
import cn.wedfrend.util.BaseDao;

public class UserDAO extends BaseDao {

	/**
	 * ��ѯuser���е���������
	 * 
	 * @return
	 */
	public List<user> getAllUser() {
		// ������һ��list
		List<user> lsUser = new ArrayList<user>();
		// ��Ѱ���ݿ�
		String sql = "select * from user";
		ResultSet rs = this.executeQuery(sql);
		if (rs != null) {
			try {
				while (rs.next()) {
					lsUser.add(new user(rs.getInt(1), rs.getString(2), rs
							.getString(3)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// �ر���
				this.colse();
			}
			return lsUser;
		} else {
			return null;
		}
	}

	/**
	 * AJAX�������û����Ƿ��Ѿ�ע��
	 * @param name
	 * @return
	 */
	public int getAjaxUserByname(String name){
		String sql = "select * from user where name=?";
		ResultSet rs = this.executeQuery(sql, name);
		System.out.println("rs-------------------"+rs.toString());
		if (rs != null) {
			try {
				if(rs.next()){
					return 1;
				}else{
					return 0;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// �ر���
				this.colse();
			}
		}
		return 1;// �û���������
	}
	
	
	/**
	 * ��ѯ���ݣ���½��ʱ��
	 * 
	 * @return 0���ɹ���1���������2���û���������
	 */
	public int getUserByName(String name, String psw) {
		String sql = "select * from user where name=?";
		ResultSet rs = this.executeQuery(sql, name);
		user us = null;
		if (rs != null) {
			try {
				while (rs.next()) {
					us = new user(rs.getInt(1), rs.getString(2),
							rs.getString(3));
					if (us.getPws().equals(psw)) {//����д��һ�ַ������ʱ
						return 0;// �ɹ�ƥ��

					} else {
						return 1;// ��ʾ�������
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// �ر���
				this.colse();
			}
		}
		return 2;// �û���������
	}
	
	
	/**
	 * ��ѯ���ݿ⣬�����жϵ�½���Լ�����
	 * @param us
	 * @return
	 */
	public user getUser(user us) {
		List<user> listUser = this.getAllUser();
		if(listUser != null)
		for (user u : listUser) {
			if(u.getName().equals(us.getName())&& u.getPws().equals(us.getPws())){
				//���ص�һ�������ݿ��ѯ������user��ԭ����ʲô���û���½ֻ��Ҫһ���û��������룬����������ݿ��д洢�û�����Ϣһ���Ǻ���ϸ��
				return u;
			}
		}
		return null;
	}
	
	
	
	
	/**
	 * ע�����û���
	 * 
	 * ע���
	 * 
	 * 		1.ע����Ҫƥ���û����Ƿ����
	 * 
	 * 		2.�����ڽ������ݵ�д�룬����������û���ʾ��Ŀǰ��û��ʹ��ajax���ƣ����Ծ���ʹ����ת�ķ�ʽ����ʹ��
	 * 
	 * @param name
	 * @param psw
	 * @return 0:ע��ɹ�  1��ע��ʧ��  2��ע���û����Ѿ�����
	 */
	public int resignUser(String name,String psw){
		
		//��һ�����������ݲ�ѯ
		if(this.getUserByName(name, psw) == 2){
			String sql = "insert into user(name,pws) values(?,?)";
			if(this.executUpdate(sql, name,psw)>0){
				return 0;
			}else{
				return 1;
			}
		}else{
			return 2;
		}
		
	}
	
	

}
