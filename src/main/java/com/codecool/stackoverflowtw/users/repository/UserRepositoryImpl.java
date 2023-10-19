package com.codecool.stackoverflowtw.users.repository;

import com.codecool.stackoverflowtw.database.service.ConnectDatabase;
import com.codecool.stackoverflowtw.database.service.ConnectDatabaseImpl;
import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.users.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;
@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Logger logger;
    private ConnectDatabase connectDatabase;

    public UserRepositoryImpl(Logger logger, ConnectDatabase connectDatabase) {
        this.logger = logger;
        this.connectDatabase = connectDatabase;
    }

    private Connection getConnection() {
        return connectDatabase.getConnection();
    }


    @Override
    public Set<User> getAll() {
        Set<User> users = new HashSet<>();
        String query = "SELECT * FROM users";

        try (Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);

                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String username = resultSet.getString("username");
                        String password = resultSet.getString("password");
                        String email = resultSet.getString("email");

                        users.add(new User(id, username, password, email));

                        logger.logInfo("Retrieving all the Users was successfully!");
                    }
                    resultSet.close();
                    stmt.close();

            } catch (SQLException e) {
                logger.logError("Error retrieving all the Users " + e.getMessage());
            }

        return users;
    }

    @Override
    public User get(int id) {
        String query = "SELECT * FROM users WHERE id = ?";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setObject(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int userId = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");

                    logger.logInfo("Retrieving Uer was successfully!");

                    return new User(userId, username, password, email);
                }
                resultSet.close();
                preparedStatement.close();
                conn.close();
            }
        } catch (SQLException e) {
            logger.logError("Error retrieving question: " + e.getMessage());
        }
        return null;
    }


    @Override
    public User findByUsername(String name) {
        try {
            Connection conn = getConnection();
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");

                return new User(id, username, password, email);
            }

        }catch (SQLException e){
            logger.logInfo(e.getMessage());
        }

       /* String query = "SELECT * FROM users WHERE username = ?";
        System.out.println(name);
        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setObject(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                System.out.println(resultSet.toString());
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");

                    logger.logInfo("Retrieving Uer was successfully!");

                    return new User(id, username, password, email);
                }
                resultSet.close();
                preparedStatement.close();
                conn.close();
            }
        } catch (SQLException e) {
            logger.logError("Error retrieving question: " + e.getMessage());
        }*/
        return null;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM users WHERE id = ?";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setObject(1, id);
                preparedStatement.executeUpdate();

                logger.logInfo("Question deleted successfully!");
                preparedStatement.close();
                conn.close();
            }
        } catch (SQLException e) {
            logger.logError("Error deleting question: " + e.getMessage());
        }
    }

    @Override
    public void add(String username, String password, String email) {
        String query = "INSERT INTO users(username, password, email) VALUES(?,?,?)";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, email);

                logger.logInfo("Adding a new User was successfully!");
                preparedStatement.close();
                conn.close();
            }
        } catch (SQLException e) {
            logger.logError("Error adding new User: " + e.getMessage());
        }
    }

    @Override
    public void update(int id, String username, String password, String email) {
        String query = "UPDATE users SET username = ?, password = ?, email = ? WHERE id = ?";

        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, email);
                preparedStatement.setInt(4, id);

                logger.logInfo("Updating User was successfully!");
                preparedStatement.close();
                conn.close();
            }
        } catch (SQLException e) {
            logger.logError("Error updating User: " + e.getMessage());
        }
    }
}
