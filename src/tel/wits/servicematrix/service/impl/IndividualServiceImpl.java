package tel.wits.servicematrix.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tel.wits.common.pagination.Page;
import tel.wits.common.pagination.PageUtil;
import tel.wits.common.repository.IBaseDao;
import tel.wits.common.service.impl.BaseService;
import tel.wits.servicematrix.model.infomodel.IndividualModel;
import tel.wits.servicematrix.model.infomodel.IndividualQueryModel;
import tel.wits.servicematrix.repository.infodao.IIndividualDao;
import tel.wits.servicematrix.service.IIndividualService;


@Service("IndividualService")
public class IndividualServiceImpl extends BaseService<IndividualModel, Integer> implements IIndividualService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndividualServiceImpl.class);

    private IIndividualDao individualDao;

    @Autowired
    @Qualifier("IndividualDao")
    @Override
    public void setBaseDao(IBaseDao<IndividualModel, Integer> individualDao) {
        this.baseDao = individualDao;
        this.individualDao = (IIndividualDao) individualDao;
    }
    


    @Override
    public Page<IndividualModel> queryByUserName(int pn, int pageSize, String userName) {
    	IndividualQueryModel command = new IndividualQueryModel();
    	command.setUserName(userName);
        return PageUtil.getPage(individualDao.countQueryByUserName(command) ,pn, individualDao.queryByUserName(pn, pageSize, command), pageSize);
    }



	@Override
	public IndividualModel getByLoginName(String loginName) {
		return individualDao.uniqueLoginName(loginName);
	}



	@Override
	public IndividualModel getByUserName(String userName) {
		return individualDao.uniqueUserName(userName);
	}

    
}