package tel.wits.servicematrix.repository.infodao;

import java.util.List;

import tel.wits.common.repository.IBaseDao;
import tel.wits.servicematrix.model.infomodel.RobotModel;
import tel.wits.servicematrix.model.infomodel.RobotQueryModel;


public interface IRobotDao extends IBaseDao<RobotModel, Integer> {
    
    List<RobotModel> queryByIndividualId(int pn, int pageSize, RobotQueryModel command);

    int countQueryByIndividualId(RobotQueryModel command);
    
    int clearNotice(int individualId);

}
