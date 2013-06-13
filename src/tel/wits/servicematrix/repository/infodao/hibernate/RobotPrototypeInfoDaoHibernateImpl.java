package tel.wits.servicematrix.repository.infodao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import tel.wits.common.repository.hibernate.BaseHibernateDao;
import tel.wits.servicematrix.model.infomodel.RobotPrototypeModel;
import tel.wits.servicematrix.model.infomodel.RobotPrototypeQueryModel;
import tel.wits.servicematrix.repository.infodao.IRobotPrototypeDao;


@Repository("RobotPrototypeDao")
public class RobotPrototypeInfoDaoHibernateImpl extends BaseHibernateDao<RobotPrototypeModel, Integer> implements IRobotPrototypeDao {

    private static final String HQL_LIST = "from RobotPrototypeModel ";
    private static final String HQL_COUNT = "select count(*) from RobotPrototypeModel ";

    private static final String HQL_LIST_QUERY_CONDITION = " where prototypeName like ?";
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by prototypeId desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;

    @Override
    public List<RobotPrototypeModel> queryByPrototypeName(int pn, int pageSize, RobotPrototypeQueryModel command) {
        return list(HQL_LIST_QUERY_ALL, pn, pageSize, getQueryParam(command));
    }

    @Override
    public int countQueryByPrototypeName(RobotPrototypeQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParam(command)).intValue();
    }
    
    //TODO only support query of prototype name now, need to support all field query
    private Object[] getQueryParam(RobotPrototypeQueryModel command) {
        String prototypeNameLikeStr = "%" + command.getPrototypeName() + "%";
        
        return new Object[]{
        		prototypeNameLikeStr
        };

    }

}
