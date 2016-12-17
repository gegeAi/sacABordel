/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jerome
 */
public class Edge implements EdgeInterface{
    
    private Node m_begin;
    private Node m_end;
    
    Edge(Node begin, Node end)
    {
        m_begin = begin;
        m_end = end;
    }   

    @Override
    public int getBegin() {
        return m_begin.getId();
    }

    @Override
    public int getEnd() {
        return m_end.getId();
    }
    
}
