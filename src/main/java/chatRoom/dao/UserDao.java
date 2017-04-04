package chatRoom.dao;

import chatRoom.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 傅華暘 on 2017/4/3.
 */
@Repository
public class UserDao {

    private User user;

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void insert(User user){
        sessionFactory.getCurrentSession().save(user);
    }

    @Transactional
    public void delete(User user){
        sessionFactory.getCurrentSession().delete(user);
    }

    @Transactional
    public List<User> findAllUser(){
        return sessionFactory.getCurrentSession().createQuery(" FROM "+User.class.getName()).list();
    }

    @Transactional
    public User findUserByProvide(String account, char[] password) {
        User user = null;
        try {
            String q = "from User where account = :account and password = :password";
            Query query = sessionFactory.getCurrentSession().createQuery(q);
            query.setParameter("account",account);
            query.setParameter("password",password);
            List<User> users = query.list();
            if(users != null){
                for(User temp : users){
                    if(temp != null){
                        user = temp;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

}
