package algoritms.searching;

public class Dejsktra {
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex vertexList[]; // Список вершин
    private int adjMat[][]; // Матрица смежности
    private int nVerts; // Текущее количество вершин
    private int nTree; // Количество вершин в дереве
    private DistPar sPath[]; // Массив данных кратчайших путей
    private int currentVert; // Текущая вершина
    private int startToCurrent; // Расстояние до currentVert

    public Dejsktra() {

        vertexList = new Vertex[MAX_VERTS];

        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        nTree = 0;

        for(int j=0; j<MAX_VERTS; j++)
            for(int k=0; k<MAX_VERTS; k++)
                adjMat[j][k] = INFINITY;

        sPath = new DistPar[MAX_VERTS];
    }

    public void addVertex(char lab)
    {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end, int weight)
    {
        adjMat[start][end] = weight; // (направленный граф)
    }

    public void path() // Выбор кратчайших путей
    {
        int startTree = 0; // Начиная с вершины 0
        vertexList[startTree].isInTree = true;
        nTree = 1; // Включение в дерево
        // Перемещение строки расстояний из adjMat в sPath
        for(int j=0; j<nVerts; j++)
        {
            int tempDist = adjMat[startTree][j];
            sPath[j] = new DistPar(startTree, tempDist);
        }
        // Пока все вершины не окажутся в дереве
        while(nTree < nVerts)
        {
            int indexMin = getMin(); // Получение минимума из sPath
            int minDist = sPath[indexMin].distance;
            if(minDist == INFINITY) // Если все расстояния бесконечны
            { // или уже находятся в дереве,
                System.out.println("There are unreachable vertices");
                break; // построение sPath завершено
            }
            else
            { // Возврат currentVert
                currentVert = indexMin; // к ближайшей вершине
                startToCurrent = sPath[indexMin].distance;
                // Минимальное расстояние от startTree
                // до currentVert равно startToCurrent
            }
            // Включение текущей вершины в дерево
            vertexList[currentVert].isInTree = true;
            nTree++;
            adjust_sPath(); // Обновление массива sPath[]
        }
        displayPaths(); // Вывод содержимого sPath[]
        nTree = 0; // Очистка дерева
        for(int j=0; j<nVerts; j++)
            vertexList[j].isInTree = false;
    }

    public int getMin() // Поиск в sPath элемента
    { // с наименьшим расстоянием
        int minDist = INFINITY; // Исходный высокий "минимум"
        int indexMin = 0;

        for(int j=1; j<nVerts; j++) // Для каждой вершины
        { // Если она не включена в дерево
            if( !vertexList[j].isInTree && // и ее расстояние меньше
                    sPath[j].distance < minDist ) // старого минимума
            {
                minDist = sPath[j].distance;
                indexMin = j; // Обновление минимума
            }
        }

        return indexMin; // Метод возвращает индекс
    } // элемента с наименьшим расстояние

    public void adjust_sPath()
    {
        // Обновление данных в массиве кратчайших путей sPath
        int column = 1; // Начальная вершина пропускается
        while(column < nVerts) // Перебор столбцов
        {
            // Если вершин а column уже включена в дерево, она пропускается
            if( vertexList[column].isInTree )
            {
                column++;
                continue;
            }
            // Вычисление расстояния для одного элемента sPath
            // Получение ребра от currentVert к column
            int currentToFringe = adjMat[currentVert][column];
            // Суммирование расстояний
            int startToFringe = startToCurrent + currentToFringe;
            // Определение расстояния текущего элемента sPath
            int sPathDist = sPath[column].distance;
            // Сравнение расстояния от начальной вершины с элементом sPath
            if(startToFringe < sPathDist) // Если меньше,
            { // данные sPath обновляются
                sPath[column].parentVert = currentVert;
                sPath[column].distance = startToFringe;
            }
            column++;
        }
    }

    public void displayPaths()
    {
        for(int j=0; j<nVerts; j++) // display contents of sPath[]
        {
            System.out.print(vertexList[j].label + "="); // B=
            if(sPath[j].distance == INFINITY)
                System.out.print("inf");
            else
                System.out.print(sPath[j].distance); // 50
            char parent = vertexList[ sPath[j].parentVert ].label;
            System.out.print("(" + parent + ") "); // (A)
        }
        System.out.println("");
    }

    class DistPar{

        public int distance;
        public int parentVert;

        public DistPar(int distance, int parentVert) {
            this.distance = distance;
            this.parentVert = parentVert;
        }

    }

    class Vertex{

        public char label;
        public boolean isInTree;

        public Vertex(char label) {
            this.label = label;
            isInTree = false;
        }
    }

}