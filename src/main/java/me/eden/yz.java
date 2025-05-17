package me.eden;

import javax.swing.*;

public class yz {
    String url = "http://edendun.online";
    public static void main() {
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
