package com.jtl.controller;

import org.springframework.stereotype.Controller;

import java.io.File;

@Controller
public class BaseController {

    //每页显示的条数
    public static final Integer COMENT_PAGE_SIZE = 10;
    public static final Integer PAGE_SIZE = 20;


    //用户上传头像的位置
    public static final String IMAGE_USER_FACE_LOCATION = "E:"+ File.separator +"img";

}
