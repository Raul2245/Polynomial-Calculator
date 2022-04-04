package model;

public class Monom implements Comparable{
    private int coefficient;
    private int grade;

    private int status = 0;

    public Monom() {}

    public int getCoefficent() {
        return coefficient;
    }

    public int getGrade() {
        return grade;
    }

    public void setCoefficient(int cf) {
        this.coefficient = cf;
    }

    public void setGrade(int grad) {
        this.grade = grad;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Monom(int cf, int grad) {
        this.coefficient = cf;
        this.grade = grad;
    }

    public Monom(int cf, int grad, int numitor) {
        this.coefficient = cf;
        this.grade = grad;
    }

    @Override
    public String toString() {
        return "Monom{" +
                "coefficient=" + coefficient +
                ", grade=" + grade +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Monom m = new Monom();
        m = (Monom) o;

        if (this.getGrade() < m.getGrade())
            return 1;
        else if (this.getGrade() > m.getGrade())
            return -1;
        return 0;
    }
}
