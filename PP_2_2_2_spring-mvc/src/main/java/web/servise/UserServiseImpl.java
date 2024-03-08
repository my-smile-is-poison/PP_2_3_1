package web.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiseImpl implements UserServise{
    @Autowired
    private UserDao userDao;


    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User showUserById(Long id) {
        return userDao.showUserById(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);

    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);

    }

    @Override
    public void updateUserById(Long id, User user) {
        userDao.updateUserById(id,user);

    }
}