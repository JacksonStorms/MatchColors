package porject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

public class Words {
	private MainGame scene;
	private int x, y;
	private String color;
	private String[] colors = {"red","blue","green","pink","white","orange","yellow","black","purple"};
	private BufferedImage 
	white1,white2,red1,red2,green1,green2,
	black1,black2,blue1,blue2,orange1,orange2,
	pink1,pink2,purple1,purple2,yellow1,yellow2,nc1,nc2;
	private Random random;
	private int speed = 1;
	private Graphics g;
	private int i = 0;
	
	
	public Words(MainGame scene, int x, int y) {
		
        this.setScene(scene);
        this.x = x;
        this.y = y;
        try {
			white1 = ImageIO.read(getClass().getResourceAsStream("/white1.png"));
			white2 = ImageIO.read(getClass().getResourceAsStream("/white2.png"));
			black1 = ImageIO.read(getClass().getResourceAsStream("/black1.png"));
			black2 = ImageIO.read(getClass().getResourceAsStream("/black2.png"));
			red1 = ImageIO.read(getClass().getResourceAsStream("/red1.png"));
			red2 = ImageIO.read(getClass().getResourceAsStream("/red2.png"));
			blue1 = ImageIO.read(getClass().getResourceAsStream("/blue1.png"));
			blue2 = ImageIO.read(getClass().getResourceAsStream("/blue2.png"));
			green1 = ImageIO.read(getClass().getResourceAsStream("/green1.png"));
			green2 = ImageIO.read(getClass().getResourceAsStream("/green2.png"));
			yellow1 = ImageIO.read(getClass().getResourceAsStream("/yellow1.png"));
			yellow2 = ImageIO.read(getClass().getResourceAsStream("/yellow2.png"));
			pink1 = ImageIO.read(getClass().getResourceAsStream("/pink1.png"));
			pink2 = ImageIO.read(getClass().getResourceAsStream("/pink2.png"));
			orange1 = ImageIO.read(getClass().getResourceAsStream("/orange1.png"));
			orange2 = ImageIO.read(getClass().getResourceAsStream("/orange2.png"));
			purple1 = ImageIO.read(getClass().getResourceAsStream("/purple1.png"));
			purple2 = ImageIO.read(getClass().getResourceAsStream("/purple2.png"));
			nc1 = ImageIO.read(getClass().getResourceAsStream("/nc1.png"));
			nc2 = ImageIO.read(getClass().getResourceAsStream("/nc2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        random = new Random();
        color = colors[random.nextInt(9)];
        
    }
	
	
    public boolean update() {
    	if(MainGame.score > 250) {speed = 2;}
    	if(MainGame.score > 500) {speed = 3;}
    	if(MainGame.score > 1000) {speed = 10;}
    	y -= speed;
        if (y < 100) {
            return false;
        } else {
            return true;
        }
    }

    
    public void draw(Graphics g) {
    	
		this.g = g;
		
		int[] q = {5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1}; 
        this.g.setColor(Color.WHITE);
        if(MainGame.fase == 0) {
	        if(color == "white") {
	        	if(q[i] % 5 == 0) {
	        		this.g.drawImage(white1,x,y,50,50,null);
	        		i++;
	        	}
	        	else {this.g.drawImage(white2,x,y,50,50,null);i++;}
	        	if(i == q.length) {i = 0;}}
	        if(color == "black") {
	    		if(q[i] % 5 == 0) {
	            	this.g.drawImage(black1,x,y,50,50,null);
	            	i++;
	            }
	    		else {this.g.drawImage(black2,x,y,50,50,null);i++;}
	    		if(i == q.length) {i = 0;}}
	        if(color == "blue") {
	    		if(q[i] % 5 == 0) {
	            	this.g.drawImage(blue1,x,y,50,50,null);
	            	i++;
	            }
	    		else {this.g.drawImage(blue2,x,y,50,50,null);i++;}
	    		if(i == q.length) {i = 0;}}
	        if(color == "green") {
	    		if(q[i] % 5 == 0) {
	            	this.g.drawImage(green1,x,y,50,50,null);
	            	i++;
	            }
	    		else {this.g.drawImage(green2,x,y,50,50,null);i++;}
	    		if(i == q.length) {i = 0;}}
	        if(color == "orange") {
	    		if(q[i] % 5 == 0) {
	            	this.g.drawImage(orange1,x,y,50,50,null);
	            	i++;
	            }
	    		else {this.g.drawImage(orange2,x,y,50,50,null);i++;}
	    		if(i == q.length) {i = 0;}}
	        if(color == "pink") {
	    		if(q[i] % 5 == 0) {
	            	this.g.drawImage(pink1,x,y,50,50,null);
	            	i++;
	            }
	    		else {this.g.drawImage(pink2,x,y,50,50,null);i++;}
	    		if(i == q.length) {i = 0;}}
	        if(color == "purple") {
	    		if(q[i] % 5 == 0) {
	            	this.g.drawImage(purple1,x,y,50,50,null);
	            	i++;
	            }
	    		else {this.g.drawImage(purple2,x,y,50,50,null);i++;}
	    		if(i == q.length) {i = 0;}}
	        if(color == "red") {
	    		if(q[i] % 5 == 0) {
	            	this.g.drawImage(red1,x,y,50,50,null);
	            	i++;
	            }
	    		else {this.g.drawImage(red2,x,y,50,50,null);i++;}
	    		if(i == q.length) {i = 0;}}
	        if(color == "yellow") {
	    		if(q[i] % 5 == 0) {
	            	this.g.drawImage(yellow1,x,y,50,50,null);
	            	i++;
	            }
	    		else {this.g.drawImage(yellow2,x,y,50,50,null);i++;}
	    		if(i == q.length) {i = 0;}}
	        }
        if(MainGame.fase == 1) {
        	if(y > MainGame.lvl) {
        	if(q[i] % 5 == 0) {
        		this.g.drawImage(nc1,x,y,50,50,null);
        		i++;
        	}
        	else {this.g.drawImage(nc2,x,y,50,50,null);i++;}}
        	if(i == q.length) {i = 0;}
        	else if(y <= MainGame.lvl) {
	        if(color == "white") {
	        	if(q[i] % 5 == 0) {
	        		this.g.drawImage(white1,x,y,50,50,null);
	        		i++;
	        	}
	        	else {this.g.drawImage(white2,x,y,50,50,null);i++;}
	        	if(i == q.length) {i = 0;}}
	        if(color == "black") {
	    		if(q[i] % 5 == 0) {
	            	this.g.drawImage(black1,x,y,50,50,null);
	            	i++;
	            }
	    		else {this.g.drawImage(black2,x,y,50,50,null);i++;}
	    		if(i == q.length) {i = 0;}}
	        if(color == "blue") {
	    		if(q[i] % 5 == 0) {
	            	this.g.drawImage(blue1,x,y,50,50,null);
	            	i++;
	            }
	    		else {this.g.drawImage(blue2,x,y,50,50,null);i++;}
	    		if(i == q.length) {i = 0;}}
	        if(color == "green") {
	    		if(q[i] % 5 == 0) {
	            	this.g.drawImage(green1,x,y,50,50,null);
	            	i++;
	            }
	    		else {this.g.drawImage(green2,x,y,50,50,null);i++;}
	    		if(i == q.length) {i = 0;}}
	        if(color == "orange") {
	    		if(q[i] % 5 == 0) {
	            	this.g.drawImage(orange1,x,y,50,50,null);
	            	i++;
	            }
	    		else {this.g.drawImage(orange2,x,y,50,50,null);i++;}
	    		if(i == q.length) {i = 0;}}
	        if(color == "pink") {
	    		if(q[i] % 5 == 0) {
	            	this.g.drawImage(pink1,x,y,50,50,null);
	            	i++;
	            }
	    		else {this.g.drawImage(pink2,x,y,50,50,null);i++;}
	    		if(i == q.length) {i = 0;}}
	        if(color == "purple") {
	    		if(q[i] % 5 == 0) {
	            	this.g.drawImage(purple1,x,y,50,50,null);
	            	i++;
	            }
	    		else {this.g.drawImage(purple2,x,y,50,50,null);i++;}
	    		if(i == q.length) {i = 0;}}
	        if(color == "red") {
	    		if(q[i] % 5 == 0) {
	            	this.g.drawImage(red1,x,y,50,50,null);
	            	i++;
	            }
	    		else {this.g.drawImage(red2,x,y,50,50,null);i++;}
	    		if(i == q.length) {i = 0;}}
	        if(color == "yellow") {
	    		if(q[i] % 5 == 0) {
	            	this.g.drawImage(yellow1,x,y,50,50,null);
	            	i++;
	            }
	    		else {this.g.drawImage(yellow2,x,y,50,50,null);i++;}
	    		if(i == q.length) {i = 0;}}
        	}
	        }
        
    }
    
    public String getColor() {
    	return color;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 50);
    }

    
    public boolean sameWord(String a) {
    	if(a.equals(getColor())) {return true;}
    	
    	else {return false;}
        
    }


	public MainGame getScene() {
		return scene;
	}


	public void setScene(MainGame scene) {
		this.scene = scene;
	}
	public void setSpeed(int a) {
		this.speed = a;
	}
	
}
