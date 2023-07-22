package Game;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args){
        int balance, bet;
        char contInput;
        char hitStandInput = 'x';
        int winnings;
        int bjresult = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Andrew's Blackjack in Java! ");
        System.out.print("To begin playing, type in your starting balance: ");
        while(true){
            try{
                balance = scan.nextInt();
                if(balance<=0){
                    throw new UnacceptableNumberException("");
                }
                break;
            }catch(UnacceptableNumberException nane){
                System.out.println("You cant have 0 or negative balance, try again");
                scan.nextLine();
            }catch(InputMismatchException e){
                System.out.println("That is not a number, try again");
                scan.nextLine();
            }
        }
        do{
            contInput = '0';
            System.out.println("Total balance: "+balance);
            System.out.print("Place your bet for the game: ");
            try{
                bet = scan.nextInt();
                if(bet<=0 || bet > balance){
                    throw new UnacceptableNumberException("");
                }
                balance -= bet;
                winnings = bet*2;
            }catch(InputMismatchException e){
                System.out.println("That is not a valid number, try again");
                scan.nextLine();
                continue;
            }catch(UnacceptableNumberException e2){
                System.out.println("This bet amount is invalid, (less than or equal to 0, or greater than balance): ");
                scan.nextLine();
                continue;
            }
            Dealer dealer = new Dealer();
            Player player = new Player();
            bjresult = player.BJchecker(dealer);
            switch(bjresult){
                case(1):
                    System.out.println(dealer+"\n\n");
                    dealer.start();
                    System.out.println("\n" + player);
                    System.out.println("\nYou got a Blackjack, you win 1.5x!");
                    balance += winnings+(bet*0.5);
                    break;
                case(-1):
                    System.out.println(dealer+"\n\n");
                    dealer.start();
                    System.out.println("\n" + player);
                    System.out.println("\nThe Dealer has a Blackjack, you lose!");
                    break;
                case(2):
                    System.out.println(dealer+"\n\n");
                    dealer.start();
                    System.out.println("\n" + player);
                    System.out.println("\nBoth of you have a Blackjack, you tied");
                    balance+=bet;
                    break;
            }
            while((hitStandInput != 'S' && hitStandInput != 's')){
                if(bjresult != 0){
                    break;
                }
                System.out.println("--------------------------------------------------------");
                System.out.println(dealer+"\n\n");
                System.out.println(player);
                System.out.println("\n--------------------------------------------------------");
                System.out.println("\n"+"Do you want to hit (h/H) or Stand (s/S)?: ");
                System.out.println("--------------------------------------------------------");
                hitStandInput = scan.next().charAt(0);
                scan.nextLine();
                if(hitStandInput == 'H' || hitStandInput == 'h'){
                    player.startingHand.hit();
                    if(player.startingHand.checkBust()){
                        break;
                    }
                }
            }
            hitStandInput = 'a';
            System.out.println("--------------------------------------------------------");
            while (bjresult == 0) {
                dealer.start();
                System.out.println("\n" + player);
                if (player.startingHand.checkBust()) {
                    System.out.print("\nYou busted, you lost " + bet + " dollars\n");
                } else if (dealer.startingHand.checkBust()) {
                    System.out.print("\nThe Dealer busted, you win " + winnings + " dollars!");
                    balance += (bet * 2);
                } else if (dealer.greaterThan(player)) {
                    System.out.print("\nThe dealer has a higher hand, you lost " + bet + " dollars");
                }else if(dealer.equalTo(player)){
                    System.out.println("\nYou both have the same value, you tied");
                    balance += bet;
                }else{
                    System.out.print("\nYou have a higher hand, you win " + winnings + " dollars!");
                    balance += winnings;
                }
                bjresult = -2;
            }
            System.out.print("\n--------------------------------------------------------");
            if(balance <= 0 ){
                System.out.println("\nYou have no more money, Game Over!");
                break;
            }
            System.out.println("\nYour Total balance: "+balance);
            System.out.print("\n\nDo you want to play another round? (Enter 'x/X' if you don't want to continue):");
            contInput = scan.next().charAt(0);
            }while(contInput != 'X' && contInput != 'x');
        System.out.println("Thanks for playing Andrew's blackjack project!");
        }
    }

