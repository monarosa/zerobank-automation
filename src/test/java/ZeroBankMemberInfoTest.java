
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ZeroBankMemberInfoTest {

    @Test
    public void  isMemberolder18Test(){
        ZeroBankMemberInfo memberInfo=
                new ZeroBankMemberInfo("mustafa",'M',1988,3456);
        Assert.assertTrue(memberInfo.isMemberOlder18( memberInfo.getAge()));

    }
}
