package bq3;
import bq3.*;
import bq3.Entity.Armnew;
import bq3.Entity.Player;

/*
 * Once a strategic point is defended successfully, the strategic point will be removed. Users can choose different
 * factions with their armies once they start the game.After the end of the limited rounds, the player who occupies
 * more strategic points wins.
 * */
public class end {
    private int getPlayerCost(Player player){
        return player.getCost();
    }
    private Player getWinner(Player player1, Player player2){
        return player1.getCost()>player2.getCost()?player1:player2;
    }

    private void displayArms(Player player){
        Armnew[] armlist = player.getArmlist();
        System.out.println("Here is your arms");
        for (Armnew armnew : armlist) {
            System.out.println(armnew);
            System.out.println(armnew.getHp());
            System.out.println(armnew.getMovementTotal());
        }
    }

    private void displayNation(Player player){
        System.out.println(player.getNation());
    }

    private void display(Player player1, Player player2){
        System.out.println("Here is the players' information:");
        displayArms(player1);
        displayNation(player1);
        System.out.println("=======================");
        displayNation(player2);
        displayArms(player2);
        System.out.println("=======================");
        System.out.println("The winner is:");
        System.out.println(getWinner(player1, player2));
    }
}
