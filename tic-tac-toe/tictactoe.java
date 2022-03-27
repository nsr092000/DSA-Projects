import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class tictactoe{
   
    static ArrayList<Integer> playerpos = new ArrayList<>(); 
    static ArrayList<Integer> cpupos = new ArrayList<>();
public static void main(String[] args) {
    
    char[][] gameboard = {
   {' ','|',' ','|',' '},
   {'-','+','-','+','-'},
   {' ','|',' ','|',' '},
   {'-','+','-','+','-'},
   {' ','|',' ','|',' '}
    };

    printboard(gameboard);


    while(true){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter yor placement (1-9):");
    int playerposition = sc.nextInt();
    
    while(playerpos.contains(playerposition) || cpupos.contains(playerposition)){

        System.out.println(" position filled! Enter a correct postion");
        playerposition = sc.nextInt();
    }

    
    putinboard(gameboard, playerposition, "player");
    
    Random random = new Random();
    int cpuposition = random.nextInt(9)+1;
    while(playerpos.contains(cpuposition) || cpupos.contains(cpuposition)){
        cpuposition = random.nextInt(9)+1;
    }

    putinboard(gameboard,cpuposition,"cpu");
    
    printboard(gameboard);
    checkwinner();
    
    }
    

}

public static void printboard(char gameboard[][]){
    
    for(int i=0;i<gameboard.length;i++){

        for(int j=0;j<gameboard[0].length;j++){
    System.out.print(gameboard[i][j]);
        }
    System.out.println();
    }


}

public static void putinboard(char gameboard[][],int position,String user){

   char symbol = ' ';

    if(user.equals("player")){
   symbol = 'X'; 
   playerpos.add(position);
    }
    else if(user.equals("cpu")){
        symbol = 'O';
        cpupos.add(position);
    }

    switch(position){
   
        case 1:
        gameboard[0][0] = symbol;
        break;

        case 2:
        gameboard[0][2] = symbol;
        break;

        case 3:
        gameboard[0][4] = symbol;
        break;

        case 4:
        gameboard[2][0] = symbol;
        break;

        case 5:
        gameboard[2][2] = symbol;
        break;

        case 6:
        gameboard[2][4] = symbol;
        break;

        case 7:
        gameboard[4][0] = symbol;
        break;

        case 8:
        gameboard[4][2] = symbol;
        break;

        case 9:
        gameboard[4][4] = symbol;
        break;

        default:
        break;
    }
    
}

public static void checkwinner(){

    List toprow = Arrays.asList(1,2,3);
    List midrow = Arrays.asList(4,5,6);
    List lastrow = Arrays.asList(7,8,9);
    List leftcol = Arrays.asList(1,4,7);
    List midcol = Arrays.asList(2,5,8);
    List lastcol = Arrays.asList(3,6,9);
    List cross1 = Arrays.asList(1,5,9);
    List cross2 = Arrays.asList(7,5,3);

List<List> winning = new ArrayList<>();
winning.add(toprow);
winning.add(midrow);
winning.add(lastrow);
winning.add(leftcol);
winning.add(midcol);
winning.add(lastcol);
winning.add(cross1);
winning.add(cross2);

for(List l : winning){

if(playerpos.containsAll(l)){
    
    System.out.println("Player wins");
   
}
else if(cpupos.containsAll(l)){
    
    System.out.println("cpu wins sorry :(, Better Luck Next Time!");
    
}
else if(playerpos.size()+cpupos.size()==9){
    
System.out.println("draw");

}
}
}

}