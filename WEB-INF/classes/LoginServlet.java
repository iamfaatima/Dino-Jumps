import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class LoginServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(365*24*60*60); 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        gameDAO p = new gameDAO();
        ArrayList<gameInfo> list;
        list = p.Login(username, password);
        
        if(list != null){
            // session.setAttribute(username, password);
            session.setAttribute("uname" , username);
            response.sendRedirect("score.jsp");
        }
        else{
            out.print("<html><head><style>body{background-image: url(error.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><center><body border='1'><h2>Username and Password does not match</h2>");
        }
        
    }
}