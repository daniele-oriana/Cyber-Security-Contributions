package vigenere1457625;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VigenereCipher1457625 {

    public static void main(String[] args) throws IOException {

        String[] options = new String[]{"I want to encrypt", "I want to decrypt"};
        int response = JOptionPane.showOptionDialog(null, "", "Vigenere Chipher", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (response == 0) {
            JFrame frame = new JFrame("Vigenere Cipher");
            String name = JOptionPane.showInputDialog(null, "Insert the name of the file that contain the plaintext (without specify the .txt extension)");
            String plaintext = readFile(name + ".txt");
            String keyword = JOptionPane.showInputDialog(null, "Insert the keyword for the cipher");
            String ciphertext = encrypt(plaintext, keyword);
            JTextArea textArea1 = new JTextArea(26, 45);
            textArea1.setText("ENCRYPTED TEXT: \n" + ciphertext);
            textArea1.setEditable(false);
            JScrollPane scrollPane1 = new JScrollPane(textArea1);
            JOptionPane.showMessageDialog(frame, scrollPane1);
        } else if (response == 1) {
            JFrame frame = new JFrame("Vigenere Cipher");
            String name = JOptionPane.showInputDialog(null, "Insert the name of the file that contain the ciphertext (without specify the .txt extension)");
            String ciphertext = readFile(name + ".txt");
            String keyword = JOptionPane.showInputDialog(null, "Insert the keyword for the cipher");
            String back = decrypt(ciphertext, keyword);
            JTextArea textArea2 = new JTextArea(26, 45);
            textArea2.setText("DECRYPTED TEXT: \n" + back);
            textArea2.setEditable(false);
            JScrollPane scrollPane2 = new JScrollPane(textArea2);
            JOptionPane.showMessageDialog(frame, scrollPane2);
        }

        System.exit(0);
    }

    public static String encrypt(String plaintext, String keyword) {
        String ciphertext = "";
        plaintext = plaintext.toLowerCase();
        keyword = keyword.toLowerCase();
        for (int i = 0, j = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (c < 'a' || c > 'z') {
                continue;
            }
            ciphertext = ciphertext + (char) (((c - 97) + (keyword.charAt(j) - 97)) % 26 + 97);
            j = ++j % keyword.length();
        }
        return ciphertext;
    }

    public static String decrypt(String ciphertext, String keyword) {
        String plaintext = "";
        ciphertext = ciphertext.toLowerCase();
        keyword = keyword.toLowerCase();
        for (int i = 0, j = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if (c < 'a' || c > 'z') {
                continue;
            }
            plaintext = plaintext + (char) ((c - keyword.charAt(j) + 26) % 26 + 97);
            j = ++j % keyword.length();
        }
        return plaintext;
    }

    public static String readFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            br.close();
            return sb.toString();
        }
    }
}
