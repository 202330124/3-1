package daelim.book.rental.kimdaelim.admin;

import daelim.book.rental.kimdaelim.admin.account.AdminAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAccountService {
    final static public int ADMIN_ACCOUNT_ALREADY_EXISTS = 0;
    final static public int ADMIN_ACCOUNT_CREATE_SUCCESS = 1;
    final static public int ADMIN_ACCOUNT_CREATE_FAIL = -1;

    @Autowired
    private AdminAccountDao adminAccountDao;

    public int createAccount(AdminAccountVo adminAccountVo) {
        System.out.println("[AdminAccountService] createAccount");

        boolean isExists = adminAccountDao.existsAccount(adminAccountVo.getId());
        if(!isExists) {
            int result = adminAccountDao.insertAccount(adminAccountVo);

            if(result > 0) {
                return ADMIN_ACCOUNT_CREATE_SUCCESS;
            } else {
                return ADMIN_ACCOUNT_CREATE_FAIL;
            }
        } else {
            return ADMIN_ACCOUNT_ALREADY_EXISTS;
        }
    }
}