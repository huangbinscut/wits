package tel.wits.servicematrix.service;

import tel.wits.common.pagination.Page;
import tel.wits.common.service.IBaseService;
import tel.wits.servicematrix.model.infomodel.ChannelModel;


public interface IChannelService extends IBaseService<ChannelModel, Integer> {

    Page<ChannelModel> queryByChannelName(int pn, int pageSize, String channelName);
}
