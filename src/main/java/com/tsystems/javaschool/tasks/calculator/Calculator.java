package com.tsystems.javaschool.tasks.calculator;
import javax.script.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;


public class Calculator {

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */
    public String evaluate(String statement) {
            try{
                if(statement.contains(",")||statement.contains("**")||statement.contains("++")||statement.contains("--")||statement.contains("//")) return null;
            }
            catch (NullPointerException e){
                return null;
            }
            ScriptEngineManager factory = new ScriptEngineManager();
            // create a JavaScript engine
            ScriptEngine engine = factory.getEngineByName("JavaScript");
            //setting the format max is 4 digits and min is 0
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(4);
            df.setMinimumFractionDigits(0);
        try {
            // evaluate JavaScript code from String
            BigDecimal ans = new BigDecimal(engine.eval(statement).toString()).setScale(4,BigDecimal.ROUND_HALF_UP);
//            System.out.println(ans);
            String answer = df.format(ans);
            return answer.replace(",",".");
        }
        catch (Exception e){
            return null;
        }
    }


}
