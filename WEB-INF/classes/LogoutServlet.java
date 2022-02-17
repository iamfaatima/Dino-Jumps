import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class LogoutServlet extends HttpServlet {  
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
              
            //request.getRequestDispatcher("index.html").include(request, response);  
              try{
            HttpSession session=request.getSession(false);  

            session.invalidate(); 

            out.print("<html><head><style>body{background-image: url(bye.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><center><body border='1'><h2>You are successfully logged out!</h2>");  

            out.println("<a href='Home.jsp'>Visit Home Page!</a></body></center></html>");

            out.close();  
            }
             catch(Exception e){
                 
            out.print("<html><head><style>body{background-image: url(error.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><center><body border='1'><h2>Your session has been expired!</h2>");
        }
    }  
}  