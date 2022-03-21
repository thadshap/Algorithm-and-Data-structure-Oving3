import java.util.Date;

public class Exercise {
    public static void main(String args[]) {
        int[] numbers = populateArray(1000000,1,100);
        int[] numbers10 = populateArray(1000000,1,100);
        int[] numbers100 = populateArray(1000000,1,100);
        int[] numbers1000 = populateArray(1000000,1,100);
        int[] numbers10000 = populateArray(1000000,1,100);
        int[] numbers100000 = populateArray(1000000,1,100);

        System.out.println("All the lists used in those tests bellow has length 1 000 000:");

        System.out.println("Sort 1 000 000 elements with Quicksort and 10 elements with Selectionsort");
        Date start = new Date();
        int rounds = 0;
        double time;
        Date end;
        do {
            quicksort(numbers10, 0, numbers10.length - 1,10);
            end = new Date();
            rounds++;
        }while ((end.getTime()-start.getTime())<10000);
        time = (double)
                (end.getTime()-start.getTime()) / rounds;
        System.out.println("Millisekund pr. runde:" + time+"\n");


        System.out.println("Sort 1 000 000 elements with Quicksort and 100 elements with Selectionsort");
        Date start1 = new Date();
        int rounds1 = 0;
        double time1;
        Date end1;
        do {
            quicksort(numbers100,0,numbers100.length-1,100);
            end1 = new Date();
            rounds1++;
        }while ((end1.getTime()-start1.getTime())<10000);
        time1 = (double)
                (end1.getTime()-start1.getTime()) / rounds1;
        System.out.println("Millisekund pr. runde:" + time1+"\n");


        System.out.println("Sort 1 000 000 elements with Quicksort and 1000 elements with Selectionsort");
        Date start2 = new Date();
        int rounds2 = 0;
        double time2;
        Date end2;
        do {
            quicksort(numbers1000,0,numbers1000.length-1,1000);
            end2 = new Date();
            rounds2++;
        }while ((end2.getTime()-start2.getTime())<10000);
        time2 = (double)
                (end2.getTime()-start2.getTime()) / rounds2;
        System.out.println("Millisekund pr. runde:" + time2+"\n");


        System.out.println("Sort 1 000 000 elements with Quicksort and 10 000 elements with Selectionsort");
        Date start3 = new Date();
        int rounds3 = 0;
        double time3;
        Date end3;
        do {
            quicksort(numbers10000,0,numbers10000.length-1,10000);
            end3 = new Date();
            rounds3++;
        }while ((end3.getTime()-start3.getTime())<10000);
        time3 = (double)
                (end3.getTime()-start3.getTime()) / rounds3;
        System.out.println("Millisekund pr. runde:" + time3+"\n");


        System.out.println("Sort 1 000 000 elements with Quicksort and 100 000 elements with Selectionsort");
        Date start4 = new Date();
        int rounds4 = 0;
        double time4;
        Date end4;
        do {
            quicksort(numbers100000,0,numbers1000.length-1,100000);
            end4 = new Date();
            rounds4++;
        }while ((end4.getTime()-start4.getTime())<10000);
        time4 = (double)
                (end4.getTime()-start4.getTime()) / rounds4;
        System.out.println("Millisekund pr. runde:" + time4+"\n");


        System.out.println("Before quicksort the sum is "+getSum(numbers));
        if (checkSorted(numbers)){
            System.out.println("Before quicksort the list is sorted");
        } else {
            System.out.println("Before quicksort the list is NOT sorted");
        }

        quicksort(numbers,0,numbers.length-1,10);

        System.out.println("After quicksort the sum is "+getSum(numbers));
        if (checkSorted(numbers)){
            System.out.println("After quicksort the list is sorted");
        } else {
            System.out.println("After quicksort the list is NOT sorted");
        }

    }
    private static boolean checkSorted(int []t){
        boolean isSorted = true;
        for (int i = 0; i<t.length-1; i++){
            if (t[i]>t[i+1]){
                isSorted = false;
            }
        }
        return isSorted;
    }

    private static int getSum(int []t){
        int sum = 0;
        for (int element : t){
            sum += element;
        }
        return sum;
    }

    private static int[] populateArray(int length, int min, int max){
        int []t = new int[length];
        for (int i = 0; i<length; i++) {
            t[i] = getRandomIntegerBetweenRange(min,max);
        }
        return t;
    }

    public static int getRandomIntegerBetweenRange(int min, int max){
        int x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    private static int median3sort ( int [] t , int v , int h) {
        int m = (v + h) / 2;                    // indeksen til midterste element
        if (t [v] > t [m ]) bytt (t , v , m );  // 6,5,4,1 -> 5,6,4,1
                                                // indeksen til m i dette tilfellet er 1
        if (t [m] > t [h ]) {
            bytt (t , m , h );                      // -> 5,1,4,6
            if (t [v] > t [m ]) bytt (t , v , m );  // -> 1,5,4,6
        }
        return m;
    }

    public static void quicksort ( int []t , int v , int h, int s) {
        if (h - v > s) { //sjekker om lista består flere enn 3 elementer
            int delepos = splitt (t , v , h ); // indeksen til pivot
            quicksort (t , v , delepos - 1,s);
            quicksort (t , delepos + 1, h,s);
        } else selectionSort(t,v,h);
    }

    /**
     * Metode for å finne pivot elementet
     * @param t
     * @param v
     * @param h
     * @return indeksen til pivot elementet
     */
    private static int splitt ( int [] t , int v , int h ) {
        int iv , ih ;
        int m = median3sort (t , v , h ); //1,4,3,6,7,2,9 (etter median3sort)
        int dv = t[ m ];                  // mellomlagrer verdien til medianen dv = 6
        bytt (t , m , h - 1);          //1,4,3,2,7,6,9
        for ( iv = v , ih = h - 1;;) {   // iv = 0 & ih = 5
            while (t [++ iv ] < dv ) ;   // -> iv = 4 , t[4]=7
            while (t [-- ih ] > dv ) ;   // -> ih = 3 , t[3]=2
            if ( iv >= ih ) break ;
            bytt (t , iv , ih );
        }
        bytt (t , iv , h -1);         // 1,4,3,2,6,7,9
        return iv ;                     // iv = 4
    }

    /**
     * Metode for å bytte elementers plassering
     * @param t
     * @param i
     * @param j
     */
    private static void bytt(int[]t, int i, int j){
        int k = t[j];  //5,7,2,4,9
                       // k = 9
        t[j] = t[i];   //5,7,2,4,5
        t[i] = k;      //9,7,2,4,5
    }

    public static void selectionSort(int[] arr, int v, int h) {
        for (int i = v; i < h; i++) {
            int index = i;
            for (int j = i + 1; j < h + 1; j++) {
                if (arr[j] < arr[index]) {
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }

    }
    }
