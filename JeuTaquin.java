import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Arrays;
import java.util.Collections;


public class JeuTaquin extends JFrame {

    public JeuTaquin() {
        initComponents();
    }

                          
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255,182,193));
        jLabel2.setText("TAQUIN GAME");

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(1));

        jRadioButton1.setText("Breadth First Search");

        jRadioButton2.setText("Depth First search");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton2)
                .addGap(45, 45, 45))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jRadioButton1)
                .addComponent(jRadioButton2))
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 2, 14));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons8_search_30px_1.png"))); 
        jButton2.setText("Search");
        

        
         // Initial board configuration
        b.generateNewBoard();
        
        jButton2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                if (jRadioButton1.isSelected())
                	
                {List<String> solution = solveTaquin(b.board);

                    if (solution != null) {
                        jTextField1.setText(solution.size()+"");
                        printSteps(solution, b.board);
                        
                    } else {
                        jTextArea1.append("No solution found.");
                    }
                 

                }
                else if(jRadioButton2.isSelected())
                {
                    List<String> solution = solveTaquinDFS(b.board);

                    if (solution != null) {
                        jTextField1.setText(solution.size() + "");
                        printSteps(solution, b.board);
                    } else {
                        jTextArea1.setText("No solution found.");
                    }

                }

                
            }

           
        });
    



        jButton3.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons8_replay_30px_1.png"))); 
        jButton3.setText("Replay");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               int [][] previousTable= b.board;
               if (previousTable != null) {
                
                jButton4.setText(previousTable[0][0] + "");
                    jButton5.setText(previousTable[0][1] + "");
                    jButton10.setText(previousTable[0][2] + "");
                    jButton12.setText(previousTable[1][0] + "");
                    jButton7.setText(previousTable[1][1] + "");
                    jButton8.setText(previousTable[1][2] + "");
                    jButton9.setText(previousTable[2][0] + "");
                    jButton11.setText(previousTable[2][1] + "");
                    jButton6.setText(previousTable[2][2] + "");

                    jTextArea1.setText("");
                    jTextField1.setText("");

            }
        }
            });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Moves:");

        jPanel6 = new JPanel(new GridLayout(3, 3));
        
        jButton4.setBackground(new Color(219,112,147));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setText(b.board[0][0]+"");
      
        jPanel6.add(jButton4);
jButton5.setBackground(new Color(219,112,147));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton5.setText(b.board[0][1]+"");
        jPanel6.add(jButton5);

        jButton10.setBackground(new Color(219,112,147));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton10.setText(b.board[0][2]+"");
        jPanel6.add(jButton10);

        jButton12.setBackground(new Color(219,112,147));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton12.setText(b.board[1][0]+"");
        jPanel6.add(jButton12);

        jButton7.setBackground(new Color(219,112,147));    
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton7.setText(b.board[1][1]+"");
        jPanel6.add(jButton7);

        jButton8.setBackground(new Color(219,112,147)); 
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton8.setText(b.board[1][2]+"");
        jPanel6.add(jButton8);

        jButton9.setBackground(new Color(219,112,147));     
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton9.setText(b.board[2][0]+"");
        jPanel6.add(jButton9);

        jButton11.setBackground(new Color(219,112,147));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton11.setText(b.board[2][1]+"");
        jPanel6.add(jButton11);

        jButton6.setBackground(new Color(219,112,147));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton6.setText( b.board[2][2]+"");
        jPanel6.add(jButton6);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jButton1.setFont(new java.awt.Font("Tahoma", 2, 18)); 
        jButton1.setForeground(new java.awt.Color(255, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons8_new_30px_4.png"))); 
        jButton1.setText("New Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                {
                   
                    b.generateNewBoard();
                    // Update the buttons with the new board state
                    jButton4.setText(b.board[0][0] + "");
                    jButton5.setText(b.board[0][1] + "");
                    jButton10.setText(b.board[0][2] + "");
                    jButton12.setText(b.board[1][0] + "");
                    jButton7.setText(b.board[1][1] + "");
                    jButton8.setText(b.board[1][2] + "");
                    jButton9.setText(b.board[2][0] + "");
                    jButton11.setText(b.board[2][1] + "");
                    jButton6.setText(b.board[2][2] + "");

                    jTextArea1.setText("");
                    jTextField1.setText("");
                }

                
            }
        });


        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEditable(true);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));

        jMenu1.setText("File");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons8_add_30px_2.png")));  
        jMenuItem1.setText("New");
        jMenu1.add(jMenuItem1);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                {  b.generateNewBoard();
                    // Update the buttons with the new board state
                    jButton4.setText(b.board[0][0] + "");
                    jButton5.setText(b.board[0][1] + "");
                    jButton10.setText(b.board[0][2] + "");
                    jButton12.setText(b.board[1][0] + "");
                    jButton7.setText(b.board[1][1] + "");
                    jButton8.setText(b.board[1][2] + "");
                    jButton9.setText(b.board[2][0] + "");
                    jButton11.setText(b.board[2][1] + "");
                    jButton6.setText(b.board[2][2] + "");

                    jTextArea1.setText("");
                    jTextField1.setText("");
                   
                }
            }});

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons8_cancel_30px_3.png"))); 
        jMenuItem2.setText("Exit");
        jMenu1.add(jMenuItem2);
        jMenuItem2.addActionListener(e -> System.exit(0));

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons8_help_30px_1.png"))); 
        jMenuItem3.setText("About");
        jMenu3.add(jMenuItem3);
        jMenuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                JOptionPane.showMessageDialog(JeuTaquin.this, "This application was created by Amal Maatoug , ING INFO 1, ISIMM ", "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();


                                        
    }
        
    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JeuTaquin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JeuTaquin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JeuTaquin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JeuTaquin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JeuTaquin().setVisible(true);
            }
        });
    }



