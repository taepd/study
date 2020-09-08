package dto;

public class User {
	
	String userid;
	String cstate;
	int upoint;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCstate() {
		return cstate;
	}
	public void setCstate(String cstate) {
		this.cstate = cstate;
	}
	public int getUpoint() {
		return upoint;
	}
	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", cstate=" + cstate + ", upoint=" + upoint + "]";
	}
	
	
	

}
