

public class colony {

    public static int[] cellCompete(int[] cells, int days)
    {

        int cellsSize = cells.length;
        int temp[] = new int[cellsSize];
        for(int i = 0; i < cellsSize; i++){
            temp[i] = cells[i];
        }

        while(days-- > 0){

            temp[0] = 0 ^ cells[1];
            temp[cellsSize - 1] = 0 ^ cells[cellsSize - 2];

            for(int i = 1; i <= cellsSize - 2; i++){
                temp[i] = cells[i-1] ^ cells[i + 1];
            }

            System.arraycopy(temp, 0, cells, 0, cellsSize);
        }

        return cells;
    }
}
