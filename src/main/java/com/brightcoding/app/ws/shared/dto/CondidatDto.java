package com.brightcoding.app.ws.shared.dto;

import com.brightcoding.app.ws.entities.*;


import java.util.Date;
import java.util.List;





public class CondidatDto  {
    


	private long id;
    private String firstName;
    private String phone;
    private String lastName;
    private String gender;
    private Date date_birthday;
    private String nationality;
    private AuthProvider authProvider;
   private String phoneEtronger;
   private List<OriginEntity> origins;
	private String userId;
    
    private String familyPhone ;
	
	private String email;

	private Role role;
	
	private String resetToken;
	
	private String encryptedPassword;
    
    private String photo;
    
    private   Application application;
   
    private List<EducationEntity> education;

    private List<ExperienceEntity> experience;
 
    private List<SkillsEntity> skills;

    List<CondidatOffreEntity> condidatoffre;


    private List<QuestionEntity> question;

    private List<DocumentEntity> document;
  
    private List<Hobbies> hobbies ;
    
    
    
//getter and setters and constructors
    
    
    public long getId() {
		return id;
	}
    

    public List<ExperienceEntity> getExperience() {
        return experience;
    }

    public List<Hobbies> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<Hobbies> hobbies) {
		this.hobbies = hobbies;
	}

	public String getFamilyPhone() {
		return familyPhone;
	}

	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public List<CondidatOffreEntity> getCondidatoffre() {
		return condidatoffre;
	}

	public void setCondidatoffre(List<CondidatOffreEntity> condidatoffre) {
		this.condidatoffre = condidatoffre;
	}

	public void setExperience(List<ExperienceEntity> experience) {
        this.experience = experience;
    }

    public List<SkillsEntity> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillsEntity> skills) {
        this.skills = skills;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public List<QuestionEntity> getQuestion() {
        return question;
    }

    public void setQuestion(List<QuestionEntity> question) {
        this.question = question;
    }

    public List<DocumentEntity> getDocument() {
        return document;
    }

    public void setDocument(List<DocumentEntity> document) {
        this.document = document;
    }

    
   

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<EducationEntity> getEducation() {
        return education;
    }

    public void setEducation(List<EducationEntity> education) {
        this.education = education;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getDate_birthday() {
        return date_birthday;
    }
    public void setDate_birthday(Date date_birthday) {
        this.date_birthday = date_birthday;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


	public void setId(long id) {
		this.id = id;
	}

	
    
	 public AuthProvider getAuthProvider() {
			return authProvider;
		}


		public void setAuthProvider(AuthProvider authProvider) {
			this.authProvider = authProvider;
		}


    
    public CondidatDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
    public String toString() {
        return "Condidat [firstName=" + firstName + ", photo=" + photo + ", phone=" + phone + ", lastName=" + lastName + ", date_birthday=" + date_birthday
                + ", gender=" + gender + ", nationality=" + nationality + ", email=" + getEmail()+ ", userId=" + getUserId() + "]";
    }


	public String getPhoneEtronger() {
		return phoneEtronger;
	}


	public void setPhoneEtronger(String phoneEtronger) {
		this.phoneEtronger = phoneEtronger;
	}


	public List<OriginEntity> getOrigins() {
		return origins;
	}


	public void setOrigins(List<OriginEntity> origins) {
		this.origins = origins;
	}


}

