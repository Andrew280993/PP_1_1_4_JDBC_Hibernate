package jm.task.core.jdbc.dao;


import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.Transaction;

import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try (Session session = getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery("CREATE TABLE IF NOT EXISTS usertable " +
                    "(id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
                    "name varchar(45) NOT NULL, " +
                    "lastName varchar(45), " +
                    "age int)").addEntity(User.class).executeUpdate();
            transaction.commit();
        } catch (SessionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery("drop table if exists usertable").addEntity(User.class).executeUpdate();
            transaction.commit();
        } catch (SessionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(new User(name, lastName, age));
            System.out.println("User с именем " + name + " добавлен в базу данных");
            transaction.commit();
        } catch (SessionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = getSessionFactory().openSession()){
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(User.class, id));
        transaction.commit();
        } catch (SessionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> user = null;
        try (Session session = getSessionFactory().openSession()){
            user = session.createCriteria(User.class).list();
        } catch (SessionException e) {
            e.printStackTrace();
        }
            return user;
    }
    @Override
    public void cleanUsersTable() {
        try (Session session = getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery("truncate table usertable").executeUpdate();
            transaction.commit();
        } catch (SessionException e) {
            e.printStackTrace();
        }
    }
}
