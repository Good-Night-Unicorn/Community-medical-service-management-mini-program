import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import news from '@/views/modules/news/list'
	import huanzhe from '@/views/modules/huanzhe/list'
	import guahaoxinxi from '@/views/modules/guahaoxinxi/list'
	import jiankangdangan from '@/views/modules/jiankangdangan/list'
	import storeup from '@/views/modules/storeup/list'
	import keshixinxi from '@/views/modules/keshixinxi/list'
	import quxiaoguahao from '@/views/modules/quxiaoguahao/list'
	import chat from '@/views/modules/chat/list'
	import binglixinxi from '@/views/modules/binglixinxi/list'
	import zuozhenshijian from '@/views/modules/zuozhenshijian/list'
	import keshifenlei from '@/views/modules/keshifenlei/list'
	import yisheng from '@/views/modules/yisheng/list'
	import config from '@/views/modules/config/list'
	import zhenliaoxinxi from '@/views/modules/zhenliaoxinxi/list'
	import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/news',
		name: '公告信息',
		component: news
	}
	,{
		path: '/huanzhe',
		name: '患者',
		component: huanzhe
	}
	,{
		path: '/guahaoxinxi',
		name: '挂号信息',
		component: guahaoxinxi
	}
	,{
		path: '/jiankangdangan',
		name: '健康档案',
		component: jiankangdangan
	}
	,{
		path: '/storeup',
		name: '我的收藏',
		component: storeup
	}
	,{
		path: '/keshixinxi',
		name: '科室信息',
		component: keshixinxi
	}
	,{
		path: '/quxiaoguahao',
		name: '取消挂号',
		component: quxiaoguahao
	}
	,{
		path: '/chat',
		name: '智能客服',
		component: chat
	}
	,{
		path: '/binglixinxi',
		name: '病历信息',
		component: binglixinxi
	}
	,{
		path: '/zuozhenshijian',
		name: '坐诊时间',
		component: zuozhenshijian
	}
	,{
		path: '/keshifenlei',
		name: '科室分类',
		component: keshifenlei
	}
	,{
		path: '/yisheng',
		name: '医生',
		component: yisheng
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/zhenliaoxinxi',
		name: '诊疗信息',
		component: zhenliaoxinxi
	}
	,{
		path: '/newstype',
		name: '公告信息分类',
		component: newstype
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
