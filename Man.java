import java.util.Arrays;

public class Man {
    static int mistakes = 0;
    char[][] arr = new char[4][15];
    public Man() {
        for(int i = 0; i < 4; i++)
            for (int j = 0; j < 15; j++)
                arr[i][j] = ' ';
        drawManZeroMistake();
        display();
    }
    private void drawMan(int i) {
        if(i == 6)
            arr[3][i] = '/';
        if(i == 8)
            arr[3][i] = '\\';
        if(i == 5)
            arr[2][i] = '/';
        if(i == 7)
            arr[2][i] = '|';
        if(i == 9)
            arr[2][i] = '\\';
        if(i == 7)
            arr[1][i] = 'O';
    }
    public void drawManZeroMistake(){
        for(int i = 0; i < 4; i++)
            arr[i][0] = '|';
        for(int i = 0; i < 4; i++)
            arr[i][14] = '|';
        for(int i = 1; i < 14; i++)
            arr[3][i] = '_';
        for(int i = 0; i < 15; i++) {
            if (i == 1 || i == 2 ||i == 3|| i == 4 || i == 10 || i == 11|| i == 12 || i == 13)
                arr[3][i] = '=';
            drawMan(i);
        }

    }
    public void drawManOneMistake(){
        for(int i = 0; i < 4; i++)
            arr[i][0] = '|';
        for(int i = 0; i < 4; i++)
            arr[i][14] = '|';
        for(int i = 1; i < 14; i++)
            arr[3][i] = '_';
        for(int i = 0; i < 15; i++) {
            if (i == 1 || i == 2 ||i == 3|| i == 4 || i == 10 || i == 11|| i == 12 || i == 13)
                arr[2][i] = '=';
            drawMan(i);
        }
    }

    public void drawManTwoMistakes(){
        for(int i = 0; i < 4; i++)
            arr[i][0] = '|';
        for(int i = 0; i < 4; i++)
            arr[i][14] = '|';
        for(int i = 1; i < 14; i++)
            arr[3][i] = '_';
        for(int i = 0; i < 15; i++) {
            if (i == 1 || i == 2 ||i == 3|| i == 4 || i == 10 || i == 11|| i == 12 || i == 13)
                arr[1][i] = '=';
            drawMan(i);
        }
    }

    public void drawManThreeMistakes(){
        for(int i = 0; i < 4; i++)
            arr[i][0] = '|';
        for(int i = 0; i < 4; i++)
            arr[i][14] = '|';
        for(int i = 1; i < 14; i++)
            arr[3][i] = '_';
        for(int i = 0; i < 15; i++) {
            if (i == 1 || i == 2 ||i == 3|| i == 4 || i == 5|| i == 6 || i == 7 || i == 8 || i == 9|| i == 10 || i == 11|| i == 12 || i == 13)
                arr[0][i] = '=';
            drawMan(i);
        }
    }

    public void display() {
        for (int i = 0; i < 4; i++) {
            // Add leading spaces to align the output to the right
            for (int s = 0; s < 80 - 15; s++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 15; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public void displayCurrent(){
        switch (mistakes){
            case 0:
                drawManZeroMistake();
                display();
                break;
            case 1:
                drawManOneMistake();
                display();
                break;
            case 2:
                drawManTwoMistakes();
                display();
                break;
            case 3:
                drawManThreeMistakes();
                display();
                break;
        }
    }
    public void reset(){
        for(int i = 0; i < 4; i++)
            for (int j = 0; j < 15; j++)
                arr[i][j] = ' ';
        drawManZeroMistake();
        display();
    }
}
//write a method that fills the array to be like the drawing below
/*

|      O      |
|    / | \    |
| = = / \ = = |
|_____________|

 */
