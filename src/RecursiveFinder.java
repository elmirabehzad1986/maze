import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RecursiveFinder implements Finder {
    @Override
    public List<Node> find(Maze maze) {

        return _find(maze, new HashSet<>(), maze.getStart());
    }

    private List<Node> _find(Maze maze, HashSet<Node> prunnedNodes, Node currentNode) {

        if(prunnedNodes.contains(currentNode) || maze.get(currentNode) == maze.BLOCK){
            return null;
        }

        prunnedNodes.add(currentNode);

        List<Node> path = new ArrayList<>();
        path.add(currentNode);

        if (maze.get(currentNode) == maze.FINISH) {
            return path;
        }

        // So maze.get(currentNode) would be equal to maze.START or maze.EMPTY

        List<Node> tempPath;
        if( (tempPath = _find(maze, prunnedNodes, currentNode.getDown())) != null) {
            path.addAll(tempPath);

        }else if( (tempPath = _find(maze, prunnedNodes, currentNode.getRight())) != null) {
            path.addAll(tempPath);

        }else if( (tempPath=_find(maze, prunnedNodes, currentNode.getUp()))!= null) {
            path.addAll(tempPath);

        }else if( (tempPath=_find(maze, prunnedNodes, currentNode.getLeft())) != null) {
            path.addAll(tempPath);

        }else {
            return null;
        }

        return path;
    }
}
