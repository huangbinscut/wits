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
import tel.wits.servicematrix.model.infomodel.ChannelModel;
import tel.wits.servicematrix.model.infomodel.ChannelQueryModel;
import tel.wits.servicematrix.repository.infodao.IChannelDao;
import tel.wits.servicematrix.service.IChannelService;


@Service("ChannelService")
public class ChannelServiceImpl extends BaseService<ChannelModel, Integer> implements IChannelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelServiceImpl.class);

    private IChannelDao channelDao;

    @Autowired
    @Qualifier("ChannelDao")
    @Override
    public void setBaseDao(IBaseDao<ChannelModel, Integer> channelDao) {
        this.baseDao = channelDao;
        this.channelDao = (IChannelDao) channelDao;
    }
    


    @Override
    public Page<ChannelModel> queryByChannelName(int pn, int pageSize, String channelName) {
    	ChannelQueryModel command = new ChannelQueryModel();
    	command.setChannelName(channelName);
        return PageUtil.getPage(channelDao.countQueryByChannelName(command) ,pn, channelDao.queryByChannelName(pn, pageSize, command), pageSize);
    }

   
}