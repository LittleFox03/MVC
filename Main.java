import javax.swing.SwingUtilities;
import View.CowStrikeApp;

public class Main {
    public static void main(String[] args) {
        // เรียกใช้ GUI ใน Event Dispatch Thread เพื่อความปลอดภัยในการทำงานของ Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CowStrikeApp().setVisible(true); // สร้างและแสดง CowStrikeApp
            }
        });
    }
}

