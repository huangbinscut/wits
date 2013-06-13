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
import tel.wits.servicematrix.model.infomodel.PermissionModel;
import tel.wits.servicematrix.model.infomodel.PermissionQueryModel;
import tel.wits.servicematrix.repository.infodao.IPermissionDao;
import tel.wits.servicematrix.service.IPermissionService;


@Service("PermissionService")
public class PermissionServiceImpl extends BaseService<PermissionModel, Integer> implements IPermissionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionServiceImpl.class);

    private IPermissionDao permissionDao;

    @Autowired
    @Qualifier("PermissionDao")
    @Override
    public void setBaseDao(IBaseDao<PermissionModel, Integer> permissionDao) {
        this.baseDao = permissionDao;
        this.permissionDao = (IPermissionDao) permissionDao;
    }
    


    @Override
    public Page<PermissionModel> queryByRobotId(int pn, int pageSize, int robotId) {
    	PermissionQueryModel command = new PermissionQueryModel();
    	command.setRobotId(robotId);
        return PageUtil.getPage(permissionDao.countQueryByRobotId(command) ,pn, permissionDao.queryByRobotId(pn, pageSize, command), pageSize);
    }

   
}