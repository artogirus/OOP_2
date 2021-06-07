import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class read {
	public int vertex = 0;
	public int[][] arr = new int[100][100];
	
	// lenh doc data
    public void loadData () throws FileNotFoundException, IOException {
        File file =  chooseTextFile();
        FileReader fr = new FileReader(file);
        LineNumberReader lnr = new LineNumberReader(fr);
        int lineNumber = 0;
        while (lnr.readLine() != null) {
            lineNumber++;
        }
        int[][] arr = new int[lineNumber][lineNumber];
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            for (int i = 0; i < arr.length; i++){
                String[] line = sc.nextLine().trim().split(" ");
                for (int j = 0; j < line.length - 1; j++){
                    arr[i][j] = Integer.parseInt(line[j+1]);
                }
            }
        }
        
        this.vertex = arr.length;
        this.arr = arr;
  
    }
    private static File chooseTextFile() {
        FileDialog dialog = new FileDialog((Frame) null, "Select file");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        File[] file; 
        file = dialog.getFiles();
        return file[0];
    }   
}