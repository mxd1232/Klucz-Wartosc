import java.io.*;
import java.io.Console;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws IOException {

      //  HInstance.main(args);
     //   HListener.main(args);
      //  HExecuteOnEntries.main(args);
      //  HExecutorService.main(args);

        Console console = System.console();

        System.out.println("PUT[0] \n MODIFY[1] \n DELETE[2] \n  GET[3] \n DISCOUNT[4] \n quit[5]");

        while(true)
        {

            Scanner scanner = new Scanner(System.in);

            int id = scanner.nextInt();

            if(id ==0)
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter a place name: ");
                String place = br.readLine();

                System.out.println("Enter a date name: ");
                int date = scanner.nextInt() ;

                System.out.println("Enter money ");
                double money = scanner.nextDouble();

                HMapPut.put(place,date,money);

            }else if(id ==1)
            {

            }else if(id ==2)
            {

            }else if(id ==3)
            {
                HMapGet.main(args);

            }else if(id ==4)
            {

            }else if(id ==5)
            {
                return;
            }

        }

    }
}
