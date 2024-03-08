package web.Dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entity;
    @Override
    @Transactional
    public List<User> getUsers() {
        TypedQuery<User> query = entity.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public User showUserById(Long id) {
        return entity.find(User.class,id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entity.persist(user);

    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        entity.remove(showUserById(id));

    }

    @Override
    @Transactional
    public void updateUserById(Long id, User user) {
        User update = showUserById(id);
        update.setName(user.getName());
        update.setLastName(user.getLastName());

    }
}
