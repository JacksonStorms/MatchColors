package porject;

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
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HowTo extends JPanel implements ActionListener,MouseListener,MouseMotionListener {
	private Rectangle btn1,btn2;
	private int getIn = 0;
	private Font f1 = new Font("Courier",Font.BOLD,30);
	private BufferedImage ht1,ht2,htbtn1,htbtn2,hthp,howtoN,ne1,ne2;
	private int i = 0;
	private int next = 0;
	private int next1 = 0;
	private URL url;
	private AudioInputStream audioIn;
	private Clip clip;

	public HowTo() {
		try {
			ht1 = ImageIO.read(getClass().getResourceAsStream("/Howto.png"));
			ht2 = ImageIO.read(getClass().getResourceAsStream("/Howto2.png"));
			htbtn1 = ImageIO.read(getClass().getResourceAsStream("/Back1.png"));
			htbtn2 = ImageIO.read(getClass().getResourceAsStream("/Back2.png"));
			hthp = ImageIO.read(getClass().getResourceAsStream("/HwHP.png"));
			howtoN = ImageIO.read(getClass().getResourceAsStream("/HowtoNext.png"));
			ne1 = ImageIO.read(getClass().getResourceAsStream("/ne1.png"));
			ne2 = ImageIO.read(getClass().getResourceAsStream("/ne2.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		btn1 = new Rectangle(10,10,50,50);
		btn2 = new Rectangle(450,580,50,50);
		setFocusable(true);
		addMouseListener(this);
        addMouseMotionListener(this);
		Timer timer = new Timer(1000/50, this);
        timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int[] q = {5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1}; 
		if(q[i] % 5 == 0) {
			g.drawImage(ht1, 0, 0,550,660, null);
			i++;
		}
		else {g.drawImage(ht2, 0, 0,550,660, null);i++;}
		if(next == 1) {g.drawImage(howtoN, 0, 0, 550, 660,null);}
		if(next == 2) {g.drawImage(hthp, 0, 0, 550, 660,null);}
		if(i == q.length) {i = 0;}
		if(getIn == 0) {
			g.drawImage(htbtn1, 10, 10, 50, 50, null);
			if(next != 2) {
			g.drawImage(ne1,450,580,50,50,null);
			}
		}
		if(getIn == 1) {
			
			g.drawImage(htbtn2, 10, 10, 50, 50, null);
			if(next != 2) {
			g.drawImage(ne1,450,580,50,50,null);
			}
		}
		if(getIn == 2) {
			g.drawImage(htbtn1, 10, 10, 50, 50, null);
			if(next != 2) {
			g.drawImage(ne2,450,580,50,50,null);}
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if ((e.getPoint().getY() < btn1.getY() + 50) && (e.getPoint().getY() > btn1.getY())) {
			if((e.getPoint().getX() < btn1.getX() + 50) && (e.getPoint().getX() > btn1.getX())) {
				getIn = 1;
				System.out.println(getIn);
				
			}
			else {getIn = 0;}
		}
		else if ((e.getPoint().getY() < btn2.getY() +50) && (e.getPoint().getY() > btn2.getY())) {
			if((e.getPoint().getX() < btn2.getX() + 50) && (e.getPoint().getX() > btn2.getX())) {
				getIn = 2;
				System.out.println(getIn);
				
			}
			else {getIn = 0;}
		}
		else {getIn = 0;}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if ((e.getPoint().getY() < btn1.getY() + 50) && (e.getPoint().getY() > btn1.getY())) {
			if((e.getPoint().getX() < btn1.getX() + 50) && (e.getPoint().getX() > btn1.getX())) {
				this.Pop();
				MainFrame.frames = 1;
			}
		}
		if ((e.getPoint().getY() < btn2.getY() +50) && (e.getPoint().getY() > btn2.getY())) {
			if((e.getPoint().getX() < btn2.getX() + 50) && (e.getPoint().getX() > btn2.getX())) {
				
				if(next != 2) {this.Pop();
				next += 1;}
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
