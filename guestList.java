import java.util.Scanner;

public class guestList {
    static String[] guests = new String[10];
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

        insertTestNames();

        do {
            displayGuests();
            displayMenu();
            int option = getOption();

            if (option == 1) {
                addGuest();

            } else if (option == 2) {
                insertGuest();

            }else if (option == 3) {
                renameGuests();
              
            } else if (option == 4) {
                removeGuest();

            }  else if (option == 5){
                break;
            }

        } while (true);
        System.out.println("Exiting...");
    }
        static void displayGuests(){
            System.out.println(" **** Guests: **** ");
            boolean isEmpty = true ;
            for (int i = 0; i < guests.length; i++) {
                if (guests[i] != null) {
                    System.out.println(i + 1 + ". " + guests[i]);
                    isEmpty = false;
                }  // condition ? a : b   (if condition is true a happens, if false b happens)
            }
            if (isEmpty){
                System.out.println("Guest list is Empty!");
            }
        }
        static void displayMenu() {
              System.out.println(" **** Menu **** ");
              System.out.println("1. Add Guest");
              System.out.println("2. Insert Guest");
              System.out.println("3. Rename Guest");
              System.out.println("4. Remove Guest");
              System.out.println("5. Exit");

        }
        static int getOption() {
              System.out.print("Option: ");
              int option = scanner.nextInt();
              scanner.nextLine(); // when user inserts 1 then enter, "\n" gets read too
              // this is to prevent from /n becoming a character in scanner for when
              // nextLine() is called in addGuest().
              return option;
        }
        static void addGuest() {
            for (int i = 0; i < guests.length; i++) {
                if (guests[i] == null) {
                    System.out.println("Enter the name");
                    guests[i] = scanner.nextLine();
                    break;
                }
            }
        }
        static void insertGuest(){
            System.out.println("Enter the Number");
            int num = scanner.nextInt();
            scanner.nextLine();

             if (0 < num && num <= 10 && guests[num - 1] != null) {
                System.out.println("Enter new Name");
                String name = scanner.nextLine();

                for (int i = guests.length -1 ; i> num -1  ;i--)  {
                        guests[i] = guests[i-1];
                }

                guests[num-1] = name;
                                                                     
             } else {
                System.out.println("This number doesn't exist!");
        }
        

        }

        static void renameGuests() {

            System.out.println("Enter the Number");
            int num = scanner.nextInt();
            scanner.nextLine();
            if (0 < num && num <= 10 && guests[num - 1] != null) {
                System.out.println("Enter new Name");
                String name = scanner.nextLine();
                guests[num - 1] = name;

            } else {
                System.out.println("This number doesn't exist!");
            }
        }
        static void removeGuest() {
            System.out.print("Enter the name: ");
            String guestName = scanner.next();
            for (int i = 0; i < guests.length; i++) {
                if (guests[i] != null && guests[i].equals(guestName)) {
                    guests[i] = null;
                    break;
                }
                //now to have a tidy list:
                String[] temp = new String[guests.length];
                int ti = 0; //temp index
                for (i = 0; i < guests.length; i++) {
                    if (guests[i] != null) {
                        temp[ti] = guests[i];
                        ti++;
                    }
                }
                guests = temp;
            }
        }
        static void insertTestNames(){
        guests[0]= "Brandon";
        guests[1]= "Sarah";
        guests[2]= "Alex";
        guests[3]= "Joyce";
        }
        
}

