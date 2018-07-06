package ru.otus.connection;

import ru.otus.base.UsersDataSet;
import ru.otus.executor.LogExecutor;

import java.sql.SQLException;

public class DBServiceUpdate extends DBServiceConnection {
    private static final String CREATE_TABLE_USER = "create table if not exists user (id bigint(20) not null auto_increment, name varchar(255), age int(3), primary key (id))";
    private static final String INSERT_USER = "insert into user (name) values ('%s')";
    private static final String DELETE_USER = "drop table user";

    @Override
    public void prepareTables() throws SQLException {
        LogExecutor exec = new LogExecutor(getConnection());
        exec.execUpdate(CREATE_TABLE_USER);
        System.out.println("Table created");
    }

    @Override
    public void addUsers(String... names) throws SQLException {
        LogExecutor exec = new LogExecutor(getConnection());
        for (String name : names) {
            int rows = exec.execUpdate(String.format(INSERT_USER, name));
            System.out.println("User added. Rows changed: " + rows);
        }
    }

    @Override
    public void deleteTables() throws SQLException {
        LogExecutor exec = new LogExecutor(getConnection());
        exec.execUpdate(DELETE_USER);
        System.out.println("Table dropped");
    }

    @Override
    public <T extends UsersDataSet> void save(T user) throws SQLException {
        LogExecutor exec = new LogExecutor(getConnection());
        exec.execUpdate(DELETE_USER);
        System.out.println("User added to DB");
    }

    @Override
    public <T extends UsersDataSet> T load(long id, Class<T> clazz) throws SQLException {
        return super.load(id, clazz);
    }

    private <T extends UsersDataSet> String getInsertUserString(T user) {
        return null;
    }
}
