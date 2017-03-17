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
	 * �������
	 */
	private void getConnection(){
		//��������
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
	 * �ر�����
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
	 * �������ݿ�
	 * @param sql
	 * @param ob �ɱ����
	 * @return
	 */
	public int executUpdate(String sql,Object...ob){
		
		try {
			this.getConnection();
			ps = conn.prepareStatement(sql);
			if(ob != null){
				//���ò���
				for (int i = 0; i < ob.length; i++) {
					//ps�����Ǵ�1��ʼ��
					ps.setObject(i+1, ob[i]);
				}
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//�ر����ӣ��ͷ���Դ
			this.colse();
		}
		return -1;
	}

	public ResultSet executeQuery(String sql,Object...ob){
		try {
			this.getConnection();
			ps = conn.prepareStatement(sql);
			if(ob != null){
				//���ò���
				for (int i = 0; i < ob.length; i++) {
					//ps�����Ǵ�1��ʼ��
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
