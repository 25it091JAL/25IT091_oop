import java.util.Scanner;
class Driver 
{
public static void main(String[] args) 
    {
  String[] logs = {
       "10:05 alice Hello there",
         "10:10 bob How are you",
         "WrongLine",
         "10:20 charlie hello everyone"
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine().toLowerCase();
        int count = 0;
        
        StringBuilder result = new StringBuilder();
        for (String line : logs) 
        {
            String[] parts = line.split(" ", 3);
            if (parts.length != 3) 
            {
                continue;
            }
            
            String time = parts[0];
            String user = parts[1];
            String message = parts[2];
            
            if (message.toLowerCase().contains(keyword)) 
            {
                count++;
                result.append(time)
                      .append(" ")
                      .append(user)
                      .append(": ")
                      .append(message)
                      .append("\n");
            }
        }
        
        System.out.println("Matches: " + count);
        System.out.println(result);
    }
}
