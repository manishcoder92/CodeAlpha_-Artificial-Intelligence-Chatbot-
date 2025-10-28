package chatbot;

import javax.swing.SwingUtilities;

public class ChatbotApplication {
    public static void main(String[] args) {
        System.out.println("=== IntelliBot Pro - Advanced AI Assistant ===");
        System.out.println("CodeAlpha Internship Project - Starting Application...");

        SwingUtilities.invokeLater(() -> {
            try {
                ChatbotGUI gui = new ChatbotGUI();
                gui.setVisible(true);
                System.out.println("IntelliBot Pro successfully launched!");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Error launching IntelliBot Pro: " + e.getMessage());
            }
        });
    }
}
