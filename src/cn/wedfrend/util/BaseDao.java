package cn.wedfrend.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseDao {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	/**
	 * 获得链接
	 */
	private void getConnection(){
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/wedfrendinfo";
			conn=DriverManager.getConnection(url, "root","root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 关闭链接
	 */
	public void colse(){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	/**
	 * 更新数据库
	 * @param sql
	 * @param ob 可变参数
	 * @return
	 */
	public int executUpdate(String sql,Object...ob){
		
		try {
			this.getConnection();
			ps = conn.prepareStatement(sql);
			if(ob != null){
				//设置参数
				for (int i = 0; i < ob.length; i++) {
					//ps参数是从1开始的
					ps.setObject(i+1, ob[i]);
				}
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//关闭链接，释放资源
			this.colse();
		}
		return -1;
	}

	public ResultSet executeQuery(String sql,Object...ob){
		try {
			this.getConnection();
			ps = conn.prepareStatement(sql);
			if(ob != null){
				//设置参数
				for (int i = 0; i < ob.length; i++) {
					//ps参数是从1开始的
					ps.setObject(i+1, ob[i]);
				}
			}
			return rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
}
