class App {
  public static void main(String[] args) {
    Book aBook = new Book();
    System.out.println(aBook.pigLatin("book!"));
    System.out.println(aBook.translateWord("book"));
    System.out.println(aBook.endPunctuation("hello!"));
  }
}
