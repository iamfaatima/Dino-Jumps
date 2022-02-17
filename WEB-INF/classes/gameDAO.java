import java.sql.*;
import java.io.* ;
import java.util.* ;
import javax.swing.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class gameDAO
{
    Connection con;
    ArrayList<gameInfo> a ;
    public gameDAO()
    {
        a =new ArrayList<gameInfo>(); 
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1/mydb";
            con = DriverManager.getConnection(url,"root","root");
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
    }
    
    public ArrayList<gameInfo> SearchGamer(String username)
    {
        try
        {
            String query = "select * from login where username=?";
            PreparedStatement st = con.prepareStatement(query);
    
            st.setString(1,username);
            ResultSet i = st.executeQuery();
            


            if (! i.next() )
            {
                return null;
            } 
            else 
            {
                do
                {
                    String uname = i.getString("username");
                    String scr = i.getString("score");
                
                    gameInfo g = new gameInfo(uname, scr);
                    a.add(g);
                } while (i.next());
            }   
          
            con.close();
            st.close(); 
        } 
       
        catch (Exception e)
        {  
            e.printStackTrace();
        }
        return a; 
    }

     public ArrayList<gameInfo> DeleteGamer(String username, String password)
    {
        try
        {
            // DELETE from login where username = '" + uname + "' AND password = '"+ pswd+"'"
            String query = "delete from login where username=? and password=?";
            PreparedStatement st = con.prepareStatement(query);
    
            st.setString(1,username);
            st.setString(2,password);
            int m =  st.executeUpdate();
            ResultSet i = st.executeQuery();
            


            if (! (m>0) )
            {
                return null;
            } 
            else 
            {
                do
                {
                    String uname = i.getString("username");
                
                    gameInfo g = new gameInfo(uname);
                    a.remove(g);
                } while (i.next());
            }   
          
            con.close();
            st.close(); 
        } 
       
        catch (Exception e)
        {  
            e.printStackTrace();
        }
        return a; 
    }
   
   public ArrayList<gameInfo> Signup(String username, String password, String score) throws Exception
    {
            // INSERT INTO login(username, password) VALUES('"+uname+"','"+pswd+"');"
            String query = "INSERT INTO login(username, password, score) VALUES(?,?,0)";
            PreparedStatement st = con.prepareStatement(query);
    
            st.setString(1,username);
            st.setString(2,password);
            
            int num = st.executeUpdate();
            ResultSet i = st.executeQuery();
            
            if (! (num>0) )
            {
                return null;
            } 
            else 
            {
                    String uname = i.getString("username");
                    String pswd = i.getString("password");
                    String scr = i.getString("score");
                    gameInfo g = new gameInfo(uname, pswd,scr);
                    a.add(g);
            }   
          
            con.close();
            st.close(); 

        return a; 
    }


    public ArrayList<gameInfo> Login(String username,String password)
    {
        try
        {
            String query = "select * from login where username=? and password=?";
            PreparedStatement st = con.prepareStatement(query);
    
            st.setString(1,username);
            st.setString(2,password);
            ResultSet i = st.executeQuery();
            


            if (! i.next() )
            {
                return null;
            } 
            else 
            {
                do
                {
                    String uname = i.getString("username");
                    String pswd = i.getString("password");
                
                    gameInfo g = new gameInfo(uname, pswd);
                    a.add(g);
                } while (i.next());
            }   
          
            con.close();
            st.close(); 
        } 
       
        catch (Exception e)
        {  
            e.printStackTrace();
        }
        return a; 
    }

        public ArrayList<gameInfo> Score(String username, String score)
    {
        try
        {
            //UPDATE login SET score = "+ scr +" WHERE username = '" + uname+ "' AND password='"+user+
            String query = "UPDATE login SET score = ? WHERE username = ?";
            PreparedStatement st = con.prepareStatement(query);
    
            st.setString(1,score);
            st.setString(2,username);

            int i = st.executeUpdate();
            ResultSet m = st.executeQuery();
            if (! (i>0) )
            {
                return null;
            } 
            else 
            {
                do
                {
                    String uname = m.getString("username");
                    String scr = m.getString("score");
                
                    gameInfo g = new gameInfo(uname, scr);
                    a.add(g);
                } while (m.next());
            }   
          
            con.close();
            st.close(); 
        } 
       
        catch (Exception e)
        {  
            e.printStackTrace();
        }
        return a; 
    }

    

    
    
}


//     public ArrayList<gameInfo> Score(String username, int score)
//     {
//         try
//         {
//             //UPDATE login SET score = "+ scr +" WHERE username = '" + uname+ "' AND password='"+user+
//             String query = "UPDATE login SET score = ? WHERE username = ?";
//             PreparedStatement st = con.prepareStatement(query);
    
//             st.setInt(1,score);
//             st.setString(2,username);

//             int i = st.executeUpdate();
//             ResultSet m = st.executeQuery();
//             if (! (i>0) )
//             {
//                 return null;
//             } 
//             else 
//             {
//                 do
//                 {
//                     String uname = m.getString("username");
//                     int scr = m.getInt("score");
                
//                     gameInfo g = new gameInfo(uname, scr);
//                     a.add(g);
//                 } while (m.next());
//             }   
          
//             con.close();
//             st.close(); 
//         } 
       
//         catch (Exception e)
//         {  
//             e.printStackTrace();
//         }
//         return a; 
//     }