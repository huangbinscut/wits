package tel.wits.servicematrix.repository.infodao;

import java.util.List;

import tel.wits.common.repository.IBaseDao;
import tel.wits.servicematrix.model.infomodel.RobotPrototypeModel;
import tel.wits.servicematrix.model.infomodel.RobotPrototypeQueryModel;


public interface IRobotPrototypeDao extends IBaseDao<RobotPrototypeModel, Integer> {
    
    List<RobotPrototypeModel> queryByPrototypeName(int pn, int pageSize, RobotPrototypeQueryModel command);

    int countQueryByPrototypeName(RobotPrototypeQueryModel command);

}
