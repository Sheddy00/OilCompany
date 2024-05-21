package hei.school.oilcompany.operation;

import hei.school.oilcompany.db.DBConnection;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AutoCrud<D, ID> implements CrudOperation<D, ID> {
    protected abstract String getTableName();

    protected abstract D mapResultSetToEntity(ResultSet resultSet);

    @Override
    public D getById(ID id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM " + getTableName() + " WHERE id = " + id + ";";

        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return mapResultSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public List<D> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM " + getTableName();
        List<D> listAll = new ArrayList<>();

        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listAll.add(mapResultSetToEntity(resultSet));
            }
            return listAll;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public D save(D toSave) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();

            Class<?> toSaveClass = toSave.getClass();

            Field[] fields = toSaveClass.getDeclaredFields();

            StringBuilder queryBuilder = new StringBuilder("INSERT INTO " + getTableName() + " (");
            for (Field field : fields) {
                queryBuilder.append(field.getName()).append(", ");
            }
            queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length());
            queryBuilder.append(") VALUES ( ");

            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(toSave);
                queryBuilder.append("'" + value + "', ");
            }
            queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length());
            queryBuilder.append(")");

            String insertQuery = queryBuilder.toString();

            statement.executeUpdate(insertQuery);
            return toSave;

        } catch (SQLException | IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);

        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public D deleteById(ID id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "DELETE FROM " + getTableName() + " WHERE id = " + id + ";";

        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return mapResultSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}
