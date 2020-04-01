package com.jtl.service;

import com.jtl.pojo.Stu;

public interface StuService {

    public Stu getStuInfo(int id);

    public void saveStu();

    public void updateStu(int id);

    public void deleteStu(int id);
}
