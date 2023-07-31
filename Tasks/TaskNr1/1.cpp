#include <iostream>
#include <fstream>
#include <algorithm>
#include <queue>
#include <windows.h>
using namespace std;
const int MAX_SIZE = 50;

//функция для изменения цвета консоли
void setcolor(int text, int backG=0){
HANDLE color = GetStdHandle(STD_OUTPUT_HANDLE);
SetConsoleTextAttribute(color,(WORD)((backG << 4)| text));
}

//функция для чтения информации из файла
bool readField(int field[MAX_SIZE][MAX_SIZE], int& n, int& m) {
    ifstream inputFile("Teren.in.txt");
    if (inputFile.is_open() && !inputFile.eof()) {
        inputFile >> n >> m;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                inputFile >> field[i][j];

        inputFile.close();
    } else {
        cout << "Unable to open file Teren.in.txt";
        return false;
    }
    return true;
}

//функция для вывода информации
void writeField(int field[MAX_SIZE][MAX_SIZE], int n, int m) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) cout << field[i][j] << " ";

        cout << endl;
    }
}

//функция для замены 1 и последней колонки матрицы
void swapColumns(int field[MAX_SIZE][MAX_SIZE], int n, int m) {
    for (int i = 0; i < n; i++) swap(field[i][0],field[i][m-1]);

}

//функция для очистки строки матрицы
void clearRow(int field[MAX_SIZE][MAX_SIZE], int row, int m) {
    for (int j = 0; j < m; j++)
        field[row][j] = 0;
}

//функция для очистки столбца матрицы
void clearColumn(int field[MAX_SIZE][MAX_SIZE], int column, int n) {
    for (int i = 0; i < n; i++)
        field[i][column] = 0;
}

//функция для поиска строки с максимальным количеством мин
void getMaxMinedRow(int field[MAX_SIZE][MAX_SIZE], int n, int m) {
    int maxMinedRow = 0;
    int maxMines = 0;
    for (int i = 0; i < n; i++) {
        int mines = 0;
        for (int j = 0; j < m; j++)
            if (field[i][j] == 1) mines++;

        if (mines > maxMines) {
            maxMines = mines;
            maxMinedRow = i;
        }
    }
    cout << maxMinedRow+1 << " ";
        for (int i = 0; i < n; i++) {
        int mines = 0;
        for (int j = 0; j < m; j++)
            if (field[i][j] == 1) mines++;

        if (mines == maxMines and i!=maxMinedRow) cout << i+1 << " ";

    }
    cout << endl;
}

//функция для поиска колонки с максимальным количеством мин
void getMaxMinedColumn(int field[MAX_SIZE][MAX_SIZE], int n, int m) {
    int maxMines = 0;
  int maxMinedColumn = 0;  // Установите начальное значение для maxMinedColumn

    for (int j = 0; j < m; j++) {
        int mines = 0;
        for (int i = 0; i < n; i++)
            if (field[i][j] == 1) mines++;


        if (mines > maxMines) {
            maxMines = mines;
            maxMinedColumn = j;
        }
    }

    cout << maxMinedColumn+1 << " ";

        for (int j = 0; j < m; j++) {
        int mines = 0;
        for (int i = 0; i < n; i++)
            if (field[i][j] == 1) mines++;

        if (mines == maxMines and j!=maxMinedColumn) {
           cout << j+1 << " ";
        }
    }
}

//функция для поиска среднего количества мин в нечётных строках
float getAverageMinedOddRows(int field[MAX_SIZE][MAX_SIZE], int n, int m) {
    int minedRows = 0;
    int minedZones = 0;
    for (int i = 0; i < n; i += 2) {
        for (int j = 0; j < m; j++)
            if (field[i][j] == 1) minedZones++;

        minedRows++;
    }
    return (minedRows > 0) ? static_cast<float>(minedZones) / minedRows : 0.0;
}

//функция для поиска количества мин в колонках
void countMinesInColumns(int field[MAX_SIZE][MAX_SIZE], int n, int m, int mineCounts[MAX_SIZE]) {
    for (int j = 0; j < m; j++) {
        int mines = 0;
        for (int i = 0; i < n; i++)
            if (field[i][j] == 1) mines++;

        mineCounts[j] = mines;
    }
}

