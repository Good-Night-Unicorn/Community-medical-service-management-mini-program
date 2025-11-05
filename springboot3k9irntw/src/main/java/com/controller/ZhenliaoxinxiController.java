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

import com.entity.ZhenliaoxinxiEntity;
import com.entity.view.ZhenliaoxinxiView;

import com.service.ZhenliaoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 诊疗信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-17 17:09:21
 */
@RestController
@RequestMapping("/zhenliaoxinxi")
public class ZhenliaoxinxiController {
    @Autowired
    private ZhenliaoxinxiService zhenliaoxinxiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhenliaoxinxiEntity zhenliaoxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			zhenliaoxinxi.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("huanzhe")) {
			zhenliaoxinxi.setHuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhenliaoxinxiEntity> ew = new EntityWrapper<ZhenliaoxinxiEntity>();



		PageUtils page = zhenliaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhenliaoxinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhenliaoxinxiEntity zhenliaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<ZhenliaoxinxiEntity> ew = new EntityWrapper<ZhenliaoxinxiEntity>();

		PageUtils page = zhenliaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhenliaoxinxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhenliaoxinxiEntity zhenliaoxinxi){
       	EntityWrapper<ZhenliaoxinxiEntity> ew = new EntityWrapper<ZhenliaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhenliaoxinxi, "zhenliaoxinxi")); 
        return R.ok().put("data", zhenliaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhenliaoxinxiEntity zhenliaoxinxi){
        EntityWrapper< ZhenliaoxinxiEntity> ew = new EntityWrapper< ZhenliaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhenliaoxinxi, "zhenliaoxinxi")); 
		ZhenliaoxinxiView zhenliaoxinxiView =  zhenliaoxinxiService.selectView(ew);
		return R.ok("查询诊疗信息成功").put("data", zhenliaoxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhenliaoxinxiEntity zhenliaoxinxi = zhenliaoxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zhenliaoxinxi,deSens);
        return R.ok().put("data", zhenliaoxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhenliaoxinxiEntity zhenliaoxinxi = zhenliaoxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zhenliaoxinxi,deSens);
        return R.ok().put("data", zhenliaoxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhenliaoxinxiEntity zhenliaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhenliaoxinxi);
        zhenliaoxinxiService.insert(zhenliaoxinxi);
        return R.ok().put("data",zhenliaoxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhenliaoxinxiEntity zhenliaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhenliaoxinxi);
        zhenliaoxinxiService.insert(zhenliaoxinxi);
        return R.ok().put("data",zhenliaoxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhenliaoxinxiEntity zhenliaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhenliaoxinxi);
        //全部更新
        zhenliaoxinxiService.updateById(zhenliaoxinxi);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhenliaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








        /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_zhenliaoxinxi_" + xColumnName + "_" + yColumnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<ZhenliaoxinxiEntity> ew = new EntityWrapper<ZhenliaoxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
                                            if(tableName.equals("yisheng")) {
            ew.eq("yishengzhanghao", (String)request.getSession().getAttribute("username"));
        }
                    if(tableName.equals("huanzhe")) {
            ew.eq("huanzhezhanghao", (String)request.getSession().getAttribute("username"));
        }
                                List<Map<String, Object>> result = zhenliaoxinxiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        Collections.sort(result, (map1, map2) -> {
            // 假设 total 总是存在并且是数值类型
            Number total1 = (Number) map1.get("total");
            Number total2 = (Number) map2.get("total");
            if(total1==null)
            {
                total1 = 0;
            }
            if(total2==null)
            {
                total2 = 0;
            }
            return Double.compare(total2.doubleValue(), total1.doubleValue());
        });
        return R.ok().put("data", result);
        }
    }
    
    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul,HttpServletRequest request)  throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_zhenliaoxinxi_" + xColumnName + "_" + yColumnNameMul + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ZhenliaoxinxiEntity> ew = new EntityWrapper<ZhenliaoxinxiEntity>();
