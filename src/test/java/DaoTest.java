import dao.Dao;
import dao.UserMySql;
import entities.User;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class DaoTest {
    Dao dao = new UserMySql();
    private User u = new User(1,"Name", 1);

    @BeforeEach
    void setUp() throws Exception{
        dao.transaction();
        dao.insert(u);
    }

    @AfterEach
    void after() throws Exception{
//        dao.rollback();
    }

    @Test
    void getAll(){
        assertTrue(dao.getAll().size() > 0);
    }

    @Test
    void getById(){
        User u1 = (User)dao.getById(u.getId());

        assertEquals(u.getName(), u1.getName());
        assertEquals(u.getAge(), u1.getAge());
    }

    @Test
    void insert(){
        User testuser = new User("TestInsert", 1);

        dao.insert(testuser);
        User u1 = (User)dao.getById(testuser.getId());
        assertEquals(testuser.getAge(), u1.getAge());
        dao.delete(testuser);
    }

    @Test
    void delete(){
        dao.delete(u);
        assertNull(dao.getById(u.getId()));
//        Assert.assertEquals(0, dao.getAll().size());
    }

    @Test
    void update(){
        String newName = "UPDATED";
        u.setName(newName);

        dao.update(u);
        User updateUser = (User)dao.getById(u.getId());
        Assert.assertEquals(newName, updateUser.getName());
    }

//    @Test
//    void truncate(){
//        assertTrue(dao.getAll().size() > 0);
//        dao.truncate();
//        assertEquals(0, dao.getAll().size());
//    }
}
