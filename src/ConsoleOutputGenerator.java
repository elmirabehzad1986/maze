import java.io.IOException;
import java.util.List;

/**
 * Created by elmirabehzad on 20/12/18.
 */
public class ConsoleOutputGenerator implements OutputGenerator {
    @Override

    public void generate(Maze maze, List<Node> nodes) {

        for (int i = 0 ; i<maze.getRowSize(); i++){
            for (int j= 0 ; j<maze.getColumnSize(); j++){

                if(maze.get(i,j) == maze.START){
                    System.out.print("S");

                }else if(maze.get(i,j) == maze.FINISH){
                    System.out.print("F");

                }else if (nodes.contains(new Node(i,j))){
                    System.out.print("*");

                }else if(maze.get(i,j) == maze.BLOCK){
                    System.out.print("#");

                }else if(maze.get(i,j) == maze.EMPTY){
                    System.out.print(" ");

                }else {
                    System.out.print("!");
                }
            }
            System.out.println();
        }
    }
}
