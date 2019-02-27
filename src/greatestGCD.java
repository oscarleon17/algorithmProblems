public class greatestGCD {

        public static int getGCD(int a, int b){

            if(a == 0){
                return b;
            }
            return getGCD(b % a, a);
        }

        public static int generalizedGCD(int arr[])
        {
            int greatestCD = arr[0];
            int arrayLength = arr.length;

            for(int i = 1; i < arrayLength; i++){
                greatestCD = getGCD(arr[i], greatestCD);
            }

            return greatestCD;

        }
}

