import javax.swing.*;

public class Show_MySQL {
    public JPanel showPanel;
    private JLabel main_label;
    private JLabel muestraDatos;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Show_MySQL");
        frame.setContentPane(new Show_MySQL().showPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
