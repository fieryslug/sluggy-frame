package com.michael.psc.panel;

import com.michael.psc.Configs;
import com.michael.psc.frame.SlugFrame;
import com.michael.psc.utils.SlugUtils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel implements ActionListener {

    public SlugFrame parent;

    public JButton buttonStart;
    public JButton buttonSettings;
    public JLabel labelTitle;
    public JLabel labelBlank;
    public JLabel labelBlank2;
    public JLabel labelBlank3;
    public JLabel labelBlank4;

    public JLabel michaelslug;

    public HomePanel(SlugFrame frame) {

        super();
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.parent = frame;

        this.labelTitle = new JLabel("", SwingConstants.CENTER);
        if(Configs.isNormal)
            this.labelTitle.setText("數字短期記憶測驗");
        else
            this.labelTitle.setText("數字短期記憶測驗-排序");
        this.labelTitle.setBackground(Color.BLACK);
        this.labelTitle.setForeground(Color.CYAN);
        this.labelTitle.setPreferredSize(new Dimension(800, 120));
        this.labelTitle.setFont(SlugUtils.BOLD_72);

        this.labelBlank = new JLabel();
        this.labelBlank.setPreferredSize(new Dimension(3000, 100));
        this.labelBlank2 = new JLabel();
        this.labelBlank2.setPreferredSize(new Dimension(3000, 100));
        this.labelBlank3 = new JLabel();
        this.labelBlank3.setPreferredSize(new Dimension(3000, 60));
        this.labelBlank4 = new JLabel();
        this.labelBlank4.setPreferredSize(new Dimension(3000, 80));

        this.buttonStart = new JButton("start");
        this.buttonStart.setText("start");
        this.buttonStart.setBackground(new Color(0, 240, 0));
        this.buttonStart.setForeground(Color.WHITE);
        this.buttonStart.setPreferredSize(new Dimension(300, 80));
        this.buttonStart.setFont(SlugUtils.BOLD_48);
        this.buttonStart.setFocusPainted(false);
        this.buttonStart.addActionListener(this);
        this.buttonStart.setBorder(BorderFactory.createLineBorder(new Color(50, 159, 52), 5, false));

        this.buttonSettings = new JButton();
        this.buttonSettings.setText("options");
        this.buttonSettings.setBackground(Color.GRAY);
        this.buttonSettings.setForeground(Color.WHITE);
        this.buttonSettings.setPreferredSize(new Dimension(200, 60));
        this.buttonSettings.setFont(SlugUtils.ITALIC_32);
        this.buttonSettings.setFocusPainted(false);
        this.buttonSettings.addActionListener(this);
        this.buttonSettings.setBorder(BorderFactory.createLineBorder(new Color(88, 88, 88), 3, false));

        this.michaelslug = new JLabel("", SwingConstants.CENTER);
        this.michaelslug.setText("Michael the slug is taking over the world!");
        this.michaelslug.setBackground(Color.BLACK);
        this.michaelslug.setForeground(new Color(25, 25, 25));
        this.michaelslug.setPreferredSize(new Dimension(1000, 40));
        this.michaelslug.setFont(SlugUtils.ITALIC_32);

        this.add(this.labelBlank);
        this.add(this.labelTitle);
        this.add(this.labelBlank2);
        this.add(this.buttonStart);
        this.add(this.labelBlank3);
        this.add(this.buttonSettings);
        this.add(this.labelBlank4);
        this.add(this.michaelslug);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == this.buttonStart) {

            this.parent.getContentPane().remove(this);
            this.parent.getContentPane().add(this.parent.practiceStartPanel);

            this.parent.practiceStartPanel.revalidate();
            this.parent.practiceStartPanel.repaint();

            this.parent.invalidate();
            this.parent.validate();

            this.parent.practiceStartPanel.enter();



        }
        if(e.getSource() == this.buttonSettings) {

            this.parent.getContentPane().remove(this);
            this.parent.getContentPane().add(this.parent.settingsPanel);

            this.parent.settingsPanel.fieldDisplayTime.setText(String.valueOf(Configs.count_down_num));
            this.parent.settingsPanel.fieldAnswerTime.setText(String.valueOf(Configs.count_down_answer));
            this.parent.settingsPanel.buttonEnableBar.setBackground(Configs.progressBarCountDown ? Color.GREEN : Color.RED);
            this.parent.settingsPanel.buttonEnableRandom.setBackground(Configs.useRandomNumber ? Color.GREEN : Color.RED);

            this.parent.settingsPanel.revalidate();
            this.parent.settingsPanel.repaint();

            this.parent.invalidate();
            this.parent.validate();

        }

    }
}
