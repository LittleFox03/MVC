package Model;

import java.util.Random;

public class CowHandler {
    private MilkCalculator milkCalculator;

    public CowHandler() {
        this.milkCalculator = new MilkCalculator();
    }

    public void handleCowWithFourUdders(Animal cow) {
        if (cow.getUdders() == 4) {
            Random rand = new Random();
            if (rand.nextInt(100) < 5) {
                cow.setUdders(3);
                System.out.println("เต้านมของวัวลดลงเหลือ 3 เต้า!");
            } else {
                int milkProduction = milkCalculator.calculateMilkProduction(cow);
                System.out.println("วัวถูกรีดนมเรียบร้อยแล้ว ผลิตน้ำนมได้: " + milkProduction + " ลิตร");
            }
        }
    }

    public void handleCowWithThreeUdders(Animal cow) {
        if (cow.getUdders() == 3) {
            Random rand = new Random();
            if (rand.nextInt(100) < 20) {
                cow.setUdders(4);
                System.out.println("วัวกลับมามี 4 เต้าเหมือนเดิม!");
            } else {
                System.out.println("วัวไม่ได้ถูกรีดนม แต่ไม่มีการเปลี่ยนแปลง");
            }
        }
    }
}
