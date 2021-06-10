/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emp.gl.tp.maze;

import java.awt.Panel;

/**
 *
 * @author fateh
 */
public class SimpleCell extends Panel implements ICell{

    private CellType cellType;
    private int x, y;

    public SimpleCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.cellType = cellType;
    }
    
    @Override
    public CellType getCellType() {
        return cellType;
    }

    @Override
    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
    
}
