import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class SearchServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        String user= request.getParameter("username");
        gameDAO p = new gameDAO();
        ArrayList<gameInfo> list;
        list = p.SearchGamer(user);
        try{
        Enumeration attributeNames = session.getAttributeNames();
        int m =0;
        while (attributeNames.hasMoreElements() && m==0) {
           String name = attributeNames.nextElement().toString();
           String value = session.getAttribute(name).toString();
            int j=0;
        if(list != null && j==0){
            
            out.println("<html><head><style>body{background-image: url(hs.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><body><center><table border ='1' ><tr><th><b>Gamer's Name</b></th><th><b>Highest Score till now</b></th>");
                for(int i=0; i<list.size(); i++)
                {
                    out.println("<tr><td>"+list.get(i).username+"</td>" +
                    "<td>"+list.get(i).score+"</td></tr>");  
                }
                out.println(" </table></center></body> </html>");
                j++;
            // String namee = rs.getString("username");
            // int result = rs.getInt("score");
            // out.println("<html><body><h3> Gamers name: "+ namee + " </br> Highest Score: " + result + "</h3></body></html>");
        }
        else{
            out.print("<html><head><style>body{background-image: url(error.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><center><body border='1'><h2>No such user exists</h2>");
        }
        m++;
        }

       }
       catch(Exception e){
            out.print("<html><head><style>body{background-image: url(error.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><center><body border='1'><h2>Fraud user alert. You are trying to access a page that requires login/signup</h2>");
        }
        out.close();
    }
}