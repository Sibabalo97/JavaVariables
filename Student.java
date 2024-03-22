public class Student {
    private String name;
    private double mathGrade;
    private double scienceGrade;
    private double englishGrade;

    public Student(String name, double mathGrade, double scienceGrade, double englishGrade) {
        this.name = name;
        this.mathGrade = mathGrade;
        this.scienceGrade = scienceGrade;
        this.englishGrade = englishGrade;
    }

    public String getName() {
        return name;
    }

    public double getMathGrade() {
        return mathGrade;
    }

    public double getScienceGrade() {
        return scienceGrade;
    }

    public double getEnglishGrade() {
        return englishGrade;
    }
}
