public class BuilderTest {
    public static void main(String[] args) {
        Computer basic = new Computer.Builder()
                              .setCPU("Intel i5")
                              .setRAM(8)
                              .build();
        Computer gaming = new Computer.Builder()
                              .setCPU("AMD Ryzen 9")
                              .setRAM(32)
                              .setStorage(1000)
                              .build();
        System.out.println(basic);
        System.out.println(gaming);
    }
}
