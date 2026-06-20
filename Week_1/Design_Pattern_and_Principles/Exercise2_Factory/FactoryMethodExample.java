public class FactoryMethodExample {
    interface Document { void info(); }
    static class WordDocument implements Document { public void info(){ System.out.println("Word doc"); } }
    static class PdfDocument implements Document { public void info(){ System.out.println("PDF doc"); } }
    static class ExcelDocument implements Document { public void info(){ System.out.println("Excel doc"); } }

    abstract static class DocumentFactory { abstract Document createDocument(); }
    static class WordFactory extends DocumentFactory { Document createDocument(){ return new WordDocument(); } }
    static class PdfFactory extends DocumentFactory { Document createDocument(){ return new PdfDocument(); } }
    static class ExcelFactory extends DocumentFactory { Document createDocument(){ return new ExcelDocument(); } }

    public static void main(String[] args) {
        DocumentFactory f1 = new WordFactory();
        DocumentFactory f2 = new PdfFactory();
        DocumentFactory f3 = new ExcelFactory();
        Document d1 = f1.createDocument(); d1.info();
        Document d2 = f2.createDocument(); d2.info();
        Document d3 = f3.createDocument(); d3.info();
    }
}
