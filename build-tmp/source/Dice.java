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

// Random Casino Dice
int total, numberDie, numberRows, changeY, valueDie;
public void setup()
{
  size(1020,700);
  noLoop();
  total = 0;
}
public void draw()
{
  background(255,0,0);
  int holdx = 0;
  numberRows = 34;
  numberDie = 51;
  valueDie = numberDie * numberRows;
  changeY = 20;
  for(int j = 0; j<numberRows;j++)
  { 
    for(int i = 0;i<numberDie;i++)
    {
      Die dy = new Die();
      dy.x += holdx;
      //dy.y += 30;
      dy.roll();
      dy.show();
      holdx += dy.side;
      total += dy.result;
    }
    changeY += 20;
    holdx = 0;
  }
  textAlign(CENTER);
  text("Total Roll: "+total,50,10);
  text("Number of Die: "+valueDie, 200,10);
  text("Created by Averal Kandala",400,10);
}
class Die
{
  int side;
  int result;
  int x; 
  int y;
  Die()
  {// defaults
    side = 20;
    result = 0;
    x = 0;
    y = changeY;
  }
  public void roll()
  {
    result = PApplet.parseInt(random(1,7));
  }
  public void show()
  {
    //side = int(random(30, 76));
    y = changeY - PApplet.parseInt(side/2);
    stroke(0);
    fill(255);
    rect(x,y,side,side);
    if(result == 1)
    {
      fill(0);
      ellipse(x+(side/2), y+(side/2), (side/5), (side/5));
    }
    else if(result == 2)
    {
      fill(0);
      ellipse(x+(4*(side/5)), y+(side/5), side/5, side/5);
      ellipse(x+(side/5),y+(4*(side/5)), side/5, side/5);
    }
    else if(result == 3)
    {
      fill(0);
      ellipse(x+(side/5), y+(side/5), side/5, side/5);
      ellipse(x+(side/2), y+(side/2), (side/5), (side/5));
      ellipse(x+(4*(side/5)),y+(4*(side/5)), side/5, side/5);
    }
    else if(result == 4)
    {
      fill(0);
      ellipse(x+(side/5), y+(side/5), side/5, side/5);
      ellipse(x+(4*(side/5)), y+(side/5), side/5, side/5);
      ellipse(x+(side/5),y+(4*(side/5)), side/5, side/5);
      ellipse(x+(4*(side/5)),y+(4*(side/5)), side/5, side/5);
    }
    else if(result == 5)
    {
      fill(0);
      ellipse(x+(side/5), y+(side/5), side/5, side/5);
      ellipse(x+(4*(side/5)), y+(side/5), side/5, side/5);
      ellipse(x+(side/2), y+(side/2), (side/5), (side/5));
      ellipse(x+(side/5),y+(4*(side/5)), side/5, side/5);
      ellipse(x+(4*(side/5)),y+(4*(side/5)), side/5, side/5);
    }
    else if(result == 6)
    {
      fill(0);
      ellipse(x+(side/5), y+(side/5), side/5, side/5);
      ellipse(x+(4*(side/5)), y+(side/5), side/5, side/5);
      ellipse(x+(side/5), y+(side/2), side/5, side/5);
      ellipse(x+(4*(side/5)), y+(side/2), side/5, side/5);
      ellipse(x+(side/5),y+(4*(side/5)), side/5, side/5);
      ellipse(x+(4*(side/5)),y+(4*(side/5)), side/5, side/5);
    }
  }
      
  
}
public void mouseClicked()
{
  redraw();
  total = 0;
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
