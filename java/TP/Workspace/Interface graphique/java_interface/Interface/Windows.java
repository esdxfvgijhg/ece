package Interface;

import Algorithme.Telechargement;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.PrintStream;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.text.JTextComponent;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

// Referenced classes of package Interface:
//            MyPanelTree, MyPanelInfos, MyPanelDownload, WindowsListener, 
//            BarreMenus, ContextualMenu, BarreTaches

public class Windows extends JFrame
{
    class ResizeWindow
        implements ComponentListener
    {

        public void componentResized(ComponentEvent componentevent)
        {
            Dimension dimension = getSize();
            boolean flag = false;
            if(dimension.height < taille.height)
            {
                dimension.height = taille.height;
                flag = true;
            }
            if(dimension.width < taille.width)
            {
                dimension.width = taille.width;
                flag = true;
            }
            if(flag)
            {
                splitPane.setDividerLocation(130);
                setSize(dimension);
            }
        }

        public void componentHidden(ComponentEvent componentevent)
        {
        }

        public void componentMoved(ComponentEvent componentevent)
        {
        }

        public void componentShown(ComponentEvent componentevent)
        {
        }

        ResizeWindow()
        {
        }
    }


    public Windows(String s)
    {
        super(s);
        taille = new Dimension(460, 310);
        rw = new ResizeWindow();
        //splitPane = new JSplitPane(1, true);
        //innerSplitPane = new JSplitPane(0, true);
        panel = new JPanel();
        tree = new MyPanelTree();
        //infos = new MyPanelInfos(this);
        //download = new MyPanelDownload(this, telechar, tree, infos);
        title = s;
        look("Metal");
        setSize(taille);
        setResizable(false);
        addComponentListener(rw);
        
        addWindowListener(new WindowsListener(this));
        menuBar = new BarreMenus(this, tree, download, infos);
        contextualMenu = new ContextualMenu(this);
        toolbar = new BarreTaches(this, download, infos);

			 try
        {
            BufferedImage image = ImageIO.read(new File("images/diable.gif"));
    				MyPanelImage contentPane = new MyPanelImage(image);
    				getContentPane().add(contentPane, "Center");
        }
        catch(Exception interruptedexception1)
        {
            new Dialogue("Impossible de charger l'image : " + interruptedexception1);
        }
    		

        setVisible(true);
				
        //innerSplitPane.setTopComponent(download);
        //innerSplitPane.setBottomComponent(infos);
        //innerSplitPane.setDividerSize(2);
        //innerSplitPane.setDividerLocation(150);
        //getContentPane().add(innerSplitPane, "Center");
        
    }

    public void look(String s)
    {
        try
        {
            if("Windows".equals(s))
                UIManager.setLookAndFeel(new MotifLookAndFeel());
            else
            if("Motif".equals(s))
                UIManager.setLookAndFeel(new MotifLookAndFeel());
            else
            if("Metal".equals(s))
                UIManager.setLookAndFeel(new MetalLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception exception)
        {
            System.out.println("LookAndFeel-Mist : " + exception);
        }
    }

    String title()
    {
        return title;
    }

    public String adresse()
    {
        return download.adresse.getText();
    }

    public void affecteAdr(String s)
    {
        download.adresse.setText(s);
    }
    
    public void dessin()
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
        x1 = image.getWidth(this);
        y1 = image.getHeight(this);
    }

    public void paint(Graphics g)
    {
        g.drawImage(image, 20, 20, x, y, this);
        g.drawString("Copyright \251 REDONDO-WAHED 2000", 260, 480);
        g.drawString("Version 1.0b3 - 20/06/2000", 15, 460);
    }

    Image image;
    Image image1;
    int x1;
    int y1;
    

    private final int x = 460;
    private final int y = 310;
    private String title;
    private Dimension taille;
    ResizeWindow rw;
    private JSplitPane splitPane;
    private JSplitPane innerSplitPane;
    public Telechargement telechar;
    JPanel panel;
    public MyPanelTree tree;
    public MyPanelInfos infos;
    public MyPanelDownload download;
    public BarreMenus menuBar;
    public ContextualMenu contextualMenu;
    public BarreTaches toolbar;


}
