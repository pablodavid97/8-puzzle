package com.company;

import Jama.Matrix;

public class BetaValues {

    public static void main(String[] args) {
        double[] BetaArray = new double[3];
        double[][] XArray = {{1.0,9.0,12.0},
                {1.0,8.0,12.0},
                {1.0,9.0,12.0},
                {1.0,8.0,12.0},
                {1.0,9.0,12.0},
                {1.0,8.0,12.0},
                {1.0,7.0,11.0},
                {1.0,8.0,12.0},
                {1.0,8.0,12.0},
                {1.0,7.0,12.0},
                {1.0,7.0,10.0},
                {1.0,7.0,12.0},
                {1.0,9.0,12.0},
                {1.0,8.0,12.0},
                {1.0,7.0,12.0},
                {1.0,8.0,12.0},
                {1.0,9.0,12.0},
                {1.0,7.0,10.0},
                {1.0,7.0,11.0},
                {1.0,8.0,10.0},
                {1.0,9.0,12.0},
                {1.0,8.0,12.0},
                {1.0,8.0,12.0},
                {1.0,8.0,12.0},
                {1.0,9.0,12.0},
                {1.0,8.0,12.0},
                {1.0,6.0,12.0},
                {1.0,9.0,12.0},
                {1.0,8.0,12.0},
                {1.0,9.0,12.0},
                {1.0,9.0,12.0},
                {1.0,8.0,12.0},
                {1.0,6.0,11.0},
                {1.0,9.0,12.0},
                {1.0,8.0,12.0},
                {1.0,8.0,12.0},
                {1.0,8.0,12.0},
                {1.0,6.0,10.0},
                {1.0,7.0,12.0},
                {1.0,7.0,12.0},
                {1.0,8.0,12.0},
                {1.0,9.0,12.0},
                {1.0,7.0,10.0},
                {1.0,8.0,12.0},
                {1.0,6.0,9.0},
                {1.0,9.0,12.0},
                {1.0,9.0,12.0},
                {1.0,9.0,12.0},
                {1.0,8.0,12.0},
                {1.0,6.0,12.0},
                {1.0,9.0,12.0},
                {1.0,7.0,12.0},
                {1.0,8.0,12.0},
                {1.0,8.0,12.0},
                {1.0,9.0,12.0},
                {1.0,8.0,10.0},
                {1.0,9.0,12.0},
                {1.0,7.0,12.0},
                {1.0,7.0,12.0},
                {1.0,9.0,12.0},
                {1.0,8.0,12.0},
                {1.0,9.0,12.0},
                {1.0,8.0,12.0},
                {1.0,8.0,12.0},
                {1.0,8.0,12.0},
                {1.0,7.0,12.0},
                {1.0,8.0,10.0},
                {1.0,9.0,12.0},
                {1.0,6.0,12.0},
                {1.0,7.0,12.0},
                {1.0,9.0,12.0},
                {1.0,8.0,12.0},
                {1.0,9.0,12.0},
                {1.0,6.0,10.0},
                {1.0,8.0,12.0},
                {1.0,7.0,11.0},
                {1.0,9.0,12.0},
                {1.0,7.0,11.0},
                {1.0,8.0,12.0},
                {1.0,7.0,12.0},
                {1.0,9.0,12.0},
                {1.0,8.0,12.0},
                {1.0,6.0,10.0},
                {1.0,8.0,12.0},
                {1.0,8.0,12.0},
                {1.0,8.0,12.0},
                {1.0,9.0,12.0},
                {1.0,8.0,12.0},
                {1.0,6.0,11.0},
                {1.0,9.0,12.0},
                {1.0,7.0,10.0},
                {1.0,9.0,12.0},
                {1.0,7.0,11.0},
                {1.0,7.0,12.0},
                {1.0,9.0,12.0},
                {1.0,6.0,10.0},
                {1.0,9.0,12.0},
                {1.0,6.0,10.0},
                {1.0,9.0,12.0},
                {1.0,7.0,12.0}
        };

        double[] yArray = {76.2553389101055,42.463203614854805,93.18090705869224,67.22309780265255,27.813439257513522,84.32319359427703,35.654915516111544,16.308857087758483,76.77919924811869,52.97294287053755,91.76650748580397,68.7794127090502,95.08968926787831,97.82932136532885,74.85275834182384,41.02838293851444,70.642582209464,23.216527548148377,66.04435290894084,82.76234813318077,51.053516101370505,33.612596851445815,33.06011189736029,26.278529002690917,15.561588216945482,73.65328999703371,97.45862758577583,43.95949133845158,85.2932232832684,83.25257828697603,47.59342180224703,85.63802002780967,67.49511912454273,80.23991439204322,73.82465870916013,69.68252407912647,35.0597703841997,77.76802429737069,97.15958401085885,61.66320470514613,28.69252673932552,41.41095545657009,22.425541086990247,42.28135267345159,85.40702558034074,21.350638940752752,42.32347630197407,91.87903802495214,33.6861987578455,78.3412238501838,89.26659880530467,32.29360526454191,42.60897184567338,98.24398485660697,47.77786731856824,58.08123817120958,29.51816526267999,68.84159592745462,21.40175402833553,38.206073840737695,58.39296551231445,74.36908417434962,84.57975939761269,96.17614540384346,38.9897757324667,17.739804568740652,11.74586001347141,61.30465210032684,35.028093967133344,17.79828483730702,23.017213718293238,46.28488313124285,68.22350355956675,39.09778153002921,18.28703429669197,26.58933399184978,93.80770238692592,54.67896765069835,49.27074015995269,65.33834526825672,72.32595015691894,18.117103318737556,92.1131128288947,73.23084882531592,11.965135609808076,49.708632146568604,81.533301068725,56.88960136533399,55.44110900098391,33.0841184186399,41.16622547940479,50.545476998428576,55.56178851442589,32.76295199696924,33.75299187814919,95.37027243772187,43.98294626963967,30.206311223586543,19.139610334327248,47.964613515968324
        };

        Matrix X = new Matrix(XArray);
        Matrix Y = new Matrix(yArray, yArray.length);
        Matrix XT = X.transpose();

        Matrix BETA = (XT.times(X)).inverse().times(XT).times(Y);
        BETA.print(12, 7);

    }
}
