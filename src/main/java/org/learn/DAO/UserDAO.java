package org.learn.DAO;

import org.learn.ConnectionJDBC.SingleConnection;
import org.learn.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {

    private Connection conn;

    //instantiate the connection with db
    public UserDAO() {
        conn = SingleConnection.getConnection();
    }

    //save a user in db
    public void save(User user){
        try {
            String sql = "insert into learning ( name, email) values (?,?)"; //query that save in the learning table
            PreparedStatement insert = conn.prepareStatement(sql);

            //setting respective values

            insert.setString(1, user.getName());
            insert.setString(2, user.getEmail());

            insert.execute();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    public List<User> listAll(){

         List<User> list = new ArrayList<User>();

        try{

            String sql = "select * from learning";//query that get all reg from learning table

            PreparedStatement query = conn.prepareStatement(sql);
            ResultSet result = query.executeQuery();

            while (result.next()){

                User user = new User();
                user.setId(result.getLong("id"));
                user.setName(result.getString("name"));
                user.setEmail(result.getString("email"));

                list.add(user);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);

        }

        return list;
    }

    public List<User> listById(Long id){

         List<User> list = new ArrayList<User>();

        try{

            String sql = "select * from learning where id=?";//query that get all reg from learning table

            PreparedStatement query = conn.prepareStatement(sql);
            query.setLong(1, id);
            ResultSet result = query.executeQuery();

            while (result.next()){

                User user = new User();
                user.setId(result.getLong("id"));
                user.setName(result.getString("name"));
                user.setEmail(result.getString("email"));

                list.add(user);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    //updates a username from db
    public void updateName(Long userId, String newName){

        String sql = "update learning set name = '"+newName+"' where id ="+ userId;

        try {
            PreparedStatement query = conn.prepareStatement(sql);
            query.execute();

            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }


        System.out.println("Name has changed! "+ "id: "+userId+", name: "+newName);

    }

    //delete a user by id
    public void delete(Long id){

        String sql = "delete from learning where id="+id;
        try {
            PreparedStatement query = conn.prepareStatement(sql);
            query.execute();
            conn.commit();
        } catch (SQLException e) {
            try{
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }


    }

}
