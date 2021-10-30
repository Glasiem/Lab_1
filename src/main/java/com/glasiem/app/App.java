package com.glasiem.app;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashSet;

import static com.glasiem.app.Evaluate.*;

class RowHeaderRenderer extends JLabel implements ListCellRenderer {

    RowHeaderRenderer(JTable table) {
        JTableHeader header = table.getTableHeader();
        setOpaque(true);
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        setHorizontalAlignment(CENTER);
        setForeground(header.getForeground());
        setBackground(header.getBackground());
        setFont(header.getFont());
    }

    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

public class App extends JFrame
{
    FileInputStream in = null;
    FileOutputStream out = null;
    private DefaultTableModel tableModel;
    private JLabel label;
    private JScrollPane scroll;
    private JTextField formula;
    private JTable table1;
    private JButton calculate;
    private JButton close;
    private JButton window1;
    private JButton window2;
    private JButton help;
    private JButton save;
    private JButton load;
    private Object[][] otherSide = new String[][] {
            {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"},
            {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11"},
            {"3", "4", "5", "6", "7", "8", "9", "10", "11", "12"},
            {"4", "5", "6", "7", "8", "9", "10", "11", "12", "13"},
            {"5", "6", "7", "8", "9", "10", "11", "12", "13", "14"},
            {"6", "7", "8", "9", "10", "11", "12", "13", "14", "15"},
            {"7", "8", "9", "10", "11", "12", "13", "14", "15", "16"},
            {"8", "9", "10", "11", "12", "13", "14", "15", "16", "17"},
            {"9", "10", "11", "12", "13", "14", "15", "16", "17", "18"},
    };

    public App() {
        int[] selectedCell = new int[]{0, 0};
        ListModel lm = new AbstractListModel() {
            String headers[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

            public int getSize() {
                return headers.length;
            }

            public Object getElementAt(int index) {
                return headers[index];
            }
        };
        label = new JLabel();
        label.setText("Select cell");
        tableModel = new DefaultTableModel(10,10);
        for (int i = 0; i <  10; i++) {
            for (int j = 0; j < 10; j++) {
                tableModel.setValueAt(String.valueOf(i+j)+".0",i,j);
            }
        }
        close = new JButton("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        formula = new JTextField();
        MouseListener tableMouseListener = new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = table1.columnAtPoint(e.getPoint());
                int row = table1.rowAtPoint(e.getPoint());
                selectedCell[0] = row;
                selectedCell[1] = col;
                //JOptionPane.showMessageDialog(null,selectedCell[0]+"+"+selectedCell[1]);
                formula.setText((String) otherSide[selectedCell[0]][selectedCell[1]]);
                label.setText("Selected cell is " + (char)(Integer.valueOf('A') + col) + String.valueOf(row + 1));
            }
        };
        calculate = new JButton("Calculate");
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String temp = formula.getText();
                    otherSide[selectedCell[0]][selectedCell[1]] = temp;
                    int rows = tableModel.getRowCount();
                    int columns = tableModel.getColumnCount();
                    for (int i = 0; i < rows ; i++) {
                        for (int j = 0; j < columns; j++) {
                            try {
                                temp = String.valueOf(otherSide[i][j]);
                                String cell = String.valueOf('A' + j) + String.valueOf(i + 1);
                                HashSet<String> set = new HashSet<>();
                                set.add(cell);
                                temp = link(temp,set, otherSide);
                                tableModel.setValueAt(evaluate(temp),i,j);
                                set.remove(cell);
                            } catch (Exception ex) {
                                tableModel.setValueAt("ERROR",i,j);
                            }
                        }
                    }
                } catch (Exception ex) {
                    tableModel.setValueAt("ERROR",selectedCell[0],selectedCell[1]);
                }
            }
        });
        window1 = new JButton("Table");
        window1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window2 = new JButton("Menu");
                window2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Box contents = new Box(BoxLayout.Y_AXIS);
                        contents.add(close);
                        contents.add(load);
                        contents.add(save);
                        contents.add(window1);
                        contents.add(help);
                        setContentPane(contents);
                        setSize(200, 170);
                        setVisible(true);
                    }
                });
                Box contents1 = new Box(BoxLayout.Y_AXIS);
                contents1.add(close);
                contents1.add(window2);
                contents1.add(scroll);
                contents1.add(label);
                contents1.add(formula);
                contents1.add(calculate);
                setContentPane(contents1);
                setSize(700, 350);
                setVisible(true);
            }
        });
        load = new JButton("Load");
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fileName = JOptionPane.showInputDialog("Enter file name");
                    File file = new File(fileName);
                    //JOptionPane.showMessageDialog(null,file.exists());
                    if(file.exists()){
                        in = new FileInputStream(file);
                        BufferedReader bi = new BufferedReader(new InputStreamReader(in));
                        int rows = Integer.parseInt(bi.readLine());
                        int columns = Integer.parseInt(bi.readLine());
                        JOptionPane.showMessageDialog(null,rows + columns);
                        for (int i = 0; i < rows; i++) {
                            for (int j = 0; j < columns; j++) {
                                otherSide[i][j] = bi.readLine();
                            }
                        }
                        for (int i = 0; i < rows ; i++) {
                            for (int j = 0; j < columns; j++) {
                                try {
                                    String temp = String.valueOf(otherSide[i][j]);
                                    String cell = String.valueOf('A' + j) + String.valueOf(i + 1);
                                    HashSet<String> set = new HashSet<>();
                                    set.add(cell);
                                    temp = link(temp,set, otherSide);
                                    tableModel.setValueAt(evaluate(temp),i,j);
                                    set.remove(cell);
                                } catch (Exception ex) {
                                    tableModel.setValueAt("ERROR",i,j);
                                }
                            }
                        }
                    }
                    else throw new Exception();
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"ERROR: WRONG FILE NAME");
                }
                try {
                    in.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fileName = JOptionPane.showInputDialog("Enter file name");
                    String temp = fileName.substring(fileName.length() - 4);
                    //JOptionPane.showMessageDialog(null,temp + temp.length());
                    if (temp.equals(".txt")){
                        temp = "";
                        out = new FileOutputStream(fileName);
                        BufferedWriter bo = new BufferedWriter(new OutputStreamWriter(out));
                        bo.write(String.valueOf(tableModel.getRowCount()));
                        bo.newLine();
                        bo.write(String.valueOf(tableModel.getColumnCount()));
                        bo.newLine();
                        for (int i = 0; i < tableModel.getRowCount() ; i++) {
                            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                                bo.write(String.valueOf(otherSide[i][j]));
                                bo.newLine();
                            }
                        }
                        bo.close();
                    }
                    else throw new Exception();
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"ERROR: WRONG FILE NAME");
                }
            }
        });
        help = new JButton("Help");
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = "---HELP---\n";
                temp += "Available operations:\n";
                temp += "+ or - == add or subtract\n";
                temp += "/ or * == divide or multiply\n";
                temp += "^ == exponent\n";
                temp += "inc or dec == increment or decrement\n";
                temp += "max(x,y) or min(x,y) == maximum or minimum of x and y\n";
                temp += "(expr) == parenthesized expression\n";
                temp += "\n";
                temp += "Link to other cells example:  #A1 \n";
                JOptionPane.showMessageDialog(null, temp);
            }
        });
        table1 = new JTable(tableModel);
        table1.addMouseListener(tableMouseListener);
        table1.setEnabled(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Box contents = new Box(BoxLayout.Y_AXIS);
        JList rowHeader = new JList(lm);
        rowHeader.setFixedCellWidth(50);
        rowHeader.setFixedCellHeight(table1.getRowHeight());
        rowHeader.setCellRenderer(new RowHeaderRenderer(table1));
        scroll=new JScrollPane(table1);
        scroll.setRowHeaderView(rowHeader);
        contents.add(close);
        contents.add(load);
        contents.add(save);
        contents.add(window1);
        contents.add(help);
        setContentPane(contents);
        setSize(200, 170);
        setVisible(true);
    }
    public static void main(String[] args) {
        new App();
    }
}