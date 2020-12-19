package ru.pvn.jdbc.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.pvn.jdbc.domain.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class PersonDaoJdbc implements PersonDao {

    private final JdbcOperations jdbc;

    public PersonDaoJdbc(JdbcOperations jdbcOperations)
    {
        this.jdbc = jdbcOperations;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(*) from records", Integer.class);
    }

    @Override
    public void insert(Person person) {
        jdbc.update("insert into records (id, record, `name`) values (?, ?, ?)", person.getId(), person.getRecord(), person.getName());
    }

    @Override
    public Person getById(long id) {
        return jdbc.queryForObject("select * from records where id = ?", new Object[] {id}, new PersonMapper());
    }

    @Override
    public List<Person> getAll() {
        return jdbc.query("select * from RECORDS", new PersonMapper());
    }


    private static class PersonMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            long record = resultSet.getLong("record");
            String name = resultSet.getString("name");
            return new Person(id, record ,name);
        }
    }
}
