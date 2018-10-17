package com.wossha.auth.commands.modifyuser.model;

import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wossha.msbase.models.PictureFileDTO;
import java.sql.Timestamp;

public class UserDTO{

	private String username;
	private String password;
	private Boolean enabled;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private Integer country;
    private String about;
    private PictureFileDTO profilePicture;
    private PictureFileDTO coverPicture;
    
    // Formats output date when this DTO is passed through JSON
    @JsonFormat(pattern = "yyyy-MM-dd")
    // Allows yyyy-MM-dd date to be passed into GET request in JSON
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp birthday;
    
    private List<String> roles;
    
    
	public UserDTO(String username, String password, String firstName, String lastName, String gender, String email, Integer country, String about, Boolean enabled, Timestamp birthday, List<String> roles) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.country = country;
		this.about = about;
		this.enabled = enabled;
		this.birthday = birthday;
		this.roles = roles;
	}
	
	public UserDTO(String username, String firstName, String lastName, String gender, String email, Integer country, String about, Timestamp birthday) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.country = country;
		this.about = about;
		this.birthday = birthday;
	}
	
	public UserDTO() {}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public PictureFileDTO getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(PictureFileDTO profilePicture) {
		this.profilePicture = profilePicture;
	}

	public PictureFileDTO getCoverPicture() {
		return coverPicture;
	}

	public void setCoverPicture(PictureFileDTO coverPicture) {
		this.coverPicture = coverPicture;
	}
	
	
}