import enums.DayOfWeek;
import model.Family;
import model.Human;
import model.Pet;
import enums.Species;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet(Species.DOG, "Buddy");

        // Valideynlərin yaradılması
        // Ana
        Map<DayOfWeek, String> motherSchedule = new HashMap<>();
        motherSchedule.put(DayOfWeek.MONDAY, "Work");
        motherSchedule.put(DayOfWeek.TUESDAY, "Exercise");

        Human mother = createHuman("Aysel", "Mammadova", 30, 120, pet, null, null,
                motherSchedule);

        // Ata
        Map<DayOfWeek, String> fatherSchedule = new HashMap<>();
        fatherSchedule.put(DayOfWeek.MONDAY, "Work");
        fatherSchedule.put(DayOfWeek.TUESDAY, "Meeting");

        Human father = createHuman("Elvin", "Mammadov", 35, 130, pet, null, null,
                fatherSchedule);

        // Övladların yaradılması
        // Leyla
        Map<DayOfWeek, String> leylaSchedule = new HashMap<>();
        leylaSchedule.put(DayOfWeek.MONDAY, "Play");
        leylaSchedule.put(DayOfWeek.TUESDAY, "School");

        Human child1 = createHuman("Leyla", "Mammadova", 5, 90, pet, mother, father,
                leylaSchedule);

        // Ziya
        Map<DayOfWeek, String> ziyaSchedule = new HashMap<>();
        ziyaSchedule.put(DayOfWeek.MONDAY, "School");
        ziyaSchedule.put(DayOfWeek.TUESDAY, "Play");

        Human child2 = createHuman("Ziya", "Mammadov", 7, 100, pet, mother, father,
                ziyaSchedule);

        // Ailənin yaradılması
        Family family = new Family(mother, father, new Human[]{child1, child2}, pet);
        mother.setFamily(family);
        father.setFamily(family);

        printFamily(family, "Başlanğıc ailə məlumatları");

        // Yeni övlad əlavə edilməsi
        // Nigar
        Map<DayOfWeek, String> nigarSchedule = new HashMap<>();
        nigarSchedule.put(DayOfWeek.MONDAY, "Play");
        nigarSchedule.put(DayOfWeek.TUESDAY, "Dance");

        Human child3 = createHuman("Nigar", "Mammadova", 4, 85, pet, mother, father,
                nigarSchedule);
        family.addChild(child3);
        printFamily(family, "Yeni uşaq əlavə edildikdən sonra");

        // Ailədəki üzvlərin sayı
        System.out.println("Ailədəki üzvlərin sayı: " + family.countFamily());

        // Uşaqlardan birinin silinməsi
        family.deleteChild(0);
        printFamily(family, "Uşaq silindikdən sonra");
        System.out.println("Ailədəki üzvlərin sayı (silinmədən sonra): " + family.countFamily());
    }

    // Human yaradılması üçün köməkçi metod
    private static Human createHuman(String name, String surname, int age, int iq, Pet pet, Human mother, Human father, Map<DayOfWeek, String> schedule) {
        return new Human(name, surname, age, iq, pet, mother, father, schedule, null);
    }

    // Ailə məlumatlarını çap etmək üçün metod
    private static void printFamily(Family family, String message) {
        System.out.println("\n" + message + ":");
        System.out.println(family);
    }
}
