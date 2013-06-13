package tel.wits.servicematrix.repository.infodao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import tel.wits.common.repository.hibernate.BaseHibernateDao;
import tel.wits.servicematrix.model.infomodel.PermissionModel;
import tel.wits.servicematrix.model.infomodel.PermissionQueryModel;
import tel.wits.servicematrix.repository.infodao.IPermissionDao;


@Repository("PermissionDao")
public class PermissionInfoDaoHibernateImpl extends BaseHibernateDao<PermissionModel, Integer> implements IPermissionDao {

    private static final String HQL_LIST = "from PermissionModel ";
    private static final String HQL_COUNT = "select count(*) from PermissionModel ";

    private static final String HQL_LIST_QUERY_CONDITION = " where robotId = ?";
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by permissionId desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;

    @Override
    public List<PermissionModel> queryByRobotId(int pn, int pageSize, PermissionQueryModel command) {
        return list(HQL_LIST_QUERY_ALL, pn, pageSize, getQueryParam(command));
    }

    @Override
    public int countQueryByRobotId(PermissionQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParam(command)).intValue();
    }
    

    private Object[] getQueryParam(PermissionQueryModel command) {
        //TODO 改成全文索引
        String robotIdLikeStr = " " + command.getRobotId() + " ";
        return new Object[]{
        		robotIdLikeStr
        };

    }

}
