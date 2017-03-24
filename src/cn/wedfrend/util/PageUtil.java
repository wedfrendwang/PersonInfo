package cn.wedfrend.util;

public class PageUtil {
	
	private int pageSize;//每一页显示的个数
	private int totalCount;//总的数量
	private int totalPage;//总页数
	private int currentPage;//当前页
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {//总的页数
		return totalPage = (totalCount%pageSize==0)?totalCount/pageSize:totalCount/pageSize+1;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
