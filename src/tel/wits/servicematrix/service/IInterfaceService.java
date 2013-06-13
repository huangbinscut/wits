package tel.wits.servicematrix.service;

import tel.wits.common.pagination.Page;
import tel.wits.common.service.IBaseService;
import tel.wits.servicematrix.model.infomodel.InterfaceModel;


public interface IInterfaceService extends IBaseService<InterfaceModel, Integer> {

    Page<InterfaceModel> queryByChannelId(int pn, int pageSize, int channelId);
}
