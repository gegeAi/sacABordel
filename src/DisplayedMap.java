
import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jerome
 */
public class DisplayedMap extends JPanel{
    
    private IterableMap m_map;
    private float m_scaleX;
    private float m_scaleY;
    
    private static final int NODE_SIZE = 10;
    
    private static final Color BACKGROUND_COLOR = Color.lightGray;
    private static final Color NODE_COLOR = Color.black;
    private static final Color EDGE_COLOR = Color.gray;
  
    DisplayedMap(int width, int height, int scaledWidth, int scaledHeight, IterableMap map)
    {
        super();
        super.setSize(width, height);
        this.setMap(map);
        this.setScale(scaledWidth, scaledHeight);
        
    }
    
    public final void setMap(IterableMap map)
    {
        m_map = map;
        repaint();
    }
    
    public final void setScale(int scaledWidth, int scaledHeight)
    {
        m_scaleX = ((float) this.getWidth()) / scaledWidth;
        m_scaleY = ((float) this.getHeight()) / scaledHeight;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        this.setBackgroundColor(g);
        this.drawNodes(g);
        this.drawEdges(g);
        
    }
    
    private void setBackgroundColor(Graphics g)
    {
        g.setColor(BACKGROUND_COLOR);
        int width = this.getWidth();
        int height = this.getHeight();
        g.fillRect(0, 0, width, height);   
    }
    
    private void drawNodes(Graphics g)
    {
        g.setColor(NODE_COLOR);
        
        Iterator<NodeInterface> it = m_map.nodeIterator();
        
        while(it.hasNext())
        {
            NodeInterface node = it.next();
            int x = (int) (node.getX()*m_scaleX);
            int y = (int) (node.getY()*m_scaleY);
            
            g.fillOval(x-NODE_SIZE/2, y-NODE_SIZE/2, NODE_SIZE, NODE_SIZE);
            
        }
    }
    
    private void drawEdges(Graphics g)
    {
        g.setColor(EDGE_COLOR);
        
        Iterator<EdgeInterface> it = m_map.edgeIterator();
        
        while(it.hasNext())
        {
            System.out.println("edge");
            EdgeInterface edge = it.next();
            
            Iterator<NodeInterface> itNode = m_map.nodeIterator();
            int xBegin = -1;
            int yBegin = -1;
            int xEnd = -1;
            int yEnd = -1;
            while(itNode.hasNext() && (xBegin == -1 || xEnd == -1))
            {
                NodeInterface node = itNode.next();
                System.out.println("node");
                if(node.getId() == edge.getBegin())
                {
                    xBegin = (int) (node.getX()*m_scaleX);
                    yBegin = (int) (node.getY()*m_scaleY);
                    System.out.println("premier");
                }
                if(node.getId() == edge.getEnd())
                {
                    xEnd = (int) (node.getX()*m_scaleX);
                    yEnd = (int) (node.getY()*m_scaleY);
                    System.out.println("deuxieme");
                }
            }
            
            g.drawLine(xBegin, yBegin, xEnd, yEnd);
            
        }
        
    }
    
}
