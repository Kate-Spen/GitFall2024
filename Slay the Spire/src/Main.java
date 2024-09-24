import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //generates random integer for the deck id number
        Random rand = new Random();
        int min = 100000000;
        int max = 999999999;
        int deckID = rand.nextInt((max - min) + 1) + min;

        //creates lists for the cards' names and costs
        String card = new String();
        File cardList = new File("/Users/kate/Desktop/remote repos/Slay the Spire/Slay the Spire/src/cardList.txt");
        ArrayList<String> cardNames = new ArrayList<String>();
        ArrayList<Integer> cardCosts = new ArrayList<Integer>();
        ArrayList<String> invalidCards = new ArrayList<String>();

        //scans through the txt file and puts the names and costs into their own lists
        Scanner sc = new Scanner(cardList);
        while (sc.hasNextLine()) {
            card = sc.nextLine();
            if(card.isEmpty()){
                invalidCards.add(card);
            }else {
                String[] parts = card.split(":");
                String cardName = parts[0];
                String cardCost = parts[1];
                int num = Integer.valueOf(cardCost);
                cardNames.add(cardName);
                cardCosts.add(num);
            }
        }
        int sum = 0;
        for (int i : cardCosts) {
            sum += i;
        }
        String reportName = "report_" + Integer.toString(deckID) + ".txt";
        String deckIDWords = Integer.toString(deckID);
        String cardCostWords = Integer.toString(sum);
        File myObj = new File(reportName);
        FileWriter myWriter = new FileWriter(myObj);
        myWriter.write("Deck ID: " + deckIDWords);
        myWriter.write("\nTotal Cost: " + cardCostWords + " energy\nInvalid cards: " + invalidCards);
        myWriter.close();
    }
}


