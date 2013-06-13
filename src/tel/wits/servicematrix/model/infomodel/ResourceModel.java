package tel.wits.servicematrix.model.infomodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import tel.wits.common.model.AbstractModel;


@Entity
@Table(name = "tbl_resource")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ResourceModel extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resource_id", nullable = false)
    private int resourceId;
    
    @Column(name = "individual_id", nullable = false)
    private int individualId;

    @Column(name = "robot_id", nullable = false)
    private int robotId;

    @Column(name = "execution_id", nullable = false)
    private int executionId;

    @Column(name = "resource_code", nullable = false)
    private String resourceCode;
 
    @Column(name = "resource_name", nullable = false)
    private String resourceName;
    
    @Column(name = "author", nullable = false)
    private String author;
   
    @Column(name = "edition", nullable = false)
    private String edition;
    
    @Column(name = "resource_url", nullable = false)
    private String resourceUrl;
   
    @Column(name = "resource_type", nullable = false)
    private int resourceType;
    
    @Column(name = "access_scope", nullable = false)
    private int accessScope;
   
    @Column(name = "access_method", nullable = false)
    private int accessMethod;   
    
    @Column(name = "generate_time", nullable = false)
    private Date generateTime;
    
    @Column(name = "fetch_time", nullable = false)
    private Date fetchTime;

    @Column(name = "expire_time", nullable = false)
    private Date expireTime;
   
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    @Column(name = "last_update_time", nullable = true)
    private Date lastUpdateTime;

    @Column(name = "read_count", nullable = false)
    private int readCount;

    @Column(name = "is_reserved", nullable = false)
    private int isReserved;

    @Column(name = "description", nullable = true)
    private String description;    
    
    
    
    public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public int getIndividualId() {
		return individualId;
	}
	public void setIndividualId(int individualId) {
		this.individualId = individualId;
	}
	public int getRobotId() {
		return robotId;
	}
	public void setRobotId(int robotId) {
		this.robotId = robotId;
	}
	public int getExecutionId() {
		return executionId;
	}
	public void setExecutionId(int executionId) {
		this.executionId = executionId;
	}
	public String getResourceCode() {
		return resourceCode;
	}
	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getResourceUrl() {
		return resourceUrl;
	}
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
	public int getResourceType() {
		return resourceType;
	}
	public void setResourceType(int resourceType) {
		this.resourceType = resourceType;
	}
	public int getAccessScope() {
		return accessScope;
	}
	public void setAccessScope(int accessScope) {
		this.accessScope = accessScope;
	}
	public int getAccessMethod() {
		return accessMethod;
	}
	public void setAccessMethod(int accessMethod) {
		this.accessMethod = accessMethod;
	}
	public Date getGenerateTime() {
		return generateTime;
	}
	public void setGenerateTime(Date generateTime) {
		this.generateTime = generateTime;
	}
	public Date getFetchTime() {
		return fetchTime;
	}
	public void setFetchTime(Date fetchTime) {
		this.fetchTime = fetchTime;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public int getIsReserved() {
		return isReserved;
	}
	public void setIsReserved(int isReserved) {
		this.isReserved = isReserved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + resourceId;
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
        ResourceModel other = (ResourceModel) obj;
        if (resourceId != other.resourceId)
            return false;
        return true;
    }
    
    
    
}
