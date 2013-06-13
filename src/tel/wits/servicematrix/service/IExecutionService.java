package tel.wits.servicematrix.service;

import tel.wits.common.pagination.Page;
import tel.wits.common.service.IBaseService;
import tel.wits.servicematrix.model.infomodel.ExecutionModel;
import tel.wits.servicematrix.model.infomodel.ExecutionQueryModel;


public interface IExecutionService extends IBaseService<ExecutionModel, Integer> {

    Page<ExecutionModel> queryByRobotId(int pn, int pageSize, int robotId);
    
    Page<ExecutionModel> queryByIndividualId(int pn, int pageSize, int individualId);

    Page<ExecutionModel> query(int pn, int pageSize, ExecutionQueryModel command);
}
