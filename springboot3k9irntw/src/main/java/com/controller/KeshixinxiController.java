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

import com.entity.KeshixinxiEntity;
import com.entity.view.KeshixinxiView;

import com.service.KeshixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 科室信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-17 17:09:20
 */
@RestController
@RequestMapping("/keshixinxi")
public class KeshixinxiController {
    @Autowired
    private KeshixinxiService keshixinxiService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KeshixinxiEntity keshixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			keshixinxi.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KeshixinxiEntity> ew = new EntityWrapper<KeshixinxiEntity>();



		PageUtils page = keshixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, keshixinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KeshixinxiEntity keshixinxi, 
		HttpServletRequest request){
        EntityWrapper<KeshixinxiEntity> ew = new EntityWrapper<KeshixinxiEntity>();

		PageUtils page = keshixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, keshixinxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KeshixinxiEntity keshixinxi){
       	EntityWrapper<KeshixinxiEntity> ew = new EntityWrapper<KeshixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( keshixinxi, "keshixinxi")); 
        return R.ok().put("data", keshixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KeshixinxiEntity keshixinxi){
        EntityWrapper< KeshixinxiEntity> ew = new EntityWrapper< KeshixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( keshixinxi, "keshixinxi")); 
		KeshixinxiView keshixinxiView =  keshixinxiService.selectView(ew);
		return R.ok("查询科室信息成功").put("data", keshixinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KeshixinxiEntity keshixinxi = keshixinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(keshixinxi,deSens);
        return R.ok().put("data", keshixinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KeshixinxiEntity keshixinxi = keshixinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(keshixinxi,deSens);
        return R.ok().put("data", keshixinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KeshixinxiEntity keshixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(keshixinxi);
        keshixinxiService.insert(keshixinxi);
        return R.ok().put("data",keshixinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KeshixinxiEntity keshixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(keshixinxi);
        keshixinxiService.insert(keshixinxi);
        return R.ok().put("data",keshixinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KeshixinxiEntity keshixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(keshixinxi);
        //全部更新
        keshixinxiService.updateById(keshixinxi);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        keshixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	












}
