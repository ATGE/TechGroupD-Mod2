import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {

  /**
   * Read  file line by line and creates Sentence objects and putting them in a List.
   */
  public static List<Sentence> readFile(String filename) {
    List<Sentence> sentences = new ArrayList<>();

    if (filename != null) {
      File textFile = new File(filename);
      if (textFile.exists()) {
        try {
          Scanner scanner = new Scanner(textFile);
          while (scanner.hasNextLine()) {
            addValidSentence(sentences, scanner.nextLine());
          }
          scanner.close();

        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
      }
    }
    return sentences;
  }

  /**
   * Add a a valid Sentence  instance created from a text line at the List.
   */
  private static void addValidSentence(List sentences, String line) {

    Scanner lineScanner = new Scanner(line);
    try {
      int score = Integer.valueOf(lineScanner.next());
      String text = lineScanner.next() + lineScanner.nextLine();
      if (!text.isEmpty() && score >= -2 && score <= 2) {
        sentences.add(new Sentence(score, text));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates an Words Set from a  Sentence List.
   */
  public static Set<Word> allWords(List<Sentence> sentences) {

    Set<Word> words = new HashSet<>();

    if (sentences != null && !sentences.isEmpty()) {
      for (Sentence sentence : sentences) {
        if (sentence != null) {
          String[] tokens = sentence.getText().toLowerCase().split("\\s");
          for (String token : tokens) {
            if (Character.isLetter(token.charAt(0))) {
              Word word = new Word(token);
              word.increaseTotal(sentence.getScore());
              words.add(word);
            }
          }
        }
      }
    }

    return words;
  }

  /**
   * Calculates score for each Word in Set.
   */
  public static Map<String, Double> calculateScores(Set<Word> words) {

    Map<String, Double> wordScores = new HashMap<>();

    if (words != null && !words.isEmpty()) {

      for (Word word : words) {
        if (word != null) {
          wordScores.put(word.getText(), word.calculateScore());
        }
      }
    }

    return wordScores;

  }

  /**
   * Calculates the average score of all the words in a sentence.
   */
  public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

    double sentenceScore = 0;
    int count = 0;

    if (wordScores != null && !wordScores.isEmpty() && sentence != null && !sentence.isEmpty()) {
      String[] tokens = sentence.toLowerCase().split("\\s");
      for (String token : tokens) {
        if (Character.isLetter(token.charAt(0))) {
          if (wordScores.containsKey(token)) {
            sentenceScore += wordScores.get(token);
          }
          count++;
        }
      }
    }
    if (count != 0) {
      return sentenceScore / count;
    }
    return 0;

  }

  /**
   * This method is here to help you run your program. Y You may modify it as needed.
   */
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please specify the name of the input file");
      System.exit(0);
    }
    String filename = args[0];
    System.out.print("Please enter a sentence: ");
    Scanner in = new Scanner(System.in);
    String sentence = in.nextLine();
    in.close();
    List<Sentence> sentences = Analyzer.readFile(filename);
    Set<Word> words = Analyzer.allWords(sentences);
    Map<String, Double> wordScores = Analyzer.calculateScores(words);
    double score = Analyzer.calculateSentenceScore(wordScores, sentence);
    System.out.println("The sentiment score is " + score);
  }
}


