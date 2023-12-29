// Author:Sreelakshmi Odatt Venu
// Date : 12/28/2023

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoList extends JFrame {
    private DefaultListModel<String> tasksLists;
    private JList<String> tasksList;
    private JTextArea taskInput;

    public ToDoList() {
        setTitle("ToDo List ");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tasksLists = new DefaultListModel<>();
        tasksList = new JList<>(tasksLists);
        taskInput = new JTextArea(2, 10);
        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Remove Task");

        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText();
                if (!task.isEmpty()) {
                	tasksLists.addElement(task);
                    taskInput.setText("");
                }
            }
        });

     
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = tasksList.getSelectedIndex();
                if (selectedIndex != -1) {
                    tasksLists.remove(selectedIndex);
                }
            }
        });

       
        setLayout(new BorderLayout());
        add(new JScrollPane(tasksList), BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.add(taskInput);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        add(inputPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoList().setVisible(true);
            }
        });
    }
}

