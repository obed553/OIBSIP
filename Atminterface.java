import java.util.Scanner;

class BankAccount {
    String name;
    String userName;
    String password;
    String accountNo;
    int prevTransaction;
    int balance = 200000;
    int transactions = 2;
    String transactionHistory = "";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Username: ");
        userName = sc.nextLine();
        System.out.print("Enter Password: ");
        password = sc.nextLine();
        System.out.print("Enter Account Number: ");
        accountNo = sc.nextLine();
        System.out.println("Registration Completed... Please Login To Proceed!!");
    }

    public void checkBalance() {
        System.out.println("Rs. " + balance);
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        Scanner receivers = new Scanner(System.in);
        int amount = receivers.nextInt();
        try {
            if (amount <= 100000) {
                transactions++;
                balance += amount;
                prevTransaction = amount;
                System.out.println("Successfully Deposited!!");
                String str = "Rs." + amount + " deposited\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("Sorry...Limit is Rs.100000.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        Scanner receivers = new Scanner(System.in);
        int amount = receivers.nextInt();
        try {
            if (balance >= amount) {
                transactions++;
                balance -= amount;
                prevTransaction = -amount;
                System.out.println("Withdrawal Successful!!");
                String str = "Rs." + amount + " withdrew\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("Insufficient Balance. Not possible for the withdrawal!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transfer() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Receiver's Name: ");
        String receiver = input.nextLine();
        System.out.print("Enter amount to transfer: ");
        int amount = input.nextInt();
        try {
            if (balance >= amount && amount <= 100000) {
                transactions++;
                balance -= amount;
                System.out.println(amount + " Successfully Transferred to " + receiver);
                String str = amount + " Rs. transferred to " + receiver + "\n";
                transactionHistory = transactionHistory.concat(str);
            } else if (amount > 100000) {
                System.out.println("Sorry!! Transfer limit is Rs.100000.");
            } else {
                System.out.println("Transfer failed due to insufficient balance!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getPrevTransaction() {
        if (prevTransaction > 0) {
            System.out.println("Deposited: " + prevTransaction);
        } else if (prevTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(prevTransaction));
        } else {
            System.out.println("No Transaction Occurred!");
        }
    }

    public void transHistory() {
        if (transactions == 0) {
            System.out.println("Empty!!");
        } else {
            System.out.println("\n" + transactionHistory);
        }
    }

    public boolean login() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Username: ");
            String enteredUsername = input.nextLine();
            if (enteredUsername.equals(userName)) {
                while (true) {
                    System.out.print("Enter Password: ");
                    String enteredPassword = input.nextLine();
                    if (enteredPassword.equals(password)) {
                        System.out.println("Login Success!!");
                        return true;
                    } else {
                        System.out.println("Incorrect Password...");
                    }
                }
            } else {
                System.out.println("Username not found.");
            }
        }
    }
}

public class InterfaceForATM {
    public static int takeIntegerInput(int limit) {
        int receiver1 = 0;
        boolean flag = false;
        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                receiver1 = sc.nextInt();
                if (receiver1 > limit || receiver1 < 1) {
                    System.out.println("Choose a number between 1 and " + limit + ".");
                } else {
                    flag = true;
                }
            } catch (Exception e) {
                System.out.println("Enter only an integer value.");
            }
        }
        return receiver1;
    }

    public static void main(String[] args) {
        System.out.println("----------- WELCOME TO ATM INTERFACE -----------\n");
        System.out.println("1.Register\n2.Exit");
        System.out.print("Enter your Choice: ");
        int choice = takeIntegerInput(2);
        if (choice == 1) {
            BankAccount account = new BankAccount();
            account.register();
            while (true) {
                System.out.println("\n1.Login\n2.Exit");
                System.out.print("Enter Your Choice: ");
                int ch = takeIntegerInput(2);
                if (ch == 1) {
                    if (account.login()) {
                        System.out.println("\n\n---------- WELCOME " + account.name + " ----------\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1.Check the Balance\n2.Deposit\n3.Withdraw\n4.Transfer\n5.Get the Last Transaction\n6.Get Full Transaction History\n7.Exit");
                            System.out.print("\nEnter Your Choice: ");
                            int c = takeIntegerInput(7);
                            switch (c) {
                                case 1:
                                    account.checkBalance();
                                    break;
                                case 2:
                                    account.deposit();
                                    break;
                                case 3:
                                    account.withdraw();
                                    break;
                                case 4:
                                    account.transfer();
                                    break;
                                case 5:
                                    account.getPrevTransaction();
                                    break;
                                case 6:
                                    account.transHistory();
                                    break;
                                case 7:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
