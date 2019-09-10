package data;

public class Exam {
    private int id;
    private String examName;
    private int examLength;
    private String examType;

    public Exam() {
        super();
    }

    public Exam(String examName, int examLength, String examType) {
        this.examName = examName;
        this.examLength = examLength;
        this.examType = examType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getExamLength() {
        return examLength;
    }

    public void setExamLength(int examLength) {
        this.examLength = examLength;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", examName='" + examName + '\'' +
                ", examLength=" + examLength +
                ", examType='" + examType + '\'' +
                '}';
    }
}
