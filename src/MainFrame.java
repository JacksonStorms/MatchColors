package porject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainFrame extends JFrame implements ActionListener{
	static int frames = 1;
	
	
	public MainFrame() {
		try {
	         URL url = this.getClass().getClassLoader().getResource("How_it_Began.wav");
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);     
	         Clip clip = AudioSystem.getClip();
	         clip.open(audioIn);
	         clip.start();
	         clip.loop(1000);
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
		setTitle("Match Color");
		if(frames == 1) {
			add(new Menu());}
		setResizable(false);
		if(frames == 2) {
			add(new MainGame());}
		if(frames == 3) {
			add(new HowTo());}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 700);
		setLocationRelativeTo(null);
        
		setVisible(true);
		Timer timer = new Timer(1000/50, this);
        timer.start();
	}

	public void switchPanel(JPanel panel) {
		removeAll();
		repaint();
		revalidate();
		this.frameInit();
		
		
		add(panel);
		repaint();
		revalidate();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(frames == 2) {
			switchPanel(new MainGame());frames += 100;
			}
		if(frames == 1) {
			switchPanel(new Menu());frames += 100;
			}
		if(frames == 3) {
			switchPanel(new HowTo());frames += 100;
			}
		
			
	}

	

}
