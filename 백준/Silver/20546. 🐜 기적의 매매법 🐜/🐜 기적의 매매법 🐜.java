import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class stock{
        int money = 0;
        int cnt = 0;

        public stock(int money, int cnt){
            this.money = money;
            this.cnt = cnt;
        }

        public void buy_stock(int cnt, int todaycost){
            if (this.money<todaycost*cnt)
                return;

            money -= todaycost*cnt;
            this.cnt+=cnt;
        }
        public int sell(int todaycost){
            this.money += todaycost*this.cnt;
            this.cnt = 0;
            return todaycost;
        }
    }

    static int n;
    static int[] price = new int[14];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<14; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        int bnp,timing;

        bnp = BNP();
        timing = TIMING();
        if(bnp <timing){
            System.out.println("TIMING");
        }else if(bnp>timing){
            System.out.println("BNP");
        }else{
            System.out.println("SAMESAME");
        }
    }

    public static int BNP(){
        stock s = new stock(n,0);
        for (int i =0; i<14; i++){
            if (price[i]<=s.money){
                s.buy_stock(s.money/price[i], price[i]);
            }
        }
        return (s.cnt * price[13]) + s.money;
    }
    public static int TIMING(){
        stock s = new stock(n,0);

        for(int i=3; i<14; i++){
            if((price[i-3]>price[i-2])&&(price[i-2]>price[i-1])){
                s.buy_stock(s.money/price[i],price[i]);
            }else if((price[i-3]<price[i-2])&&(price[i-2]<price[i-1])){
                s.sell(price[i]);
            }
        }
        return (s.cnt*price[13])+s.money;
    }
}
