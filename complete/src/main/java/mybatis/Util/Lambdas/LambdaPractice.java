//package mybatis.Util.Lambdas;
//
///**
// * Created by aaron on 7/28/17.
// */
//@FunctionalInterface
//public interface LambdaPractice {
//
//    public int practice(int x, int y);
//}
//
//class LambdaDemos{
//    public static void main(String[] args) {
//
//       LambdaPractice sumLambda = (a, b) -> {
//            return a + b;
//        };
//
//        LambdaPractice multLambda = (a, b) -> {
//            return a * b;
//        };
//
//        int x = sumLambda.practice(2,4);
//        System.out.println(x);
//
//        int y = multLambda.practice(2,4);
//        System.out.println(y);
//
//
//        // annonymous innerclass below
//        LambdaPractice anonInner = new LambdaPractice() {
//            @Override
//            public int practice(int x, int y) {
//                return x + y;
//            }
//        };
//
//        int anon = anonInner.practice(2,5);
//        System.out.println(anon);
//    }
//
//
//}
