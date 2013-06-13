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
@Table(name = "tbl_robot_prototype")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RobotPrototypeModel extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prototype_id", nullable = false)
    private int prototypeId;
    
    @Column(name = "prototype_name", nullable = false)
    private String prototypeName;
 
    @Column(name = "function_type", nullable = false)
    private String functionType;

    @Column(name = "design_time", nullable = false)
    private Date designTime;
    
    @Column(name = "price", nullable = false)
    private String price;
    
    @Column(name = "purchase_count", nullable = false)
    private int purchaseCount;

    @Column(name = "description", nullable = true)
    private String description;    
    
	public int getPrototypeId() {
		return prototypeId;
	}
	public void setPrototypeId(int prototypeId) {
		this.prototypeId = prototypeId;
	}
	public String getPrototypeName() {
		return prototypeName;
	}
	public void setPrototypeName(String prototypeName) {
		this.prototypeName = prototypeName;
	}
	public String getFunctionType() {
		return functionType;
	}
	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}
	public Date getDesignTime() {
		return designTime;
	}
	public void setDesignTime(Date designTime) {
		this.designTime = designTime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getPurchaseCount() {
		return purchaseCount;
	}
	public void setPurchaseCount(int purchaseCount) {
		this.purchaseCount = purchaseCount;
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
        result = prime * result + prototypeId;
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
        RobotPrototypeModel other = (RobotPrototypeModel) obj;
        if (prototypeId != other.prototypeId)
            return false;
        return true;
    }
    
    
    
}
