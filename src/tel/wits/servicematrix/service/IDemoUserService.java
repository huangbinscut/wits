package tel.wits.servicematrix.service;

import tel.wits.common.pagination.Page;
import tel.wits.common.service.IBaseService;
import tel.wits.servicematrix.model.UserModel;
import tel.wits.servicematrix.model.UserQueryModel;

/**
 * User: Zhang Kaitao
 * Date: 12-1-4 上午10:13
 * Version: 1.0
 */
public interface IDemoUserService extends IBaseService<UserModel, Integer> {

    Page<UserModel> query(int pn, int pageSize, UserQueryModel command);
}
