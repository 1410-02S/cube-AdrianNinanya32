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
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }


    }

    public void turnFace(int index, String direction) {
        edgedFace eface = new edgedFace(index);

        String [][] copy = new String[6][9];

        for (int i = 0; i < 6; i++){
            for (int j =0; j <9; j++){
                copy [i][j] = cube [i][j];
            }
        }

        switch (direction){
            case "c":
                cube [eFace.current_face][0] = copy[eFace.current_face][2];
                cube [eFace.current_face][1] = copy[eFace.current_face][5];
                cube [eFace.current_face][2] = copy[eFace.current_face][8];
                cube [eFace.current_face][3] = copy[eFace.current_face][1];
                cube [eFace.current_face][5] = copy[eFace.current_face][7];
                cube [eFace.current_face][6] = copy[eFace.current_face][0];
                cube [eFace.current_face][7] = copy[eFace.current_face][3];
                cube [eFace.current_face][8] = copy[eFace.current_face][6];

                //Changing the edges now
                cube[eFace.edge1[0]][eFace.edge[1]]


                break;
            case "cc":
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


    public static void main(String[]args){

        Rubiks Rubikscube = new Rubiks();

        Rubikscube.showCube();

    }

}