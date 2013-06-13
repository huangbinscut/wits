package tel.wits.servicematrix.repository.infodao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import tel.wits.common.repository.hibernate.BaseHibernateDao;
import tel.wits.servicematrix.model.infomodel.ExecutionModel;
import tel.wits.servicematrix.model.infomodel.ExecutionQueryModel;
import tel.wits.servicematrix.repository.infodao.IExecutionDao;


@Repository("ExecutionDao")
public class ExecutionInfoDaoHibernateImpl extends BaseHibernateDao<ExecutionModel, Integer> implements IExecutionDao {

    private static final String HQL_LIST = "from ExecutionModel ";
    private static final String HQL_COUNT = "select count(*) from ExecutionModel ";

    private static final String HQL_LIST_QUERY_ROBOT_CONDITION = " where robotId = ?";
    private static final String HQL_LIST_QUERY_ROBOT_ALL = HQL_LIST + HQL_LIST_QUERY_ROBOT_CONDITION + "order by executionId desc";
    private static final String HQL_COUNT_QUERY_ROBOT_ALL = HQL_COUNT + HQL_LIST_QUERY_ROBOT_CONDITION;

    private static final String HQL_LIST_QUERY_INDIVIDUAL_CONDITION = " where individualId = ?";
    private static final String HQL_LIST_QUERY_INDIVIDUAL_ALL = HQL_LIST + HQL_LIST_QUERY_INDIVIDUAL_CONDITION + "order by executionId desc";
    private static final String HQL_COUNT_QUERY_INDIVIDUAL_ALL = HQL_COUNT + HQL_LIST_QUERY_INDIVIDUAL_CONDITION;

    @Override
    public List<ExecutionModel> queryByRobotId(int pn, int pageSize, ExecutionQueryModel command) {
        return list(HQL_LIST_QUERY_ROBOT_ALL, pn, pageSize, getQueryParamByRobotId(command));
    }

    @Override
    public int countQueryByRobotId(ExecutionQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ROBOT_ALL, getQueryParamByRobotId(command)).intValue();
    }
    

    private Object[] getQueryParamByRobotId(ExecutionQueryModel command) {
        //TODO 改成全文索引
        String robotIdLikeStr = " " + command.getRobotId() + " ";
        return new Object[]{
        		robotIdLikeStr
        };

    }


    @Override
    public List<ExecutionModel> queryByIndividualId(int pn, int pageSize, ExecutionQueryModel command) {
        return list(HQL_LIST_QUERY_INDIVIDUAL_ALL, pn, pageSize, getQueryParamByIndividualId(command));
    }

    @Override
    public int countQueryByIndividualId(ExecutionQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_INDIVIDUAL_ALL, getQueryParamByIndividualId(command)).intValue();
    }
    

    private Object[] getQueryParamByIndividualId(ExecutionQueryModel command) {
        //TODO 改成全文索引
        String individualIdLikeStr = " " + command.getIndividualId() + " ";
        return new Object[]{
        		individualIdLikeStr
        };

    }


}
