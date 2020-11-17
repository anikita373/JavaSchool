public class operators {

    public static void main (String[] args){
        //===================== 1 =====================//
        //    Consider the following code snippet.
        //            arrayOfInts[j] > arrayOfInts[j+1]
        //    Which operators does the code contain?
        // Answer: > +
        //=============================================//

        //===================== 2 =====================//
        //    Consider the following code snippet.
        int i = 10;
        int n = i++%5;
        //My answer is:
        int answer = 0;
        if (answer == n)
        {
            System.out.printf("True");
        }
        else
        {
            System.out.printf("False");
        }

        n = ++i%5;
        answer = 1;
        if (answer == n)
        {
                System.out.println("True");
        }
        else
        {
            System.out.printf("True");
        }
        //    What are the values of i and n after the code is executed?
        //    What are the final values of i and n if instead of using
        //    the postfix increment operator (i++), you use the prefix version (++i))?
        //=============================================//

        //===================== 3 =====================//
        // To invert the value of a boolean, which operator would you use?
        boolean inverting = true;
        System.out.println(Boolean.toString(!inverting));
        //=============================================//

        //===================== 4 =====================//
        // Which operator is used to compare two values, = or == ?
        if (2 == 1)
        {
            System.out.println("Поздравляем! Вы все сломали!");
        }
        //=============================================//

        //===================== 5 =====================//
        // Which operator is used to compare two values, = or == ?
        // result = someCondition ? value1 : value2;
        // If someCondition is TRUE, assign the value of value1 to result
        //=============================================//

        //===================== 6 =====================//
        int result = 3;
        System.out.println(result);

        result -= 1;
        System.out.println(result);

        result *= 2;
        System.out.println(result);

        result /= 2;
        System.out.println(result);

        result += 8;
        result %= 7;
        System.out.println(result);
        //=============================================//

        //===================== 7 =====================//
        // System.out.println (++i) increases by one(6), then  display value.
        // System.out.println (i++) display  value (6), then increases by one.
        //=============================================//
    }

}
