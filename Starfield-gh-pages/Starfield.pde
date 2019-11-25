//your code here
int clicks = 0;
int randomInt = (int)(Math.random()*2);
Particle[] Test = new Particle[100];
Hypnotize[] blackground = new Hypnotize[51];

void setup()
{
	//your code here
	size(400, 400);
	for(int i = 0; i < Test.length; i++)
		Test[i] = new NormalParticle();
	for(int i = 0; i < 30; i++)
		Test[i] = new OddballParticle();
	for(int i = 0; i < 15; i++)
		Test[i] = new JumboParticle();
	for(int i = 0; i < blackground.length; i++)
		blackground[i] = new Hypnotize(((blackground.length-1)*15)-(i*15));
}

void draw()
{
	//your code here
	if(clicks == 0)
	{
		fill(0, 0, 0, 10);
		rectMode(CORNER);
		rect(0, 0, width, height);
		for(int i = 0; i < Test.length; i++)
		{
			Test[i].show();
			Test[i].move();
			Test[i].wrap();
		}
	}
	else if(clicks == 1)
	{
		background(100);
		for(int i = 0; i < blackground.length; i++)
		{
			if(i%2 == 0)
			{
				blackground[i].isBlack = false;
			}
			blackground[i].show();
			blackground[i].grow();
			blackground[i].revert();
		}
	}
	else if(clicks == 2)
	{
		background(100);
		for(int i = 0; i < blackground.length; i++)
		{
			if(i%2 == 0)
			{
				blackground[i].isBlack = false;
			}
			blackground[i].show();
			blackground[i].grow();
			blackground[i].revert();
		}
		for(int i = 0; i < Test.length; i++)
		{
			Test[i].show();
			Test[i].move();
			Test[i].wrap();
		}
	}
	else if(clicks == 3)
	{
		background(0);
		for(int j = 0; j < height+10; j += 10)
		{
			for(int i = 0; i < width; i += 10)
			{
				text(randomInt, i, j);
				randomInt = (int)(Math.random()*2);
			}
		}
	}
}

void mousePressed()
{
	clicks++;
	if(clicks > 3)
		clicks = 0;
}

class NormalParticle implements Particle
{
	//your code here
	int myColor, mySize;
	double myX, myY, myAngle, mySpeed;
	NormalParticle()
	{
		myColor = color(0, 255, 0, 150);
		mySize = (int)(Math.random()*5)+7;
		myX = 200;
		myY = 200;
		myAngle = Math.PI*2*Math.random();
		mySpeed = (Math.random()*5)+5;
	}
	public void show()
	{
		noStroke();
		fill(myColor);
		ellipse((int)myX, (int)myY, mySize, mySize);
	}
	public void move()
	{
		myX += Math.cos(myAngle)*mySpeed;
		myY += Math.sin(myAngle)*mySpeed;
	}
	public void wrap()
	{
		if(myX < 0 || myX > 400)
		{
			myX = 200;
			myY = 200;
			myAngle = Math.PI*2*Math.random();
		}
		if(myY < 0 || myY > 400)
		{
			myX = 200;
			myY = 200;
			myAngle = Math.PI*2*Math.random();
		}
	}
}

interface Particle
{
	//your code here
	public void show();
	public void move();
	public void wrap();
}

class OddballParticle implements Particle //uses an interface
{
	//your code here
	double myX, myY, myAngle, mySpeed;
	OddballParticle()
	{
		myX = 200;
		myY = 200;
		myAngle = Math.PI*2*Math.random();
		mySpeed = (Math.random()*7)+5;
	}
	public void show()
	{
		noStroke();
		fill(255, 0, 0, 150);
		rectMode(CENTER);
		rect((int)myX, (int)myY, 15, 15);
	}
	public void move()
	{
		myX += Math.cos(myAngle)*mySpeed;
		myY += Math.sin(myAngle)*mySpeed;
		myAngle += Math.PI/24;
	}
	public void wrap()
	{
		if(myX < 0 || myX > 400)
		{
			myX = 200;
			myY = 200;
			myAngle = Math.PI*2*Math.random();
		}
		if(myY < 0 || myY > 400)
		{
			myX = 200;
			myY = 200;
			myAngle = Math.PI*2*Math.random();
		}
	}
}

class JumboParticle extends NormalParticle //uses inheritance
{
	//your code here
	public void show()
	{
		noStroke();
		fill(myColor);
		ellipse((int)myX, (int)myY, 20, 20);
	}
}

class Hypnotize
{
	int myX, myY, mySize, growth;
	boolean isBlack;
	boolean isGrowing;
	Hypnotize(int size)
	{
		myX = width/2;
		myY = height/2;
		mySize = size;
		growth = 0;
		isBlack = true;
		isGrowing = true;
	}
	void show()
	{
		if(isBlack == true)
		{
			fill(0);
			ellipse(myX, myY, mySize, mySize);
		}
		else
		{
			fill(255);
			ellipse(myX, myY, mySize, mySize);
		}
	}
	void grow()
	{
		if (isGrowing == true)
		{
			mySize++;
			growth++;
		}
	}
	void revert()
	{
		if (growth == 30)
		{
			mySize -= 30;
			growth = 0;
		}
	}
}