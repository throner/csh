package test.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.hibernate5.HibernateTemplate;
import javax.annotation.Resource;
/**
 * Created by chenjiansheng on 2016-4-28.
 */
public class BaseHibernateDao extends DaoSupport {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    private HibernateTemplate hibernateTemplate;
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    protected Session session = getSession();
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory=sessionFactory;
        this.hibernateTemplate=createHibernateTemplate(sessionFactory);
    }

    public Session getSession() {
        if (this.sessionFactory==null) {
            throw new HibernateException("Session Create Fail,SessionFactory is null!");
        }
        return this.sessionFactory.getCurrentSession();
    }

    protected HibernateTemplate createHibernateTemplate(
            SessionFactory sessionFactory) {
        return new HibernateTemplate(sessionFactory);
    }

    @Override
    protected void checkDaoConfig() throws IllegalArgumentException {
        if (this.hibernateTemplate==null) {
            throw new IllegalArgumentException("'sessionFactory' or 'hibernateTemplate' is required");
        }
    }

    public final void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate=hibernateTemplate;
    }

    public final HibernateTemplate getHibernateTemplate() {
        return this.hibernateTemplate;
    }
}
