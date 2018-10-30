package com.michael.psc.panel;

import com.michael.psc.Configs;
import com.michael.psc.frame.SlugFrame;
import com.michael.psc.utils.SlugUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PracticeStartPanel extends JPanel implements ActionListener {

    public JLabel titulo;
    public JLabel count;
    private JLabel blank;
    private JLabel blank1;

    private SlugFrame parent;
    private Timer timer;
    private int timeLeft;

    public PracticeStartPanel(SlugFrame frame) {

        super();
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.parent = frame;

        this.timeLeft = (int)Configs.count_down_start;

        this.titulo = new JLabel("", SwingConstants.CENTER);
        this.titulo.setText("Practice starts in");
        this.titulo.setForeground(new Color(255, 242, 0));
        this.titulo.setPreferredSize(new Dimension(800, 50));
        this.titulo.setFont(SlugUtils.PLAIN_64);

        this.blank = new JLabel();
        this.blank.setPreferredSize(new Dimension(3000, 150));
        this.blank1 = new JLabel();
        this.blank1.setPreferredSize(new Dimension(3000, 60));

        this.count = new JLabel("", SwingConstants.CENTER);
        this.count.setText(String.valueOf(this.timeLeft));
        this.count.setForeground(Color.GREEN);
        this.count.setPreferredSize(new Dimension(80, 80));
        this.count.setFont(SlugUtils.BOLD_72);

        this.timer = new Timer(1000, this);

        this.add(this.blank);
        this.add(this.titulo);
        this.add(this.blank1);
        this.add(this.count);

    }

    public void enter() {

        this.count.setText(String.valueOf(3));
        this.timeLeft = (int)Configs.count_down_start;
        this.timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.timeLeft--;
        if(this.timeLeft <= 0) {

            this.timer.stop();
            this.parent.getContentPane().remove(this);
            this.parent.getContentPane().add(this.parent.challengePanel);

            this.parent.challengePanel.revalidate();
            this.parent.challengePanel.repaint();

            //
            this.parent.invalidate();
            this.parent.revalidate();
            //

            this.parent.challengePanel.ord = 0;

            this.parent.challengePanel.reInit();

            this.invalidate();
            this.validate();

            //System.out.println("Prac");

        }
        else {

            this.count.setText(String.valueOf(this.timeLeft));

        }
    }
}
