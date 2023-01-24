import java.util.Scanner;
class ATM {
    int ATM_ID = 272003;
    int ATM_PIN = 6072;
    int TRANSFER_ID = 124428;
    double Balance, amount1, amount2, amount3;

    Scanner sc = new Scanner(System.in);

    public void checkDetail(){
        System.out.println("\nWELCOME TO ATM MACHINE!!!");    
        System.out.print("Enter ATM_ID:");
        int atm_id = sc.nextInt();
        System.out.print("Enter ATM_PIN:");
        int pin = sc.nextInt();

        if((atm_id==ATM_ID) && (pin==ATM_PIN)){
            Command_menu();
        }
        else{
            System.out.println("ATM_ID or PIN is INCORRECT!! Enter a valid credential! Please Try Again!");
            checkDetail();
        }
    }

    public void Command_menu(){
        System.out.print("""
        \n***Command_menu***
        1.Transcation History 
        2.Withdraw
        3.Deposit 
        4.Transfer 
        5.Check Balance 
        6.Quit
        Enter Your Choice:""");

        char choice = sc.next().charAt(0);

        switch(choice){
            case '1' -> {
                System.out.println("Your Transaction History is as follows:");
                System.out.println("Current Balance is: "+Balance+
                             "\nWithdrawal ammount is:  -"+amount1+
                             "\nDeposited amount is:    +"+amount2+
                             "\nTransfered amount is:   -"+amount3);
                Command_menu();
            }
            case '2' -> {
                System.out.print("Enter Amount to Withdraw:");
                amount1 = sc.nextDouble();
                System.out.println(amount1);

                if(amount1 > Balance){
                    System.out.println("INSUFFICIENT BALANCE");
                }
                else{
                    Balance = Balance - amount1;
                    System.out.println("Money Withdraws Successfully!!");
                }
                Command_menu();
            }
            case '3' -> {
                System.out.print("Enter the Amount to be deposit:");
                amount2 = sc.nextDouble();
                Balance = Balance + amount2;
                System.out.println("Money Deposited Successfully!");
                Command_menu();
            }
            case '4' -> {
                System.out.print("Enter Transfer_ID: ");
                int transfer_id=sc.nextInt();
                if(transfer_id==TRANSFER_ID){
                    System.out.print("Enter Amount to be transmit:");
                    amount3 = sc.nextDouble();
                    if(amount3 < Balance){
                        System.out.println("Money Transmitted Successfully!");
                        Balance = Balance - amount3;
                        System.out.println("Your Balance is: "+Balance);
                    }
                    else{
                    System.out.println("INSUFFICIENT BALANCE!!\nTry Again!");
                    }
                }
                else{
                    System.out.println("Entered Transfer_ID is not matched!!\nTry Again!");
                }
                Command_menu();
            }
            case '5' -> {
                System.out.println("Balance: "+Balance);
                Command_menu();
            }
            case '6' -> {
                System.out.println("Thank you for using ATM!!\nCome Again!!\nHave a Great Day");
            }
            default ->{ 
                System.out.println("INVALID CHOICE!\nTry Again");
                Command_menu();
            }
        }
    }
}


public class ATMInterface {
    public static void main(String[] args) throws Exception {
        ATM at = new ATM();
        at.checkDetail();
    }
}
