package tel.wits.servicematrix.service;

import tel.wits.common.pagination.Page;
import tel.wits.common.service.IBaseService;
import tel.wits.servicematrix.model.infomodel.RobotModel;
import tel.wits.servicematrix.model.infomodel.RobotQueryModel;


public interface IRobotService extends IBaseService<RobotModel, Integer> {

    Page<RobotModel> queryByIndividualId(int pn, int pageSize, int individualId);
    
    Page<RobotModel> query(int pn, int pageSize, RobotQueryModel command);

    int clearNotice(int individualId);
}
