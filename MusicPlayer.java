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
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import java.awt.image.*;

public class MusicPlayer implements ActionListener {

    
    JFrame frame;
    JLabel songNameLabel=new JLabel();
    JButton selectButton=new JButton("Choose");
    JButton addButton=new JButton("Add");
    

    JFileChooser fileChooser;//Creating object of JFileChooser
    File myFile=null;//Creating object of File class
    String filename;
    String filePath;
    MusicPlayer(){
        prepareGUI();
        addActionEvents();
 
    }
    public void prepareGUI(){

        UIDefaults uiDefaults = UIManager.getDefaults();
        uiDefaults.put("activeCaption", new javax.swing.plaf.ColorUIResource(Color.gray));
        uiDefaults.put("activeCaptionText", new javax.swing.plaf.ColorUIResource(Color.white));
        JFrame.setDefaultLookAndFeelDecorated(true);

        ImageIcon img = new ImageIcon("icon.ico");
        
        frame=new JFrame();
        frame.setTitle("Add or Choose");
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.pink);
        frame.setSize(440,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(img.getImage());
 
        selectButton.setBounds(240,65,100,30);
        frame.add(selectButton);

        addButton.setBounds(60,65,100,30);
        frame.add(addButton);
        
    }
    public void addActionEvents(){
        selectButton.addActionListener(this);
        addButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
     
    {
        
        if(e.getSource()==selectButton){

            fileChooser=new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users\\user\\Music\\Music"));
            fileChooser.setDialogTitle("Choose PlayList");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setFileFilter(new FileNameExtensionFilter("wav files","wav"));
            if(fileChooser.showOpenDialog(selectButton)==JFileChooser.APPROVE_OPTION){
                myFile=fileChooser.getSelectedFile();
                filename=fileChooser.getSelectedFile().getName();
                filePath=fileChooser.getSelectedFile().getPath();

                Songs music = new Songs(filename, filePath);

                try {
                    music.setPlayer();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                    
                    e1.printStackTrace();
                }
            }
        }else if(e.getSource() == addButton){
            
            try {
                Desktop.getDesktop().open(new File("C:\\Users\\user\\Music\\Music"));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
 
    }

}