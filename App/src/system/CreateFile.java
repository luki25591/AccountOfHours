package system;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public void createFIle(){
        String nameFile = "fileDateAndHours.txt";
        File file = new File(nameFile);

        boolean fileExist = file.exists();
        if(!fileExist){
            try{
                fileExist = file.createNewFile();
            }catch (IOException e){
                System.out.println("Nie udało się utworzyć pliku!");
            }
        }
        if(fileExist){
            System.out.println("Plik: " + nameFile + " istnieje lub został utworzony!");
        }
    }
}
