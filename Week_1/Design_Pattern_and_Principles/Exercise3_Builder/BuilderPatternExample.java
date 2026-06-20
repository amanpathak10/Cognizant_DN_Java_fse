public class BuilderPatternExample {
    static class Computer {
        private final String cpu; private final int ram; private final int storage;
        private Computer(Builder b){ cpu=b.cpu; ram=b.ram; storage=b.storage; }
        public String toString(){ return "CPU="+cpu+" RAM="+ram+"GB Storage="+storage+"GB"; }
        static class Builder {
            private String cpu; private int ram; private int storage;
            public Builder cpu(String c){ this.cpu=c; return this; }
            public Builder ram(int r){ this.ram=r; return this; }
            public Builder storage(int s){ this.storage=s; return this; }
            public Computer build(){ return new Computer(this); }
        }
    }
    public static void main(String[] args){
        Computer c = new Computer.Builder().cpu("Intel").ram(16).storage(512).build();
        System.out.println(c);
    }
}
