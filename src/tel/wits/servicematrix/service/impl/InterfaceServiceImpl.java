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
import tel.wits.servicematrix.model.infomodel.InterfaceModel;
import tel.wits.servicematrix.model.infomodel.InterfaceQueryModel;
import tel.wits.servicematrix.repository.infodao.IInterfaceDao;
import tel.wits.servicematrix.service.IInterfaceService;


@Service("InterfaceService")
public class InterfaceServiceImpl extends BaseService<InterfaceModel, Integer> implements IInterfaceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InterfaceServiceImpl.class);

    private IInterfaceDao interfaceDao;

    @Autowired
    @Qualifier("InterfaceDao")
    @Override
    public void setBaseDao(IBaseDao<InterfaceModel, Integer> interfaceDao) {
        this.baseDao = interfaceDao;
        this.interfaceDao = (IInterfaceDao) interfaceDao;
    }
    


    @Override
    public Page<InterfaceModel> queryByChannelId(int pn, int pageSize, int channelId) {
    	InterfaceQueryModel command = new InterfaceQueryModel();
    	command.setChannelId(channelId);
        return PageUtil.getPage(interfaceDao.countQueryByChannelId(command) ,pn, interfaceDao.queryByChannelId(pn, pageSize, command), pageSize);
    }

   
}