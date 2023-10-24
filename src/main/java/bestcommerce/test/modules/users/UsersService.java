package bestcommerce.test.modules.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bestcommerce.test.config.EmailAlreadyTakenException;

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
        if (isEmailAlreadyTaken(user)) {
            throw new EmailAlreadyTakenException("O email: " + user.getEmail() + " já possui cadastro !");
        }

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

    public boolean isEmailAlreadyTaken(Users user) {
        if (user.getCostumer() == null) {
            user.getCostumer().setId(null);
        }

        Optional<Users> existingUser = usersDao.findUserByEmailAndCustomerId(user.getEmail(),
                user.getCostumer().getId());

        return existingUser.isPresent();
    }
}
