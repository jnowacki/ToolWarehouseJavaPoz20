package pl.jnowacki.dao;

import pl.jnowacki.model.User;
import pl.jnowacki.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class UserDaoDBImpl implements UserDao {

    private static UserDaoDBImpl instance;

    private UserDaoDBImpl() {
    }

    public static UserDaoDBImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoDBImpl();
        }

        return instance;
    }

    @Override
    public User getUser(String userLogin) {

        String selectSQL = "SELECT * FROM users WHERE username = ?";

        try (Connection dbConnection = DbConnection.getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            preparedStatement.setString(1, userLogin);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Long id = rs.getLong("id");
                String userName = rs.getString("username");
                String password = rs.getString("password");

                return new User(id, userName, password);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
