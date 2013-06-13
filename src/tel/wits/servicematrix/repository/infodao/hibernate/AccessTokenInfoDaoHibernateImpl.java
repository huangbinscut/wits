package tel.wits.servicematrix.repository.infodao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import tel.wits.common.repository.hibernate.BaseHibernateDao;
import tel.wits.servicematrix.model.infomodel.AccessTokenModel;
import tel.wits.servicematrix.model.infomodel.AccessTokenQueryModel;
import tel.wits.servicematrix.repository.infodao.IAccessTokenDao;


@Repository("AccessTokenDao")
public class AccessTokenInfoDaoHibernateImpl extends BaseHibernateDao<AccessTokenModel, Integer> implements IAccessTokenDao {

    private static final String HQL_LIST = "from AccessTokenModel ";
    private static final String HQL_COUNT = "select count(*) from AccessTokenModel ";

    private static final String HQL_LIST_QUERY_CONDITION = " where channelId = ?";
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by tokenId desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;

    @Override
    public List<AccessTokenModel> queryByChannelId(int pn, int pageSize, AccessTokenQueryModel command) {
        return list(HQL_LIST_QUERY_ALL, pn, pageSize, getQueryParam(command));
    }

    @Override
    public List<AccessTokenModel> queryByChannelId(AccessTokenQueryModel command) {
        return list(HQL_LIST_QUERY_ALL, getQueryParam(command));
    }

    @Override
    public int countQueryByChannelId(AccessTokenQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParam(command)).intValue();
    }
    

    //TODO only support query of channel id now, need to support all field query
    private Object[] getQueryParam(AccessTokenQueryModel command) {
        String channelIdLikeStr = " " + command.getChannelId() + " ";
        return new Object[]{
    		channelIdLikeStr
        };

    }

}
