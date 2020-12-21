package concern;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {
    @AfterThrowing(pointcut = "execution(public * service.*.*(..))")
    public void log(){
        System.out.println("----------------------");
        System.out.println("LOI ROI BAN EHHH!");
        System.out.println("----------------------");

    }
}
