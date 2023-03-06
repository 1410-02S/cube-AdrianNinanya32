import java.util.Scanner;
import java.util.ArrayList;


public class Rubiks {

    String [][] cube = {{
        "r","r","r",
        "r","r","r",
        "r","r","r"
        }, {
        "b","b","b",
        "b","b","b",
        "b","b","b"
        }, {
        "o","o","o",
        "o","o","o",
        "o","o","o"
        }, {
        "g","g","g",
        "g","g","g",
        "g","g","g"
        }, {
        "y","y","y",
        "y","y","y",
        "y","y","y"
        }, {
        "w","w","w",
        "w","w","w",
        "w","w","w"
        }

    };

    class edgedFace{
        public int current_face;
        int []edge1 = new int[4]; //Index 0 is the face and 1-3 are the sides of the face
        int []edge2 = new int[4]; //For yellow
        int []edge3 = new int[4]; //For Green
        int []edge4 = new int[4]; //For white

        public edgedFace(int face){
            current_face = face;

            switch (face) {
                case 0:
                    edge1[0] = 1;
                    edge1[1] = 2;
                    edge1[2] = 5;
                    edge1[3] = 8;

                    
                    edge2[0] = 4;
                    edge2[1] = 2;
                    edge2[2] = 5;
                    edge2[3] = 8;

                    edge3[0] = 3;
                    edge3[1] = 0;
                    edge3[2] = 3;
                    edge3[3] = 6;

                    edge4[0] = 5;
                    edge4[1] = 2;
                    edge4[2] = 5;
                    edge4[3] = 8;
                    break;

                //Blue side    
                case 1:
                    edge1[0] = 2;
                    edge1[1] = 2;
                    edge1[2] = 5;
                    edge1[3] = 8;

                    
                    edge2[0] = 4;
                    edge2[1] = 2;
                    edge2[2] = 5;
                    edge2[3] = 8;

                    edge3[0] = 0;
                    edge3[1] = 0;
                    edge3[2] = 3;
                    edge3[3] = 6;

                    edge4[0] = 5;
                    edge4[1] = 2;
                    edge4[2] = 5;
                    edge4[3] = 8;
                    break;

                //Orange Side
                case 2:
                    edge1[0] = 3;
                    edge1[1] = 2;
                    edge1[2] = 5;
                    edge1[3] = 8;

                    
                    edge2[0] = 4;
                    edge2[1] = 2;
                    edge2[2] = 5;
                    edge2[3] = 8;

                    edge3[0] = 1;
                    edge3[1] = 0;
                    edge3[2] = 3;
                    edge3[3] = 6;

                    edge4[0] = 5;
                    edge4[1] = 2;
                    edge4[2] = 5;
                    edge4[3] = 8;
                    break;

                //Green Side    
                case 3:
                    edge1[0] = 0;
                    edge1[1] = 2;
                    edge1[2] = 5;
                    edge1[3] = 8;

                    
                    edge2[0] = 4;
                    edge2[1] = 2;
                    edge2[2] = 5;
                    edge2[3] = 8;

                    edge3[0] = 2;
                    edge3[1] = 0;
                    edge3[2] = 3;
                    edge3[3] = 6;

                    edge4[0] = 5;
                    edge4[1] = 2;
                    edge4[2] = 5;
                    edge4[3] = 8;
                    break;

                //Yellow Side    
                case 4:
                    edge1[0] = 1;
                    edge1[1] = 2;
                    edge1[2] = 5;
                    edge1[3] = 8;

                    
                    edge2[0] = 2;
                    edge2[1] = 2;
                    edge2[2] = 5;
                    edge2[3] = 8;

                    edge3[0] = 3;
                    edge3[1] = 0;
                    edge3[2] = 3;
                    edge3[3] = 6;

                    edge4[0] = 0;
                    edge4[1] = 2;
                    edge4[2] = 5;
                    edge4[3] = 8;
                    break;

            
                //White Side
                case 5:
                    edge1[0] = 1;
                    edge1[1] = 2;
                    edge1[2] = 5;
                    edge1[3] = 8;

                    
                    edge2[0] = 0;
                    edge2[1] = 2;
                    edge2[2] = 5;
                    edge2[3] = 8;

                    edge3[0] = 3;
                    edge3[1] = 0;
                    edge3[2] = 3;
                    edge3[3] = 6;

                    edge4[0] = 2;
                    edge4[1] = 2;
                    edge4[2] = 5;
                    edge4[3] = 8;
                    break;
            }
        }


    }

