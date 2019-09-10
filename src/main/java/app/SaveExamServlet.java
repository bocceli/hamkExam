package app;

import data.Exam;
import data.SaveExam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "SaveExamBocek",
        urlPatterns = {"/save-exam"}
)
public class SaveExamServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String length = request.getParameter("length");
        String type = request.getParameter("type");

        Exam exam = new Exam(name, Integer.parseInt(length), type);

        Exam newExam = SaveExam.saveExam(exam);

        if (newExam != null) {
            out.println("<h1>Added object</h1>");
            out.println(newExam.toString());
        } else {
            out.println("Exam saving problem!");
        }

        out.println("<br>");
        out.println("<a href='/exam-form.html'>Add new Exam</a>");
        out.println("<br>");
        out.println("<a href='/exams'>List of Exams</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}