package chatRoom.dao;

import chatRoom.entity.User;
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


}
