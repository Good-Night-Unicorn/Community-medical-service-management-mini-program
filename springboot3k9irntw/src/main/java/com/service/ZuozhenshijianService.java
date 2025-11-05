package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZuozhenshijianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZuozhenshijianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuozhenshijianView;


/**
 * 坐诊时间
 *
 * @author 
 * @email 
 * @date 2025-01-17 17:09:20
 */
public interface ZuozhenshijianService extends IService<ZuozhenshijianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuozhenshijianVO> selectListVO(Wrapper<ZuozhenshijianEntity> wrapper);
   	
   	ZuozhenshijianVO selectVO(@Param("ew") Wrapper<ZuozhenshijianEntity> wrapper);
   	
   	List<ZuozhenshijianView> selectListView(Wrapper<ZuozhenshijianEntity> wrapper);
   	
   	ZuozhenshijianView selectView(@Param("ew") Wrapper<ZuozhenshijianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuozhenshijianEntity> wrapper);

   	

}

