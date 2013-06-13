package tel.wits.servicematrix.repository.infodao;

import java.util.List;

import tel.wits.common.repository.IBaseDao;
import tel.wits.servicematrix.model.infomodel.ResourceModel;
import tel.wits.servicematrix.model.infomodel.ResourceQueryModel;


public interface IResourceDao extends IBaseDao<ResourceModel, Integer> {
    
    List<ResourceModel> queryByIndividualId(int pn, int pageSize, ResourceQueryModel command);

    int countQueryByIndividualId(ResourceQueryModel command);

    List<ResourceModel> queryByRobotId(int pn, int pageSize, ResourceQueryModel command);

    int countQueryByRobotId(ResourceQueryModel command);
    
    List<ResourceModel> queryByExecutionId(int pn, int pageSize, ResourceQueryModel command);

    int countQueryByExecutionId(ResourceQueryModel command);
}
