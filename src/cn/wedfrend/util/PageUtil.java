package cn.wedfrend.util;

public class PageUtil {
	
	private int pageSize;//ÿһҳ��ʾ�ĸ���
	private int totalCount;//�ܵ�����
	private int totalPage;//��ҳ��
	private int currentPage;//��ǰҳ
	
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
	public int getTotalPage() {//�ܵ�ҳ��
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
