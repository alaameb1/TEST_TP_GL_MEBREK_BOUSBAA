/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emp.gl.tp.robot;


/**
 *
 * @author fateh
 */
public interface IRobot {

    public void render(int oldX, int oldY, int newX, int newY);

    public void moveRight();

    public void moveLeft();

    public void moveTop();

    public void moveBottom();
    
    public void changeState(IState state);
}
