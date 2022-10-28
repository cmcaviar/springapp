package cmcaviar.dao;

import cmcaviar.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDao {
    private List<User> users;
    private static int PEOPLE_COUNT;

    {
        users = new ArrayList<>();
        users.add(new User(++PEOPLE_COUNT, "tom"));
        users.add(new User(++PEOPLE_COUNT, "rod"));
        users.add(new User(++PEOPLE_COUNT, "pol"));
        users.add(new User(++PEOPLE_COUNT, "bob"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(users -> users.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++PEOPLE_COUNT);
        users.add(user);
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
    }

    public void delete(int id) {
        users.removeIf(p -> p.getId() == id);
    }
}
