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
import tel.wits.servicematrix.model.infomodel.ExecutionModel;
import tel.wits.servicematrix.model.infomodel.ExecutionQueryModel;
import tel.wits.servicematrix.repository.infodao.IExecutionDao;
import tel.wits.servicematrix.service.IExecutionService;


@Service("ExecutionService")
public class ExecutionServiceImpl extends BaseService<ExecutionModel, Integer> implements IExecutionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutionServiceImpl.class);

    private IExecutionDao executionDao;

    @Autowired
    @Qualifier("ExecutionDao")
    @Override
    public void setBaseDao(IBaseDao<ExecutionModel, Integer> executionDao) {
        this.baseDao = executionDao;
        this.executionDao = (IExecutionDao) executionDao;
    }
    


    @Override
    public Page<ExecutionModel> queryByRobotId(int pn, int pageSize, int robotId) {
    	ExecutionQueryModel command = new ExecutionQueryModel();
    	command.setRobotId(robotId);
        return PageUtil.getPage(executionDao.countQueryByRobotId(command) ,pn, executionDao.queryByRobotId(pn, pageSize, command), pageSize);
    }

    @Override
    public Page<ExecutionModel> queryByIndividualId(int pn, int pageSize, int individualId) {
    	ExecutionQueryModel command = new ExecutionQueryModel();
    	command.setRobotId(individualId);
        return PageUtil.getPage(executionDao.countQueryByIndividualId(command) ,pn, executionDao.queryByIndividualId(pn, pageSize, command), pageSize);
    }
  
    @Override
    public Page<ExecutionModel> query(int pn, int pageSize, ExecutionQueryModel command) {
        return PageUtil.getPage(executionDao.countQueryByIndividualId(command) ,pn, executionDao.queryByIndividualId(pn, pageSize, command), pageSize);
    }
}