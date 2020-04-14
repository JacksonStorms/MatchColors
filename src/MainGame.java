package porject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.*;
import javax.swing.Timer;

import java.util.*;


public class MainGame extends JPanel implements ActionListener,MouseListener,MouseMotionListener {
	
	private ArrayList<Words> dList = new ArrayList<Words>();
	private BufferedImage hp,ovs,line,bg,re1,re2,re3;
	private static final long serialVersionUID = 1L;
	private ArrayList<Words> words = new ArrayList<Words>();
	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<Item> dListI = new ArrayList<Item>();
	private Random random,ranItem;
    static int score = 0 ;
    private int hpx;
    private String wr = "";
    private Timer timer;
	private JPanel panel1;
	private JTextField textfield;
	private JButton btn1,btn2;
	protected boolean timeS = true;
	private int hpmax = 4;
	private int i = 0;
	private int x = 0;
	private Font f1 = new Font("Courier",Font.BOLD,30);
	private Font f2 = new Font("Courier",Font.BOLD,20);
	private Font f3 = new Font("Courier",Font.BOLD,15);
	private int getIn = 0;
	private Rectangle ree = new Rectangle(240, 500, 70, 70);
	static int fase = 0;
	static int lvl = 500;
	private URL url;
	private AudioInputStream audioIn;
	private Clip clip;
	
