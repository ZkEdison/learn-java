package ExceptionDay01;

import java.awt.*;
import java.io.IOException;

/**
 * 重写父类一个含有throws 异常抛出声明的方法时, 子类该方法的throws的重写原著
 */
public class ExceptionDemo03 {
    public void dosome() throws IOException, AWTException{

    }
}

class Son extends ExceptionDemo03 {
    @Override
    public void dosome() {
//        super.dosome();
    }
}
