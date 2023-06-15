import view.AppFrame;

import javax.swing.*;

public class CrudApp {
    public static void main(String[] args) {
        // varsão do java utilizada 11

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AppFrame appFrame = new AppFrame();
                appFrame.mostrar();
            }
        });
    }
}
