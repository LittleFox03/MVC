package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.CheckDatabase;
import Model.Animal;
import Model.CowHandler;

public class CowStrikeApp extends JFrame {

    private JTextField idInput;
    private JLabel resultLabel;
    private CheckDatabase controller;
    private CowHandler cowHandler;

    public CowStrikeApp() {
        controller = new CheckDatabase();
        cowHandler = new CowHandler();

        setTitle("Cow Strike");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("กรุณาใส่รหัสวัวหรือแพะ:");
        idInput = new JTextField(10);
        JButton submitButton = new JButton("ตรวจสอบ");
        resultLabel = new JLabel("");

        panel.add(label);
        panel.add(idInput);
        panel.add(submitButton);
        panel.add(resultLabel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkId();
            }
        });

        add(panel);
    }

    private void checkId() {
        String animalId = idInput.getText();
        Animal animal = controller.getAnimalById(animalId);

        if (animal == null) {
            resultLabel.setText("ไม่พบสัตว์ตัวนี้ในฐานข้อมูล!");
        } else {
            if (animal.getType().equals("Goat")) {
                resultLabel.setText("รหัสตรงกับแพะ: " + animal.getId() + " ส่งกลับภูเขา!");
            } else if (animal.getType().equals("Cow")) {
                int milkProduction = animal.getAgeYears() + animal.getAgeMonths();
                if (animal.getUdders() == 4) {
                    cowHandler.handleCowWithFourUdders(animal);
                    resultLabel.setText("รหัสตรงกับวัว: " + animal.getId() +
                            ", รีดนมได้: " + milkProduction + " ลิตร");
                } else if (animal.getUdders() == 3) {
                    cowHandler.handleCowWithThreeUdders(animal);
                    resultLabel.setText("รหัสตรงกับวัว: " + animal.getId() +
                            ", วัวไม่สมบูรณ์ รีดนมไม่ได้ แต่โอกาสกลับมาเป็น 4 เต้า: 20%");
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CowStrikeApp().setVisible(true);
            }
        });
    }
}
