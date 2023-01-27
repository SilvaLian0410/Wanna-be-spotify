package GroupAssignment2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;  
import java.io.IOException;
import java.io.PrintWriter; 
import java.io.FileWriter;
import java.io.File;                                                            
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Music {
    JFrame frame =new JFrame();

    public void PlayMusic(File file)throws UnsupportedAudioFileException, IOException, LineUnavailableException{

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            AudioFormat format = audioStream.getFormat();
            long audioFileLength = file.length();
            int frameSize = format.getFrameSize();
            float frameRate = format.getFrameRate();
            float durationInSeconds = (audioFileLength / (frameSize * frameRate));
            
            String line = "Duration : " + durationInSeconds;

        JLabel duration = new JLabel(line);
        JLabel SongName = new JLabel(toString());
        JButton playButton=new JButton("Play");
        JButton pauseButton=new JButton("Pause");
        JButton resetButton=new JButton("Reset");
        JButton stopButton=new JButton("Stop");
        JButton upButton=new JButton("Up");
        JButton downButton=new JButton("Down");
        JButton timeButton = new JButton("TimeLine");
        JTextField time = new JTextField();

        ImageIcon img = new ImageIcon("icon.ico");
        
        frame=new JFrame();
        frame.setTitle(toString());
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.green);
        frame.setSize(440,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(img.getImage());
 
        duration.setFont(new Font("Arial", Font.PLAIN, 15));
        duration.setSize(300, 30);
        duration.setLocation(120, 30);
        frame.add(duration);

        SongName.setFont(new Font("Arial", Font.PLAIN, 20));
        SongName.setSize(300, 25);
        SongName.setLocation(90, 12);
        frame.add(SongName);

        playButton.setBounds(30,60,100,30);
        frame.add(playButton);
 
        upButton.setBounds(30,120,100,30);
        frame.add(upButton);

        pauseButton.setBounds(120,60,100,30);
        frame.add(pauseButton);
 
        resetButton.setBounds(210,60,100,30);
        frame.add(resetButton);
 
        stopButton.setBounds(300,60,100,30);
        frame.add(stopButton);

        downButton.setBounds(300,120,100,30);
        frame.add(downButton);

        timeButton.setBounds(160,120,100,29);
        frame.add(timeButton);

        time.setFont(new Font("Arial", Font.PLAIN, 15));
        time.setSize(50, 20);
        time.setLocation(184, 95);
        frame.add(time);

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                do{
                    if(e.getSource() == playButton){
                        play(clip);
                    }else if(e.getSource() == pauseButton){
                        stop(clip);
                    }else if(e.getSource() == resetButton){
                        reset(clip);
                }else if(e.getSource()== downButton){
                    gainControl.setValue(-20.0f);
                    play(clip);
                }else if(e.getSource()== upButton){
                    gainControl.setValue(20.0f);
                    play(clip);
                }else if(e.getSource() == timeButton){
                   int timer = Integer.parseInt(time.getText());
                   int longing = timer * 1000000;
                   clip.setMicrosecondPosition(longing);
                }
                    
                }while (e.getSource() == stopButton);
        }
            
        });

        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                do{
                    if(e.getSource() == playButton){
                        play(clip);
                    }else if(e.getSource() == pauseButton){
                        stop(clip);
                    }else if(e.getSource() == resetButton){
                        reset(clip);
                }else if(e.getSource()== downButton){
                    gainControl.setValue(-20.0f);
                    play(clip);
                }else if(e.getSource()== upButton){
                    gainControl.setValue(20.0f);
                    play(clip);
                }else if(e.getSource() == timeButton){
                   int timer = Integer.parseInt(time.getText());
                   int longing = timer * 1000000;
                   clip.setMicrosecondPosition(longing);
                }
                    
                }while (e.getSource() == stopButton);
        }
            
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                do{
                    if(e.getSource() == playButton){
                        play(clip);
                    }else if(e.getSource() == pauseButton){
                        stop(clip);
                    }else if(e.getSource() == resetButton){
                        reset(clip);
                }else if(e.getSource()== downButton){
                    gainControl.setValue(-20.0f);
                    play(clip);
                }else if(e.getSource()== upButton){
                    gainControl.setValue(20.0f);
                    play(clip);
                }else if(e.getSource() == timeButton){
                   int timer = Integer.parseInt(time.getText());
                   int longing = timer * 1000000;
                   clip.setMicrosecondPosition(longing);
                }
                    
                }while (e.getSource() == stopButton);
        }
            
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             
                if(e.getSource() == stopButton){
                    stop(clip);
                    frame.dispose();
                }
                
            }
        });

        downButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                do{
                    if(e.getSource() == playButton){
                        play(clip);
                    }else if(e.getSource() == pauseButton){
                        stop(clip);
                    }else if(e.getSource() == resetButton){
                        reset(clip);
                }else if(e.getSource()== downButton){
                    gainControl.setValue(-20.0f);
                    play(clip);
                }else if(e.getSource()== upButton){
                    gainControl.setValue(20.0f);
                    play(clip);
                }else if(e.getSource() == timeButton){
                   int timer = Integer.parseInt(time.getText());
                   int longing = timer * 1000000;
                   clip.setMicrosecondPosition(longing);
                }
                    
                }while (e.getSource() == stopButton);
        }
            
        });

        upButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                do{
                    if(e.getSource() == playButton){
                        play(clip);
                    }else if(e.getSource() == pauseButton){
                        stop(clip);
                    }else if(e.getSource() == resetButton){
                        reset(clip);
                }else if(e.getSource()== downButton){
                    gainControl.setValue(-20.0f);
                    play(clip);
                }else if(e.getSource()== upButton){
                    gainControl.setValue(20.0f);
                    play(clip);
                }else if(e.getSource() == timeButton){
                   int timer = Integer.parseInt(time.getText());
                   int longing = timer * 1000000;
                   clip.setMicrosecondPosition(longing);
                }
                    
                }while (e.getSource() == stopButton);
        }
            
        });

        timeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                do{
                    if(e.getSource() == playButton){
                        play(clip);
                    }else if(e.getSource() == pauseButton){
                        stop(clip);
                    }else if(e.getSource() == resetButton){
                        reset(clip);
                }else if(e.getSource()== downButton){
                    gainControl.setValue(-20.0f);
                    play(clip);
                }else if(e.getSource()== upButton){
                    gainControl.setValue(20.0f);
                    play(clip);
                }else if(e.getSource() == timeButton){
                   int timer = Integer.parseInt(time.getText());
                   int longing = timer * 1000000;
                   clip.setMicrosecondPosition(longing);
                }
                    
                }while (e.getSource() == stopButton);
        }
            
        });


    }

    public void play(Clip clip){
        clip.start();
    }

    public void stop(Clip clip){
        clip.stop();
    }

    public void reset(Clip clip){
        clip.setMicrosecondPosition(0);
    }

    public void quit(Clip clip){
        clip.close();
    }

}




