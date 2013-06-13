package tel.wits.servicematrix.repository.infodao;

import java.util.List;

import tel.wits.common.repository.IBaseDao;
import tel.wits.servicematrix.model.infomodel.AccessTokenModel;
import tel.wits.servicematrix.model.infomodel.AccessTokenQueryModel;


public interface IAccessTokenDao extends IBaseDao<AccessTokenModel, Integer> {
    
    List<AccessTokenModel> queryByChannelId(int pn, int pageSize, AccessTokenQueryModel command);

    List<AccessTokenModel> queryByChannelId(AccessTokenQueryModel command);
    
    int countQueryByChannelId(AccessTokenQueryModel command);

}
