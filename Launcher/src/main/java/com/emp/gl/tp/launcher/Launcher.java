/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emp.gl.tp.launcher;

import com.emp.gl.tp.controller.Controller;
import com.emp.gl.tp.environment.Environment;
import com.emp.gl.tp.maze.IMaze;
import com.emp.gl.tp.myrobot.MyRobot;
import com.emp.gl.tp.robot.IRobot;

/**
 *
 * @author User
 */
public class Launcher {
    public static void main(String[] args) {
        IMaze maze = new Environment(10, 10);
        IRobot robot = new MyRobot(maze, 5, 5);
        Controller ctrl = new Controller(robot);
    }
}
