package com.brightcoding.app.ws.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "condidat")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class CondidatEntity  implements Serializable {
	
	
	
    private static final long serialVersionUID = -5763827745308343856L;
    
    
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
    @Column(nullable=true, length=50)
    private String firstName;
    @Column(nullable=true, length=50)
    private String phone;
    @Column(nullable=true, length=50)
    private String lastName;
    @Column(nullable=true, length=50)
    private String gender;
    @Temporal(TemporalType.DATE)
    @Column(nullable=true)
    private Date date_birthday;
    @Column(nullable=true, length=50)
    private String nationality;
    @Column(nullable=true)
    private AuthProvider authProvider;
   
	@Column(nullable=true)
	private String userId;
    @Column(nullable=true, length=50)
    private String familyPhone ;
	@Column(nullable=false, length=120, unique=true)
	private String email;
	@Column(nullable=true)
	private Role role;
	@Column(name = "reset_token")
	private String resetToken;
	@Column(nullable=false)
	private String encryptedPassword;
    @Column(nullable=true)
    private String photo;
    @Column(nullable=true)
    private   Application application;
    @OneToMany(cascade = CascadeType.ALL )
    private List<EducationEntity> education;
    @OneToMany(cascade = CascadeType.ALL )
    private List<ExperienceEntity> experience;
    @OneToMany(cascade = CascadeType.ALL )
    private List<SkillsEntity> skills;
    @OneToOne(cascade = CascadeType.ALL )
    CondidatOffreEntity condidatoffre;

  

	@OneToMany(cascade = CascadeType.ALL)
    private List<QuestionEntity> question;
    @OneToMany(cascade = CascadeType.ALL )
    private List<DocumentEntity> document;
    @OneToMany(cascade = CascadeType.ALL )
    private List<Hobbies> hobbies ;
    
    
    
//getter and setters and constructors
    
    public CondidatOffreEntity getCondidatoffre() {
  		return condidatoffre;
  	}


  	public void setCondidatoffre(CondidatOffreEntity condidatoffre) {
  		this.condidatoffre = condidatoffre;
  	}
  	
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


    
    public CondidatEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
    public String toString() {
        return "Condidat [firstName=" + firstName + ", photo=" + photo + ", phone=" + phone + ", lastName=" + lastName + ", date_birthday=" + date_birthday
                + ", gender=" + gender + ", nationality=" + nationality + ", email=" + getEmail()+ ", userId=" + getUserId() + "]";
    }


}
