package tel.wits.servicematrix.model.infomodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import tel.wits.common.model.AbstractModel;
import tel.wits.common.web.validator.DateFormat;


@Entity
@Table(name = "tbl_individual")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class IndividualModel extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "individual_id", nullable = false)
    private int individualId;
    
    @Column(name = "login_name", nullable = false)
    @NotEmpty(message = "{login_name.illegal}")
    @Email(message = "{login_name.illegal}") //错误消息会自动到MessageSource中查找
    private String loginName;
    
    @Column(name = "password", nullable = false)
    @Pattern(regexp = "[A-Za-z0-9]{5,20}", message = "{password.illegal}") 
    private String password;    
    
    @Column(name = "password_repeat", nullable = true)
    private String passwordRepeat;    

    @Column(name = "user_name", nullable = false)
    @Pattern(regexp = "[A-Za-z0-9]{1,20}", message = "{user_name.illegal}") 
    private String userName;
    
    @Column(name = "user_type", nullable = false)
    private String userType;
   
    @Column(name = "mobile", nullable = true)
    @Pattern(regexp = "[0-9]{5,20}|^$", message = "{mobile.illegal}")     
    private String mobile;
    
    @Column(name = "email", nullable = false)
    @Email(message = "{email.illegal}") //错误消息会自动到MessageSource中查找
    private String email;

    @Column(name = "generate_time", nullable = false)    
    @DateFormat( message="{generate_time.error}")//自定义的验证器
    private Date generateTime;
    
    @Column(name = "login_time", nullable = true)    
    private Date loginTime;
 
    @Column(name = "last_login_time", nullable = true)    
    private Date lastLoginTime;
    
    @Column(name = "login_count", nullable = false)
    private int loginCount;    
    

    
	public int getIndividualId() {
		return individualId;
	}
	public void setIndividualId(int individualId) {
		this.individualId = individualId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordRepeat() {
		return passwordRepeat;
	}
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getGenerateTime() {
		return generateTime;
	}
	public void setGenerateTime(Date generateTime) {
		this.generateTime = generateTime;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public int getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + individualId;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IndividualModel other = (IndividualModel) obj;
        if (individualId != other.individualId)
            return false;
        return true;
    }
    
    
    
}
