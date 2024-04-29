import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userName, password;
        Scanner input = new Scanner(System.in);
        int right = 3; // Allowed attemps
        int balance = 1500;
        int select;
        while (right > 0) {

            // Asking username and password info.
            System.out.print("Kullanıcı Adınız :");
            userName = input.nextLine();
            System.out.print("Parolanız : ");
            password = input.nextLine();

            // Correct information check.
            if (userName.equals("patika") && password.equals("dev123")) {
                System.out.println("Merhaba, E Bank'a Hoşgeldiniz!");

                do {
                    System.out.println("1-Para yatırma\n" + // Deposit money
                            "2-Para Çekme\n" + // Withdraw money
                            "3-Bakiye Sorgula\n" + // Check balance
                            "4-Çıkış Yap"); //Exit
                    System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz : ");
                    select = input.nextInt();

                    switch (select) {
                        case 1:// Deposit money operation.
                            System.out.print("Yatırmak İstediğiniz Para miktarı : ");
                            int depositAmount = input.nextInt();
                            balance += depositAmount;
                            System.out.println("Güncel Bakiyeniz: " + balance); //showing the updated balance
                            break;
                        case 2:// Withdraw money operation.
                            System.out.print("Çekmek İstediğiniz Para miktarı : ");
                            int withdrawAmount = input.nextInt();
                            if (withdrawAmount > balance) {
                                System.out.println("Bakiye yetersiz.");
                            } else {
                                balance -= withdrawAmount;
                                System.out.println("Güncel Bakiyeniz:" + balance ); //showing updated balance
                            }
                            break;
                        case 3:// Check balance.
                            System.out.println("Bakiyeniz : " + balance);
                            break;
                        case 4://Exit
                            System.out.println("Tekrar görüşmek üzere.");
                            break;
                        default:
                            System.out.println("Geçersiz işlem. Lütfen tekrar deneyiniz.");
                            break;
                    }
                } while (select != 4);
                break;
            } else {
                right --;

                System.out.println("Hatalı kullanıcı adı veya şifre. Tekrar deneyiniz.");
                if (right == 0) {
                    System.out.println("Hesabınız bloke olmuştur lütfen banka ile iletişime geçiniz.");
                } else {
                    System.out.println("Kalan Hakkınız : " + right);// Remaining attempts for the user.
                }
            }
        }
    }
}