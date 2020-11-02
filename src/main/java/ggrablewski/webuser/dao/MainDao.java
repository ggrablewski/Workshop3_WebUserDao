package ggrablewski.webuser.dao;

public class MainDao {

    public static void main(String[] args) {

        User user = new User();

        UserDao.deleteAllUsers();
        int created = 0, updated = 0, deleted = 0;

        UserDao.createUser(new User("tester", "test@test", "test456")); created++;
        UserDao.createUser(new User("drugi", "drugi@test", "ryuj6")); created++;
        UserDao.createUser(new User("jakiś", "jakis@inny", "ryuk")); created++;
        UserDao.createUser(new User("ktoś", "nieten@tam", "fjk")); created++;
        UserDao.createUser(new User("statysta", "nowy@tu", "gsfb")); created++;
        UserDao.createUser(new User("panizkiosku", "pani@zkiosku", "kiosk123")); created++;
        UserDao.createUser(new User("panzmpk", "torowy@mpk", "fhnu5g")); created++;
        UserDao.createUser(new User("student", "pilnys@uczelnia", "xcvml")); created++;
        UserDao.createUser(new User("zadymiarz", "grozny@klub", "DSKLJe4")); created++;
        UserDao.createUser(new User("iksik", "iks@cicho.sza", "wepr-03")); created++;

        System.out.println("User: ktoś");
        user = UserDao.readUser("ktoś");
        System.out.println(user.toString());

        System.out.println("Updated user: jakiś");
        user = UserDao.readUser("jakiś");
        user.setEmail("jakis@inny_nowy");
        UserDao.updateUser(user.getId(), user); updated++;
        System.out.println(user.toString());

        user = UserDao.readUser("statysta");
        UserDao.deleteUser(user.getId()); deleted++;

        System.out.printf("List of all users (%d created, %d updated, %d deleted)",
                created, updated, deleted);
        User[] allUsers = UserDao.findAllUsers();
        for (User nextUser : allUsers) {
            System.out.println(nextUser.toString());
        }

    }
}
