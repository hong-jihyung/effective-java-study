package study.effectivejava.chapter3.item10;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * equals 는 일반 규약을 지켜 재정의해라
 */
public class Item10 {
    private final Logger log = LoggerFactory.getLogger(getClass());

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
}
