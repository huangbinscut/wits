package tel.wits.servicematrix.repository.infodao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import tel.wits.common.repository.hibernate.BaseHibernateDao;
import tel.wits.servicematrix.model.infomodel.ChannelModel;
import tel.wits.servicematrix.model.infomodel.ChannelQueryModel;
import tel.wits.servicematrix.repository.infodao.IChannelDao;


@Repository("ChannelDao")
public class ChannelInfoDaoHibernateImpl extends BaseHibernateDao<ChannelModel, Integer> implements IChannelDao {

    private static final String HQL_LIST = "from ChannelModel ";
    private static final String HQL_COUNT = "select count(*) from ChannelModel ";

    private static final String HQL_LIST_QUERY_CONDITION = " where channelName like ?";
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by channelId desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;

    @Override
    public List<ChannelModel> queryByChannelName(int pn, int pageSize, ChannelQueryModel command) {
        return list(HQL_LIST_QUERY_ALL, pn, pageSize, getQueryParam(command));
    }

    @Override
    public int countQueryByChannelName(ChannelQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParam(command)).intValue();
    }
    

    private Object[] getQueryParam(ChannelQueryModel command) {
        //TODO 改成全文索引
        String channelNameLikeStr = "%" + command.getChannelName() + "%";
        return new Object[]{
        		channelNameLikeStr
        };

    }

}
