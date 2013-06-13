package tel.wits.servicematrix.service;

import tel.wits.common.pagination.Page;
import tel.wits.common.service.IBaseService;
import tel.wits.servicematrix.model.infomodel.PermissionModel;


public interface IPermissionService extends IBaseService<PermissionModel, Integer> {

    Page<PermissionModel> queryByRobotId(int pn, int pageSize, int robotId);
}
