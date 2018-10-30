package com.michael.psc.frame;

import com.michael.psc.Configs;
import com.michael.psc.panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class SlugFrame extends JFrame implements ActionListener {

    public HomePanel homePanel;
    public SettingsPanel settingsPanel;
    public PracticeStartPanel practiceStartPanel;
    public ChallengePanel challengePanel;
    public StartPanel startPanel;
    public IntervalPanel intervalPanel;
    public FinalPanel finalPanel;

    public boolean progressBarCountDown;
    public boolean useRandomNumber;

    public SlugFrame() {

        super("Babosa001");

        if(!Configs.isNormal)
            this.setTitle("Babosa002");

        this.setBounds(500, 50, 1200, 900);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.getContentPane().setBackground(Color.BLACK);

        this.progressBarCountDown = false;
        this.useRandomNumber = false;

        this.homePanel = new HomePanel(this);
        this.settingsPanel = new SettingsPanel(this);
        this.practiceStartPanel = new PracticeStartPanel(this);
        this.challengePanel = new ChallengePanel(this);
        this.intervalPanel = new IntervalPanel(this);
        this.startPanel = new StartPanel(this);

        this.finalPanel = new FinalPanel(this);

        this.getContentPane().add(this.homePanel);

        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }




}
