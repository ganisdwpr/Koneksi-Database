/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksidatabase;

/**
 *
 * @author ASUS
 */
public class MVC_Praktikum {
    ViewPraktikum viewPraktikum = new ViewPraktikum();
    ModelPraktikum modelPraktikum = new ModelPraktikum();
    ControllerPraktikum controllerPraktikum = new ControllerPraktikum(modelPraktikum, viewPraktikum);
}
