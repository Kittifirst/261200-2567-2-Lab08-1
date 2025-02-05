import java.util.Random;

class Counternumber implements Runnable {
    private int threadNumber;
    private static final Random random = new Random();

    public Counternumber(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("Thread #" + threadNumber + ": " + i);
            try {
                Thread.sleep(random.nextInt(91) + 10);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Counternumber(1));
        Thread t2 = new Thread(new Counternumber(2));
        Thread t3 = new Thread(new Counternumber(3));
        t1.start();
        t2.start();
        t3.start();
    }
}

//  ก่อนใส่ Thread: เธรดจะทำงานเร็วมากจนตัวเลขอาจสลับกันแบบไม่เป็นระเบียบ
//  หลังใส่ Thread.sleep(): เธรดแต่ละตัวจะหน่วงเวลา ทำให้แสดงผลตัวเลขเป็นลำดับเข้าใจง่ายขึ้น