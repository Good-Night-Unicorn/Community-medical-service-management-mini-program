package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhenliaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhenliaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhenliaoxinxiView;


/**
 * 诊疗信息
 *
 * @author 
 * @email 
 * @date 2025-01-17 17:09:21
 */
public interface ZhenliaoxinxiService extends IService<ZhenliaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhenliaoxinxiVO> selectListVO(Wrapper<ZhenliaoxinxiEntity> wrapper);
   	
   	ZhenliaoxinxiVO selectVO(@Param("ew") Wrapper<ZhenliaoxinxiEntity> wrapper);
   	
   	List<ZhenliaoxinxiView> selectListView(Wrapper<ZhenliaoxinxiEntity> wrapper);
   	
   	ZhenliaoxinxiView selectView(@Param("ew") Wrapper<ZhenliaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhenliaoxinxiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ZhenliaoxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ZhenliaoxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ZhenliaoxinxiEntity> wrapper);



}

