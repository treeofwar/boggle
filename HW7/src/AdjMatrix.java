
import java.util.*;
public class AdjMatrix {
             public static final int DEF_SIZE = 10;
             private double[][] adjMatrix;
             public AdjMatrix()
             {
                           init(DEF_SIZE);
             }
             public AdjMatrix(int size)
             {
                           init(size);
             }
             private void init(int size)
             {
                           if(size <= 0)
                                        return;
                           adjMatrix = new double[size][size];
             }
             public void addEdge(int toVert, int fromVert, double weight) //To vertices and from vertices
             {
                           if(!isValid(toVert) || !isValid(fromVert)) //If toVert is NOT valid or fromVert is NOT valid
                                        return;
                           adjMatrix[toVert][fromVert] = weight;
             }
             private boolean isValid(int i) //Checking if valid
             {
                           return i>=0 && i<adjMatrix.length;
             }
             private LinkedList<Integer> markedList = new LinkedList<Integer>();
             public void printDFS()  //Depth First search
             {
                           markedList.clear();
                           printDFS(0); //This is arbitrary and this is the recursive call
             }
             private void printDFS(int index) //Recursive Method
             {
                           System.out.println(index);
                           markedList.add(index);
                           for(int i=0; i<adjMatrix.length; i++)
                           {
                                        if(!markedList.contains(i) && adjMatrix[index][i] != 0) //If the markedList doesn't contain index i and the graph isn't empty
                                                     printDFS(i);
                           }
             }
}
             