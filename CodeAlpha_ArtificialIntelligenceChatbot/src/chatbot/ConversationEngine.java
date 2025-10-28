package chatbot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConversationEngine {
    private NLPProcessor nlpProcessor;
    private KnowledgeBase knowledgeBase;

    public ConversationEngine(NLPProcessor nlpProcessor, KnowledgeBase knowledgeBase) {
        this.nlpProcessor = nlpProcessor;
        this.knowledgeBase = knowledgeBase;
    }

    public String processInput(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            return "I didn't catch that. Please say something! I'm here to help with programming, general questions, or friendly conversation!";
        }

        String trimmedInput = userInput.trim();

        // Handle mathematical expressions first
        if (isMathExpression(trimmedInput)) {
            return handleMathCalculation(trimmedInput);
        }

        // Extract intent using NLP
        String intent = nlpProcessor.extractIntent(trimmedInput);

        // Get intelligent response
        return knowledgeBase.getResponse(intent, trimmedInput);
    }

    private boolean isMathExpression(String input) {
        return input.matches(".*\\d+\\s*[+\\-*/]\\s*\\d+.*") ||
                input.toLowerCase().contains("calculate") ||
                input.toLowerCase().contains("solve") ||
                Pattern.compile("\\b\\d+\\s*[+\\-*/]\\s*\\d+\\b").matcher(input).find();
    }

    private String handleMathCalculation(String input) {
        Pattern basicMath = Pattern.compile("(\\d+(?:\\.\\d+)?)\\s*([+\\-*/])\\s*(\\d+(?:\\.\\d+)?)");
        Matcher matcher = basicMath.matcher(input);

        if (matcher.find()) {
            try {
                double num1 = Double.parseDouble(matcher.group(1));
                String operator = matcher.group(2);
                double num2 = Double.parseDouble(matcher.group(3));

                double result = 0;
                String operation = "";

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        operation = "addition";
                        break;
                    case "-":
                        result = num1 - num2;
                        operation = "subtraction";
                        break;
                    case "*":
                        result = num1 * num2;
                        operation = "multiplication";
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                            operation = "division";
                        } else {
                            return "ERROR: Division by Zero\n\nDivision by zero is undefined in mathematics! Please try a different calculation.";
                        }
                        break;
                }

                String resultFormatted = (result == (long) result) ?
                        String.format("%.0f", result) :
                        String.format("%.2f", result);

                return String.format("CALCULATION RESULT:\n\nThe %s of %.2f %s %.2f = %s\n\nNeed more calculations? Just ask!",
                        operation, num1, operator, num2, resultFormatted);

            } catch (NumberFormatException e) {
                return "I had trouble parsing those numbers. Please try: 10 + 5 or 25.5 * 2";
            }
        }

        return "I can help with calculations! Try: 15 + 25, 100 - 35, 12 * 8, 144 / 12";
    }
}
