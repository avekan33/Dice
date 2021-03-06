// Random Casino Dice
int total, numberDie, numberRows, changeY, valueDie;
void setup()
{
  size(1020,700);
  noLoop();
  total = 0;
}
void draw()
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
  void roll()
  {
    result = int(random(1,7));
  }
  void show()
  {
    //side = int(random(30, 76));
    y = changeY - int(side/2);
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
void mouseClicked()
{
  redraw();
  total = 0;
}
