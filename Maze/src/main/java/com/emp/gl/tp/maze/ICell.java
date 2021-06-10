/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emp.gl.tp.maze;

/**
 *
 * @author fateh
 */
public interface ICell {
    public CellType getCellType();
    public void setCellType(CellType cellType);
    public int getX();
    public int getY();
    public void setX(int x);
    public void setY(int y);
}


