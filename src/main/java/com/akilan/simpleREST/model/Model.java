package com.akilan.simpleREST.model;

import com.akilan.simpleREST.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Model {
    @Autowired
    Profile pro = new Profile();
    private static String url = "jdbc:mysql://localhost:3306/SimpleRestDB";
    private static String username = "root";
    private static String password = "password";

    // url : http//something.com/users
    public ArrayList<Profile> listOfUsers() {

        ArrayList<Profile> profiles = new ArrayList();
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from main");

            while (rs.next()) {
                Profile pro = new Profile();
                pro.setId(rs.getInt(1));
                pro.setName(rs.getString(2));
                pro.setAge(rs.getString(3));
                pro.setProfession(rs.getString(4));
                pro.setPlace(rs.getString(5));
                profiles.add(pro);
            }
        } catch (Exception e) {
            System.out.println("exception occurred :( -- >  " + e);
        }
        return profiles;
    }
    // url : http//something.com/user/1
    public Profile specificUser(int id) {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from main where id = " + id);
            rs.next();
            if (rs != null) {
                pro.setId(rs.getInt("id"));
                pro.setName(rs.getString("username"));
                pro.setAge(rs.getString("age"));
                pro.setProfession(rs.getString("profession"));
                pro.setPlace(rs.getString("place"));
            }
        } catch (Exception e) {
            System.out.println("some exceptions occurred : " + e);
        }
        return pro;
    }
    // url : http//something.com/upload
    public String uploadUser(Profile pro){
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            System.out.println(pro);

            String sql = "insert into main values("
                    +pro.id+"," +
                    "\""+pro.name+"\","+
                    pro.age+","+
                    "\""+pro.profession+"\","+
                    "\""+pro.place+"\")";
            System.out.println(sql);
            st.executeUpdate(sql);
            System.out.println(sql);
        }
        catch (Exception e){
            System.out.println(e);
            return "{message : something went wrong :( \n cause : "+e+"}";
        }
        return "profile created";
    }
    // url : http//something.com/user/1
    public static String deleteUser(int id){
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            String sql = "Delete from main where id = "+id;
            st.executeUpdate(sql);
            return "user deleted";
        }
        catch (Exception e){
            return "something went wrong";
        }
    }
     // url : http//something.com/user/1
    public static String updateUser(int id,Profile profile){
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            String sql = "Update main set username = \""
                    +profile.name
                    +"\",age = "+profile.age+","
                    +"profession = \""+ profile.profession
                    +"\", place = \""+profile.place
                    +"\" where id = "+id;
            st.executeUpdate(sql);
            return "updated user";
        }
        catch (Exception e){
            System.out.println(e);
            return "something went wrong";
        }
    }
}
