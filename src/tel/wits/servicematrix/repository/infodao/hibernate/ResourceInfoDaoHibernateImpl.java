package tel.wits.servicematrix.repository.infodao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import tel.wits.common.repository.hibernate.BaseHibernateDao;
import tel.wits.servicematrix.model.infomodel.ResourceModel;
import tel.wits.servicematrix.model.infomodel.ResourceQueryModel;
import tel.wits.servicematrix.repository.infodao.IResourceDao;


@Repository("ResourceDao")
public class ResourceInfoDaoHibernateImpl extends BaseHibernateDao<ResourceModel, Integer> implements IResourceDao {

    private static final String HQL_LIST = "from ResourceModel ";
    private static final String HQL_COUNT = "select count(*) from ResourceModel ";

    private static final String HQL_LIST_QUERY_CONDITION = " where individualId = ?";
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by resourceId desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;

    private static final String HQL_LIST_QUERY_ROBOT_CONDITION = " where robotId = ?";
    private static final String HQL_LIST_QUERY_ROBOT_ALL = HQL_LIST + HQL_LIST_QUERY_ROBOT_CONDITION + "order by resourceId desc";
    private static final String HQL_COUNT_QUERY_ROBOT_ALL = HQL_COUNT + HQL_LIST_QUERY_ROBOT_CONDITION;

    private static final String HQL_LIST_QUERY_EXECUTION_CONDITION = " where executionId = ?";
    private static final String HQL_LIST_QUERY_EXECUTION_ALL = HQL_LIST + HQL_LIST_QUERY_EXECUTION_CONDITION + "order by resourceId desc";
    private static final String HQL_COUNT_QUERY_EXECUTION_ALL = HQL_COUNT + HQL_LIST_QUERY_EXECUTION_CONDITION;

    @Override
    public List<ResourceModel> queryByIndividualId(int pn, int pageSize, ResourceQueryModel command) {
        return list(HQL_LIST_QUERY_ALL, pn, pageSize, getQueryParamByIndividualId(command));
    }

    @Override
    public int countQueryByIndividualId(ResourceQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParamByIndividualId(command)).intValue();
    }
    

    private Object[] getQueryParamByIndividualId(ResourceQueryModel command) {
        //TODO 改成全文索引
        String individualIdLikeStr = " " + command.getIndividualId() + " ";
        return new Object[]{
        		individualIdLikeStr
        };

    }

    @Override
    public List<ResourceModel> queryByRobotId(int pn, int pageSize, ResourceQueryModel command) {
        return list(HQL_LIST_QUERY_ROBOT_ALL, pn, pageSize, getQueryParamByRobotId(command));
    }

    @Override
    public int countQueryByRobotId(ResourceQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ROBOT_ALL, getQueryParamByRobotId(command)).intValue();
    }
    

    private Object[] getQueryParamByRobotId(ResourceQueryModel command) {
        //TODO 改成全文索引
        String robotIdLikeStr = " " + command.getRobotId() + " ";
        return new Object[]{
        		robotIdLikeStr
        };

    }

    @Override
    public List<ResourceModel> queryByExecutionId(int pn, int pageSize, ResourceQueryModel command) {
        return list(HQL_LIST_QUERY_EXECUTION_ALL, pn, pageSize, getQueryParamByExecutionId(command));
    }

    @Override
    public int countQueryByExecutionId(ResourceQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_EXECUTION_ALL, getQueryParamByExecutionId(command)).intValue();
    }
    

    private Object[] getQueryParamByExecutionId(ResourceQueryModel command) {
        //TODO 改成全文索引
        String executionIdLikeStr = " " + command.getExecutionId() + " ";
        return new Object[]{
        		executionIdLikeStr
        };

    }
}
