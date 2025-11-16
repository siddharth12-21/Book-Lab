//A few assumptions.......

//Words will be separated by spaces. 
//There can be punctuation in a word, we will only add/keep punctuation at the end of a string if it is at the end of a string.
//    for examples: Hello.==> Ellohay.    Good-bye! ==> Ood-byegay!    so... ==> osay...
import java.io.IOException;
import java.util.Scanner;
import java.net.URL;
import java.io.PrintWriter;
import java.io.File;

public class Book
{
  public String book;
  public Book(String url){
    readBook(url);
  }
  private File readBook(String link){
    try{
      int counter = 0;
      URL url = new URL(link);
      Scanner s = new Scanner(url.openStream());
      File translated = new File("translated.txt");
      PrintWriter writer = new PrintWriter(translated);
      while(s.hasNext()){
        String text = s.nextLine();
        String words[]=text.split(" ");
        counter += words.length;
        text = translateSentence(text);
        System.out.println(text);
        book+=text;
        writer.println(text);
      }
      writer.close();
      System.out.println();
      System.out.println("Total words: " + counter);
      return translated;
    }
    catch(IOException ex){
      ex.printStackTrace();
      return null;
    }
  }
  public String pigLatin(String word)
  {
    String word1 = word.toLowerCase();
    int inx = 0;
    String digits = "0123456789";
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String pigWord = "";
    //empty string case
    if (word1.length()==0){
      return word;
    }
    //digit start case
    if (digits.indexOf(word1.charAt(0))>=0){
      return word;
    }
    //vowel start case
    if (word1.charAt(0)=='a'||word1.charAt(0)=='e'||word1.charAt(0)=='i'||word1.charAt(0)=='o'||word1.charAt(0)=='u'||word1.charAt(0)=='y')
    {
      pigWord = word1+"yay";
      return pigWord;
    }
    //special character start case
    if (word1.charAt(0)=='“'||word1.charAt(0)=='(')
    {
      return word1.substring(0,1)+finalWordTranslation(word1.substring(1,word.length()));
    }
    // only special character:
    if (alphabet.indexOf(word1.charAt(0))<0){
      return word;
    }

    //normal consonant start case
    else
    {
      for (int i = 0; i<word1.length();i++){
        if (word1.charAt(i)=='a'||word1.charAt(i)=='e'||word1.charAt(i)=='i'||word1.charAt(i)=='o'||word1.charAt(i)=='u'){
          inx = i;
          break;
        }
      }
      String piggy = word1.substring(inx)+word1.substring(0,inx)+"ay";
      return piggy;
    }
  }
  public String finalWordTranslation(String word)  //return the index of where the punctuation is at the end of a String. If it is all punctuation return 0, if there is no punctuation return -1
  {
    int ender = 0;
    String punc = "";
    for (int i=0; i<word.length();i++){
      if (word.charAt(i)=='!'||word.charAt(i)=='?'||word.charAt(i)=='.'||word.charAt(i)==','||word.charAt(i)==':'||word.charAt(i)==';'){
        ender = i;
        break;
      }
      else{
        ender=-1;
      }
    }
    if (ender==-1){
      return capitalizeWord(word);
    }
    else{
      punc = word.substring(ender,word.length());
      String only = word.substring(0,ender);
      String only1 = capitalizeWord(only);
      String only2 = only1 + punc;
      return only2;
    }
  }
  public String capitalizeWord(String word)    //to share with class
  {
    String convertedWord = pigLatin(word);
    if (word.toUpperCase().equals(word) && word.length()>1){
      String uppered = convertedWord.toUpperCase();
      return uppered;
    }
    if (word.length()==0){
      return "";
    }
    else if (Character.isUpperCase(word.charAt(0))==true){
      String firstLetter = convertedWord.substring(0,1);
      String rest = convertedWord.substring(1,convertedWord.length());
      String capitalized = firstLetter.toUpperCase()+rest;
      return capitalized;
    }
    else if((word.charAt(0)=='“'||word.charAt(0)=='(' && Character.isUpperCase(word.charAt(1))==true)){
      String firstLetter = convertedWord.substring(1,2);
      String rest = convertedWord.substring(2,convertedWord.length());
      String capitalized = word.charAt(0)+firstLetter.toUpperCase()+rest;
      return capitalized;
    }
    else{
      return convertedWord;
    }
  }
  public String translateSentence(String sentence)
  {
    int wordCount = 0;
    String retSentence = "";
    sentence = sentence + " ";
    String word = "";
    if (sentence.length()==0){
      return "";
    }
    else{
      for(int i =0; i<sentence.length();i++){
        if(sentence.charAt(i)==' '){
          word = sentence.substring(0,i);
          wordCount++;
          retSentence = retSentence + finalWordTranslation(word) + " ";
          word = "";
          sentence = sentence.substring(i+1);
          i=0;
        }
      }
      return retSentence;
    } 
  }
}  
