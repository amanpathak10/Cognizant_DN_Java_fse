public class ProxyPatternExample {
    interface Image { void display(); }
    static class RealImage implements Image {
        private final String url; RealImage(String u){ url=u; load(); }
        private void load(){ System.out.println("Loading " + url); }
        public void display(){ System.out.println("Displaying " + url); }
    }
    static class ProxyImage implements Image {
        private final String url; private RealImage real;
        ProxyImage(String u){ url=u; }
        public void display(){ if (real==null) real = new RealImage(url); real.display(); }
    }

    public static void main(String[] args){
        Image img = new ProxyImage("http://example.com/pic.jpg");
        img.display();
        img.display();
    }
}
