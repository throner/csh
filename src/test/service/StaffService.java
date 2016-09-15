package test.service;

import org.springframework.stereotype.Service;
import test.dao.StaffDao;

import javax.annotation.Resource;

/**
 * Created by chenjiansheng on 2016-4-26.
 */
@Service
public class StaffService {
    @Resource
    private StaffDao staffDao;
    public boolean addStaff(String userId) {
        boolean bResult = false;
        staffDao.addStaff();
        bResult = true;
        return bResult;
    }
}
