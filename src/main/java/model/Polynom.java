package model;

import controller.Operation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

public class Polynom {
    private String polynom = new String();
    private ArrayList<Monom> monoms = new ArrayList<Monom>();
    Operation op = new Operation();

    public ArrayList<Monom> getMonoms() {
        return monoms;
    }

    public String getPolynom() {
        return polynom;
    }

    public void setPolynom(String polynom) {
        this.polynom = polynom;
    }

    public void setMonoms(ArrayList<Monom> monoms) {
        this.monoms = monoms;
    }

    public void addMonom(Monom m){
        monoms.add(m);
    }

    public Polynom() { }

    public Polynom(String polynom) {
        this.polynom = polynom;
        this.monomyalSplit();
    }

    public void monomyalSplit(){
        String monomPattern = "\\+";
        String[] result = this.polynom.split(monomPattern);
        ArrayList<String> finalResult = new ArrayList<String>();

        monomPattern = "\\-";
        for (String i : result) {
            String[] tempResult = i.split(monomPattern);
            int flag = 0;
            for (String j : tempResult)
                if (tempResult.length > 1) {
                    flag++;
                    if (flag >= 2)
                        finalResult.add("-" + j);
                    else
                        finalResult.add(j);
                } else
                    finalResult.add(j);
        }

        Pattern p = Pattern.compile("(\\-?\\d+)|([a-zA-Z])+|(\\d+)");
        ArrayList<String> tokens = new ArrayList<String>();

        int[] found = new int[20];
        Arrays.fill(found, 0);

        int knt = 0;
        for (String i: finalResult) {
            Matcher m = p.matcher(i);

            while (m.find()) {
                found[knt]++;
            }
            knt++;
        }

        for (int i = 0; i < found.length; i++)
            if (found[i] > 2)
                found[i] = 2;

        int flagFirstElement = 0;
        int count = 0;
        for (String i : finalResult) {
            Matcher m = p.matcher(i);
            Monom mon = new Monom();

            while (m.find()) {
                String token = m.group(1);
                tokens.add(token);
                if (flagFirstElement == 0 && found[count] == 1) {
                    if (token != null) {
                        flagFirstElement++;
                        mon.setCoefficient(Integer.parseInt(token));

                    } else {
                        flagFirstElement++;
                        if (mon.getCoefficent() == 0)
                            if (i.contains("-"))
                                mon.setCoefficient(-1);
                            else
                                mon.setCoefficient(1);
                        if (mon.getGrade() == 0)
                            mon.setGrade(1);
                    }
                } else if (flagFirstElement == 0 && found[count] == 2) {
                    if (token != null) {
                        flagFirstElement++;
                        mon.setCoefficient(Integer.parseInt(token));
                    } else {
                        flagFirstElement++;
                        if (mon.getCoefficent() == 0)
                            if (i.contains("-"))
                                mon.setCoefficient(-1);
                            else
                                mon.setCoefficient(1);
                    }
                } else if (flagFirstElement != 0 && found[count] == 2) {
                    if (token != null) {
                        mon.setGrade(Integer.parseInt(token));
                    } else {
                        if (mon.getGrade() == 0)
                            mon.setGrade(1);
                    }
                }
            }
            count++;
            monoms.add(mon);
            flagFirstElement = 0;
        }
        op.simplify(this);
    }

    public String toString(){
        String result = "";
        int flag = 0;
        for (Monom i : this.monoms) {
            if (i.getGrade() <= 1) {
                if (i.getGrade() == 1) {
                    if (flag == 0) {
                        flag++;
                        if (i.getCoefficent() != 0)
                            if (i.getCoefficent() == 1)
                                result = result + "x";
                            else if (i.getCoefficent() == -1)
                                result = result + "-x";
                            else
                                result = result + i.getCoefficent() + "x";
                    }
                    else if (i.getCoefficent() > 0)
                        if (i.getCoefficent() != 1)
                            result = result + "+" + i.getCoefficent() + "x";
                        else
                            result = result + "+x";
                    else if (i.getCoefficent() < 0)
                        if (i.getCoefficent() != -1)
                            result = result + i.getCoefficent() + "x";
                        else
                            result = result + "-x";
                } else if (i.getGrade() == 0) {
                    if (flag == 0) {
                        flag++;
                        result = result + i.getCoefficent();
                    }
                    else if (i.getCoefficent() > 0)
                        result = result + "+" + i.getCoefficent();
                    else if (i.getCoefficent() < 0)
                        result = result + i.getCoefficent();
                }
            }
            else{
                if (flag == 0) {
                    flag++;
                    if (i.getCoefficent() != 0)
                        if (i.getCoefficent() == 1)
                            result = result + "x^" + i.getGrade();
                        else if (i.getCoefficent() == -1)
                            result = result + "-x^" + i.getGrade();
                        else
                            result = result + i.getCoefficent() + "x^" + i.getGrade();
                }
                else if (i.getCoefficent() > 0)
                    if (i.getCoefficent() != 1)
                        result = result + "+" + i.getCoefficent() + "x^" + i.getGrade();
                    else
                        result = result + "+" + "x^" + i.getGrade();
                else if (i.getCoefficent() < 0)
                    if (i.getCoefficent() != -1)
                        result = result + i.getCoefficent() + "x^" + i.getGrade();
                    else
                        result = result + "-" + "x^" + i.getGrade();
            }

        }

        if (this.monoms.size() == 0)
            result = "0";

        return result;
    }
}


