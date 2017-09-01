package algoritms.searching;

import java.util.Stack;

public class DFS {

    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private boolean visited[];
    private int nVertex;
    private Stack<Integer> stack;

    public DFS(){
        vertexList = new Vertex[20];
        adjMat = new int[20][20];
        visited = new boolean[20];
        nVertex = 0;
        for(int i = 1; i <= nVertex; i++){
            for(int j = 1; j <= nVertex; j++){
                adjMat[i][j] = 0;
            }
        }
        stack = new Stack();
    }

    public void addVertex(String lab){
        vertexList[++nVertex] = new Vertex(lab);
    }

    public void addEdge(int firstVertex, int secondVertex){
        adjMat[firstVertex][secondVertex] = 1;
        adjMat[secondVertex][firstVertex] = 1;
    }

    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }

    public int getFirstFreeVertex(int n){
        for(int i = 1; i <= nVertex; i++){
            if(adjMat[n][i] == 1 && vertexList[i].visited == false){
                return i;
            }
        }
        return -1;
    }

    public void dfsStack(int start){
        stack.push(start);
        vertexList[start].visited = true;
        displayVertex(start);
        while(!stack.isEmpty()){
            int v = getFirstFreeVertex(stack.peek());
            if(v != -1){
                stack.push(v);
                vertexList[v].visited = true;
                displayVertex(v);
            }
            else{
                stack.pop();
            }
        }

    }

    int finish;

    void dfsRecursion(int v, int from)
    {
        if (visited[v]){
            return;
        }

        visited[v] = true;
        stack.push(from);

        if (v == finish){
            System.out.println("Hooray! The path was found!\n");
            return;
        }

        for (int i = 0; i < adjMat[v].length; ++i){
            dfsRecursion(adjMat[v][i], v);
        }
    }

    class Vertex{

        public String label;
        public boolean visited;

        public Vertex(String lab){
            label = lab;
            visited = false;
        }
    }
}