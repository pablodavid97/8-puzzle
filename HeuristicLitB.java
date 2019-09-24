package com.company;

import java.util.ArrayList;
import java.util.Random;

public class HeuristicLitB {
    //To genereate random puzzles
    static ArrayList<Integer> list = new ArrayList();
    static int[] targetConf = {1, 2, 3, 4, 5, 6, 7, 8, 0};

    static Integer[] fisherYatesShuffling(Integer[] arr, int n) {
        Integer[] a = new Integer[n];
        int[] ind = new int[n];
        for (int i = 0; i < n; i++) {
            ind[i] = 0;
        }
        int index;
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            do {
                index = rand.nextInt(n);
            } while (ind[index] != 0);

            ind[index] = 1;
            a[i] = arr[index];
        }
        return a;
    }

    // verificar si tiene solución
    static int getInvCount(Integer arr[], int n) {
        int inv_count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    inv_count++;
                }
            }
        }
        return inv_count;
    }

    public static void main(String[] args) {
        double[][] XArray = new double[100][3];
        double[] yArray = new double[100];

        Random r = new Random();
        double rangeMin = 10;
        double rangeMax = 100;
        int count = 0;
        for (int j = 0; j < 250; j++) {
            int n = 9;
            Integer[] a = new Integer[n];
            int[] res = new int[n];
            Integer[] resObj;
            for (int i = 0; i < n; i++) {
                a[i] = new Integer(i);
            }

            resObj = fisherYatesShuffling(a, n);


            if (getInvCount(resObj, n) % 2 == 0 && count < 100) {
                int x1 = 0;
                int x2 = 0;
                double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
                for (int k = 0; k < n; k++) {
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

                XArray[count][0] = 1;
                XArray[count][1] = x1;
                XArray[count][2] = x2/2;
                yArray[count] = randomValue; //This has to be changed for manhatan cost

                count++;

            }

        }
        //Asi se obtiene los strings a reemplazar el el archivo de la regresión
        for (int j = 0; j<100; j++){
            System.out.println();
            System.out.print("{"+XArray[j][0]+ ",");
            System.out.print(XArray[j][1]+ ",");
            System.out.print(XArray[j][2]+"},");

        }
        System.out.println("*************************");
        for (int j = 0; j<100; j++){
            System.out.print(+yArray[j]+",");
        }

    }
}
