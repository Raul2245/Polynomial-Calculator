package view;

import controller.Operation;
import model.Polynom;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class GUI extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField firstPolynom;
    private JTextField secondPolynom;
    Operation op = new Operation();

    public static void main(String[] args) {
        try {
            GUI dialog = new GUI();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GUI() {
        setTitle("Polynomial Calculator");
        setBounds(100, 100, 553, 364);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        firstPolynom = new JTextField();
        firstPolynom.setBounds(112, 24, 417, 19);
        contentPanel.add(firstPolynom);
        firstPolynom.setColumns(10);

        JLabel firstPolynomLabel = new JLabel("First Polynom");
        firstPolynomLabel.setBounds(10, 27, 105, 13);
        contentPanel.add(firstPolynomLabel);

        secondPolynom = new JTextField();
        secondPolynom.setBounds(112, 53, 417, 19);
        contentPanel.add(secondPolynom);
        secondPolynom.setColumns(10);

        JLabel secondPolynomLabel = new JLabel("Second Polynom");
        secondPolynomLabel.setBounds(10, 56, 97, 13);
        contentPanel.add(secondPolynomLabel);

        JPanel panel = new JPanel();
        panel.setBounds(10, 82, 273, 135);
        contentPanel.add(panel);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(284, 214, -274, 101);
        contentPanel.add(scrollPane);

        JTextPane resultPane = new JTextPane();
        resultPane.setBounds(10, 240, 273, 77);
        contentPanel.add(resultPane);
        resultPane.setEditable(false);

        JLabel lblNewLabel = new JLabel("Result:");
        lblNewLabel.setBounds(10, 220, 45, 13);
        contentPanel.add(lblNewLabel);

        MouseListener secondPolynomialMouseListener = new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                secondPolynom.setFocusable(true);
                firstPolynom.setFocusable(false);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        };
        MouseListener firstPolynomialMouseListener = new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                secondPolynom.setFocusable(false);
                firstPolynom.setFocusable(true);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        };

        secondPolynom.addMouseListener(secondPolynomialMouseListener);
        firstPolynom.addMouseListener(firstPolynomialMouseListener);

        JButton sevenBttn = new JButton("7");
        sevenBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstPolynom.isFocusable())
                    firstPolynom.setText(firstPolynom.getText() + "7");
                else if (secondPolynom.isFocusable())
                    secondPolynom.setText(secondPolynom.getText() + "7");
            }
        });
        sevenBttn.setBounds(4, 5, 85, 21);
        panel.add(sevenBttn);

        JButton eightBttn = new JButton("8");
        eightBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstPolynom.isFocusable())
                    firstPolynom.setText(firstPolynom.getText() + "8");
                else if (secondPolynom.isFocusable())
                    secondPolynom.setText(secondPolynom.getText() + "8");
            }
        });
        eightBttn.setBounds(94, 5, 85, 21);
        panel.add(eightBttn);

        JButton nineBttn = new JButton("9");
        nineBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstPolynom.isFocusable())
                    firstPolynom.setText(firstPolynom.getText() + "9");
                else if (secondPolynom.isFocusable())
                    secondPolynom.setText(secondPolynom.getText() + "9");
            }
        });
        nineBttn.setBounds(184, 5, 85, 21);
        panel.add(nineBttn);

        JButton fourBttn = new JButton("4");
        fourBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstPolynom.isFocusable())
                    firstPolynom.setText(firstPolynom.getText() + "4");
                else if (secondPolynom.isFocusable())
                    secondPolynom.setText(secondPolynom.getText() + "4");
            }
        });
        fourBttn.setBounds(4, 31, 85, 21);
        panel.add(fourBttn);

        JButton fiveBttn = new JButton("5");
        fiveBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstPolynom.isFocusable())
                    firstPolynom.setText(firstPolynom.getText() + "5");
                else if (secondPolynom.isFocusable())
                    secondPolynom.setText(secondPolynom.getText() + "5");
            }
        });
        fiveBttn.setBounds(94, 31, 85, 21);
        panel.add(fiveBttn);

        JButton sixBttn = new JButton("6");
        sixBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstPolynom.isFocusable())
                    firstPolynom.setText(firstPolynom.getText() + "6");
                else if (secondPolynom.isFocusable())
                    secondPolynom.setText(secondPolynom.getText() + "6");
            }
        });
        sixBttn.setBounds(184, 31, 85, 21);
        panel.add(sixBttn);

        JButton oneBttn = new JButton("1");
        oneBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstPolynom.isFocusable())
                    firstPolynom.setText(firstPolynom.getText() + "1");
                else if (secondPolynom.isFocusable())
                    secondPolynom.setText(secondPolynom.getText() + "1");
            }
        });


        oneBttn.setBounds(4, 57, 86, 21);
        panel.add(oneBttn);

        JButton twoBttn = new JButton("2");
        twoBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstPolynom.isFocusable())
                    firstPolynom.setText(firstPolynom.getText() + "2");
                else if (secondPolynom.isFocusable())
                    secondPolynom.setText(secondPolynom.getText() + "2");
            }
        });
        twoBttn.setBounds(94, 57, 85, 21);
        panel.add(twoBttn);

        JButton threeBttn = new JButton("3");
        threeBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstPolynom.isFocusable())
                    firstPolynom.setText(firstPolynom.getText() + "3");
                else if (secondPolynom.isFocusable())
                    secondPolynom.setText(secondPolynom.getText() + "3");
            }
        });
        threeBttn.setBounds(184, 57, 85, 21);
        panel.add(threeBttn);

        JButton zeroBttn = new JButton("0");
        zeroBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstPolynom.isFocusable())
                    firstPolynom.setText(firstPolynom.getText() + "0");
                else if (secondPolynom.isFocusable())
                    secondPolynom.setText(secondPolynom.getText() + "0");
            }
        });
        zeroBttn.setBounds(93, 83, 85, 21);
        panel.add(zeroBttn);

        JButton plusBttn = new JButton("+");
        plusBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstPolynom.isFocusable())
                    firstPolynom.setText(firstPolynom.getText() + "+");
                else if (secondPolynom.isFocusable())
                    secondPolynom.setText(secondPolynom.getText() + "+");
            }
        });
        plusBttn.setBounds(4, 83, 85, 21);
        panel.add(plusBttn);

        JButton minusBttn = new JButton("-");
        minusBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstPolynom.isFocusable())
                    firstPolynom.setText(firstPolynom.getText() + "-");
                else if (secondPolynom.isFocusable())
                    secondPolynom.setText(secondPolynom.getText() + "-");
            }
        });
        minusBttn.setBounds(184, 83, 85, 21);
        panel.add(minusBttn);

        JButton xBttn = new JButton("X");
        xBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstPolynom.isFocusable())
                    firstPolynom.setText(firstPolynom.getText() + "x");
                else if (secondPolynom.isFocusable())
                    secondPolynom.setText(secondPolynom.getText() + "x");
            }
        });
        xBttn.setBounds(4, 110, 85, 21);
        panel.add(xBttn);

        JButton powerBttn = new JButton("^");
        powerBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstPolynom.isFocusable())
                    firstPolynom.setText(firstPolynom.getText() + "^");
                else if (secondPolynom.isFocusable())
                    secondPolynom.setText(secondPolynom.getText() + "^");
            }
        });
        powerBttn.setBounds(94, 110, 85, 21);
        panel.add(powerBttn);

        JButton eraseBttn = new JButton("Erase");
        eraseBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (firstPolynom.isFocusable()) {
                    if (firstPolynom.getText().length() > 0)
                        firstPolynom.setText(firstPolynom.getText().substring(0, firstPolynom.getText().length() - 1));
                }
                else if (secondPolynom.isFocusable()) {
                    if (secondPolynom.getText().length() > 0)
                        secondPolynom.setText(secondPolynom.getText().substring(0, secondPolynom.getText().length() - 1));
                }
            }
        });
        eraseBttn.setBounds(184, 110, 85, 21);
        panel.add(eraseBttn);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(293, 82, 236, 235);
        contentPanel.add(panel_1);
        panel_1.setLayout(null);

        JButton additionBttn = new JButton("Addition");
        additionBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynom polynom1 = new Polynom(firstPolynom.getText());
                Polynom polynom2 = new Polynom(secondPolynom.getText());

                Polynom result = op.addPolynoms(polynom1, polynom2);

                resultPane.setText(result.toString());
            }
        });
        additionBttn.setBounds(10, 10, 216, 21);
        panel_1.add(additionBttn);

        JButton substractBttn = new JButton("Substract");
        substractBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynom polynom1 = new Polynom(firstPolynom.getText());
                Polynom polynom2 = new Polynom(secondPolynom.getText());

                Polynom result = op.subtractPolynoms(polynom1, polynom2);

                resultPane.setText(result.toString());
            }
        });
        substractBttn.setBounds(10, 41, 216, 21);
        panel_1.add(substractBttn);

        JButton multiplyBttn = new JButton("Multiply");
        multiplyBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynom polynom1 = new Polynom(firstPolynom.getText());
                Polynom polynom2 = new Polynom(secondPolynom.getText());

                Polynom result = op.multiplyPolynoms(polynom1, polynom2);

                resultPane.setText(result.toString());
            }
        });
        multiplyBttn.setBounds(10, 72, 216, 21);
        panel_1.add(multiplyBttn);

        JButton divideBttn = new JButton("Divide");
        divideBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynom polynom1 = new Polynom(firstPolynom.getText());
                Polynom polynom2 = new Polynom(secondPolynom.getText());
                Polynom restDivide = new Polynom();

                Polynom result = op.dividePolynoms(polynom1, polynom2, restDivide);

                resultPane.setText(result.toString() + "\nRest: " + restDivide.toString());
            }
        });
        divideBttn.setBounds(10, 103, 216, 21);
        panel_1.add(divideBttn);

        JButton derivativeBttn = new JButton("Derivative");
        derivativeBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynom polynom1 = new Polynom(firstPolynom.getText());

                Polynom result = op.derivative(polynom1);

                resultPane.setText(result.toString());
            }
        });
        derivativeBttn.setBounds(10, 134, 216, 21);
        panel_1.add(derivativeBttn);

        JButton integralBttn = new JButton("Integral");
        integralBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynom polynom1 = new Polynom(firstPolynom.getText());

                String result = op.integration(polynom1);

                resultPane.setText(result);
            }
        });
        integralBttn.setBounds(10, 165, 216, 21);
        panel_1.add(integralBttn);
    }
}