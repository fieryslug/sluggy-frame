package com.michael.psc.panel;

import com.michael.psc.Configs;
import com.michael.psc.frame.SlugFrame;
import com.michael.psc.utils.SlugUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPanel extends JPanel implements ActionListener {

    public SlugFrame parent;

    public JLabel numberDisplayTime;
    public JLabel answerTime;
    public JLabel intervalTime;
    public JLabel enableProgressBar;
    public JLabel enableRandomNum;

    public JTextField fieldDisplayTime;
    public JTextField fieldAnswerTime;
    public JTextField fieldIntervalTime;
    public JButton buttonEnableBar;
    public JButton buttonEnableRandom;

    public JButton back;

    public JLabel blank;
    public JLabel blank1;
    public JLabel blank2;
    public JLabel blank3;
    public JLabel blank4;
    public JLabel blank5;

    public SettingsPanel(SlugFrame frame) {

        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.parent = frame;

        this.numberDisplayTime = new JLabel("", SwingConstants.LEFT);
        this.numberDisplayTime.setText("Number display time(sec)");
        this.numberDisplayTime.setPreferredSize(new Dimension(600, 60));
        this.numberDisplayTime.setForeground(Color.WHITE);
        this.numberDisplayTime.setFont(SlugUtils.PLAIN_48);

        this.answerTime = new JLabel("", SwingConstants.LEFT);
        this.answerTime.setText("Answer time(sec)");
        this.answerTime.setPreferredSize(new Dimension(600, 60));
        this.answerTime.setForeground(Color.WHITE);
        this.answerTime.setFont(SlugUtils.PLAIN_48);

        this.intervalTime = new JLabel("", SwingConstants.LEFT);
        this.intervalTime.setText("Interval(sec)");
        this.intervalTime.setPreferredSize(new Dimension(600, 60));
        this.intervalTime.setForeground(Color.WHITE);
        this.intervalTime.setFont(SlugUtils.PLAIN_48);

        this.enableProgressBar = new JLabel("", SwingConstants.LEFT);
        this.enableProgressBar.setText("Progress bar count down");
        this.enableProgressBar.setPreferredSize(new Dimension(660, 60));
        this.enableProgressBar.setForeground(Color.WHITE);
        this.enableProgressBar.setFont(SlugUtils.PLAIN_48);

        this.enableRandomNum = new JLabel("", SwingConstants.LEFT);
        this.enableRandomNum.setText("Random numbers");
        this.enableRandomNum.setPreferredSize(new Dimension(660, 60));
        this.enableRandomNum.setForeground(Color.WHITE);
        this.enableRandomNum.setFont(SlugUtils.PLAIN_48);

        //----Big slug-----

        this.fieldDisplayTime = new JTextField();
        this.fieldDisplayTime.setText(String.valueOf(Configs.count_down_num));
        this.fieldDisplayTime.setForeground(Color.WHITE);
        this.fieldDisplayTime.setBackground(Color.BLACK);
        this.fieldDisplayTime.setPreferredSize(new Dimension(100, 60));
        this.fieldDisplayTime.setFont(SlugUtils.PLAIN_32);
        this.fieldDisplayTime.setBorder(BorderFactory.createLineBorder(new Color(255, 211, 118), 3, true));

        this.fieldAnswerTime = new JTextField();
        this.fieldAnswerTime.setText(String.valueOf(Configs.count_down_answer));
        this.fieldAnswerTime.setForeground(Color.WHITE);
        this.fieldAnswerTime.setBackground(Color.BLACK);
        this.fieldAnswerTime.setPreferredSize(new Dimension(100, 60));
        this.fieldAnswerTime.setFont(SlugUtils.PLAIN_32);
        this.fieldAnswerTime.setBorder(BorderFactory.createLineBorder(new Color(255, 211, 118), 3, true));

        this.fieldIntervalTime = new JTextField();
        this.fieldIntervalTime.setText(String.valueOf(Configs.count_down_interval));
        this.fieldIntervalTime.setForeground(Color.WHITE);
        this.fieldIntervalTime.setBackground(Color.BLACK);
        this.fieldIntervalTime.setPreferredSize(new Dimension(100, 60));
        this.fieldIntervalTime.setFont(SlugUtils.PLAIN_32);
        this.fieldIntervalTime.setBorder(BorderFactory.createLineBorder(new Color(255, 211, 118), 3, true));

        this.buttonEnableBar = new JButton();
        this.buttonEnableBar.setForeground(Color.WHITE);
        this.buttonEnableBar.setBackground(Color.RED);
        this.buttonEnableBar.setPreferredSize(new Dimension(40, 40));
        this.buttonEnableBar.setFont(SlugUtils.PLAIN_32);
        this.buttonEnableBar.setBorder(BorderFactory.createLineBorder(new Color(101, 250, 255), 3, false));

        this.buttonEnableRandom = new JButton();
        this.buttonEnableRandom.setForeground(Color.WHITE);
        this.buttonEnableRandom.setBackground(Color.RED);
        this.buttonEnableRandom.setPreferredSize(new Dimension(40, 40));
        this.buttonEnableRandom.setFont(SlugUtils.PLAIN_32);
        this.buttonEnableRandom.setBorder(BorderFactory.createLineBorder(new Color(101, 250, 255), 3, false));

        this.back = new JButton();
        this.back.setText("Save changes");
        this.back.setForeground(new Color(220, 220, 220));
        this.back.setBackground(new Color(56, 196, 167));
        this.back.setPreferredSize(new Dimension(350, 70));
        this.back.setFont(SlugUtils.BOLD_48);
        this.back.setFocusPainted(false);
        this.back.setBorder(BorderFactory.createLineBorder(new Color(70, 246, 210), 3, false));


        this.blank = new JLabel();
        this.blank.setPreferredSize(new Dimension(3000, 30));
        this.blank1 = new JLabel();
        this.blank1.setPreferredSize(new Dimension(3000, 30));
        this.blank2 = new JLabel();
        this.blank2.setPreferredSize(new Dimension(3000, 30));
        this.blank3 = new JLabel();
        this.blank3.setPreferredSize(new Dimension(3000, 30));
        this.blank4 = new JLabel();
        this.blank4.setPreferredSize(new Dimension(3000, 30));
        this.blank5 = new JLabel();
        this.blank5.setPreferredSize(new Dimension(3000, 30));

        this.buttonEnableBar.addActionListener(this);
        this.buttonEnableRandom.addActionListener(this);
        this.back.addActionListener(this);



        this.add(this.blank);
        this.add(this.numberDisplayTime);
        this.add(this.fieldDisplayTime);

        this.add(this.blank1);
        this.add(this.answerTime);
        this.add(this.fieldAnswerTime);

        this.add(this.blank5);
        this.add(this.intervalTime);
        this.add(this.fieldIntervalTime);

        this.add(this.blank2);
        this.add(this.enableProgressBar);
        this.add(this.buttonEnableBar);

        this.add(this.blank3);
        this.add(this.enableRandomNum);
        this.add(this.buttonEnableRandom);

        this.add(this.blank4);
        this.add(this.back);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == this.back) {


            double d1 = Configs.count_down_num;
            double d2 = Configs.count_down_answer;
            double d3 = Configs.count_down_interval;

            try {
                d1 = Double.valueOf(this.fieldDisplayTime.getText());
            }
            catch(NumberFormatException exception) {

            }

            try {
                d2 = Double.valueOf(this.fieldAnswerTime.getText());
            }
            catch(NumberFormatException exception) {

            }

            try {
                d3 = Double.valueOf(this.fieldIntervalTime.getText());
            }
            catch(NumberFormatException exception) {

            }

            Configs.count_down_num = d1;
            Configs.count_down_answer = d2;
            Configs.count_down_interval = d3;
            //System.out.print(d3);

            this.parent.getContentPane().remove(this);
            this.parent.getContentPane().add(this.parent.homePanel);

            this.parent.homePanel.revalidate();
            this.parent.homePanel.repaint();

            this.parent.invalidate();
            this.parent.validate();

            //System.out.println("h");

        }

        if(e.getSource() == this.buttonEnableBar) {

            if(Configs.progressBarCountDown) {

                this.buttonEnableBar.setBackground(Color.RED);
                Configs.progressBarCountDown = false;

            }
            else {

                this.buttonEnableBar.setBackground(Color.GREEN);
                Configs.progressBarCountDown = true;

            }

        }

        if(e.getSource() == this.buttonEnableRandom) {

            if(Configs.useRandomNumber) {

                this.buttonEnableRandom.setBackground(Color.RED);
                Configs.useRandomNumber = false;

            }
            else {

                this.buttonEnableRandom.setBackground(Color.GREEN);
                Configs.useRandomNumber = true;

            }
        }
    }
}
