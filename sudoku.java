import java.util.Scanner;

public class sudoku{

    private static final int boardsize = 9;

    public static void main(String[] args) {
   
        int board[][] = {

       {7,0,2,0,5,0,6,0,0},
       {0,0,0,0,0,3,0,0,0},
       {1,0,0,0,0,9,5,0,0},
       {8,0,0,0,0,0,0,9,0},
       {0,4,3,0,0,0,7,5,0},
       {0,9,0,0,0,3,0,0,8},
       {0,0,9,7,0,0,0,0,5},
       {0,0,0,2,0,0,0,0,0},
       {0,0,7,0,4,0,2,0,3}
        };

    // Scanner scanner = new Scanner(System.in);
  
    // int board[][] = new int[boardsize][boardsize];

    // for(int i=0;i<boardsize;i++){
    //     for(int j=0;j<boardsize;j++){
    //         board[i][j] = scanner.nextInt(); 
    //     }
    // }

        if(solve(board)){
            System.out.println("wow solved it");
        }
        else{
            System.out.println("unsolvable board");
        }

        printboard(board);
    }

    private static void printboard(int board[][]){

   for(int row = 0 ;row<boardsize;row++){

  for(int column=0;column<boardsize;column++){

    System.out.print(board[row][column]+" ");
  }
 System.out.println();

   }


    }
    
    private static boolean noinrow(int board[][],int num,int row){

   for(int i=0;i<boardsize;i++){
   
    if(board[row][i]==num){
        return true;
    }
   }
return false;
    }

    private static boolean noincolumn(int board[][],int num,int column){

        for(int i=0;i<boardsize;i++){
        
         if(board[i][column]==num){
             return true;
         }
        }
     return false;
         }


         
    private static boolean noinbox(int board[][],int num,int row,int column){

int localboxrow = row-row%3;
int localboxcol = column - column%3;        

for(int i=localboxrow;i<localboxrow+3;i++){

for(int j=localboxcol;j<localboxcol+3;j++){

    if(board[localboxrow][localboxcol]==num){
        return true;
    }
}
}
return false;
    }

    private static boolean bestplacement(int board[][],int num,int row,int col){

   
  return !noinrow(board, num, row) && 
         !noincolumn(board, num, col) &&
         !noinbox(board, num, row, col);

    }


private static boolean solve(int board[][]){

for(int i=0;i<boardsize;i++){

for(int col=0;col<boardsize;col++){

    if(board[i][col]==0){
        for(int numtotry = 1;numtotry<=boardsize;numtotry++){

            if(bestplacement(board, numtotry,i,col)){
             
                board[i][col] = numtotry;

                if(solve(board)){
                    return true;
                }
                else{
                   board[i][col]=0;
                }
            }
        }
        return false;
    }
    
}
}

   return true; 
}


}
