package org.cr.p20201013;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/02/23
 */
public class TestEquals {

    static class TestEqual<T> {
        T a;

        public TestEqual(T a) {
            this.a = a;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestEqual testEqual = (TestEqual) o;
            return a == testEqual.a;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a);
        }
    }

    public static void main(String[] args) {
        TestEqual testEqual = new TestEqual(2);
        HashMap<TestEqual, Integer> map = new HashMap<>();
        map.put(testEqual, 2);

        TestEqual testEqual2 = new TestEqual(2);
        map.put(testEqual2, 3);
        System.out.println(map);
    }
}
