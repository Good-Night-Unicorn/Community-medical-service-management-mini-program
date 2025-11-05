package com.dao;

import com.entity.ZuozhenshijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZuozhenshijianVO;
import com.entity.view.ZuozhenshijianView;


/**
 * 坐诊时间
 * 
 * @author 
 * @email 
 * @date 2025-01-17 17:09:20
 */
public interface ZuozhenshijianDao extends BaseMapper<ZuozhenshijianEntity> {
	
	List<ZuozhenshijianVO> selectListVO(@Param("ew") Wrapper<ZuozhenshijianEntity> wrapper);
	
	ZuozhenshijianVO selectVO(@Param("ew") Wrapper<ZuozhenshijianEntity> wrapper);
	
	List<ZuozhenshijianView> selectListView(@Param("ew") Wrapper<ZuozhenshijianEntity> wrapper);

	List<ZuozhenshijianView> selectListView(Pagination page,@Param("ew") Wrapper<ZuozhenshijianEntity> wrapper);

	
	ZuozhenshijianView selectView(@Param("ew") Wrapper<ZuozhenshijianEntity> wrapper);
	

}
