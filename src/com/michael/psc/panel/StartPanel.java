package com.michael.psc.panel;

import com.michael.psc.frame.SlugFrame;
import com.michael.psc.utils.SlugUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class StartPanel extends JPanel implements ActionListener, KeyListener {

    public SlugFrame parent;

    public JLabel ready;
    public JButton start;
    private JLabel blank;

    public StartPanel(SlugFrame frame) {

        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.parent = frame;

        this.ready = new JLabel("", SwingConstants.CENTER);
        this.ready.setText("Ready?");
        this.ready.setForeground(new Color(89, 255, 155));
        //this.ready.setBackground(new Color(139, 53, 177));
        this.ready.setPreferredSize(new Dimension(3000, 300));
        this.ready.setFont(SlugUtils.BOLD_72);

        this.blank = new JLabel();
        this.blank.setPreferredSize(new Dimension(3000, 100));

        this.start = new JButton();
        this.start.setText("Go!");
        this.start.setForeground(new Color(255, 255, 255));
        this.start.setBackground(new Color(244, 160, 63));
        this.start.setPreferredSize(new Dimension(150, 80));
        this.start.setFont(SlugUtils.PLAIN_48);
        this.start.addActionListener(this);
        this.start.setBorder(BorderFactory.createLineBorder(new Color(252, 255, 135), 4, false));
        this.start.setFocusPainted(false);

        this.add(this.ready);
        //this.add(this.blank);
        this.add(this.start);

    }

    private void switchPanel() {
        this.parent.getContentPane().remove(this);
        this.parent.getContentPane().add(this.parent.intervalPanel);
        this.parent.intervalPanel.enter();

        this.parent.invalidate();
        this.parent.validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.switchPanel();


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        this.switchPanel();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
