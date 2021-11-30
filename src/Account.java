public class Account {
    int balance;

    public Account() {
        balance = 10000;
    }

    public void withdraw(int val)
    {    syncronised(this);
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException obj) {
                System.out.println("hello");
            }
            balance = balance - val;
            System.out.println(balance);
        }
    }

    private void syncronised(Account account) {
    }
}
class Mythread extends Thread{
    Account obj;
    public Mythread(Account tobj){
        obj = tobj;
    }
    public void run() {
        obj.withdraw(500);
    }
}
class Test {
    public static void main(String[] args) {
        Account obj = new Account();
        Mythread obj1=new Mythread(obj);
        Mythread obj2 =new Mythread(obj);
        obj1.start();
        obj2.start();
    }
}