package Interface;
import Interface.Dialogue;
import java.awt.*;
import javax.swing.JFrame;

public class Bienvenue extends JFrame
{
    public Bienvenue()
    {
        MediaTracker mediatracker = new MediaTracker(this);
        image = getToolkit().getImage("images/diable.gif");
        mediatracker.addImage(image, 1);
        try
        {
            mediatracker.waitForID(1);
        }
        catch(InterruptedException interruptedexception)
        {
            new Dialogue("Impossible de charger l'image : " + interruptedexception);
        }
        x = image.getWidth(this);
        y = image.getHeight(this);
        image1 = getToolkit().getImage("images/aspimagic.gif");
        mediatracker.addImage(image1, 1);
        try
        {
            mediatracker.waitForID(1);
        }
        catch(InterruptedException interruptedexception1)
        {
            new Dialogue("Impossible de charger l'image : " + interruptedexception1);
        }
        x1 = 400;
        y1 = 200;
    }

    public void paint(Graphics g)
    {
        g.drawImage(image, 20, 20, x, y, this);
        g.drawImage(image1, 35, -30, x1, y1, this);
        g.drawString("Copyright \251 REDONDO-WAHED 2000", 260, 480);
        g.drawString("Version 1.0b3 - 20/06/2000", 15, 460);
    }

    Image image;
    Image image1;
    int x;
    int y;
    int x1;
    int y1;
}
