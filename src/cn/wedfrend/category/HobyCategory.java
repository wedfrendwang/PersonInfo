package cn.wedfrend.category;

/**
 * @author welive
 *
 * 创建的个人爱好类
 */
public class HobyCategory {
	
	public HobyCategory(String hoby, String level) {
		super();
		this.hoby = hoby;
		this.level = level;
	}
	//爱好
	private String hoby;
	//喜爱程度
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
