package cn.wedfrend.category;

/**
 * @author welive
 *
 * �����ĸ��˰�����
 */
public class HobyCategory {
	
	public HobyCategory(String hoby, String level) {
		super();
		this.hoby = hoby;
		this.level = level;
	}
	//����
	private String hoby;
	//ϲ���̶�
	private String level;
	public String getHoby() {
		return hoby;
	}
	public void setHoby(String hoby) {
		this.hoby = hoby;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
	

}
