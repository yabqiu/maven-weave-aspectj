package unmi;

import cc.unmi.aspects.MethodStartAspect;
import cc.unmi.service.UserService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class HelloAopTest {

    @Before
    public void setup() {
        MethodStartAspect.clearStartTime();
    }

    @Test
    public void testSettingMethodStartTimeInThreadLocal() {
        new UserService().fetchUserById(9999);

        assertThat(MethodStartAspect.getStartTime(), notNullValue());
    }
}