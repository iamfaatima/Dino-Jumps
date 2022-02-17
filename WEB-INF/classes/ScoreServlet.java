import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;


public class ScoreServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        gameDAO p = new gameDAO();
        ArrayList<gameInfo> list;
        String scr = "0";
        String resultt = "0";
        if(request.getParameter("scoreinput1") == null ){
        try{
        Enumeration attributeNames = session.getAttributeNames();
        int i=0;
        while (attributeNames.hasMoreElements() && i==0) {
           String name = attributeNames.nextElement().toString();
           String user = session.getAttribute("uname").toString();
            list = p.SearchGamer(user);
        if(list != null){
            out.println("<html><head><style>body{background-image: url(hs.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><body><center><table border ='1' ><tr><th><b>Gamer's Name</b></th><th><b>Highest Score till now</b></th>");
                for(int j=0; j<list.size(); j++)
                {
                    out.println("<tr><td>"+list.get(j).username+"</td>" +
                    "<td>"+list.get(j).score+"</td></tr>");  
                }
                out.println(" </table></center></body> </html>");
        }
        else{
           out.print("<html><head><style>body{background-image: url(error.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><center><body border='1'><h2>No user exists with a high score</h2>");
        }
        
        i++;
         }

       }
       catch(Exception e){
           out.print("<html><head><style>body{background-image: url(error.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><center><body border='1'><h2>Fraud user alert. You are trying to access a page that requires login/signup</h2>");
        }
        }
        else{
        scr = request.getParameter("scoreinput1");

        try{
        Enumeration attributeNames = session.getAttributeNames();
        int j=0;
        while (attributeNames.hasMoreElements() && j==0) {
           String name = attributeNames.nextElement().toString();
           String user = session.getAttribute("uname").toString();
            gameDAO pp = new gameDAO();
            gameDAO ppp = new gameDAO();
            ArrayList<gameInfo> list2;
            list2 = ppp.SearchGamer(user);
            for(int k=0; k<list2.size(); k++)
            {
            resultt = list2.get(k).score;
            }
        if(Integer.parseInt(scr) >= Integer.parseInt(resultt)){
            list2 = pp.Score(user, scr);
        if(list2 != null){
            out.println("<html><style>body{background-image: url(go.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head>");
              out.println("<html><center><body><h3> Highest Score: " + scr + "</h3></body></html>");
            out.println("<html><body><a href='score.jsp'>Visit Home Page!</a></body></center></html>");
        }
        else{
           out.print("<html><head><style>body{background-image: url(error.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><center><body border='1'><h2>No user</h2>");
        }
        }
        
        else{
        list2 = pp.Score(user, resultt);
        if(list2 != null){
             out.println("<html><head><style>body{background-image: url(go.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head>");
              out.println("<html><center><body><h3> Highest Score: " + resultt + "</h3></body></html>");
            out.println("<html><body><a href='score.jsp'>Visit Home Page!</a></body></center></html>");
        }
        else{
           out.print("<html><head><style>body{background-image: url(error.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><center><body border='1'><h2>Fraud user alert. You are trying to access a page that requires login/signup</h2>");
        }

        }
        
    
        j++;
        } //closing while
                }//closing try
                catch(Exception e){
            out.print("<html><head><style>body{background-image: url(error.png);background-repeat: no-repeat;background-size: 100vw 100vh;width: 100%;height: 100vh;}</style></head><center><body border='1'><h2>Fraud user alert. You are trying to access a page that requires login/signup</h2>");
        }
        

       } //closing else 
       
        }    //closing do get    

    } //closing class
