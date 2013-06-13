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
import tel.wits.servicematrix.model.infomodel.ResourceModel;
import tel.wits.servicematrix.model.infomodel.ResourceQueryModel;
import tel.wits.servicematrix.repository.infodao.IResourceDao;
import tel.wits.servicematrix.service.IResourceService;


@Service("ResourceService")
public class ResourceServiceImpl extends BaseService<ResourceModel, Integer> implements IResourceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceServiceImpl.class);

    private IResourceDao resourceDao;

    @Autowired
    @Qualifier("ResourceDao")
    @Override
    public void setBaseDao(IBaseDao<ResourceModel, Integer> resourceDao) {
        this.baseDao = resourceDao;
        this.resourceDao = (IResourceDao) resourceDao;
    }
    


    @Override
    public Page<ResourceModel> queryByIndividualId(int pn, int pageSize, int individualId) {
    	ResourceQueryModel command = new ResourceQueryModel();
    	command.setIndividualId(individualId);
        return PageUtil.getPage(resourceDao.countQueryByIndividualId(command) ,pn, resourceDao.queryByIndividualId(pn, pageSize, command), pageSize);
    }

    @Override
    public Page<ResourceModel> queryByRobotId(int pn, int pageSize, int robotId) {
    	ResourceQueryModel command = new ResourceQueryModel();
    	command.setRobotId(robotId);
        return PageUtil.getPage(resourceDao.countQueryByRobotId(command) ,pn, resourceDao.queryByRobotId(pn, pageSize, command), pageSize);
    }

    @Override
    public Page<ResourceModel> queryByExecutionId(int pn, int pageSize, int executionId) {
    	ResourceQueryModel command = new ResourceQueryModel();
    	command.setExecutionId(executionId);
        return PageUtil.getPage(resourceDao.countQueryByExecutionId(command) ,pn, resourceDao.queryByExecutionId(pn, pageSize, command), pageSize);
    }


	@Override
	public Page<ResourceModel> query(int pn, int pageSize,
			ResourceQueryModel command) {
        return PageUtil.getPage(resourceDao.countQueryByIndividualId(command) ,pn, resourceDao.queryByIndividualId(pn, pageSize, command), pageSize);
	}

   
}