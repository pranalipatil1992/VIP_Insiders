/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.context.FacesContext;

/**
 *
 * @author pranalipatil
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

    private String userId;
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
  
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    /**
     * Creates a new instance of Login
     */
    
    public String Login() {
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //return to internalError.xhtml
            return ("./HTML/internalError.xhtml");
        }
        
        final String DATABASE_URL = "jdbc:mysql://localhost:3306/vip_insiders";
        Connection connection = null;  
        Statement statement = null;    
        ResultSet resultSet = null;   
        
        
        try
        {
            connection = DriverManager.getConnection(DATABASE_URL,"root", "Patil@123");   
            if(connection != null )
            {
                System.out.println("connection successfull");
            }
            else
            {
                 System.out.println("connection not successfull");
            }
//            statement = connection.createStatement();
//            
//            resultSet = statement.executeQuery("Select * from customers where userID = '" +userId + "' and password = '"+password+ "'");
//            
//            if(resultSet.next())
//            {
//                if(password.equals(resultSet.getString(2)))
//                {
//                    theLoginAccount = new EmailAccount(id, password,resultSet.getString(3));
//                    return "inbox";
//                     
//                }
//                else
//                {
//                    userId = "";
//                    password = "";
//                    return "loginNotOK";    
//                }
//            }
//            else
//            {
//                userId = "";
//                password = "";
//                return "loginNotOK";
//                 
//            }
//            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return ("./HTML/tiernalError.xhtml");
        }
        finally
        {
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
                 
            }
            catch (Exception e)
            {
                e.printStackTrace();    
                return e.getMessage();
            }
        userId = "";
        password = "";
        }
        return "jj";
    }
    public String signOut()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml";
    
    }
}
