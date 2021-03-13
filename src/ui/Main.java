package s6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    
    public static int[] difference(int []prices, int money ) {

            int dif = 0;
            int value = Integer.MAX_VALUE;
            int[]pos = new int[2];

            for(int i=0;i<prices.length;i++) {
                
                if(binarySearch(prices,(money-prices[i]))>=0) {
                    
                    if(prices[i]-prices[binarySearch(prices,(money-prices[i]))]<Integer.MAX_VALUE) {
                        
                        dif = (prices[i]-prices[binarySearch(prices,(money-prices[i]))])*-1;
                        
                        if((value)>(dif)) {
                            value = dif;
                            pos[0] = prices[i];
                            pos[1]= prices[binarySearch(prices,(money-prices[i]))];
                        }
                    }
                }
            }
            return pos;
	}
    
    public static int binarySearch(int[] prices, int money){
            
            int pos = -1;
	    int i= 0;
            int j = prices.length-1;

            while(i<=j && pos<0) {
                
                int m = (i+j)/2;
                    
                if(prices[m] == money) {
                    pos = m;
                    
                }else if(prices[m]>money) {
                    j = m-1;
                    
                }else {
                    i = m+1;
                }
            }
            
        return pos;
    }
    
	public final static String SPACE =" ";
        
	public static void main(String args[]) throws NumberFormatException, IOException {
            
            System.out.println("Ingrese los datos: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            
            String line = br.readLine();
            int quantity = Integer.parseInt(line);
            int[] pricesToBooks =  new int[quantity];
	    String[] arrayPrices;
            int money;
            
           while(line != null) {

                line = br.readLine();

                arrayPrices = line.split(SPACE);

                for(int i =0; i<quantity;i++) {
                    pricesToBooks[i] = Integer.parseInt(arrayPrices[i]);

                }
                Arrays.sort(pricesToBooks);

                line= br.readLine();
                
                money = Integer.parseInt(line);	


                int[]pos = difference(pricesToBooks,money);
                System.out.println("\tRESULT: ");
                System.out.println("Peter should buy books whose prices are "+pos[0] +" and "+pos[1]+"\n");
                line= br.readLine();
                }
                br.close();
                bw.close();
        }
        
        
}