//dfs method

public List<String> solveTaquinDFS(int[][] initialBoard) {
    int[][] goalBoard = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0}
    };

    Stack<Node> stack = new Stack<>();
    Set<String> visited = new HashSet<>();

    Node initialNode = new Node(initialBoard, findZeroRow(initialBoard), findZeroCol(initialBoard), "");
    stack.push(initialNode);
    visited.add(Arrays.deepToString(initialBoard));

    while (!stack.isEmpty()) {
        Node current = stack.pop();
        if (Arrays.deepEquals(current.board, goalBoard)) {
            return getPath(current);
        }

        int zeroRow = current.zeroRow;
        int zeroCol = current.zeroCol;

        for (int i = 0; i < 4; i++) {
            int newRow = zeroRow + ROW_MOVES[i];
            int newCol = zeroCol + COL_MOVES[i];

            if (isValidMove(newRow, newCol)) {
                int[][] newBoard = cloneBoard(current.board);
                swap(newBoard, zeroRow, zeroCol, newRow, newCol);

                if (!visited.contains(Arrays.deepToString(newBoard))) {
                    String move = DIRECTIONS[i];
                    Node newNode = new Node(newBoard, newRow, newCol, move);
                    newNode.parent = current;
                    stack.push(newNode);
                    visited.add(Arrays.deepToString(newBoard));
                }
            }
        }
        jButton4.setText(goalBoard[0][0]+"");
        jButton5.setText(goalBoard[0][1]+"");
        jButton10.setText(goalBoard[0][2]+"");
        jButton12.setText(goalBoard[1][0]+"");
        jButton7.setText(goalBoard[1][1]+"");
        jButton8.setText(goalBoard[1][2]+"");
        jButton9.setText(goalBoard[2][0]+"");
        jButton11.setText(goalBoard[2][1]+"");
        jButton6.setText(goalBoard[2][2]+"");
    }

    return null; // No solution found
}

 
           
//BFS method 
class Node {
    public int[][] board;
    public int zeroRow;
    public int zeroCol;
    public String move;
    public Node parent;

    public Node(int[][] board, int zeroRow, int zeroCol, String move) {
        this.board = board;
        this.zeroRow = zeroRow;
        this.zeroCol = zeroCol;
        this.move = move;
        this.parent = null;
    }
}
    private static final int[] ROW_MOVES = {0, 0, -1, 1};
    private static final int[] COL_MOVES = {-1, 1, 0, 0};
    private static final String[] DIRECTIONS = {"LEFT", "RIGHT", "UP", "DOWN"};
    private static final int SIZE = 3;



    private static void printSteps(List<String> moves, int[][] initialBoard) {
        int[][] currentBoard = cloneBoard(initialBoard);
        jTextArea1.append("Configurations du tableau :\n");
        jTextArea1.append("Étape 0 :\n");
        printBoard(currentBoard);
    
        for (int i = 0; i < moves.size(); i++) {
            String move = moves.get(i);
    
            int zeroRow = findZeroRow(currentBoard);
            int zeroCol = findZeroCol(currentBoard);
            int newRow = zeroRow;
            int newCol = zeroCol;
    
            switch (move) {
                case "UP":
                    newRow--;
                    break;
                case "DOWN":
                    newRow++;
                    break;
                case "LEFT":
                    newCol--;
                    break;
                case "RIGHT":
                    newCol++;
                    break;
            }
     
            swap(currentBoard, zeroRow, zeroCol, newRow, newCol);
    
            jTextArea1.append("");
            jTextArea1.append("\nStep " + (i + 1) + " : "+ move+"\n");
            printBoard(currentBoard);
       
    
     
        }
        jTextArea1.append("Done!");
    }
    
    private static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                
                jTextArea1.append(board[i][j] + " ");

            }
            jTextArea1.append("\n");
        }
        jTextArea1.append("\n");
    }
    

