package controller;

import model.Monom;
import model.Polynom;

import java.util.ArrayList;
import java.util.Collections;

public class Operation {
    public Polynom addPolynoms(Polynom p, Polynom q){
        Polynom result = new Polynom();

        for (Monom i: p.getMonoms()) {
            for (Monom j : q.getMonoms()) {
                if (i.getGrade() == j.getGrade()) {
                    i.setStatus(2);
                    j.setStatus(2);
                    result.getMonoms().add(new Monom(i.getCoefficent() + j.getCoefficent(), j.getGrade()));
                }
            }
        }

        for (Monom i: p.getMonoms())
            if (i.getStatus() != 2){
                i.setStatus(0);
                result.getMonoms().add(i);
            }

        for (Monom i: q.getMonoms())
            if (i.getStatus() != 2){
                i.setStatus(0);
                result.getMonoms().add(i);
            }

        this.simplify(result);
        Collections.sort(result.getMonoms());

        return result;
    }

    public Polynom subtractPolynoms(Polynom p, Polynom q){
        Polynom result = new Polynom();

        for (Monom i: p.getMonoms()) {
            int foundFlag = 0;
            for (Monom j : q.getMonoms()) {
                if (i.getGrade() == j.getGrade()) {
                    i.setStatus(2);
                    j.setStatus(2);
                    result.getMonoms().add(new Monom(i.getCoefficent() - j.getCoefficent(), i.getGrade()));
                }
            }
        }

        for (Monom i: p.getMonoms())
            if (i.getStatus() != 2){
                i.setStatus(0);
                result.getMonoms().add(i);
            }

        for (Monom i: q.getMonoms())
            if (i.getStatus() != 2){
                i.setStatus(0);
                Monom temp = new Monom(-i.getCoefficent(), i.getGrade());
                result.getMonoms().add(temp);
            }

        simplify(result);
        Collections.sort(result.getMonoms());

        return result;
    }

    public Polynom multiplyPolynoms(Polynom p, Polynom q){
        Polynom result = new Polynom();

        for (Monom i: p.getMonoms())
            for (Monom j: q.getMonoms())
                if (i.getGrade() != 0 && j.getGrade() != 0)
                    result.addMonom(new Monom(i.getCoefficent() * j.getCoefficent(), i.getGrade() + j.getGrade()));
                else
                    result.addMonom(new Monom(i.getCoefficent() * j.getCoefficent(), Math.max(i.getGrade(), j.getGrade())));

        simplify(result);
        Collections.sort(result.getMonoms());

        return result;
    }

    public Polynom dividePolynoms(Polynom p, Polynom q, Polynom restDivide){
        Polynom result = new Polynom();
        Polynom rest = new Polynom();

        if (q.getPolynom() != "")
        {
            for (Monom m: p.getMonoms())
                rest.getMonoms().add(m);
        }

        Polynom tempPolynom = new Polynom();
        while (rest.getPolynom() != "" && rest.getMonoms().size() != 0) {
            if (rest.getMonoms().get(0).getGrade() >= q.getMonoms().get(0).getGrade()) {
                int tempGrade = rest.getMonoms().get(0).getGrade() - q.getMonoms().get(0).getGrade();
                int tempCoefficient = rest.getMonoms().get(0).getCoefficent() / q.getMonoms().get(0).getCoefficent();

                if (tempCoefficient == 0)
                    break;

                Polynom tempPolynomial = new Polynom();
                Polynom tempMonom = new Polynom();

                result.addMonom(new Monom(tempCoefficient, tempGrade));
                tempMonom.addMonom(new Monom(tempCoefficient, tempGrade));
                tempPolynomial = this.multiplyPolynoms(tempMonom, q);
                rest = this.subtractPolynoms(rest, tempPolynomial);
                Collections.sort(rest.getMonoms());
            }
            else
            {
                result.addMonom(new Monom(0, 0));
                break;
            }
        }

        restDivide.setMonoms(rest.getMonoms());
        return result;

    }

    public Polynom derivative(Polynom p){
        Polynom result = new Polynom();

        for (Monom i: p.getMonoms()) {
            if (i.getGrade() != 0) {
                result.getMonoms().add(new Monom(i.getCoefficent() * i.getGrade(), i.getGrade() - 1));
            }
        }

        return result;
    }

    public String integration(Polynom p) {
        Polynom PolynomialResult = new Polynom();

        for (Monom i: p.getMonoms()) {
            PolynomialResult.getMonoms().add(new Monom(i.getCoefficent(), (i.getGrade() + 1)));
        }

        Collections.sort(PolynomialResult.getMonoms());
        String stringResult = integrationToString(PolynomialResult);

        return stringResult;
    }

    public String integrationToString(Polynom p){
        String result = "";
        int flag = 0;
        for (Monom i : p.getMonoms()) {
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
                            result = result + "1/" + i.getGrade() + "x^" + i.getGrade();
                        else if (i.getCoefficent() == -1)
                            result = result + "-1/" + i.getGrade() +"x^" + i.getGrade();
                        else
                            result = result + i.getCoefficent() + "/" + i.getGrade() + "x^" + i.getGrade();
                }
                else if (i.getCoefficent() > 0)
                    if (i.getCoefficent() != 1)
                        result = result + "+" + i.getCoefficent() + "/" + i.getGrade() + "x^" + i.getGrade();
                    else
                        result = result + "+" + "1/" + i.getGrade() + "x^" + i.getGrade();
                else if (i.getCoefficent() < 0)
                    if (i.getCoefficent() != -1)
                        result = result + i.getCoefficent() + "/" + i.getGrade() + "x^" + i.getGrade();
                    else
                        result = result + "-1" + "/" + i.getGrade() + "x^" + i.getGrade();
            }

        }

        if (p.getMonoms().size() == 0)
            result = "0";

        return result;
    }

    public void simplify(Polynom p){
        ArrayList<Monom> copy =  (ArrayList<Monom>)p.getMonoms().clone();

        for (Monom i: p.getMonoms()) {
            i.setStatus(1);
            for (Monom c: copy)
                if (c.equals(i)){
                    c.setStatus(1);
                    break;
                }
            for (Monom j: copy)
                if (j.getStatus() == 0){
                    if (i.getGrade() == j.getGrade()) {
                        i.setCoefficient(i.getCoefficent() + j.getCoefficent());

                        for (Monom m: p.getMonoms())
                            if (m.equals(j)){
                                m.setCoefficient(0);
                                m.setGrade(0);
                            }
                        for (Monom m: copy)
                            if (m.equals(j)){
                                m.setCoefficient(0);
                                m.setGrade(0);
                            }
                    }
                }
        }
        ArrayList<Monom> forRemoval = new ArrayList<Monom>();
        for (Monom m: p.getMonoms())
            if (m.getCoefficent() == 0 && m.getGrade() == 0 || m.getCoefficent() == 0 && m.getGrade() != 0)
                forRemoval.add(m);

        for (Monom m: forRemoval)
            p.getMonoms().remove(m);
    }
}
