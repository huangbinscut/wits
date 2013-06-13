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
import tel.wits.servicematrix.model.infomodel.AccessTokenModel;
import tel.wits.servicematrix.model.infomodel.AccessTokenQueryModel;
import tel.wits.servicematrix.repository.infodao.IAccessTokenDao;
import tel.wits.servicematrix.service.IAccessTokenService;


@Service("AccessTokenService")
public class AccessTokenServiceImpl extends BaseService<AccessTokenModel, Integer> implements IAccessTokenService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessTokenServiceImpl.class);

    private IAccessTokenDao accessTokenDao;

    @Autowired
    @Qualifier("AccessTokenDao")
    @Override
    public void setBaseDao(IBaseDao<AccessTokenModel, Integer> accessTokenDao) {
        this.baseDao = accessTokenDao;
        this.accessTokenDao = (IAccessTokenDao) accessTokenDao;
    }
    


    @Override
    public Page<AccessTokenModel> queryByChannelId(int pn, int pageSize, int channelId) {
    	AccessTokenQueryModel command = new AccessTokenQueryModel();
    	command.setChannelId(channelId);
        return PageUtil.getPage(accessTokenDao.countQueryByChannelId(command) ,pn, accessTokenDao.queryByChannelId(pn, pageSize, command), pageSize);
    }

    @Override
    public List<AccessTokenModel> queryByChannelId(int channelId) {
    	AccessTokenQueryModel command = new AccessTokenQueryModel();
    	command.setChannelId(channelId);
    	return accessTokenDao.queryByChannelId(command);
    }
   
}