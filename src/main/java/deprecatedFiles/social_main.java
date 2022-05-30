//package com.example.backEndProject;
//
//import java.util.Scanner;
//
//import static com.example.backEndProject.scanner.LogInScanner.logIn;
//import static com.example.backEndProject.scanner.NewAccountScanner.createNewAccount;
//
//public class social_main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int menuSelection;
//        do {
//            welcomeMenu();
//            menuSelection = scanner.nextInt();
//            System.out.println(menuSelection + ") ");
//            switch (menuSelection) {
//                case 1 -> {
//                    createNewAccount(scanner);
//                } case 2 -> {
//                    logIn(scanner);
//                }
//            }
//        } while (menuSelection !=0);
//    }
//    private static void welcomeMenu(){
//        System.out.println("");
//        System.out.println("=================");
//        System.out.println("Select an option: ");
//        System.out.println("1) Create a new account");
//        System.out.println("2) Log in");
//        System.out.println("==================");
//    }
//
//}
