package org.learn;

import org.learn.DAO.UserDAO;
import org.learn.model.User;
import org.junit.Test;

import java.util.List;

public class MainTest {

    UserDAO dao = new UserDAO();

    @Test
    public void saveDB(){

        User user = new User("doido de pedra", "emaildemaluco@maluco.com");
        dao.save(user);
    }

    @Test
    public void listAllDB(){

        List<User> list = dao.listAll();
        for (User user : list){
            System.out.println("----------------");
            System.out.println(user);
            System.out.println("----------------");
        }
    }

    @Test
    public void listByIdDB(){

        List<User> list = dao.listById(3L);
        for (User user : list){
            System.out.println("---------------------------------------------------------------------------");
            System.out.println(user);
            System.out.println("---------------------------------------------------------------------------");
        }
    }

    @Test
    public void updateUserName(){

        dao.updateName(3L, "maluco normal");

    };

    @Test
    public void deleteFromDB(){

        dao.delete(3L);

    }

}
