package daelim.book.rental.kimdaelim.admin;

import daelim.book.rental.kimdaelim.admin.account.AdminAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminAccountService {
    final static public int ADMIN_ACCOUNT_ALREADY_EXISTS = 0;
    final static public int ADMIN_ACCOUNT_CREATE_SUCCESS = 1;
    final static public int ADMIN_ACCOUNT_CREATE_FAIL = -1;

    @Autowired
    private AdminAccountDao adminAccountDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
    
    public AdminAccountVo login(AdminAccountVo adminAccountVo) {
        // dao 연동해서 처리
        AdminAccountVo loginedAdminAccountVo = adminAccountDao.selectAdmin(adminAccountVo);

        if(loginedAdminAccountVo != null) {
            if(bCryptPasswordEncoder.matches(adminAccountVo.getPassword(), loginedAdminAccountVo.getPassword())) {
                return loginedAdminAccountVo;
            }
        }

        return null;
    }

    public int modifyAccount(AdminAccountVo adminAccountVo) {
        // dao -> modify call
        return adminAccountDao.updateAdminAccount(adminAccountVo);
    }

    public AdminAccountVo getLoginedAdminAccountVo(int no) {
        return adminAccountDao.selectAdmin(no);
    }
}