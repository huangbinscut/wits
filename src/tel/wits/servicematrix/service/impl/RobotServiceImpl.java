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
import tel.wits.servicematrix.model.infomodel.RobotModel;
import tel.wits.servicematrix.model.infomodel.RobotQueryModel;
import tel.wits.servicematrix.repository.infodao.IRobotDao;
import tel.wits.servicematrix.service.IRobotService;


@Service("RobotService")
public class RobotServiceImpl extends BaseService<RobotModel, Integer> implements IRobotService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RobotServiceImpl.class);

    private IRobotDao robotDao;

    @Autowired
    @Qualifier("RobotDao")
    @Override
    public void setBaseDao(IBaseDao<RobotModel, Integer> robotDao) {
        this.baseDao = robotDao;
        this.robotDao = (IRobotDao) robotDao;
    }
    


    @Override
    public Page<RobotModel> queryByIndividualId(int pn, int pageSize, int individualId) {
    	RobotQueryModel command = new RobotQueryModel();
    	command.setIndividualId(individualId);
        return PageUtil.getPage(robotDao.countQueryByIndividualId(command) ,pn, robotDao.queryByIndividualId(pn, pageSize, command), pageSize);
    }


	@Override
	public Page<RobotModel> query(int pn, int pageSize, RobotQueryModel command) {
        return PageUtil.getPage(robotDao.countQueryByIndividualId(command) ,pn, robotDao.queryByIndividualId(pn, pageSize, command), pageSize);
	}



	@Override
	public int clearNotice(int individualId) {
		return robotDao.clearNotice(individualId);
	}





   
}