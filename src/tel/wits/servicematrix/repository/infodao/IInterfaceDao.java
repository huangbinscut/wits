package tel.wits.servicematrix.repository.infodao;

import java.util.List;

import tel.wits.common.repository.IBaseDao;
import tel.wits.servicematrix.model.infomodel.InterfaceModel;
import tel.wits.servicematrix.model.infomodel.InterfaceQueryModel;


public interface IInterfaceDao extends IBaseDao<InterfaceModel, Integer> {
    
    List<InterfaceModel> queryByChannelId(int pn, int pageSize, InterfaceQueryModel command);

    int countQueryByChannelId(InterfaceQueryModel command);

}
