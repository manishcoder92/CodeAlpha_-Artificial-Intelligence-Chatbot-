package chatbot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class KnowledgeBase {
    private Map<String, List<String>> responses;
    private Map<String, String> detailedAnswers;
    private Random random;

    public KnowledgeBase() {
        responses = new HashMap<>();
        detailedAnswers = new HashMap<>();
        random = new Random();
        initializeSmartResponses();
        initializeDetailedAnswers();
    }

    private void initializeSmartResponses() {
        // FIXED: Using simple dash instead of unicode symbols
        responses.put("greeting", Arrays.asList(
                "Hello! Welcome to IntelliBot Pro!\n\nI can help you with:\n\n- Java programming fundamentals\n- Object-oriented programming concepts\n- Code explanations and examples\n- Mathematical calculations\n- Study guidance and career advice\n\nWhat topic would you like to explore today?",

                "Hi there! I'm IntelliBot - your professional coding companion!\n\nQuick suggestions to get started:\n\n- Ask \"what is java?\" for comprehensive overview\n- Try \"explain oop\" for object-oriented concepts\n- Say \"help with coding\" for programming guidance\n- Request \"study tips\" for learning strategies\n\nWhich area interests you most?",

                "Hey! Great to meet you!\n\nI excel at helping with:\n\n- Programming concepts and implementation\n- Technical problem-solving approaches\n- Code examples with detailed explanations\n- Academic and career guidance\n\nWhat would you like to explore first?"
        ));

        responses.put("general", Arrays.asList(
                "Interesting question! Here are some popular areas I can help with:\n\nTRENDING TOPICS:\n\n- Java programming basics and advanced concepts\n- Object-oriented programming principles\n- Code debugging and optimization techniques\n- Programming career development advice\n\nTry asking: \"explain inheritance\" or \"what is constructor\" for detailed explanations.",

                "I'd be happy to assist you! Here's what I specialize in:\n\nCORE EXPERTISE:\n\n- Java syntax and programming fundamentals\n- Problem-solving methodologies\n- Technical explanations with practical examples\n- Study planning and project guidance\n\nPopular questions include: \"java fundamentals\" or \"oop principles\"",

                "Great question! Let me suggest some key areas of expertise:\n\nHOT TOPICS:\n\n- Java fundamentals to advanced programming\n- Real-world coding examples and best practices\n- Technical interview preparation strategies\n- Software development project guidance\n\nFeel free to ask: \"help with java\" or \"career advice\""
        ));

        responses.put("identity", Arrays.asList(
                "I'm IntelliBot Pro - your dedicated programming mentor!\n\nMY SPECIALIZATIONS:\n\n- Breaking down complex Java concepts into simple terms\n- Providing real-world programming examples\n- Developing logical problem-solving approaches\n- Supporting your continuous learning journey\n\nFUN FACT: I'm designed to make programming education accessible and enjoyable!",

                "Hello! I'm IntelliBot - your intelligent AI programming assistant!\n\nWHAT MAKES ME UNIQUE:\n\n- Clear explanations in simple, understandable language\n- Practical examples for every concept discussed\n- Adaptive teaching style based on your needs\n- 24/7 availability for programming support\n\nDeveloped specifically for the CodeAlpha internship project!"
        ));

        responses.put("help", Arrays.asList(
                "IntelliBot Pro - Comprehensive Help Guide:\n\nPROGRAMMING ASSISTANCE:\n- 'java basics' - Core programming concepts\n- 'oop explained' - Object-oriented programming\n- 'code examples' - Practical implementation guides\n\nPROBLEM SOLVING:\n- '50 + 25' - Mathematical calculations\n- 'debug help' - Code troubleshooting assistance\n- 'logic building' - Programming methodology\n\nACADEMIC SUPPORT:\n- 'study plan' - Structured learning roadmap\n- 'career advice' - Industry guidance and tips\n- 'interview prep' - Technical preparation\n\nGENERAL SERVICES:\n- 'time now' - Current date and time\n- 'motivation' - Inspirational programming quotes\n- 'tech trends' - Latest industry developments\n\nSimply type any topic or question to begin!"
        ));

        responses.put("casual", Arrays.asList(
                "Excellent! I enjoy engaging in meaningful conversations!\n\nSINCE WE'RE CHATTING, here are some engaging topics:\n\n- Your current programming journey and experiences\n- Interesting coding projects you're developing\n- Technology trends that fascinate you\n- Professional goals and career aspirations\n\nWhat's currently on your mind today?",

                "Wonderful! Let's have an enriching discussion!\n\nI'M CURIOUS ABOUT:\n\n- What initially sparked your interest in programming?\n- Recent projects you've been working on\n- Programming challenges you're currently facing\n- Favorite technology companies or industry leaders\n\nFeel free to share anything you'd like to discuss!"
        ));

        responses.put("programming", Arrays.asList(
                "Programming is absolutely fascinating! Here's how I can help:\n\nPOPULAR REQUESTS:\n\n- 'explain java syntax' - Language fundamentals\n- 'oop with examples' - Object-oriented concepts\n- 'best practices' - Professional coding standards\n- 'project ideas' - Creative development suggestions\n\nQUICK START OPTIONS:\n\n- Ask about specific programming concepts\n- Request detailed code examples\n- Get professional debugging assistance\n- Discuss current industry trends\n\nWhich programming aspect interests you most?",

                "I'm passionate about discussing code and development!\n\nMY EXPERTISE INCLUDES:\n\n- Java fundamentals through advanced topics\n- Strategic problem-solving approaches\n- Code optimization and performance techniques\n- Real-world application development\n\nACADEMIC SUPPORT:\n\n- Concept explanations with practical examples\n- Technical interview question practice\n- Project development guidance and mentoring\n\nWhich area would you like to explore in depth?"
        ));

        responses.put("goodbye", Arrays.asList(
                "Thank you for our productive conversation! I hope today's assistance was valuable!\n\nREMEMBER: I'm always available when you need:\n\n- Java programming support and guidance\n- Detailed code explanations and examples\n- Academic study assistance and planning\n- Professional technology discussions\n\nSee you next time! Keep coding and learning!",

                "Goodbye! It's been a pleasure helping you today!\n\nQUICK REMINDER - I'm here 24/7 for:\n\n- Programming questions and solutions\n- Technical support and troubleshooting\n- Learning guidance and study strategies\n- Motivation and professional development tips\n\nCome back anytime. Happy coding!"
        ));
    }

    private void initializeDetailedAnswers() {
        detailedAnswers.put("time",
                "CURRENT DATE & TIME INFORMATION:\n\n" +
                        "Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy")) + "\n" +
                        "Time: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a")) + "\n" +
                        "Zone: IST (Indian Standard Time)\n\n" +
                        "How else can I assist you today?"
        );

        detailedAnswers.put("java",
                "JAVA PROGRAMMING LANGUAGE - COMPREHENSIVE OVERVIEW:\n\n" +
                        "WHAT IS JAVA?\n" +
                        "Java is a high-level, object-oriented programming language developed by Sun Microsystems (now Oracle Corporation) in 1995.\n\n" +
                        "KEY FEATURES & ADVANTAGES:\n\n" +
                        "Platform Independence\n" +
                        "  - \"Write Once, Run Anywhere\" capability\n" +
                        "  - Bytecode runs on any Java Virtual Machine\n\n" +
                        "Object-Oriented Programming\n" +
                        "  - Supports OOP principles\n" +
                        "  - Promotes code reusability and modularity\n\n" +
                        "Memory Management\n" +
                        "  - Automatic garbage collection\n" +
                        "  - Prevents memory leaks\n\n" +
                        "Security Features\n" +
                        "  - Built-in security mechanisms\n" +
                        "  - Bytecode verification\n\n" +
                        "REAL-WORLD APPLICATIONS:\n\n" +
                        "- Enterprise Applications (Banking, E-commerce)\n" +
                        "- Android Mobile Application Development\n" +
                        "- Web Applications (Spring Framework)\n" +
                        "- Desktop Applications (Swing, JavaFX)\n" +
                        "- Big Data Processing (Hadoop, Spark)\n\n" +
                        "CAREER ADVANTAGES:\n\n" +
                        "- High demand in global job market\n" +
                        "- Excellent salary prospects\n" +
                        "- Strong community support\n" +
                        "- Used by leading companies: Google, Amazon, Netflix\n\n" +
                        "BASIC PROGRAM STRUCTURE:\n\n" +
                        "public class HelloWorld {\n" +
                        "    public static void main(String[] args) {\n" +
                        "        System.out.println(\"Hello, World!\");\n" +
                        "    }\n" +
                        "}\n\n" +
                        "Would you like me to explain any specific aspect in more detail?"
        );

        detailedAnswers.put("oop",
                "OBJECT-ORIENTED PROGRAMMING (OOP) - COMPLETE GUIDE:\n\n" +
                        "DEFINITION:\n" +
                        "OOP is a programming paradigm based on 'objects' which contain data (attributes) and code (methods).\n\n" +
                        "THE FOUR FUNDAMENTAL PRINCIPLES:\n\n" +
                        "1. ENCAPSULATION\n" +
                        "   - Bundling data and methods within one unit\n" +
                        "   - Data hiding through access modifiers\n" +
                        "   - Controlled access via getter/setter methods\n\n" +
                        "2. INHERITANCE\n" +
                        "   - One class acquires properties of another\n" +
                        "   - Implemented using 'extends' keyword\n" +
                        "   - Promotes code reusability\n\n" +
                        "3. POLYMORPHISM\n" +
                        "   - Same interface, multiple implementations\n" +
                        "   - Method Overloading and Overriding\n" +
                        "   - Runtime and compile-time polymorphism\n\n" +
                        "4. ABSTRACTION\n" +
                        "   - Hiding internal implementation complexities\n" +
                        "   - Focus on essential features\n" +
                        "   - Achieved through abstract classes and interfaces\n\n" +
                        "BENEFITS OF OOP:\n\n" +
                        "- Enhanced Code Reusability\n" +
                        "- Easier Maintenance and Updates\n" +
                        "- Modular Programming Approach\n" +
                        "- Real-world Problem Modeling\n" +
                        "- Better Code Organization\n\n" +
                        "Would you like detailed examples of any specific OOP concept?"
        );
    }

    public String getResponse(String intent, String originalInput) {
        String lowerInput = originalInput.toLowerCase();

        // Time-specific check
        if (lowerInput.contains("time") && (lowerInput.contains("now") || lowerInput.contains("current") || lowerInput.contains("what"))) {
            return detailedAnswers.get("time");
        }

        // Check for detailed explanations
        for (String key : detailedAnswers.keySet()) {
            if (lowerInput.contains(key)) {
                return detailedAnswers.get(key);
            }
        }

        // Special handling for "what is" questions
        if (lowerInput.contains("what is")) {
            if (lowerInput.contains("java") && !lowerInput.contains("javascript")) {
                return detailedAnswers.get("java");
            }
            if (lowerInput.contains("oop") || lowerInput.contains("object oriented")) {
                return detailedAnswers.get("oop");
            }
        }

        // Handle OOP variations
        if (lowerInput.equals("oop") || lowerInput.equals("oops") ||
                lowerInput.contains("object oriented")) {
            return detailedAnswers.get("oop");
        }

        // Regular responses
        List<String> intentResponses = responses.get(intent);
        if (intentResponses != null && !intentResponses.isEmpty()) {
            return intentResponses.get(random.nextInt(intentResponses.size()));
        }

        return "I'd be happy to provide a comprehensive explanation! Could you be more specific? I specialize in Java programming concepts, technical explanations, and professional development guidance.";
    }

    public String getResponse(String intent) {
        return getResponse(intent, "");
    }
}
