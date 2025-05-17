package me.eden;

import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class main {
    String url = "http://edendun.online";
    public static void main(String[] args) {
        String key = null;
        key = showKeyInputDialog();
        if (key == null) {
            System.exit(0);
        }
    }

    public static String showKeyInputDialog() {
        // 创建输入框
        JTextField inputField = new JTextField(20);

        // 弹出对话框
        int option = JOptionPane.showConfirmDialog(
                null,
                inputField,
                "请输入密钥",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // 处理用户选择
        if (option == JOptionPane.OK_OPTION) {
            String key = inputField.getText();
            System.out.println("用户输入的密钥: " + key);
            return key;
        } else {
            return null;
        }
    }
}
