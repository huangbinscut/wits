package tel.wits.servicematrix.service.impl;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import tel.wits.common.repository.IBaseDao;
import tel.wits.common.service.impl.BaseService;
import tel.wits.common.pagination.Page;
import tel.wits.common.pagination.PageUtil;
import tel.wits.servicematrix.repository.infodao.IDemoUserDao;
import tel.wits.servicematrix.model.UserModel;
import tel.wits.servicematrix.model.UserQueryModel;
import tel.wits.servicematrix.service.IDemoUserService;

/**
 * User: Zhang Kaitao
 * Date: 12-1-4 上午11:06
 * Version: 1.0
 */

@Service("UserService")
public class DemoUserServiceImpl extends BaseService<UserModel, Integer> implements IDemoUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoUserServiceImpl.class);

    private IDemoUserDao userDao;

    @Autowired
    @Qualifier("UserDao")
    @Override
    public void setBaseDao(IBaseDao<UserModel, Integer> userDao) {
        this.baseDao = userDao;
        this.userDao = (IDemoUserDao) userDao;
    }
    


    @Override
    public Page<UserModel> query(int pn, int pageSize, UserQueryModel command) {
        return PageUtil.getPage(userDao.countQuery(command) ,pn, userDao.query(pn, pageSize, command), pageSize);
    }

   
}