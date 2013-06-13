package tel.wits.servicematrix.repository.infodao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import tel.wits.common.repository.hibernate.BaseHibernateDao;
import tel.wits.servicematrix.model.infomodel.InterfaceModel;
import tel.wits.servicematrix.model.infomodel.InterfaceQueryModel;
import tel.wits.servicematrix.repository.infodao.IInterfaceDao;


@Repository("InterfaceDao")
public class InterfaceInfoDaoHibernateImpl extends BaseHibernateDao<InterfaceModel, Integer> implements IInterfaceDao {

    private static final String HQL_LIST = "from InterfaceModel ";
    private static final String HQL_COUNT = "select count(*) from InterfaceModel ";

    private static final String HQL_LIST_QUERY_CONDITION = " where channelId = ?";
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by interfaceId desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;

    @Override
    public List<InterfaceModel> queryByChannelId(int pn, int pageSize, InterfaceQueryModel command) {
        return list(HQL_LIST_QUERY_ALL, pn, pageSize, getQueryParam(command));
    }

    @Override
    public int countQueryByChannelId(InterfaceQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParam(command)).intValue();
    }
    

    private Object[] getQueryParam(InterfaceQueryModel command) {
        //TODO 改成全文索引
        String channelIdLikeStr = " " + command.getChannelId() + " ";
        return new Object[]{
        		channelIdLikeStr
        };

    }

}
