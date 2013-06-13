package tel.wits.servicematrix.service;

import java.util.List;

import tel.wits.common.pagination.Page;
import tel.wits.common.service.IBaseService;
import tel.wits.servicematrix.model.infomodel.AbilityModel;


public interface IAbilityService extends IBaseService<AbilityModel, Integer> {

    Page<AbilityModel> queryByPrototypeId(int pn, int pageSize, int prototypeId);
    
    List<AbilityModel> queryByPrototypeId(int prototypeId);
}
