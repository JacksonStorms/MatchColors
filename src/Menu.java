package porject;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Menu extends JPanel implements ActionListener,MouseListener,MouseMotionListener {
	private Rectangle play,how,exi;
	private int getIn = 0;
	private Font f1 = new Font("Courier",Font.BOLD,30);
	private BufferedImage bg,btn11,btn12;
	private URL url;
	private AudioInputStream audioIn;
	private Clip clip;
	
	public Menu(){
		
	   
		try {
			bg = ImageIO.read(getClass().getResourceAsStream("/BG-MENU.png"));
			btn11 = ImageIO.read(getClass().getResourceAsStream("/btn11.png"));
			btn12 = ImageIO.read(getClass().getResourceAsStream("/btn12.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		this.setLayout(new BorderLayout());
		setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setFocusable(true);
        play = new Rectangle(210, 250, 130, 50);
        how = new Rectangle(170, 375, 210, 50);
        exi = new Rectangle(210, 500, 130, 50);
       
        
        setFocusable(true);
        addMouseListener(this);
        this.addMouseMotionListener(this);
    
	
		Timer timer = new Timer(1000/50, this);
        timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(bg, 0, 0,550, 700, null);
		if(getIn == 0) {
			g.drawImage(btn11,210, 215, 130, 125,null);
			g.drawImage(btn11,145, 340, 260, 125,null);
			g.drawImage(btn11,210, 465, 130, 125,null);
		}
		if(getIn == 1) {
			g.drawImage(btn11,145, 340, 260, 125,null);
			g.drawImage(btn11,210, 465, 130, 125,null);
			g.drawImage(btn12,210, 215, 130, 125,null);
			
		}
		if(getIn == 2) {
			g.drawImage(btn11,210, 215, 130, 125,null);
			g.drawImage(btn11,210, 465, 130, 125,null);
			g.drawImage(btn12,145, 340, 260, 125,null);
			
		}
		if(getIn == 3) {
			g.drawImage(btn11,210, 215, 130, 125,null);
			g.drawImage(btn11,145, 340, 260, 125,null);
			g.drawImage(btn12,210, 465, 130, 125,null);
			
		}
		g.setColor(Color.BLACK);
		g.setFont(f1);
		g.drawString("Play", 238, 285);
		g.drawString("How To Play", 176, 410);
		g.drawString("Exit", 238, 535);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.print(e.getPoint().getX());
		if ((e.getPoint().getX() < play.getX() + 130) && (e.getPoint().getX() > play.getX())) {
			if((e.getPoint().getY() < play.getY() +50) && (e.getPoint().getY() > play.getY())) {
				this.Pop();
				MainFrame.frames = 2;
			}
		}
		if ((e.getPoint().getY() < how.getY() +50) && (e.getPoint().getY() > how.getY())) {
			if((e.getPoint().getX() < how.getX() + 210) && (e.getPoint().getX() > how.getX())) {
				this.Pop();
				MainFrame.frames = 3;
			}
		}
		if ((e.getPoint().getY() < exi.getY() +50) && (e.getPoint().getY() > exi.getY())) {
			if((e.getPoint().getX() < exi.getX() + 130) && (e.getPoint().getX() > exi.getX())) {
				this.Pop();
				System.exit(0);
			}
		}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if ((e.getPoint().getY() < play.getY() + 50) && (e.getPoint().getY() > play.getY())) {
			if((e.getPoint().getX() < play.getX() + 130) && (e.getPoint().getX() > play.getX())) {
				getIn = 1;
				System.out.println(getIn);
				repaint();
			}
			else {getIn = 0;repaint();}
		}
		else if ((e.getPoint().getY() < how.getY() +50) && (e.getPoint().getY() > how.getY())) {
			if((e.getPoint().getX() < how.getX() + 210) && (e.getPoint().getX() > how.getX())) {
				getIn = 2;
				System.out.println(getIn);
				
				repaint();
			}
			else {getIn = 0;repaint();}
		}
		else if ((e.getPoint().getY() < exi.getY() +50) && (e.getPoint().getY() > exi.getY())) {
			if((e.getPoint().getX() < exi.getX() + 130) && (e.getPoint().getX() > exi.getX())) {
				getIn = 3;
				System.out.println(getIn);
				repaint();
			}
			else {getIn = 0;repaint();}
		}
		else {getIn = 0;repaint();}
	}
	
	public void Pop()
	{
		try {
	        // Open an audio input stream.
	        url = this.getClass().getClassLoader().getResource("Pop.wav");
	        audioIn = AudioSystem.getAudioInputStream(url);
	        // Get a sound clip resource.
	        clip = AudioSystem.getClip();
	        // Open audio clip and load samples from the audio input stream.
	        clip.open(audioIn);clip.start();
	     } catch (UnsupportedAudioFileException e) {
	        e.printStackTrace();
	     } catch (IOException e) {
	        e.printStackTrace();
	     } catch (LineUnavailableException e) {
	        e.printStackTrace();
	     }
	}
}
