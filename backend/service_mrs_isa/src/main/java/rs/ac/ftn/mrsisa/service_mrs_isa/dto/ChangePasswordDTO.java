package rs.ac.ftn.mrsisa.service_mrs_isa.dto;

public class ChangePasswordDTO {
	
	private String oldPassword;
	
	private String newPassword;
	
	ChangePasswordDTO(){}
	
	

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
	

}
