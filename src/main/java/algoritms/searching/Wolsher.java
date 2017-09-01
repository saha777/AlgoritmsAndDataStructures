package algoritms.searching;


public class Wolsher {

    int numVer;
    int adjMat[][];

    public Wolsher(int numVer){
        this.numVer = numVer;
        adjMat = new int[numVer][numVer];
    }

    public void addEdge(int firstVertex, int secondVertex, int weight){
        adjMat[firstVertex][secondVertex] = weight;
        adjMat[secondVertex][firstVertex] = weight;
    }

    public void WolsherRun(){
        for(int k = 1; k <= numVer; k++)
            for(int i = 1; i <= numVer; i++)
                for(int j = 1; j <= numVer; j++)
                    if(adjMat[i][j] > adjMat[i][k] + adjMat[k][j])
                        adjMat[i][j] = adjMat[i][k] + adjMat[k][j];
    }

}