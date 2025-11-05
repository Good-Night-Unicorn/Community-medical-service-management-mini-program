package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import java.util.Collections;

import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZuozhenshijianEntity;
import com.entity.view.ZuozhenshijianView;

import com.service.ZuozhenshijianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 坐诊时间
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-17 17:09:20
 */
@RestController
@RequestMapping("/zuozhenshijian")
public class ZuozhenshijianController {
    @Autowired
    private ZuozhenshijianService zuozhenshijianService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuozhenshijianEntity zuozhenshijian,
		HttpServletRequest request){
        EntityWrapper<ZuozhenshijianEntity> ew = new EntityWrapper<ZuozhenshijianEntity>();



		PageUtils page = zuozhenshijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuozhenshijian), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuozhenshijianEntity zuozhenshijian, 
		HttpServletRequest request){
        EntityWrapper<ZuozhenshijianEntity> ew = new EntityWrapper<ZuozhenshijianEntity>();

		PageUtils page = zuozhenshijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuozhenshijian), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuozhenshijianEntity zuozhenshijian){
       	EntityWrapper<ZuozhenshijianEntity> ew = new EntityWrapper<ZuozhenshijianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuozhenshijian, "zuozhenshijian")); 
        return R.ok().put("data", zuozhenshijianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuozhenshijianEntity zuozhenshijian){
        EntityWrapper< ZuozhenshijianEntity> ew = new EntityWrapper< ZuozhenshijianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuozhenshijian, "zuozhenshijian")); 
		ZuozhenshijianView zuozhenshijianView =  zuozhenshijianService.selectView(ew);
		return R.ok("查询坐诊时间成功").put("data", zuozhenshijianView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuozhenshijianEntity zuozhenshijian = zuozhenshijianService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zuozhenshijian,deSens);
        return R.ok().put("data", zuozhenshijian);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuozhenshijianEntity zuozhenshijian = zuozhenshijianService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zuozhenshijian,deSens);
        return R.ok().put("data", zuozhenshijian);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuozhenshijianEntity zuozhenshijian, HttpServletRequest request){
        if(zuozhenshijianService.selectCount(new EntityWrapper<ZuozhenshijianEntity>().eq("zuozhenshijian", zuozhenshijian.getZuozhenshijian()))>0) {
            return R.error("坐诊时间已存在");
        }
    	//ValidatorUtils.validateEntity(zuozhenshijian);
        zuozhenshijianService.insert(zuozhenshijian);
        return R.ok().put("data",zuozhenshijian.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZuozhenshijianEntity zuozhenshijian, HttpServletRequest request){
        if(zuozhenshijianService.selectCount(new EntityWrapper<ZuozhenshijianEntity>().eq("zuozhenshijian", zuozhenshijian.getZuozhenshijian()))>0) {
            return R.error("坐诊时间已存在");
        }
    	//ValidatorUtils.validateEntity(zuozhenshijian);
        zuozhenshijianService.insert(zuozhenshijian);
        return R.ok().put("data",zuozhenshijian.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZuozhenshijianEntity zuozhenshijian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuozhenshijian);
        if(zuozhenshijianService.selectCount(new EntityWrapper<ZuozhenshijianEntity>().ne("id", zuozhenshijian.getId()).eq("zuozhenshijian", zuozhenshijian.getZuozhenshijian()))>0) {
            return R.error("坐诊时间已存在");
        }
        //全部更新
        zuozhenshijianService.updateById(zuozhenshijian);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuozhenshijianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	












}