//функция для сортировки колонок в убывающем порядке
void sortColumnsByMines(int columns[MAX_SIZE], int mineCounts[MAX_SIZE], int m) {
    for (int i = 0; i < m; i++)
        for (int j = i + 1; j < m; j++)
            if (mineCounts[j] > mineCounts[i]) {
                swap(mineCounts[i], mineCounts[j]);
                swap(columns[i], columns[j]);
            }
}

//функция для копирования строк с минами в отдельный файл
void copyRowsWithMines(int field[MAX_SIZE][MAX_SIZE], int n, int m) {
    ofstream outputFile("Mine.txt");
    if (outputFile.is_open()) {
        for (int i = 0; i < n; i++) {
            bool hasMines = false;
            for (int j = 0; j < m; j++)
                if (field[i][j] == 1) {
                    hasMines = true;
                    break;
                }

            if (hasMines) {
                for (int j = 0; j < m; j++)
                    outputFile << field[i][j] << " ";

                outputFile << endl;
            }
        }
        outputFile.close();
    } else {
        cout << "Unable to open file Mine.txt";
    }
}

//функция для подсчёта объектов в матрицы
int countObjects(int field[MAX_SIZE][MAX_SIZE], int n, int m) {
    int objects = 0;
    bool visited[MAX_SIZE][MAX_SIZE] = { false };

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            if (field[i][j] == 1 && !visited[i][j]) {
                objects++;
                visited[i][j] = true;

                int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
                int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };
                for (int k = 0; k < 8; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if (ni >= 0 && ni < n && nj >= 0 && nj < m && field[ni][nj] == 1 && !visited[ni][nj])
                        visited[ni][nj] = true;
                }
    }

    return objects;
}

// создание структуры для поиска кратчайшего пути в матрице
struct Cell {
    int row;
    int col;
};

// функция для поиска кратчайшего пути от начальной точки к конечной
void findShortestPath(int field[MAX_SIZE][MAX_SIZE], int n, int m) {
    bool visited[MAX_SIZE][MAX_SIZE] = { false };
    Cell parent[MAX_SIZE][MAX_SIZE];

    queue<Cell> q;
    Cell start = { n - 1, m - 1 };
    Cell end = { 0, 0 };

    visited[start.row][start.col] = true;
    q.push(start);

    bool pathFound = false;

    while (!q.empty()) {
        Cell current = q.front();
        q.pop();

        int cx = current.row;
        int cy = current.col;

        if (cx == end.row && cy == end.col) {
            pathFound = true;
            break;
        }

        int dx[] = { -1, 1, 0, 0 };
        int dy[] = { 0, 0, -1, 1 };

        for (int k = 0; k < 4; k++) {
            int nx = cx + dx[k];
            int ny = cy + dy[k];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && field[nx][ny] == 0 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                parent[nx][ny] = { cx, cy };
                q.push({ nx, ny });
            }
        }
    }

    if (pathFound) {
        Cell current = end;

        Cell showPath[MAX_SIZE];
        int count = 0;
        while (current.row != start.row || current.col != start.col) {
            cout << "[" << current.row + 1 << ", " << current.col + 1 << "] - ";
         field[current.row][current.col] = 4;
            current = parent[current.row][current.col];

        }
        cout << "[" << start.row + 1 << ", " << start.col + 1 << "]" << endl;
field[start.row][start.col] = 4;
    } else {
        cout << "No path found." << endl;
    }
}

