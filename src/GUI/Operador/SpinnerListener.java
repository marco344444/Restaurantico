package GUI.Operador;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class SpinnerListener implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
        JSpinner spinner = (JSpinner) e.getSource();
        int value = (int) spinner.getValue();

        if (value < 0 || value > 10) {
            spinner.setValue(spinner.getPreviousValue());
        }
    }
}
