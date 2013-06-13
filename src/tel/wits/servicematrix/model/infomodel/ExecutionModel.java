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
@Table(name = "tbl_execution")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ExecutionModel extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "execution_id", nullable = false)
    private int executionId;
    
    @Column(name = "individual_id", nullable = false)
    private int individualId;

    @Column(name = "robot_id", nullable = false)
    private int robotId;

    @Column(name = "execution_time", nullable = false)
    private Date executionTime;
    
    @Column(name = "input_count", nullable = false)
    private int inputCount;
    
    @Column(name = "output_count", nullable = false)
    private int outputCount;
   
    @Column(name = "read_count", nullable = false)
    private int readCount;

    @Column(name = "resource_new", nullable = false)
    private int resourceNew;
    
    @Column(name = "execution_log", nullable = true)
    private String executionLog;   
    
	
	public int getExecutionId() {
		return executionId;
	}
	public void setExecutionId(int executionId) {
		this.executionId = executionId;
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
	public Date getExecutionTime() {
		return executionTime;
	}
	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}
	public int getInputCount() {
		return inputCount;
	}
	public void setInputCount(int inputCount) {
		this.inputCount = inputCount;
	}
	public int getOutputCount() {
		return outputCount;
	}
	public void setOutputCount(int outputCount) {
		this.outputCount = outputCount;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public int getResourceNew() {
		return resourceNew;
	}
	public void setResourceNew(int resourceNew) {
		this.resourceNew = resourceNew;
	}
	public String getExecutionLog() {
		return executionLog;
	}
	public void setExecutionLog(String executionLog) {
		this.executionLog = executionLog;
	}
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + executionId;
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
        ExecutionModel other = (ExecutionModel) obj;
        if (executionId != other.executionId)
            return false;
        return true;
    }
    
    
    
}
