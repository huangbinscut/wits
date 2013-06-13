package tel.wits.servicematrix.repository.infodao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import tel.wits.common.repository.hibernate.BaseHibernateDao;
import tel.wits.servicematrix.model.infomodel.IndividualModel;
import tel.wits.servicematrix.model.infomodel.IndividualQueryModel;
import tel.wits.servicematrix.repository.infodao.IIndividualDao;


@Repository("IndividualDao")
public class IndividualInfoDaoHibernateImpl extends BaseHibernateDao<IndividualModel, Integer> implements IIndividualDao {

    private static final String HQL_LIST = "from IndividualModel ";
    private static final String HQL_COUNT = "select count(*) from IndividualModel ";

    private static final String HQL_LIST_QUERY_CONDITION = " where userName like ?";
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by individualId desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;

    @Override
    public List<IndividualModel> queryByUserName(int pn, int pageSize, IndividualQueryModel command) {
        return list(HQL_LIST_QUERY_ALL, pn, pageSize, getQueryParam(command));
    }

    @Override
    public int countQueryByUserName(IndividualQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParam(command)).intValue();
    }
    

    private Object[] getQueryParam(IndividualQueryModel command) {
        //TODO 改成全文索引
        String userNameLikeStr = " " + command.getUserName() + " ";
        return new Object[]{
        		userNameLikeStr
        };

    }

	@Override
	public IndividualModel uniqueLoginName(String loginName) {
		Criteria criteria = getSession().createCriteria(IndividualModel.class);
		criteria.add(Restrictions.like("loginName", loginName));
		
		return this.unique(criteria);
	}

	@Override
	public IndividualModel uniqueUserName(String userName) {
		Criteria criteria = getSession().createCriteria(IndividualModel.class);
		criteria.add(Restrictions.like("userName", userName));
		
		return this.unique(criteria);
	}
    
}
