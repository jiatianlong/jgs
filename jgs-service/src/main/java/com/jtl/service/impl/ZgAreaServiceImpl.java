package com.jtl.service.impl;
import com.jtl.mapper.ZgAreaMapper;
import com.jtl.mapper.ZgAreaMapperCustom;
import com.jtl.pojo.ZgArea;
import com.jtl.service.ZgAreaService;
import com.jtl.vo.ZgAreaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ZgAreaServiceImpl implements ZgAreaService {

    @Autowired
    private ZgAreaMapper zgAreaMapper;

    @Autowired
    private ZgAreaMapperCustom zgAreaMapperCustom;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ZgArea> queryAllRootLevelArea() {
        Example example = new Example(ZgArea.class);

        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("pid",0);
        List<ZgArea> result = zgAreaMapper.selectByExample(example);
        return result;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ZgAreaVo> getZgAreaList(Integer rootId) {
        return zgAreaMapperCustom.getZgAreaList(rootId);
    }


}
