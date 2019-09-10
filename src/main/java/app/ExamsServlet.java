package app;

import data.Exam;
import db.DbConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "ExamsBocek",
        urlPatterns = {"/exams"}
)
public class ExamsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Connection conn = DbConnection.getConnection();

        try {
            if (conn != null) {

                Statement stmt = conn.createStatement();
                //querying for all animals from db
                ResultSet RS = stmt.executeQuery("select * from exams");
                out.println("<h1>List of Exams</h1>");
                out.println("<table>");
                out.println("<tr><td>Id</td><td>Name</td><td>Length</td><td>Type</td></tr>");

                while (RS.next()) {
                    out.println("<tr>");
                    out.println("<td>" + RS.getInt("id") + "</td>");
                    out.println("<td>" + RS.getString("name") + "</td>");
                    out.println("<td>" + RS.getInt("length") + "</td>");
                    out.println("<td>" + RS.getString("type") + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");

                conn.close();

            } else {
                System.out.println("No connection!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("<br>");
        out.println("<a href='/exam-form.html'>Add new Exam</a>");
    }
}