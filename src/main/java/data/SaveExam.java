package data;

import db.DbConnection;

import java.sql.*;

public class SaveExam {
    public static Exam saveExam(Exam exam) {
        Connection conn = DbConnection.getConnection();

        try {
            if (conn != null) {
                PreparedStatement pstmt=conn.prepareStatement("insert into exams(name, length, type) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1,  exam.getExamName());
                pstmt.setInt(2,  exam.getExamLength());
                pstmt.setString(3,  exam.getExamType());

                pstmt.executeUpdate();

                //getting last inserted id
                ResultSet rs= pstmt.getGeneratedKeys();
                if (rs.next())
                {
                    exam.setId((int) rs.getLong(1));
                }

                conn.close();

                return exam;
            } else {
                System.out.println("No connection!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
