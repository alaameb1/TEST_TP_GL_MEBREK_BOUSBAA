/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emp.gl.tp.maze;

import java.beans.PropertyChangeListener;
import java.util.List;

/**
 *
 * @author fateh
 */
public interface IMaze extends PropertyChangeListener{
    public List<ICell> getNeighbors(int x, int y);
    
    public int getHeight();

    public int getWidth();

    public ICell getCell(int x, int y);
}
