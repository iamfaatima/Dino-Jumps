import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class SignupServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        session.setMaxInactiveInterval(365*24*60*60); 
        String pswd = request.getParameter("pswd");
        String uname = request.getParameter("uname");
        String cpswd = request.getParameter("cpswd");

        session.setAttribute("uname" , uname);

        String scr = "0";
        gameDAO p = new gameDAO();
        ArrayList<gameInfo> list = null;
        
        if(pswd.equals(cpswd))
        {
        try {
            list = p.Signup(uname, cpswd, scr);
            
        if(list != null){
            session.setAttribute(uname, pswd);
            response.sendRedirect("score.jsp");
             //removed scr as third parameter
            //out.print("<html><center><body><h4>based</h4></body></center></html>");
        }
        else{
            out.print("<html><head><style>body{background-image: url(error.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><center><body border='1'><h2>Couldn't add you in!</h2>");
        }
        
        
        }
        catch (Exception err) {
            // response.sendError(401, "User already exists.");
           // PrintWriter out = response.getWriter();
            out.println("return:" + list);
            out.print("<html><head><style>body{background-image: url(error.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><center><body border='1'><h2>User already exists!</h2>");
            out.close();

        }
        } 
        else{
           out.print("<html><head><style>body{background-image: url(error.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><center><body border='1'><h2>Password and Confirm Password does not match</h2>");
        }
        //String sql = "INSERT INTO login(username, password) VALUES('"+uname+"','"+pswd+"');";
       // ResultSet rs = stm.executeQuery("SELECT * FROM login where username ='" + uname + "'");
       
    
    }
}