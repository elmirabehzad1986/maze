import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Maze {

    public final  int BLOCK = 0;
    public final int EMPTY = 1;
    public final  int START = 2;
    public final int FINISH = 3;

    private Finder finder;
    private Node start;
    private Node finish;
    private int columnSize;
    private List<Integer[]> matrix;
    private List<Node> foundPath;

    public Maze(Finder finder) {
        this.finder = finder;
        this.columnSize = 0;
        this.matrix = new ArrayList<>();
    }

    public Node getStart() {
        return start;
    }

    public Node getFinish() {
        return finish;
    }


    public int getColumnSize() {
        return columnSize;
    }

    public int getRowSize() {
        return matrix.size();
    }

    public List<Node> getFoundPath() {
        return foundPath;
    }

    public int get(Node node) {
        return this.get(node.getRow(), node.getColumn());
    }

    public int get(int i, int j) {
        if (i < 0 || i >= matrix.size()){
            return BLOCK;
        }

        if (j < 0 || j >= matrix.get(i).length){
            return BLOCK;
        }

        return matrix.get(i)[j];
    }

    public boolean find(){
        this.foundPath = finder.find(this);
        return (this.foundPath != null && !this.foundPath.isEmpty()) ? true : false;
    }

    public void printPath(OutputGenerator...printers) {
        if (getFoundPath() != null){
            for(OutputGenerator printer : printers){
                printer.generate(this, getFoundPath());
            }
        }
    }

    public  void load(File path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));

        this.matrix.clear();
        String line = null;
        int row = 0;
        while((line = br.readLine()) != null) {
            Integer[] intLine = new Integer[line.length()];
            for(int col = 0; col < line.length(); col++){
                switch(line.charAt(col)){
                    case '#':
                        intLine[col] = BLOCK;
                        break;
                    case ' ':
                        intLine[col] = EMPTY;
                        break;
                    case 'S':
                        intLine[col] = START;
                        start =new Node(row, col);
                        break;
                    case 'F':
                        intLine[col] = FINISH;
                        finish =new Node(row, col);
                        break;
                }
            }
            this.matrix.add(intLine);
            columnSize = line.length() > columnSize ? line.length() : columnSize;
            row++;
        }

        br.close();
    }
}
