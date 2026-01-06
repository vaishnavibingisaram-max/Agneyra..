 import java.util.Scanner;
 
 //Account class
 class Account{
     private int pin;
     private double balance;
     
     //Constuctor
     public Account (int pin,double balance){
         this.pin=pin;
     }
     //Validate PIN 
     public boolean validatePin(int enteredPin){
         return this.pin==enteredPin;
     }
     
     //Check balance
     public double getBalance(){
         return balance;
     }
    //Deposit amount
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Amount deposited successfully.");
        }else{
            System.out.println("Invalid deposit amount.");
        }
    }
    
    //Withdraw amount
    public void withdraw(double amount){
        if(amount>0&& amount<=balance){
            balance-=amount;
            System.out.println("Please collect your cash.");
        }else if(amount>balance){
            System.out.println("Insufficient balance.");
        }else{
            System.out.println("Invalid withdrawal amount.");
        }    
      }  
 }  
   
    

    //Main ATM class 
      class ATMSimulation{
      public static void main(String[]args){
        
        Scanner sc = new Scanner(System.in);
        Account account=new Account(1234,6000.0);
        
        
        System.out.print("Enter your PIN:");
        int enteredPin = sc.nextInt();
        
        if(!account.validatePin(enteredPin)){
            System.out.println("Invalid PIN. Access denied");
            return;
        }
        
        int choice;
        do{
            System.out.println("\n=====ATM MENU=====");
            System.out.println("1.Check Balance");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Exit");
            System.out.println("Enter your choice:");
            choice=sc.nextInt();
            
            switch(choice){
                case 1:
                    System.out.println("Current Balance:₹"+account.getBalance());
                    break;
                    
                case 2:
                    System.out.print("Enter amount to deposit:");
                    double depositAmount=sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                    
                case 3:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount=sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                
                case 4:
                    System.out.println("Thank you for using the ATM:");
                    break;
                    
                    
                default:
                    System.out.println("Invalid choice.Please try again.");
            }
            }while(choice!=4);
            
            sc.close();
        }
}