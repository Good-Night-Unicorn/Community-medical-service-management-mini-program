package com.entity.view;

import com.entity.GuahaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 挂号信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-01-17 17:09:20
 */
@TableName("guahaoxinxi")
public class GuahaoxinxiView  extends GuahaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GuahaoxinxiView(){
	}
 
 	public GuahaoxinxiView(GuahaoxinxiEntity guahaoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, guahaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
