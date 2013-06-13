package tel.wits.servicematrix.repository.infodao;

import java.util.List;

import tel.wits.common.repository.IBaseDao;
import tel.wits.servicematrix.model.infomodel.IndividualModel;
import tel.wits.servicematrix.model.infomodel.IndividualQueryModel;


public interface IIndividualDao extends IBaseDao<IndividualModel, Integer> {
    
    List<IndividualModel> queryByUserName(int pn, int pageSize, IndividualQueryModel command);

    int countQueryByUserName(IndividualQueryModel command);
    
    IndividualModel uniqueLoginName(String loginName);

    IndividualModel uniqueUserName(String userName);

}
