package com.entity.view;

import com.entity.ZuozhenshijianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 坐诊时间
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-01-17 17:09:20
 */
@TableName("zuozhenshijian")
public class ZuozhenshijianView  extends ZuozhenshijianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZuozhenshijianView(){
	}
 
 	public ZuozhenshijianView(ZuozhenshijianEntity zuozhenshijianEntity){
 	try {
			BeanUtils.copyProperties(this, zuozhenshijianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
