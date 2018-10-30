package com.michael.psc.panel;

import com.michael.psc.Configs;
import com.michael.psc.frame.SlugFrame;
import com.michael.psc.utils.SlugUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ChallengePanel extends JPanel implements ActionListener {

    public int num;
    public JLabel number;
    public JLabel blank;
    public JLabel blank2;
    public JLabel blank3;
    public JLabel count;
    public JLabel bar;
    private Random rand;

    public JTextField field;
    public JButton enter;
    public JLabel count2;
    public JLabel bar2;

    private double timeLeft = Configs.count_down_num;
    private double timeLeft2 = Configs.count_down_answer;

    public java.util.List<String> result;
    public java.util.List<Integer> scores;

    public int ord = 0;

    private Timer timer;
    private Timer timer2;

    private SlugFrame parent;

    public ChallengePanel(SlugFrame frame) {

        super();
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.parent = frame;
        this.rand = new Random();
        this.result = new ArrayList<String>();
        this.scores = new ArrayList<Integer>();

        this.number = new JLabel("", SwingConstants.CENTER);
        this.number.setForeground(Color.WHITE);
        this.number.setPreferredSize(new Dimension(800, 60));
        this.number.setFont(SlugUtils.BOLD_64);

        this.blank = new JLabel();
        this.blank.setPreferredSize(new Dimension(3000, 150));
        this.blank2 = new JLabel();
        this.blank2.setPreferredSize(new Dimension(3000, 60));
        this.blank3 = new JLabel();
        this.blank3.setPreferredSize(new Dimension(3000, 30));

        this.count = new JLabel("", SwingConstants.CENTER);
        this.count.setForeground(Color.WHITE);
        this.count.setPreferredSize(new Dimension(100, 60));
        this.count.setFont(SlugUtils.BOLD_48);

        this.bar = new JLabel();
        this.bar.setBackground(new Color(255, 187, 73));
        this.bar.setOpaque(true);
        this.bar.setPreferredSize(new Dimension(700, 10));

        this.field = new JTextField();
        this.field.setBackground(Color.BLACK);
        this.field.setForeground(Color.WHITE);
        this.field.setPreferredSize(new Dimension(900, 80));
        this.field.setFont(SlugUtils.PLAIN_72);
        this.field.addActionListener(this);
        this.field.setBorder(BorderFactory.createLineBorder(new Color(132, 210, 255), 5, false));

        this.enter = new JButton();
        this.enter.setForeground(Color.WHITE);
        this.enter.setBackground(Color.GREEN);
        this.enter.setText("Enter");
        this.enter.setPreferredSize(new Dimension(200, 80));
        this.enter.setFont(SlugUtils.BOLD_48);
        this.enter.addActionListener(this);
        this.enter.setBorder(BorderFactory.createLineBorder(new Color(203, 255, 189), 4, false));
        this.enter.setFocusPainted(false);

        this.count2 = new JLabel("", SwingConstants.CENTER);
        this.count2.setForeground(Color.WHITE);
        this.count2.setPreferredSize(new Dimension(100, 60));
        this.count2.setFont(SlugUtils.BOLD_48);

        this.bar2 = new JLabel();
        this.bar2.setBackground(new Color(255, 187, 73));
        this.bar2.setOpaque(true);
        this.bar2.setPreferredSize(new Dimension(700, 10));

        this.timer = new Timer(100, this);
        this.timer2 = new Timer(100, this);

    }

    public void reInit() {

        this.timeLeft = Configs.count_down_num;
        this.timeLeft2 = Configs.count_down_answer;

        if(this.ord == 0)
            this.number.setText(String.format("%06d", rand.nextInt(1000000)));

        else {

            if(Configs.useRandomNumber) {

                int digits = Configs.DIGITS[this.ord - 1];
                String str = "";
                for(int i=0; i<digits; ++i) {
                    str = str + String.valueOf(this.rand.nextInt(10));
                }
                this.number.setText(str);

            }
            else {
                if(Configs.isNormal)
                    this.number.setText(Configs.NUMBERS[this.ord - 1]);
                else
                    this.number.setText(Configs.NUMBERS1[this.ord - 1]);
            }
        }

        this.removeAll();

        this.add(this.blank);
        this.add(this.number);
        this.add(this.blank2);

        if(Configs.progressBarCountDown)
            this.add(this.bar);
        else
            this.add(this.count);

        this.revalidate();
        this.repaint();
        this.parent.invalidate();
        this.parent.validate();

        this.timer.start();

    }

    public void timesUp() {

        this.timer.stop();

        this.removeAll();
        this.field.setText("");

        this.add(this.blank);
        this.add(this.field);
        this.add(this.blank2);

        if(Configs.progressBarCountDown) {

            this.add(this.bar2);
            this.add(this.blank3);

        }
        else
            this.add(this.count2);

        this.add(this.enter);

        this.field.requestFocus();

        this.revalidate();
        this.repaint();

        this.parent.invalidate();
        this.parent.validate();

        this.timer2.start();

    }

    public void exit() {

        this.ord++;
        this.timer2.stop();

        if(this.ord == 1) {

            this.parent.getContentPane().remove(this);
            this.parent.getContentPane().add(this.parent.startPanel);

            this.parent.startPanel.revalidate();
            this.parent.startPanel.repaint();

            this.parent.invalidate();
            this.parent.validate();

        }
        else {

            this.result.add(this.number.getText() + "|" + this.field.getText());

            if(this.ord < Configs.problems - 3) {
                if (Configs.isNormal)
                    this.scores.add(SlugUtils.getMaxPrefixLength(this.number.getText(), this.field.getText()));
                else
                    this.scores.add(SlugUtils.getMaxSortedPrefixLength(this.number.getText(), this.field.getText()));
            }
            if(this.ord == Configs.problems + 1) {

                this.parent.getContentPane().remove(this);
                this.parent.getContentPane().add(this.parent.finalPanel);

                this.parent.finalPanel.revalidate();
                this.parent.finalPanel.repaint();

                this.parent.invalidate();
                this.parent.validate();


                int tot = 0;

                for(int i=0; i < this.scores.size(); ++i) {

                    System.out.println(String.valueOf(i + 1) + ":");
                    System.out.println("score: " + this.scores.get(i));
                    System.out.println("       " + this.result.get(i));

                    tot += this.scores.get(i);

                }
                Map<String, Object> map = new HashMap<>();

                map.put("mode", Configs.isNormal ? 0 : 1);
                map.put("score", tot);
                map.put("rec", this.result);

                SlugUtils.writeDataFromMap("data.txt", map);

                //this.parent.finalPanel.score.setText(String.valueOf(tot));

            }
            else {

                //this.reInit();
                this.parent.getContentPane().remove(this);
                this.parent.getContentPane().add(this.parent.intervalPanel);

                this.parent.intervalPanel.revalidate();
                this.parent.intervalPanel.repaint();

                this.parent.invalidate();
                this.parent.validate();

                this.parent.intervalPanel.enter();
            }
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == this.timer) {

            this.timeLeft = this.timeLeft - 0.1;

            if(this.timeLeft <= 0.005) {

                this.timesUp();

            }
            else {

                this.count.setText(String.format("%.1f", this.timeLeft));
                this.bar.setPreferredSize(new Dimension((int)(700 * this.timeLeft / Configs.count_down_num), 10));
                this.revalidate();
                //this.repaint();
                //this.parent.invalidate();
                //this.parent.validate();

            }
        }

        if(e.getSource() == this.timer2) {

            this.timeLeft2 = this.timeLeft2 - 0.1;

            if(this.timeLeft2 <= 0.005) {

                this.exit();

            }
            else {

                this.count2.setText(String.format("%.1f", this.timeLeft2));
                this.bar2.setPreferredSize(new Dimension((int)(700 * this.timeLeft2 / Configs.count_down_answer), 10));
                this.revalidate();
                //this.repaint();
                //this.parent.invalidate();
                //this.parent.validate();

            }
        }

        if(e.getSource() == this.enter || e.getSource() == this.field) {

            this.exit();

        }
    }
}
