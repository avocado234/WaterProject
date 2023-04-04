public class checkAge {

    public double check(int age, char gender) {
        double waterIntake = 0;

        if (age >= 1 && age <= 3) {
            waterIntake = 1000;
        } else if (age >= 4 && age <= 8) {
            waterIntake = 1200;
        } else if (age >= 9 && age <= 13) {
            if (gender == 'M' || gender == 'm') {
                waterIntake = 2100;
            } else if (gender == 'F' || gender == 'f') {
                waterIntake = 1900;
            }
        } else if (age >= 14 && age <= 18) {
            if (gender == 'M' || gender == 'm') {
                waterIntake = 2600;
            } else if (gender == 'F' || gender == 'f') {
                waterIntake = 2300;
            }
        } else if (age >= 19 && age <= 50) {
            if (gender == 'M' || gender == 'm') {
                waterIntake = 3300;
            } else if (gender == 'F' || gender == 'f') {
                waterIntake = 2300;
            }
        } else if (age > 50 && age <120) {
            if (gender == 'M' || gender == 'm') {
                waterIntake = 3000;
            } else if (gender == 'F' || gender == 'f') {
                waterIntake = 2100;
            }
        }

        return waterIntake;
    }
}
