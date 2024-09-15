package Controller;

import Model.Animal;
import Model.CowHandler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckDatabase {
    private List<Animal> animals;
    private CowHandler cowHandler;

    public CheckDatabase() {
        animals = loadAnimals("Model/Database.csv");
        cowHandler = new CowHandler();
    }

    private List<Animal> loadAnimals(String filePath) {
        List<Animal> animals = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 5) {
                    continue;
                }

                String id = parts[0].trim();
                String type = parts[1].trim();
                int ageYears = parts[2].isEmpty() ? 0 : (int) Double.parseDouble(parts[2].trim());
                int ageMonths = parts[3].isEmpty() ? 0 : (int) Double.parseDouble(parts[3].trim());
                Integer udders = parts[4].isEmpty() ? null : (int) Double.parseDouble(parts[4].trim());

                animals.add(new Animal(id, type, ageYears, ageMonths, udders));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return animals;
    }

    public Animal getAnimalById(String animalId) {
        for (Animal animal : animals) {
            if (animal.getId().equals(animalId)) {
                return animal;
            }
        }
        return null;
    }
}
