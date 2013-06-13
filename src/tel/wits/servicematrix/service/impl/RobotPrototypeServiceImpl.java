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
import tel.wits.servicematrix.model.infomodel.RobotPrototypeModel;
import tel.wits.servicematrix.model.infomodel.RobotPrototypeQueryModel;
import tel.wits.servicematrix.repository.infodao.IRobotPrototypeDao;
import tel.wits.servicematrix.service.IRobotPrototypeService;


@Service("RobotPrototypeService")
public class RobotPrototypeServiceImpl extends BaseService<RobotPrototypeModel, Integer> implements IRobotPrototypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RobotPrototypeServiceImpl.class);

    private IRobotPrototypeDao robotPrototypeDao;

    @Autowired
    @Qualifier("RobotPrototypeDao")
    @Override
    public void setBaseDao(IBaseDao<RobotPrototypeModel, Integer> robotPrototypeDao) {
        this.baseDao = robotPrototypeDao;
        this.robotPrototypeDao = (IRobotPrototypeDao) robotPrototypeDao;
    }
    


    @Override
    public Page<RobotPrototypeModel> queryByPrototypeName(int pn, int pageSize, String prototypeName) {
    	RobotPrototypeQueryModel command = new RobotPrototypeQueryModel();
    	command.setPrototypeName(prototypeName);
    	
        return PageUtil.getPage(robotPrototypeDao.countQueryByPrototypeName(command) ,pn, robotPrototypeDao.queryByPrototypeName(pn, pageSize, command), pageSize);
    }



	@Override
    //TODO only support query of prototype name now, need to support all field query
	public Page<RobotPrototypeModel> query(int pn, int pageSize,
			RobotPrototypeQueryModel command) {
		
        return PageUtil.getPage(robotPrototypeDao.countQueryByPrototypeName(command) ,pn, robotPrototypeDao.queryByPrototypeName(pn, pageSize, command), pageSize);
	}

   
}