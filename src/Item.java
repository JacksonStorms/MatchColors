package porject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Item {
	private MainGame scene;
	private int x, y;
	private BufferedImage tm;
	private Random random;
	private int speed = 1;
	private Graphics g;
	private String it;
	
	public Item(MainGame scene, int x, int y) {
		try {
			tm = ImageIO.read(getClass().getResourceAsStream("/hp.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setScene(scene);
        this.x = x;
        this.y = y;
        random = new Random();
        this.it = "use";
	}
	public boolean update() {
    	
    	y += speed;
        if (y > 700) {
            return false;
        } else {
            return true;
        }
    }
	public MainGame getScene() {
		return scene;
	}


	public void setScene(MainGame scene) {
		this.scene = scene;
	}
	public String getItem() {
    	return it;
    }
	public void draw(Graphics g) {
		g.drawImage(tm,x, y, 50, 50,null);
	}
	public boolean sameWord(String a) {
    	if(a.equals(getItem())) {return true;}
    	
    	else {return false;}
        
    }
	
}
