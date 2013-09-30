public ArrayList<String[]> solveNQueens(int n) {
  // Start typing your Java solution below
  // DO NOT write main() function
  
  ArrayList<String[]> chessLists = new ArrayList<String[]>();
  ArrayList<int[]> lists = new ArrayList<int[]>();
  int[] columns = new int[n];
  
  placeQueens(columns, n, 0, lists);
  
  for (int i = 0; i < lists.size(); i++) {
      String[] chess = new String[n];
      for (int j = 0; j < n; j++) {
          String s = "";
          for (int k = 0; k < n; k++) {
              if (lists.get(i)[j] == k) {
                  s = s + "Q";
              } else {
                  s = s + ".";
              }
          }
          chess[j] = s;
      }
      chessLists.add(chess);
  }
  
  return chessLists;
}

public void placeQueens(int[] columns, int n, int rows, ArrayList<int[]> lists) {
  if (rows >= n) {
      int[] result = new int[n];
  	for (int j = 0; j < n; j++) {
  		result[j] = columns[j];
  	}
      lists.add(result);
      return;
  }
  
  for (int i = 0; i < n; i++) {
      columns[rows] = i;
      if (checkValid(columns, rows)) {
          placeQueens(columns, n, rows + 1, lists);
      }
  }
}

public boolean checkValid(int[] columns, int row2) {
  int row1 = 0;
  int column2 = columns[row2];
  for (; row1 < row2; row1++) {
      int column1 = columns[row1];
      if (column1 == column2) {
          return false;
      }
      if (Math.abs(row1 - row2) == Math.abs(column1 - column2)) {
          return false;
      }
  }
  return true;
}
