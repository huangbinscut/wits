package tel.wits.servicematrix.repository.infodao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import tel.wits.common.repository.hibernate.BaseHibernateDao;
import tel.wits.servicematrix.model.infomodel.RobotModel;
import tel.wits.servicematrix.model.infomodel.RobotQueryModel;
import tel.wits.servicematrix.repository.infodao.IRobotDao;


@Repository("RobotDao")
public class RobotInfoDaoHibernateImpl extends BaseHibernateDao<RobotModel, Integer> implements IRobotDao {

    private static final String HQL_LIST = "from RobotModel ";
    private static final String HQL_COUNT = "select count(*) from RobotModel ";
    private static final String HQL_UPDATE = "update RobotModel r ";
    
    private static final String HQL_SET_NOTICE = " set r.exeNew = ? ";

    private static final String HQL_LIST_QUERY_CONDITION = " where individualId = ? ";
    private static final String HQL_UPDATE_QUERY_CONDITION = " where r.individual Id = ? ";
    
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + " order by robotId desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;
    private static final String HQL_UPDATE_NOTICE_ALL = HQL_UPDATE + HQL_SET_NOTICE + HQL_UPDATE_QUERY_CONDITION;

    @Override
    //TODO only support query of individual id now, need to support all field query
    public List<RobotModel> queryByIndividualId(int pn, int pageSize, RobotQueryModel command) {
        return list(HQL_LIST_QUERY_ALL, pn, pageSize, getQueryParam(command));
    }

    @Override
    public int countQueryByIndividualId(RobotQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParam(command)).intValue();
    }
    

    private Object[] getQueryParam(RobotQueryModel command) {
        //TODO 改成全文索引
        String individualIdLikeStr = " " + command.getIndividualId() + " ";
        return new Object[]{
        		individualIdLikeStr
        };

    }

	@Override
	public int clearNotice(int individualId) {
		Object[] paramList = new Object[] {
				0,
				individualId
		};
		
		return execteBulk(HQL_UPDATE_NOTICE_ALL, paramList);
	}

    
}
