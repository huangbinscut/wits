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
@Table(name = "tbl_interface")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class InterfaceModel extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "interface_id", nullable = false)
    private int interfaceId;
    
    @Column(name = "channel_id", nullable = false)
    private int channelId;
    
    @Column(name = "interface_name", nullable = false)
    private String interfaceName;    
    
    @Column(name = "interface_url", nullable = false)
    private String interfaceUrl;
    
    @Column(name = "interface_type", nullable = false)
    private String interfaceType;
   
    @Column(name = "resource_type", nullable = false)
    private String resourceType;
    
    @Column(name = "description", nullable = true)
    private String description;

	public int getInterfaceId() {
		return interfaceId;
	}
	public void setInterfaceId(int interfaceId) {
		this.interfaceId = interfaceId;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public String getInterfaceUrl() {
		return interfaceUrl;
	}
	public void setInterfaceUrl(String interfaceUrl) {
		this.interfaceUrl = interfaceUrl;
	}
	public String getInterfaceType() {
		return interfaceType;
	}
	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
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
        result = prime * result + interfaceId;
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
        InterfaceModel other = (InterfaceModel) obj;
        if (interfaceId != other.interfaceId)
            return false;
        return true;
    }
    
    
    
}
