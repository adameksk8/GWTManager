package it.nowak.adam.GWTManager.DataGenerators;

import it.nowak.adam.GWTManager.Model.Users.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UsersGenerator {

    String[] firstNameList= {"Adam","Aleks", "Alfred", "Paweł", "Piotr", "Jan", "Józef"};
    String[] surNameList= {"Nowak", "Kozłowski", "Pawlak"};
    String[] emailDomainsList= {"gmail.com", "wp.pl", "interia.pl", "onet.pl", "o2.pl", "poczta.onet.pl", "mail.com"};
    String[] roleList= {"User", "Administrator"};

    public UsersGenerator() {
        readUserFirstNamesFromFile();
        readUserLastNamesFromFile();
    }

    private String generateFirstName(){
        Random rand = new Random();
        return firstNameList[rand.nextInt(firstNameList.length)];
    }
    private String generateLastName(){
        Random rand = new Random();
        return surNameList[rand.nextInt(surNameList.length)];
    }

    private String generateEmail(User user){
        Random rand = new Random();

        return user.getFirstName().toLowerCase()+'.'+user.getLastName().toLowerCase()+'@'+emailDomainsList[rand.nextInt(emailDomainsList.length)];
    }
    private String generateRole(){
        Random rand = new Random();
        return roleList[rand.nextInt(roleList.length)];
    }

    private long generatePesel(){
        long pesel=0;
        Random rand = new Random();
        for (int i=0; i<11;i++){
            pesel+=rand.nextInt(10);
            pesel*=10;
        }
        return pesel;
    }
    private Integer generatePhoneNumber(){
        Integer number=0;
        Random rand = new Random();
        for (int i=0; i<9;i++){
            number*=10;
            number+=rand.nextInt(10);
        }
        return number;
    }
    public User generateUser(){
        User user = new User();
        user.setFirstName(generateFirstName());
        user.setLastName(generateLastName());
        user.setEmail(generateEmail(user));
        user.setRole(generateRole());
        user.setPesel(generatePesel());
        user.setPhone((generatePhoneNumber()));
        user.setMobilePhone(generatePhoneNumber());
        user.setVoip(generatePhoneNumber());
        return user;
    }

    public ArrayList<User> generateUsers(int count){
        ArrayList<User> result = new ArrayList();
        for (int i=0;i<count;i++){
            result.add(generateUser());
        }
        return result;
    }
    private int readUserFirstNamesFromFile(){
        Scanner scanner = null;
        ArrayList<String> tokens = new ArrayList();
        try {
            scanner = new Scanner(new File("src/main/resources/userFirstNames.txt"));
            while(scanner.hasNext()){
                String input=scanner.nextLine().split("\n")[0];
                if (input.length()>0) {
                    String output = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
                    tokens.add(output);
                }
            }
            firstNameList=tokens.toArray(new String[tokens.size()]);
            return tokens.size();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }
    private int readUserLastNamesFromFile(){
        Scanner scanner = null;
        ArrayList<String> tokens = new ArrayList();
        try {
            scanner = new Scanner(new File("src/main/resources/userLastNames.txt"));
            while(scanner.hasNext()){
                String input=scanner.nextLine().split("\n")[0];
                if (input.length()>0) {
                    String output = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
                    tokens.add(output);
                }
            }
            surNameList=tokens.toArray(new String[tokens.size()]);
            return tokens.size();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
