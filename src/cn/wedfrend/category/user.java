package cn.wedfrend.category;

/**
 * �û���User
 * 
 * id ����  ����
 * 
 * ע�����ʹ�ã���Ȼ��ѯҲ����Ҫʹ�õ�
 * 
 * @author welive
 *
 */
public class user {

	public user(String name, String pws) {
		super();
		this.name = name;
		this.pws = pws;
	}
	public user(int id, String name, String pws) {
		super();
		this.id = id;
		this.name = name;
		this.pws = pws;
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPws() {
		return pws;
	}
	public void setPws(String pws) {
		this.pws = pws;
	}
	private String name;
	private String pws;
}
