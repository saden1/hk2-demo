package com.github.saden1.hk2.runlevel;

import com.github.saden1.hk2.runlevel.kernel.Kernel;
import javax.inject.Inject;
import org.jvnet.testing.hk2testng.HK2;
import org.testng.annotations.Test;

/**
 *
 * @author saden
 */
@HK2
public class SecondaryITest {

    @Inject
    Kernel lifeCycle;

    @Test
    public void test() {
        System.out.println("Running secondary integration test");
    }
}
