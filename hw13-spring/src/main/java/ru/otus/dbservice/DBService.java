package ru.otus.dbservice;

import org.springframework.stereotype.Service;
import ru.otus.datasets.UserDataSet;

import java.util.List;

@Service
public interface DBService {
    String getLocalStatus();

    void save(UserDataSet dataSet);

    UserDataSet read(long id);

    UserDataSet readByName(String name);

    List<UserDataSet> readAll();

    void shutdown();
}
