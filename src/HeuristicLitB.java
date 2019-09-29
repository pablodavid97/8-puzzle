import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class HeuristicLitB {
    //To genereate random puzzles
    static ArrayList<Integer> list = new ArrayList();
    static int[] targetConf = {1, 2, 3, 4, 5, 6, 7, 8, 0};
    


    public static void main(String[] args) {
        double[][] XArray = new double[100][3];
        double[] yArray = new double[100];
         int[][] goal    = { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };
        Random r = new Random();
        double rangeMin = 10;
        double rangeMax = 100;
        int n = 5;
        ArrayList<Integer[]> puzzles = Fisher_Yates_Array_Shuffling.validatedPuzzlesGenerator(n);
        for (int j = 0; j < n; j++) {
                 Integer[] resObj = puzzles.get(j);
                int x1 = 0;
                int x2 = 0;
                double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
                for (int k = 0; k < 9; k++) {
                    //For x1 calculus
                    if (resObj[k] != k + 1 && resObj[k] != 0) {
                        x1++;
                    }else if (resObj[k] == 0 && k!=8){
                       x1++;
                    }

                    //For x2 calculus
                    if (k == 0) {
                        if (resObj[k] != 1) {
                            x2 = x2 + 2;
                        } else if (resObj[k] == 1) {
                            if (resObj[k + 1] != 2) {
                                x2++;
                            }
                            if (resObj[k + 3] != 4) {
                                x2++;
                            }
                        }
                    } else if (k == 1) {
                        if (resObj[k] != 2) {
                            x2 = x2 + 3;
                        } else if (resObj[k] == 2) {
                            if (resObj[k - 1] != 1) {
                                x2++;
                            }
                            if (resObj[k + 1] != 3) {
                                x2++;
                            }
                            if (resObj[k + 3] != 5) {
                                x2++;
                            }
                        }
                    } else if (k == 2) {
                        if (resObj[k] != 3) {
                            x2 = x2 + 2;
                        } else if (resObj[k] == 3) {
                            if (resObj[k - 1] != 2) {
                                x2++;
                            }
                            if (resObj[k + 3] != 6) {
                                x2++;
                            }
                        }
                    } else if (k == 3) {
                        if (resObj[k] != 4) {
                            x2 = x2 + 3;
                        } else if (resObj[k] == 4) {
                            if (resObj[k - 3] != 1) {
                                x2++;
                            }
                            if (resObj[k + 1] != 5) {
                                x2++;
                            }
                            if (resObj[k + 3] != 7) {
                                x2++;
                            }
                        }
                    } else if (k == 4) {
                        if (resObj[k] != 5) {
                            x2 = x2 + 4;
                        } else if (resObj[k] == 5) {
                            if (resObj[k - 3] != 2) {
                                x2++;
                            }
                            if (resObj[k - 1] != 4) {
                                x2++;
                            }
                            if (resObj[k + 1] != 6) {
                                x2++;
                            }
                            if (resObj[k + 3] != 8) {
                                x2++;
                            }
                        }
                    } else if (k == 5) {
                        if (resObj[k] != 6) {
                            x2 = x2+ 3;
                        } else if (resObj[k] == 5) {
                            if (resObj[k - 3] != 2) {
                                x2++;
                            }
                            if (resObj[k - 1] != 4) {
                                x2++;
                            }
                            if (resObj[k + 1] != 6) {
                                x2++;
                            }
                            if (resObj[k + 3] != 8) {
                                x2++;
                            }
                        }
                    } else if (k == 6) {
                        if (resObj[k] != 7) {
                            x2 = x2 + 2;
                        } else if (resObj[k] == 7) {
                            if (resObj[k - 3] != 4) {
                                x2++;
                            }
                            if (resObj[k + 1] != 8) {
                                x2++;
                            }
                        }
                    } else if (k == 7) {
                        if (resObj[k] != 8) {
                           x2 = x2 + 3;
                        } else if (resObj[k] == 8) {
                            if (resObj[k - 3] != 5) {
                                x2++;
                            }
                            if (resObj[k - 1] != 7) {
                                x2++;
                            }
                            if (resObj[k + 1] != 0) {
                                x2++;
                            }
                        }
                    } else if (k == 8) {
                        if (resObj[k] != 0) {
                            x2 = x2 + 2;
                        } else if (resObj[k] == 0) {
                            if (resObj[k - 3] != 6) {
                                x2++;
                            }
                            if (resObj[k - 1] != 8) {
                                x2++;
                            }
                        }
                    }

                }

                XArray[j][0] = 1;
                XArray[j][1] = x1;
                XArray[j][2] = x2/2;
                
            int p = Arrays.asList(resObj).indexOf(0);
            int xi = p/3;
            int yi = p%3;
            Puzzle solver = new Puzzle();
            int [][] m = solver.makeMatrix(resObj);
            yArray[j] = solver.solve(m,goal,xi,yi);
            }
        //Asi se obtiene los strings a reemplazar el el archivo de la regresión
        for (int j = 0; j<n; j++){
            System.out.println();
            System.out.print("{"+XArray[j][0]+ ",");
            System.out.print(XArray[j][1]+ ",");
            System.out.print(XArray[j][2]+"},");

        }
        System.out.println("*************************");
        for (int j = 0; j<n; j++){
            System.out.print(+yArray[j]+",");
        }

    }
}
