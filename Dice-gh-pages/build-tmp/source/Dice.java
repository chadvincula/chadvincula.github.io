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

public class Dice extends PApplet {

Die dice;
int total;
String rollTotal;

public void setup()
{
	noLoop();
	size(400, 400);
}

public void draw()
{
	//your code here
	total = 0;
	background(0, 255, 0);
	for(int j = 40; j <= 360; j += 45)
	{
		for(int i = 0; i <= 400; i += 45)
		{
			dice = new Die(i, j);
			dice.show();
			total += dice.myRoll;
			rollTotal = "" + total;
		}
	}
	//Roll Total
	fill(0);
	rect(140, 5, 120, 30);
	fill(255);
	textSize(16);
	textAlign(CENTER,BASELINE);
	text("Roll Total: " + rollTotal, 200, 30);
}

public void mousePressed()
{
	redraw();
}

class Die //models one single dice cube
{
	//variable declarations here
	int myX, myY, myRoll;
	Die(int x, int y) //constructor
	{
		//variable initializations here
		myX = x;
		myY = y;
		roll();
	}
	public void roll()
	{
		//your code here
		myRoll = (int)(Math.random()*6)+1;
	}
	public void show()
	{
		//your code here
		fill(255);
		rect(myX, myY, 40, 40, 5);
		fill(0);
		if(myRoll == 1)
		{
			ellipse(myX+20, myY+20, 7, 7);
		}
		if(myRoll == 2)
		{
			ellipse(myX+10, myY+10, 7, 7);
			ellipse(myX+30, myY+30, 7, 7);
		}
		if(myRoll == 3)
		{
			ellipse(myX+10, myY+10, 7, 7);
			ellipse(myX+20, myY+20, 7, 7);
			ellipse(myX+30, myY+30, 7, 7);
		}
		if(myRoll == 4)
		{
			ellipse(myX+10, myY+10, 7, 7);
			ellipse(myX+10, myY+30, 7, 7);
			ellipse(myX+30, myY+10, 7, 7);
			ellipse(myX+30, myY+30, 7, 7);
		}
		if(myRoll == 5)
		{
			ellipse(myX+10, myY+10, 7, 7);
			ellipse(myX+10, myY+30, 7, 7);
			ellipse(myX+30, myY+10, 7, 7);
			ellipse(myX+20, myY+20, 7, 7);
			ellipse(myX+30, myY+30, 7, 7);
		}
		if(myRoll == 6)
		{
			ellipse(myX+10, myY+10, 7, 7);
			ellipse(myX+10, myY+30, 7, 7);
			ellipse(myX+30, myY+10, 7, 7);
			ellipse(myX+10, myY+20, 7, 7);
			ellipse(myX+30, myY+20, 7, 7);
			ellipse(myX+30, myY+30, 7, 7);
		}
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
