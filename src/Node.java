import java.util.Objects;

public class Node {

    private int row;
    private int column;


    public Node(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Node getUp(){
        return new Node(row-1,column);
    }

    public Node getDown(){
        return new Node(row+1,column);
    }

    public Node getLeft(){
        return new Node(row,column-1);
    }

    public Node getRight(){
        return new Node(row,column+1);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (!(obj instanceof Node)){
            return false;
        }
        Node node = (Node) obj;
        return Objects.equals(node.row,row)&& Objects.equals(node.column,column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "{"+row+","+column+"}";
    }
}