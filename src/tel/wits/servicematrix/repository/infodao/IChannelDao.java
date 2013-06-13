package tel.wits.servicematrix.repository.infodao;

import java.util.List;

import tel.wits.common.repository.IBaseDao;
import tel.wits.servicematrix.model.infomodel.ChannelModel;
import tel.wits.servicematrix.model.infomodel.ChannelQueryModel;


public interface IChannelDao extends IBaseDao<ChannelModel, Integer> {
    
    List<ChannelModel> queryByChannelName(int pn, int pageSize, ChannelQueryModel command);

    int countQueryByChannelName(ChannelQueryModel command);

}
