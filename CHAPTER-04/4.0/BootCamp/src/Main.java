import KNU.UTIL;

public class Main {
    static String TAG = Main.class.getName();
    public static short countBits_DEBUG(long x) {
        UTIL.LOG(5, TAG, String.format("START OF countBits(%d)", x));
        short numBits = 0;
        while (x != 0) {
            UTIL.LOG(5, TAG,String.format("numBits BEFORE : %d", numBits));
            numBits += (x & 1) ;
            UTIL.LOG(5, TAG,String.format("numBits AFTER  : %d", numBits));

            UTIL.LOG(5, TAG,String.format("x value BEFORE : %10s", Long.toBinaryString(x)));
            x >>>= 1;
            UTIL.LOG(5, TAG,String.format("x value AFTER  : %10s", Long.toBinaryString(x)));
        }
        UTIL.LOG(5, TAG,String.format("End of while : numBits IS : %d", numBits));
        return numBits;
    }

    public static int countBits_COMMENT(long x) {
        int numBits = 0; // 결과값 초기화
        while (x != 0) { // 모든 비트가 0 이므로 더이상 numBits 를 증가시킬 필요 없음
            numBits += (x & 1) ; // x의 최하위 비트가 1이면 numBits를 1 증가
/*
            if((x & 1) == 1) {
//                numBits = numBits + 1;
                numBits += 1;
            }
//*/
            x >>>= 1; // x 를 오른쪽으로 1 bit 시프트, 최상위 비트는 0으로 채움
                      // x >>= 1 : 최상위 비트는 그대로 두고 나머지 비트만 시프트
        }
        return numBits;
    }

    public static int countBits(long x) {
        int numBits = 0;
        while (x != 0) {
            numBits += (x & 1);
            x >>>= 1;
        }
        return numBits;
    }

    public static void main(String[] args) {
//        int RESULT0 = countBits(922337236854775807L);
//        int RESULT1 = Long.bitCount(922337236854775807L);
        int RESULT0 = countBits_DEBUG(0xA7);
        int RESULT1 = Long.bitCount(0xAA);
        UTIL.LOG(3, TAG,String.format("Method Result : %d .vs. %d", RESULT0, RESULT1));

/*
        Character K = 'a';
        // Character[] c = new char[]{'a','b','c'}; <- Compile ERROR
        int KL = 345;
        Integer I = KL;
        int[] II = new int[]{3,4,5};
//*/
    }
}