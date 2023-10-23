package bestcommerce.test.modules.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersDao usersDao;

    public List<Users> getAllUsers() {
        return usersDao.findAll();
    }

    public Users getUserById(Long id) {
        return usersDao.findById(id).orElse(null);
    }

    public Users createUser(Users user) {
        return usersDao.save(user);
    }

    public Users updateUser(Long id, Users user) {
        if (usersDao.existsById(id)) {
            user.setId(id);
            return usersDao.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        usersDao.deleteById(id);
    }

    public boolean isEmailAlreadyTaken(String email) {
        Optional<Users> existingUser = usersDao.findByEmail(email);
        return existingUser.isPresent();
    }

    public void registerUser(Users user) {
        if (isEmailAlreadyTaken(user.getEmail())) {
        } else {
            usersDao.save(user);
        }
    }
}
