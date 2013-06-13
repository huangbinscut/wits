package tel.wits.servicematrix.service;

import tel.wits.common.pagination.Page;
import tel.wits.common.service.IBaseService;
import tel.wits.servicematrix.model.infomodel.RobotPrototypeModel;
import tel.wits.servicematrix.model.infomodel.RobotPrototypeQueryModel;


public interface IRobotPrototypeService extends IBaseService<RobotPrototypeModel, Integer> {

    Page<RobotPrototypeModel> queryByPrototypeName(int pn, int pageSize, String prototypeName);
    
    Page<RobotPrototypeModel> query(int pn, int pageSize, RobotPrototypeQueryModel command);
}
