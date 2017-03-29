package cn.wedfrend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wedfrend.category.user;
import cn.wedfrend.util.BaseDao;

public class UserDAO extends BaseDao {

	/**
	 * 查询user表中的所有数据
	 * 
	 * @return
	 */
	public List<user> getAllUser() {
		// 先声明一个list
		List<user> lsUser = new ArrayList<user>();
		// 插寻数据库
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
				// 关闭流
				this.colse();
			}
			return lsUser;
		} else {
			return null;
		}
	}

	/**
	 * AJAX来进行用户名是否已经注册
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
				// 关闭流
				this.colse();
			}
		}
		return 1;// 用户名不存在
	}
	
	
	/**
	 * 查询数据：登陆的时候
	 * 
	 * @return 0：成功，1：密码错误，2：用户名不存在
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
					if (us.getPws().equals(psw)) {//这样写有一种防错机制时
						return 0;// 成功匹配

					} else {
						return 1;// 表示密码错误
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// 关闭流
				this.colse();
			}
		}
		return 2;// 用户名不存在
	}
	
	
	/**
	 * 查询数据库，并且判断登陆名以及密码
	 * @param us
	 * @return
	 */
	public user getUser(user us) {
		List<user> listUser = this.getAllUser();
		if(listUser != null)
		for (user u : listUser) {
			if(u.getName().equals(us.getName())&& u.getPws().equals(us.getPws())){
				//返回的一定是数据库查询出来的user，原因是什么，用户登陆只需要一个用户名和密码，但是你的数据库中存储用户的信息一定是很详细的
				return u;
			}
		}
		return null;
	}
	
	
	
	
	/**
	 * 注册新用户：
	 * 
	 * 注意点
	 * 
	 * 		1.注册先要匹配用户名是否存在
	 * 
	 * 		2.不存在进行数据的写入，存在则进行用户提示，目前还没有使用ajax机制，所以就先使用跳转的方式进行使用
	 * 
	 * @param name
	 * @param psw
	 * @return 0:注册成功  1：注册失败  2：注册用户名已经存在
	 */
	public int resignUser(String name,String psw){
		
		//第一步，进行数据查询
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
