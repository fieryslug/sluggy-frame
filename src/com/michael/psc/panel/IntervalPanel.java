package com.michael.psc.panel;

import com.michael.psc.Configs;
import com.michael.psc.frame.SlugFrame;
import com.michael.psc.utils.SlugUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntervalPanel extends JPanel implements ActionListener {

    public SlugFrame parent;

    public JLabel count;
    public JLabel blank;
    public JLabel bar;

    private Timer timer;
    public double timeLeft = Configs.count_down_interval;

    public IntervalPanel(SlugFrame frame) {

        super();
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.parent = frame;

        this.count = new JLabel("", SwingConstants.CENTER);
        this.count.setForeground(Color.WHITE);
        this.count.setPreferredSize(new Dimension(200, 80));
        this.count.setFont(SlugUtils.BOLD_72);
        this.count.setText(String.valueOf(this.timeLeft));

        this.bar = new JLabel();
        this.bar.setBackground(new Color(91, 255, 175));
        this.bar.setOpaque(true);
        this.bar.setPreferredSize(new Dimension(700, 10));

        this.blank = new JLabel();
        this.blank.setPreferredSize(new Dimension(3000, 300));

        this.timer = new Timer(100, this);
    }

    public void enter() {

        this.timeLeft = Configs.count_down_interval;
        this.count.setText(String.valueOf(this.timeLeft));
        this.bar.setPreferredSize(new Dimension(700, 10));
        this.timer.start();

        if(Configs.progressBarCountDown) {
            this.add(this.blank);
            this.add(this.bar);
        }
        else {
            this.add(this.blank);
            this.add(this.count);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.timeLeft = this.timeLeft - 0.1;

        if(this.timeLeft <= 0.05) {

            this.timer.stop();
            this.removeAll();

            this.parent.getContentPane().remove(this);
            this.parent.getContentPane().add(this.parent.challengePanel);
            this.parent.challengePanel.reInit();

            this.parent.invalidate();
            this.parent.validate();


        }
        this.count.setText(String.format("%.1f", this.timeLeft));
        this.bar.setPreferredSize(new Dimension((int)(700 * this.timeLeft / Configs.count_down_interval), 10));
        this.revalidate();

    }
}