public List<String> solveTaquin(int[][] initialBoard) {
    int[][] goalBoard = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0}
    };

    Queue<Node> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();

    Node initialNode = new Node(initialBoard, findZeroRow(initialBoard), findZeroCol(initialBoard), "");
    queue.add(initialNode);
    visited.add(Arrays.deepToString(initialBoard));

    while (!queue.isEmpty()) {
        Node current = queue.poll();

        if (Arrays.deepEquals(current.board, goalBoard)) {
            return getPath(current);
        }

        int zeroRow = current.zeroRow;
        int zeroCol = current.zeroCol;

        for (int i = 0; i < 4; i++) {
            int newRow = zeroRow + ROW_MOVES[i];
            int newCol = zeroCol + COL_MOVES[i];

            if (isValidMove(newRow, newCol)) {
                int[][] newBoard = cloneBoard(current.board);
         
                swap(newBoard, zeroRow, zeroCol, newRow, newCol);

                if (!visited.contains(Arrays.deepToString(newBoard))) {
                    String move = DIRECTIONS[i];
                    Node newNode = new Node(newBoard, newRow, newCol, move);
                    newNode.parent = current;
                    queue.add(newNode);
                    visited.add(Arrays.deepToString(newBoard));
                }
            }
        }
        jButton4.setText(goalBoard[0][0]+"");
        jButton5.setText(goalBoard[0][1]+"");
        jButton10.setText(goalBoard[0][2]+"");
        jButton12.setText(goalBoard[1][0]+"");
        jButton7.setText(goalBoard[1][1]+"");
        jButton8.setText(goalBoard[1][2]+"");
        jButton9.setText(goalBoard[2][0]+"");
        jButton11.setText(goalBoard[2][1]+"");
        jButton6.setText(goalBoard[2][2]+""); 
    }

    return null; // No solution found
}

private boolean isValidMove(int row, int col) {
    return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
}

private static int[][] cloneBoard(int[][] board) {
    int[][] clone = new int[SIZE][SIZE];
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            clone[i][j] = board[i][j];
        }
        
    }
    return clone;
}

private static void swap(int[][] board, int row1, int col1, int row2, int col2) {
    int temp = board[row1][col1];
    board[row1][col1] = board[row2][col2];
    board[row2][col2] = temp;
}

private static int findZeroRow(int[][] board) {
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (board[i][j] == 0) {
                return i;
            }
        }
    }
    return -1; // Zero not found
}

private static int findZeroCol(int[][] board) {
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (board[i][j] == 0) {
                return j;
            }
        }
    }
    return -1; // Zero not found
}

private List<String> getPath(Node node) {
    List<String> path = new ArrayList<>();
    while (node.parent != null) {
        path.add(0, node.move);
        node = node.parent;
    }
    return path;
}


public class BoardGenerator {
    private int[][] board;

    public BoardGenerator() {
        this.board = new int[3][3];
    }

    public int[][] generateNewBoard() {
        List<Integer> numbers = new ArrayList<>();

        // Populate the list with numbers 0 to 8
        for (int i = 0; i < 9; i++) {
            numbers.add(i);
        }

        // Shuffle the numbers randomly
        Collections.shuffle(numbers);

        // Assign the shuffled numbers to the board
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = numbers.get(index);
                index++;
            }
        }
        
        // Check if the generated board is solvable
        while (!isSolvable()) {
            Collections.shuffle(numbers);
            index = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    this.board[i][j] = numbers.get(index);
                    index++;
                }
            }
        }

        return this.board;
    }

    private boolean isSolvable() {
        int inversions = 0;
        int[] flat = flatten();
        for (int i = 0; i < flat.length - 1; i++) {
            if (flat[i] != 0) {
                for (int j = i + 1; j < flat.length; j++) {
                    if (flat[j] != 0 && flat[i] > flat[j]) {
                        inversions++;
                    }
                }
            }
        }
        return inversions % 2 == 0;
    }

    private int[] flatten() {
        int[] flat = new int[9];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                flat[k++] = this.board[i][j];
            }
        }
        return flat;
    }
}
BoardGenerator b = new BoardGenerator();

    



	// Variables declaration       

    private javax.swing.JButton jButton1;
    private static javax.swing.JButton jButton10;
    private static javax.swing.JButton jButton11;
    private static javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private static javax.swing.JButton jButton4;
    private static javax.swing.JButton jButton5;
    private static javax.swing.JButton jButton6;
    private static javax.swing.JButton jButton7;
    private static javax.swing.JButton jButton8;
    private static javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private static  javax.swing.JTextArea jTextArea1;
    private static javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}