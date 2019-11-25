import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Lightning extends PApplet {

int startX1 = 100;
int startY1 = 240;
int endX1 = 100;
int endY1 = 240;
/*
int startX2 = 100;
int startY2 = 240;
int endX2 = 100;
int endY2 = 240;
int changeX = startX1 + (int)(Math.random()*9);
int changeY = startY1 + (int)(Math.random()*9)-4;
*/

public void setup()
{
  size(800,400);
  strokeWeight(3);
  background(0);
}
public void draw()
{
	stick();
	stroke(255);
	stroke((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
	while(endX1 < 800)
	{
		endX1 = startX1 + (int)(Math.random()*9);
		endY1 = startY1 + (int)(Math.random()*9)-4;
		line(startX1, startY1, endX1, endY1);
		startX1 = endX1;
		startY1 = endY1;
	}
	/*
	stroke((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
	while(endX2 < 800)
	{
		endX2 = changeX;
		endY2 = changeY;
		line(startX2, startY2, endX2, endY2);
		startX2 = endX2;
		startY2 = endY2;
	}
	*/
}
public void mousePressed()
{
	startX1 = 100;
	startY1 = 240;
	endX1 = 100;
	endY1 = 240;
	/*
	startX2 = 100;
	startY2 = 250;
	endX2 = 100;
	endY2 = 250;
	*/
}
public void stick()
{
	noStroke();
	//Head
	ellipse(85, 220, 15, 15);
	strokeWeight(2);
	stroke(255);
	//Neck
	line(84, 220, 82, 236);
	//Top Arm
	line(82, 236, 92, 233);
	line(92, 233, 98, 233);
	//Bottom Arm
	line(82, 236, 88, 242);
	line(88, 242, 94, 242);
	//Body
	line(82, 236, 78, 260);
	//Front Leg
	line(78, 260, 86, 267);
	line(86, 267, 84, 275);
	//Back Leg
	line(78, 260, 78, 269);
	line(78, 269, 70, 275);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Lightning" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
