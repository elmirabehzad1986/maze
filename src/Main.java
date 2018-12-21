import java.io.*;

public class Main {

    static final String FILE_MAZE_IN = "maze.in";
    static final String FILE_MAZE_OUT = "maze.out";


    public static void main(String[] args) {

        String projectPath = "";
        try {
            projectPath = (new File(".")).getCanonicalPath();
            projectPath += "/src/resources/";
        } catch (Exception e) {
            System.out.println("ERROR: Can not get the current project path!");
        }

        File mazeIn = new File(projectPath + FILE_MAZE_IN);
        File mazeOut = new File(projectPath + FILE_MAZE_OUT);

        RecursiveFinder finder = new RecursiveFinder();
        FileOutputGenerator filePrinter = new FileOutputGenerator(mazeOut);
        ConsoleOutputGenerator consolePrinter = new ConsoleOutputGenerator();

        Maze maze = new Maze(finder);
        try {
            maze.load(mazeIn);

            if (maze.find()){
                System.out.println("Maze is: ");
                consolePrinter.generate(maze);
                System.out.println("\nResolved maze is: ");
                maze.printPath(consolePrinter, filePrinter);
            }else{
                System.out.println("Could not find any path from S to F in the maze!\n");
                consolePrinter.generate(maze);
            }

        } catch (IOException e) {
            System.out.println("ERROR: Maze can not load file:" + projectPath + FILE_MAZE_IN);
        }
    }

}