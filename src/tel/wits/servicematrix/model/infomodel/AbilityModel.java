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
@Table(name = "tbl_ability")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AbilityModel extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ability_id", nullable = false)
    private int abilityId;
    
    @Column(name = "channel_id", nullable = false)
    private int channelId;

    @Column(name = "interface_id", nullable = false)
    private int interfaceId;

    @Column(name = "prototype_id", nullable = false)
    private int prototypeId;

    @Column(name = "ability_name", nullable = false)
    private String abilityName;
    
    @Column(name = "ability_type", nullable = false)
    private String abilityType;
    
    @Column(name = "description", nullable = true)
    private String description;
   
    
    
    
 	
	
	public int getAbilityId() {
		return abilityId;
	}
	public void setAbilityId(int abilityId) {
		this.abilityId = abilityId;
	}
	public int getInterfaceId() {
		return interfaceId;
	}
	public void setInterfaceId(int interfaceId) {
		this.interfaceId = interfaceId;
	}
	public int getPrototypeId() {
		return prototypeId;
	}
	public void setPrototypeId(int prototypeId) {
		this.prototypeId = prototypeId;
	}
	public String getAbilityName() {
		return abilityName;
	}
	public void setAbilityName(String abilityName) {
		this.abilityName = abilityName;
	}
	public String getAbilityType() {
		return abilityType;
	}
	public void setAbilityType(String abilityType) {
		this.abilityType = abilityType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + abilityId;
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
        AbilityModel other = (AbilityModel) obj;
        if (abilityId != other.abilityId)
            return false;
        return true;
    }
    
    
    
}
