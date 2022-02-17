import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class DeleteServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        //session.setMaxInactiveInterval(365*24*60*60); 
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        gameDAO p = new gameDAO();
        ArrayList<gameInfo> list;
        list = p.DeleteGamer(username, password);
        try{
        Enumeration attributeNames = session.getAttributeNames();
     
        while (attributeNames.hasMoreElements()) {
           String name = attributeNames.nextElement().toString();
           String value = session.getAttribute(name).toString();
        
        if(list != null){
            session.invalidate();
            out.println("<html><head><style>body{background-image: url(bye.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><center><body border='1'><h2>YOUR ACCOUNT HAS BEEN DELETED</h2>");  
            out.println("<a href='Home.jsp'>Visit Home Page!</a></body></center></html>");
        }
            else{
            
            out.print("<html><head><style>body{background-image: url(error.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><center><body border='1'><h2>Username and Password does not belong to any account!</h2>");
        }
      
         }
         

       }
       catch(Exception e){
           
            out.print("<html><head><style>body{background-image: url(error.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><center><body border='1'><h2>Fraud user alert. You are trying to access a page that requires login/signup!</h2>");
        }
         out.close();
    }
}