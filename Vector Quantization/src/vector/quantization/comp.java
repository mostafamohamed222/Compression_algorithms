package vector.quantization;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class comp {

    public void  com()
    {
        Scanner in = new Scanner(System.in);
        //String Path="input.jpg";
        int width=6 , height=6;
        //File file=new File(Path);
        //BufferedImage image=null;
        /*
        try
        {
            image=ImageIO.read(file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
       */
        //width=image.getWidth();
        //height=image.getHeight();
        //System.out.println(width + " "+  height);
        
        int[][] pixels=new int[height][width];
        for(int i = 0 ; i < width ; i++)
        {
            
            for(int j = 0 ; j < height ; j++)
            {
          //      int rgb=image.getRGB(i, j);
            //    int alpha=(rgb >> 24) & 0xff;
              //  int r =   (rgb >> 16) & 0xff;
               // int g =   (rgb >> 8) & 0xff;
               // int b =   (rgb >> 0) & 0xff;
 
                pixels[j][i]=in.nextInt();
                //System.out.print(pixels[j][i]+" ");
            }
            //System.out.println();
        }

        int wid = in.nextInt();
        int hig = in.nextInt();
        
        ArrayList xa = new ArrayList();
        ArrayList ya = new ArrayList();
        
        for(int i = 0 ; i < wid ; i ++)
        {
            for(int j = 0 ; j < hig ; j ++)
            {
                xa.add(i+1);
                ya.add(j+1);
            }
        }
        
        for(int i = 0 ; i < xa.size() ; i++)
        {
            int w = (int) xa.get(i);
            int h = (int) xa.get(i);
            int sum= 0 ;
            
            System.out.println("new " + w + "  " +  h);
            for(int k = w ; k < width ; k +=wid)
            {
                for(int t =  h ; t < height ; t+=hig)
                {
                    System.out.print(pixels[k][t]+ " ");
                 sum+=pixels[k][t];   
                }
            }
            System.out.println(sum);
        }
        
    
        
        
        
    }
    

    
}
