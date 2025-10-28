package chatbot;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatbotGUI extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private JButton clearButton;
    private JLabel statusLabel;
    private NLPProcessor nlpProcessor;
    private KnowledgeBase knowledgeBase;
    private ConversationEngine conversationEngine;

    // Professional Colors
    private final Color HEADER_COLOR = new Color(52, 73, 94);
    private final Color BUTTON_COLOR = new Color(74, 144, 226);
    private final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private final Color CLEAR_COLOR = new Color(231, 76, 60);
    private final Color BACKGROUND_COLOR = new Color(240, 242, 245);
    private final Color TEXT_COLOR = new Color(50, 50, 50);

    public ChatbotGUI() {
        nlpProcessor = new NLPProcessor();
        knowledgeBase = new KnowledgeBase();
        conversationEngine = new ConversationEngine(nlpProcessor, knowledgeBase);

        initializeGUI();
        addWelcomeMessage();
    }

    private void initializeGUI() {
        setTitle("IntelliBot Pro - Advanced AI Programming Assistant | CodeAlpha Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(true);

        createHeaderPanel();
        createChatArea();
        createBottomPanel();
        setupEventListeners();

        setMinimumSize(new Dimension(700, 500));
    }

    private void createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(HEADER_COLOR);
        headerPanel.setBorder(new EmptyBorder(20, 25, 20, 25));
        headerPanel.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(HEADER_COLOR);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("IntelliBot Pro");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subtitleLabel = new JLabel("Advanced AI Programming Assistant");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitleLabel.setForeground(new Color(189, 195, 199));
        subtitleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel brandLabel = new JLabel("CodeAlpha Internship Project 2025");
        brandLabel.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        brandLabel.setForeground(new Color(149, 165, 166));
        brandLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        titlePanel.add(titleLabel);
        titlePanel.add(Box.createVerticalStrut(3));
        titlePanel.add(subtitleLabel);
        titlePanel.add(Box.createVerticalStrut(2));
        titlePanel.add(brandLabel);

        // FIXED: Remove the star symbol from status
        JPanel statusPanel = new JPanel();
        statusPanel.setBackground(HEADER_COLOR);
        statusPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JLabel statusDot = new JLabel("●");  // This will work as it's a simple bullet
        statusDot.setFont(new Font("Arial", Font.BOLD, 20));
        statusDot.setForeground(SUCCESS_COLOR);

        JLabel statusText = new JLabel("AI Online");  // FIXED: Removed the * symbol
        statusText.setFont(new Font("Segoe UI", Font.BOLD, 14));
        statusText.setForeground(Color.WHITE);

        statusPanel.add(statusDot);
        statusPanel.add(Box.createHorizontalStrut(5));
        statusPanel.add(statusText);

        headerPanel.add(titlePanel, BorderLayout.WEST);
        headerPanel.add(statusPanel, BorderLayout.EAST);

        add(headerPanel, BorderLayout.NORTH);
    }

    // ... rest of the ChatbotGUI code remains the same ...

    private void createChatArea() {
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        chatArea.setBackground(Color.WHITE);
        chatArea.setForeground(TEXT_COLOR);
        chatArea.setBorder(new EmptyBorder(20, 20, 20, 20));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setBackground(new Color(230, 230, 230));

        JPanel chatPanel = new JPanel(new BorderLayout());
        chatPanel.setBorder(new EmptyBorder(15, 15, 10, 15));
        chatPanel.setBackground(BACKGROUND_COLOR);
        chatPanel.add(scrollPane, BorderLayout.CENTER);

        add(chatPanel, BorderLayout.CENTER);
    }

    private void createBottomPanel() {
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(BACKGROUND_COLOR);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(new EmptyBorder(10, 20, 15, 20));
        inputPanel.setBackground(BACKGROUND_COLOR);

        inputField = new JTextField();
        inputField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        inputField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 2),
                new EmptyBorder(12, 16, 12, 16)
        ));
        inputField.setBackground(Color.WHITE);
        inputField.setForeground(TEXT_COLOR);

        inputField.setText("Type your message here...");
        inputField.setForeground(Color.GRAY);

        inputField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (inputField.getText().equals("Type your message here...")) {
                    inputField.setText("");
                    inputField.setForeground(TEXT_COLOR);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (inputField.getText().trim().isEmpty()) {
                    inputField.setText("Type your message here...");
                    inputField.setForeground(Color.GRAY);
                }
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        buttonPanel.setBackground(BACKGROUND_COLOR);

        clearButton = new JButton("Clear Chat");
        clearButton.setBackground(CLEAR_COLOR);
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        clearButton.setBorder(new EmptyBorder(12, 18, 12, 18));
        clearButton.setFocusPainted(false);
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        sendButton = new JButton("Send Message");
        sendButton.setBackground(BUTTON_COLOR);
        sendButton.setForeground(Color.WHITE);
        sendButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        sendButton.setBorder(new EmptyBorder(12, 24, 12, 24));
        sendButton.setFocusPainted(false);
        sendButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        addButtonHoverEffect(clearButton, CLEAR_COLOR);
        addButtonHoverEffect(sendButton, BUTTON_COLOR);

        buttonPanel.add(clearButton);
        buttonPanel.add(sendButton);

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(buttonPanel, BorderLayout.EAST);

        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBackground(HEADER_COLOR);
        statusPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        statusLabel = new JLabel("Ready to assist | Type 'help' for guidance");
        statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        statusLabel.setForeground(new Color(189, 195, 199));

        JLabel timeLabel = new JLabel();
        timeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        timeLabel.setForeground(new Color(189, 195, 199));

        Timer timer = new Timer(1000, e -> {
            timeLabel.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
        });
        timer.start();

        statusPanel.add(statusLabel, BorderLayout.WEST);
        statusPanel.add(timeLabel, BorderLayout.EAST);

        bottomPanel.add(inputPanel, BorderLayout.NORTH);
        bottomPanel.add(statusPanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void addButtonHoverEffect(JButton button, Color originalColor) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(originalColor.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(originalColor);
            }
        });
    }

    private void setupEventListeners() {
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearChat();
            }
        });

        inputField.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    private void sendMessage() {
        String userInput = inputField.getText().trim();

        if (userInput.isEmpty() || userInput.equals("Type your message here...")) {
            return;
        }

        appendMessage("YOU", userInput);

        statusLabel.setText("Processing your request...");
        sendButton.setEnabled(false);

        SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                Thread.sleep(300);
                return conversationEngine.processInput(userInput);
            }

            @Override
            protected void done() {
                try {
                    String botResponse = get();
                    appendMessage("INTELLIBOT PRO", botResponse);
                } catch (Exception e) {
                    appendMessage("INTELLIBOT PRO",
                            "Sorry, I encountered an error processing your request. Please try again!");
                    e.printStackTrace();
                }

                statusLabel.setText("Ready to assist | Type 'help' for guidance");
                sendButton.setEnabled(true);

                inputField.setText("");
                inputField.setForeground(TEXT_COLOR);
                inputField.requestFocus();
            }
        };

        worker.execute();
    }

    private void clearChat() {
        int result = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to clear the chat history?",
                "Clear Chat",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (result == JOptionPane.YES_OPTION) {
            chatArea.setText("");
            addWelcomeMessage();
            statusLabel.setText("Chat cleared - Ready to assist");
        }
    }

    private void appendMessage(String sender, String message) {
        SwingUtilities.invokeLater(() -> {
            if (sender.equals("YOU")) {
                chatArea.append("\n>> You: " + message + "\n");
            } else if (sender.equals("INTELLIBOT PRO")) {
                chatArea.append("\n>> IntelliBot: " + message + "\n");
            } else {
                chatArea.append("\n>> " + sender + ": " + message + "\n");
            }

            chatArea.setCaretPosition(chatArea.getDocument().getLength());
        });
    }

    private void addWelcomeMessage() {
        appendMessage("INTELLIBOT PRO",
                "Hello! I'm IntelliBot Pro - your professional programming assistant!\n\n" +
                        "I specialize in Java programming, technical problem-solving, and educational support.\n" +
                        "Feel free to ask me anything to begin our conversation!"
        );
    }
}
