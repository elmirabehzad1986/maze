import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileOutputGenerator implements OutputGenerator {
    private File outputFile;

    @Override
    public void generate(Maze maze, List<Node> nodes) {

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(outputFile));
            for (int i = 0 ; i<maze.getRowSize(); i++){
                for (int j= 0 ; j<maze.getColumnSize(); j++){

                    if(maze.get(i,j) == maze.START){
                        writer.write("S");

                    }else if(maze.get(i,j) == maze.FINISH){
                        writer.write("F");

                    }else if (nodes.contains(new Node(i,j))){
                        writer.write("*");

                    }else if(maze.get(i,j) == maze.BLOCK){
                        writer.write("#");

                    }else if(maze.get(i,j) == maze.EMPTY){
                        writer.write(" ");

                    }else {
                        writer.write("!");
                    }
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                // Ignore
            }
        }




    }

    public FileOutputGenerator(File outputFile) {
        this.outputFile = outputFile;
    }
}
