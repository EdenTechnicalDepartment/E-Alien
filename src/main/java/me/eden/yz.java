package me.eden;

import dev.luminous.Alien;
import net.minecraft.client.MinecraftClient;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class yz {
    static String url = "http://edendun.online/api/mc/VerifyToken?token=";
    static String msg = "";
    public static void main() throws IOException {
        String key;
        key = showKeyInputDialog();
        if (key == null) {
            System.exit(0);
        }
        else {
            URL obj = new URL(url+key);
            System.out.printf(url+key);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // 设置请求方法
            con.setRequestMethod("GET");
            con.connect();
            int code = con.getResponseCode();
            if (code == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    msg += line;
                }
                reader.close();
            }
            con.disconnect();
        }
        String name = MinecraftClient.getInstance().getGameProfile().getName();
        System.out.println(!msg.equals(name));
        System.out.println(name);
        if (!msg.equals(name)){
            System.out.println("[" + Alien.NAME + "] 密钥验证失败");
            System.exit(0);
        }
        else{
            System.out.println("[" + Alien.NAME + "] 密钥验证成功");
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
