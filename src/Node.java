
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jerome
 */
public class Node implements NodeInterface{

    private int m_x;
    private int m_y;
    private int m_id;
    Node(int x, int y, int id)
    {
        m_x = x;
        m_y = y;
        m_id = id;
    }
    @Override
    public int getX() {
        return m_x;
    }

    @Override
    public int getY() {
        return m_y;
    }

    @Override
    public int getId() {
        return m_id;
    }
    
}
