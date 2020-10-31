package ggrablewski.webuser.dao;

import java.sql.*;
import java.util.Arrays;

public class DBUtil {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/webuserDB?serverTimezone=UTC" +
            "&useSSL=false" +
            "&characterEncoding=UTF8" +
            "&CharSet=UTF8" +
            "&PublicKeyRetrieval=TRUE";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "coderslab";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    public static User query(Connection conn, String query, int id) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User query(Connection conn, String query, String userName) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, userName);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User[] queryList(Connection conn, String query) throws SQLException {
        User[] allUsers = new User[0];
        try (PreparedStatement statement = conn.prepareStatement(query)) {
             ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allUsers = Arrays.copyOf(allUsers, allUsers.length+1);
                allUsers[allUsers.length-1] = new User(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    public static void update(Connection conn, String query) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Connection conn, String query, int id) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Connection conn, String query, String... params) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.executeUpdate();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

}

/*    public static int insertWithKey(Connection conn, String query, String... params) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.executeUpdate();

            // Tu następuje pobranie ustawionego klucza i zwrócenie go
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) return resultSet.getInt(1);
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            return -1;
        }
    }*/