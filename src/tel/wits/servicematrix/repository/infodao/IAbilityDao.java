package tel.wits.servicematrix.repository.infodao;

import java.util.List;

import tel.wits.common.repository.IBaseDao;
import tel.wits.servicematrix.model.infomodel.AbilityModel;
import tel.wits.servicematrix.model.infomodel.AbilityQueryModel;


public interface IAbilityDao extends IBaseDao<AbilityModel, Integer> {
    
    List<AbilityModel> queryByPrototypeId(int pn, int pageSize, AbilityQueryModel command);
    
    List<AbilityModel> queryByPrototypeId(AbilityQueryModel command);

    int countQueryByPrototypeId(AbilityQueryModel command);

}
