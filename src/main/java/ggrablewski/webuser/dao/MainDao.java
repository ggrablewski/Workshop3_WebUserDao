package ggrablewski.webuser.dao;

public class MainDao {

    public static void main(String[] args) {

        User user;

        UserDao.deleteAllUsers();

        user = new User( "tester", "test@test", "test456");
        UserDao.createUser(user);
        user = new User("drugi", "drugi@test", "ryuj6");
        UserDao.createUser(user);
        user = new User("jakiś", "jakis@inny", "ryuk");
        UserDao.createUser(user);
        user = new User("ktoś", "nieten@tam", "fjk");
        UserDao.createUser(user);
        user = new User("statysta", "nowy@tu", "gsfb");
        UserDao.createUser(user);

        System.out.println("User: ktoś");
        user = UserDao.readUser("ktoś");
        System.out.println(user.toString());

        System.out.println("Updated user: jakiś");
        user = UserDao.readUser("jakiś");
        user.setEmail("jakis@inny_nowy");
        UserDao.updateUser(user.getId(), user);
        System.out.println(user.toString());

        user = UserDao.readUser("statysta");
        UserDao.deleteUser(user.getId());

        System.out.println("List of all users (5 created, 1 updated, 1 deleted)");
        User[] allUsers = UserDao.findAllUsers();
        for (User nextUser : allUsers) {
            System.out.println(nextUser.toString());
        }

    }
}