    public void turnFace(int index, String direction) {
        edgedFace eFace = new edgedFace(index);

        String [][] copy = new String[6][9];

        for (int i = 0; i < 6; i++){
            for (int j =0; j <9; j++){
                copy [i][j] = cube [i][j];
            }
        }

        switch (direction){
            case "c":
                cube [eFace.current_face][0] = copy[eFace.current_face][6];
                cube [eFace.current_face][1] = copy[eFace.current_face][3];
                cube [eFace.current_face][2] = copy[eFace.current_face][0];
                cube [eFace.current_face][3] = copy[eFace.current_face][7];
                cube [eFace.current_face][5] = copy[eFace.current_face][1];
                cube [eFace.current_face][6] = copy[eFace.current_face][8];
                cube [eFace.current_face][7] = copy[eFace.current_face][5];
                cube [eFace.current_face][8] = copy[eFace.current_face][2];

                //Changing the edges in the left 
                cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
                cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
                cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

                //Changing the edges on top 
                cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
                cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
                cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];
                
                //Changin the edges in the right

                cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
                cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
                cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

                //Changing the edges on bottom
                cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
                cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
                cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];
                break;

            case "cc":
                cube [eFace.current_face][0] = copy[eFace.current_face][2];
                cube [eFace.current_face][1] = copy[eFace.current_face][5];
                cube [eFace.current_face][2] = copy[eFace.current_face][8];
                cube [eFace.current_face][3] = copy[eFace.current_face][1];
                cube [eFace.current_face][5] = copy[eFace.current_face][7];
                cube [eFace.current_face][6] = copy[eFace.current_face][0];
                cube [eFace.current_face][7] = copy[eFace.current_face][3];
                cube [eFace.current_face][8] = copy[eFace.current_face][6];

                //Changing the edges in the left
                cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
                cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
                cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

                //Changing the edges in the top
                cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
                cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
                cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

                //Changing the edges on the right
                cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
                cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
                cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

                //Changing the edges on the bottom
                cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
                cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
                cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];
                break;
        }

    }

    public void showCube() {
        int ind = 0;
        for(int x=0; x<6; x++){
            for (int y=0; y <3; y++){
                for (int z=0; z<3; z++){
                    System.out.print(cube[x][ind++]);
                }
                System.out.println();
            }
            ind = 0;
            System.out.println();
        }
    }

    public String reverseString (String x) {

        char ch;
        String nstr = "";

        for (int i = 0; i < x.length(); i++) {
            ch = x.charAt(i);
            nstr = ch + nstr;
        }

        return nstr;

    }


    public static void main(String[]args){

        Scanner in = new Scanner (System.in);

        Rubiks Rubikscube = new Rubiks();


        boolean proceed = true;

        while(proceed){
            
            String input = in.nextLine();
            String solve = "";

            switch (input) {

                //Yellow Clock
                case "u":
                    Rubikscube.turnFace(4, "c");
                    Rubikscube.showCube();
                    solve += "u ";
                    break;
                //Yellow Cc
                case "u'":
                    Rubikscube.turnFace(4, "cc");
                    Rubikscube.showCube();
                    solve += "u' ";
                    break;
                //White Clock
                case "d":
                    Rubikscube.turnFace(5, "c");
                    Rubikscube.showCube();
                    solve += "d ";
                    break;

                //White Cc
                case "d'":
                    Rubikscube.turnFace(5, "cc");
                    Rubikscube.showCube();
                    solve += "d' ";
                    break;

                //Red Clockwise
                case "r":
                    Rubikscube.turnFace(0, "c");
                    Rubikscube.showCube();
                    solve += "r ";
                    break;

                //Red Cc
                case "r'":
                    Rubikscube.turnFace(0, "cc");
                    Rubikscube.showCube();
                    solve += "r' ";
                    break;

                //Orange Clockwise
                case "l":
                    Rubikscube.turnFace(2, "c");
                    Rubikscube.showCube();
                    solve += "l ";
                    break;

                //Orange Cc
                case "l'":
                    Rubikscube.turnFace(2, "cc");
                    Rubikscube.showCube();
                    solve += "l' ";
                    break;

                //Blue Clockwise
                case "f":
                    Rubikscube.turnFace(1, "c");
                    Rubikscube.showCube();
                    solve += "f ";
                    break;

                //Blue Cc
                case "f'":
                    Rubikscube.turnFace(1, "cc");
                    Rubikscube.showCube();
                    solve += "f' ";
                    break;

                //Green Clockwise
                case "b":
                    Rubikscube.turnFace(3, "c");
                    Rubikscube.showCube();
                    solve += "b ";
                    break;

                //Green CC
                case "b'":
                    Rubikscube.turnFace(3, "cc");
                    Rubikscube.showCube();
                    solve += "b' ";
                    break;

                //Solutions
                case "s":
                    System.out.println("Here are the steps to solve the cube" + Rubikscube.reverseString(solve));
                    break;
                //Quit
                case "q":
                    proceed = false;
                    break;
            }


        }

    }

}