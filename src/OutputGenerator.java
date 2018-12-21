import java.util.ArrayList;
import java.util.List;

public interface OutputGenerator {

    public void generate(Maze maze, List<Node> nodes);

    public default void generate(Maze maze) {
        this.generate(maze, new ArrayList<>());
    }
}
