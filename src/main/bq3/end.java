package bq3;
/*
 * Once a strategic point is defended successfully, the strategic point will be removed. Users can choose different
 * factions with their armies once they start the game.After the end of the limited rounds, the player who occupies
 * more strategic points wins.
 * */
public class Settlement {
    private int getPlayerCost(Player player){
        return player.getCost();
    }
    private Player getWinner(Player player1, Player player2){
        return player1.getCost()>player2.getCost()?player1:player2;
    }
}