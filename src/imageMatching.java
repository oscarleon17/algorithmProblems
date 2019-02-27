//Not yet completed, please ignore :)

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class imageMatching {

    public int regionFinder(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == '0') {
            return 0;
        }
        System.out.println("Location is " + i + "," + j);
        grid[i][j] = '0';
        for (int k=0; k<4; k++) {
            regionFinder(grid, i + d[k], j + d[k + 1]);
        }

        return 1;
    }
    int[] d = {0, 1, 0, -1, 0};

    public static int countMatches(List<String> grid1, List<String> grid2) {

        imageMatching imageM = new imageMatching();
        int g1w = grid1.size();
        int g1h = grid1.size();
        int g2w = grid2.size();
        int g2h = grid2.size();

        String grid1String = String.join("", grid1);
        String grid2String = String.join("", grid2);


        char[][] grid1Array = new char[g1w][g1h];
        int position1 = 0;
        for(int i = 0; i < g1w; i++){
            for (int j = 0; j < g1h; j++){
                grid1Array[i][j] = grid1String.charAt(position1);
                position1++;
            }
        }

        char[][] grid2Array = new char[g2w][g2h];
        int position2 = 0;
        for(int i = 0; i < g2w; i++){
            for (int j = 0; j < g2h; j++){
                grid2Array[i][j] = grid2String.charAt(position2);
                position2++;
            }
        }

        int islands = 0;
        for (int i=0; i<grid1Array.length; i++)
            for (int j=0; j<grid1Array[i].length; j++)
                islands += imageM.regionFinder(grid1Array, i, j);
        return islands;

    }



    public static void main(String[] args) throws  IOException{

        File file = new File("./input001.txt");
        InputStream is = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int grid1Count = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid1 = IntStream.range(0, grid1Count).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int grid2Count = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid2 = IntStream.range(0, grid2Count).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int result = imageMatching.countMatches(grid1, grid2);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();

    }
}
