package org.testng.com.Demo;

import org.junit.Assert;
import org.testng.annotations.Test;

public class Test1
    {
        @Test
        public void te()
            {
                System.out.println("Assss");
            }
            
        @Test
        public void tse()
            {
                Assert.assertTrue(false);
            }

        @Test(enabled = false)
        public void tsse()
            {
                Assert.assertTrue(false);
            }
    }
