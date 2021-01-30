
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;

    public MapGenerator(int row, int col)
    {
        map =new int [row][col];
        int i=0;
        while(i<map.length)
        {
            int j = 0;
            while( j < map.length) {
                map[i][j]=1;
                 j++;
            }
            i++;
        }
        brickWidth=540/col;
        brickHeight=150/row;
    }
    public void draw(Graphics2D g)
    {
        int i = 0;
        while( i <map.length) {
            int j = 0;
            while ( j <map.length) {
                if(map[i][j]>0)
                {
                    g.setColor(Color.white);
                    g.fillRect(j *brickWidth + 80, i *brickHeight +50,brickWidth,brickHeight);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);

                }
                 j++;

            }
            i++;
        }


    }
    public void setBrickValue(int value,int row,int col)
    {
        map[row][col]=value;
    }
}
