//package mybatis.Util.Lambdas.FactorLambdaDemo2;
//
///**
// * Created by aaron on 7/28/17.
// */
//class FactorialLambdaDemo2 {
//        public static void main(String args[]) {
//
//            // This block lambda computes the factorial of an int value.
//            long lambdaStart = System.nanoTime();
//
//            NumericFunc factorial = (unicorn) ->  {
//                int result = 1;
//
//                for(int i=1; i <= unicorn; i++)
//                    result = i * result;
//
//                return result;
//            };
//
//            factorial.func(3);
//            factorial.func(4);
//            factorial.func(5);
//            long lambdaEnd = System.nanoTime();
//            System.out.println("lambda = " + (lambdaEnd - lambdaStart));
//
//
//            long anonInnerStart = System.nanoTime();
//            NumericFunc funkydunk = new NumericFunc() {
//                @Override
//                public int func(int n) {
//                    int result = 1;
//
//                    for(int i=1; i <= n; i++)
//                        result = i * result;
//
//                    return result;
//                }
//            };
//
//            funkydunk.func(3);
//            funkydunk.func(4);
//            funkydunk.func(5);
//            long anonInnerEnd = System.nanoTime();
//            System.out.println("anonInner = " + (anonInnerEnd - anonInnerStart));
//
//
//            long standardStart = System.nanoTime();
//            NumericFuncImpl funky = new NumericFuncImpl();
//
//            funky.func(3);
//            funky.func(4);
//            funky.func(5);
//            long standardEnd = System.nanoTime();
//            System.out.println("standard = " + (standardEnd - standardStart));
//
////        System.out.println("The factoral of 3 is " + factorial.func(3));
////        System.out.println("The factoral of 3 is " + factorial.func(5));
////        System.out.println("The factoral of 5 is " + factorial.func(9));
//        }
//    }
