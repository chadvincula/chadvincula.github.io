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

public class OriginalDesign extends PApplet {

int colr = 0;
int colg = 100;
int colb = 200;
int changeR = 5;
int changeG = 5;
int changeB = 5;
int changeX1 = -5;
int changeX2 = 5;
int changeY = -1;
int x1 = 170;
int x2 = 230;
int y1 = 0;
int y2 = 400;
public void setup()
{
  size(400,400);
}

public void draw()
{
  background(colr, colg, colb);
  for(int i = 1; i < 100; i++)
  {
  	trippyUp(x1+(i*7), x2-(i*7), y1+(i*5), colr+(i*(int)(Math.random()*3)), colg+(i*(int)(Math.random()*3)), colb+(i*(int)(Math.random()*3)));
  	trippyDown(x1+(i*7), x2-(i*7), y2-(i*5), colr+(i*(int)(Math.random()*3)), colg+(i*(int)(Math.random()*3)), colb+(i*(int)(Math.random()*3)));
  }

  colr += changeR;
  colg += changeG;
  colb += changeB;
  x1 += changeX1;
  x2 += changeX2;
  y1 += changeY;
  y2 -= changeY;

  if(colr > 255)
  {
  	changeR = -5;
  }
  else if(colr < 0)
  {
  	changeR = 5;
  }
  if(colg > 255)
  {
  	changeG = -5;
  }
  else if(colg < 0)
  {
  	changeG = 5;
  }
  if(colb > 255)
  {
  	changeB = -5;
  }
  else if(colb < 0)
  {
  	changeB = 5;
  }
  if(x1 < -50)
  {
  	changeX1 = 5;
  }
  else if(x1 > 250)
  {
  	changeX1 = -5;
  }
  if(x2 > 450)
  {
  	changeX2 = -5;
  }
  else if(x2 < 150)
  {
  	changeX2 = 5;
  }
  if(y1 < 0)
  {
  	y1 = 500;
  }
  if(y2 > 400)
  {
  	y2 = -100;
  }

  groundAndSky();
  hair();
  head();
  eyes();
  body();
  beard();
  arm();

}

public void groundAndSky()
{
	noStroke();
	fill(0, 174, 255,20);
	bezier(400,0,469,100,88,200,-300,0);
	bezier(400,0,435,100,100,200,-300,0);
	bezier(400,0,401,100,112,200,-300,0);
	bezier(400,0,367,100,124,200,-300,0);
	bezier(400,0,333,100,136,200,-300,0);
	bezier(400,0,299,100,148,200,-300,0);
	bezier(400,0,265,100,160,200,-300,0);
	bezier(400,0,231,100,172,200,-300,0);
	//fill(55, 158, 55);
	//rect(0,300,400,100);
}
public void hair()
{
	rotate(PI/12);
	fill(255, 255, 255);
	bezier(328,186,251,-84,13,-84,18,186);
	bezier(328,186,327,-84,109,-84,18,186);
	rect(18,185,310,137);
	fill(0, 0, 0,70);
	bezier(256,241,258,281,292,340,281,207);
	bezier(101,232,56,320,52,301,63,170);
	fill(0, 0, 0,30);
	triangle(174,-12,175,26,165,25);
}
public void head()
{
	fill(158, 98, 98);
	rect(61,149,220,100,50);
	bezier(62,208,56,-37,287,-37,281,208);
	fill(138, 73, 73);
	bezier(94,168,100,196,157,196,163,168);
	fill(158, 98, 98);
	bezier(94,168,118,191,141,189,163,168);
	fill(138, 73, 73);
	bezier(94,155,100,180,158,180,163,155);
	fill(158, 98, 98);
	bezier(94,155,118,174,141,174,163,155);
	fill(138, 73, 73);
	bezier(187,168,193,196,250,196,256,168);
	fill(158, 98, 98);
	bezier(187,168,210,191,235,189,256,168);
	fill(138, 73, 73);
	bezier(187,155,193,180,250,180,256,155);
	fill(158, 98, 98);
	bezier(187,155,211,174,234,174,256,155);
	fill(255, 0, 0);
	rect(55,22,237,10);
}
public void eyes()
{
	fill(251, 255, 0);
	ellipse(128,119,70,70);
	ellipse(215,119,70,70);
	fill(250, 255, 224);
	ellipse(123,111,50,50);
	ellipse(210,111,50,50);
	fill(255, 255, 255,30);
	ellipse(128,119,72,72);
	ellipse(128,119,74,74);
	ellipse(128,119,76,76);
	ellipse(128,119,78,78);
	ellipse(128,119,80,80);
	ellipse(128,119,82,82);
	ellipse(128,119,84,84);
	ellipse(215,119,72,72);
	ellipse(215,119,74,74);
	ellipse(215,119,76,76);
	ellipse(215,119,78,78);
	ellipse(215,119,80,80);
	ellipse(215,119,82,82);
	ellipse(215,119,84,84);
}
public void body()
{
	fill(0, 136, 255);
	bezier(-3,444,-75,181,417,181,351,444);
}
public void beard()
{
	fill(255, 255, 255);
	bezier(65,316,84,99,273,235,282,316);
	bezier(65,316,93,235,264,99,282,316);
	bezier(65,316,84,514,273,482,282,316);
	fill(0, 0, 0,30);
	bezier(65,321,68,233,114,180,179,204);
	bezier(283,321,274,233,245,180,177,204);
	quad(177,205,192,218,184,212,169,216);
	bezier(65,321,68,399,138,515,179,217);
	bezier(283,321,269,399,230,515,177,217);
	fill(255, 255, 255);
	bezier(72,321,76,233,123,184,179,215);
	bezier(274,321,274,233,221,182,177,215);
	bezier(73,321,76,399,138,515,177,215);
	bezier(273,321,267,399,220,515,181,215);
}
public void arm()
{
	rotate(PI/12);
	fill(158, 98, 98);
	rect(417,127,41,60);
	fill(255, 255, 255);
	rect(387,140,105,300,30);
	fill(0, 0, 0,30);
	rect(387,140,105,300,30);
	fill(255, 255, 255);
	rect(390,145,98,300,30);
	noFill();
	stroke(158, 98, 98);
	strokeWeight(15);
	arc(438,95,60,60,-2*PI/45,31*PI/30);
	stroke(255, 255, 255,40);
	strokeWeight(1);
	arc(438,102,71,60,14*PI/45,683*PI/1000);
}

public void trippyUp(int leftX, int rightX, int y, int colorR, int colorG, int colorB)
{
	noStroke();
	fill(colorR, colorG, colorB);
	bezier(-40,y,leftX,y-100,rightX,y-100,440,y);
}
public void trippyDown(int leftX, int rightX, int y, int colorR, int colorG, int colorB)
{
	noStroke();
	fill(colorR, colorG, colorB);
	bezier(-40,y,leftX,y+100,rightX,y+100,440,y);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OriginalDesign" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
