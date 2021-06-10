/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emp.gl.tp.myrobot;

import com.emp.gl.tp.maze.CellType;
import com.emp.gl.tp.maze.ICell;
import com.emp.gl.tp.maze.IMaze;
import com.emp.gl.tp.robot.IRobot;
import com.emp.gl.tp.robot.IState;
import com.emp.gl.tp.robot.Position;
import com.emp.gl.tp.robot.StateIndicator;
import com.emp.gl.tp.robot.TopState;
import java.beans.PropertyChangeSupport;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author fateh
 */
public class MyRobot implements IRobot {

    private final PropertyChangeSupport support;

    private final IMaze maze;

    private IState state;

    private int x, y, oldX, oldY;

    public MyRobot(IMaze maze, int x_, int y_) {
        state = new TopState(this);
        this.x = x_;
        this.y = y_;
        support = new PropertyChangeSupport(this);
        this.maze = maze;
        support.addPropertyChangeListener(this.maze);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                move();
                render(oldX, oldY, x, y);
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    void move() {
        oldX = x;
        oldY = y;
        int pre_x = x + state.getDx();
        int pre_y = y + state.getDy();

        if (pre_x < 0) {
            pre_x = 0;
            this.state.changeState(StateIndicator.BLOCKED);
        }
        if (pre_x == maze.getWidth()) {
            pre_x--;
            this.state.changeState(StateIndicator.BLOCKED);
        }

        if (pre_y < 0) {
            pre_y = 0;
            this.state.changeState(StateIndicator.BLOCKED);
        }
        if (pre_y == maze.getHeight()) {
            pre_y--;
            this.state.changeState(StateIndicator.BLOCKED);
        }

        ICell cell = maze.getCell(pre_x, pre_y);

        CellType cellType = cell.getCellType();
        if (cellType != CellType.OBSTACLE) {
            x = pre_x;
            y = pre_y;
        } else {
            this.state.changeState(StateIndicator.BLOCKED);
        }

    }

    @Override
    public void render(int oldX, int oldY, int newX, int newY) {
        Position oldPosition = new Position(oldX, oldY);
        Position newPosition = new Position(newX, newY);
        support.firePropertyChange("Position", oldPosition, newPosition);
    }

    @Override
    public void moveRight() {
        this.state.changeState(StateIndicator.RIGHT);
    }

    @Override
    public void moveLeft() {
        this.state.changeState(StateIndicator.LEFT);
    }

    @Override
    public void moveTop() {
        this.state.changeState(StateIndicator.TOP);
    }

    @Override
    public void moveBottom() {
        this.state.changeState(StateIndicator.BOTTOM);
    }

    @Override
    public void changeState(IState state) {
        this.state = state;
    }
}
