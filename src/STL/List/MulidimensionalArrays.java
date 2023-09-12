package STL.List;



public class MulidimensionalArrays {

    public static void main(String[] args) {

        ///Create 1-Dimension Array
        int [] oneDimension = new int[3];
        System.out.println(oneDimension.length);


        //Create 2-Dimension Array
        //Size 3 row and 4 col
        int[][] twoDimension = new int [3][];
        twoDimension[0] = new int[4];
        twoDimension[1] = new int[4];
        twoDimension[2] = new int[4];


        twoDimension[0][0] = 0;
        twoDimension[0][1] = 1;
        twoDimension[0][2] = 2;
        twoDimension[0][3] = 3;


        twoDimension[1][0] = 0;
        twoDimension[1][1] = 1;
        twoDimension[1][2] = 2;
        twoDimension[1][3] = 3;

        twoDimension[2][0] = 0;
        twoDimension[2][1] = 1;
        twoDimension[2][2] = 2;
        twoDimension[2][3] = 3;


        //2-D Array of base size 3
        int[][] x = new int[3][];
        x[0] = new int[3];
        x[1] = new int[1];
        x[2] = new int[2];

        //3-D Array of base size 2
        int[][][] z = new int[2][][];

        z[0] = new int[3][];
        z[1] = new int[3][];

        z[0][0] = new int[3];
        z[0][1] = new int[1];
        z[0][2] = new int[2];

        z[1][0] = new int[3];
        z[1][1] = new int[1];
        z[1][2] = new int[2];

        z[0][0][0] = 1;
    }

}
