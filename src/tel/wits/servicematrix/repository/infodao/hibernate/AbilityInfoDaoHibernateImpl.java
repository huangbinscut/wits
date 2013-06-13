package tel.wits.servicematrix.repository.infodao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import tel.wits.common.repository.hibernate.BaseHibernateDao;
import tel.wits.servicematrix.model.infomodel.AbilityModel;
import tel.wits.servicematrix.model.infomodel.AbilityQueryModel;
import tel.wits.servicematrix.repository.infodao.IAbilityDao;


@Repository("AbilityDao")
public class AbilityInfoDaoHibernateImpl extends BaseHibernateDao<AbilityModel, Integer> implements IAbilityDao {

    private static final String HQL_LIST = "from AbilityModel ";
    private static final String HQL_COUNT = "select count(*) from AbilityModel ";

    private static final String HQL_LIST_QUERY_CONDITION = " where prototypeId = ?";
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by abilityId desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;

    @Override
    public List<AbilityModel> queryByPrototypeId(int pn, int pageSize, AbilityQueryModel command) {
        return list(HQL_LIST_QUERY_ALL, pn, pageSize, getQueryParam(command));
    }


    @Override
    public List<AbilityModel> queryByPrototypeId(AbilityQueryModel command) {
        return list(HQL_LIST_QUERY_ALL, getQueryParam(command));
    }

    @Override
    public int countQueryByPrototypeId(AbilityQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParam(command)).intValue();
    }
    

   //TODO only support query of prototype id now, need to support all field query
   private Object[] getQueryParam(AbilityQueryModel command) {
        String prototypeIdLikeStr = " " + command.getPrototypeId() + " ";
        return new Object[]{
        	prototypeIdLikeStr
        };

    }

}
