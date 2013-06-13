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
@Table(name = "tbl_robot")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RobotModel extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "robot_id", nullable = false)
    private int robotId;
    
    @Column(name = "prototype_id", nullable = false)
    private int prototypeId;
    
    @Column(name = "individual_id", nullable = false)
    private int individualId;
    
    @Column(name = "robot_name", nullable = false)
    private String robotName;
 
    @Column(name = "manufacture_time", nullable = false)
    private Date manufactureTime;
    
    @Column(name = "exe_count", nullable = false)
    private int exeCount;
    
    @Column(name = "exe_new", nullable = false)
    private int exeNew;
    
	@Column(name = "description", nullable = true)
    private String description;    
    
  	public int getRobotId() {
		return robotId;
	}
	public void setRobotId(int robotId) {
		this.robotId = robotId;
	}
	public int getPrototypeId() {
		return prototypeId;
	}
	public void setPrototypeId(int prototypeId) {
		this.prototypeId = prototypeId;
	}
	public int getIndividualId() {
		return individualId;
	}
	public void setIndividualId(int individualId) {
		this.individualId = individualId;
	}
	public String getRobotName() {
		return robotName;
	}
	public void setRobotName(String robotName) {
		this.robotName = robotName;
	}
	public Date getManufactureTime() {
		return manufactureTime;
	}
	public void setManufactureTime(Date manufactureTime) {
		this.manufactureTime = manufactureTime;
	}
    public int getExeCount() {
		return exeCount;
	}
	public void setExeCount(int exeCount) {
		this.exeCount = exeCount;
	}
	public int getExeNew() {
		return exeNew;
	}
	public void setExeNew(int exeNew) {
		this.exeNew = exeNew;
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
        result = prime * result + robotId;
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
        RobotModel other = (RobotModel) obj;
        if (robotId != other.robotId)
            return false;
        return true;
    }
    
    
    
}
