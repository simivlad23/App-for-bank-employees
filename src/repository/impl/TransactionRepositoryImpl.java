package repository.impl;

import model.Transaction;
import repository.TransactionRepository;

import java.sql.*;

public class TransactionRepositoryImpl implements TransactionRepository {

    JDBConnectionWrapper jdbConnectionWrapper;

    public TransactionRepositoryImpl(JDBConnectionWrapper jdbConnectionWrapper) {
        this.jdbConnectionWrapper = jdbConnectionWrapper;
    }

    @Override
    public Transaction create(Transaction transaction) {




        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO trans (id_exp, id_dest, money) VALUES(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, transaction.getId_exp());
            preparedStatement.setLong(2, transaction.getId_dest());
            preparedStatement.setInt(3, transaction.getMoney());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                transaction.setId(resultSet.getLong(1));
                return transaction;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;


    }
}
