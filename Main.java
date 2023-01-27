
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

public class Main {
    public static void main(String[] args)throws UnsupportedAudioFileException, IOException, LineUnavailableException{
           new MusicPlayer();
    }
}

