package ggrablewski.webuser.dao;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {

    public static void createUser(User user) {
        try (Connection conn = DBUtil.getConnection()) {
            DBUtil.update(conn, "INSERT INTO users(username, email, password) VALUES (?, ?, ?);",
                    user.getUserName(),
                    user.getEmail(),
                    hashPassword(user.getPassword()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User readUser(int id) {
        try (Connection conn = DBUtil.getConnection()) {
            return DBUtil.query(conn, "SELECT * FROM users WHERE id = ?;", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User readUser(String userName) {
        try (Connection conn = DBUtil.getConnection()) {
            return DBUtil.query(conn, "SELECT * FROM users WHERE username = ?;", userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateUser(int id, User newUser) {
        User currentUser = readUser(id);
        updateUser(currentUser, newUser);
    }

    public static void updateUser(String userName, User newUser) {
        User currentUser = readUser(userName);
        updateUser(currentUser, newUser);
    }

    private static void updateUser(User currentUser, User newUser) {
        try (Connection conn = DBUtil.getConnection()) {
            DBUtil.update(conn, "UPDATE users SET username = ?, email = ?, password = ? WHERE username = ?;",
                    newUser.getUserName(),
                    newUser.getEmail(),
                    hashPassword(newUser.getPassword()),
                    currentUser.getUserName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(int id) {
        try (Connection conn = DBUtil.getConnection()) {
            DBUtil.update(conn, "DELETE FROM users WHERE id = ?;", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAllUsers() {
        try (Connection conn = DBUtil.getConnection()) {
            DBUtil.update(conn, "DELETE FROM users;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User[] findAllUsers() {
        try (Connection conn = DBUtil.getConnection()) {
            User[] allUsers = DBUtil.queryList(conn, "SELECT * FROM users;");
            return allUsers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}