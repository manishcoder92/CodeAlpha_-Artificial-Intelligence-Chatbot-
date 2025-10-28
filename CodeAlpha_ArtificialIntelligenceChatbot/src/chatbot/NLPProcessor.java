package chatbot;

import java.util.*;

public class NLPProcessor {
    private Set<String> stopWords;

    public NLPProcessor() {
        initializeStopWords();
    }

    private void initializeStopWords() {
        stopWords = new HashSet<>(Arrays.asList(
                "the", "a", "an", "and", "or", "but", "in", "on", "at", "to",
                "for", "of", "with", "by", "is", "am", "are", "was", "were",
                "be", "been", "being", "have", "has", "had", "do", "does", "did"
        ));
    }

    public String extractIntent(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "general";
        }

        String lowerInput = input.toLowerCase();

        // Identity/Personal questions
        if (lowerInput.contains("name") || lowerInput.contains("who are you") ||
                lowerInput.contains("about you") || lowerInput.contains("your name")) {
            return "identity";
        }

        // Greetings
        if (lowerInput.contains("hello") || lowerInput.contains("hi") ||
                lowerInput.contains("hey") || lowerInput.contains("good morning") ||
                lowerInput.contains("good afternoon") || lowerInput.contains("good evening")) {
            return "greeting";
        }

        // Goodbye
        if (lowerInput.contains("bye") || lowerInput.contains("goodbye") ||
                lowerInput.contains("see you") || lowerInput.contains("exit") ||
                lowerInput.contains("quit")) {
            return "goodbye";
        }

        // Help
        if (lowerInput.contains("help") || lowerInput.contains("assist") ||
                lowerInput.contains("support") || lowerInput.contains("guide")) {
            return "help";
        }

        // Programming - General
        if (lowerInput.contains("java") || lowerInput.contains("programming") ||
                lowerInput.contains("code") || lowerInput.contains("coding")) {
            return "programming";
        }

        // Java Concepts - Specific
        if (lowerInput.contains("constructor") || lowerInput.contains("inheritance") ||
                lowerInput.contains("polymorphism") || lowerInput.contains("encapsulation") ||
                lowerInput.contains("abstraction") || lowerInput.contains("class") ||
                lowerInput.contains("object") || lowerInput.contains("method")) {
            return "java_concepts";
        }

        // Time/Date
        if (lowerInput.contains("time") || lowerInput.contains("date") ||
                lowerInput.contains("today") || lowerInput.contains("now") ||
                lowerInput.contains("current")) {
            return "datetime";
        }

        // Math/Calculation
        if (lowerInput.contains("calculate") || lowerInput.contains("math") ||
                lowerInput.contains("add") || lowerInput.contains("subtract") ||
                lowerInput.contains("multiply") || lowerInput.contains("divide")) {
            return "calculation";
        }

        // Casual conversation
        if (lowerInput.contains("chat") || lowerInput.contains("talk") ||
                lowerInput.contains("conversation") || lowerInput.contains("i am") ||
                lowerInput.contains("i'm") || lowerInput.contains("feeling")) {
            return "casual";
        }

        return "general";
    }

    public List<String> tokenizeAndClean(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new ArrayList<>();
        }

        List<String> tokens = new ArrayList<>();
        String cleaned = input.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = cleaned.split("\\s+");

        for (String word : words) {
            word = word.trim();
            if (!word.isEmpty() && !stopWords.contains(word)) {
                tokens.add(word);
            }
        }
        return tokens;
    }
}
