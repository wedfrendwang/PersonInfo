package cn.wedfrend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wedfrend.category.Book;
import cn.wedfrend.util.BaseDao;
import cn.wedfrend.util.PageUtil;

/**
 * 
 * 数据表Book操作
 * @author welive
 *
 */
public class BookDAO extends BaseDao{
//	CategoryDAO categoryDAO = new CategoryDAO();
	
	
	/**
	 * 查询book列表数据
	 * @return
	 */
	public List<Book> getAllBook(){
		List<Book> list = new ArrayList<Book>();
		String sql = "select * from book";
		try {
			ResultSet rs = this.executeQuery(sql);
			while (rs.next()) {
				list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5), rs.getInt(6)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.colse();
		}
		return null;
	}
	
	
	
	/**
	 * 查询book列表数据,有条件的查询对吧，比如说分页
	 * @return
	 */
	public List<Book> getAllBook(PageUtil pg){
		List<Book> list = new ArrayList<Book>();
		String sql = "select * from book limit ?,?";
		try {
			ResultSet rs = this.executeQuery(sql,(pg.getCurrentPage()-1)*pg.getPageSize(),pg.getPageSize());
			while (rs.next()) {
				list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5), rs.getInt(6)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.colse();
		}
		return null;
	}
	
	
	
	
	public int getAllCount(){//获取页数之前，先获取总的记录数
		String sql = "select count(1) from book";
		try {
			ResultSet rs = this.executeQuery(sql);
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	/**
	 * 添加书籍
	 * @param book
	 * @return
	 */
	public int addBook(Book book){
		String sql = "insert into book(name,author,price,date,categoryId) values(?,?,?,?,?)";
		return this.executUpdate(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getDate(),book.getCategoryId());
	}
	
	
	/**
	 * 跟新数据库
	 * @param book
	 * @return
	 */
	public int update(Book book){
		
		String sql = "update book set name=?,author=?,price=?,date=?,categoryId=? where id=?";
		return this.executUpdate(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getDate(),book.getCategoryId(),book.getId());
	}
	
	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public Book getBookById(int id){
		String sql = "select * from book where id=?";
		try {
			ResultSet rs = this.executeQuery(sql, id);
			while (rs.next()) {
				return new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5), rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.colse();
		}
		return null;
	}
	
	
	/**
	 * 删除一条记录
	 * @param id
	 * @return
	 */
	public int del(int id){
		String sql = "delete from book where id=?";
		return this.executUpdate(sql, id);
		
	}
	

}
