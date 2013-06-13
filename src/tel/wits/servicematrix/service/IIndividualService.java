package tel.wits.servicematrix.service;

import tel.wits.common.pagination.Page;
import tel.wits.common.service.IBaseService;
import tel.wits.servicematrix.model.infomodel.IndividualModel;


public interface IIndividualService extends IBaseService<IndividualModel, Integer> {

    Page<IndividualModel> queryByUserName(int pn, int pageSize, String userName);
    
    IndividualModel getByLoginName(String loginName);
    
    IndividualModel getByUserName(String userName);
}
