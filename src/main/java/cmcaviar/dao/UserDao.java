package cmcaviar.dao;

import cmcaviar.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User show(int id);
    void save(User user);
    void delete(int id);
    void update(int id, User updatedUser);

}
