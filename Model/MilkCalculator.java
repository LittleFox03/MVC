package Model;

public class MilkCalculator {

    // ฟังก์ชันสำหรับคำนวณน้ำนมที่ผลิตได้จากวัว
    public int calculateMilkProduction(Animal cow) {
        if (cow.getType().equals("Cow")) {
            // คำนวณน้ำนมโดยใช้จำนวนปีบวกกับจำนวนเดือนในอายุของวัว
            return cow.getAgeYears() + cow.getAgeMonths();
        }
        return 0; // หากไม่ใช่วัว จะไม่ผลิตน้ำนม
    }
}
