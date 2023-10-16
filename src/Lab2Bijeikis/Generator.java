package Lab2Bijeikis;
import java.util.Random;

public class Generator {
     public String[] Generate(int amount) {
            // Define arrays of possible values for each column
            String[] processorMakers = {"Intel", "AMD", "Apple", "Qualcomm"};
            String[] processorModels = {"i7","i5","i9","i3", "Ryzen 9","Ryzen 7","Ryzen 5", "M1","M2", "Snapdragon 888"};
            String[] ramAmounts = {"8GB", "16GB", "32GB", "64GB"};
            String[] hardDriveSpace = {"256GB", "512GB", "1TB", "2TB"};

            // Create a random number generator
            Random random = new Random();
            String[] dataRow = new String[amount];
            // Generate and print random data rows
            for (int i = 0; i < amount; i++) {
                String processorMaker = processorMakers[random.nextInt(processorMakers.length)];
                String processorModel = processorModels[random.nextInt(processorModels.length)];
                String ram = ramAmounts[random.nextInt(ramAmounts.length)];
                String storage = hardDriveSpace[random.nextInt(hardDriveSpace.length)];
                int randomInt = random.nextInt(10001);
                double price = 100 + (900 * random.nextDouble()); // Random price between 100 and 1000

                // Create the data row
                dataRow[i] = processorMaker + ";" + processorModel + ";" + ram + ";" + storage + ";" + randomInt + ";" + String.format("%.2f", price);
            }
            return dataRow;
        }

}
