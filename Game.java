package Game;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args){
        int balance, bet;
        char contInput;
        char hitStandInput = 'x';
        int winnings;
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
            while((hitStandInput != 'S' && hitStandInput != 's')){
                System.out.println("--------------------------------------------------------");
                System.out.println(dealer+"\n");
                System.out.println();
                System.out.println(player+"\n\n"+"Do you want to hit (h/H) or Stand (s/S)?: ");
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
            dealer.start();
            System.out.println(player);
            if(player.startingHand.checkBust()){
                System.out.print("\nYou Busted, you lost "+bet+" dollars\n");
            }else if(dealer.startingHand.checkBust()){
                System.out.print("\nThe Dealer Busted, you win "+winnings+" dollars!");
                balance+=(bet*2);
            }else if(dealer.greaterThan(player)){
                System.out.print("\nThe dealer has a higher hand, you lost "+bet+" dollars");
            }else{
                System.out.print("\nYou have a higher hand, you win "+winnings+" dollars!");
                balance+=(bet*2);
            }
            System.out.print("\n--------------------------------------------------------");
            if(balance <= 0 ){
                System.out.println("\nYou lost all your money, Game Over!");
                break;
            }
            System.out.println("\nYour Total balance: "+balance);
            System.out.print("\n\nDo you want to play another round? (Enter 'x/X' if you don't want to continue)");
            contInput = scan.next().charAt(0);
            }while(contInput != 'X' && contInput != 'x');
        System.out.println("Thanks for playing my blackjack project!");
        }
    }

