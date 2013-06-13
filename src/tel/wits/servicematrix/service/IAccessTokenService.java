package tel.wits.servicematrix.service;

import java.util.List;

import tel.wits.common.pagination.Page;
import tel.wits.common.service.IBaseService;
import tel.wits.servicematrix.model.infomodel.AccessTokenModel;


public interface IAccessTokenService extends IBaseService<AccessTokenModel, Integer> {

    Page<AccessTokenModel> queryByChannelId(int pn, int pageSize, int channelId);

    List<AccessTokenModel> queryByChannelId(int channelId);
}
