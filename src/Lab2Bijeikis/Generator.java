package Lab2Bijeikis;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Klasė duomenis generuoti
 */
public class Generator {
    /**
     * Kontruktorius
     */
    public Generator(){};

    /**
     * Metodas generuoti duomenis
     * @param amount duomenu kiekis
     */
     public void Generate(int amount) {
            String[] processorMakers = {"Intel", "AMD", "Apple", "Qualcomm"};
            String[] processorModels = {"i7","i5","i9","i3", "Ryzen 9","Ryzen 7","Ryzen 5", "M1","M2", "Snapdragon 888"};
            String[] ramAmounts = {"8GB", "16GB", "32GB", "64GB"};
            String[] hardDriveSpace = {"256GB", "512GB", "1TB", "2TB"};

            Random random = new Random();
            String[] dataRow = new String[amount];

            for (int i = 0; i < amount; i++) {
                String processorMaker = processorMakers[random.nextInt(processorMakers.length)];
                String processorModel = processorModels[random.nextInt(processorModels.length)];
                String ram = ramAmounts[random.nextInt(ramAmounts.length)];
                String storage = hardDriveSpace[random.nextInt(hardDriveSpace.length)];
                int randomInt = random.nextInt(10001);
                double price = 100 + (900 * random.nextDouble());

                dataRow[i] = processorMaker + ";" + processorModel + ";" + ram + ";" + storage + ";" + randomInt + ";" + String.format("%.2f", price);
            }
            PrintToFile(dataRow);
     }

    /**
     * Spausdina sukurtus duomenis i faila
     * @param data duomenų masyvas
     */
     public void PrintToFile(String[] data){
         String fileName = "Kompiuteriai.txt";

         try {

             FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

             for(int i=0;i<data.length;i++){
                 bufferedWriter.write(data[i]+"\n");
             }


             bufferedWriter.close();
             fileWriter.close();

             System.out.println("Data has been written to " + fileName);
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

}
