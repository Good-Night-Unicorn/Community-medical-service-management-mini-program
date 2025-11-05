package com.entity.view;

import com.entity.ZhenliaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 诊疗信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-01-17 17:09:21
 */
@TableName("zhenliaoxinxi")
public class ZhenliaoxinxiView  extends ZhenliaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhenliaoxinxiView(){
	}
 
 	public ZhenliaoxinxiView(ZhenliaoxinxiEntity zhenliaoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, zhenliaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
