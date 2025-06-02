
package fsmproje123;

import java.util.Scanner;
/**
* @file Fsmproje123.java
* @descraption Labirent oyunu (Programlama 1 projesi) 
* @assignment 1. proje
* @date 30/12/2023
* @author Motasem Yıldız
*/

public class Fsmproje123 {

    public static void Print_Labirent(char matris[][], int raw, int col) {

        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {
                if (i == raw && j == col) {
                    System.out.print("X" + " ");
                } else {
                    System.out.print(matris[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Konumunuz :" + " " + " ( " + " " + raw + "," + " " + col + " " + ")");

    }

    public static void print_information(int hamle_sayisi, int T_bonus, int R_bonus, int H_bonus, int F_bonus) {
        System.out.println("Hamle Sayısı: " + hamle_sayisi);
        System.out.println();
        System.out.println("Bonuslarınız:" + " " + "T:" + " " + T_bonus + " R:" + " " + R_bonus + " H:" + " " + H_bonus + " F:" + " " + F_bonus);
        System.out.println("Lütfen hamle yapın ");
        System.out.println("Yukarıya gitmek için W yada w basınız ");
        System.out.println("Sağa gitmek için D yada d basınız ");
        System.out.println("Sola gitmek için A yada a basınız ");
        System.out.println("Aşağıya gitmek için S yada s basınız");
    }

    public static boolean True_move(char[][] matris, int raw, int col) {
        if (raw >= 0 && raw <= matris.length - 1 && col >= 0 && col <= matris[0].length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public static char Remove_wall(int R_bonus, char[][] matris, int raw, int col) {
        char wall = '#';
        char point = '.';
        wall = point;
        matris[raw][col] = point;
        return point;
    }

    public static char Remove_mine(int F_bonus, char[][] matris, int raw, int col) {
        char mine = '!';
        char point = '.';
        mine = point;
        matris[raw][col] = point;
        return point;
    }
    
    public static char Convert_point(char bonus){
        char point = '.';
        bonus = point;
        return point;
    }
    
    public static void Change_5moves(int hamle_sayisi, char[][] matris) {
        if (hamle_sayisi % 5 == 0 && hamle_sayisi != 0) {  // bu dongu labirent icindeki bonularin sayilari belirlemek icin 
            int counter_bonus = 0;
            for (int i = 0; i <matris.length; i++) {
                for (int j = 0; j < matris[i].length; j++) {
                    if (matris[i][j] == 'T' || matris[i][j] == 'H' || matris[i][j] == 'F' || matris[i][j] == 'R') {
                            counter_bonus++;
                        }
                }
            }
            char[] save_bonus = new char[counter_bonus];
            int counter = 0;
            if (hamle_sayisi % 5 == 0 && hamle_sayisi != 0) {
                for (int i = 0; i < matris.length; i++) { // bu dongu labirent icindeki bonuslari topluyor sonra bir array icin kayde ediyor
                    for (int j = 0; j < matris[i].length; j++) {
                        if (matris[i][j] == 'T' || matris[i][j] == 'H' || matris[i][j] == 'F' || matris[i][j] == 'R') {
                            save_bonus[counter] = matris[i][j];
                            counter++;
                        }
                    }
                }
                for (int i = 0; i < matris.length; i++) {
                    for (int j = 0; j < matris[i].length; j++) {
                        if (matris[i][j] == 'T' || matris[i][j] == 'H' || matris[i][j] == 'F' || matris[i][j] == 'R') {
                            matris[i][j] = '.';
                        }
                    }
                }
                        
                        
                for (int new_bonus_number = 0; new_bonus_number < counter; new_bonus_number++) { //elemizdeki butun!!!!! karakterleri labirentte rastgele bir sekilde koymak icin 
                    int random_raw;
                    int random_col;
                    do {
                        random_raw = (int) (Math.random() * matris.length);
                        random_col = (int) (Math.random() * matris[0].length);
                    } while (matris[random_raw][random_col] == '#' || matris[random_raw][random_col] == '!' || matris[random_raw][random_col] == 'B' || matris[random_raw][random_col] == 'E');

                    matris[random_raw][random_col] = save_bonus[new_bonus_number];

                }

            }
        }

    }
    
    public static void Change_5moves_for_mayin(int hamle_sayisi, char[][] matris) {
        if (hamle_sayisi % 5 == 0 && hamle_sayisi != 0) {  // bu dongu labirent icindeki bonularin sayilari belirlemek icin 
            int counter_bonus = 0;
            for (int i = 0; i <matris.length; i++) {
                for (int j = 0; j < matris[i].length; j++) {
                    if (matris[i][j] == '!') {
                            counter_bonus++;
                        }
                }
            }
            char[] save_bonus = new char[counter_bonus];
            int counter = 0;
            if (hamle_sayisi % 5 == 0 && hamle_sayisi != 0) {
                for (int i = 0; i < matris.length; i++) { // bu dongu labirent icindeki bonuslari topluyor sonra bir array icin kayde ediyor
                    for (int j = 0; j < matris[i].length; j++) {
                        if (matris[i][j] == '!') {
                            save_bonus[counter] = matris[i][j];
                            counter++;
                        }
                    }
                }
                for (int i = 0; i < matris.length; i++) {
                    for (int j = 0; j < matris[i].length; j++) {
                        if (matris[i][j] == '!') {
                            matris[i][j] = '.';
                        }
                    }
                }
                for (int new_bonus_number = 0; new_bonus_number < counter; new_bonus_number++) { //elemizdeki butun!!!!! karakterleri labirentte rastgele bir sekilde koymak icin 
                    int random_raw;
                    int random_col;
                    do {
                        random_raw = (int) (Math.random() * matris.length);
                        random_col = (int) (Math.random() * matris[0].length);
                    } while (matris[random_raw][random_col] == '#' || matris[random_raw][random_col] == 'R' || matris[random_raw][random_col] == 'B' || matris[random_raw][random_col] == 'E' || matris[random_raw][random_col] == 'F' || matris[random_raw][random_col] == 'H' || matris[random_raw][random_col] == 'T');
                    matris[random_raw][random_col] = save_bonus[new_bonus_number];
                }

            }
        }

    }
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Oyuna Hoş Geldiniz");
        System.out.println("Oyunu bitirmek icin E'ye gelminiz lazim");
        char[][] labirent = {
            {'#', '!', '.', '.', 'R', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.'},
            {'.', '.', '#', '.', '.', '.', '#', '.', 'H', '.', '.', '.', '.', '.', '!'},
            {'F', '.', '.', '.', '#', '.', '!', '.', '.', 'R', '.', '.', '#', '#', '.'},
            {'.', '.', '#', '.', '.', '#', '.', '.', '.', '.', 'F', '.', '.', '.', '.'},
            {'.', '!', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '.', '.', '.'},
            {'.', '.', 'H', '.', '.', '!', '.', '.', 'H', '.', '.', 'F', '.', '.', 'R'},
            {'#', '#', '#', '#', '.', '.', '#', '.', '.', '.', 'T', '.', '.', '.', 'E'},
            {'.', '.', '#', '.', 'F', '.', '#', '#', '.', '#', '#', '#', '#', '.', '.'},
            {'.', '#', '.', '.', '.', '.', '!', '.', '#', '.', '.', '.', '#', '.', '.'},
            {'.', 'T', 'T', '.', '#', '#', '.', '.', '.', '.', 'T', '.', '.', '.', 'R'},
            {'.', '.', '.', '#', '.', '.', '.', '#', '.', '#', '.', '#', '.', 'T', '.'},
            {'B', '.', '#', '.', '.', '!', '.', '!', '.', '.', '.', '.', '.', '.', '#'},
            {'.', '.', '.', 'F', '!', '.', '.', '.', 'H', '.', '.', 'R', '.', '.', '.'},
            {'.', '.', 'H', '.', '.', '.', '!', '.', '.', '.', '#', '.', '.', '#', '.'},
            {'.', '.', '.', '#', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '#'}};

        boolean game_finish = true;
        int Hamle_sayisi = 0;
        int raw = 0;
        int col = 0;
        int user_position[] = new int[2];
        int T_bonus = 0;
        int R_bonus = 0;
        int H_bonus = 0;
        int F_bonus = 0;

        for (raw = 0; raw < labirent.length; raw++) {
            for (col = 0; col < labirent[raw].length; col++) {
                if (labirent[raw][col] == 'B') {
                    user_position[0] = raw;
                    user_position[1] = col;
                    break;
                }
            }
        }
        raw = user_position[0];
        col = user_position[1];

        while (game_finish) {
            Print_Labirent(labirent, raw, col);
            print_information(Hamle_sayisi, T_bonus, R_bonus, H_bonus, F_bonus);
            char user = input.next().charAt(0);
            boolean correct_hamle = false;
            
            switch (user) {
                case 'W':
                case 'w':
                    if (True_move(labirent, raw - 1, col)) { // raw -1 yeni hareketin değeri
                        raw--;
                        correct_hamle = true;
                    }
                    break;
                case 'D':
                case 'd':
                    if (True_move(labirent, raw, col + 1)) {
                        col++;
                        correct_hamle = true;
                    }
                    break;
                case 'A':
                case 'a':
                    if (True_move(labirent, raw, col - 1)) {
                        col--;
                        correct_hamle = true;
                    }
                    break;
                case 'S':
                case 's':
                    if (True_move(labirent, raw + 1, col)) {
                        raw++;
                        correct_hamle = true;
                    }
                    break;
                case 'T':
                case 't':
                case 'R':
                case 'H':
                case 'h':
                case 'F':
                case 'O':
                case 'o':
                    break;
                default:
                    System.out.println("Geçersiz hamle!! W, A, S veya D tuşlarından birini kullanın.");
                    Hamle_sayisi += 0;
            }
            
            Change_5moves(Hamle_sayisi, labirent);
            Change_5moves_for_mayin(Hamle_sayisi, labirent);
            
             if (labirent[raw][col] == 'T') {
                T_bonus++;
                labirent[raw][col] = Convert_point(labirent[raw][col]);
            }
            if (labirent[raw][col] == 'R') {
                R_bonus++;
                Convert_point(labirent[raw][col]);
                labirent[raw][col] = Convert_point(labirent[raw][col]);
            }
            if (labirent[raw][col] == 'H') {
                H_bonus++;
                labirent[raw][col] = Convert_point(labirent[raw][col]);
            }
            if (labirent[raw][col] == 'F') {
                F_bonus++;
                labirent[raw][col] = Convert_point(labirent[raw][col]);
            }
            
            switch (user) {
                case 'T':
                case 't':
                    if (T_bonus > 0) {
                        System.out.println("Gitmek istediğiniz konum koordinatlarını(x ve y) giriniz ");
                        int X = input.nextInt();
                        int Y = input.nextInt();
                        if (labirent[X][Y] != '#' && X >= 0 && X <= labirent.length - 1 && Y >= 0 && X <= labirent[0].length - 1) {
                            raw = X;
                            col = Y;
                            T_bonus--;
                        } else {
                            System.out.println("Geçersiz Işınlanma Hamlesi");
                        }
                    }
                    break;

                case 'H':
                case 'h':
                    if (Hamle_sayisi > 2 && H_bonus > 0) {
                        Hamle_sayisi -= 3; // burda fazla bir hamle var bu yuzden 3 yazdim
                        H_bonus--; 
                    } else {
                        System.out.println("H bonsunuz yok!! Şimdi H bonusu kullanamazsınız");
                    }
                    break;
                    
                case 'O':
                case 'o':
                    game_finish = false;
                    System.out.println("Oyunu sonlandırdınız");
            break;
            }
            

            char position = labirent[raw][col];

            switch (position) {

                case '#':
                    System.out.println("Duvar ile karşılaştınız");
                    if (R_bonus > 0) {
                        System.out.println("R bonsunuz var ,Duvari kaldırdınız");
                        Remove_wall(R_bonus, labirent, raw, col);
                        R_bonus--;
                    } else {
                        System.out.println("R bonsunuz yok!!Duvari kaldıramazsınız geri dönmeniz lazim");
                        if (user == 'w' || user == 'W') {
                            raw++;
                        }
                        if (user == 's' || user == 'S') {
                            raw--;
                        }
                        if (user == 'd' || user == 'D') {
                            col--;
                        }
                        if (user == 'a' || user == 'A') {
                            col++;
                        }

                    }
                    break;
                case '!':
                    System.out.println("Mayın ile karşılaştınız");
                    if (F_bonus > 0) {
                        System.out.println("F bonsunuz var ,Mayını kaldırdınız");
                        Remove_mine(F_bonus, labirent, raw, col);
                        F_bonus--;
                    } else {
                        System.out.println("F bonsunuz yok!! ,Mayın patladi");
                        Remove_mine(F_bonus, labirent, raw, col);
                        Hamle_sayisi += 5;
                    }
                        break;

            }
            Hamle_sayisi++;
            if (position == 'E') {
                System.out.println("Tebrikler,Oyunu bitirdiniz");
                System.out.println("Hamle Sayisi :" + " " + Hamle_sayisi);
                game_finish = false;

            }

        }
    }

}
