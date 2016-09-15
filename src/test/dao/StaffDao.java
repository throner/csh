package test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import test.pojo.StaffManagerEntity;

import javax.annotation.Resource;


/**
 * Created by chenjiansheng on 2016-4-28.
 */
@Repository
public class StaffDao {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    //http://127.0.0.1:8080/csh/staff/addStaff.do
    public boolean addStaff(){
        boolean bResult = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        StaffManagerEntity staffManagerEntity = new StaffManagerEntity();
        staffManagerEntity.setStaffId("222");
        staffManagerEntity.setStaffName("张三1111");
        session.update(staffManagerEntity);
        session.getTransaction().commit();
        return bResult;
    }
}
