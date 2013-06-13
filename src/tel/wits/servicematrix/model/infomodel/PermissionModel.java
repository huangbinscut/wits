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
@Table(name = "tbl_permission")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PermissionModel extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "permission_id", nullable = false)
    private int permissionId;
    
    @Column(name = "token_id", nullable = false)
    private int tokenId;
    
    @Column(name = "robot_id", nullable = false)
    private int robotId;

    @Column(name = "is_available", nullable = false)
    private int isAvailable;
    
    @Column(name = "generate_time", nullable = false)
    private Date generateTime;
   
    @Column(name = "access_time", nullable = true)
    private Date accessTime;

    @Column(name = "last_access_time", nullable = true)
    private Date lastAccessTime;
    
    
 	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public int getTokenId() {
		return tokenId;
	}
	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}
	public int getRobotId() {
		return robotId;
	}
	public void setRobotId(int robotId) {
		this.robotId = robotId;
	}
	public int getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Date getGenerateTime() {
		return generateTime;
	}
	public void setGenerateTime(Date generateTime) {
		this.generateTime = generateTime;
	}
	public Date getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}
	public Date getLastAccessTime() {
		return lastAccessTime;
	}
	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + permissionId;
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
        PermissionModel other = (PermissionModel) obj;
        if (permissionId != other.permissionId)
            return false;
        return true;
    }
    
    
    
}