	public MainGame(){
		try {
			ovs = ImageIO.read(getClass().getResourceAsStream("/OverS.jpg"));
			hp = ImageIO.read(getClass().getResourceAsStream("/hp.png"));
			line = ImageIO.read(getClass().getResourceAsStream("/ropered.png"));
			bg = ImageIO.read(getClass().getResourceAsStream("/GameBG.png"));
			re1 = ImageIO.read(getClass().getResourceAsStream("/Re1.png"));
			re2 = ImageIO.read(getClass().getResourceAsStream("/Re2.png"));
			re3 = ImageIO.read(getClass().getResourceAsStream("/Re3.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setFocusable(true);
        panel1 = new JPanel();
        
        ranItem = new Random();
        random = new Random();
		textfield = new JTextField(30);
		btn2 = new JButton("Back To Menu");
		btn1 = new JButton("Re-Start");
		btn2.setPreferredSize(new Dimension(150,30));
		btn2.setBackground(Color.green);
		btn2.setFont(f3);
		btn1.setBackground(Color.yellow);
		btn1.setPreferredSize(new Dimension(90,20));
		panel1.setBackground(null);
		
		panel1.add(textfield);
		panel1.add(btn2);
		add(panel1);
		textfield.setFont(f2);
		addMouseListener(this);
        addMouseMotionListener(this);
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				score = 0;
				x = 0;
				for (Words color : words) {   
					dList.add(color);
					
		        }
				for (Words dead : dList) {
		            if (words.contains(dead)) {
		                words.remove(dead);
		            }
		        }
				x = 0;
				createColor();
				MainGame.fase = 0;
				timer.start();
				System.out.print("aaaa");
			}
		});
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.frames = 1;
				x = 4;
				score = 0;
				MainGame.fase = 0;
				timer.stop();
				Pop();
			}
		});
		textfield.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					wr = textfield.getText();
					
					textfield.setText("");
					repaint();
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		
        for (int i = 0; i < 3; i++) {
            Words word = new Words(this, 50 + random.nextInt(400), 680 + random.nextInt(100));
            words.add(word);
            
        }
        
        timer = new Timer(1000/50, this);
        timer.start();
	}
	public void createColor() {
		for (int i = 0; i < 3; i++) {
            Words word = new Words(this, 50 + random.nextInt(400), 680 + random.nextInt(100));
            words.add(word);}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(0 + ranItem.nextInt(200) == 50) {
			if(items.size() == 0) {
			Item it = new Item(this, 50 + random.nextInt(450),50 );
			items.add(it);}
			System.out.print("sssssssssssssssssssssssssssssssssss");}
		update();
		
		System.out.print(words.get(0).getColor());
		System.out.print(words.get(1).getColor());
		System.out.print(words.get(2).getColor());
	}
	
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
        g.drawImage(bg, 0, 0, 550,700, null);

		g.setFont(f1);
        for (Words word : words) {
            word.draw(g);
        }
        for (Item it : items) {
            it.draw(g);
        }
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 20, 80);
        hpx = 360;
        for(i = 0+x ;i < hpmax;i++) {
        g.drawImage(hp, hpx, 50, 50, 50, null);
        hpx += 40;        
        }
        if(x == 4) {
        	g.setFont(f1);
        	g.drawImage(ovs,5,0,525,700,null);
        	g.drawString("Score: " + score, 180, 220);
        	timer.stop();
        	if(getIn == 0) {
        		g.drawImage(re1, 240, 500, 70, 70,null);
        	}
        	if(getIn == 1) {
        		g.drawImage(re2, 240, 500, 70, 70,null);
        	}
        	System.out.println("xxxxxxxxxxxxxxxxxxxxx");
        }
        g.setColor(Color.red);
        if(x != 4) {
        g.drawImage(line,0,100,600, 10,null);}
        
    }
    
    public void update() {
        
        System.out.println(wr);
        
        for (Words color : words) {
            if (color.update() == false) {
                dList.add(color);
                x++;
            }
        }
        for (Item it : items) {
            if (it.update() == false) {
                dListI.add(it);
                
            }
        }
        for (Words color : words) {
        	if (color.sameWord(wr)) {
        		dList.add(color);
       			score += 10;
       			Pop();
       			wr = "";
       			}
        }
        for (Item it : items) {
        	if (it.sameWord(wr)) {
        		dListI.add(it);
        		if(x != 0) {x -= 1;Dop();}
       			wr = "";
       			}
        	
        }
        for (Words dead : dList) {
            if (words.contains(dead)) {
                words.remove(dead);
                
                Words word = new Words(this, 50 + random.nextInt(400), 680 + random.nextInt(100));
                words.add(word);
                if(score == 100) {
                	Words z = new Words(this, 50 + random.nextInt(400), 680 + random.nextInt(100));
                    words.add(z);
                }
                if(score == 250) {
                	Words z = new Words(this, 50 + random.nextInt(400), 680 + random.nextInt(100));
                    words.add(z);
                }
            }
        }
        
        for (Item dead : dListI) {
            if (items.contains(dead)) {
                items.remove(dead);
            }
        }
        
        //score += 1;
        if(score == 150) {
        	MainGame.fase = 1;
        	}
        repaint();
    }
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		if(x == 4) {
		if ((e.getPoint().getY() < ree.getY() + 70) && (e.getPoint().getY() > ree.getY())) {
			if((e.getPoint().getX() < ree.getX() + 70) && (e.getPoint().getX() > ree.getX())) {
				getIn = 1;
				System.out.println(getIn);
				repaint();
			}
			else {getIn = 0;repaint();;}
		}
		else {getIn = 0;repaint();}
	}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(x == 4) {
			if ((e.getPoint().getY() < ree.getY() + 70) && (e.getPoint().getY() > ree.getY())) {
				if((e.getPoint().getX() < ree.getX() + 70) && (e.getPoint().getX() > ree.getX())) {
					this.Pop();
					timer.stop();
					score = 0;
					x = 0;
					for (Words color : words) {   
						dList.add(color);
						x++;
			        }
					for (Words dead : dList) {
			            if (words.contains(dead)) {
			                words.remove(dead);
			            }
			        }
					for (Item it : items) {
						dListI.add(it);
			        }
					for (Item dead : dListI) {
			            if (items.contains(dead)) {
			                items.remove(dead);
			            }
			        }
					x = 0;
					createColor();
					timer.start();
					System.out.print("aaaa");
					}
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
	public void Dop()
	{
		try {
	        // Open an audio input stream.
	        url = this.getClass().getClassLoader().getResource("Dropflag.wav");
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
