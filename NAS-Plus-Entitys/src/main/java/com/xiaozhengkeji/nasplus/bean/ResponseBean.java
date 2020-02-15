package com.xiaozhengkeji.nasplus.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors( chain = true )
public class ResponseBean implements Serializable {
    //Http状态码
    private int code;

    //返回信息
    private String msg;

    //返回的数据
    private Object data;

    public ResponseBean(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
