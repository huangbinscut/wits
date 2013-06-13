package tel.wits.servicematrix.model.infomodel;

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
@Table(name = "tbl_channel")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ChannelModel extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "channel_id", nullable = false)
    private int channelId;
    
    @Column(name = "channel_name", nullable = false)
    private String channelName;
    
    @Column(name = "channel_type", nullable = false)
    private String channelType;
    
    @Column(name = "channel_url", nullable = true)
    private String channelUrl;
   
    @Column(name = "description", nullable = true)
    private String description;    
    
    
 	
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	public String getChannelUrl() {
		return channelUrl;
	}
	public void setChannelUrl(String channelUrl) {
		this.channelUrl = channelUrl;
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
        result = prime * result + channelId;
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
        ChannelModel other = (ChannelModel) obj;
        if (channelId != other.channelId)
            return false;
        return true;
    }
    
    
    
}
