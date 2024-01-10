package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class JPanelGeneralController {

    public static void setVisibility(ArrayList<JComponent> componentList, Boolean visibility){
        for(JComponent component:componentList){
            component.setVisible(visibility);
        }
    }
    public static void setFocusable(ArrayList<JComponent> componentList, boolean focusable) {
        for (JComponent component:componentList) {
            component.setFocusable(focusable);
        }
    }

}