int main() {
    setcolor(3,0);
    int field[MAX_SIZE][MAX_SIZE];
    int n, m;
    if(readField(field, n, m) == 0) return 10;

    int choice;
    do{
        cout << "Matrix\n";
        writeField(field,n,m);
        cout << "\nMenu:\n";
        cout << "1. Swap first and last columns\n";
        cout << "2. Clear zones in a row/column\n";
        cout << "3. Get row/column with max mines\n";
        cout << "4. Calculate average mined zones in odd rows\n";
        cout << "5. Sort columns by number of mines\n";
        cout << "6. Copy rows with mines to a file\n";
        cout << "7. Count objects\n";
        cout << "8. Find shortest path from top-left to bottom-right\n";
        cout << "9. Read data from a file\n";
        setcolor(4,0);
        cout << "10. Exit\n";
        setcolor(3,0);
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:{
                swapColumns(field, n, m);
                cout << "\nField after swapping first and last columns:" << endl;
                writeField(field, n, m);
            system("pause");
            system("CLS");
                break;
            }case 2:{
                int rowToClear, columnToClear,ch=0;
                cout << "\nWant to clear everything(1), row(2),column(3) or nothing(0)?\n";
                do{
                        if(ch<0 or ch>3){
                            setcolor(4,0);
                            cout << "\nError! Invalid choice! Try again! \n";
                            setcolor(3,0);
                        }

                cout << "Enter your choice: ";
                cin >> ch;
                }while(ch<0 or ch>3);

                switch(ch){
            case 1 :
            case 2 :
                cout << "\nEnter the row to clear: ";
                cin >> rowToClear;
                clearRow(field, rowToClear - 1, m);
                cout << "\nField after clearing row " << rowToClear << ":" << endl;
                writeField(field, n, m);
                if(ch!=1)break;
            case 3:
                cout << "\nEnter the column to clear: ";
                cin >> columnToClear;
                clearColumn(field, columnToClear - 1, n);
                cout << "\nField after clearing column " << columnToClear << ":" << endl;
                writeField(field, n, m);
                if(ch!=1)break;

                case 0 :
                setcolor(4,0);
                cout << "\nExit...\n"<<endl;
                setcolor(3,0);
                break;

            }
                system("pause");
                system("CLS");
            break;

            }case 3:{
                int ch;
cout << "\nWant to see all(1), row(2),column(3) or nothing(0) with the maximum number of mined zones?\n";
                            do{
                        if(ch<0 or ch>3){
                            setcolor(4,0);
                            cout << "\nError! Invalid choice! Try again! \n";
                            setcolor(3,0);
                        }

                cout << "Enter your choice: ";
                cin >> ch;
                }while(ch<0 or ch>3);

                switch(ch){
            case 1 :
            case 2 :{
            cout << "\nRow with the maximum number of mined zones: ";
             getMaxMinedRow(field, n, m);
                if(ch!=1)break;
            }case 3:{
                cout << "\nColumn with the maximum number of mined zones: ";
                getMaxMinedColumn(field, n, m);
                cout << endl;
                if(ch!=1)break;

                }case 0 :
                setcolor(4,0);
                cout << "\nExit...\n\n";
                setcolor(3,0);
                break;
                }
                system("pause");
                system("CLS");
                break;
            }case 4:{
                float averageMinedOddRows = getAverageMinedOddRows(field, n, m);
                cout << "\nAverage mined zones in odd rows: " << averageMinedOddRows << endl;
                system("pause");
                system("CLS");
                break;
            }case 5:{
                int columns[MAX_SIZE];
                int mineCounts[MAX_SIZE];
                for (int j = 0; j < m; j++) {
                    columns[j] = j + 1;
                }
                countMinesInColumns(field, n, m, mineCounts);
                sortColumnsByMines(columns, mineCounts, m);
                cout << "\nColumns in descending order of mine count:" << endl;
                for (int j = 0; j < m; j++) {
                    cout << columns[j] << " ";
                }
                cout << endl;
                system("pause");
                system("CLS");
                break;
            }case 6:{
                copyRowsWithMines(field, n, m);
                cout << "\nRows with mines copied to Mine.txt" << endl;
                system("pause");
                system("CLS");
                break;
            }case 7:{
                int objects = countObjects(field, n, m);
                cout << "\nNumber of objects: " << objects << endl;
                system("pause");
                system("CLS");
                break;
            }case 8:{
                cout << "\nShortest path from top-left to bottom-right:" << endl;
                findShortestPath(field, n, m);
cout << "\nPath: \n";
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++)
                            if(field[i][j] == 4){
                field[i][j] = 0;
            setcolor(10,0);
            cout << field[i][j]<< " ";
            setcolor(3,0);
        }else cout << field[i][j] << " ";

        cout << endl;
    }

                system("pause");
                system("CLS");
                break;
            }case 9:{
                readField(field, n, m);
                setcolor(10,0);
                cout << "Data from the file has been read"<<endl;
                setcolor(3,0);
                system("pause");
                system("CLS");
                break;
                }case 10:{
                    setcolor(4,0);
                cout << "Exit..."<<endl;
                setcolor(3,0);
                return 10;
                system("pause");
                system("CLS");
                }
            default:
                setcolor(4,0);
                cout << "\nInvalid choice. Please enter a valid choice.\n";
                setcolor(3,0);
                system("pause");
                system("CLS");
                break;
        }
    }while(choice!=10);

    return 0;
}
