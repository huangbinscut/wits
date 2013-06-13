package tel.wits.servicematrix.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tel.wits.common.pagination.Page;
import tel.wits.common.pagination.PageUtil;
import tel.wits.common.repository.IBaseDao;
import tel.wits.common.service.impl.BaseService;
import tel.wits.servicematrix.model.infomodel.AbilityModel;
import tel.wits.servicematrix.model.infomodel.AbilityQueryModel;
import tel.wits.servicematrix.repository.infodao.IAbilityDao;
import tel.wits.servicematrix.service.IAbilityService;


@Service("AbilityService")
public class AbilityServiceImpl extends BaseService<AbilityModel, Integer> implements IAbilityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbilityServiceImpl.class);

    private IAbilityDao abilityDao;

    @Autowired
    @Qualifier("AbilityDao")
    @Override
    public void setBaseDao(IBaseDao<AbilityModel, Integer> abilityDao) {
        this.baseDao = abilityDao;
        this.abilityDao = (IAbilityDao) abilityDao;
    }
    


    @Override
    public Page<AbilityModel> queryByPrototypeId(int pn, int pageSize, int prototypeId) {
    	AbilityQueryModel command = new AbilityQueryModel();
    	command.setPrototypeId(prototypeId);
        return PageUtil.getPage(abilityDao.countQueryByPrototypeId(command) ,pn, abilityDao.queryByPrototypeId(pn, pageSize, command), pageSize);
    }

    @Override
    public List<AbilityModel> queryByPrototypeId(int prototypeId) {
    	AbilityQueryModel command = new AbilityQueryModel();
    	command.setPrototypeId(prototypeId);
    	return abilityDao.queryByPrototypeId(command);
    }
}