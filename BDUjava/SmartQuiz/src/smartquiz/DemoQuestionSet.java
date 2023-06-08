//Demo Question set
package smartquiz;

public class DemoQuestionSet {

    public String Call_Question(int questionNumber) {
        String[] questions = {
            "What is the capital city of Bangladesh?",
            "Which river forms the southern boundary of Bangladesh?",
            "Which language is predominantly spoken in Bangladesh?",
            "What is the national flower of Bangladesh?",
            "Which of the following is the national animal of Bangladesh?",
            "Which sea borders Bangladesh to the south?",
            "Who is considered the founding father of Bangladesh?",
            "Which sport is the most popular in Bangladesh?",
            "What is the currency of Bangladesh?",
            "Which UNESCO World Heritage Site is located in Bangladesh?"
        };
        return questions[questionNumber - 1];
    }

    public String Call_Option(int questionNumber, int optionNumber) {
        String[][] options = {
            {"Dhaka", "Chittagong", "Khulna", "Rajshahi"},
            {"Brahmaputra", "Padma", "Ganges", "Meghna"},
            {"Bengali", "Urdu", "Hindi", "English"},
            {"Rose", "Lotus", "Jasmine", "Sunflower"},
            {"Royal Bengal Tiger", "Elephant", "Deer", "Lion"},
            {"Indian Ocean", "Arabian Sea", "Bay of Bengal", "Coral Sea"},
            {"Sheikh Hasina", "Sheikh Mujibur Rahman", "Ziaur Rahman", "Khaleda Zia"},
            {"Cricket", "Football", "Badminton", "Tennis"},
            {"Rupee", "Taka", "Rupiah", "Dollar"},
            {"Great Barrier Reef", "Angkor Wat", "Sundarbans", "Taj Mahal"}
        };
        return options[questionNumber - 1][optionNumber - 1];

    }

    public String Call_Answers(int answerNumber) {
        String[] answers = {
            "[A]", "[D]", "[A]", "[B]", "[A]","[C]","[B]", "[A]", "[B]","[C]"
        };
        return answers[answerNumber - 1];
    }
}
