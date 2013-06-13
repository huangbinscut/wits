package tel.wits.servicematrix.repository.infodao;

import java.util.List;

import tel.wits.common.repository.IBaseDao;
import tel.wits.servicematrix.model.infomodel.PermissionModel;
import tel.wits.servicematrix.model.infomodel.PermissionQueryModel;


public interface IPermissionDao extends IBaseDao<PermissionModel, Integer> {
    
    List<PermissionModel> queryByRobotId(int pn, int pageSize, PermissionQueryModel command);

    int countQueryByRobotId(PermissionQueryModel command);

}
