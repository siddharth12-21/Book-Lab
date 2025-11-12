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
    String digits = "0123456789";
    String pigWord = "";
    if (word1.length()==0){
      return word;
    }
    if (digits.indexOf(word1.charAt(0))>=0){
      return word;
    }
    if (word1.charAt(0)=='a'||word1.charAt(0)=='e'||word1.charAt(0)=='i'||word1.charAt(0)=='o'||word1.charAt(0)=='u'||word1.charAt(0)=='y')
    {
      pigWord = word1+"yay";
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
      String piggy = word1.substring(inx)+word1.substring(0,inx)+"ay";
      return piggy;
    }
  }
  
  public String finalWordTranslation(String word)  //return the index of where the punctuation is at the end of a String. If it is all punctuation return 0, if there is no punctuation return -1
  {
    int ender = 0;
    String punc = "";
    for (int i=0; i<word.length();i++){
      if (word.charAt(i)=='!'||word.charAt(i)=='?'||word.charAt(i)=='.'||word.charAt(i)==','||word.charAt(i)==':'||word.charAt(i)==';'||word.charAt(i)=='"'){
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
    if (Character.isUpperCase(word.charAt(0))==true){
      String firstLetter = convertedWord.substring(0,1);
      String rest = convertedWord.substring(1,convertedWord.length());
      String capitalized = firstLetter.toUpperCase()+rest;
      return capitalized;
    }
    else{
      return convertedWord;
    }
  }

  public String translateSentence(String sentence)
  {
    String retSentence = "";


    return retSentence;
  }
}  
