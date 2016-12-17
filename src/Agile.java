/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jerome
 */
public class Agile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame j = new JFrame();
        j.setSize(800, 600);
        j.setVisible(true);
        DisplayedMap dp = new DisplayedMap(800,600,1600,1200, new IterableMap() {
            @Override
            public Iterator<NodeInterface> nodeIterator() {
                Vector<NodeInterface> hm = new Vector<NodeInterface>();
                hm.add(new Node(400,400,1));
                hm.add(new Node(700,950,2));
                return hm.iterator();
            }

            @Override
            public Iterator<EdgeInterface> edgeIterator() {
                Vector<EdgeInterface> hm = new Vector<EdgeInterface>();
                Edge e = new Edge(new Node(400,400,1),new Node(700,950,2));
                hm.add(e);
                return hm.iterator();
            }
            
        });
        
       j.setContentPane(dp);
    }
    
}
