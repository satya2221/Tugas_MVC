/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_mvc;

/**
 *
 * @author Satya
 */
public class MVC_mine {
    View_mine viewnya = new View_mine();
    Model_mine modelnya= new Model_mine();
    Controller_mine controllernya = new Controller_mine(viewnya, modelnya);
}
