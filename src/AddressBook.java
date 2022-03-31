import com.infogalaxy.Contact;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class AddressBook {
    ArrayList<Contact> contactlist = new ArrayList();
    Scanner sc = new Scanner(System.in);

    //UC-2 Adding Multiple Contacts:
    public void addContacts() {
        Contact contact = new Contact();
        System.out.println("Enter the First Name:");
        contact.setFirstName(sc.next());
        System.out.println("Enter the Last Name:");
        contact.setLastName(sc.next());
        System.out.println("Enter the Address:");
        contact.setAddress(sc.next());
        System.out.println("Enter the City:");
        contact.setCity(sc.next());
        System.out.println("Enter the State:");
        contact.setState(sc.next());
        System.out.println("Enter the Mobile Number:");
        contact.setMobno(sc.next());
        System.out.println("Enter the Email:");
        contact.setEmail(sc.next());
        System.out.println("Enter the Zip Code:");
        contact.setZip(sc.next());
        contactlist.add(contact);
    }

    public void displayContacts() {
        for (int i = 0; i < contactlist.size(); i++) {
            Contact contact = contactlist.get(i);
            System.out.println(contact.toString());
        }
    }

    public void FindContact() {
        String F_name;
        int flag=0;
        System.out.println("Enter the First Name:");
        F_name = sc.next();
        for (int i = 0; i < contactlist.size(); i++) {
            Contact contact = contactlist.get(i);
            if (F_name.equals(contact.getFirstName())) {
                flag = 1;
                System.out.println("Enter the Last Name:");
                contact.setLastName(sc.next());
                System.out.println("Enter the Address:");
                contact.setAddress(sc.next());
                System.out.println("Enter the City:");
                contact.setCity(sc.next());
                System.out.println("Enter the State:");
                contact.setState(sc.next());
                System.out.println("Enter the Mobile Number:");
                contact.setMobno(sc.next());
                System.out.println("Enter the Email:");
                contact.setEmail(sc.next());
                System.out.println("Enter the Zip Code:");
                contact.setZip(sc.next());
                break;
            }
        }
        if(flag == 0) {
            System.out.println("Contact not Found");
        }
        else {
            System.out.println("Contact  Found");
        }
    }

    public void enterState() {

        String state;
        System.out.println("Enter the State: ");
        state = sc.next();
        for (int i =0; i < contactlist.size(); i++) {
            Contact contact = contactlist.get(i);
            if (state.equals(contact.getState())) {
                System.out.println(contact.getFirstName());
                System.out.println(contact.getMobno());
            }



        }
    }
    public void backupToFile() {
        String conData = null;
        for (int i = 0; i < contactlist.size(); i++) {
            Contact contact = contactlist.get(i);
            conData = contact.getFirstName() + "," + contact.getLastName() + "," + contact.getMobno() +
                    "," + contact.getAddress() + "," + contact.getAddress() + "," + contact.getCity() + ","
                    + contact.getState() + "," + contact.getEmail() + "," + contact.getZip() + "\n" + conData;
        }
        try {
            Path file = Paths.get("MyData.txt");
            byte[] filedata = conData.getBytes();
            Files.write(file, filedata);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteContact() {
        System.out.println("Enter the Fist Name :");
        String delete = sc.next();
        for (int i = 0; i < contactlist.size(); i++) {
            Contact contact = contactlist.get(i);
            if (delete.equals(contact.getFirstName())) {
                contactlist.remove(i);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        int select;
        do {
            System.out.println("Welcome to Employee Inventory Management");
            System.out.println("\n1. Add Contact \n2.Display Conatact  \n3.Find Contact \n4.Find State \n5.Delete \n6.BackupContact \n7.Exit");
            System.out.println("Select Any of Your Choice:");
            select = sc.nextInt();
            switch (select) {
                case 1:
                    addressBook.addContacts();
                    break;
                case  2:
                    addressBook.displayContacts();
                    break;
                case 3:
                    addressBook.enterState();
                    break;
                case 4:
                    addressBook.FindContact();
                    break;
                case 5:
                    addressBook.deleteContact();
                    break;
                case 6:
                    addressBook.backupToFile();
                    break;


            }
        }while (select !=7);

    }
}
