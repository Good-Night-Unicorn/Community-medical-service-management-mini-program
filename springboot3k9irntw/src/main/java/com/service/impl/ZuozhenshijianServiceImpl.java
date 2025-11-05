package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZuozhenshijianDao;
import com.entity.ZuozhenshijianEntity;
import com.service.ZuozhenshijianService;
import com.entity.vo.ZuozhenshijianVO;
import com.entity.view.ZuozhenshijianView;

@Service("zuozhenshijianService")
public class ZuozhenshijianServiceImpl extends ServiceImpl<ZuozhenshijianDao, ZuozhenshijianEntity> implements ZuozhenshijianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuozhenshijianEntity> page = this.selectPage(
                new Query<ZuozhenshijianEntity>(params).getPage(),
                new EntityWrapper<ZuozhenshijianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuozhenshijianEntity> wrapper) {
		  Page<ZuozhenshijianView> page =new Query<ZuozhenshijianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZuozhenshijianVO> selectListVO(Wrapper<ZuozhenshijianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZuozhenshijianVO selectVO(Wrapper<ZuozhenshijianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZuozhenshijianView> selectListView(Wrapper<ZuozhenshijianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuozhenshijianView selectView(Wrapper<ZuozhenshijianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
