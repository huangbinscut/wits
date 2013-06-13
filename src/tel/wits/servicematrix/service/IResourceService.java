package tel.wits.servicematrix.service;

import tel.wits.common.pagination.Page;
import tel.wits.common.service.IBaseService;
import tel.wits.servicematrix.model.infomodel.ResourceModel;
import tel.wits.servicematrix.model.infomodel.ResourceQueryModel;


public interface IResourceService extends IBaseService<ResourceModel, Integer> {

    Page<ResourceModel> queryByIndividualId(int pn, int pageSize, int individualId);
    
    Page<ResourceModel> queryByRobotId(int pn, int pageSize, int robotId);
    
    Page<ResourceModel> queryByExecutionId(int pn, int pageSize, int executionId);

    Page<ResourceModel> query(int pn, int pageSize, ResourceQueryModel command);
}
