package com.michael.psc.panel;

import com.michael.psc.frame.SlugFrame;
import com.michael.psc.utils.SlugUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalPanel extends JPanel implements ActionListener {

    public JButton restart;
    public JLabel titutlo;
    public JLabel blank;
    public JLabel blank2;
    public JLabel score;

    public SlugFrame parent;

    public FinalPanel(SlugFrame frame) {

        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.parent = frame;

        this.titutlo = new JLabel("", SwingConstants.CENTER);
        this.titutlo.setText("FIN");
        this.titutlo.setForeground(new Color(105, 201, 182));
        this.titutlo.setPreferredSize(new Dimension(3000, 100));
        this.titutlo.setFont(SlugUtils.BOLD_72);

        this.score = new JLabel("", SwingConstants.CENTER);
        this.score.setForeground(new Color(255, 200, 80));
        this.score.setPreferredSize(new Dimension(3000, 100));
        this.score.setFont(SlugUtils.PLAIN_72);


        this.restart = new JButton();
        this.restart.setText("restart");
        this.restart.setBackground(new Color(98, 173, 255));
        this.restart.setForeground(Color.WHITE);
        this.restart.setPreferredSize(new Dimension(200, 100));
        this.restart.setFont(SlugUtils.PLAIN_64);
        this.restart.setFocusPainted(false);
        this.restart.setBorder(BorderFactory.createLineBorder(new Color(100, 114, 206), 4, false));
        this.restart.addActionListener(this);

        this.blank = new JLabel();
        this.blank.setPreferredSize(new Dimension(3000, 200));
        this.blank2 = new JLabel();
        this.blank2.setPreferredSize(new Dimension(3000, 200));

        this.add(this.titutlo);
        this.add(this.blank);
        //this.add(this.score);
        this.add(this.blank2);
        this.add(this.restart);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.parent.getContentPane().remove(this);
        this.parent.getContentPane().add(this.parent.homePanel);

        this.parent.homePanel.revalidate();
        this.parent.homePanel.repaint();

        this.parent.invalidate();
        this.parent.validate();

        this.parent.challengePanel.result.clear();
        this.parent.challengePanel.scores.clear();


    }
}
