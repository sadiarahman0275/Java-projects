package java1.java2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener{
    private JTextField tf;
    private String operator;
    private double a, b, c;

    public Calculator() {
        setTitle("Calculator");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tf=new JTextField();
        tf.setFont(new Font("Arial",Font.BOLD,15));
        tf.setHorizontalAlignment(SwingConstants.RIGHT);
        add((tf),BorderLayout.NORTH);
        
        JPanel p=new JPanel();
        p.setLayout(new GridLayout(4,4,10,10));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String text:buttons) {
            JButton bu=new JButton(text);
            bu.setFont(new Font("Arial",Font.BOLD,20));
            bu.addActionListener(this);
            p.add(bu);
        }

        add(p,BorderLayout.CENTER);
        
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String command=e.getActionCommand();

        if(command.matches("\\d"))
        { // when we enter the number
            tf.setText(tf.getText() + command);
        }
        else if(command.matches("[+\\-*/]"))
        { // when we enter the operator
            a=Double.parseDouble(tf.getText());
            operator = command;
            tf.setText("");
        }
        else if(command.equals("="))
        {  //this is how the caculator works
            b=Double.parseDouble(tf.getText());
            switch(operator) {
                case "+":
                    c=a+b;
                    break;
                case "-":
                    c=a-b;
                    break;
                case "*":
                    c=a*b;
                    break;
                case "/":
                    if (b!=0) {
                        c=b/a;
                    } else {
                        System.out.println("Exception:devide by zero.");
                        
                    }
                    break;
                default:
                    System.out.println("invalid.");
                    
            }
            tf.setText(String.valueOf(c));

        } 
        else if (command.equals("C"))
        {
            tf.setText("");
            a=b=c=0;
            operator=null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
