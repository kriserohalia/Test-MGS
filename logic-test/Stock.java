import java.util.Scanner;

public class Stock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah harga saham: ");
        int n = scanner.nextInt();

        int[] stockPrices = new int[n];

        System.out.println("Masukkan harga saham:");
        for (int i = 0; i < n; i++) {
            System.out.print("Harga saham ke-" + (i + 1) + ": ");
            stockPrices[i] = scanner.nextInt();
        }



        int bestBuyPrice = findBestBuyPrice(stockPrices);
        System.out.println("Nilai saham dengan keuntungan terbaik: " + bestBuyPrice);

        scanner.close();
    }

    public static int findBestBuyPrice(int[] prices) {
        if (prices == null || prices.length < 2) {
            throw new IllegalArgumentException("Array harus memiliki setidaknya dua elemen");
        }

        int minPrice = prices[0];
        int maxProfit = 0;
        int bestBuyPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            
            int potentialProfit = currentPrice - minPrice;

            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit;
                bestBuyPrice = minPrice;
            }

            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            }
        }

        return bestBuyPrice;
    }
}
