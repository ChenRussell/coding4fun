package org.cr.juc.kkb;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Exchanger;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding-for-offer
 * @date 2021/07/08
 */
public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger<CustBook> exchanger = new Exchanger<>();
        // Starting two threads
        new Thread(new ExchangerOne(exchanger)).start();
        new Thread(new ExchangerTwo(exchanger)).start();
    }
}

@Data
class CustBook {

    private String name;
}

@Slf4j
class ExchangerOne implements Runnable {

    Exchanger<CustBook> ex;

    ExchangerOne(Exchanger<CustBook> ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        CustBook custBook = new CustBook();
        custBook.setName("book one");

        try {
            CustBook exhangeCustBook = ex.exchange(custBook);
            log.info(exhangeCustBook.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
@Slf4j
class ExchangerTwo implements Runnable {

//    Logger log = LoggerFactory.getLogger(ExchangerTwo.class);
    Exchanger<CustBook> ex;

    ExchangerTwo(Exchanger<CustBook> ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        CustBook custBook = new CustBook();
        custBook.setName("book two");

        try {
            CustBook exhangeCustBook = ex.exchange(custBook);
            log.info(exhangeCustBook.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
