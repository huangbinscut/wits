package tel.wits.servicematrix.repository.infodao;

import java.util.List;

import tel.wits.common.repository.IBaseDao;
import tel.wits.servicematrix.model.infomodel.ExecutionModel;
import tel.wits.servicematrix.model.infomodel.ExecutionQueryModel;


public interface IExecutionDao extends IBaseDao<ExecutionModel, Integer> {
    
    List<ExecutionModel> queryByRobotId(int pn, int pageSize, ExecutionQueryModel command);

    int countQueryByRobotId(ExecutionQueryModel command);

    List<ExecutionModel> queryByIndividualId(int pn, int pageSize, ExecutionQueryModel command);

    int countQueryByIndividualId(ExecutionQueryModel command);
}