String tableName = request.getSession().getAttribute("tableName").toString();
                                            if(tableName.equals("yisheng")) {
            ew.eq("yishengzhanghao", (String)request.getSession().getAttribute("username"));
        }
                    if(tableName.equals("huanzhe")) {
            ew.eq("huanzhezhanghao", (String)request.getSession().getAttribute("username"));
        }
                            for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = zhenliaoxinxiService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
}
    
    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_zhenliaoxinxi_" + xColumnName + "_" + yColumnName + "_"+timeStatType+".json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("xColumn", xColumnName);
            params.put("yColumn", yColumnName);
            params.put("timeStatType", timeStatType);
            EntityWrapper<ZhenliaoxinxiEntity> ew = new EntityWrapper<ZhenliaoxinxiEntity>();
    String tableName = request.getSession().getAttribute("tableName").toString();
                                                                                                                        if(tableName.equals("yisheng")) {
                ew.eq("yishengzhanghao", (String)request.getSession().getAttribute("username"));
            }
                                            if(tableName.equals("huanzhe")) {
                ew.eq("huanzhezhanghao", (String)request.getSession().getAttribute("username"));
            }
                                                                                List<Map<String, Object>> result = zhenliaoxinxiService.selectTimeStatValue(params, ew);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            return R.ok().put("data", result);
        }
    }
    
        /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) throws IOException
    {
        java.nio.file.Path path = java.nio.file.Paths.get("value_zhenliaoxinxi_" + xColumnName + "_" + yColumnNameMul + "_" + timeStatType + ".json");
        if (java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
            String[] yColumnNames = yColumnNameMul.split(",");
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("xColumn", xColumnName);
            params.put("timeStatType", timeStatType);
            List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            EntityWrapper<ZhenliaoxinxiEntity> ew = new EntityWrapper<ZhenliaoxinxiEntity>();
    String tableName = request.getSession().getAttribute("tableName").toString();
                                                                                                                        if(tableName.equals("yisheng")) {
                ew.eq("yishengzhanghao", (String)request.getSession().getAttribute("username"));
            }
                                            if(tableName.equals("huanzhe")) {
                ew.eq("huanzhezhanghao", (String)request.getSession().getAttribute("username"));
            }
                                                                        for(int i=0;i<yColumnNames.length;i++) {
                params.put("yColumn", yColumnNames[i]);
                List<Map<String, Object>> result = zhenliaoxinxiService.selectTimeStatValue(params, ew);
                for(Map<String, Object> m : result) {
                    for(String k : m.keySet()) {
                        if(m.get(k) instanceof Date) {
                            m.put(k, sdf.format((Date)m.get(k)));
                        }
                    }
                }
                result2.add(result);
            }
            return R.ok().put("data", result2);
        }
    }
    
        /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("group_zhenliaoxinxi_" + columnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)){
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<ZhenliaoxinxiEntity> ew = new EntityWrapper<ZhenliaoxinxiEntity>();
String tableName = request.getSession().getAttribute("tableName").toString();
                                            if(tableName.equals("yisheng")) {
            ew.eq("yishengzhanghao", (String)request.getSession().getAttribute("username"));
        }
                    if(tableName.equals("huanzhe")) {
            ew.eq("huanzhezhanghao", (String)request.getSession().getAttribute("username"));
        }
                                List<Map<String, Object>> result = zhenliaoxinxiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
        }
    }    
    
    




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,ZhenliaoxinxiEntity zhenliaoxinxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yisheng")) {
            zhenliaoxinxi.setYishengzhanghao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("huanzhe")) {
            zhenliaoxinxi.setHuanzhezhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<ZhenliaoxinxiEntity> ew = new EntityWrapper<ZhenliaoxinxiEntity>();
        int count = zhenliaoxinxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhenliaoxinxi), params), params));
        return R.ok().put("data", count);
    }




}
