package com.xiaozhengkeji.nasplus.bean;

import com.xiaozhengkeji.nasplus.entitys.UserPoJo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class LoginBean implements Serializable {
    private UserPoJo userPoJo;
    private String Token;
}
