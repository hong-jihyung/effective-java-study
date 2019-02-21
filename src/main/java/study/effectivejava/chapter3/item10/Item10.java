package study.effectivejava.chapter3.item10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * equals 는 일반 규약을 지켜 재정의해라
 */
@Slf4j
public class Item10 {

    @Test
    public void p55() {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        assertTrue(cis.equals(s));
        assertFalse(s.equals(cis));

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        log.info("{} {}", cis.hashCode(), s.hashCode());

        assertTrue(list.contains(cis));
        assertFalse(list.contains(s));
    }

    @AllArgsConstructor
    class Tt {
        String aa;
        int bb;

    }

    @AllArgsConstructor
    @EqualsAndHashCode
    class Toverride {
        String aa;
        int bb;

    }

    @Test
    public void 해시코드_equals_재정의_안한_case() {
        Tt t1 = new Tt("aaa", 11);
        Tt t2 = new Tt("aaa", 11);

        log.info("t1:{}, t2:{}", t1.hashCode(), t2.hashCode());
        log.info("t1 == t2 {}", t1 == t2);
        log.info("t1.equals(t2) {}", t1.equals(t2));
    }

    @Test
    public void 해시코드_equals_재정의_case() {
        Toverride t1 = new Toverride("aaa", 11);
        Toverride t2 = new Toverride("aaa", 11);

        log.info("t1:{}, t2:{}", t1.hashCode(), t2.hashCode());
        log.info("t1 == t2 {}", t1 == t2);
        log.info("t1.equals(t2) {}", t1.equals(t2));
    }

    @Test
    public void tt() {

    }
}
