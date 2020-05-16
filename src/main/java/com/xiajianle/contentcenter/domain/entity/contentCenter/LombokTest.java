package com.xiajianle.usercenter.domain.entity.contentCenter;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class LombokTest {
    //UserReg reg = new UserReg();
    public void aa()
    {
        //reg.getMail();
        UserReg.builder().mail("MAIL").password("123");
    }


}
@Builder
@Data
class UserReg{

    private String mail;
    private String password;
}