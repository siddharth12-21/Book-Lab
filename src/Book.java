//A few assumptions.......

//Words will be separated by spaces. 
//There can be punctuation in a word, we will only add/keep punctuation at the end of a string if it is at the end of a string.
//    for examples: Hello.==> Ellohay.    Good-bye! ==> Ood-byegay!    so... ==> osay...

public class Book
{
  public String pigLatin(String word)
  {
    String word1 = word.toLowerCase();
    int inx = 0;
    String pigWord = "";
    if (word1.charAt(0)=='a'||word1.charAt(0)=='e'||word1.charAt(0)=='i'||word1.charAt(0)=='o'||word1.charAt(0)=='u')
    {
      pigWord = word1.substring(1,word.length())+word.substring(0,1)+"yay";
      return pigWord;
    }
    else
    {
      for (int i = 0; i<word1.length();i++){
        if (word1.charAt(i)=='a'||word1.charAt(i)=='e'||word1.charAt(i)=='i'||word1.charAt(i)=='o'||word1.charAt(i)=='u'){
          inx = i;
          break;
        }
      }
      int remain = word.length()-inx;
      String piggy = word1.substring(inx)+word1.substring(0,inx)+"ay";
      return piggy;
    }
  }
  
  public int endPunctuation(String word)  //return the index of where the punctuation is at the end of a String. If it is all punctuation return 0, if there is no punctuation return -1
  {

    return -1;
  }

  public String translateWord(String word)    //to share with class
  {
    String convertedWord = "";

    return convertedWord;
  }

  public String translateSentence(String sentence)
  {
    String retSentence = "";


    return retSentence;
  }
}  
