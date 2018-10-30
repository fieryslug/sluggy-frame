package com.michael.psc;


import com.michael.psc.frame.SlugFrame;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Thread;

public class Main {

    public static void main(String[] args) throws IOException {

        if(!Configs.isNormal) {

            Configs.count_down_num = 10.0;
            Configs.count_down_answer = 25.0;

        }
        SlugFrame frame = new SlugFrame();

    }

}
